package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.Inventory;

public class InventorySteps extends BaseStep {
    UserStep userStep = new UserStep(driver);
    Inventory inventory = new Inventory(driver);


    public InventorySteps(WebDriver driver) {
        super(driver);
    }

    public Inventory addToCartStuff(String email, String psw) {
        userStep.login(email, psw);
        addToCart();
        return new Inventory(driver);
    }

    public CartPage goingToCart(String email, String psw) {
        userStep.login(email, psw);
        addToCart();
        goingToBucket();
        return new CartPage(driver);
    }

    public void addToCart() {
        inventory.getAddToCartButton().click();
    }

    public void goingToBucket() {
        inventory.getButtonIntoBucket().click();
    }

}
