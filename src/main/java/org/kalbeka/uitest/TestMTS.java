package org.kalbeka.uitest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.*;

/* Необходимо написать автотесты для сайта mts.by. Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
1.Проверить название указанного блока;
2.Проверить наличие логотипов платёжных систем;
3.Проверить работу ссылки «Подробнее о сервисе»;
4.Заполнить поля и проверить работу кнопки «Продолжить»(проверяем только вариант «Услуги связи», номер для теста 297777777)*/
public class TestMTS extends TestBase {

    @Test
    public void testOnlinePay() {

        driver.get("https://mts.by");

        //0 принять cookies
        WebElement cookiesSkip = driver.findElement(By.xpath("//button[@id=\"cookie-agree\"]"));
        cookiesSkip.click();

        //1
        WebElement blockHeader = driver.findElement(By.xpath("//section/div/h2"));
        assertEquals("Онлайн пополнение" + '\n' + "без комиссии", blockHeader.getText(), "проверка заголовка блока «Онлайн пополнение без комиссии»");

        //2
        WebElement payLogos = driver.findElement(By.className("pay__partners"));
        assertTrue(payLogos.isDisplayed(), "проверка наличия логотипов платёжных систем");

        //3
        WebElement infoLink = driver.findElement(By.xpath("//a[contains( text(),'Подробнее о сервисе')]"));
        infoLink.click();
        assertEquals("Порядок оплаты и безопасность интернет платежей", driver.getTitle(), "проверка заголовка страницы по ссылке Подробнее о сервисе");

        driver.navigate().back();

        //4
        WebElement numberInput = driver.findElement(By.xpath("//form/div/input[@placeholder= \"Номер телефона\"]"));
        numberInput.click();
        numberInput.sendKeys("297777777");

        WebElement paymentInput = driver.findElement(By.xpath("//form/div/input[@placeholder= \"Сумма\"]"));
        paymentInput.click();
        paymentInput.sendKeys("10");

        WebElement eMailInput = driver.findElement(By.xpath("//form/div/input[@placeholder= \"E-mail для отправки чека\"]"));
        eMailInput.click();
        eMailInput.sendKeys("abrakadabra@gmail.com");

        WebElement continueButton = driver.findElement(By.xpath("//form[@class= \"pay-form opened\"]/button[@class= \"button button__default \"]"));
        continueButton.click();

        
    }
}
