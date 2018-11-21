package com.pageobjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class ShippingInfo_page {


    WebDriver driver;

    public ShippingInfo_page(WebDriver ldriver) {
        this.driver = ldriver;
    }



    @FindBy(how = How.ID, using = "given-name")
    WebElement Firsrtname;

    @FindBy(how = How.ID, using = "family-name")
    WebElement Lastname;

    @FindBy(how = How.ID, using = "address")
    WebElement Address;

    @FindBy(how = How.ID, using = "address-level2")
    WebElement City;

    @FindBy(how = How.NAME, using = "state")
    WebElement State;

    @FindBy(how = How.ID , using = "address-form-email")
    WebElement Email;

    @FindBy(how = How.ID,using = "tel")
    WebElement Phone;

    @FindBy(how = How.ID,using = "postal-code")
    WebElement Zipcode;

    @FindBy(how = How.XPATH,using = ".//*[@class='hbc-button hbc-button--primary address-form__submit-button']")
    WebElement ConfirmAdress;




    public void firstname()
    {
        Firsrtname.sendKeys("Sanjay");
    }

    public void lastname()
    {

        Actions actions = new Actions(driver);
        actions.moveToElement(Lastname);
        actions.click();
        actions.sendKeys("SOME DATA");
        actions.build().perform();
        //Lastname.sendKeys("S");
    }


    public void address ()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(Address);
        actions.click();
        actions.sendKeys("410 5TH AVENEU");
        actions.build().perform();
    }

    public void city()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(City);
        actions.click();
        actions.sendKeys("NEW YORK");
        actions.build().perform();
    }


    public void selectstate() {
        Select drop = new Select(State);
        drop.selectByValue("NY");

    }

    public void email()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(Email);
        actions.click();
        actions.sendKeys("accept@fraudtest.com");
        actions.build().perform();

    }

    public void phone()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(Phone);
        actions.click();
        actions.sendKeys("939473847383");
        actions.build().perform();
    }

    public void Postal()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(Zipcode);
        actions.click();
        actions.sendKeys("10003");
        actions.build().perform();
    }

    public void confirmAdd()
    {


        ConfirmAdress.click();



    }
}
