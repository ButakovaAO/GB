package org.example;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Test2 extends AbstractTest{

    @Test
    @DisplayName("Удаление товара из корзины")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void test2() {
        new DeleteFromCart(getWebDriver()).elEl1();
        new DeleteFromCart(getWebDriver()).elEl2();
        new DeleteFromCart(getWebDriver()).elEl3();
        new DeleteFromCart(getWebDriver()).elEl4();
        new DeleteFromCart(getWebDriver()).elEl5();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//main[@class='content']/div/h1")).getText().equals("Корзина пуста"));
    }
}
