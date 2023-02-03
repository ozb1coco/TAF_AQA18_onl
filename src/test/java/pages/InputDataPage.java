package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InputDataPage {

    private By firstNameInputLocator = By.id("first-name");
    private By lastNameInputLocator = By.id("last-name");
    private By zipCodeInputLocator = By.id("postal-code");
    private By continueButtonLocator = By.id("continue");

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator).shouldBe(visible);
    }

    public SelenideElement getFirstNameInput() {
        return $(firstNameInputLocator).shouldBe(visible);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInputLocator).shouldBe(visible);
    }

    public SelenideElement getZipCodeInput() {
        return $(zipCodeInputLocator).shouldBe(visible);
    }
}
