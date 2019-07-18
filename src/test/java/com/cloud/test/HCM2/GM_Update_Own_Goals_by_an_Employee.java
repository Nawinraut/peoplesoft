/**
 Test Name: GM_Update_Own_Goals_by_an_Employee
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to update own Goals  by an Employee
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
import com.cloud.pageobjects.HCM.CareerandPerformancePage;
import com.cloud.pageobjects.HCM.GoalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class GM_Update_Own_Goals_by_an_Employee extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to update own Goals by an Employeer")	
	public void GM_Update_OwnGoals_by_Emp(String UserName,String Password,String GoalName,String Status,String ActualCompletionDate) throws TestException,InterruptedException
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
		
		report.log(LogStatus.INFO, "Step 5. Click the Career and Performance Link");
		CareerandPerformancePage objcp=objHome.clickCareerandPerformance();
		
		report.log(LogStatus.INFO, "Step 6. Click the Goals Link");
		GoalsPage objgoal=objcp.clickGoals();
		if(objgoal.isGoalsPageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.My Goals page is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.My Goals page is not displayed");	
		}
		
		report.log(LogStatus.INFO, "Step 7.Click on any Goal link.");
		if(GoalName != "")
		{
			objgoal.clickGoalLink1(GoalName);
			report.log(LogStatus.PASS, "Step 7.1.Goal Name is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Value of Goal Name is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 8. Click the Status list.");
		report.log(LogStatus.INFO, "Step 9. Click the In progress list item.");
		if(Status != "")
		{
			objgoal.selectStatus(Status);
			report.log(LogStatus.PASS, "Step 9.1.Status is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Value of Status is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Clicked on Select Actual Completion Date picker");
		objgoal.clickActaulCompDate();
		
		report.log(LogStatus.INFO, "Step 11. Select the appropriate date");
		if(ActualCompletionDate != "")
		{
			objgoal.selectDayFromActualCompDate(ActualCompletionDate);
			report.log(LogStatus.PASS, "Step 11.1.ActualCompletionDate is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Value of ActualCompletionDate is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click the Save and Close button.");
		objgoal.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 13. Click the OK button.");
		objgoal.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 14. Click the Submit for Approval link");
		objgoal.clickSubmitForApprovalButton();
		
		report.log(LogStatus.INFO, "Step 15. Click the Submit button");
		objgoal.clickSubmitButton();
		
		sAssert.assertAll();
				
	}

}