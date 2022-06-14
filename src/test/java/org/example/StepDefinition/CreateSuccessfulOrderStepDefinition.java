package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import org.example.Pages.PaymentPage;
import org.example.Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateSuccessfulOrderStepDefinition {
    Hooks hook=new Hooks();
    LoginPage loginpage=new LoginPage(hook.driver);
    UserAccountPage page=new UserAccountPage(hook.driver);
    PaymentPage payPage=new PaymentPage(hook.driver);


    @Given("User Log In")
    public void navigate() throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
        loginpage.enterEmail("a@a.com");
        loginpage.enterPassword("12345678");
        loginpage.pressLoginBtn();
        Thread.sleep(2000);
    }

    @When("^Select Category \"(.*)\"$")
    public void selectCategory(String cat) throws InterruptedException {
        page.chooseCategory(cat," ");
    }
    @And("^Add product to shopping cart \"(.*)\"$")
    public void addProduct(String pro) throws InterruptedException {
        page.addProductToShoppingCart(pro);
        Thread.sleep(2000);
        page.goToShoppingCart();
    }

    @And("agree and press check out btn")
    public void checkOut() throws InterruptedException {
        page.checkOut();
    }
    @And("fill payment information")
    public void paymentInfo() throws InterruptedException {
        payPage.fillPaymentInfo("engy","heshmat","a@a.com","c","test","test",
                "tt","01232001253");

    }
    @And("select payment method and confirm")
    public void confirm() throws InterruptedException {
        Thread.sleep(5000);
        payPage.paymentMethod();
        Thread.sleep(5000);
    }
    @Then("see success msg")
    public void check(){
        payPage.checkTitle();
    }

}
