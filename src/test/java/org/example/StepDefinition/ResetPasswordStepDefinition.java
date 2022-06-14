package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import org.example.Pages.ResetPasswordPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPasswordStepDefinition {
    Hooks hook=new Hooks();
    LoginPage loginpage=new LoginPage(hook.driver);
    ResetPasswordPage page=new ResetPasswordPage(hook.driver);


    @Given("User navigates to login page")
    public void navigatesToLoginPage () throws InterruptedException {

        hook.driver.navigate().to("https://demo.nopcommerce.com/login");
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

}
