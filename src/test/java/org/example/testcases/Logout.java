package org.example.testcases;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout extends BaseTest{

    @Test(description = "Validate Login Functionality of OrangeHRM")
    public void loginToApplication() {

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.checkIsDisplayed());
        loginPage.enter_Username("Admin")
                .enter_Password("admin123")
                .enter_Signin();
        Assert.assertEquals(loginPage.getTitleFromLoginPage(), "OrangeHRM");
    }

    @Test(description = "Validate the user is able to logout the application")
    public void logoutApplication() {
      LogoutPage logout_obj = new LogoutPage();
      String title= logout_obj.logout_dropdown_method()
              .logout_button_method()
              .getTitleFromLoginPage();
        Assert.assertEquals(title,"OrangeHRM");
    }

}
