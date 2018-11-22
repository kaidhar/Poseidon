package com.pageobjects;


import org.openqa.selenium.support.ui.WebDriverWait;


import com.helper.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page {

	WebDriver driver;
	WebDriverWait wait=null;
	WebElement ele;
	Utilities prop = new Utilities();

	public Home_page(WebDriver ldriver) {
		
		wait=new WebDriverWait(ldriver, 20);
		this.driver = ldriver;

	}


	public void Close_popup() {
		try {
			
			ele=driver.findElement(By.xpath(prop.getProperty("closepopup")));
			ele.click();
		
		} catch (Exception e) {
			System.out.println("Unable to click close popUp");
			e.printStackTrace();
		}

	}

	public void Change_country() {
		try {
			ele=driver.findElement(By.xpath(prop.getProperty("Changeountry")));
			ele.click();
		} catch (Exception e) {
			System.out.println("Unable to click Changeountry");
			e.printStackTrace();
		}
	}

	public void SwitchToUS() {
		try {
			ele=driver.findElement(By.xpath(prop.getProperty("Switchus")));
			ele.click();
		} catch (Exception e) {
			System.out.println("Unable to click Switchus");
			e.printStackTrace();
		}
	}
}