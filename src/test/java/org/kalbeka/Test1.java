package org.kalbeka;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/* Написать автотесты для сайта wildberries.ru, в ходе которых на главной странице несколько товаров кладется в корзину,
затем осуществляется переход в корзину и происходят проверки на соответствие названия товаров, их количество,
цен каждого товара в корзине и общей суммы товаров.
При написании автотестов необходимо использовать подходящие паттерны, изученные в данной теме.*/
public class Test1 extends TestBase {

    private WebElement waitElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Test
    public void testAddToCart() {

        // List<WebElement> itemsList = driver.findElements(By.xpath("(//a[@class='product-card__link j-card-link j-open-full-product-card'])"));

        WebElement itemToBuy1 = waitElementVisibility(By.xpath("(//a[@class='product-card__link j-card-link j-open-full-product-card'])[1]"));
        WebElement itemToBuy2 = waitElementVisibility(By.xpath("(//div[@class='product-card__wrapper'])[2]"));

        WebElement itemToBuy1Name = waitElementVisibility(By.xpath("(//span[@class='product-card__name'])[1]"));
        String itemToBuy1NameText = itemToBuy1Name.getText();

        Actions action = new Actions(driver);
        action.moveToElement(itemToBuy1);
        action.perform();

        WebElement bsktAddButton1 = waitElementVisibility(By.xpath("(//a[@class='product-card__add-basket j-add-to-basket btn-main-sm'])[1]"));
        bsktAddButton1.click();

        /*try {
            WebElement checkSizeButton = driver.findElement(By.xpath("(//label[@class='j-quick-order-size-fake sizes-list__button'])[1]"));
            checkSizeButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("без размера");
        }*/

        action.moveToElement(itemToBuy2);
        action.perform();

        WebElement bsktAddButton2 = waitElementVisibility(By.xpath("(//a[@class='product-card__add-basket j-add-to-basket btn-main-sm'])[2]"));
        bsktAddButton2.click();

        WebElement basketButton = waitElementVisibility(By.xpath("//a[@data-wba-header-name='Cart']"));
        basketButton.click();

        //assertEquals("https://www.wildberries.ru/lk/basket", driver.getCurrentUrl());


        WebElement basketItem1 = waitElementVisibility(By.xpath("(//a[@class='img-plug list-item__good-img j-product-popup'])[2]"));
        //assertTrue(basketItem1.isDisplayed());

        WebElement basketItem1Name = waitElementVisibility(By.xpath("(//span[@class='good-info__good-name'])[2]"));

        //assertEquals("/ " + basketItem1Name.getText(), itemToBuy1NameS);

        assertAll(
                () -> assertEquals("https://www.wildberries.ru/lk/basket", driver.getCurrentUrl()),
                () -> assertTrue(basketItem1.isDisplayed()),
                () -> assertEquals("/ " + basketItem1Name.getText(), itemToBuy1NameText)
        );

    }
}
