package org.example.pages;

import org.example.driver.DriverManager;
import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class LoginPage extends BasePage{


    public LoginPage(){
        //this.driver = driver;
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    @FindBy(xpath ="//input[@name='username']")
    private WebElement textbox_username;

    @FindBy(xpath ="//input[@name='password']")
    private WebElement textbox_password;

    @FindBy(xpath ="//button[@type='submit']")
    private WebElement signin_button;

    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']/span[1]")
    private WebElement check_input_validation;

    /*@FindBy(xpath = "//p[contains(.,'Candidate to Interview')]")
    private WebElement interview_link;*/

    By interview_link = By.xpath("//p[contains(.,'Candidate to Interview')]");

    public LoginPage enter_Username(String username){
        //textbox_username.sendKeys(username);
        sendKeys(textbox_username,username,"Username");
        return this;
    }

    public LoginPage enter_Password(String password){
        //textbox_password.sendKeys(password);
        sendKeys(textbox_password,password,"Password");
        return this;
    }

    public LoginPage enter_Signin(){
        signin_button.click();
        return this;
    }

    public LogoutPage enter_Details(String username, String password){
        //textbox_username.sendKeys(username);
        //textbox_password.sendKeys(password);
        sendKeys(textbox_username,username,"Username");
        sendKeys(textbox_password,password,"Password");
        click(signin_button,"Sign in");
        return new LogoutPage();
        //signin_button.click();
    }

    public String getTitleFromLoginPage(){
        return getTitle();
    }

    public boolean checkIsDisplayed(){
        return isDisplayed(textbox_username);
    }

    public String checkRequiredValidation(){ return getText(check_input_validation);}

    public RecruitmentPage clickInterviewLink(){
        click(interview_link, WaitStrategy.CLICKABLE,"Candidate interview link");
        //click(interview_link,"Candidate interview link");
        return new RecruitmentPage();
    }
}
