package org.example.pages;

import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public final class DashboardPage extends BasePage{
    public DashboardPage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    private By admin_link = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");

    public void admin_Link_Click(){
        click(admin_link,"Admin");
    }
}
