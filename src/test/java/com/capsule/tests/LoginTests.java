package com.capsule.tests;

import com.capsule.base.TestBase;
import com.capsule.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginPage loginPage;

    @Test
    public void login() {
        loginPage = new LoginPage();
        System.out.println(driver.getTitle());
        loginPage.login();
    }
}
