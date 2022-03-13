package org.example;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test3 extends AbstractTest{

    @Test
    @DisplayName("Выбор товара")
    @Issue("https://docs.google.com/spreadsheets/d/1V2UKDUlw3F22LM8U7tWfY9tvBaUqLMsNy1F0YIWkwOA/edit?usp=sharing")
    @Severity(SeverityLevel.NORMAL)
    void test() throws InterruptedException {
        new ChoiceElement(getWebDriver()).elEl1();
        new ChoiceElement(getWebDriver()).elEl2();
        new ChoiceElement(getWebDriver()).elEl3();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/kofe/vishnya_na_konyake.html"));
    }
}
