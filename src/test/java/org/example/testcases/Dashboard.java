package org.example.testcases;

import org.example.pages.DashboardPage;
import org.testng.annotations.Test;

public class Dashboard extends BaseTest{
    @Test
    public void click_AdminLink(){

        new DashboardPage().admin_Link_Click();
    }
}
