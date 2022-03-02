package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test5 extends AbstractTest{

    @Test
    void clickToChay(){
        new ChayInfoMainPage(getWebDriver()).navigateToChay();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/chay/"));
    }

    @Test
    void clickToKofe(){
        new ChayInfoMainPage(getWebDriver()).navigateToKofe();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/kofe/"));
    }

    @Test
    void clickToPodarki(){
        new ChayInfoMainPage(getWebDriver()).navigateToPodarki();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().equals("https://www.chay.info/catalog/podarki/"));
    }
}
