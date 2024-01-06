package org.kalbeka;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*Написать автотест для калькулятора, который совершает арифметические действия (сложение, вычитание, умножение и деление)
и проверяет, что результат, отображаемый на экране соответствует ожидаемому (для теста взять приложение «Калькулятор» от Google
(https://play.google.com/store/apps/details?id=com.google.android.calculator&hl=ru&gl=US&pli=1)).*/

public class CalculatorTest {

    WebDriver driver;

    @BeforeEach
    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:app", "C:\\Users\\Люба\\Documents\\Java\\appiumTest\\src\\test\\java\\org\\kalbeka\\resourses\\com.google.android.calculator.apk");
        capabilities.setCapability("appium:deviceName", "Pixel");

        //capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void calcPlusTest() {

        driver.findElement(Buttons.NINE.locator).click();
        driver.findElement(Buttons.PLUS.locator).click();
        driver.findElement(Buttons.THREE.locator).click();
        driver.findElement(Buttons.EQUAL.locator).click();
        String result = driver.findElement(Buttons.RESULT.locator).getText();
        assertEquals("12", result);
    }

    @Test
    public void calcSubtractionTest() {
        driver.findElement(Buttons.NINE.locator).click();
        driver.findElement(Buttons.SUBS.locator).click();
        driver.findElement(Buttons.THREE.locator).click();
        driver.findElement(Buttons.EQUAL.locator).click();
        String result = driver.findElement(Buttons.RESULT.locator).getText();
        assertEquals("6", result);
    }

    @Test
    public void calcMultiplyTest() {
        driver.findElement(Buttons.NINE.locator).click();
        driver.findElement(Buttons.MULT.locator).click();
        driver.findElement(Buttons.THREE.locator).click();
        driver.findElement(Buttons.EQUAL.locator).click();
        String result = driver.findElement(Buttons.RESULT.locator).getText();
        assertEquals("27", result);
    }

    @Test
    public void calcDivideTest() {
        driver.findElement(Buttons.NINE.locator).click();
        driver.findElement(Buttons.DIV.locator).click();
        driver.findElement(Buttons.THREE.locator).click();
        driver.findElement(Buttons.EQUAL.locator).click();
        String result = driver.findElement(Buttons.RESULT.locator).getText();
        assertEquals("3", result);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
