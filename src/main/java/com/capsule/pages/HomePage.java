package com.capsule.pages;

import com.capsule.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    WebDriver driver = DriverFactory.getChromeDriver();

    private HomePage()
    {
        PageFactory.initElements(driver, this);
    }

    public HomePage isAt()
    {
        Assert.assertEquals(driver.getTitle(), "Dashboard | Selenium Testing World CRM");
        return this;
    }

    public static HomePage getHomePage()
    {
        return new HomePage();
    }
}
