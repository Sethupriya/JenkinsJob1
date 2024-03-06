package org.example.testcases;

import org.example.annotations.FrameworkAnnotation;
import org.example.enums.CategoryType;
import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;
import org.example.reports.ExtentLogger;
import org.example.utils.DataProviderUtils;
import org.example.utils.DecodeUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

//@Listeners(org.example.listeners.MyListeners.class)
public class Login extends BaseTest{

   // WebDriver driver;
   //LoginPage loginPage= new LoginPage();

    //@Test(description = "Validate username text box",priority = 1)
    public void enteringUsername(){
        LoginPage loginPage = new LoginPage();
        //loginPage.enter_Username("Admin");
        loginPage.enter_Signin();
        ExtentLogger.pass("Clicked sign in button");
        Assert.assertEquals(loginPage.checkRequiredValidation(),"Required");
    }

    //@Test(description = "Validate password text box",priority = 2)
    public void enteringPassword(){
        new LoginPage().enter_Password("admin123");
    }

    //@Test(description = "Validate sign in button",priority = 3)
    public void clickSignin(){
        new LoginPage().enter_Signin();
    }

    //@Test(description = "Validate the user is able to logout the application",priority = 4)
    public void logoutApplication() {
        LogoutPage logout_obj = new LogoutPage();
        String title= logout_obj.logout_dropdown_method()
                .logout_button_method()
                .getTitleFromLoginPage();
        Assert.assertEquals(title,"OrangeHRM");
    }


    @Test(description = "Validate Login Functionality of OrangeHRM",priority = 5,dataProvider = "login",
            dataProviderClass = DataProviderUtils.class)
    @FrameworkAnnotation(author = {"Sethu","Anjana"},category = {CategoryType.SANITY,CategoryType.SMOKE})
    public void loginToApplication(Map<String,String> data){
        /*LoginPage loginPage= new LoginPage();
        Assert.assertTrue(loginPage.checkIsDisplayed());
        /*loginPage.enter_Username(data.get("username"))
                .enter_Password(data.get("password"))
                .enter_Signin();*/
        //loginPage.enter_Details(data.get("username"),data.get("password"));
       // SoftAssert sa = new SoftAssert();
        //sa.assertEquals(loginPage.getTitleFromLoginPage(),"OrangeHRM");
        /* Hard Assertion
        Assert.assertEquals(loginPage.getTitleFromLoginPage(),"OrangeHRM");*/

        /*LogoutPage logout_obj = new LogoutPage();
        String title= logout_obj.logout_dropdown_method()
                .logout_button_method()
                .getTitleFromLoginPage();
        sa.assertEquals(title,"OrangeHRM");
        //Assert.assertEquals(title,"OrangeHRM");
        sa.assertAll();*/

         /*driver = DriverManager.checkBrowserToOpen();
        LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));*/

        /*LoginPage loginPage= new LoginPage();
        boolean username_displayed_check = loginPage.checkIsDisplayed();
        System.out.println(username_displayed_check);
        Assert.assertEquals(username_displayed_check,true);
        loginPage.enter_Details("Admin","admin123");
        String title = loginPage.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"OrangeHRM");*/
        String title =new LoginPage().enter_Details(data.get("username"), DecodeUtils.getDecodedString(data.get("password")))
                .logout_dropdown_method().logout_button_method().getTitleFromLoginPage();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(title,"OrangeHRM");
        sa.assertAll();
    }
    @Test(dataProvider = "login",dataProviderClass = DataProviderUtils.class)
    @FrameworkAnnotation(author = {"Sethu","Anjana"},category = {CategoryType.SANITY})
    public void negativeCheck(Map<String,String> data){
        String req_validation = new LoginPage().enter_Username(data.get("username"))
                .enter_Password(DecodeUtils.getDecodedString(data.get("password"))).enter_Signin().checkRequiredValidation();
        //SoftAssert sa = new SoftAssert();
        Assert.assertEquals(req_validation,"Required1");
        System.out.println("End of negativeCheck Validation");
        //sa.assertAll();
    }

    @Test(dataProvider = "login",dataProviderClass = DataProviderUtils.class)
    @FrameworkAnnotation(author = "Anjana",category =CategoryType.REGRESSION)
    public void recruitmentLinkValidation(Map<String,String> data){
        String page_title=new LoginPage().enter_Username(data.get("username"))
                .enter_Password(DecodeUtils.getDecodedString(data.get("password"))).enter_Signin()
                .clickInterviewLink().getURLfromRecruitPage();
        System.out.println(page_title);
        boolean title_check=page_title.contains("recruitment");
        Assert.assertTrue(title_check);
    }

}
