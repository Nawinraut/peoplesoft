/**
 Test Name: PM_SharePerformanceDocumentswithEmployeebyManager
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for how to share Performance Documents with Employee by Manager
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.HCM2;

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
	public class PM_SharePerformanceDocumentswithEmployeebyManager extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to share Performance Documents with Employee by Manager")	
	public void PM_SharePDwithEmp_by_Mgr(String UserName,String Password,String ReviewPeriod,String EmpName) throws TestException,InterruptedException
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
			
		report.log(LogStatus.INFO, "Step 6. Click the My Manager Evaluations: Ciber 2019 Review Period� list");
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
		
		
		report.log(LogStatus.INFO, "Step 9. Click the Manager Evaluation of Workers link for any of the Employee");
		if(EmpName != "")
		{
			objPerf.clickGoals(EmpName,"Share Performance Document");
			report.log(LogStatus.PASS, "Step 9.1.Clicked on Manager Evaluation of Workers link successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Not clicked on Manager Evaluation of Workers link");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click the vertical scrollbar up.");
		SeleniumUtils.scroll(driver, 0, -500);
				
		report.log(LogStatus.INFO, "Step 11. Click the Share and Release button");
		objPerf.clickShareandRelease();
				
		report.log(LogStatus.INFO, "Step 12. Click in the Comments field.");
		report.log(LogStatus.INFO, "Step 13. Enter the desired information into the Comments field.");
//		objPerf.enterShareandReleaseComments("Completed");
		
		report.log(LogStatus.INFO, "Step 14. Click the OK button.");
		objPerf.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 15. Click the OK button.");
		objPerf.clickOkButton();
		
		sAssert.assertAll();
				
	}

}