package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test5 extends AbstractTest{

    @Test
    void test() throws InterruptedException {
        WebElement webElement = getDriver().findElement(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-chay']"));
        webElement.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().equals("https://www.chay.info/catalog/chay/"));
    }

    @Test
    void test2() throws InterruptedException {
        WebElement webElement = getDriver().findElement(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']"));
        webElement.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().equals("https://www.chay.info/catalog/kofe/"));
    }

    @Test
    void test3() throws InterruptedException {
        WebElement webElement = getDriver().findElement(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-podarki']"));
        webElement.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().equals("https://www.chay.info/catalog/podarki/"));
    }
}
