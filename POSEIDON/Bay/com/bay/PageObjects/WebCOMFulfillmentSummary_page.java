package com.bay.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bay.helper.Utilities;

public class WebCOMFulfillmentSummary_page {

	WebDriver driver;
	WebDriverWait wait = null;
	WebElement ele;
	Utilities prop = new Utilities();

	public WebCOMFulfillmentSummary_page(WebDriver ldriver) {
		wait = new WebDriverWait(ldriver, 20);
		this.driver = ldriver;
	}

	public void SelectShippingMethod(String service) throws IOException, Exception {
		try {

			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("LinenumberCheckBox"))));
			ele.click();

			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ShippngMethodBtn"))));
			ele.click();

			ele = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("LevelofService"))));
			ele.clear();
			ele.sendKeys(service);

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ApplyButton"))));
			ele.click();

			Thread.sleep(6000);

			ele = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(prop.getProperty("FullfillmenyNextButton"))));
			ele.click();

			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ConfirmationOKBtn"))));
			ele.click();

		} catch (IOException e) {
			System.out.println("Failed in SelectShippingMethod page");
			e.printStackTrace();
		}

	}

	public void ConfirmOrder() throws IOException, Exception {
		try {

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ConfirmOrder"))));
			ele.click();

		} catch (IOException e) {
			System.out.println("Failed in ConfirmOrder page");
			e.printStackTrace();
		}

	}

	/* Payment method adding */

	public void AddPaymentMethodCreditcard(String Paymenttype) throws IOException, Exception {
		try {

			Thread.sleep(6000);
			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("AddPaymentMedhod"))));
			ele.click();

			ele = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("PaymentTypeTB"))));
			ele.clear();
			ele.sendKeys(Paymenttype);

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CardNumberTB"))));
			ele.clear();
			ele.sendKeys(prop.getProperty("MasterCard"));

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CardTypeTB"))));
			ele.clear();
			ele.sendKeys(prop.getProperty("CardType"));

			Thread.sleep(6000);

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("NameOnCardTB"))));
			ele.clear();
			ele.sendKeys(prop.getProperty("NameOnCard"));

			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ExpirationMonthTB"))));
			ele.clear();
			ele.sendKeys(prop.getProperty("ExpirationMonth"));

			ele = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("ExpirationYearTB"))));
			ele.clear();
			ele.sendKeys(prop.getProperty("ExpirationYear"));

			ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("CVVTB"))));
			ele.clear();
			ele.sendKeys(prop.getProperty("CVV"));

			ele = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(prop.getProperty("AddPaymentMethodApplybtn"))));
			ele.click();

		} catch (IOException e) {
			System.out.println("Failed in AddPaymentMethodCreditcard page");
			e.printStackTrace();
		}

	}

}
