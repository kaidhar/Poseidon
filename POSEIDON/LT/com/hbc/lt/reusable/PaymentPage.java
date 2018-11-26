package com.hbc.lt.reusable;

import static com.hbc.acoe.framework.selenium.FrameworkDriver.driver;
import static com.hbc.lt.reusable.HomePage.bErrorFound;

import com.hbc.acoe.framework.selenium.By;
import com.hbc.acoe.framework.selenium.testdata.DataTable;
import com.hbc.acoe.framework.selenium.verify.Assert;

public class PaymentPage {



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

	public static void enterPaymentDetails(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> enterPaymentDetails");
			System.out.println("Start --> enterPaymentDetails");
			String sScreenName = "LTPaymentPagePG.";
			String[] aTXFields = {"cardNumberTX","cardHolderNameTX","creditCardCVVTX"};
			String[] aWLFields = {"paymentTypeByValWL","creditCardMonthByValWL","creditCardYearByValWL"};
			try
			{
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				GenericActions.driver_WaitForElementVisible(sScreenName+"cardNumberTX");

				GenericActions.dataModify(sScreenName, oTestData, null, aWLFields, null, null, null, iIteration);
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);

				GenericActions.driver_WaitForElementVisible(sScreenName+"paymentContinueCheckOutBN");
				driver.findElement(By.logicalName(sScreenName+"paymentContinueCheckOutBN")).click();
				Assert.pass("Clicked on continue CheckOut button");
				System.out.println("Clicked on continue CheckOut button");

				GenericActions.driver_Wait(1);

			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in enterPaymentDetails  was expected!");
					Assert.pass("Failure in enterPaymentDetails  was expected!");
				}
				else
				{
					Assert.fail("enterPaymentDetails  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> enterPaymentDetails");
			System.out.println("END --> enterPaymentDetails");
		}




	}

}
