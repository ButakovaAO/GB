package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class Test6 extends AbstractTest{

    @Test
    void myActiontest(){
        getDriver().findElement(By.xpath(".//header[@class='header']/div/div[@class='container']/div[@class='header__bar-inner']/ul[@class='header__top-controls']/li[@class='header__top-controls-item header__top-controls-item--auth']/a")).click();

        Actions loginIn = new Actions(getDriver());

        loginIn.sendKeys(getDriver().findElement(By.xpath(".//div[@class='header__sign-in sign-container js-popup is-visible']/form/div[@class='form__item']/span[@class='input input--view--form']/input[@type='email']")),"te_st@test.ru")
                .click(getDriver().findElement(By.xpath(".//div[@class='header__sign-in sign-container js-popup is-visible']/form/div[@class='form__item']/span[@class='input input--view--form']/input[@type='password']")))
                .sendKeys("testtest")
                .click(getDriver().findElement(By.xpath(".//div[@class='header__sign-in sign-container js-popup is-visible']/form/div[@class='form__buttons']/button")))
                .build()
                .perform();

        getDriver().findElement(By.xpath(".//header[@class='header']/div/div[@class='container']/div[@class='header__bar-inner']/ul[@class='header__top-controls']/li[@class='header__top-controls-item header__top-controls-item--auth']/a[@class='icon header__top-control js-popup-btn']")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath(".//header/div/div/div[@class='header__bar-inner']/ul/li[@class='header__top-controls-item header__top-controls-item--auth']/div/div/div/h4")).getText().equals("te_st@test.ru"));
    }
}
