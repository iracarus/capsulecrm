package com.capsule.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    WebDriverWait wait;
    public static Properties props;

    public TestBase() {
        FileInputStream inputFile;
        props = new Properties();
        try {
            inputFile = new FileInputStream(System.getProperty("user.dir") +
                    File.separator + "src" + File.separator + "main" + File.separator + "resources" +File.separator+ "environment.properties");

            props.load(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void startUpBrowser()
    {
        driver = DriverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 5);
    }

    @BeforeMethod
    public void goToLogin() {
        driver.get("https://starwars.capsulecrm.com/login");
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser()
    {
        driver.quit();
    }
}
