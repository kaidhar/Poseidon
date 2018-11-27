package com.hbc.lt.reusable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hbc.acoe.framework.config.Environment;
import com.hbc.acoe.framework.selenium.Actions;
import com.hbc.acoe.framework.selenium.By;
import com.hbc.acoe.framework.selenium.FrameworkDriver;
import com.hbc.acoe.framework.selenium.Select;
import com.hbc.acoe.framework.selenium.WebElement;
import com.hbc.acoe.framework.selenium.testdata.DataTable;
import com.hbc.acoe.framework.selenium.verify.Assert;

public class GenericActions {

	public static WebDriver driver = FrameworkDriver.driver; 
	public static String sOrderNumber="";





	/**
	 * dataModify - Add or Edit data in given page
	 * @param sScreenName - screen name to be modified
	 * @param oTestData - Data object pulled from data table
	 * @param aTXFields - TX fields to be modified
	 * @param aWLFields - WL fields to be modified
	 * @param aRBFields - RB fields to be modified
	 * @param aCBFields - CB fields to be modified
	 * @param aWEFields - WE fields to be modified
	 * @param iIteration - iteration of data to use (if more than 1)
	 * @throws InterruptedException
	 */
	/*
	'**********************************************************************************************************
	'  Name         :  dataModify
	'  Description  :  Add or Edit data in given page 
	'----------------------------------------------------------------------------------------------------------
	'  Created by 	:  
	'  Create Date	:  
	'----------------------------------------------------------------------------------------------------------
	'  Notes        : 
	'----------------------------------------------------------------------------------------------------------
	'**********************************************************************************************************
	 */
	public static void dataModify(String sScreenName, DataTable oTestData, String[] aTXFields, String[] aWLFields, String[] aRBFields, String[] aCBFields, String[] aWEFields, Integer iIteration) throws Exception
	{
		Assert.pass("Start --> dataModify");
		System.out.println("Start --> dataModify");

		// variable declaration
		String sDTValue = "";

		//		try 
		//		{		
		// enter values for CB fields
		if (aCBFields != null)
		{
			for (String sCBField:aCBFields)
			{
				sDTValue = oTestData.getValue(sCBField, iIteration);
				if (!(sDTValue.equalsIgnoreCase(""))&&!(sDTValue.equalsIgnoreCase("NA")))
				{
					if(GenericActions.driver_WaitForElementVisible(sScreenName+sCBField))
					{
						if (sDTValue.equalsIgnoreCase("Y")||sDTValue.equalsIgnoreCase("ON"))
						{
							if (!driver.findElement(By.logicalName(sScreenName+sCBField)).isSelected())
							{
								driver.findElement(By.logicalName(sScreenName+sCBField)).click();	
							}
						}
						else
						{
							if (driver.findElement(By.logicalName(sScreenName+sCBField)).isSelected())
							{
								driver.findElement(By.logicalName(sScreenName+sCBField)).click();	
							}
						}

						//write field/value line
						Assert.pass("Field ("+sCBField+") - Value ("+sDTValue+")");
						System.out.println("Field ("+sCBField+") - Value ("+sDTValue+")");
					}
					sDTValue = "";      
				}
			}
		} 
		if (aRBFields != null)
		{
			for (String sRBField:aRBFields)
			{
				sDTValue = oTestData.getValue(sRBField, iIteration);
				if (!(sDTValue.equalsIgnoreCase(""))&&!(sDTValue.equalsIgnoreCase("NA")))
				{
					if (sDTValue.equalsIgnoreCase("Y")||sDTValue.equalsIgnoreCase("ON"))

					{
						driver.findElement(By.logicalName(sScreenName+sRBField)).click();  
					}

					//write field/value line
					Assert.pass("Field ("+sRBField+") - Value ("+sDTValue+")");
					System.out.println("Field ("+sRBField+") - Value ("+sDTValue+")");
				}
				sDTValue = "";                   
			}
		}


		// enter values for WL fields
		if (aWLFields != null)
		{
			for (String sWLField:aWLFields)
			{
				GenericActions.driver_MoveToElement(driver.findElement(By.logicalName(sScreenName + sWLField)));
				sDTValue = oTestData.getValue(sWLField, iIteration);
				if (!(sDTValue.equalsIgnoreCase(""))&&!(sDTValue.equalsIgnoreCase("NA")))
				{
					if(sWLField.contains("ByValWL"))
					{
						new Select(driver.findElement(By.logicalName(sScreenName+sWLField))).selectByValue(sDTValue);
					}
					else if(sWLField.contains("ByIndexWL"))
					{
						new Select(driver.findElement(By.logicalName(sScreenName+sWLField))).selectByIndex(Integer.parseInt(sDTValue));
					}
					else
					{
						new Select(driver.findElement(By.logicalName(sScreenName+sWLField))).selectByVisibleText(sDTValue);
					}
					//write field/value line
					Assert.pass("Field ("+sWLField+") - Value ("+sDTValue+")");
					System.out.println("Field ("+sWLField+") - Value ("+sDTValue+")");
				}
				sDTValue = "";
			}
		}

		// enter values for TX fields
		if (aTXFields != null)
		{ 
			for (String sTXField:aTXFields)
			{
				sDTValue = oTestData.getValue(sTXField, iIteration);
				/*if (sTXField.equalsIgnoreCase("signInUsernameTX") ||sTXField.equalsIgnoreCase("signInPasswordTX") ||sTXField.equalsIgnoreCase("signUpEMailTX") ||sTXField.equalsIgnoreCase("signUpPasswordTX") || sTXField.equalsIgnoreCase("signUpPasswordConfirmTX")) 

				 */
				driver.findElement(By.logicalName(sScreenName+sTXField)).clear();

				if (!(sDTValue.equalsIgnoreCase("")) && !(sDTValue.equalsIgnoreCase("NA")))
				{
					driver_WaitForElementVisible(sScreenName+sTXField);
					/*if(sTXField.equalsIgnoreCase("primaryContactPhoneNumberTX"))
					{
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.logicalName(sScreenName + sTXField)));
					}
					else
					{
						GenericActions.driver_MoveToElement(driver.findElement(By.logicalName(sScreenName + sTXField)));
					}*/
					/*if(!(sUsername.equalsIgnoreCase("")) && ((sTXField.equalsIgnoreCase("signUpEMailTX")) || (sTXField.equalsIgnoreCase("signInUsernameTX")) || (sTXField.equalsIgnoreCase("passwordForgotMemberUsernameTX"))))
					{
						GenericActions.driver_WaitForElementInvisible("HomePG.systemLoaderWE");
						driver.findElement(By.logicalName(sScreenName+sTXField)).clear();
						//driver_Wait((int) 0.1);
						driver.findElement(By.logicalName(sScreenName+sTXField)).click();
						GenericActions.driver_WaitForElementInvisible("HomePG.systemLoaderWE");
						driver.findElement(By.logicalName(sScreenName+sTXField)).sendKeys(sUsername);

						//write field/value line
						Assert.pass("Field ("+sTXField+") - Value ("+sUsername+")");
						System.out.println("Field ("+sTXField+") - Value ("+sUsername+")");
					}
					else
					{*/
					driver.findElement(By.logicalName(sScreenName+sTXField)).clear();
					/*GenericActions.driver_WaitForElementInvisible("HomePG.systemLoaderWE");
					 */	driver_Wait((int) 0.8);
					 driver.findElement(By.logicalName(sScreenName+sTXField)).click();
					 //GenericActions.driver_WaitForElementInvisible("HomePG.systemLoaderWE");	
					 driver.findElement(By.logicalName(sScreenName+sTXField)).sendKeys(sDTValue);

					 //write field/value line
					 Assert.pass("Field ("+sTXField+") - Value ("+sDTValue+")");
					 System.out.println("Field ("+sTXField+") - Value ("+sDTValue+")");
					 //}
				}
				sDTValue = "";
			}
		}

		//		} catch (NoSuchElementException e)  
		//		{
		//			Assert.fail("Adding/Editing data encountered errors ("+e.getMessage()+")");
		//			System.out.println("Adding/Editing data encountered errors ("+e.getMessage()+")");
		//		}
		Assert.pass("End --> dataModify");
		System.out.println("End --> dataModify");
	}


