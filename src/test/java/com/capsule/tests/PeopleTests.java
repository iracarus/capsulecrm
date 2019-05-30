package com.capsule.tests;

import com.capsule.base.TestBase;
import com.capsule.enums.AddressType;
import com.capsule.pages.HomePage;
import com.capsule.pages.LoginPage;
import com.capsule.pages.PartiesPage;
import com.capsule.pages.PartyDetailsPage;
import org.testng.annotations.Test;

public class PeopleTests extends TestBase {
    LoginPage loginPage = LoginPage.getLoginPage();
    HomePage homePage = HomePage.getHomePage();
    PartiesPage partiesPage = PartiesPage.getPartiesPage();
    PartyDetailsPage partyDetailsPage = PartyDetailsPage.getPartyDetailsPage();

    @Test
    public void addPeopleTest()
    {

        String title = "Mr";
        String firstName = "Tarzan";
        String lastName = "Wangdu";
        String jobTitle = "Software Engineer";
        String organization = "Jungle Enterprises";
        String phoneNumber = "1435435435";
        String emailAddress = "test@testing.com";

//        loginPage.goTo();
//        loginPage.setUsername("darthvader")
//                .setPassword("Selenium12#")
//                .clickLogin();
//
//        homePage.isAt();
        partiesPage.goTo();
        partiesPage.selectList("People")
                .addPerson()
                .setTitle(title)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setJobTitle(jobTitle)
                .setOrganization(organization)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .setAddress(AddressType.HOME, "Test Stree, Sector 62, Noida", "Delhi", "New Delhi", "110008", "India")
                .save();

        partyDetailsPage.verifyPartyDetailsPage();

        partiesPage.goTo();
        partiesPage.isAt();
        partiesPage.selectPerson(title, firstName, lastName, jobTitle, organization, phoneNumber, emailAddress)
                    .deletePerson();
    }
}
