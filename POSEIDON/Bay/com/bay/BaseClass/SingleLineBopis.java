package com.bay.BaseClass;

import com.bay.PageObjects.*;


import com.bay.helper.*;
import com.helper.BrowserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingleLineBopis {

	static boolean result = false;
	Properties prop = new Properties();
	InputStream input = null;

	public void loadPropertiesFile() {
		String filepath = System.getProperty("user.dir") + "//Testdata/BAY.properties";

		try {
			input = new FileInputStream(filepath);
			prop.load(input);
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	public String  SinglineVisa() throws InterruptedException {
		this.loadPropertiesFile();
		WebDriver driver = BrowserFactory.launchBrowser("chrome", "https://qa.thebay.com");
		String OrderID = "";
		
		try {
			SkuSearchpage skusearch = PageFactory.initElements(driver, SkuSearchpage.class);
			skusearch.BopisSkuSearch();
			
			AddtoCart_page cart = PageFactory.initElements(driver, AddtoCart_page.class);
			cart.selectColor("Black");
			cart.SelectSize("22W");
			cart.StorePickup();
			cart.EnterPostalCode();
			cart.CheckStores();
			cart.BopisCheckOut();
			cart.Checkout();
			cart.Checkout2();
			cart.select_user();
		}