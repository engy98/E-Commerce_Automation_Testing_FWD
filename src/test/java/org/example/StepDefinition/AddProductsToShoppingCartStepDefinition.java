package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import org.example.Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductsToShoppingCartStepDefinition {
    Hooks hook=new Hooks();
    LoginPage loginPage=new LoginPage(hook.driver);
    UserAccountPage page=new UserAccountPage(hook.driver);


    @Given("User login to app")
    public void login() throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
        loginPage.enterEmail("a@a.com");
        loginPage.enterPassword("12345678");
        loginPage.pressLoginBtn();
        Thread.sleep(2000);
    }
    @When("^User select category \"(.*)\" to add to shopping cart$")
    public void search(String category) throws InterruptedException {
        page.chooseCategory(category," ");
        Thread.sleep(2000);
    }
    @And("^User add a product \"(.*)\" to his shopping cart$")
    public void addProduct1(String name) throws InterruptedException {
        page.addProductToShoppingCart(name);
    }
    @And("^User add another product \"(.*)\" to his shopping cart from category \"(.*)\"$")
    public void addProduct2( String name, String category) throws InterruptedException {
        String sub=" ";
        page.chooseCategory(category,sub);
        page.addProductToShoppingCart(name);
    }
    @And("User open shopping cart")
    public void openShoppingCart() throws InterruptedException {
        page.goToShoppingCart();
        Thread.sleep(2000);
    }
    /*@Then("User see msg")
    public void checkMsg(){
        page.cartMsg();
    }*/
    @Then("^User see the products \"(.*)\" and \"(.*)\" that he added$")
    public void checkProducts(String p1,String p2){
        page.checkShoppingCart(p1,p2);
    }


}
