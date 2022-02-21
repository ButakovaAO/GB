package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test3 extends AbstractTest{

    @Test
    void test() throws InterruptedException {
        WebElement webElement = getDriver().findElement(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']"));
        webElement.click();
        getDriver().findElement(By.xpath(".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")).click();
        getDriver().findElement(By.xpath(".//div[@class='catalog-card__price-btns']/button[@id='product_favorites']")).click();
        Assertions.assertTrue(getDriver().getCurrentUrl().equals("https://www.chay.info/catalog/kofe/vishnya_na_konyake.html"));
    }
}
