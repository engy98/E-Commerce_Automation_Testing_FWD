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
    WebDriver driver;
    LoginPage loginpage;
    UserAccountPage page;
    PaymentPage payPage;

    @Before("@fol")
    public void openBrowser(){

        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginpage=new LoginPage(driver);
        page=new UserAccountPage(driver);
        payPage=new PaymentPage(driver);
    }

    @Given("^press the social media \"(.*)\"$")
    public void followUs(String media) throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        page.followUs(media);
    }
    @Then("^new window with this link \"(.*)\" will be opened$")
    public void checkFollowing(String url) throws InterruptedException {
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
        driver.close();
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
    }

    @After("@fol")
    public void close(){
        driver.quit();
    }

}
