package com.indusface.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.indusface.util.CommonUtil;
import com.indusface.util.Driver;

public class HomePage {
public static Logger log= Logger.getLogger(HomePage.class);
	 
	
	@FindBy(id="txtSearch")
	public static WebElement searchBox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Go']")
	public static WebElement goButton;
	
	@FindBy(xpath="//h2[contains(text(),'406 Something Malicious')]")
	public static WebElement maliciousText;
	
	
	public boolean validateHomePage(){
		try{
			CommonUtil.implicitWait(100);
			String title=CommonUtil.getTitle();
			Assert.assertTrue(title.contains("Altoro Mutual"),"launching Home Page Failed...");
			log.info("Home page launched Sucessfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	public void attackXSS(String vector){
		try{
			CommonUtil.implicitWait(10);
			log.info("Clearing searchBox...");
			searchBox.clear();
			log.info("Entering vector value in the  searchBox...");
			searchBox.sendKeys(vector);
			log.info("Clicking on Go button...");
			CommonUtil.implicitWait(50);
            goButton.click();
		}catch(Exception e){
			e.printStackTrace();
			}
	}
	
}
