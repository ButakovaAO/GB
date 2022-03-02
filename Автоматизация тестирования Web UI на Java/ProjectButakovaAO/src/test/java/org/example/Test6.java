package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class Test6 extends AbstractTest{

    @Test
    void loginIn(){
        new LoginPage(getWebDriver()).PersonalArea();
        new LoginPage(getWebDriver()).setLogin("te_st@test.ru").setPassword("testtest");
        new LoginPage(getWebDriver()).LoginButton();
        new LoginPage(getWebDriver()).PersonalAreaIn();

        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//header/div/div/div[@class='header__bar-inner']/ul/li[@class='header__top-controls-item header__top-controls-item--auth']/div/div/div/h4")).getText().equals("te_st@test.ru"));
    }
}
