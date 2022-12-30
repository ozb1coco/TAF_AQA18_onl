package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {

    private final By overViewPageLocator = By.xpath("//span[contains(text(),'Checkout: Overview')]");
    private final By finishButtonLocator = By.id("finish");

    public WebElement getFinishButton(){
        return driver.findElement(finishButtonLocator);
    }

    @Override
    protected By getPageIdentifier() {
        return overViewPageLocator;
    }

    public OverviewPage(WebDriver driver){
        super(driver);
    }
}
