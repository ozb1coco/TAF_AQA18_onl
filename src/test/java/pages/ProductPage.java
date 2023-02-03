package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class ProductPage {
    private By addToCartStuffButtonLocator = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartButtonLocator = By.id("shopping_cart_container");

    public SelenideElement getAddToCartStuffButtonLocator() {
        return $(addToCartStuffButtonLocator);
    }
    public SelenideElement getCartButtonLocator(){
        return $(cartButtonLocator);
    }

}