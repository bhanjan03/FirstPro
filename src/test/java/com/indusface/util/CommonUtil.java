package com.indusface.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.By;

public class CommonUtil {
	public static Properties props = new Properties();
	static InputStream input = null;
	public static PropertiesConfiguration config=null;
	
	public static String getPropertyValue(String property){
		try {
			
			input = new FileInputStream("src/test/resources/config.properties");
    		props.load(input);
    		}catch (IOException ex) {
    			ex.printStackTrace();
    			} finally {
    				if (input != null) {
    					try {
    						input.close();
    						} catch (IOException e) {
    							e.printStackTrace();
    							}
    					}
    				
    			}
		return props.getProperty(property);
		}
	
	
	public static void setPropertyValue(String MaliciousText,String IncidentTime,String IncidentID)  {
		try{
		config = new PropertiesConfiguration("src/test/resources/config.properties");
		config.setProperty("MaliciousText", MaliciousText);
		config.setProperty("IncidentTime", IncidentTime);
		config.setProperty("IncidentID", IncidentID);
		config.save();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static String getTitle(){
		return Driver.driver.getTitle();
	}
	public static void implicitWait(int timetowait){
		Driver.driver.manage().timeouts().implicitlyWait(timetowait, TimeUnit.SECONDS);
	}
	
	public static void launchBrowser(String URL){
		Driver.driver.manage().window().maximize();
		Driver.driver.get(URL);
		
	}
	
	public static void closeBrowser(){
		Driver.driver.close();
	}
	public static void refreshPage(){
		Driver.driver.navigate().refresh();
		implicitWait(50);
		
	}
	
	public static void navigateBack(){
		try{
			implicitWait(50);
			Driver.driver.navigate().back();
			implicitWait(50);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
		public static String getText(String xpath)
		{
			String str= Driver.driver.findElement(By.xpath(xpath)).getText();
			return str;
		}
	}
