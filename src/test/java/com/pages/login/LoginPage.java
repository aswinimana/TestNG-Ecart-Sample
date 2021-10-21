package com.pages.login;

import com.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Properties;

public class LoginPage extends Page {

    public void doLogin(String userName,String password){
        driver.get(CONFIG.getProperty("baseURL"));
        try{
            Assert.assertEquals("Edgewords Shop – e-commerce demo site for Training", driver.getTitle());
        }catch(Throwable t){
            Page.takeScreenshot("Login.jpg");
        }
        click("myaccount_page");
        input("USERNAME",userName);
        input("PASSWORD",password);
        click("LOGIN_BUTTON");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class=\"woocommerce-MyAccount-content\"")));
        String message = driver.findElement(By.cssSelector("div[class=\"woocommerce-MyAccount-content\"")).getText();
        Assert.assertTrue(message.contains("Hello aswini87"));
    }
}
