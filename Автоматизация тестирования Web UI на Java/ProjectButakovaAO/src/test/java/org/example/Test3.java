package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test3 extends AbstractTest{

    @Test
    void test() throws InterruptedException {
        new ChoiceElement(getWebDriver()).elEl1();
        new ChoiceElement(getWebDriver()).elEl2();
        new ChoiceElement(getWebDriver()).elEl3();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/kofe/vishnya_na_konyake.html"));
    }
}
