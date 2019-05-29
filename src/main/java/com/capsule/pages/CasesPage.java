package com.capsule.pages;

import com.capsule.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasesPage {
    WebDriver driver = DriverFactory.getChromeDriver();
    HeaderSection headerSection = HeaderSection.getHeader();

    @FindBy(xpath = "//div[@class='menu-select ember-view simple lists-menu']")
    WebElement simpleListMenu;


    @FindBy(xpath = "//div[text()='System lists']")
    WebElement systemList;

    @FindBy(xpath = "//div[@class='menu-select-group-options']/a[text()='Open Cases']")
    WebElement openCasesLink;


    @FindBy(linkText = "Add Case")
    WebElement linkAddCase;

    private CasesPage()
    {
        PageFactory.initElements(driver, this);
    }
    public static CasesPage getCasesPage() {
        return new CasesPage();
    }


    public CasesPage selectList(String open_cases) {
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(simpleListMenu));
        simpleListMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(systemList));
        openCasesLink.click();

        return this;
    }

    public NewCasePage addCase() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(linkAddCase));
        linkAddCase.click();
        return NewCasePage.getNewCasePage();
    }

    public CasesPage goTo() {
        headerSection.goTo("Cases");
        return this;
    }
}
