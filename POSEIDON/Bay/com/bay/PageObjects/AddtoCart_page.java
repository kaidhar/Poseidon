package com.bay.PageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

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
		WebElement selectColor = driver.findElement(By.xpath("//span[contains(text(),'" + color + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		;
		js.executeScript("arguments[0].click();", selectColor);

	}
	
	public void SelectSize(String size) throws Exception {
		WebElement selectsize = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + size + "')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		;
		js.executeScript("arguments[0].click();", selectsize);
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
			ele.click()

		} catch (Exception e) {
			System.out.println("unable to select user");
			e.printStackTrace();
		}
	}

	public void Increment() {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Multiquantity"))));
			ele.click();

		} catch (Exception e) {
			System.out.println("Unable add multiple item");
			e.printStackTrace();
		}
	}
}
