package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import org.example.Pages.PaymentPage;
import org.example.Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class FollowUsStepDefinition {
    Hooks hook=new Hooks();
    UserAccountPage page=new UserAccountPage(hook.driver);


    @Given("^press the social media \"(.*)\"$")
    public void followUs(String media) throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
        page.followUs(media);
    }
    @Then("^new window with this link \"(.*)\" will be opened$")
    public void checkFollowing(String url) throws InterruptedException {
        ArrayList<String> tabs=new ArrayList<>(hook.driver.getWindowHandles());
        hook.driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(hook.driver.getCurrentUrl().contains(url));
        hook.driver.close();
        Thread.sleep(2000);
        hook.driver.switchTo().window(tabs.get(0));
    }


}
