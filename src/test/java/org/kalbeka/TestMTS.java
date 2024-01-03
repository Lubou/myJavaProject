package org.kalbeka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/* Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
 нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
 номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты,
 наличие иконок платёжных систем.*/

public class TestMTS extends TestBase {

    private WebElement waitElementVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @ParameterizedTest
    @CsvSource({
            "connection-phone,Номер телефона",
            "internet-phone,Номер абонента",
            "score-instalment,Номер счета на 44",
            "score-arrears,Номер счета на 2073"
    })
    public void testNumberInput(String inputFieldId, String expectedPlaceholder) {
        WebElement accountNumberInput = driver.findElement(By.id(inputFieldId));
        assertEquals(expectedPlaceholder, accountNumberInput.getAttribute("placeholder"));
    }

    @ParameterizedTest
    @CsvSource({
            "connection-sum,Сумма",
            "internet-sum,Сумма",
            "instalment-sum,Сумма",
            "arrears-sum,Сумма"
    })
    public void testSumInput(String inputFieldId, String expectedPlaceholder) {
        WebElement sumInput = driver.findElement(By.id(inputFieldId));
        assertEquals(expectedPlaceholder, sumInput.getAttribute("placeholder"));
    }

    @ParameterizedTest
    @CsvSource({
            "connection-email,E-mail для отправки чека",
            "internet-email,E-mail для отправки чека",
            "instalment-email,E-mail для отправки чека",
            "arrears-email,E-mail для отправки чека"
    })
    public void testEmailInput(String inputFieldId, String expectedPlaceholder) {
        WebElement eMailInput = driver.findElement(By.id(inputFieldId));
        assertEquals(expectedPlaceholder, eMailInput.getAttribute("placeholder"));
    }

    @Test
    public void testFrame() {

        logIn();

        WebElement frameSum = waitElementVisibility(By.xpath("//p[@class='header__payment-amount']"));
        WebElement frameSumButton = waitElementVisibility(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        WebElement framePhoneNumber = waitElementVisibility(By.xpath("//p[@class='header__payment-info']"));

        assertAll(
                () -> assertEquals("10.00 BYN", frameSum.getText()),
                () -> assertEquals("Оплатить 10.00 BYN", frameSumButton.getText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", framePhoneNumber.getText())
        );
    }

    @Test
    public void testPayFrame() {

        logIn();

        WebElement cardNumberInput = waitElementVisibility(By.xpath("//label[@class='ng-tns-c47-1 ng-star-inserted']"));
        WebElement cardDateInput = waitElementVisibility(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']"));
        WebElement cvcInput = waitElementVisibility(By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']"));
        WebElement nameInput = waitElementVisibility(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));

        assertAll(
                () -> assertEquals("Номер карты", cardNumberInput.getText()),
                () -> assertEquals("Срок действия", cardDateInput.getText()),
                () -> assertEquals("CVC", cvcInput.getText()),
                () -> assertEquals("Имя держателя (как на карте)", nameInput.getText())
        );
    }

    @Test
    public void testPayIcons() {

        logIn();

        List<PaymentSystem> payments = List.of(PaymentSystem.values());

        assertAll(
                () -> payments.forEach(payment -> assertTrue(waitElementVisibility(payment.locator).isDisplayed()))
        );
    }
}