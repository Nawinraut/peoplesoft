package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.JournalBatchNotificationPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class GL_How_to_Approve_Journal_by_GL_Manager extends BaseWebTest {
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is How to Approve Journal by GL Manager")	
	public void Cloud_How_to_Approve_Journal(String UserName,String Password,String Notification,String Action) throws TestException,InterruptedException
	{
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		if(objLogin.isUserNameDisplayed())
		{
			report.log(LogStatus.PASS, "Step 1.1.Cloud application is launched successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 1.1.Launching of Cloud application is  failed");
		}
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
			
		report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		if(objHome.isHomeImageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 3.1.Navigation to Home Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 3.1.Navigation to Home Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 4. Click the Notifications link.");
		objHome.clickNotificationsIcon();
		
		report.log(LogStatus.INFO, "Step 5. Click the appropriate notification link");
		objHome.selectExpNotification(Notification);
		
		SeleniumUtils.swithToWindow(driver, "Journal Batch");
		JournalBatchNotificationPage objERP=new JournalBatchNotificationPage(driver,report);
		
		report.log(LogStatus.INFO, "Step 6. Click the "+Action+" button.");
		objERP.clickPerformActions(Action);
		/*System.out.println(Action);
		if(Action == "Approve") {
			report.log(LogStatus.INFO, "Step 6. Click the Approve button.");
			objERP.clickApproveButton();
		}else {
			report.log(LogStatus.INFO, "Step 6. Click the Reject button.");
			objERP.clickRejectButton();
		}*/
		
		
		
	}

	}
