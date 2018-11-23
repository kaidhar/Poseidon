package com.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {
	
	Properties prop = new Properties();
    InputStream input = null;
    String filepath="";
	
	 public String getProperty(String Prop) throws IOException {
	    	
	    	filepath=System.getProperty("user.dir")+"//Testdata/SAKS.properties";
			input = new FileInputStream(filepath);
			prop.load(input);
			String Value = prop.getProperty(Prop);
			return Value;

		}

}