package com.cloud;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cloud.driver.WebDriverType;
import com.cloud.driver.WebDriverUtil;

public class WebDriverTest extends BaseWebTest{
	
	public WebDriverType drivertype;
	public WebDriver driver;
	
	@SuppressWarnings("unchecked")
	public static <T extends WebDriver> T initializeDriver(WebDriverType drivertype)
	{
		T driver=null;
				
      	switch (drivertype)
    	{

        	case chrome:
        		 			WebDriverUtil.initializeChrome();
        		 			ChromeOptions options = new ChromeOptions();
        		 			//below is to disable chrome is being controlled by popup
        		 			options.addArguments("disable-infobars");
        		 			//options.addArguments("--disable-notifications");
        		 			
        		 			        		 			
        		 		/*	options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        		 			Map<String, Object> prefs = new HashMap<>();
        		 			// Enable flash for all sites for Chrome 69
        		 		
        		 			// Enable Flash
        		 		//	prefs.put("profile.default_content_setting_values.notifications", 2);
        		 			prefs.put("profile.default_content_setting_values.plugins", 1);
        		 			
        		 			prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
        		 			prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
        		 			prefs.put("profile.default_content_settings.state.flash",1);  
        		 			
        		 			// Hide save credentials prompt
        		 			prefs.put("credentials_enable_service", false);
        		 			prefs.put("profile.password_manager_enabled", false);
        		 			options.setExperimentalOption("prefs", prefs);*/
        		 			
        		 			
        		 			
        		 			driver=(T) new ChromeDriver(options);
			                break;
        	case firefox:
        					WebDriverUtil.initializeFirefox();
			        		driver = (T) new FirefoxDriver();
			                break;
        	case ie:
        					WebDriverUtil.initializeInternetExplorer();
        				    driver = (T) new InternetExplorerDriver();
        					break;
        	default:
        					WebDriverUtil.initializeChrome();
        					driver =  (T) new ChromeDriver();
        					break;
    	}
      	
      	return  driver;
			
				
	}

}
