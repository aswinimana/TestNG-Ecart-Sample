package com.testcases;

import com.pages.shop.ShopPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTest {
    @Test(priority = 3, description="Select a product and add to the Cart")
    public void select_product_add_to_cart() {
        ShopPage shopPage = new ShopPage();
        shopPage.selectProduct();
    }
}