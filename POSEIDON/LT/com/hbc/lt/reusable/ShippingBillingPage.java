package com.hbc.lt.reusable;

import static com.hbc.acoe.framework.selenium.FrameworkDriver.driver;
import static com.hbc.lt.reusable.HomePage.bErrorFound;

import com.hbc.acoe.framework.selenium.By;
import com.hbc.acoe.framework.selenium.testdata.DataTable;
import com.hbc.acoe.framework.selenium.verify.Assert;

public class ShippingBillingPage {

	
	
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
	
	
	
	public static void shippingAndBillingAddress(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> shippingAndBillingAddress");
			System.out.println("Start --> shippingAndBillingAddress");
			String sScreenName = "LTShipBillPagePG.";
			String[] aTXFields = {"FirstNameTX","LastNameTX","shipingAddressTX","shipCityTX","shipEmailTX","shipPhoneTX","zipCodeTX"};
			String[] aWLFields = {"shipStateByValWL"};
			try
			{
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				GenericActions.driver_WaitForElementVisible(sScreenName+"shipBillTitleWE");
				
				GenericActions.dataModify(sScreenName, oTestData, null, aWLFields, null, null, null, iIteration);
				
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, aWLFields, null, null, null, iIteration);
				
				
				GenericActions.driver_WaitForElementVisible(sScreenName+"continueCheckOutBN");
				driver.findElement(By.logicalName(sScreenName+"continueCheckOutBN")).click();
				Assert.pass("Clicked on continue CheckOut button");
				System.out.println("Clicked on continue CheckOut button");
				
				if(GenericActions.driver_WaitForElementVisible(sScreenName+"userEnteredAdressBN"))
				{
					driver.findElement(By.logicalName(sScreenName+"userEnteredAdressBN")).click();
					Assert.pass("Clicked on user entered address  button");
					System.out.println("Clicked on user entered address  button");
				}
				

			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in shippingAndBillingAddress  was expected!");
					Assert.pass("Failure in checkOut  was expected!");
				}
				else
				{
					Assert.fail("shippingAndBillingAddress  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> shippingAndBillingAddress");
			System.out.println("END --> shippingAndBillingAddress");
		}




	}

	
}
