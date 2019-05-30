package com.capsule.tests;

import com.capsule.base.TestBase;
import com.capsule.enums.AddressType;
import com.capsule.pages.CaseDetailsPage;
import com.capsule.pages.CasesPage;
import com.capsule.pages.HomePage;
import com.capsule.pages.LoginPage;
import org.testng.annotations.Test;

public class CasesTests extends TestBase {
    LoginPage loginPage = LoginPage.getLoginPage();
    HomePage homePage = HomePage.getHomePage();
    CasesPage casesPage = CasesPage.getCasesPage();
    CaseDetailsPage caseDetailsPage = CaseDetailsPage.getCaseDetailsPage();

    @Test
    public void addCaseTest()
    {
        //loginPage.goTo();
        //loginPage.setUsername("darthvader")
          //      .setPassword("Selenium12#")
            //    .clickLogin();

        //homePage.isAt();
        casesPage.goTo();

        casesPage.selectList("Open Cases")
                .addCase()
                .setCaseRelatesTo("Darth Vader")
                .setCaseName("Test Case")
                .setDescription("Test Case Description")
                .save();

        caseDetailsPage.verifyCaseDetailsPage();
        caseDetailsPage.verifyCaseStatus("Open");
    }
}
