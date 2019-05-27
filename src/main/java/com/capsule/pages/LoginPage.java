package com.capsule.pages;

import com.capsule.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(id = "login:usernameDecorate:username")
    WebElement editUsername;

    @FindBy(id = "login:passwordDecorate:password")
    WebElement editPassword;

    @FindBy(id = "login:login")
    WebElement btnLogin;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    public void login(){
        editUsername.sendKeys("darthvader");
        editPassword.sendKeys("Selenium12#");
        btnLogin.click();
    }
}
