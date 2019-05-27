package com.capsule.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static Properties props;
    public static WebDriver driver;

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


    @BeforeMethod
    public void setup()
    {
        TestBase.initialize();
    }

    @AfterMethod
    public void end() {
        tearDown();
    }


    /**
     * Initializes all the basic components like driver, properties file etc
     * Takes care of the operating system to load relevant drivers/files
     */
    public static void initialize()
    {

        ChromeOptions options = new ChromeOptions();

        if(props.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            options.addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        else if(props.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(props.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(props.getProperty("IMPLICITLY_WAIT")), TimeUnit.SECONDS);
        driver.get(props.getProperty("url"));

    }

    /**
     * Quits the driver to close the browser
     */
    public void tearDown()
    {
        //driver.quit();
    }
}
