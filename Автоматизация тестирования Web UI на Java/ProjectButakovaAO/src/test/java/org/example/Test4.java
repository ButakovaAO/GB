package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test4 extends AbstractTest{

    @Test
    void test() throws InterruptedException {
        WebElement webElement = getDriver().findElement(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']"));
        webElement.click();
        getDriver().findElement(By.xpath(".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")).click();
        getDriver().findElement(By.xpath(".//div[@id='product_sku_list']/div/label[@title='упаковка 0,5 кг']")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//div[@class='page__catalog-element catalog']/div/div[@class='catalog-card-page__head']/h1")).getText().equals("Вишня на коньяке, упаковка кофе 0,5 кг"));
    }
}
