package com.pageobjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

public class SkuSearchpage {

    WebDriver driver;

    public SkuSearchpage (WebDriver Qdriver)
    {
        this.driver=Qdriver;
    }

    @FindBy(how = How.XPATH, using = ".//*[@name='SearchString']")
    WebElement Search;


    public void SearchSku()
    {
        Search.sendKeys("0467558208102",Keys.ENTER);
    }


}


