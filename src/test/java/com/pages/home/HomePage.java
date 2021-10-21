package com.pages.home;

import com.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends Page{
    public void selectCategory(){
        driver.get(CONFIG.getProperty("baseURL"));
        try{
            Assert.assertEquals("Edgewords Shop – e-commerce demo site for Training", driver.getTitle());
        }catch(Throwable t){
            Page.takeScreenshot("Login.jpg");
        }
        WebDriverWait wait = new WebDriverWait(driver, 60);
        click("home_page");
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div/ul/li[1]/a/h2"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
//         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/section[1]/div/ul/li")));
        driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div/ul/li[2]/a")).click();

        WebElement webElement1 = driver.findElement(By.xpath("//*[@id='main']/ul/li[1]/a[2]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement1);
        click("category_addcart");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/ul/li[1]/a[3]")));
        click("category_viewcart");
    }

    public void checkProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement webElement = driver.findElement(By.xpath("//*[@class=\"wc-proceed-to-checkout\"]/a"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"wc-proceed-to-checkout\"]/a")));
        driver.findElement(By.xpath("//img[contains(@src,'hoodie.jpg')]"));
    }

    public void removeProducts(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        click("cart_page");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"product-remove\"]/a")));
        click("remove_product");
        String message = driver.findElement(By.cssSelector("div[class=\"woocommerce-message\"")).getText();
        Assert.assertTrue(message.contains("“Hoodie” removed."));
    }
}
