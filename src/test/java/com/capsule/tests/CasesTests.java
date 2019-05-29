package com.capsule.tests;

import com.capsule.enums.AddressType;
import com.capsule.pages.CasesPage;
import com.capsule.pages.HomePage;
import com.capsule.pages.LoginPage;
import org.testng.annotations.Test;

public class CasesTests {
    LoginPage loginPage = LoginPage.getLoginPage();
    HomePage homePage = HomePage.getHomePage();
    CasesPage casesPage = CasesPage.getCasesPage();

    @Test
    public void addCaseTest()
    {
        loginPage.goTo();
        loginPage.setUsername("darthvader")
                .setPassword("Selenium12#")
                .clickLogin();

        homePage.isAt();
        casesPage.goTo();

        casesPage.selectList("Open Cases")
                .addCase()
                .setCaseRelatesTo("Darth Vader");
//                .setCaseName("Test Case")
//                .setDescription("Test Case Description")
//                .save();
    }
}
