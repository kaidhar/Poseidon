package com.bay.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

public class WebComCustomerSearch_page {
	
	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public WebComCustomerSearch_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}



	public void AddingExstingCustomer() throws IOException, Exception {
		try {
			
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("FirstnameTB"))));
		ele.sendKeys(prop.getProperty("Firstname"));
		
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("SearchButton"))));
		ele.click();
		
		Thread.sleep(6000);
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("NextButton"))));
		ele.click();
		
		
		
		} catch (IOException e) {
			System.out.println("Failed in AddingExstingCustomer");
			e.printStackTrace();
		}

	}

}
