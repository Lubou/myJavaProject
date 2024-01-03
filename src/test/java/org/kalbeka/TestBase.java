package org.kalbeka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeAll
    public static void settings() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", new File("external_resources/chromedriver-win32/chromedriver.exe").getAbsolutePath());//
    }

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement cookiesSkip = driver.findElement(By.xpath("//button[@id=\"cookie-agree\"]"));
        cookiesSkip.click();

    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    public void logIn() {
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
    }
}

