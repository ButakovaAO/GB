package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test1 extends AbstractTest{

    @Test
    void test() throws InterruptedException {
        WebElement webElement = getDriver().findElement(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']"));
        webElement.click();
        getDriver().findElement(By.xpath(".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")).click();
        getDriver().findElement(By.xpath(".//button[@id='product_btn_buy']/div/div[@class='icon-plus__block']/p")).click();
        getDriver().findElement(By.xpath(".//form[@id='product_price_block']/div[@class='catalog-card__price-btns']/a")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//article[@class='cart-item']/div[@class='cart-item__header']/a")).getText().equals("Вишня на коньяке"));
    }
}
