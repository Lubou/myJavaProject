package org.kalbeka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
    public WebDriver driver;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//a[@class='img-plug list-item__good-img j-product-popup'])[2]")
    private WebElement basketItem1;

    @FindBy(xpath = "(//a[@class='img-plug list-item__good-img j-product-popup'])[1]")
    private WebElement basketItem2;

    @FindBy(xpath = "(//span[@class='good-info__good-name'])[2]")
    private WebElement basketItem1Name;

    @FindBy(xpath = "(//span[@class='good-info__good-name'])[1]")
    private WebElement basketItem2Name;

}
