package org.kalbeka;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    private static final String URL = "https://www.wildberries.ru/";

    private static final String ITEM_TO_BUY_1_XPATH_LOCATOR = "(//a[@class='product-card__link j-card-link j-open-full-product-card'])[1]";
    private static final String ITEM_TO_BUY_2_XPATH_LOCATOR = "(//a[@class='product-card__link j-card-link j-open-full-product-card'])[2]";
    private static final String ITEM_TO_BUY_1_NAME_XPATH_LOCATOR = "(//span[@class='product-card__name'])[1]";
    private static final String ITEM_TO_BUY_2_NAME_XPATH_LOCATOR = "(//span[@class='product-card__name'])[2]";
    private static final String ITEM_TO_BUY_1_PRICE_XPATH_LOCATOR = "(//*/*[@class='price__lower-price'])[1]";
    private static final String ITEM_TO_BUY_2_PRICE_XPATH_LOCATOR = "(//*/*[@class='price__lower-price'])[2]";
    private static final String BSKT_ADD_BUTTON_1_XPATH_LOCATOR = "(//a[@class='product-card__add-basket j-add-to-basket btn-main-sm'])[1]";
    private static final String BSKT_ADD_BUTTON_2_XPATH_LOCATOR = "(//a[@class='product-card__add-basket j-add-to-basket btn-main-sm'])[2]";
    private static final String BASKET_BUTTON_XPATH_LOCATOR = "//a[@data-wba-header-name='Cart']";


    @FindBy(xpath = ITEM_TO_BUY_1_NAME_XPATH_LOCATOR)
    private WebElement itemToBuy1Name;
    @FindBy(xpath = ITEM_TO_BUY_2_NAME_XPATH_LOCATOR)
    private WebElement itemToBuy2Name;
    @FindBy(xpath = ITEM_TO_BUY_1_PRICE_XPATH_LOCATOR)
    private WebElement itemToBuy1Price;
    @FindBy(xpath = ITEM_TO_BUY_2_PRICE_XPATH_LOCATOR)
    private WebElement itemToBuy2Price;

    public String getItemToBuy1NameText() {
        return itemToBuy1Name.getText();
    }

    public String getItemToBuy2NameText() {
        return itemToBuy2Name.getText();
    }

    public String getItemToBuy1PriceText() {
        waitElementVisibility(By.xpath(ITEM_TO_BUY_1_PRICE_XPATH_LOCATOR));
        return itemToBuy1Price.getText();
    }

    public String getItemToBuy2PriceText() {
        waitElementVisibility(By.xpath(ITEM_TO_BUY_2_PRICE_XPATH_LOCATOR));
        return itemToBuy2Price.getText();
    }

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public void addToBasket() {
        Actions action = new Actions(driver);
        action.moveToElement(waitElementVisibility(By.xpath(ITEM_TO_BUY_1_XPATH_LOCATOR)));
        action.perform();

        waitElementVisibility(By
                .xpath(BSKT_ADD_BUTTON_1_XPATH_LOCATOR)).click();

        try {
            action.moveToElement(driver.findElement(By.xpath(ITEM_TO_BUY_2_XPATH_LOCATOR)));
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath("(//label[@class='j-quick-order-size-fake sizes-list__button'])[1]")).click();
        }
        action.perform();

        waitElementVisibility(By.xpath(BSKT_ADD_BUTTON_2_XPATH_LOCATOR)).click();

    }

    public BasketPage goToBasket() {
        addToBasket();
        try {
            waitElementVisibility(By.xpath(BASKET_BUTTON_XPATH_LOCATOR)).click();
        } catch (NoSuchElementException e) {
            driver.findElement(By.xpath("(//label[@class='j-quick-order-size-fake sizes-list__button'])[1]")).click();
        }
        return new BasketPage(driver);
    }

    private WebElement waitElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
