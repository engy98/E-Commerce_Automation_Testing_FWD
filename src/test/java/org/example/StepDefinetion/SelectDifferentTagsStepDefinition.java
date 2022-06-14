package org.example.StepDefinetion;

import Pages.LoginPage;
import Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDifferentTagsStepDefinition {
    WebDriver driver;
    LoginPage loginPage;
    UserAccountPage page;

    @Before("@tag")
    public void openBrowser(){
        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        page=new UserAccountPage(driver);
    }

    @Given("login")
    public void login() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/login");
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

    @After("@tag")
    public void closeBrowser(){
        this.driver.quit();
    }
}
