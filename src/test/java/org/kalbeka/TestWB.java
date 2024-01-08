package org.kalbeka;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
;

/* Написать автотесты для сайта wildberries.ru, в ходе которых на главной странице несколько товаров кладется в корзину,
затем осуществляется переход в корзину и происходят проверки на соответствие названия товаров, их количество,
цен каждого товара в корзине и общей суммы товаров.
При написании автотестов необходимо использовать подходящие паттерны, изученные в данной теме.*/

public class TestWB extends TestBase {

    @Test
    public void addToBasketAndCheck() {
        new MainPage(driver).addToBasket();
        new MainPage(driver).goToBasket();


        assertAll(
                () -> assertEquals("https://www.wildberries.ru/lk/basket", driver.getCurrentUrl()),
                () -> assertTrue(BasketPage.basketItem1.isDisplayed()),
                () -> assertTrue(BasketPage.basketItem2.isDisplayed()),
                () -> assertEquals("/ " + BasketPage.basketItem1NameText, MainPage.itemToBuy1NameText),
                () -> assertEquals("/ " + BasketPage.basketItem2NameText, MainPage.itemToBuy2NameText),
                () -> assertEquals("2", BasketPage.basketItemsCountText),
                () -> assertEquals(MainPage.itemToBuy1PriceText, BasketPage.basketItem1PriceText),
                () -> assertEquals(MainPage.itemToBuy2PriceText, BasketPage.basketItem2PriceText)
        );

    }

}