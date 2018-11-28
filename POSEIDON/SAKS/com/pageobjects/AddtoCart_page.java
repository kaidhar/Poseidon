package com.pageobjects;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Utilities;

import org.openqa.selenium.support.How;

public class AddtoCart_page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public AddtoCart_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}

	public void selectColor(String color) throws Exception {
		Thread.sleep(2000);
		WebElement selectColor = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + color + "')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		;
		js.executeScript("arguments[0].click();", selectColor);

	}

	public void StorePickup() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("StorePickup"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable to add to cart");
			e.printStackTrace();
		}
	}

	public void EnterPostalCode() {
		try {

			ele = driver.findElement(By.id(prop.getProperty("enterZipcode")));
			ele.sendKeys("postalcode");

		} catch (Exception e) {
			System.out.println("first name not entered");
			e.printStackTrace();
		}
	}
	
	public void BopisCheckOut() {
		try {

			ele = driver.findElement(By.id(prop.getProperty("BopisCheckout")));
			ele.click();

		} catch (Exception e) {
			System.out.println("first name not entered");
			e.printStackTrace();
		}
	}
	
	public void Checkstore() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("checkstores"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable to add to cart");
			e.printStackTrace();
		}
	}
	

	public void Addtocart() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("addtocart"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable to add to cart");
			e.printStackTrace();
		}
	}

	public void Checkout() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("checkout"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable to proceed with checkout");
			e.printStackTrace();
		}
	}

	public void Checkout2() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("checkout2"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable to proceed with checkout");
			e.printStackTrace();
		}
	}

	public void select_user() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("selectuser"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("unable to select user");
			e.printStackTrace();
		}
	}

	public void Increment() {
		try {

			ele = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Multiquantity"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable add multiple item");
			e.printStackTrace();
		}
	}

	public void HideChekout() {
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("HideCheckout"))));
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
