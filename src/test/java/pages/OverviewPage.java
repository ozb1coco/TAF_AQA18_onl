package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    private final By buttonFinishLocator = By.id("finish");
    private final By successfulOrderPageLocator = By.xpath("//*[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!']");

    public SelenideElement getButtonFinishLocator() {
        return $(buttonFinishLocator);
    }

    public SelenideElement successfulOrderPage() {
        return $(successfulOrderPageLocator);
    }
}