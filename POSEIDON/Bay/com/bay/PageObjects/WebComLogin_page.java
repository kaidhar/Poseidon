package com.bay.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

public class WebComLogin_page {
	
	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public WebComLogin_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}



	public void Login() throws IOException {
		try {
			
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("COMuserName"))));
		ele.sendKeys(prop.getProperty("UserID"));
		
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("COMpassword"))));
		ele.sendKeys(prop.getProperty("Password"));
		
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("COMLogin"))));
		ele.click();
		
		
		} catch (IOException e) {
			System.out.println("Unable to login to WEBCOM , Failed in Login page");
			e.printStackTrace();
		}

	}

}
