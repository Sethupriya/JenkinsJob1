package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public final class AdminPage extends BasePage{
    public AdminPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    private By add_link = By.xpath("//div[@class='orangehrm-header-container']/button");

    public void addAdmin_Link_Click(){
        click(add_link,"Admin");
    }

}
