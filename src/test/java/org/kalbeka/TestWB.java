package org.kalbeka;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


/* Написать автотесты для сайта wildberries.ru, в ходе которых на главной странице несколько товаров кладется в корзину,
затем осуществляется переход в корзину и происходят проверки на соответствие названия товаров, их количество,
цен каждого товара в корзине и общей суммы товаров.
При написании автотестов необходимо использовать подходящие паттерны, изученные в данной теме.*/

public class TestWB extends TestBase {

    @Test
    public void addToBasketAndCheck() {
        MainPage mainPage = new MainPage(driver);
        String itemToBuy1Name = mainPage.getItemToBuy1NameText();
        String itemToBuy2Name = mainPage.getItemToBuy2NameText();
        String itemToBuy1Price = mainPage.getItemToBuy1PriceText();
        String itemToBuy2Price = mainPage.getItemToBuy2PriceText();

        mainPage
                .goToBasket();

        BasketPage basketPage = new BasketPage(driver);
        String BasketItem1Name = basketPage.getBasketItem1NameText();
        String BasketItem2Name = basketPage.getBasketItem2NameText();
        String basketItemsCount = basketPage.getBasketItemsCountText();
        String basketItem1Price = basketPage.getBasketItem1PriceText();
        String basketItem2Price = basketPage.getBasketItem2PriceText();

        assertAll(
                () -> assertEquals("/ " + BasketItem1Name, itemToBuy1Name),
                () -> assertEquals("/ " + BasketItem2Name, itemToBuy2Name),
                () -> assertEquals("2", basketItemsCount),
                () -> assertEquals(itemToBuy1Price, basketItem1Price),
                () -> assertEquals(itemToBuy2Price, basketItem2Price)

        );

    }

}