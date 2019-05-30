package com.capsule.pages;

import com.capsule.base.DriverFactory;
import com.capsule.utils.BrowserUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewCasePage {
    WebDriver driver = DriverFactory.getChromeDriver();

    @FindBy(id="partySearch")
    WebElement editCaseSearch;

    @FindBy(xpath = "//div[@class='searchresult']")
    WebElement searchCaseOptions;

    @FindBy(id="caseNameDecorate:name")
    WebElement editCaseName;

    @FindBy(id="caseDescriptionDecorate:description")
    WebElement editCaseDescription;

    @FindBy(id = "save")
    WebElement btnSave;

    private NewCasePage()
    {
        PageFactory.initElements(driver, this);
    }

    public static NewCasePage getNewCasePage() {
        return new NewCasePage();
    }

    public NewCasePage setCaseRelatesTo(String caseRelatesTo) {
        editCaseSearch.clear();
        editCaseSearch.sendKeys(caseRelatesTo);

        BrowserUtils.selectOptionWithText(driver, searchCaseOptions, caseRelatesTo);
//        editCaseSearch.sendKeys(Keys.ENTER);
//        for(int i = 0; i<10; i++)
//        {
//            try
//            {
//                WebElement searchOption = driver.findElement(By.xpath("//div[@class='searchresult']/ul/li/text()[contains(., '"+caseRelatesTo+"')]/preceding-sibling::img"));
//                WebDriverWait wait = new WebDriverWait(driver, 30);
//                wait.until(ExpectedConditions.visibilityOf(searchOption));
//                searchOption.click();
//                break;
//            }
//            catch (NoSuchElementException ex)
//            {
//
//            }
//
//        }

        return this;

    }

    public NewCasePage setCaseName(String caseName) {
        editCaseName.clear();
        editCaseName.sendKeys(caseName);
        return this;
    }

    public NewCasePage setDescription(String caseDescription) {
        editCaseDescription.clear();
        editCaseDescription.sendKeys(caseDescription);
        return this;
    }

    public void save() {
        WebDriverWait wait  = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnSave));

        btnSave.click();
    }
}
