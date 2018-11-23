package com.pageobjects;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Utilities;

public class ShippingInfo_page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public ShippingInfo_page(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public void firstname() {
		try {

			ele = driver.findElement(By.id(prop.getProperty("firstname")));
			ele.sendKeys("sanjay");

		} catch (Exception e) {
			System.out.println("first name not entered");
			e.printStackTrace();
		}
	}

	public void lastname() {

		try {

			ele = driver.findElement(By.id(prop.getProperty("lastname")));
			ele.sendKeys("s");

		} catch (Exception e) {
			System.out.println("last name not entered");
			e.printStackTrace();
		}
	}

	public void address() {
		try {

			ele = driver.findElement(By.id(prop.getProperty("address")));
			ele.sendKeys("1000 w 78 st");

		} catch (Exception e) {
			System.out.println("address not entered");
			e.printStackTrace();
		}
	}

	public void city() {
		try {

			ele = driver.findElement(By.id(prop.getProperty("city")));
			ele.sendKeys("new york");

		} catch (Exception e) {
			System.out.println("city not entered");
			e.printStackTrace();
		}
	}

	public void selectstate() {
		ele = driver.findElement(By.name("state"));
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

			ele = driver.findElement(By.id(prop.getProperty("email")));
			ele.sendKeys("accept@fraudtest.com");

		} catch (Exception e) {
			System.out.println("email not entered");
			e.printStackTrace();
		}
	}

	public void phone() {
		try {

			ele = driver.findElement(By.id(prop.getProperty("phone")));
			ele.sendKeys("9845718271");

		} catch (Exception e) {
			System.out.println("phone no not entered");
			e.printStackTrace();
		}
	}

	public void Postal() {
		try {

			ele = driver.findElement(By.id(prop.getProperty("zipcode")));
			ele.sendKeys(prop.getProperty("postalcode"));

		} catch (Exception e) {
			System.out.println("phone no not entered");
			e.printStackTrace();
		}
	}

	public void confirmAdd() {

		try {

			ele = driver.findElement(By.xpath(prop.getProperty("confrmaddress")));
			ele.click();

		} catch (Exception e) {
			System.out.println("not able to proceed");
			e.printStackTrace();
		}

	}
}
