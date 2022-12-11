package tests;

import factory.BrowsersFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;

public class SmokeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        BrowsersFactory browsersFactory = new BrowsersFactory();
        driver = browsersFactory.getDriver();
    }

    @Test
    public void validateCalculator() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement heightInput = driver.findElement(By.id("el_f_width"));
        heightInput.sendKeys("4");
        WebElement lenghtInput = driver.findElement(By.id("el_f_lenght"));
        lenghtInput.sendKeys("5");
        WebElement selectWebElement = driver.findElement(By.id("room_type"));
        Select selectRoomType = new Select(selectWebElement);
        selectRoomType.selectByValue("2");
        selectWebElement = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectWebElement);
        selectHeatingType.selectByVisibleText("Подогрев для комфорта");
        WebElement heatLostInput = driver.findElement(By.id("el_f_losses"));
        heatLostInput.sendKeys("22");
        driver.findElement(By.className("buttHFcalc")).click();
        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"), "12");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"),"1");

    }
    @Test
    public void validateLaminateTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(10000);
        driver.findElement(By.id("ln_room_id")).clear();
        driver.findElement(By.id("ln_room_id")).sendKeys("500");
        driver.findElement(By.id("wd_room_id")).clear();
        driver.findElement(By.id("wd_room_id")).sendKeys("400");
        driver.findElement(By.id("ln_lam_id")).clear();
        driver.findElement(By.id("ln_lam_id")).sendKeys("2000");
        driver.findElement(By.id("wd_lam_id")).clear();
        driver.findElement(By.id("wd_lam_id")).sendKeys("200");
        driver.findElement(By.id("n_packing")).clear();
        driver.findElement(By.id("n_packing")).sendKeys("8");
        driver.findElement(By.id("min_length_segment_id")).clear();
        driver.findElement(By.id("min_length_segment_id")).sendKeys("250");
        driver.findElement(By.id("indent_walls_id")).clear();
        driver.findElement(By.id("indent_walls_id")).sendKeys("10");
        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select selectMethodOfLayingType = new Select(selectWebElement);
        selectMethodOfLayingType.selectByVisibleText("с использованием отрезанного элемента");
        driver.findElement(By.id("direction-laminate-id1")).click();
        driver.findElement(By.cssSelector("[class = 'calc-btn']")).click();
        WebElement resultOfQuantity = driver.findElement(By.xpath("//div[contains( text(), 'Требуемое количество')]"));
        Assert.assertEquals(resultOfQuantity.getText(),"Требуемое количество досок ламината: 53");
        WebElement resultOfQuantityPacks = driver.findElement(By.xpath("//div[contains( text(), 'Количество упаковок')]"));
        Assert.assertEquals(resultOfQuantityPacks.getText(),"Количество упаковок ламината: 7");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
