package com.capsule.tests;

import com.capsule.enums.AddressType;
import com.capsule.pages.HomePage;
import com.capsule.pages.LoginPage;
import com.capsule.pages.PartiesPage;
import com.capsule.pages.PartyDetailsPage;
import org.testng.annotations.Test;

public class PeopleTests {
    LoginPage loginPage = LoginPage.getLoginPage();
    HomePage homePage = HomePage.getHomePage();
    PartiesPage partiesPage = PartiesPage.getPartiesPage();
    PartyDetailsPage partyDetailsPage = PartyDetailsPage.getPartyDetailsPage();

    @Test
    public void addPeopleTest()
    {
        loginPage.goTo();
        loginPage.setUsername("darthvader")
                .setPassword("Selenium12#")
                .clickLogin();

        homePage.isAt();
        partiesPage.goTo();
        partiesPage.selectList("People")
                .addPerson()
                .setTitle("Mr")
                .setFirstName("Tarzan")
                .setLastName("Wangdu")
                .setJobTitle("Software Engineer")
                .setOrganization("Jungle Enterprises")
                .setPhoneNumber("1435435435")
                .setEmailAddress("test@testing.com")
                .setAddress(AddressType.HOME, "Test Stree, Sector 62, Noida", "Delhi", "New Delhi", "110008", "India")
                .save();

        partyDetailsPage.verifyPartyDetailsPage();

        partiesPage.goTo();
        partiesPage.isAt();


    }
}
