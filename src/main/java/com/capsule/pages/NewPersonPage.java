package com.capsule.pages;

import com.capsule.base.DriverFactory;
import com.capsule.enums.AddressType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPersonPage {
    WebDriver driver = DriverFactory.getChromeDriver();

    @FindBy(xpath="//select[@name='party:j_id108:j_id116']")
    WebElement ddTitle;

    @FindBy(id = "party:fnDecorate:fn")
    WebElement editFirstName;

    @FindBy(id="party:lnDecorate:ln")
    WebElement editLastName;

    @FindBy(id="party:roleDecorate:jobTitle")
    WebElement editJobTitle;

    @FindBy(id="party:orgDecorate:org")
    WebElement editOrganization;

    @FindBy(id = "party:j_id325:0:phnDecorate:number")
    WebElement editPhoneNumber;

    @FindBy(id="party:j_id342:0:emlDecorate:nmbr")
    WebElement editEmail;

    @FindBy(xpath = "//a[@id='party:j_id443']")
    WebElement linkAddAnAddress;

    @FindBy(xpath = "//textarea[@id='party:j_id389:0:strDecorate:str']")
    WebElement textAddressDetails;

    @FindBy(name="party:j_id389:0:j_id438")
    WebElement ddAddressType;

    @FindBy(id="party:j_id389:0:ctyDecorate:cty")
    WebElement editCity;

    @FindBy(id="party:j_id389:0:rgnDecorate:dist")
    WebElement editState;

    @FindBy(id="party:j_id389:0:ctyPstCd:pstCd")
    WebElement editZip;

    @FindBy(name = "party:j_id389:0:cntryDecorate:j_id431")
    WebElement ddCountry;

    @FindBy(id="party:save")
    WebElement btnSave;

    private NewPersonPage()
    {
        PageFactory.initElements(driver, this);
    }

    public static NewPersonPage getNewPersonPage()
    {
        return new NewPersonPage();
    }
    public NewPersonPage setTitle(String title)
    {
        Select select = new Select(ddTitle);
        select.selectByVisibleText(title);
        return this;
    }

    public NewPersonPage setFirstName(String firstName)
    {
        editFirstName.sendKeys(firstName);
        return this;
    }

    public NewPersonPage setLastName(String lastName)
    {
        editLastName.sendKeys(lastName);
        return this;
    }

    public NewPersonPage setJobTitle(String jobTitle)
    {
        editJobTitle.sendKeys(jobTitle);
        return this;
    }

    public NewPersonPage setOrganization(String organization)
    {
        editOrganization.sendKeys(organization);
        return this;
    }

    public NewPersonPage setPhoneNumber(String phoneNumber)
    {
        editPhoneNumber.sendKeys(phoneNumber);
        return this;
    }

    public NewPersonPage setEmailAddress(String emailAddress)
    {
        editEmail.sendKeys(emailAddress);
        return this;
    }

    public NewPersonPage setAddress(AddressType addressType, String addressDetails, String city, String state, String zip, String country)
    {
        if(linkAddAnAddress.isDisplayed())
        {
            linkAddAnAddress.click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(textAddressDetails));
            textAddressDetails.clear();
            textAddressDetails.sendKeys(addressDetails);

            Select selectDDAddressType = new Select(ddAddressType);
            selectDDAddressType.selectByVisibleText(addressType.toString());

            editCity.clear();
            editCity.sendKeys(city);

            editState.clear();
            editState.sendKeys(state);

            editZip.clear();
            editZip.sendKeys(zip);

            Select selectDDCountry = new Select(ddCountry);
            selectDDCountry.selectByVisibleText(country);
        }

        return this;
    }

    public PartyDetailsPage save()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnSave));

        btnSave.click();

        return PartyDetailsPage.getPartyDetailsPage();
    }

}
