

package com.pageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;


public class Home_page {

    WebDriver driver;

    public Home_page(WebDriver ldriver)
    {
        this.driver=ldriver;
    }



    @FindBy(how = How.XPATH ,using = ".//*[@href='http://qa.saks.com/main/context_chooser.jsp']")
    WebElement ClosePopup;

    @FindBy(how = How.XPATH,using = ".//*[@class='hbc-ship-to__copy']")
    WebElement ChangeCountry;

    @FindBy(how = How.XPATH,using = ".//*[@class='text-decor-border-bottom']")
    WebElement SwitchTous;

    public void Close_popup(){
        ClosePopup.click();
    }

    public void Change_country(){
        ChangeCountry.click();
    }

    public void SwitchToUS(){
        SwitchTous.click();
    }
}
