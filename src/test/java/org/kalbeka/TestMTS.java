package org.kalbeka;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

/* Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
 нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
 номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты,
 наличие иконок платёжных систем.*/

public class TestMTS extends TestBase {
    @Test
    public void testCommunicationServices() {

        WebElement numberInput = driver.findElement(By.id("connection-phone"));
        assertEquals("Номер телефона", numberInput.getAttribute("placeholder"), "проверка надписи в поле ввода номера телефона в разделе услуги связи");

        WebElement paymentInput = driver.findElement(By.id("connection-sum"));
        assertEquals("Сумма", paymentInput.getAttribute("placeholder"), "проверка надписи в поле ввода суммы в разделе услуги связи");

        WebElement eMailInput = driver.findElement(By.id("connection-email"));
        assertEquals("E-mail для отправки чека", eMailInput.getAttribute("placeholder"), "проверка надписи в поле ввода email в разделе услуги связи");
    }

    @Test
    public void testHomeInternet() {

        WebElement phoneInput2 = driver.findElement(By.id("internet-phone"));
        assertEquals("Номер абонента", phoneInput2.getAttribute("placeholder"), "проверка надписи в поле ввода номера телефона в разделе домашний интернет");

        WebElement sumInput2 = driver.findElement(By.id("internet-sum"));
        assertEquals("Сумма", sumInput2.getAttribute("placeholder"), "проверка надписи в поле ввода суммы в разделе домашний интернет");

        WebElement emailInput2 = driver.findElement(By.id("internet-email"));
        assertEquals("E-mail для отправки чека", emailInput2.getAttribute("placeholder"), "проверка надписи в поле ввода email в разделе домашний интернет");
    }

    @Test
    public void testInstalment() {

        WebElement accountNumberInput = driver.findElement(By.id("score-instalment"));
        assertEquals("Номер счета на 44", accountNumberInput.getAttribute("placeholder"), "проверка надписи в поле ввода номера счёта в разделе рассрочка");

        WebElement sumInput3 = driver.findElement(By.id("instalment-sum"));
        assertEquals("Сумма", sumInput3.getAttribute("placeholder"), "проверка надписи в поле ввода суммы в разделе рассрочка");

        WebElement emailInput3 = driver.findElement(By.id("instalment-email"));
        assertEquals("E-mail для отправки чека", emailInput3.getAttribute("placeholder"), "проверка надписи в поле ввода email в разделе рассрочка");
    }

    @Test
    public void testDebt() {

        WebElement debtInput = driver.findElement(By.id("score-arrears"));
        assertEquals("Номер счета на 2073", debtInput.getAttribute("placeholder"), "проверка надписи в поле ввода номера счёта в разделе задолженность");

        WebElement sumInput4 = driver.findElement(By.id("arrears-sum"));
        assertEquals("Сумма", sumInput4.getAttribute("placeholder"), "проверка надписи в поле ввода суммы в разделе задолженность");

        WebElement emailInput4 = driver.findElement(By.id("arrears-email"));
        assertEquals("E-mail для отправки чека", emailInput4.getAttribute("placeholder"), "проверка надписи в поле ввода email в разделе задолженность");
    }

    @Test
    public void testPayFrame() {

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

        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        WebElement frameSum = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        assert (frameSum.getAttribute("innerHTML").contains("10.00 BYN"));

        WebElement frameSumButton = driver.findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        assert (frameSumButton.getAttribute("innerHTML").contains("Оплатить  10.00 BYN"));

        WebElement framePhoneNumber = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        assert (framePhoneNumber.getAttribute("innerHTML").contains("375297777777"));

    }

    @Test
    public void testCardInput() {

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

        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));


        WebElement cardNumberInput = driver.findElement(By.xpath("//label[@class='ng-tns-c47-1 ng-star-inserted']"));
        assert (cardNumberInput.getAttribute("innerHTML").contains("Номер карты"));

        WebElement cardDateInput = driver.findElement(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']"));
        assert (cardDateInput.getAttribute("innerHTML").contains("Срок действия"));

        WebElement cvcInput = driver.findElement(By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']"));
        assert (cvcInput.getAttribute("innerHTML").contains("CVC"));

        WebElement nameInput = driver.findElement(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));
        assert (nameInput.getAttribute("innerHTML").contains("Имя держателя (как на карте)"));

    }

    @Test
    public void testPayIcons() {

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
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));


        WebElement mastercardIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        WebElement visaIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        WebElement belkartIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        WebElement mirIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));
        WebElement maestroIcon = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(mastercardIcon.isDisplayed());
        assertTrue(visaIcon.isDisplayed());
        assertTrue(belkartIcon.isDisplayed());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(mirIcon.isDisplayed());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(maestroIcon.isDisplayed());

    }

}