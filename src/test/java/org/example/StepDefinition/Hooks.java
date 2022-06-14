package org.example.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.Pages.LoginPage;
import org.example.Pages.UserAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver=null;

    @Before
    public static void  openBrowser() throws InterruptedException {


        String chromePath =System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        if(driver==null){
            System.out.println("nullll");
        }else {
            System.out.println("notttttt");
        }

    }

    @After
    public static void closeBrowser(){
        driver.quit();
    }
}
