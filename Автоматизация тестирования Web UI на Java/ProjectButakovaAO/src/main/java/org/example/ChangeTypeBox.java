package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeTypeBox extends AbstractPage {

    @FindBy(xpath = ".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']")
    private WebElement el1;

    @FindBy(xpath = ".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")
    private WebElement el2;

    @FindBy(xpath = ".//div[@id='product_sku_list']/div/label[@title='упаковка 0,5 кг']")
    private WebElement el3;

    public ChangeTypeBox(WebDriver driver) {
        super(driver);
    }

    public void elEl1() {
        this.el1.click();
    }

    public void elEl2() { this.el2.click(); }

    public void elEl3() { this.el3.click(); }

}
