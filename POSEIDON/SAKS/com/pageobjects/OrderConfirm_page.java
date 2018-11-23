package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Utilities;

public class OrderConfirm_page {
	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public OrderConfirm_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}

	public Boolean GetorderNumber() throws InterruptedException {
		Thread.sleep(2000);
		String OrderNo="";
		try {
		 ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("retriveorder"))));
		 OrderNo=ele.getText();
		 
		}catch (Exception e) {
			System.out.println("Unable to get OrderNumber");
			e.printStackTrace();
		}
		System.out.println("Orderno :  " + OrderNo);
		
		if (OrderNo.length() == 8 && OrderNo.matches("[0-9]+")) {
			return true;
		} else {
			System.out.println("Unable to retrive Order number");
			return false;
		}

	}

	public String ReturnorderNumber() throws InterruptedException {
		Thread.sleep(2000);
		String OrderNo="";
		try {
		 ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("retriveorder"))));
		 OrderNo=ele.getText();
		 
		}catch (Exception e) {
			System.out.println("Unable to get OrderNumber");
			e.printStackTrace();
		}
		System.out.println("orderno :  " + OrderNo);
		return "0" + OrderNo;
	}

	public void PlaceOrder() {
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("placeorder"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable to click confirm order");
			e.printStackTrace();
		}

	}
}