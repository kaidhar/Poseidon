package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;

public class OrderConfirm_page {
    WebDriver driver;

    public OrderConfirm_page(WebDriver ldriver)
    {
        this.driver=ldriver;
    }


    @FindBy(how = How.XPATH , using = ".//*[@class='hbc-button hbc-button--primary hbc-checkout__checkout-btn']")
    WebElement ConfirmOrder;


    public Boolean GetorderNumber() throws InterruptedException{
        Thread.sleep(2000);
        String OrderNo=driver.findElement(By.xpath(".//*[@href='/account/order-history']")).getText();
        System.out.println("orderno :  " + OrderNo);
        if(OrderNo.length()== 8 && OrderNo.matches("[0-9]+"))
        {
            return true;
        }
        else
        {
            return false;
        }
        
        
    }
    
    public String ReturnorderNumber() throws InterruptedException{
        Thread.sleep(2000);
        String OrderNo=driver.findElement(By.xpath(".//*[@href='/account/order-history']")).getText();
        System.out.println("orderno :  " + OrderNo);
		return OrderNo;
		}


    public void  PlaceOrder() throws InterruptedException {
        Thread.sleep(3000);
        ConfirmOrder.click();

    }
}
