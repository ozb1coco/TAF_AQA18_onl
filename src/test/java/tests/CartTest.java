package tests;

import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends InventoryTest {
    @Test
    public void checkQuantityValueTest() {
        Assert.assertEquals(
                inventorySteps.goingToCart(ReadProperties.username(), ReadProperties.password())
                        .getCartQuantity().getText(), "1"
        );
    }

    @Test
    public void checkPriceValueTest() {
        Assert.assertEquals(
                inventorySteps.goingToCart(ReadProperties.username(), ReadProperties.password())
                        .getPriceValue().getText(), "$49.99"
        );
    }
    @Test
    public void goingToCheckoutTest(){
        Assert.assertTrue(cartSteps.goingToCheckout(ReadProperties.username(), ReadProperties.password())
                .isPageOpened());

    }
}
