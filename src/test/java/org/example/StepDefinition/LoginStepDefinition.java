package org.example.StepDefinition;

import org.example.Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;


public class LoginStepDefinition {
    Hooks hook=new Hooks();
    LoginPage page=new LoginPage(hook.driver);


    @Given("User navigates to the login page")
    public void navigate() throws InterruptedException {

        hook.driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
    }

    @When("^User enters email \"(.*)\"$")
    public void enterEmail(String mail){

        page.enterEmail(mail);
    }

    @And("^User enter password \"(.*)\"$")
    public void enterPassword(String password){

        page.enterPassword(password);
    }

    @And("User press login button")
    public void pressLoginBtn() throws InterruptedException {

        page.pressLoginBtn();
        Thread.sleep(2000);
    }

    @Then("user login to the system successfully")
    public void checkValidLogin(){
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(hook.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"));
        soft.assertTrue(hook.driver.findElement(By.className("ico-account")).isDisplayed());
        soft.assertAll();

    }
    @Then("user could not login to the system successfully")
    public void checkInvalidLogin(){
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(hook.driver.findElement(By.className("message-error")).getText().contains("Login was unsuccessful."));
        String col=hook.driver.findElement(By.className("message-error")).getCssValue("color");
        soft.assertTrue(Color.fromString(col).asHex().equals("#e4434b"));
        soft.assertAll();

    }


}
