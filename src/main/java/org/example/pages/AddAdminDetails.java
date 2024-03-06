package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class AddAdminDetails extends BasePage{
    public AddAdminDetails(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    private WebElement UserRole;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement Emp_Name;

    private By UserRoleDropDown= By.xpath("//div[@role = 'listbox']/child::div");

    private By EmpNameDropDown = By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']");

    private By StatusDropDown = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']");

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    private WebElement Status;

    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active'])[1]")
    private WebElement UserName;

    @FindBy(xpath = "(//div[@class='oxd-form-row user-password-row']/descendant::input[@class='oxd-input oxd-input--active'])[1]")
    private WebElement Password;

    @FindBy(xpath = "(//div[@class='oxd-form-row user-password-row']/descendant::input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement Confirm_Password;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='button']")
    private WebElement Cancel;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='submit']")
    private WebElement Submit;

    public AddAdminDetails select_UserRole(String userRole){
        click(UserRole,"UserRoleDropdown");
        dropDown(UserRoleDropDown,"UserRoleDropdown",userRole);
        return this;
    }

    public AddAdminDetails select_EmpName(String empName){
        sendKeys(Emp_Name,empName,"Emp Name");
        dropDown(EmpNameDropDown,"Selected ",empName);
        return this;
    }

    public AddAdminDetails select_Status(String status){
        click(Status,"StatusDropDown");
        dropDown(StatusDropDown,"Selected ",status);
        return this;
    }

    public AddAdminDetails enter_UserName(String userName){
        sendKeys(UserName,userName,"Username");
        return this;
    }
    public AddAdminDetails enter_Password(String password){
        sendKeys(Password,password,"Password");
        return this;
    }
    public AddAdminDetails enter_confirmPassword(String confirmPassword){
        sendKeys(Confirm_Password,confirmPassword,"ConfirmPassword");
        return this;
    }
    public AdminPage click_Submit(){
        click(Submit,"Submit button");
        return new AdminPage();
    }
}
