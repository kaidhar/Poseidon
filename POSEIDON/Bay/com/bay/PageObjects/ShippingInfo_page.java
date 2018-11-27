package com.bay.PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

public class ShippingInfo_page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public ShippingInfo_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}

	public void firstname() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("firstname"))));
			ele.sendKeys("sanjay");

		} catch (Exception e) {
			System.out.println("first name not entered");
			e.printStackTrace();
		}
	}

	public void lastname() {

		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("lastname"))));
			ele.sendKeys("s");

		} catch (Exception e) {
			System.out.println("last name not entered");
			e.printStackTrace();
		}
	}

	public void address() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("address"))));
			ele.sendKeys("401 bay street");

		} catch (Exception e) {
			System.out.println("address not entered");
			e.printStackTrace();
		}
	}

	public void city() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("city"))));
			ele.sendKeys("Toronto");

		} catch (Exception e) {
			System.out.println("city not entered");
			e.printStackTrace();
		}
	}

	public void selectstate() throws IOException {
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("state"))));
		Select drop = new Select(ele);
		try {
			drop.selectByValue(prop.getProperty("stateSelect"));
		} catch (IOException e) {
			System.out.println("state not selected");
			e.printStackTrace();
		}

	}

	public void email() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("email"))));
			ele.sendKeys("accept@fraudtest.com");

		} catch (Exception e) {
			System.out.println("email not entered");
			e.printStackTrace();
		}
	}

	public void phone() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("phone"))));
			ele.sendKeys("9845718271");

		} catch (Exception e) {
			System.out.println("phone no not entered");
			e.printStackTrace();
		}
	}

	public void Postal() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("zipcode"))));
			ele.sendKeys(prop.getProperty("postalcode"));

		} catch (Exception e) {
			System.out.println("phone no not entered");
			e.printStackTrace();
		}
	}
	
	public void ContinueCheckout() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CtnCheckout"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("phone no not entered");
			e.printStackTrace();
		}
	}

	public void confirmAdd() {
		Actions actions = new Actions(driver);
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("confrmaddress"))));
			actions.moveToElement(ele);
			actions.click();
			actions.build().perform();
			

		} catch (Exception e) {
			System.out.println("not able to proceed");
			e.printStackTrace();
		}

	}
}
