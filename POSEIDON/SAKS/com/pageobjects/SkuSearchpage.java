package com.pageobjects;
import org.openqa.selenium.Keys;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

public class SkuSearchpage {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public SkuSearchpage(WebDriver ldriver) {

		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;

	}
    
    
    public void SearchSku() {
		try {
			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Searchsku"))));
			ele.sendKeys("0467558208102",Keys.ENTER);

		} catch (Exception e) {
			System.out.println("Unable to enter and search webID");
			e.printStackTrace();
		}

	}


}
