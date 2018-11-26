package com.hbc.lt.reusable;

import static com.hbc.acoe.framework.selenium.FrameworkDriver.driver;

import com.hbc.acoe.framework.selenium.By;
import com.hbc.acoe.framework.selenium.testdata.DataTable;
import com.hbc.acoe.framework.selenium.verify.Assert;

import static com.hbc.lt.reusable.HomePage.bErrorFound;

public class CheckOutPage {


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


	public static void checkOut(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> checkOut");

			String sScreenName = "LTCheckOutPagePG.";


			try
			{
				System.out.println("Start --> starting checkOut ");
				//DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				GenericActions.driver_WaitForElementVisible(sScreenName+"bagTitleWE");
				if((GenericActions.driver_WaitForElementVisible(sScreenName+"checkOutBN")))
				{

					Assert.pass("Bag Title is disaplyed");
					driver.findElement(By.logicalName(sScreenName+"checkOutBN")).click();
					System.out.println("Clicked on check out button ");
					GenericActions.driver_WaitForElementVisible(sScreenName+"logInPopUpWE");
					driver.findElement(By.logicalName(sScreenName+"guestCheckoutBN")).click();
					Assert.pass("Clicked on guest user check out button");

					GenericActions.driver_Wait(5);
				}
				else
				{
					Assert.fail("Seems like a error in checkout page.");
					System.out.println("Seems like a error in checkout page.");
				}




			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in checkOut  was expected!");
					Assert.pass("Failure in checkOut  was expected!");
				}
				else
				{
					Assert.fail("checkOut  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> checkOut");
		}




	}

}
