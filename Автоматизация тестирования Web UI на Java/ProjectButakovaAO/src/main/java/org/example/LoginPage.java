package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = ".//header[@class='header']/div/div[@class='container']/div[@class='header__bar-inner']/ul[@class='header__top-controls']/li[@class='header__top-controls-item header__top-controls-item--auth']/a")
    private WebElement personalArea;

    @FindBy(xpath = ".//div[@class='header__sign-in sign-container js-popup is-visible']/form/div[@class='form__item']/span[@class='input input--view--form']/input[@type='email']")
    private WebElement login;

    @FindBy(xpath = ".//div[@class='header__sign-in sign-container js-popup is-visible']/form/div[@class='form__item']/span[@class='input input--view--form']/input[@type='password']")
    private WebElement password;

    @FindBy(xpath = ".//div[@class='header__sign-in sign-container js-popup is-visible']/form/div[@class='form__buttons']/button")
    private WebElement loginButton;

    @FindBy(xpath = ".//header[@class='header']/div/div[@class='container']/div[@class='header__bar-inner']/ul[@class='header__top-controls']/li[@class='header__top-controls-item header__top-controls-item--auth']/a[@class='icon header__top-control js-popup-btn']")
    private WebElement personalAreaIn;

    public LoginPage(WebDriver driver){

        super(driver);
    }

    public void PersonalArea(){
        this.personalArea.click();
    }

    public LoginPage setLogin(String login){
        this.login.click();
        this.login.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }

    public void LoginButton(){
        this.loginButton.click();
    }

    public void PersonalAreaIn(){
        this.personalAreaIn.click();
    }

}