package org.example;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class Test6 extends AbstractTest{

    @Test
    @DisplayName("Авторизация")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.CRITICAL)
    void loginIn(){
        new LoginPage(getWebDriver()).PersonalArea();
        new LoginPage(getWebDriver()).setLogin("te_st@test.ru").setPassword("testtest");
        new LoginPage(getWebDriver()).LoginButton();
        new LoginPage(getWebDriver()).PersonalAreaIn();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//header/div/div/div[@class='header__bar-inner']/ul/li[@class='header__top-controls-item header__top-controls-item--auth']/div/div/div/h4")).getText().equals("te_st@test.ru"));
    }
}
