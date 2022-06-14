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

public class SearchStepDefinition {
    WebDriver driver;
    LoginPage loginpage;
    UserAccountPage page;

    @Before("@search")
    public void openBrowser(){

        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        loginpage=new LoginPage(driver);
        page=new UserAccountPage(driver);
    }

    @Given("^User write the product name \"(.*)\" in the text field$")
    public void searchByName(String name) throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
        page.enterProductName(name);
        page.pressSearchBtn();
        Thread.sleep(2000);
    }


    @Then("^User see the product he searched for \"(.*)\"$")
    public void checkResult(String name){

        Assert.assertTrue(driver.getCurrentUrl().contains("search"));
        List<WebElement> products=driver.findElements(By.xpath("//h2[@class=\"product-title\"]//a"));
        for (WebElement pro:products){
            System.out.println(pro.getAttribute("href"));
            Assert.assertTrue(pro.getAttribute("href").contains(name));
        }
    }
    @Given("^User write the product sku \"(.*)\" in the text field$")
    public void searchBySku(String sku) throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);
        page.enterProductName(sku);
        page.pressSearchBtn();
        Thread.sleep(2000);
    }
    @When("User press the product")
    public void pressProduct() throws InterruptedException {
        driver.findElement(By.xpath("//h2[@class=\"product-title\"]//a")).click();
        Thread.sleep(7000);
    }
    @Then("^User see the sku of product he searched for \"(.*)\"$")
    public void checkSku(String sku){
       Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"sku\"]//span[2]")).getText().contains(sku));
    }

    @After("@search")
    public void closeBrowser(){
        this.driver.quit();
    }
}
