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

public class HomeSliderStepDef {
    Hooks  hook=new Hooks();
    LoginPage loginpage=new LoginPage(hook.driver);
    UserAccountPage page=new UserAccountPage(hook.driver);


    @Given("^user clicks on the slider \"(.*)\"$")
    public void clickSlider(String num){
        hook.driver.navigate().to("https://demo.nopcommerce.com/");
        page.getSlider(Integer.parseInt(num));
    }
    @Then("^the url will be changed \"(.*)\"$")
    public void checkUrl(String url){

        Assert.assertTrue(hook.driver.getCurrentUrl().contains(url));
    }


}
