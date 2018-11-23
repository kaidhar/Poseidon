package com.hbc.lt.websom;

import static com.hbc.acoe.framework.selenium.FrameworkDriver.driver;

import java.util.concurrent.TimeUnit;

import com.hbc.acoe.framework.config.Environment;
import com.hbc.acoe.framework.selenium.By;
import com.hbc.acoe.framework.selenium.testdata.DataTable;
import com.hbc.acoe.framework.selenium.verify.Assert;
import com.hbc.lt.reusable.GenericActions;

import static com.hbc.lt.reusable.HomePage.bErrorFound;

public class LTFulfillmentPage {



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


	public static void openWebsomURL(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> Open WEBSOM URL");
			String sScreenName = "LTWebsomPagePG.";
			String appURL = "";
			String[] aTXFields= {"userNameTX","loginPasswordTX"};
			//need to add the store number form API, karthikay need to integrate it 
			try
			{
				appURL = Environment.get("appWEBSOMURL");
				driver.get(appURL);
				Assert.pass("Open the WebSOM URL");
				System.out.println("WEB URL is opened");
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().window().fullscreen();

				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				GenericActions.driver_WaitForElementVisible(sScreenName+"userNameTX");
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
				driver.findElement(By.logicalName(sScreenName+"loginBN")).click();
				GenericActions.driver_WaitForElementVisible(sScreenName+"searchShipmentBN");


			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in openWebsomURL of the application was expected!");
					Assert.pass("Failure in openWebsomURL of the application was expected!");
				}
				else
				{
					Assert.fail("openWebsomURL ("+ appURL +") failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> openWebsomURL");
		}

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


	public static void searchShipemnt(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> searchShipemnt");
			String sScreenName = "LTWebsomPagePG.";
			
			try
			{
				
				GenericActions.driver_WaitForElementVisible(sScreenName+"searchShipmentBN");
				

			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in searchShipemnt of the application was expected!");
					Assert.pass("Failure in searchShipemnt of the application was expected!");
				}
				else
				{
					Assert.fail("searchShipemnt  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> searchShipemnt");
		}

	}



}
