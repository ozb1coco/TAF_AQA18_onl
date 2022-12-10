package tests;

import configuration.ReadProperties;
import factory.BrowsersFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_8 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void swagLabsTest() throws InterruptedException {
        driver.get(ReadProperties.getUrl());
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(),"$9.99");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class = 'inventory_item_price']")).getText(),"$9.99");
        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_price")).getText(),"$9.99");
        Thread.sleep(2000);
    }
}
