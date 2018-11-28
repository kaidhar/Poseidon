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

public class SingleLineAllTenderTypes {

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

	public String SinglineVisa() throws InterruptedException {
		this.loadPropertiesFile();
		WebDriver driver = BrowserFactory.launchBrowser("chrome", "https://qa.thebay.com");
		String OrderID = "";

		try {
			SkuSearchpage skusearch = PageFactory.initElements(driver, SkuSearchpage.class);
			skusearch.SearchSku();

			AddtoCart_page cart = PageFactory.initElements(driver, AddtoCart_page.class);
			cart.selectColor("White");
			cart.SelectSize("ONE SIZE");
			cart.Increment();
			cart.Increment();
			cart.Addtocart();
			cart.Checkout();
			cart.Checkout2();
			cart.select_user();

			ShippingInfo_page ship = PageFactory.initElements(driver, ShippingInfo_page.class);
			ship.firstname();
			ship.lastname();
			ship.address();
			ship.selectstate();
			ship.city();
			ship.email();
			ship.phone();
			ship.Postal();
			ship.ContinueCheckout();
			Thread.sleep(3000);
			ship.confirmAdd();

			Payment_page pay = PageFactory.initElements(driver, Payment_page.class);
			pay.selectType();
			Thread.sleep(2000);
			pay.CardName();
			Thread.sleep(2000);
			pay.CardYear();
			pay.CardMonth();
			pay.Cardcvv();
			pay.cardnumber(prop.getProperty("CreditcardVISA"));
			pay.confirmPayment();
			Thread.sleep(3000);

			OrderConfirm_page cnfrm = PageFactory.initElements(driver, OrderConfirm_page.class);
			cnfrm.PlaceOrder();
			Thread.sleep(2000);
			OrderID = cnfrm.ReturnorderNumber();
			if(OrderID.equals(null));
			{
			System.out.println("Order Not Created");	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OrderID;
	}

	/* WebCom order creation */
	@Test
	public String SingleLine() throws InterruptedException {
		this.loadPropertiesFile();
		WebDriver driver = BrowserFactory.launchBrowser(prop.getProperty("Driver"), prop.getProperty("COMURL"));
		String OrderID = null;

		try {
			WebComLogin_page login = new WebComLogin_page(driver);
			login.Login();

			WebComCreateOrder_Page crtOdr = new WebComCreateOrder_Page(driver);
			crtOdr.SelectEnterprise();

			WebComCustomerSearch_page custSearch = new WebComCustomerSearch_page(driver);
			custSearch.AddingExstingCustomer();

			WebComAddProducts_page addProduct = new WebComAddProducts_page(driver);
			addProduct.AddProduct();

			WebCOMFulfillmentSummary_page fulfillment = new WebCOMFulfillmentSummary_page(driver);
			fulfillment.SelectShippingMethod(prop.getProperty("ShippingService"));
			fulfillment.AddPaymentMethodCreditcard(prop.getProperty("PaymentType"));
			fulfillment.ConfirmOrder();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return OrderID;
	}

}