	/*'**********************************************************************************************************
    '  Name         :  driver_WaitForElementInvisible
    '  Description  :  Method to wait for element until Invisible
    '----------------------------------------------------------------------------------------------------------
    '  Created by        :  
    '  Create Date       :  
    '----------------------------------------------------------------------------------------------------------
    '  Notes        : 
    '----------------------------------------------------------------------------------------------------------
    '**********************************************************************************************************
	 */
	public static void driver_WaitForElementInvisible(String sElementLogicalName) throws Exception {

		Long lElementTimeOut = Long.parseLong(Environment.get("ElementTimeOut"));

		new WebDriverWait(driver, lElementTimeOut)
		.until(ExpectedConditions.invisibilityOfElementLocated(By.logicalName(sElementLogicalName)));
	}


	/*'**********************************************************************************************************
    '  Name         :  driver_MoveToElement
    '  Description  :  Method to move focus to the webelements
    '----------------------------------------------------------------------------------------------------------
    '  Created by        :  
    '  Create Date       :  
    '----------------------------------------------------------------------------------------------------------
    '  Notes        : 
    '----------------------------------------------------------------------------------------------------------
    '**********************************************************************************************************
	 */

	public static void driver_MoveToElement(org.openqa.selenium.WebElement webElement) throws Exception 
	{

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -225)", "");
	}


	public static String getTestDataFile()
	{
		String sTestDataFile = "";

		sTestDataFile = Environment.get("test_data_path");

		return sTestDataFile;
	}


	/*
	'**********************************************************************************************************
	'  Name         :  
	'  Description  :  
	'----------------------------------------------------------------------------------------------------------
	'  Created by 	:  
	'  Create Date	:  
	'----------------------------------------------------------------------------------------------------------
	'  Notes        : 
	'----------------------------------------------------------------------------------------------------------
	'**********************************************************************************************************
	 */
	
	public static String getTestOrderFile()
	{
		String sTestOrderFile = "";

		sTestOrderFile = Environment.get("test_order_path");

		return sTestOrderFile;
	}
	
	/*
	'**********************************************************************************************************
	'  Name         :  chrome_HeadlesBrowser
	'  Description  :  Method to launch chroem healdess browser
	'----------------------------------------------------------------------------------------------------------
	'  Created by 	:  
	'  Create Date	:  
	'----------------------------------------------------------------------------------------------------------
	'  Notes        : 
	'----------------------------------------------------------------------------------------------------------
	'**********************************************************************************************************
	 */

	public static WebDriver setMyDriver()
	{
		try
		{
			System.out.println("Start -> chrome_HeadlessBrowser");
			String sBrowserHeadless = Environment.get("headlessdriver");
			String _driver = Environment.get("driver");
			if(sBrowserHeadless.equalsIgnoreCase("Yes"))
			{
				FrameworkDriver.driver.quit();
				System.out.println("Start -> Headless browser is started ");
				System.setProperty("webdriver.chrome.driver", Environment.get("driver_path"));   
				ChromeOptions chromeOptions = new ChromeOptions();
				//chromeOptions.addArguments("--headless");
				//chromeOptions.addArguments("--start-maximized");
				driver = new ChromeDriver(chromeOptions);
				FrameworkDriver.driver = driver;
				Assert.pass("Headless Driver Initialization Success");
			}
			if(_driver.equalsIgnoreCase("IE"))
			{
				FrameworkDriver.driver.quit();
				System.out.println("Start -> IE browser is started ");
				System.setProperty("webdriver.ie.driver", Environment.get("driver_path"));   
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setCapability("requireWindowFocus", true);
				driver = new InternetExplorerDriver(capabilities);
				FrameworkDriver.driver = driver;
				Assert.pass("IE Driver Initialization Success");
			}
			return FrameworkDriver.driver;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("headless Driver Initialization failed");
			return null;
		}
	}

	/*
	'**********************************************************************************************************
	'  Name         :  turnOFFImplicitWait
	'  Description  :  Method to set implicit wait to Zero seconds
	'----------------------------------------------------------------------------------------------------------
	'  Created by 	:  
	'  Create Date	:  
	'----------------------------------------------------------------------------------------------------------
	'  Notes        : 
	'----------------------------------------------------------------------------------------------------------
	'**********************************************************************************************************
	 */
	public static void turnOFFImplicitWait() {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	/*
	'**********************************************************************************************************
	'  Name         :  waitForDomToLoad
	'  Description  :  Method to wait for the element to present on Dom
	'----------------------------------------------------------------------------------------------------------
	'  Created by 	:  
	'  Create Date	:  
	'----------------------------------------------------------------------------------------------------------
	'  Notes        : 
	'----------------------------------------------------------------------------------------------------------
	'**********************************************************************************************************
	 */
	public static void waitForDomToLoad(WebDriver driver) {

		Boolean state=new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
		((JavascriptExecutor) wd).executeScript("return document.readyState").toString().equals("complete"));
		System.out.println("DOM state----------->"+state);        
	}

	/*
    '**********************************************************************************************************
    '  Name         :  driver_WaitForElementVisible
    '  Description  :  Method to wait for element until visible and clickable
    '----------------------------------------------------------------------------------------------------------
    '  Created by        :  
    '  Create Date       : 
    '----------------------------------------------------------------------------------------------------------
    '  Notes        : 
    '----------------------------------------------------------------------------------------------------------
    '**********************************************************************************************************
	 */
	public static boolean driver_WaitForElementVisible(String sElementLogicalName) {

		System.out.println("sElementLogicalName-----"+sElementLogicalName);
		String sElement= sElementLogicalName.split("\\.")[1];
		int lElementTimeOut;

		try	
		{
			if(sElement.contains("ErrorWE") ){
				lElementTimeOut = 3;
			}		
			else
			{
				lElementTimeOut = Integer.parseInt(Environment.get("ElementTimeOut"));
			}

			new WebDriverWait(driver, lElementTimeOut)
			.until(ExpectedConditions.visibilityOfElementLocated(By.logicalName(sElementLogicalName)));
			Assert.pass(sElement + " is Visible");
			return true;
		}
		catch(Exception e)
		{

			Assert.pass(sElement + " is not Visible");
			return false;
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
	public static void driver_Wait(int value)
	{
		try
		{
			Thread.sleep(value*1000);
		}
		catch (Exception e) {
			// TODO: handle exception
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

	public static void driver_Actions()
	{
		try
		{

			Actions dActions = new Actions(driver);
			dActions.sendKeys(Keys.ESCAPE);
		}
		catch (Exception e) {
			// TODO: handle exception
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

	public static String extractOnlyNumber(String order)
	{
		try
		{
			

			//extracting string
			sOrderNumber=order.replaceAll("[^0-9]", "");

			System.out.println("Numbers are: " + sOrderNumber);

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return sOrderNumber;
	}

}
