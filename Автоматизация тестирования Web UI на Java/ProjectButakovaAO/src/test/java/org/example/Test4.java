package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test4 extends AbstractTest{

    @Test
    void test() throws InterruptedException {
        new ChangeTypeBox(getWebDriver()).elEl1();
        new ChangeTypeBox(getWebDriver()).elEl2();
        new ChangeTypeBox(getWebDriver()).elEl3();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//div[@class='page__catalog-element catalog']/div/div[@class='catalog-card-page__head']/h1")).getText().equals("Вишня на коньяке, упаковка кофе 0,5 кг"));
    }
}
