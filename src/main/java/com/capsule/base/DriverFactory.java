package com.capsule.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverFactory() {
        // prevernt instatiation
    }

    public static WebDriver getChromeDriver()
    {
        if(driver==null)
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait()
    {
        if(wait==null)
        {
            wait = new WebDriverWait(getChromeDriver(), 5);
        }
        return wait;
    }
}
