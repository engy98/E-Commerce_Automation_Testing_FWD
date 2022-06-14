package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import org.example.Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class SwitchCurrenciesStepDefinition {
    WebDriver driver;
    LoginPage loginpage;
    UserAccountPage page;

    @Before("@cur")
    public void openBrowser(){

        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginpage=new LoginPage(driver);
        page=new UserAccountPage(driver);
    }



    @When("User login to his account")
    public void login() throws InterruptedException {
        loginpage.enterEmail("a@a.com");
        loginpage.enterPassword("12345678");
        loginpage.pressLoginBtn();
        Thread.sleep(2000);
    }

    @Given("^User press the currencies list and Select the \"(.*)\" currency$")
    public void pressCurrenciesList(String cur){
        driver.navigate().to("https://demo.nopcommerce.com/");
        page.pressCurrenciesList(cur);
    }


    @Then("^The currency of the prices of the products will be \"(.*)\"$")
    public void checkCurrency(String currency){
        int count=driver.findElements(By.className("actual-price")).size();
        List<WebElement> prices=driver.findElements(By.className("actual-price"));

        for (int i=0;i<count;i++){
            Assert.assertTrue(prices.get(i).getText().contains(currency));
        }
    }

    @After("@cur")
    public void closeDriver(){
        this.driver.quit();
    }
}
