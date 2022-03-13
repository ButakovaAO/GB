package org.example;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test4 extends AbstractTest{

    @Test
    @DisplayName("Изменение меры объема")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void test() throws InterruptedException {
        new ChangeTypeBox(getWebDriver()).elEl1();
        new ChangeTypeBox(getWebDriver()).elEl2();
        new ChangeTypeBox(getWebDriver()).elEl3();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//div[@class='page__catalog-element catalog']/div/div[@class='catalog-card-page__head']/h1")).getText().equals("Вишня на коньяке, упаковка кофе 0,5 кг"));
    }
}
