package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChayInfoMainPage extends AbstractPage {

    @FindBy(xpath = ".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-chay']")
    private WebElement chay;

    @FindBy(xpath = ".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']")
    private WebElement kofe;

    @FindBy(xpath = ".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-podarki']")
    private WebElement podarki;

    public ChayInfoMainPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToChay() {
        this.chay.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("chay"));
    }

    public void navigateToKofe() {
        this.kofe.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("kofe"));
    }

    public void navigateToPodarki() {
        this.podarki.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains("podarki"));
    }

}