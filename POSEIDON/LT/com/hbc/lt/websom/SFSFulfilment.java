package com.hbc.lt.websom;

import static com.hbc.acoe.framework.selenium.FrameworkDriver.driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.hbc.acoe.framework.config.Environment;
import com.hbc.acoe.framework.selenium.By;
import com.hbc.acoe.framework.selenium.Driver;
import com.hbc.acoe.framework.selenium.testdata.DataTable;
import com.hbc.acoe.framework.selenium.verify.Assert;
import com.hbc.lt.reusable.GenericActions;

import static com.hbc.lt.reusable.HomePage.bErrorFound;
import static com.hbc.lt.reusable.ReviewSubmitPage.sOnlyOrderNum;

public class SFSFulfilment {



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


	public void openWebsomURL(String OrderID, String Banner)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> Open WEBSOM URL");
			String sScreenName = "LTWebsomPagePG.";
			String appURL = "";
			String[] aTXFields= {"userNameTX","loginPasswordTX","storeIDTX"};
			//need to add the store number form API, K need to integrate it 
			try
			{
				appURL = Environment.get("appWEBSOMURL");
				driver.get(appURL);
				Assert.pass("Open the WebSOM URL");
				System.out.println("WEB URL is opened");
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().window().fullscreen();

				//DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				GenericActions.driver_WaitForElementVisible(sScreenName+"userNameTX");
				//GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
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


	public  void searchShipemnt(String OrderID,String ShipNode)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> searchShipemnt");
			String sScreenName = "LTWebsomPagePG.";
			//String[] aTXFields= {"orderNumberTX"};
			//order number i should get at runtime
			try
			{
				System.out.println("Start --> searchShipemnt");
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				GenericActions.driver_WaitForElementVisible(sScreenName+"searchShipmentBN");
				driver.findElement(By.logicalName(sScreenName+"searchShipmentBN")).click();
				Assert.pass("Clicked on search shipment button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"orderNumberTX");
				//GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
				driver.findElement(By.logicalName(sScreenName+"orderNumberTX")).sendKeys(sOnlyOrderNum);
				driver.findElement(By.logicalName(sScreenName+"searchBN")).click();
				Assert.pass("Clicked on search order button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"packOrderBN");


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


	public void packOrder(String OrderID, String Banner)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> packOrder");
			String sScreenName = "LTWebsomPagePG.";
			String sNumberOfQaq="";
			String[] aTXFields = {"WeightTX"};

			try
			{
				System.out.println("Start --> packOrder");
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				//GenericActions.driver_WaitForElementVisible(sScreenName+"packOrderBN");
				driver.findElement(By.logicalName(sScreenName+"packOrderBN")).click();
				Assert.pass("Clicked on pack order button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"numberOfQuantityWE");
				sNumberOfQaq = driver.findElement(By.logicalName(sScreenName+"numberOfQuantityWE")).getText();
				int iNumberOfQuantity = Integer.parseInt(GenericActions.extractOnlyNumber(sNumberOfQaq));
				for(int i=1; i<=iNumberOfQuantity;i++)
				{

					driver.findElement(By.logicalName(sScreenName+"increaseQuantityWE")).click();
					GenericActions.driver_WaitForElementVisible(sScreenName+"loadingIconWE");
					GenericActions.driver_WaitForElementInvisible(sScreenName+"loadingIconWE");
					Assert.pass("clicked on increased quantity button");
				}

				GenericActions.driver_WaitForElementVisible(sScreenName+"WeightTX");
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
				driver.findElement(By.logicalName(sScreenName+"getWeightBN")).click();
				Assert.pass("clicked on get weight button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"loadingIconWE");
				GenericActions.driver_WaitForElementInvisible(sScreenName+"loadingIconWE");
				driver.findElement(By.logicalName(sScreenName+"printPackSlipBN")).click();
				GenericActions.driver_WaitForElementVisible(sScreenName+"loadingIconWE");
				GenericActions.driver_WaitForElementInvisible(sScreenName+"loadingIconWE");
				Assert.pass("Clicked on print pack slip button ");
				String sPrintError = driver.findElement(By.logicalName(sScreenName+"printMessageTitleErrorWE")).getText();

				if(sPrintError.equalsIgnoreCase(oTestData.getValue("printMessageTitleErrorWE")))
				{
					Assert.pass("Pass");
				}
				else
				{
					Assert.pass("Please check the error message");
				}

				if(driver.findElement( By.logicalName(sScreenName+"readyToShipWE")).getText().equalsIgnoreCase(oTestData.getValue("readyToShipWE")))
				{
					Assert.pass("Ready to ship");
					System.out.println("Ready to ship");
				}
				else
				{
					Assert.fail("Not Ready to ship please check the error");
					System.out.println("Not Ready to ship please check the error");
				}

				driver.findElement(By.logicalName(sScreenName+"printPackSlipBN")).click();
				GenericActions.driver_WaitForElementVisible(sScreenName+"loadingIconWE");
				GenericActions.driver_WaitForElementInvisible(sScreenName+"loadingIconWE");
				Assert.pass("Clicked on print shipping label button ");
				System.out.println("Clicked on print shipping label button ");

				String sPrintShippingError = driver.findElement(By.logicalName(sScreenName+"printMessageTitleErrorWE")).getText();

				if(sPrintError.equalsIgnoreCase(oTestData.getValue("printMessageTitleErrorWE")))
				{
					Assert.pass("Shipping lable Pass");
					System.out.println("Shipping lable Pass");
				}
				else
				{
					Assert.pass("Please check the error message");
					System.out.println("Please check the error message");
				}

				driver.findElement(By.logicalName(sScreenName+"finishPackBN")).click();
				Assert.pass("clicked on finish pack button");
				System.out.println("clicked on finish pack button");
				GenericActions.driver_WaitForElementVisible(sScreenName+"loadingIconWE");
				GenericActions.driver_WaitForElementInvisible(sScreenName+"loadingIconWE");
				if(GenericActions.driver_WaitForElementVisible(sScreenName+"packedWE"))
				{
					Assert.pass("Order is packed ");
					System.out.println("Order is packed ");
				}
				else
				{
					Assert.fail("Order is not packed ");
					System.out.println("Order is not packed ");
				}
				

			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in packOrder of the application was expected!");
					Assert.pass("Failure in packOrder of the application was expected!");
				}
				else
				{
					Assert.fail("packOrder  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> packOrder");
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


	public  void carrierShipment(String OrderID, String Banner)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> carrierShipment");
			String sScreenName = "LTWebsomPagePG.";
			String sNumberOfQaq="";
			String[] aTXFields = {"carrierNameTX"};

			try
			{
				System.out.println("Start --> carrierShipment");
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				
				driver.findElement(By.logicalName(sScreenName+"homeWE")).click();
				Assert.pass("Clicked on pack home link");
				GenericActions.driver_WaitForElementVisible(sScreenName+"carrierNameTX");
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
				
				driver.findElement(By.logicalName(sScreenName+"carrierGoBN")).click();
				GenericActions.driver_WaitForElementVisible(sScreenName+"loadingIconWE");
				GenericActions.driver_WaitForElementInvisible(sScreenName+"loadingIconWE");
				Assert.pass("Clicked on carrier go  button ");
				
				GenericActions.driver_WaitForElementVisible(sScreenName+"carrierConfirmBN");
				driver.findElement(By.logicalName(sScreenName+"carrierConfirmBN")).click();
				Assert.pass("Clicked on carrier confirm button ");
				System.out.println("Clicked on carrier confirm button ");
				GenericActions.driver_WaitForElementVisible(sScreenName+"shipmentConfirmWE");
				if(driver.findElement(By.logicalName(sScreenName+"shipmentConfirmWE")).getText().equalsIgnoreCase(oTestData.getValue("shipmentConfirmWE")))
				{
					Assert.pass("Order is shipped ");
					System.out.println("Order is shipped ");
				}
				else
				{
					Assert.fail("Order is not shipped ");
					System.err.println("Order is notshipped ");
				}
				

			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in carrierShipment of the application was expected!");
					Assert.pass("Failure in carrierShipment of the application was expected!");
				}
				else
				{
					Assert.fail("carrierShipment  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> carrierShipment");
		}

	}
	
	
<<<<<<< HEAD:POSEIDON/LT/com/hbc/lt/websom/SFSFulfilment.java
	

	}
	
	
	
=======
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


	public static void startBagging(String sWorkBook, String sSheet, String sTestCase, int iIteration, boolean bExpectFailure)
	{

		if(!bErrorFound)
		{
			Assert.pass("Start --> startBagging");
			String sScreenName = "LTWebsomPagePG.";
			String sNumberOfQaq="";
			String[] aTXFields = {"carrierNameTX"};

			try
			{
				System.out.println("Start --> startBagging");
				DataTable oTestData=new DataTable(sWorkBook, sSheet, sTestCase);
				
				driver.findElement(By.logicalName(sScreenName+"homeWE")).click();
				Assert.pass("Clicked on pack home link");
				GenericActions.driver_WaitForElementVisible(sScreenName+"carrierNameTX");
				GenericActions.dataModify(sScreenName, oTestData, aTXFields, null, null, null, null, iIteration);
				
				driver.findElement(By.logicalName(sScreenName+"carrierGoBN")).click();
				GenericActions.driver_WaitForElementVisible(sScreenName+"loadingIconWE");
				GenericActions.driver_WaitForElementInvisible(sScreenName+"loadingIconWE");
				Assert.pass("Clicked on carrier go  button ");
				
				GenericActions.driver_WaitForElementVisible(sScreenName+"carrierConfirmBN");
				driver.findElement(By.logicalName(sScreenName+"carrierConfirmBN")).click();
				Assert.pass("Clicked on carrier confirm button ");
				System.out.println("Clicked on carrier confirm button ");
				GenericActions.driver_WaitForElementVisible(sScreenName+"shipmentConfirmWE");
				if(driver.findElement(By.logicalName(sScreenName+"shipmentConfirmWE")).getText().equalsIgnoreCase(oTestData.getValue("shipmentConfirmWE")))
				{
					Assert.pass("Order is shipped ");
					System.out.println("Order is shipped ");
				}
				else
				{
					Assert.fail("Order is not shipped ");
					System.err.println("Order is notshipped ");
				}
				

			}
			catch (Exception e) 
			{
				bErrorFound = true;
				e.printStackTrace();
				if(bExpectFailure)
				{
					System.out.println("Failure in startBagging of the application was expected!");
					Assert.pass("Failure in startBagging of the application was expected!");
				}
				else
				{
					Assert.fail("startBagging  failed ("+e.getStackTrace()+")");
				}
			} 
			Assert.pass("End --> startBagging");
		}

	}
	
>>>>>>> Yogiraj:POSEIDON/LT/com/hbc/lt/websom/LTFulfillmentPage.java
}
