package org.kalbeka;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* Написать автотесты для сайта wildberries.ru, в ходе которых на главной странице несколько товаров кладется в корзину,
затем осуществляется переход в корзину и происходят проверки на соответствие названия товаров, их количество,
цен каждого товара в корзине и общей суммы товаров.
При написании автотестов необходимо использовать подходящие паттерны, изученные в данной теме.*/

public class TestWB extends TestBase {

    @Test
    public void addToBasketAndCheck() {
        mainPage.addToBasket();
        mainPage.goToBasket();
        assertEquals("https://www.wildberries.ru/lk/basket", driver.getCurrentUrl());

    }

}