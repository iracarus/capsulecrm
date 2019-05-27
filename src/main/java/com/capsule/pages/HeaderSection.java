package com.capsule.pages;

import com.capsule.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderSection {
    WebDriver driver = DriverFactory.getChromeDriver();

    @FindBy(xpath = "//span[contains(text(),'People')]/parent::a")
    WebElement peopleLink;

    private HeaderSection()
    {
        PageFactory.initElements(driver, this);
    }
    public void goTo(String sectionName) {
        switch (sectionName)
        {
            case "People" :
                peopleLink.click();
                break;
        }
    }

    public static HeaderSection getHeader()
    {
        return new HeaderSection();
    }
}
