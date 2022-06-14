package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    WebDriver driver;
   // Select day;
   // Select month;
   // Select year;
    public RegistrationPage(WebDriver driver){
        this.driver=driver;


        PageFactory.initElements(driver,this);
       // day=new Select(driver.findElement(By.name("DateOfBirthDay")));
       // month=new Select(driver.findElement(By.name("DateOfBirthMonth")));
       // year=new Select(driver.findElement(By.name("DateOfBirthYear")));
    }

    @FindBy(className = "ico-login")
    WebElement loginLink;

    @FindBy(id="gender-male")
    WebElement male;

    @FindBy(id="gender-female")
    WebElement female;

    @FindBy(id="FirstName")
    WebElement firstName;

    @FindBy(id="LastName")
    WebElement lastName;

    @FindBy(name="DateOfBirthDay")
    WebElement day;


    @FindBy(name = "DateOfBirthMonth")
    WebElement month;


    @FindBy(name = "DateOfBirthYear")
    WebElement year;


    @FindBy(id = "Email")
    WebElement mail;

    @FindBy(id = "Company")
    WebElement company;

    @FindBy(id = "Newsletter")
    WebElement newsLetter;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement passwordConfirmation;

    @FindBy(id = "register-button")
    WebElement registerBtn;



    public void selectBirthDate(){
        WebElement birthDay = driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(birthDay);
        select.selectByIndex(10);
       // this.day.sendKeys("12");
        WebElement birthMonth = driver.findElement(By.name("DateOfBirthMonth"));
        Select selectm = new Select(birthMonth);
        selectm.selectByValue("3");
        //this.month.sendKeys("j");
        WebElement birthYear = driver.findElement(By.name("DateOfBirthYear"));
        Select selecty = new Select(birthYear);
        selecty.selectByVisibleText("1998");
        //this.year.sendKeys("1");
    }

    public void selectFemale(){
        female.click();
    }

    public void selectMale(){
        male.click();
    }

    public void enterFirstName(String name){
        firstName.sendKeys(name);
    }
    public void enterLastName(String name){
        lastName.sendKeys(name);
    }

    public void enterCompanyName(String name){
        company.sendKeys(name);
    }

    public void enterMail(String mail){
        this.mail.sendKeys(mail);
    }

    public void checkNewsLetter(){
        if(newsLetter.isSelected())
        {

        }else {
            newsLetter.click();
        }

    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void confirmPassword(String password){
        this.passwordConfirmation.sendKeys(password);
    }

    public void pressRegister(){
        registerBtn.click();
    }
}
