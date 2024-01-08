package org.kalbeka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
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
        driver.get("https://www.wildberries.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterEach
    public void teardown() {
        driver.quit();
    }

}

