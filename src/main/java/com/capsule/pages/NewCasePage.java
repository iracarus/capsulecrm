package com.capsule.pages;

import com.capsule.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewCasePage {
    WebDriver driver = DriverFactory.getChromeDriver();

    @FindBy(id="partySearch")
    WebElement editCaseSearch;

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

        for(int i = 0; i<10; i++)
        {
            try
            {
                WebElement searchOption = driver.findElement(By.xpath("//div[@class='searchresult']/ul/li/text()[contains(., '"+caseRelatesTo+"')]/preceding-sibling::img"));
                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOf(searchOption));
                searchOption.click();
                break;
            }
            catch (NoSuchElementException ex)
            {

            }

        }

        return this;

    }
}
