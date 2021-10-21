package com.testcases;

import com.pages.cart.CartPage;
import org.testng.annotations.Test;

public class CartTest {
    @Test(priority = 4, description="Proceed to checkout")
    public void proceed_to_checkout() {
        CartPage cartPage = new CartPage();
        cartPage.proceed_checkout();
    }

    @Test(priority = 5, description="Remove product from cart")
    public void remove_poroduct_from_cart() {
        CartPage cartPage = new CartPage();
        cartPage. remove_poroducts();
    }

    @Test(priority = 6, description="Undo removed products from Cart")
    public void undo_poroducts_from_cart() {
        CartPage cartPage = new CartPage();
        cartPage. undo_poroducts();
    }
}
