package com.bay.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

public class WebComCreateOrder_Page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public WebComCreateOrder_Page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 30);
		this.driver = ldriver;
	}

	public void SelectEnterprise() throws IOException, Exception {
		try {
			Thread.sleep(5000);
			ele = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("COMCreateOrder"))));
			ele.click();

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Enterprise"))));
			ele.click();

			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SelectEnterprise"))));
			ele.click();
			
			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ApplyButton"))));
			ele.click();

		} catch (IOException e) {
			System.out.println("Unable to Select enterprise to WEBCOM , Failed in WebComCreateOrder_Page");
			e.printStackTrace();
		}

	}

}
