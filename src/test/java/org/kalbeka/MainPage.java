package org.kalbeka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public static WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@class='product-card__link j-card-link j-open-full-product-card'])[1]")
    private WebElement itemToBuy1;

    @FindBy(xpath = "(//a[@class='product-card__link j-card-link j-open-full-product-card'])[2]")
    private WebElement itemToBuy2;

    @FindBy(xpath = "(//span[@class='product-card__name'])[1]")
    private WebElement itemToBuy1Name;

    @FindBy(xpath = "(//span[@class='product-card__name'])[2]")
    private WebElement itemToBuy2Name;

    @FindBy(xpath = "(//a[@class='product-card__add-basket j-add-to-basket btn-main-sm'])[1]")
    private WebElement bsktAddButton1;

    @FindBy(xpath = "(//a[@class='product-card__add-basket j-add-to-basket btn-main-sm'])[2]")
    private WebElement bsktAddButton2;

    @FindBy(xpath = "(//label[@class='j-quick-order-size-fake sizes-list__button'])[1]")
    private WebElement checkSizeButton;

    @FindBy(xpath = "//a[@data-wba-header-name='Cart']")
    private WebElement basketButton;

    public void addToBasket() {
        Actions action = new Actions(driver);
        action.moveToElement(itemToBuy1);
        action.perform();
        bsktAddButton1.click();
        checkSizeButton.click();
        action.moveToElement(itemToBuy2);
        action.perform();
        bsktAddButton2.click();
        checkSizeButton.click();
    }
    public void getItemName() {
        String itemToBuy1NameText = itemToBuy1Name.getText();
        String itemToBuy2NameText = itemToBuy2Name.getText();
    }

    public void goToBasket() {
        basketButton.click();
    }

    private static WebElement waitElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
