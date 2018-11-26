package com.hbc.lt.regression;

import com.hbc.acoe.framework.config.Environment;
import com.hbc.acoe.framework.selenium.verify.Assert;
import com.hbc.lt.reusable.GenericActions;
import com.hbc.lt.reusable.HomePage;


public class HomePageTest {
	
	
	static String sWorkBook = GenericActions.getTestDataFile();
	static String sSheet = "LTHomePage";
	static String sTestCase = "";
	static int iIteration = 1;
	//static String sWorkBook="";s
	
	
	

	public static void TC_ToLoginToLT()
	{
		Assert.pass("Start-------> TC_ToLoginToLT");
		System.out.println("Start-------> TC_ToLoginToLT");
		
		sTestCase="TC_ToLoginToLT";
		HomePage.openURL(sWorkBook, sSheet, sTestCase, iIteration, false);
		HomePage.searchItem(sWorkBook, sSheet, sTestCase, iIteration, false);
		
		Assert.pass("Start-------> TC_ToLoginToLT");
		System.out.println("End-------> TC_ToLoginToLT");
	}

	

	
	
}
