package org.example.StepDefinetion;

import Pages.LoginPage;
import Pages.PaymentPage;
import Pages.UserAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateSuccessfulOrderStepDefinition {
    WebDriver driver;
    LoginPage loginpage;
    UserAccountPage page;
    PaymentPage payPage;

    @Before("@suc")
    public void openBrowser(){

        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginpage=new LoginPage(driver);
        page=new UserAccountPage(driver);
        payPage=new PaymentPage(driver);
    }

    @Given("User Log In")
    public void navigate() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/login");
        Thread.sleep(2000);
        loginpage.enterEmail("a@a.com");
        loginpage.enterPassword("12345678");
        loginpage.pressLoginBtn();
        Thread.sleep(2000);
    }

    @When("^Select Category \"(.*)\"$")
    public void selectCategory(String cat) throws InterruptedException {
        page.chooseCategory(cat," ");
    }
    @And("^Add product to shopping cart \"(.*)\"$")
    public void addProduct(String pro) throws InterruptedException {
        page.addProductToShoppingCart(pro);
        Thread.sleep(2000);
        page.goToShoppingCart();
    }

    @And("agree and press check out btn")
    public void checkOut() throws InterruptedException {
        page.checkOut();
    }
    @And("fill payment information")
    public void paymentInfo() throws InterruptedException {
        payPage.fillPaymentInfo("engy","heshmat","a@a.com","c","test","test",
                "tt","01232001253");

    }
    @And("select payment method and confirm")
    public void confirm() throws InterruptedException {
        Thread.sleep(5000);
        payPage.paymentMethod();
        Thread.sleep(5000);
    }
    @Then("see success msg")
    public void check(){
        payPage.checkTitle();
    }
    @After("@suc")
    public void closeDriver(){
        driver.quit();
    }
}
