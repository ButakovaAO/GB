package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends AbstractPage {

    @FindBy(xpath = ".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']")
    private WebElement el1;

    @FindBy(xpath = ".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")
    private WebElement el2;

    @FindBy(xpath = ".//button[@id='product_btn_buy']/div/div[@class='icon-plus__block']/p")
    private WebElement el3;

    @FindBy(xpath = ".//form[@id='product_price_block']/div[@class='catalog-card__price-btns']/a")
    private WebElement el4;

    public AddToCart(WebDriver driver) {
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

}
