package org.example.StepDefinetion;

import Pages.LoginPage;
import Pages.ResetPasswordPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;

public class ResetPasswordStepDefinition {
    WebDriver driver;
    LoginPage loginpage;
    ResetPasswordPage page;

    @Before("@res")
    public void openBrowser(){

        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginpage=new LoginPage(driver);
        page=new ResetPasswordPage(driver);
    }

    @Given("User navigates to login page")
    public void navigatesToLoginPage () throws InterruptedException {

        driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
    }

    @When("User press forgot password button")
    public void pressForgotPasswordBtn() throws InterruptedException {
        loginpage.pressForgetPassword();
        Thread.sleep(2000);
    }

    @And("^User enters his valid email \"(.*)\"$")
    public void enterEmail(String mail){
        page.enterMail(mail);
    }
    @And("User press recover button")
    public void pressRecoverBtn() throws InterruptedException {
        page.pressRecoverBtn();
    }
    @Then("^User see success message \"(.*)\"$")
    public void checkSuccessMsg(String msg){
        page.checkSuccessMsg(msg);
    }

    @After("@res")
    public void closeBrowser(){
        this.driver.quit();
    }
}
