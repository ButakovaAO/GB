package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Test1 extends AbstractTest {

    @Test
    void test1() {
        new AddToCart(getWebDriver()).elEl1();
        new AddToCart(getWebDriver()).elEl2();
        new AddToCart(getWebDriver()).elEl3();
        new AddToCart(getWebDriver()).elEl4();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//article[@class='cart-item']/div[@class='cart-item__header']/a")).getText().equals("Вишня на коньяке"));
    }
}

