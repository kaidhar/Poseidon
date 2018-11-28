package com.bay.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

public class WebComAddProducts_page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public WebComAddProducts_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}

	public void AddProduct() throws IOException, Exception {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ProductIDTB"))));
			ele.sendKeys(prop.getProperty("ProductID"));

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AddButton"))));
			ele.click();

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("QuantityTB"))));
			ele.clear();
			ele.sendKeys(prop.getProperty("Quantity"));

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SaveButton"))));
			ele.click();

			Thread.sleep(6000);

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("NextButton"))));
			ele.click();

		} catch (IOException e) {
			System.out.println("Failed in AddProduct page");
			e.printStackTrace();
		}

	}

}
