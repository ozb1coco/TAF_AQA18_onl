package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;

public class CartSteps extends BaseStep {
    InventorySteps inventorySteps = new InventorySteps(driver);
    CartPage cartPage = new CartPage(driver);

    public CartSteps(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage goingToCheckout(String email, String psw) {
        inventorySteps.goingToCart(email, psw);
        pressCheckoutButton();
        return new CheckoutPage(driver);
    }

    public void pressCheckoutButton() {
        cartPage.getCheckoutButton().click();
    }

}
