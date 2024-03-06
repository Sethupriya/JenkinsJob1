package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class LogoutPage extends BasePage {

    public LogoutPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement logout_dropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout_button;

    public LogoutPage logout_dropdown_method() {
        //logout_dropdown.click();
        click(logout_dropdown,"Logout dropdown");
        return this;
    }

    public LoginPage logout_button_method() {
        //logout_button.click();
        click(logout_button,"Logout button");
        return new LoginPage();
    }

    public String getTitleFromLogoutPage(){
        return getTitle();
    }

}
