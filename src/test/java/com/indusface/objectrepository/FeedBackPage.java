package com.indusface.objectrepository;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.indusface.util.CommonUtil;

public class FeedBackPage {
public static Logger log= Logger.getLogger(FeedBackPage.class);
	 
	
	@FindBy(xpath="//h2[contains(text(),'406')]")
	public static WebElement MaliciousText;
	
	@FindBy(xpath="//h4[contains(text(),'Incident Time')]")
	public static  WebElement IncidentTime;
	
	@FindBy(xpath="//h4[contains(text(),'Incident ID')]")
	public static WebElement IncidentID;
	
	public static boolean validateFeedBackPage(){
		try{
			CommonUtil.implicitWait(100);
			String getText=CommonUtil.getText("//h2[contains(text(),'406 Something Malicious')]");
			CommonUtil.implicitWait(100);
			Assert.assertTrue(getText.contains("Something Malicious"),"loading FeedBack Page Failed...");
			log.info("FeedBackPage launched Sucessfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	public static void setValueInConfigFile(){
		
		String MaliciousText=FeedBackPage.MaliciousText.getText();
		String IncidentTime=FeedBackPage.IncidentTime.getText();
		String IncidentID=FeedBackPage.IncidentTime.getText();
		CommonUtil.setPropertyValue(MaliciousText,IncidentTime,IncidentID);
	}
	
}
