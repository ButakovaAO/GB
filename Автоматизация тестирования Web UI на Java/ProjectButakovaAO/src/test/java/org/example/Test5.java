package org.example;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test5 extends AbstractTest{

    @Test
    @DisplayName("Страница Чай")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void clickToChay(){
        new ChayInfoMainPage(getWebDriver()).navigateToChay();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/chay/"));
    }

    @Test
    @DisplayName("Страница Кофе")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void clickToKofe(){
        new ChayInfoMainPage(getWebDriver()).navigateToKofe();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/kofe/"));
    }

    @Test
    @DisplayName("Страница Подарки")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void clickToPodarki(){
        new ChayInfoMainPage(getWebDriver()).navigateToPodarki();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/podarki/"));
    }
}
