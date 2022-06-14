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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddProductToWishlistStepDefinition {
    Hooks hook=new Hooks();
    LoginPage loginPage=new LoginPage(hook.driver);
    UserAccountPage page=new UserAccountPage(hook.driver);



    @Given("^User add a product \"(.*)\" to his wishlist$")
    public void addProduct(String pro) throws InterruptedException {
        hook.driver.navigate().to("https://demo.nopcommerce.com/");
        page.addProductToWishList(pro);
    }

   @Then("^the product added to the wishlist and see success msg \"(.*)\"$")
   public void checkMsg(String msg) throws InterruptedException {
       SoftAssert soft=new SoftAssert();
       Thread.sleep(1000);
       soft.assertTrue(hook.driver.findElement(By.id("bar-notification")).getText().contains(msg),"msg");
       String color=hook.driver.findElement(By.xpath("/html/body/div[5]/div")).getCssValue("background-color");
       soft.assertTrue(Color.fromString(color).asHex().equals("#4bb07a"),"color");
       soft.assertAll();

   }

    @When("user open wishlist")
    public void openWishlist(){
        WebDriverWait wait=new WebDriverWait(hook.driver, Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.invisibilityOf(hook.driver.findElement(By.id("bar-notification"))));
        page.goToWishlist();
    }
    @Then("^the product exist in wishlist \"(.*)\"$")
    public void checkWishlist(String p){
        page.checkWishlist(p);
    }

}
