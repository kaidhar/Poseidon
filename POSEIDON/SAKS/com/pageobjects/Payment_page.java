package com.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Utilities;

public class Payment_page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public Payment_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}



	public void SelectType() {
		Actions actions = new Actions(driver);
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Selecttype"))));
			actions.moveToElement(ele);
			actions.click();
			actions.build().perform();

		} catch (Exception e) {
			System.out.println("Unable to click selectType");
			e.printStackTrace();
		}

	}

	public WebElement cardnumber(String cardType) {
		
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("CCnumber"))));
			
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
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("Ccname"))));
			actions.moveToElement(ele);
			actions.click();
			actions.sendKeys(prop.getProperty("CardHolderName"));
			actions.build().perform();

		} catch (Exception e) {
			System.out.println("Unable to enter name of the card holder");
			e.printStackTrace();
		}

	}

	public void CardYear() {

		Actions actions = new Actions(driver);

		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("CcMonth"))));
			actions.moveToElement(ele);
			actions.click();
			actions.sendKeys(prop.getProperty("DateandYear"));
			actions.build().perform();

		} catch (Exception e) {
			System.out.println("Unable to enter the Date and Year");
			e.printStackTrace();
		}

	}

	public void CardCvv() {
		Actions actions = new Actions(driver);
		
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("CVV"))));
			actions.moveToElement(ele);
			actions.click();
			actions.sendKeys(prop.getProperty("CVVNumber"));
			actions.build().perform();

		} catch (Exception e) {
			System.out.println("Unable to enter Card CVV");
			e.printStackTrace();
		}
	}
	
	
	public void confirmPayment() {
		
		
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CompletePay"))));
			ele.click();
			

		} catch (Exception e) {
			System.out.println("Unable to click confirmPayment");
			e.printStackTrace();
		}
	}

}



