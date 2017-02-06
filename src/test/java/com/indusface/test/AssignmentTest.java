package com.indusface.test;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.indusface.objectrepository.FeedBackPage;
import com.indusface.objectrepository.HomePage;
import com.indusface.util.CommonUtil;
import com.indusface.util.Driver;

public class AssignmentTest {
	HomePage homepage=PageFactory.initElements(Driver.driver, HomePage.class);
	FeedBackPage feedbackpage=PageFactory.initElements(Driver.driver, FeedBackPage.class);
	public static Logger log= Logger.getLogger(AssignmentTest.class);

	
	@BeforeClass
	public void launchBrowser(){
		CommonUtil.launchBrowser(CommonUtil.getPropertyValue("URL"));
		log.info("Browser Opened successfully");
		
		
	}
	@AfterClass
	public void quiteBrowser(){
		 CommonUtil.closeBrowser();
		 log.info("Browser Closed Successfully");
		 
	}
  @Test
  public void test() {
	   boolean isValidateHoemPage= homepage.validateHomePage();
	   Assert.assertTrue(isValidateHoemPage,"Validate HoemPage Failed...");
	   log.info("validate Home page Successfully.....");
	   
	   
	   homepage.attackXSS(CommonUtil.getPropertyValue("Vector1"));
	   log.info("Attacked with XSS value="+CommonUtil.getPropertyValue("Vector1"));
	   
	   boolean isvalidateFeedBackPageWithVector1=FeedBackPage.validateFeedBackPage();
	   Assert.assertTrue(isvalidateFeedBackPageWithVector1,"Validate FeedBack Page Failed...");
	   log.info("validate FeedBack Page Successfully.....");
	   
	   
	   feedbackpage.setValueInConfigFile();
	   log.info("Save the results in Properties file");
	   
	   CommonUtil.navigateBack();
	   log.info("Navigate to Previous page");
	   CommonUtil.refreshPage();
	   log.info("Refresh the browser");
	   
	   
	   homepage.attackXSS(CommonUtil.getPropertyValue("Vector2"));
	   log.info("Attacked with XSS value="+CommonUtil.getPropertyValue("Vector2"));
	   boolean isvalidateFeedBackPageWithVector2=FeedBackPage.validateFeedBackPage();
	   Assert.assertTrue(isvalidateFeedBackPageWithVector2,"Validate MaliciousPage Failed...");
	   log.info("Validate FeedBack Page Successfully.....");
	   
	  
	   feedbackpage.setValueInConfigFile();
	   log.info("Save the results in Properties file");

	  
  }
  
 
}
