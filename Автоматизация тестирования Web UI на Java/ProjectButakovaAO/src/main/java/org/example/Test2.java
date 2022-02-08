package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test2
{
    public static void main( String[] args )
    {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments ("start-maximized"); //открытие полноэкранного формата
        options.addArguments ("--incognito"); //открытие страницы в режиме инкогнито
        options.addArguments ("disable-popup-blocking"); //блокировка всплывающих окон

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.chay.info/");

        WebElement webElement = driver.findElement(By.xpath(".//div[@id='header__bar']/div/div[@class='header__bottom']/ul/li[@class='header__bottom-categories-item']/a[@data-id='cat-kofe']"));
        webElement.click();

        driver.findElement(By.xpath(".//h3/a[@href='/catalog/kofe/vishnya_na_konyake.html']")).click();
        driver.findElement(By.xpath(".//button[@id='product_btn_buy']/div/div[@class='icon-plus__block']/p")).click();
        driver.findElement(By.xpath(".//form[@id='product_price_block']/div[@class='catalog-card__price-btns']/a")).click();
        driver.findElement(By.xpath(".//li[@class='cart__item ']/button[@class='cart__item-del js-del-cart-item']")).click();
        //driver.quit();

    }
}
