package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;



public class UserAccountPage {
    WebDriver driver;

    public UserAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "small-searchterms")
    WebElement textField;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div[2]/form/button")
    WebElement searchBtn;

    @FindBy(className = "product-title")
    WebElement product;

    @FindBy(id = "customerCurrency")
    WebElement currencyList;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[1]/div/select/option[1]")
    WebElement USDollar;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[1]/div/select/option[2]")
    WebElement Euro;

    @FindBy(className = "price")
    WebElement price;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")
    WebElement title;

    @FindBy(className = "cart-label")
    WebElement shoppingCart;

    @FindBy(className = "wishlist-label")
    WebElement wishList;




    public void enterProductName(String name){
        textField.sendKeys(name);
    }

    public void pressSearchBtn(){
        searchBtn.click();
    }



    public void pressCurrenciesList(String currency){

        currencyList.click();
        Select select=new Select(currencyList);
        select.selectByVisibleText(currency);
    }


    public void chooseCategory(String category, String sub) throws InterruptedException {

        List<WebElement> subLists=driver.findElements(By.className("sublist"));
        WebElement categoryName = driver.findElement(By.linkText(category));
        int flag=0;
        new Actions(driver)
                .moveToElement(categoryName)
                .perform();

        Thread.sleep(2000);
        for (WebElement i: subLists){
            if(i.isDisplayed()){

                WebElement subC=driver.findElement(By.partialLinkText(sub));
                subC.click();
                flag=1;
                break;
            }
        }
        if (flag==0){

            categoryName.click();
        }
        Thread.sleep(5000);



    }
    public void checkTitle(String category){
        Assert.assertTrue(title.getText().contains(category),"title");
    }
    //there is many links with same text

    public void getSlider(int count){
        if (count==1){
            driver.findElement(By.xpath("//div[@class='nivo-controlNav']//a[1]")).click();
            driver.findElement(By.cssSelector("#nivo-slider > a:nth-child(1)")).click();
        }else {
            driver.findElement(By.xpath("//div[@class='nivo-controlNav']//a[2]")).click();
            driver.findElement(By.cssSelector("#nivo-slider > a:nth-child(2)")).click();
        }

    }

    public void selectColor(String color) throws InterruptedException {

        List<WebElement>colors=driver.findElements(By.className("attribute-square"));
        for (WebElement i: colors){

            //System.out.println(i.getCssValue("color"));
            if(i.getCssValue("background-color").equals(color)){
                i.click();
                Thread.sleep(5000);
                break;
            }
        }

    }
    public void checkColor(String color){
        List<WebElement>colors=driver.findElements(By.className("attribute-square"));
        List<WebElement>boxes=driver.findElements(By.className("item"));
        int count=0;
        for (WebElement i: colors){
            count++;
            if(i.getCssValue("background-color").equals(color)){
                 switch (count){
                     case 1:Assert.assertTrue(driver.findElement(By.id("attribute-option-14")).isSelected());
                        break;
                     case 2:Assert.assertTrue(driver.findElement(By.id("attribute-option-15")).isSelected());
                        break;
                     case 3:Assert.assertTrue(driver.findElement(By.id("attribute-option-16")).isSelected());
                     break;
                 }
                //Assert.assertTrue(boxes.get(colors.indexOf(i)).isSelected(),"selected");

                break;
            }
        }
    }
    public void addProductToShoppingCart(String product) throws InterruptedException {
        List<WebElement> products=driver.findElements(By.className("product-title"));
        List<WebElement> addBtns=driver.findElements(By.className("button-2"));
        int count=0;
        for (WebElement i: addBtns){
              //System.out.println(i.getText());
            if(i.getText().contains("ADD TO CART")){
                count++;
                if(i.isDisplayed()) {
                    //System.out.println(addBtns.indexOf(i));
                    if(products.get(count-1).getText().contains(product)){
                        //System.out.println(products.get(addBtns.indexOf(i)).getText());
                        i.click();
                        Thread.sleep(5000);
                        //System.out.println(driver.findElement(By.className("add-to-cart-panel")).getText());
                        if (driver.findElements(By.className("page-title")).isEmpty()){
                            driver.findElement(By.className("add-to-cart-panel")).click();
                        }
                        break;
                    }
                }
        }
    }
    Thread.sleep(5000);
    }
    public void goToShoppingCart(){
        shoppingCart.click();
    }
    public void checkShoppingCart(String product1,String product2){
        List<WebElement> products=driver.findElements(By.className("product-name"));
        //Assert.assertTrue(shoppingCartMsg.getText().contains("The product has been added to your"), "msg");
        int tmp=0;
        for (WebElement i: products){
            if (i.isDisplayed()){
                tmp++;
                if (tmp==1){
                    Assert.assertTrue(i.getText().contains(product1));
                }else {
                    Assert.assertTrue(i.getText().contains(product2));
                    break;
                }

            }

        }

    }

    public void selectTag(String tag) throws InterruptedException {
        driver.findElement(By.partialLinkText(tag)).click();

        Thread.sleep(5000);
    }

    public void checkTag(String tag){
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1"))
                .getText().contains(tag),"tag");
    }

    public void addProductToWishList(String pro) throws InterruptedException {
        List<WebElement> products=driver.findElements(By.className("product-title"));
        List<WebElement> addBtns=driver.findElements(By.className("add-to-wishlist-button"));
        int count=0;
        for (WebElement i: addBtns){

                    if(products.get(addBtns.indexOf(i)).getText().contains(pro)){
                        //System.out.println(products.get(addBtns.indexOf(i)).getText());
                        i.click();
                       // System.out.println("mmmmmmmmmm");

                        //System.out.println(driver.findElement(By.className("add-to-cart-panel")).getText());
                        break;
                    }
                }
            }


    public void goToWishlist(){
        wishList.click();
    }
    public void checkWishlist(String product){
        //driver.findElement(By.linkText(product)).click();
        List<WebElement> products=driver.findElements(By.className("product-name"));
        //Assert.assertTrue(shoppingCartMsg.getText().contains("The product has been added to your"), "msg");

        for (WebElement i: products){
            if (i.isDisplayed()){
                    Assert.assertTrue(i.getText().contains(product));
                   break;
            }

        }

    }
    public void addProductToCompareList(String pro){
        List<WebElement> products=driver.findElements(By.className("product-title"));
        List<WebElement> addBtns=driver.findElements(By.className("button-2"));
        int count=0;
        for (WebElement i: addBtns){
            //System.out.println(i.getText());
            if(i.getText().contains("Add to compare list")){
                count++;
                if(i.isDisplayed()) {
                    //System.out.println(addBtns.indexOf(i));
                    if(products.get(count-1).getText().contains(pro)){
                        //System.out.println(products.get(addBtns.indexOf(i)).getText());
                        i.click();
                        //Thread.sleep(5000);
                        //System.out.println(driver.findElement(By.className("add-to-cart-panel")).getText());
                        break;
                    }
                }
            }

        }}


    public void checkCompareList(String product1,String product2){
        List<WebElement> products=driver.findElements(By.className("product-name"));
        //Assert.assertTrue(shoppingCartMsg.getText().contains("The product has been added to your"), "msg");
        int tmp=0;
        for (WebElement i: products){
            if (i.isDisplayed()){
                tmp++;
                if (tmp==1){
                    Assert.assertTrue(i.getText().contains(product1));
                }else {
                    Assert.assertTrue(i.getText().contains(product2));
                    break;
                }

            }

        }}
    public void checkOut() throws InterruptedException {
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);
    }
    public void followUs(String media) throws InterruptedException {
        driver.findElement(By.linkText(media)).click();
        Thread.sleep(2000);
    }


}
