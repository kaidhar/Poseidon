package com.hbc.lt.reusable;

import com.hbc.acoe.framework.config.Environment;
import com.hbc.acoe.framework.selenium.verify.Assert;
import com.hbc.acoe.framework.selenium.*;

import com.hbc.acoe.framework.selenium.FrameworkDriver.*;
import com.hbc.acoe.framework.selenium.testdata.DataTable;

import static com.hbc.acoe.framework.selenium.FrameworkDriver.driver;
import static com.hbc.lt.reusable.HomePage.bErrorFound;

import java.util.concurrent.TimeUnit;


public class HomePage {

	//public static WebDriver driver = DriverScript.driver_Init();

	public static boolean bErrorFound;

	public static void openURL(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		bErrorFound = false;
		if(!bErrorFound)
		{
			Assert.pass("Start --> OpenURL");
			String sScreenName = "LTHomePagePG.";
			String appURL = "";
			try
			{
				appURL = Environment.get("appURL");
				driver.get(appURL);
				//GenericActions.waitForDomToLoad(driver);
				Assert.pass("Open the WebPage");
				System.out.println("URL opened");
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().window().fullscreen();
				GenericActions.driver_WaitForElementVisible(sScreenName+"ltTitleLK");
				if((GenericActions.driver_WaitForElementVisible(sScreenName+"ltTitleLK")))
				{

					Assert.pass("Lord & Taylor logo is ("+ driver.findElement(By.logicalName(sScreenName+"ltTitleLK")).getText()+") displayed");
					System.out.println("Lord & Taylor logo is displayed");
				}
				//Thread.sleep(10000);

			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in openURL of the application was expected!");
					Assert.pass("Failure in openURL of the application was expected!");
				}
				else
				{
					Assert.fail("OpenURL ("+ appURL +") failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> OpenURL");
		}




	}

	public static void searchItem(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> searchItem");

			String sScreenName = "LTHomePagePG.";
			String[] aTXFields= {"searchStringTX"};
			String sWebID="";
			try
			{
				System.out.println("Start --> searchItem");
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				sWebID=oTestData.getValue("searchStringTX");
				System.out.println("Web ID is ----->"+ sWebID);
				Assert.pass("Searching the web ID");
				System.out.println("Searching the web ID");
				/*GenericActions.driver_WaitForElementVisible(sScreenName+"searchStringTX");

				if((GenericActions.driver_WaitForElementVisible(sScreenName+"closePopUpBN")))
				{
					driver.findElement(By.logicalName(sScreenName+"closePopUpBN")).click();
					Assert.pass("Pop up is closed.");
					System.out.println("Pop up is closed.");
				}*/
				GenericActions.driver_Wait(2);
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);

				driver.findElement(By.logicalName(sScreenName+"submitSearchWE")).click();
				Assert.pass("Clicked on submit search button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"productNameWE");


				if((GenericActions.driver_WaitForElementVisible(sScreenName+"ltTitleLK")))
				{

					Assert.pass("Lord & Taylor logo is ("+ driver.findElement(By.logicalName(sScreenName+"ltTitleLK")).getText()+") displayed");
					System.out.println("Lord & Taylor logo is displayed");
				}


			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in searchItem  was expected!");
					Assert.pass("Failure in searchItem  was expected!");
				}
				else
				{
					Assert.fail("searchItem  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> searchItem");
		}




	}
	
	public static void searchSecondItem(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> searchSecondItem");

			String sScreenName = "LTHomePagePG.";
			String[] aTXFields= {"searchStringIDTX"};
			String sWebID="";
			try
			{
				System.out.println("Start --> searchItem");
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				sWebID=oTestData.getValue("searchStringTX");
				System.out.println("Web ID is ----->"+ sWebID);
				Assert.pass("Searching the web ID");
				System.out.println("Searching the web ID");
				/*GenericActions.driver_WaitForElementVisible(sScreenName+"searchStringTX");

				if((GenericActions.driver_WaitForElementVisible(sScreenName+"closePopUpBN")))
				{
					driver.findElement(By.logicalName(sScreenName+"closePopUpBN")).click();
					Assert.pass("Pop up is closed.");
					System.out.println("Pop up is closed.");
				}*/
				GenericActions.driver_Wait(2);
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
				
			
				driver.findElement(By.logicalName(sScreenName+"submitSearchWE")).click();
				Assert.pass("Clicked on submit search button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"productNameWE");


				if((GenericActions.driver_WaitForElementVisible(sScreenName+"ltTitleLK")))
				{

					Assert.pass("Lord & Taylor logo is ("+ driver.findElement(By.logicalName(sScreenName+"ltTitleLK")).getText()+") displayed");
					System.out.println("Lord & Taylor logo is displayed");
				}


			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in searchSecondItem  was expected!");
					Assert.pass("Failure in searchSecondItem  was expected!");
				}
				else
				{
					Assert.fail("searchItem  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> searchItem");
		}




	}
	


	public static void addItemToBag(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> addItemToBag");

			String sScreenName = "LTHomePagePG.";
			String[] aTXFields= {"numberOfQuantityTX"}; 
			
			try
			{
				System.out.println("Start --> starting addItemToBag ");
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);

				if((GenericActions.driver_WaitForElementVisible(sScreenName+"productVariantWE")))
				{

					Assert.pass("Product cariant is disaplyed");

					if(GenericActions.driver_WaitForElementVisible(sScreenName+"selectFirstColourWE"))
					{

						driver.findElement(By.logicalName(sScreenName+"selectFirstColourWE")).click();
						Assert.pass("Clicked on first colour");
						System.out.println("Clicked on first colour");
					}	
				}
				if(GenericActions.driver_WaitForElementVisible(sScreenName+"sizeVariantWE"))
				{
					Assert.pass("Size variant is disaplyed");

					if(GenericActions.driver_WaitForElementVisible(sScreenName+"selectFirstSizeWE"))
					{

						driver.findElement(By.logicalName(sScreenName+"selectFirstSizeWE")).click();
						Assert.pass("Clicked on first size");
						System.out.println("Clicked on first size");
					}	
				}
				
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
				
				driver.findElement(By.logicalName(sScreenName+"addToBagBN")).click();
				Assert.pass("Clicked on add to bag button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"bagOverlayPopupWE");
				GenericActions.driver_Wait(2);
				GenericActions.driver_WaitForElementVisible(sScreenName+"viewMyBagCheckoutBN");
				driver.findElement(By.logicalName(sScreenName+"viewMyBagCheckoutBN")).click();
				System.out.println("Clicked on add to bag button");
				GenericActions.driver_Wait(2);
				



			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in addItemToBag  was expected!");
					Assert.pass("Failure in addItemToBag  was expected!");
				}
				else
				{
					Assert.fail("addItemToBag  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> addItemToBag");
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
	
	public static void changeShipToUS(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		
		if(!bErrorFound)
		{
			Assert.pass("Start --> changeShipToUS");
			String sScreenName = "LTHomePagePG.";
			
			try
			{
				if((GenericActions.driver_WaitForElementVisible(sScreenName+"closePopUpBN")))
				{
					driver.findElement(By.logicalName(sScreenName+"closePopUpBN")).click();
					Assert.pass("Pop up is closed.");
					System.out.println("Pop up is closed.");
				}
				GenericActions.driver_Wait(2);
				
				System.out.println("start changeShipToUS");
				GenericActions.driver_WaitForElementVisible(sScreenName+"shipToLK");
				driver.findElement(By.logicalName(sScreenName+"shipToLK")).click();
				GenericActions.driver_WaitForElementVisible(sScreenName+"backToUSSiteBN");
				driver.findElement(By.logicalName(sScreenName+"backToUSSiteBN")).click();
				Assert.pass("Clicked on back to US button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"shipToLK");
				
			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in changeShipToUS of the application was expected!");
					Assert.pass("Failure in changeShipToUS of the application was expected!");
				}
				else
				{
					Assert.fail("changeShipToUS  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> changeShipToUS");
			System.out.println("End --> changeShipToUS");
		}

	}

}