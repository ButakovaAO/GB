package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
    }

    @Test
    void mytest(){
        open("https://www.chay.info/");
        $(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']")).click();
        $(By.xpath(".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")).click();
        $(By.xpath(".//button[@id='product_btn_buy']/div/div[@class='icon-plus__block']/p")).click();
        $(By.xpath(".//form[@id='product_price_block']/div[@class='catalog-card__price-btns']/a")).click();
        $(By.xpath(".//li[@class='cart__item ']/button[@class='cart__item-del js-del-cart-item']")).click();
        $(By.xpath(".//main[@class='content']/div/h1")).shouldHave(text("Корзина пуста"));

    }

}
