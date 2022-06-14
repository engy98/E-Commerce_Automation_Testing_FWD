package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

       WebDriver driver;
    Hooks hook=new Hooks();


        public LoginPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);

        }


        @FindBy(id = "Email")
        WebElement mail;

        @FindBy(id="Password")
        WebElement password;

        @FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
        WebElement loginBtn;

        @FindBy(linkText="Forgot password?")
        WebElement forgetPasswordBtn;





        @FindBy(className = "ico-logout")
        WebElement logOutBtn;



        public void enterEmail(String mail){
            this.mail.clear();
            this.mail.sendKeys(mail);
        }

        public void enterPassword(String password){

            this.password.clear();
            this.password.sendKeys(password);
        }

        public void pressLoginBtn(){

            this.loginBtn.click();
        }

        public void pressForgetPassword(){

            forgetPasswordBtn.click();
        }
        public void checkLogOutBtn(){
            Assert.assertTrue(logOutBtn.getText().contains("out"),"logout btn");
        }



    }


