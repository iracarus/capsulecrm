package com.capsule.tests;

import com.capsule.base.TestBase;
import com.capsule.pages.HomePage;
import com.capsule.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginPage loginPage = LoginPage.getLoginPage();
    HomePage homePage = HomePage.getHomePage();

    @Test
    public void login() {
        loginPage.goTo();
        loginPage.setUsername("darthvader")
                .setPassword("Selenium12#")
                .clickLogin();

        homePage.isAt();
    }
}
