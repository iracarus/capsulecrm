package com.capsule.pages;

import com.capsule.base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver = DriverFactory.getChromeDriver();

    @FindBy(id = "login:usernameDecorate:username")
    WebElement editUsername;

    @FindBy(id = "login:passwordDecorate:password")
    WebElement editPassword;

    @FindBy(id = "login:login")
    WebElement btnLogin;

    private LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    public LoginPage goTo()
    {
        driver.get("https://starwars.capsulecrm.com/login");
        return this;
    }

    public LoginPage setUsername(String userName)
    {
        editUsername.sendKeys(userName);
        return this;
    }

    public LoginPage setPassword(String password)
    {
        editPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin()
    {
        btnLogin.click();
        return this;
    }

    public static LoginPage getLoginPage()
    {
        return new LoginPage();
    }
}
