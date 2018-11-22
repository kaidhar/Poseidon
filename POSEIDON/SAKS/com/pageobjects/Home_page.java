

package com.pageobjects;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;


public class Home_page {

	 WebDriver driver;
	    Properties prop = new Properties();
	    InputStream input = null;

    public Home_page(WebDriver ldriver)
    {
        this.driver=ldriver;
    }
    public void loadPropertiesFile() {
        String filepath=System.getProperty("user.dir")+"//Testdata/SAKS.properties";
        
        try {
            input = new FileInputStream(filepath);
            prop.load(input);
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
   }
   


    WebElement ClosePopup = driver.findElement(By.name(prop.getProperty("closepopup")));

    WebElement ChangeCountry = driver.findElement(By.name(prop.getProperty("Changeountry")));
    
    WebElement SwitchTous = driver.findElement(By.name(prop.getProperty("Switchus")));

   
    public void Close_popup(){
        ClosePopup.click();
    }

    public void Change_country(){
        ChangeCountry.click();
    }

    public void SwitchToUS(){
        SwitchTous.click();
    }
}
