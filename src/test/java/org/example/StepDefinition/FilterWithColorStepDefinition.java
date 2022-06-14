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

public class FilterWithColorStepDefinition {
    Hooks hook=new Hooks();
    LoginPage loginPage=new LoginPage(hook.driver);
    UserAccountPage page=new UserAccountPage(hook.driver);


    @Given("User Login")
    public void login() throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
        loginPage.enterEmail("a@a.com");
        loginPage.enterPassword("12345678");
        loginPage.pressLoginBtn();
        Thread.sleep(2000);
    }

    @When("^User select category \"(.*)\" and subcategory \"(.*)\"$")
    public void selectCategory(String category,String sub) throws InterruptedException {
        page.chooseCategory(category,sub);
    }

    @And("^User filter with color red \"(.*)\"$")
    public void filterWithColor(String color) throws InterruptedException {
        page.selectColor(color);
    }
    @Then("^The color \"(.*)\" will be selected$")
    public void checkColor(String color){
        page.checkColor(color);
    }

}
