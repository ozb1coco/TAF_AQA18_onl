package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void implicitlyVisibilityTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkboxPoint = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkboxPoint.click();
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

        WebElement loading = waitsService.waitForVisibilityBy(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(waitsService.waitForElementInvisible(loading));

        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");

        Assert.assertEquals(driver.findElement(By.xpath("//button[@onclick='swapInput()']")).getText(), "Enable");
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id = 'message']")).getText(), "It's enabled!");
        Assert.assertEquals(driver.findElement(By.xpath("//button[@onclick='swapInput()']")).getText(), "Disable");
    }
}
