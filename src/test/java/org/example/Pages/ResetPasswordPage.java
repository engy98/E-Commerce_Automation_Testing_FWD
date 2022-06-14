package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResetPasswordPage {
    WebDriver driver;

    public ResetPasswordPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "Email")
    WebElement mail;

    @FindBy(name = "send-email")
    WebElement recoverBtn;

    @FindBy(className = "bar-notification")
    WebElement successMsg;

    public void enterMail(String mail){

        this.mail.clear();
        this.mail.sendKeys(mail);
    }

    public void pressRecoverBtn() throws InterruptedException {
        this.recoverBtn.click();
        Thread.sleep(1000);
    }

    public void checkSuccessMsg(String msg){
        Assert.assertTrue(successMsg.getText().contains(msg),"success msg");
    }
}
