package com.capsule.pages;

import com.capsule.base.DriverFactory;
import com.capsule.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PartiesPage {
    WebDriver driver = DriverFactory.getChromeDriver();
    HeaderSection headerSection = HeaderSection.getHeader();

    @FindBy(xpath = "//div[text()='System lists']")
    WebElement systemList;

    @FindBy(xpath = "//div[contains(@class, 'simple lists-menu')]")
    WebElement simpleListMenu;

    @FindBy(xpath = "//div[@class='menu-select-group-options']/a[text()='People']")
    WebElement peopleLink;

    @FindBy(linkText = "Add Person")
    WebElement linkAddPerson;

    @FindBy(xpath = "//table[contains(@class, 'simple-table list-results')]")
    WebElement tableParties;

    @FindBy(xpath = "//span[@id='ember131']")
    WebElement btnDeleteParty;

    @FindBy(xpath = "//input[@class='form-input-checkbox bulk-delete-modal-checkbox']")
    WebElement chkBulkDelete;

    @FindBy(xpath="//form[@class='form simple']//button[text()='Delete']")
    WebElement btnDeleteConfirm;

    private PartiesPage()
    {
        PageFactory.initElements(driver, this);
    }

    public PartiesPage selectList(String listName)
    {
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        wait1.until(ExpectedConditions.elementToBeClickable(simpleListMenu));
        simpleListMenu.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(systemList));
        peopleLink.click();

        return this;
    }

    public NewPersonPage addPerson()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(linkAddPerson));
        linkAddPerson.click();
        return NewPersonPage.getNewPersonPage();
    }
    public PartiesPage goTo()
    {
        headerSection.goTo("People");
        return this;
    }

    public void isAt()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(tableParties));

        Assert.assertTrue(tableParties.isDisplayed());
    }

    public static PartiesPage getPartiesPage()
    {
        return new PartiesPage();
    }

    public PartiesPage selectPerson(String title, String firstName, String lastName, String jobTitle, String organization, String phoneNumber, String emailAddress) {
        int idx = BrowserUtils.SearchTable();

        if(idx > 0)
        {
            idx = idx+1; // there is one occluded row hence increased the rows by 1
            System.out.println("Person Found");
            WebElement checkBox = driver.findElement(By.xpath("//table[@class='simple-table list-results-table with-hover-effect']/tbody/tr["+idx+"]/td[1]/input"));
            checkBox.click();
        }
        else
        {
            System.out.println("Person not found");
        }
        return this;
    }

    public PartiesPage deletePerson() {
        btnDeleteParty.click();
        chkBulkDelete.click();
        btnDeleteConfirm.click();

        return this;
    }
}
