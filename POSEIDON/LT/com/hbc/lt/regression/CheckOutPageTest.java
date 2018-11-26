package com.hbc.lt.regression;

import com.hbc.acoe.framework.selenium.verify.Assert;
import com.hbc.lt.reusable.CheckOutPage;
import com.hbc.lt.reusable.GenericActions;
import com.hbc.lt.reusable.HomePage;
import com.hbc.lt.reusable.PaymentPage;
import com.hbc.lt.reusable.ReviewSubmitPage;
import com.hbc.lt.reusable.ShippingBillingPage;

public class CheckOutPageTest {

	
	static String sWorkBook = GenericActions.getTestDataFile();
	static String sSheet = "";
	static String sTestCase = "";
	static int iIteration = 1;
	
	
	

	
	/*
    '**********************************************************************************************************
    '  Name         :  
    '  Description  :  
    '----------------------------------------------------------------------------------------------------------
    '  Created by        :  
    '  Create Date       : 
    '----------------------------------------------------------------------------------------------------------
    '  Notes        : 
    '----------------------------------------------------------------------------------------------------------
    '**********************************************************************************************************
	 */
	
	public static void TC_ToAddItemToCart()
	{
		Assert.pass("Start-------> TC_ToAddItemToCart");
		System.out.println("Start-------> TC_ToAddItemToCart");
		
		sTestCase ="TC_ToAddItemToCart";
				
		sSheet="LTHomePage";
		HomePage.openURL(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.changeShipToUS(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.searchItem(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.addItemToBag(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTCheckOutPage";
		CheckOutPage.checkOut(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTShipBillPage";
		ShippingBillingPage.shippingAndBillingAddress(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTPaymentPage";
		PaymentPage.enterPaymentDetails(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTReviewSubmitPage";
		ReviewSubmitPage.reviewSubmitOrder(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		
		
		Assert.pass("End-------> TC_ToAddItemToCart");
		System.out.println("End-------> TC_ToAddItemToCart");
	}
}
