package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class UserStep extends BaseStep {
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;
    private final CheckoutPage checkoutPage;
    private final OverviewPage overviewPage;
    private final CheckoutCompletePage checkoutCompletePage;
    private final CartPage cartPage;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        cartPage = new CartPage(driver);
    }

    public void login(String email, String psw) {
        loginPage.getUsernameInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public void inventory(){
        inventoryPage.getAddToCartButton().click();
        inventoryPage.getButtonIntoBucket().click();
    }

    public void cartPageFinish(){
        cartPage.getCheckoutButton().click();
    }
    public void addInfoToCheckoutPage(String firstname, String lastname, String postalCode){
        checkoutPage.getFirstNameCheckout().sendKeys(firstname);
        checkoutPage.getLastNameCheckout().sendKeys(lastname);
        checkoutPage.getPostalCodeCheckout().sendKeys(postalCode);
        checkoutPage.getContinueCheckoutButton().click();
    }

    public void finishOverview(){
        overviewPage.getFinishButton().click();
    }
    public InventoryPage loginSuccessful(String username, String psw){
        login(username, psw);
        return new InventoryPage(driver);
    }

    public CartPage inventorySuccessful(){
        inventory();
        return new CartPage(driver);
    }

    public CheckoutPage CartPageSuccessful(){
        cartPageFinish();
        return new CheckoutPage(driver);
    }

    public OverviewPage goingIntoOverviewPageSuccessful(String firstname, String lastname, String postalCode){
        addInfoToCheckoutPage(firstname, lastname, postalCode);
        return new OverviewPage(driver);
    }

    public CheckoutCompletePage finishOverviewIsSuccessful(){
        finishOverview();
        return new CheckoutCompletePage(driver);
    }

    public boolean backHome(){
        checkoutCompletePage.getBackHomeButton().click();
        return true;
    }


}
