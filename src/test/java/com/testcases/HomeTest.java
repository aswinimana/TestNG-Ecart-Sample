package com.testcases;

import com.base.Page;
import com.pages.home.HomePage;
import com.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeTest extends Page {

    @Test(priority = 7, description="Got to Home page and Select a Category")
    public void select_category_add_to_cart() {
        HomePage homepPage = new HomePage();
        homepPage.selectCategory();
    }
    @Test(priority = 8, description="Test product selected is added to Cart")
    public void check_product_added_to_cart() {
        HomePage homepPage = new HomePage();
        homepPage.checkProduct();
    }
}
