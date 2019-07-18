/**
 Test Name: PM_ConfirmReviewMeeting_Held_by_Manager
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for how to Confirm Review Meeting Held by Manager
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
	public class PM_ConfirmReviewMeeting_Held_by_Manager extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is how to Confirm Review Meeting Held by Manager")	
	public void PM_ConfirmReviewMeetingHeld_Mgr(String UserName,String Password,String ReviewPeriod,String EmpName,String MettingHeldDate) throws TestException,InterruptedException
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
		
		report.log(LogStatus.INFO, "Step 6. Click the My Manager Evaluations: Ciber 2019 Review Period… list");
		objPerf.clickReviewPeriodList();
		
		report.log(LogStatus.INFO, "Step 7. Click the Ciber Review Period list item");
		if(ReviewPeriod != "")
		{
			objPerf.selectReviewPeriodList(ReviewPeriod);
			report.log(LogStatus.PASS, "Step 7.1.Review Period is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Value of Review Period is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 8. Click the vertical scrollbar.");
		SeleniumUtils.scroll(driver, 0, 300);
		
		report.log(LogStatus.INFO, "Step 9. Click the Confirm Review Meeting Held link for any of the Employee");
		if(EmpName != "")
		{
			objPerf.clickGoals(EmpName,"Confirm Review Meeting Held");
			report.log(LogStatus.PASS, "Step 9.1.Clicked on Confirm Review Meeting Held link successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Not clicked on Confirm Review Meeting Held link");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click the Select Metting Held Date button");
		objPerf.clickSelectDateIcon();
		
		report.log(LogStatus.INFO, "Step 11. Select the appropriate date.Click the 27 cell.");
		objPerf.selectMeetingHeldDate(MettingHeldDate);
		
		report.log(LogStatus.INFO, "Step 12. Click the Yes button.");
		objPerf.clickYesConfrimButton();
		
		report.log(LogStatus.INFO, "Step 13. Click the OK button.");
		objPerf.clickOkButton();
		
		sAssert.assertAll();
				
	}

}