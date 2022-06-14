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

public class FilterWithColorStepDefinition {
    WebDriver driver;
    LoginPage loginPage;
    UserAccountPage page;

    @Before("@fil")
    public void openBrowser(){
        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        page=new UserAccountPage(driver);
    }

    @Given("User Login")
    public void login() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/login");
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

    @After("#fil")
    public void closeBrowser(){
        this.driver.quit();
    }
}
