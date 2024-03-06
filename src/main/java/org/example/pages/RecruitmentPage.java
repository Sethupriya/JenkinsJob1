package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage extends BasePage {
    RecruitmentPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }
    public String getURLfromRecruitPage(){
        return getURL();
    }
}
