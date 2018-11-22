package com.pageobjects;
import org.openqa.selenium.Keys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

public class SkuSearchpage {

    WebDriver driver;
    Properties prop = new Properties();
    InputStream input = null;

    public SkuSearchpage (WebDriver Qdriver)
    {
        this.driver=Qdriver;
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
    
    
    WebElement Search = driver.findElement(By.name(prop.getProperty("Searchsku")));
    public void SearchSku()
    {
        Search.sendKeys("0467558208102",Keys.ENTER);
    }


}


