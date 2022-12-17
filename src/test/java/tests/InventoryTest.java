package tests;

import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTest extends LoginTest {
    @Test
    public void addToCartTest() {
        Assert.assertTrue(
                inventorySteps.addToCartStuff(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );
    }

    @Test
    public void goingToBucketAfterAddStuffTest() {
        Assert.assertTrue(
                inventorySteps.goingToCart(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened()
        );
    }
}
