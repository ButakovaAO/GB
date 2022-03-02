package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Test2 extends AbstractTest{

    @Test
    void test2() {
        new DeleteFromCart(getWebDriver()).elEl1();
        new DeleteFromCart(getWebDriver()).elEl2();
        new DeleteFromCart(getWebDriver()).elEl3();
        new DeleteFromCart(getWebDriver()).elEl4();
        new DeleteFromCart(getWebDriver()).elEl5();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//main[@class='content']/div/h1")).getText().equals("Корзина пуста"));
    }
}
