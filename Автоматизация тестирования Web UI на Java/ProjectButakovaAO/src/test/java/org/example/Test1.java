package org.example;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Test1 extends AbstractTest {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void test1() {
        new AddToCart(getWebDriver()).elEl1();
        new AddToCart(getWebDriver()).elEl2();
        new AddToCart(getWebDriver()).elEl3();
        new AddToCart(getWebDriver()).elEl4();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//article[@class='cart-item']/div[@class='cart-item__header']/a")).getText().equals("Вишня на коньяке"));
    }
}

