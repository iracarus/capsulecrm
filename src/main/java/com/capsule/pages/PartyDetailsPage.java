package com.capsule.pages;

import com.capsule.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartyDetailsPage {
    WebDriver driver = DriverFactory.getChromeDriver();

    @FindBy(xpath = "//div[contains(@class, 'primary-party-details')]")
    WebElement  sectionPrimaryPartyDetails;

    private PartyDetailsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void verifyPartyDetailsPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(sectionPrimaryPartyDetails));

        Assert.assertTrue(sectionPrimaryPartyDetails.isDisplayed());
    }
    public static PartyDetailsPage getPartyDetailsPage()
    {
        return new PartyDetailsPage();
    }
}
