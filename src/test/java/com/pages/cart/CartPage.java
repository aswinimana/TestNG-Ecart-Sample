package com.pages.cart;

import com.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage extends Page {
    public void proceed_checkout(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        click("cart_page");
        WebElement webElement = driver.findElement(By.xpath("//*[@class=\"wc-proceed-to-checkout\"]/a"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"wc-proceed-to-checkout\"]/a")));
        click("proceed_checkout");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"place_order\"]")));
        String message = driver.findElement(By.cssSelector("h1[class=\"entry-title\"")).getText();
        Assert.assertTrue(message.contains("Checkout"));
    }

    public void remove_poroducts(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        click("cart_page");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"product-remove\"]/a")));
        click("remove_product");
        String message = driver.findElement(By.cssSelector("div[class=\"woocommerce-message\"")).getText();
        Assert.assertTrue(message.contains("“Cap” removed."));
    }

    public void undo_poroducts(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"woocommerce-message\"]/a")));
        click("undo_product");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"checkout-button button alt wc-forward\"]")));
        String message = driver.findElement(By.xpath("//*[@class=\"checkout-button button alt wc-forward\"]")).getText();
        Assert.assertTrue(message.contains("Proceed to checkout"));
    }
}