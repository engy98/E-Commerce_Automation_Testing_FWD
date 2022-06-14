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
    WebDriver driver;
    LoginPage loginpage;
    UserAccountPage page;

    @Before("@slid")
    public void openBrowser(){

        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginpage=new LoginPage(driver);
        page=new UserAccountPage(driver);
    }
    @Given("^user clicks on the slider \"(.*)\"$")
    public void clickSlider(String num){
        driver.navigate().to("https://demo.nopcommerce.com/");
        page.getSlider(Integer.parseInt(num));
    }
    @Then("^the url will be changed \"(.*)\"$")
    public void checkUrl(String url){

        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }
    @After("@slid")
    public void closeBrowser(){

        driver.quit();
    }

}
