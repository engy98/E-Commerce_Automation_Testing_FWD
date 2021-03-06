package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import org.example.Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelectCategoryStepDefinition {
    Hooks hook=new Hooks();
    UserAccountPage page=new UserAccountPage(hook.driver);



    @Given("^User hover category name \"(.*)\" and press subcategory \"(.*)\" if found$")
    public void selectCategory(String category,String sub) throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/");
        page.chooseCategory(category,sub);
        Thread.sleep(2000);
    }
    @Then("^the category name \"(.*)\" will be displayed$")
    public void checkTitle(String title){
        page.checkTitle(title);
        Assert.assertTrue(hook.driver.getCurrentUrl().contains(title.toLowerCase().trim()));
    }


}
