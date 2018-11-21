package com.pageobjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class AddtoCart_page {

    WebDriver driver;


    public AddtoCart_page(WebDriver ldriver)
    {
        this.driver=ldriver;
    }


    @FindBy(how = How.XPATH,using = "//*[@class='hbc-button hbc-button--full hbc-button--primary']")
    WebElement Addtocart;

    @FindBy(how = How.XPATH,using = "//*[@class=\"hbc-button hbc-button--block hbc-button--primary\"]")
    WebElement Checkout;

    @FindBy(how = How.XPATH,using = ".//*[@href='/checkout/checkout.jsp']")
    WebElement Checkout2;

    @FindBy (how = How.XPATH , using = ".//*[@class='hbc-button hbc-button--secondary hbc-login__guest-checkout-btn']")
    WebElement SelectUser;

    //For multiaunatity
    @FindBy(how = How.XPATH,using = "//*[@class=\"spinbox__increment\"]")
    WebElement Increment;

    public void selectColor(String color) throws Exception {
        Thread.sleep(2000);
        WebElement selectColor=driver.findElement(By.xpath("//span[contains(text(),'"+color+"')]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;;
        js.executeScript("arguments[0].click();", selectColor);


    }


    public void Addtocart()
    {
        Addtocart.click();
    }

    public void Checkout()
    {
        Checkout.click();
    }

    public void Checkout2()
    {
        Checkout2.click();
    }

    public void select_user()
    {
        SelectUser.click();
    }
    public void Increment()
    {
        Increment.click();
    }
}
