/**
 Test Name: PM_TrackCompletionStatusOfPerformanceDocumentsByManager
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for how to Track completion status of the Performance Documents By Manager
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.MasterTests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.HCM.PerformancePage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class PM_TrackCompletionStatusOfPerformanceDocumentsByManager extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Track completion status of the Performance Documents By Manager")	
	public void PM_TrackCompletionStatusPD_Mgr(String UserName,String Password,String WorkersType,String PerformanceDocuments) throws TestException,InterruptedException
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
		
		report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 5. Click the Goals Link");
		PerformancePage objPerf=objHome.clickPerformance();
		if(objPerf.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Performance Page is Loaded Successfully");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Performance Page is not Loaded");	
		}
			
		report.log(LogStatus.INFO, "Step 6. Click the My Organization button");
		objPerf.clickMyOrganization();
		
		report.log(LogStatus.INFO, "Step 7. Click the Filter button.");
		objPerf.clickFilterButton();
		
		report.log(LogStatus.INFO, "Step 8. Click the All reports option");
		objPerf.selectWorkersType(WorkersType);
				
		report.log(LogStatus.INFO, "Step 9. Select the appropriate performance document.Click the 2018 Performance Evaluation option");
		report.log(LogStatus.INFO, "Step 10. Click the 2018 evaluation option.");
		objPerf.checkPerformanceDocuments(PerformanceDocuments);
		
		report.log(LogStatus.INFO, "Step 11. Click the Apply button.");
		objPerf.clickApplyButton();
		
		report.log(LogStatus.INFO, "Step 12. Click the Task Completion Status link");
		report.log(LogStatus.INFO, "Step 13. Use the Task Completion Status tab to preview the completion status");
		objPerf.clickTaskCompStatus();
		
		sAssert.assertAll();
				
	}

}