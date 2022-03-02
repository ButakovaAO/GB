package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteFromCart extends AbstractPage {

    @FindBy(xpath = ".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']")
    private WebElement el1;

    @FindBy(xpath = ".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")
    private WebElement el2;

    @FindBy(xpath = ".//button[@id='product_btn_buy']/div/div[@class='icon-plus__block']/p")
    private WebElement el3;

    @FindBy(xpath = ".//form[@id='product_price_block']/div[@class='catalog-card__price-btns']/a")
    private WebElement el4;

    @FindBy(xpath = ".//li[@class='cart__item ']/button[@class='cart__item-del js-del-cart-item']")
    private WebElement el5;

    public DeleteFromCart(WebDriver driver) {
        super(driver);
    }

    public void elEl1() {
        this.el1.click();
    }

    public void elEl2() {
        this.el2.click();
    }

    public void elEl3() {
        this.el3.click();
    }

    public void elEl4() {
        this.el4.click();
    }

    public void elEl5() {
        this.el5.click();
        new WebDriverWait(getDriver(), 10000).until(ExpectedConditions.urlContains("cart"));
    }

}
