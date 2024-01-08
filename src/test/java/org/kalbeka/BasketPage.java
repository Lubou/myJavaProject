package org.kalbeka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage {

    private static final String BASKET_ITEM_1_XPATH_LOCATOR = "(//a[@class='img-plug list-item__good-img j-product-popup'])[2]";
    private static final String BASKET_ITEM_2_XPATH_LOCATOR = "(//a[@class='img-plug list-item__good-img j-product-popup'])[1]";
    private static final String BASKET_ITEM_1_NAME_XPATH_LOCATOR = "(//span[@class='good-info__good-name'])[2]";
    private static final String BASKET_ITEM_2_NAME_XPATH_LOCATOR = "(//span[@class='good-info__good-name'])[1]";
    private static final String BASKET_ITEMS_COUNT_XPATH_LOCATOR = "//h1[@class='basket-section__header active']";
    private static final String BASKET_ITEM_1_PRICE_XPATH_LOCATOR = "(//div[@class='list-item__price-new'])[2]";
    private static final String BASKET_ITEM_2_PRICE_XPATH_LOCATOR = "(//div[@class='list-item__price-new'])[1]";


    @FindBy(xpath = BASKET_ITEM_1_NAME_XPATH_LOCATOR)
    public static WebElement basketItem1Name;
    @FindBy(xpath = BASKET_ITEM_2_NAME_XPATH_LOCATOR)
    public static WebElement basketItem2Name;
    @FindBy(xpath = BASKET_ITEM_1_XPATH_LOCATOR)
    public static WebElement basketItem1;
    @FindBy(xpath = BASKET_ITEM_2_XPATH_LOCATOR)
    public static WebElement basketItem2;
    @FindBy(xpath = BASKET_ITEMS_COUNT_XPATH_LOCATOR)
    public static WebElement basketItemsCount;
    @FindBy(xpath = BASKET_ITEM_1_PRICE_XPATH_LOCATOR)
    public static WebElement basketItem1Price;
    @FindBy(xpath = BASKET_ITEM_2_PRICE_XPATH_LOCATOR)
    public static WebElement basketItem2Price;


    public static String basketItem1NameText = basketItem1Name.getText();
    public static String basketItem2NameText = basketItem2Name.getText();
    public static String basketItemsCountText = basketItemsCount.getAttribute("data-count");
    public static String basketItem1PriceText = basketItem1Price.getText();
    public static String basketItem2PriceText = basketItem2Price.getText();


    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
