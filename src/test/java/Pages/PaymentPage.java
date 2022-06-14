package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PaymentPage {
    WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement fName;
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement mail;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement add1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement code;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement num;

    @FindBy(name = "save")
    WebElement conBtn;

    public void fillPaymentInfo(String fName,String lName,String mail,String country,String city, String add1,
                                String code,String num) throws InterruptedException {
        if(driver.findElement(By.id("billing-address-select")).isDisplayed()){
            driver.findElement(By.id("billing-address-select")).sendKeys("n");
            driver.findElement(By.id("billing-address-select")).sendKeys(Keys.ENTER);
            Thread.sleep(5000);

        }

            this.fName.sendKeys(fName);
            this.lName.sendKeys(lName);
            this.mail.sendKeys(mail);
            this.country.sendKeys(country);
            this.country.sendKeys(Keys.ENTER);
            this.city.sendKeys(city);
            this.add1.sendKeys(add1);
            this.code.sendKeys(code);
            this.num.sendKeys(num);
            this.conBtn.click();


    }
    public void paymentMethod() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button")).click();

    }
    public void checkTitle(){
        List<WebElement> titles= driver.findElements(By.className("title"));
        Assert.assertTrue(titles.get(0).getText().contains("Your order has been successfully processed!"),"msg");
    }

}
