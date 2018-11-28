package com.hbc.lt.regression;

import com.hbc.acoe.framework.selenium.verify.Assert;
import com.hbc.lt.reusable.CheckOutPage;
import com.hbc.lt.reusable.GenericActions;
import com.hbc.lt.reusable.HomePage;
import com.hbc.lt.reusable.PaymentPage;
import com.hbc.lt.reusable.ReviewSubmitPage;
import com.hbc.lt.reusable.ShippingBillingPage;

public class OrderTest {

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
	
	public static void TC_ToPlaceSingleLineSingleQuantity()
	{
		Assert.pass("Start-------> TC_ToPlaceSingleLineSingleQuantity");
		System.out.println("Start-------> TC_ToPlaceSingleLineSingleQuantity");
		
		sTestCase ="TC_ToPlaceSingleLineSingleQuantity";
				
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
		
		
		
		Assert.pass("End-------> TC_ToPlaceSingleLineSingleQuantity");
		System.out.println("End-------> TC_ToPlaceSingleLineSingleQuantity");
	}
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
	
	public static void TC_ToPlaceSingleLineMultiQuantity()
	{
		Assert.pass("Start-------> TC_ToPlaceSingleLineMultiQuantity");
		System.out.println("Start-------> TC_ToPlaceSingleLineMultiQuantity");
		
		sTestCase ="TC_ToPlaceSingleLineMultiQuantity";
				
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
		
		
		
		Assert.pass("End-------> TC_ToPlaceSingleLineMultiQuantity");
		System.out.println("End-------> TC_ToPlaceSingleLineMultiQuantity");
	}
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
	
	public static void TC_ToPlaceMultiLineSingleQuantity()
	{
		Assert.pass("Start-------> TC_ToPlaceMultiLineSingleQuantity");
		System.out.println("Start-------> TC_ToPlaceMultiLineSingleQuantity");
		
		sTestCase ="TC_ToPlaceMultiLineSingleQuantity";
				
		sSheet="LTHomePage";
		HomePage.openURL(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.changeShipToUS(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.searchItem(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.addItemToBag(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.searchSecondItem(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.addItemToBag(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTCheckOutPage";
		CheckOutPage.checkOut(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTShipBillPage";
		ShippingBillingPage.shippingAndBillingAddress(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTPaymentPage";
		PaymentPage.enterPaymentDetails(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTReviewSubmitPage";
		ReviewSubmitPage.reviewSubmitOrder(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		
		
		
		Assert.pass("End-------> TC_ToPlaceMultiLineSingleQuantity");
		System.out.println("End-------> TC_ToPlaceMultiLineSingleQuantity");
	}
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
	
	public static void TC_ToPlaceMultiLineMultiQuantity()
	{
		Assert.pass("Start-------> TC_ToPlaceMultiLineMultiQuantity");
		System.out.println("Start-------> TC_ToPlaceMultiLineMultiQuantity");
		
		sTestCase ="TC_ToPlaceMultiLineMultiQuantity";
				
		sSheet="LTHomePage";
		HomePage.openURL(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.changeShipToUS(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.searchItem(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.addItemToBag(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.searchSecondItem(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.addItemToBag(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTCheckOutPage";
		CheckOutPage.checkOut(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTShipBillPage";
		ShippingBillingPage.shippingAndBillingAddress(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTPaymentPage";
		PaymentPage.enterPaymentDetails(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		sSheet="LTReviewSubmitPage";
		ReviewSubmitPage.reviewSubmitOrder(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		
		
		
		Assert.pass("End-------> TC_ToPlaceMultiLineMultiQuantity");
		System.out.println("End-------> TC_ToPlaceMultiLineMultiQuantity");
	}
	
	/*
    '**********************************************************************************************************
    '  Name         :  TC_ToPlaceBopisSingleLineSingleQuantity
    '  Description  :  
    '----------------------------------------------------------------------------------------------------------
    '  Created by        :  
    '  Create Date       : 
    '----------------------------------------------------------------------------------------------------------
    '  Notes        : 
    '----------------------------------------------------------------------------------------------------------
    '**********************************************************************************************************
	 */
	
	public static void TC_ToPlaceBopisSingleLineSingleQuantity()
	{
		Assert.pass("Start-------> TC_ToPlaceBopisSingleLineSingleQuantity");
		System.out.println("Start-------> TC_ToPlaceBopisSingleLineSingleQuantity");
		
		sTestCase ="TC_ToPlaceBopisSingleLineSingleQuantity";
				
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
		
		
		
		
		Assert.pass("End-------> TC_ToPlaceBopisSingleLineSingleQuantity");
		System.out.println("End-------> TC_ToPlaceBopisSingleLineSingleQuantity");
	}
}
