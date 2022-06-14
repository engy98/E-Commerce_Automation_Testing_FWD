package org.example.StepDefinition;

import org.example.Pages.RegistrationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class RegisterStepDefinition {

    WebDriver driver;
    RegistrationPage page;

    @Before("@reg")
    public void openBrowser(){

        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        page=new RegistrationPage(driver);
    }

    @Given("User navigates to the registration page")
    public void navigate() throws InterruptedException {

        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
        driver.findElement((By.className("ico-register"))).click();
        Thread.sleep(2000);
    }

    @When("User enters the gender female")
    public void selectFemale(){
        page.selectFemale();
    }

    @And("^User enters the first name \"(.*)\"$")
    public void enterFirstName(String name){
        page.enterFirstName(name);
    }

    @And("^User enters the last name \"(.*)\"$")
    public void enterLastName(String name){
        page.enterLastName(name);
    }

    @And("User enters the birth date")
    public void selectDate(){
        page.selectBirthDate();
    }

    @And("^User enters the email \"(.*)\"$")
    public void enterEmail(String mail){
        page.enterMail(mail);
    }

    @And("^User enters the company name \"(.*)\"$")
    public void enterCompany(String name){
        page.enterCompanyName(name);
    }

    @And("User selects the newsletter")
    public void selectNewsLetter(){
        page.checkNewsLetter();
    }

    @And("^User enters password \"(.*)\" and confirmation password \"(.*)\"$")
    public void enterPassword(String password,String confirmation){
        page.enterPassword(password);
        page.confirmPassword(confirmation);
    }

    @And("User press register button")
    public void pressRegister() throws InterruptedException {
        page.pressRegister();
        Thread.sleep(2000);
    }


    @Then("success message is displayed")
    public void checkMsg(){
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(driver.findElement(By.className("result")).getText().contains("Your registration completed"),"success msg assertion");
        soft.assertTrue(driver.findElement(By.className("result")).getCssValue("color").equals("rgba(76, 177, 124, 1)"));
        soft.assertAll();
    }


    @After("@reg")
    public void closeDriver(){
        this.driver.quit();
    }
}
