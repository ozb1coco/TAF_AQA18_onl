package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        String pathToFile = FileUploaderTest.class.getClassLoader().getResource("image.jpg").getPath().substring(1);
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),
                "image.jpg");
    }
}
