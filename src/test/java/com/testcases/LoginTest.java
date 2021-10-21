package com.testcases;

import com.base.Page;
import com.pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginTest extends Page{

//    //Negative Test
//    @Test(priority = 1, description="Login check with incorrect username and password")
//    public void verify_when_wrong_credentials() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.doLogin("TestUser", "TestPassword");
//        String message = driver.findElement(By.cssSelector("ul[class=\"woocommerce-error\"")).getText();
//        Assert.assertTrue(message.contains("ERROR: Invalid username. Lost your password?"));
//    }

    @Test(priority = 2, description="Login check with correct username and password")
    //Positive Test
    public void verify_user_is_able_to_login() {
        LoginPage loginPage = new LoginPage();
        loginPage.doLogin(CONFIG.getProperty("UserName"), CONFIG.getProperty("Password"));
    }
}
