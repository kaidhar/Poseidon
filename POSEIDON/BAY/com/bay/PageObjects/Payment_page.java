package com.bay.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

public class Payment_page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public Payment_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}



	public void selectType() throws IOException {
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("paymentType"))));
		Select drop = new Select(ele);
		try {
			drop.selectByValue(prop.getProperty("CardType"));
		} catch (IOException e) {
			System.out.println("state not selected");
			e.printStackTrace();
		}

	}

	public WebElement cardnumber(String cardType) {
		
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CCnumber"))));
			
			if (cardType.equalsIgnoreCase("VISA")) {
				ele.click();
				ele.sendKeys(prop.getProperty("VISACard"));
			} else if (cardType.equalsIgnoreCase("MASTERCARD")) {
				ele.click();
				ele.sendKeys(prop.getProperty("MASTERCard"));
			} else if (cardType.equalsIgnoreCase("AMEX")) {
				ele.click();
				ele.sendKeys(prop.getProperty("AMEXCard"));
			} else if (cardType.equalsIgnoreCase("DISCOVER")) {
				ele.click();
				ele.sendKeys(prop.getProperty("DISCOVERCard"));
			} else if (cardType.equalsIgnoreCase("Storecard")) {
				ele.click();
				ele.sendKeys(prop.getProperty("StoreCard"));
			}

		} catch (Exception e) {
			System.out.println("Unable to click selectType and enter the card number");
			e.printStackTrace();
		}

		return ele;

	}

	public void CardName() {
		Actions actions = new Actions(driver);

		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Ccname"))));
			actions.moveToElement(ele);
			actions.click();
			actions.sendKeys(prop.getProperty("CardHolderName"));
			actions.build().perform();

		} catch (Exception e) {
			System.out.println("Unable to enter name of the card holder");
			e.printStackTrace();
		}

	}

	public void CardMonth() throws IOException
	{
	ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CcMonth"))));
	Select drop = new Select(ele);
	try {
		drop.selectByValue(prop.getProperty("month"));
	} catch (IOException e) {
		System.out.println("state not selected");
		e.printStackTrace();
	}

}

	public void CardYear() throws IOException
	{
	ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Ccyear"))));
	Select drop = new Select(ele);
	try {
		drop.selectByValue(prop.getProperty("year"));
	} catch (IOException e) {
		System.out.println("state not selected");
		e.printStackTrace();
	}

}
	
	public void Cardcvv() {
		Actions actions = new Actions(driver);

		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cvv"))));
			actions.moveToElement(ele);
			actions.click();
			actions.sendKeys(prop.getProperty("Cvvnumber"));
			actions.build().perform();

		} catch (Exception e) {
			System.out.println("Unable to enter name of the card holder");
			e.printStackTrace();
		}
	}

	
	
	public void confirmPayment() {
		
		
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Completepay"))));
			ele.click();
			

		} catch (Exception e) {
			System.out.println("Unable to click confirmPayment");
			e.printStackTrace();
		}
	}

}



