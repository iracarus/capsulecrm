package com.capsule.pages;

import com.capsule.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CaseDetailsPage {
    WebDriver driver = DriverFactory.getChromeDriver();

    @FindBy(xpath = "//div[contains(@class, 'kase-summary-status')]/span")
    WebElement caseStatus;

    private CaseDetailsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public static CaseDetailsPage getCaseDetailsPage()
    {
        return new CaseDetailsPage();
    }

    public void verifyCaseDetailsPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(caseStatus));

        Assert.assertTrue(caseStatus.isDisplayed());
    }

    public CaseDetailsPage verifyCaseStatus(String expStatus) {
        Assert.assertEquals(caseStatus.getText(), expStatus);
        return this;
    }
}
