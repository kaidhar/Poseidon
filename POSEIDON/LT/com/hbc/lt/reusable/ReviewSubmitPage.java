package com.hbc.lt.reusable;

import static com.hbc.acoe.framework.selenium.FrameworkDriver.driver;
import static com.hbc.lt.reusable.HomePage.bErrorFound;

import com.hbc.acoe.framework.selenium.By;
import com.hbc.acoe.framework.selenium.WebElement;
import com.hbc.acoe.framework.selenium.testdata.DataTable;
import com.hbc.acoe.framework.selenium.verify.Assert;

public class ReviewSubmitPage {


	
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

	public static void reviewSubmitOrder(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> reviewSubmitOrder");
			System.out.println("Start --> reviewSubmitOrder");
			String sScreenName = "LTReviewSubmitPagePG.";
			try
			{
				//DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				GenericActions.driver_WaitForElementVisible(sScreenName+"placeOrderBN");
				GenericActions.driver_MoveToElement(driver.findElement(By.logicalName(sScreenName+"placeOrderBN")));
				GenericActions.driver_Wait(1);
				driver.findElement(By.logicalName(sScreenName+"placeOrderBN")).click();
				Assert.pass("Clicked on place order button");
				System.out.println("Clicked on place order button");
				GenericActions.driver_Wait(1);


				GenericActions.driver_WaitForElementVisible(sScreenName+"thankYouTitleWE");
				String sOrderDetails = driver.findElement(By.logicalName(sScreenName+"orderDetailsWE")).getText();

				System.out.println("Order details is ---->"+sOrderDetails);

				Assert.pass("order details is "+ sOrderDetails + " ");

				String sOrderNumber = driver.findElement(By.logicalName(sScreenName+"orderNumberWE")).getText();
				System.out.println("Order Number is ---->"+sOrderNumber);

				Assert.pass("order Number is "+ sOrderNumber + " ");
				
				String sOnlyOrderNum = GenericActions.extractOnlyNumber(sOrderNumber);

				System.out.println("Order Number is ---->"+sOnlyOrderNum);

				Assert.pass("order Number is "+ sOnlyOrderNum + " ");
				
				
				System.out.println("Writting the order to excel sheet");
				 String sOrderWorkBook = GenericActions.getTestOrderFile();
				 System.out.println("--------->"+sOrderWorkBook);
				 String sOrderSheet = "TestOrder";
				 DataTable oTestData=new DataTable(sWorkBook, sOrderSheet, sTestCase);
				 //oTestData.setValue("TCID", 2, sTestCase);
				 oTestData.setValue("ORDERS", 2, sOnlyOrderNum);
				 
				
				
			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in reviewSubmitOrder  was expected!");
					Assert.pass("Failure in reviewSubmitOrder  was expected!");
				}
				else
				{
					Assert.fail("reviewSubmitOrder  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> reviewSubmitOrder");
			System.out.println("END --> reviewSubmitOrder");
		}




	}

}
