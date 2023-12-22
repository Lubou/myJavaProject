package org.kalbeka.uitest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/* Необходимо написать автотесты для сайта mts.by. Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
1.Проверить название указанного блока;
2.Проверить наличие логотипов платёжных систем;
3.Проверить работу ссылки «Подробнее о сервисе»;
4.Заполнить поля и проверить работу кнопки «Продолжить»(проверяем только вариант «Услуги связи», номер для теста 297777777)*/
public class TestMTS {

    @Test
    public void testOnlinePay() {
        System.setProperty("webdriver.chrome.driver",
                new File("external_resources/chromedriver-win32/chromedriver.exe").getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //0
        WebElement cookiesSkip = driver.findElement(By.xpath("//button[@id=\"cookie-agree\"]"));
        cookiesSkip.click();

        //1
        WebElement blockHeader = driver.findElement(By.xpath("//section/div/h2"));
        System.out.println(blockHeader.getText());
        System.out.println("1: " + blockHeader.isDisplayed());

        //2
        WebElement payLogos = driver.findElement(By.className("pay__partners"));
        System.out.println("2: " + payLogos.isDisplayed());

        //3

        WebElement infoLink = driver.findElement(By.xpath("//a[contains( text(),'Подробнее о сервисе')]"));
        infoLink.click();
        System.out.println(driver.getTitle());

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
        System.out.println(continueButton.isDisplayed());

        driver.quit();

    }
}
