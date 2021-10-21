package com.pages.shop;

import com.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShopPage extends Page{
    public void selectProduct(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        click("shop_page");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/ul/li[3]/a[2]")));
        click("addcart");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='main']/ul/li[3]/a[3]")));
        click("viewcart");

    }
}
