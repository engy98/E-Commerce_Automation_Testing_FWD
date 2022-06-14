package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import org.example.Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCompareListStepDefinition {
    Hooks hook=new Hooks();
    LoginPage loginPage=new LoginPage(hook.driver);
    UserAccountPage page=new UserAccountPage(hook.driver);


    @Given("login to the app")
    public void login() throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
        loginPage.enterEmail("a@a.com");
        loginPage.enterPassword("12345678");
        loginPage.pressLoginBtn();
        Thread.sleep(2000);
    }
    @When("^select the category \"(.*)\"$")
    public void selectCategory(String cat) throws InterruptedException {
        page.chooseCategory(cat," ");
    }
    @And("^User add a product \"(.*)\" to his compare list$")
    public void addProduct1(String pro) throws InterruptedException {
        page.addProductToCompareList(pro);
        Thread.sleep(2000);
    }
    @And("^User add another product \"(.*)\" to his compare list from category \"(.*)\"$")
    public void addProduct2(String pro,String cat) throws InterruptedException {
        page.chooseCategory(cat," ");
        page.addProductToCompareList(pro);
        Thread.sleep(1000);
    }
    @And("User open compare list")
    public void openComparelist() throws InterruptedException {
        hook.driver.findElement(By.linkText("product comparison")).click();
        Thread.sleep(2000);
    }
    @Then("^User see the products \"(.*)\" and \"(.*)\" in the compare list$")
    public void checkCompareList(String p1,String p2){
        page.checkCompareList(p1,p2);
    }

}
