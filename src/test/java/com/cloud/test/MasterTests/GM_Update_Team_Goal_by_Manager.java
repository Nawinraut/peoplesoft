/**
 Test Name: GM_Update_Team_Goal_by_Manager
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Update Team Goal by Manager
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
import com.cloud.pageobjects.HCM.GoalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class GM_Update_Team_Goal_by_Manager extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Update Team Goal by Manager")	
	public void GM_Update_Team_Goal_by_Mgr(String UserName,String Password,String ReviewPeriod,String GoalType,String WorkerName,String GoalName,String Priority) throws TestException,InterruptedException
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
		GoalsPage objgoal=objHome.clickGoals();
		/*if(objgoal.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Goals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Goals Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click the My Team Goals Icon button");
		objgoal.clickMyTeamGoalsIcon();
		*/
		if(objgoal.isMyTeamGoalsPageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.My Team Goals is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.My Team Goals is not displayed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click the Ciber Review Period list item");
		objgoal.clickReviewPeriodList();
		
		report.log(LogStatus.INFO, "Step 8. Click the Ciber Review Period list item");
		if(ReviewPeriod != "")
		{
			objgoal.selectReviewPeriodList(ReviewPeriod);
			report.log(LogStatus.PASS, "Step 8.1.Review Period is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Value of Review Period is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Add Goal button");
		objgoal.clickAddGoalButton();
		
		report.log(LogStatus.INFO, "Step 10. Click the New Goal list item");
		objgoal.selectGoalTypeNew(GoalType);
		
		report.log(LogStatus.INFO, "Step 11. Click the Goal Plan option.");
		objgoal.selectWorker(WorkerName);
		
		report.log(LogStatus.INFO, "Step 12.Click the Next button");
		objgoal.clickNextButton();
		
		report.log(LogStatus.INFO, "Step 13. Click in the Goal Name field");
		report.log(LogStatus.INFO, "Step 14. Enter the desired information into the Goal Name field");
		if(GoalName != "")
		{
			objgoal.enterGoalName(GoalName);
			report.log(LogStatus.PASS, "Step 14.1.Goal Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Value of Goal Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click the Priority list.");
		report.log(LogStatus.INFO, "Step 16. Click the High list item.");
		objgoal.selectPriority(Priority);
		
		report.log(LogStatus.INFO, "Step 17. Click the Save and Close button.");
		objgoal.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 18. Click the OK button.");
		objgoal.clickGLOKButton();
		
		sAssert.assertAll();
				
	}

}