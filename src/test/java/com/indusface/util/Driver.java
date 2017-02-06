package com.indusface.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
public static WebDriver driver = browserFactory();
	
	public static WebDriver browserFactory(){
		String browser = CommonUtil.getPropertyValue("BROWSER_TYPE");
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		       driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("FireFox")){
			 System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		       driver = new FirefoxDriver();
		}
		return driver;
		
	}
}
