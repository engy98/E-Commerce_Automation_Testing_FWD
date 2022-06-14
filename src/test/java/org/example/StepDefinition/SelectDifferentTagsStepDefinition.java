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

public class SelectDifferentTagsStepDefinition {
    Hooks hook=new Hooks();
    LoginPage loginPage=new LoginPage(hook.driver);
    UserAccountPage page=new UserAccountPage(hook.driver);


    @Given("login")
    public void login() throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
        loginPage.enterEmail("a@a.com");
        loginPage.enterPassword("12345678");
        loginPage.pressLoginBtn();
        Thread.sleep(2000);
    }

    @When("^User Select Category \"(.*)\"$")
    public void selectCategory(String category) throws InterruptedException {
        page.chooseCategory(category, " ");
    }

    @And("^User press \"(.*)\" tag$")
    public void selectTag(String tag) throws InterruptedException {
        page.selectTag(tag);
    }

    @Then("^the \"(.*)\" tag will be displayed in the title$")
    public void checkTag(String tag){
        page.checkTag(tag);
    }

}
