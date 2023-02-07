package stepDefs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import factory.BrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.OverviewPage;
import steps.CheckoutSteps;
import steps.UserSteps;

public class E2EStepDefsSouceDemo extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private CheckoutSteps checkoutSteps;
    private OverviewPage overviewPage;
    public E2EStepDefsSouceDemo(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("open page of log in")
    public void openLogInPage(){
        driver.get(ReadProperties.getUrl());
    }

    @When("user {string} with password {string} logged in")
    public void userLoggedIn(String username, String password){
        UserSteps userSteps = new UserSteps(driver);
        checkoutSteps = userSteps.successfulLogin(username,password);
    }
    @And("add stuff to the cart")
    public void userAddStuffToCart(){
        checkoutSteps.addToCartProduct();
    }
    @And("open cart page")
    public void userOpenCartPage(){
        checkoutSteps.goToCartPage();
    }
    @And("open data page")
    public void userOpenDataPage(){
        checkoutSteps.clickButtonCheckOut();
    }
    @When("user input personal data firstname {string}, lastname {string}, zipcode {string}")
    public void userInputPersonalData(String firstname, String lastname, String zipcode){
        checkoutSteps.dataInputAndGoToOverview(firstname, lastname, zipcode);
    }
    @Then("finish page")
    public void finishPage(){
        Assert.assertTrue(checkoutSteps.clickFinish().isPageOpened());
    }
}
