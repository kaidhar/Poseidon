package com.BaseClass;


import com.helper.*;

import com.pageobjects.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;




public class MultiqunatityAllTenderTypes {
	
	static boolean result = false;
	Properties prop = new Properties();
	InputStream input = null;

	public void loadPropertiesFile() {
		String filepath = System.getProperty("user.dir") + "//Testdata/SAKS.properties";

		try {
			input = new FileInputStream(filepath);
			prop.load(input);
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	public String MultiLineAmex() {
		WebDriver driver = BrowserFactory.launchBrowser("chrome", "https://www.qa.saks.com/Entry.jsp");
		String OrderID = null;
		try {

			Home_page homePage = PageFactory.initElements(driver, Home_page.class);
			Thread.sleep(3000);
			homePage.Close_popup();
			homePage.Change_country();
			homePage.SwitchToUS();

			SkuSearchpage skusearch = PageFactory.initElements(driver, SkuSearchpage.class);
			skusearch.SearchSku();

			AddtoCart_page cart = PageFactory.initElements(driver, AddtoCart_page.class);
			cart.selectColor("Benares");
			cart.Increment();
			cart.Increment();
			cart.Addtocart();
			cart.Checkout();
			cart.Checkout2();
			cart.select_user();

			ShippingInfo_page ship = PageFactory.initElements(driver, ShippingInfo_page.class);
			ship.firstname();
			Thread.sleep(2000);
			ship.lastname();
			ship.address();
			ship.selectstate();
			ship.city();
			ship.email();
			ship.phone();
			ship.Postal();
			// ship.CtnCheckout();
			Thread.sleep(3000);
			ship.confirmAdd();

			Payment_page pay = PageFactory.initElements(driver, Payment_page.class);
			pay.SelectType();
			Thread.sleep(2000);
			pay.cardnumber("Visa");
			Thread.sleep(2000);
			pay.CardName();
			pay.CardYear();
			pay.CardCvv();
			pay.confirmPayment();
			Thread.sleep(3000);

			OrderConfirm_page cnfrm = PageFactory.initElements(driver, OrderConfirm_page.class);
			cnfrm.PlaceOrder();
			Thread.sleep(2000);
			result = cnfrm.GetorderNumber();
			Assert.assertEquals(true, result);
			OrderID = cnfrm.ReturnorderNumber();

		} catch (Exception e) {
			driver.quit();
		}
		return OrderID;
	}
}	