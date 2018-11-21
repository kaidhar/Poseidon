package com.pageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Payment_page {


    static WebDriver driver;

    public Payment_page (WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(how = How.XPATH,using = ".//*[@class=\"tab-label tab-label--active tab-label--radio\"]")
    WebElement Selecttype;

    @FindBy(how = How.ID,using = "ccnumber")
    static WebElement CCnumber;

    @FindBy(how = How.ID,using = "nameoncard")
    WebElement Ccname;

    @FindBy(how = How.ID,using = "month")
    WebElement CcMonth;

    @FindBy(how = How.ID,using = "cvc")
    WebElement Ccvv;

    @FindBy(how = How.XPATH,using = ".//*[@class='hbc-button hbc-button--primary hbc-checkout__page-submit-button']")
    WebElement CompletePay;

public void SelectType()
{
    Actions actions = new Actions(driver);
    actions.moveToElement(Selecttype);
    actions.click();
    actions.build().perform();

}

    public static WebElement cardnumber (String cardnumbers) {
        if (cardnumbers.equalsIgnoreCase("VISA"))
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(CCnumber);
            actions.click();
            actions.sendKeys("4895390000000013");
            actions.build().perform();
        }
        else if (cardnumbers.equalsIgnoreCase( "MASTERCARD" ))
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(CCnumber);
            actions.click();
            actions.sendKeys("5454545454545454");
            actions.build().perform();
        }
        else if(cardnumbers.equalsIgnoreCase( "AMEX" ))
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(CCnumber);
            actions.click();
            actions.sendKeys("373953192351004");
            actions.build().perform();
        }
        else if(cardnumbers.equalsIgnoreCase( "DISCOVER" ))
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(CCnumber);
            actions.click();
            actions.sendKeys("6011020000045098");
            actions.build().perform();
        }
        else if(cardnumbers.equalsIgnoreCase( "Storecard" ))
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(CCnumber);
            actions.click();
            actions.sendKeys("8091179005");
            actions.build().perform();
        }
        return  CCnumber;

    }


    public void CardName()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(Ccname);
        actions.click();
        actions.sendKeys("sanjay");
        actions.build().perform();

    }



    public void CardYear()
    {
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(CcMonth);
            actions.click();
            actions.sendKeys("122021");
            actions.build().perform();
        }


    }
    public void CardCvv()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(Ccvv);
        actions.click();
        actions.sendKeys("111");
        actions.build().perform();
    }

    public void confirmPayment()
    {
        CompletePay.click();
    }

}
