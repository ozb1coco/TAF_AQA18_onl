package baseEntities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    protected abstract WebElement getPageIdentifier();

    public boolean isPageOpened() {
        return getPageIdentifier().isDisplayed();
    }
}