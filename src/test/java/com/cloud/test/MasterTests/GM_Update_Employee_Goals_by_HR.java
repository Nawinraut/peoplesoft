/**
 Test Name: GM_Update_Employee_Goals_by_HR
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Update Employee Goals by HR
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
	public class GM_Update_Employee_Goals_by_HR extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Update Employee Goals by HR")	
	public void GM_Update_Emp_Goals_by_HR(String UserName,String Password,String ReviewPeriod,String SearchGoalText,String GoalPlan,String GoalDescription,String GoalType,String GoalNameToSearch,String ToSelectGoalName) throws TestException,InterruptedException
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
		if(objgoal.isMyTeamGoalsPageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.My Team Goals is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.My Team Goals is not displayed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on My Goals icon");
		objgoal.clickMyGoalsIcon();
		if(objgoal.isGoalsPageDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.My Goals page is displayed");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.My Goals page is not displayed");	
		}

		
		report.log(LogStatus.INFO, "Step 7. Click Tasks button");
		objgoal.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 8. Click the Manage Goal Plans link");
		objgoal.clickManageGoalPlansLink();
		if(objgoal.isCreateGoalPlanButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 8.1.Clicked on Manage Goal Plans Link is successful");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Clicked on Manage Goal Plans Link is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Review Period list.");
		objgoal.clickReviewPeriodLink();
		
		report.log(LogStatus.INFO, "Step 10. Click the Ciber Review Period list item");
		if(ReviewPeriod != "")
		{
			objgoal.selectReviewPeriod(ReviewPeriod);
			report.log(LogStatus.PASS, "Step 10.1.Review Period is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Value of Review Period is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click in the Goal Plan field");
		report.log(LogStatus.INFO, "Step 12. Enter the desired information into the Goal Plan field");
		if(SearchGoalText != "")
		{
			objgoal.setGoalPlan(SearchGoalText);
			report.log(LogStatus.PASS, "Step 12.1.Goal Plan Search Text is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Value of Goal Plan is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click the Search button");
		objgoal.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 14. Click the Goal Plan link");
		if(GoalPlan != "")
		{
			objgoal.selectGoalPlanLink(GoalPlan);
			report.log(LogStatus.PASS, "Step 14.1.Goal Plan is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Value of Goal Plan is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click in the Description field");
		report.log(LogStatus.INFO, "Step 16. Enter the desired information into the Description field");
		if(GoalDescription != "")
		{
			objgoal.enterDescription(GoalDescription);
			report.log(LogStatus.PASS, "Step 16.1.Goal Description is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 16.1.Value of Goal Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click the Next button");
		objgoal.clickNextButton();
		
		report.log(LogStatus.INFO, "Step 18. Click the Add Goal button");
		objgoal.clickAddGoalButton();
		
		report.log(LogStatus.INFO, "Step 19. Click the Library Goal list item");
		objgoal.selectGoalType(GoalType);
		
		report.log(LogStatus.INFO, "Step 20. Click in the Goal Name field");
		report.log(LogStatus.INFO, "Step 21. Enter the desired information into the Goal Name field");
		if(GoalNameToSearch != "")
		{
			objgoal.enterGoalName(GoalNameToSearch);
			report.log(LogStatus.PASS, "Step 21.1.Goal Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 21.1.Value of Goal Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 22. Click the Search button");
		objgoal.clickSearchResButton();
		
		report.log(LogStatus.INFO, "Step 23. Click the Gain upward feedback from team members before the end of the ... cell");
		objgoal.selectSearchGoalResult2(ToSelectGoalName);
		
		report.log(LogStatus.INFO, "Step 24. Click the OK button");
		objgoal.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 25. The newly added goal is displayed in Goals section");
		report.log(LogStatus.INFO, "Step 26. Click the Next button");
		objgoal.clickNextButton();
		
		report.log(LogStatus.INFO, "Step 27. Click the Save and Close button.");
		objgoal.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 28. Click the 2018 Financial Goal Plan cell.");
				
		report.log(LogStatus.INFO, "Step 29. Click the Manage Scheduled Process button.");
		objgoal.clickManageScheduleProcessButton();
		
		report.log(LogStatus.INFO, "Step 30. Click the Submit button");
		objgoal.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 31. Note the Process number to view the process status.");
		String ProcessNum=objgoal.getProcessNum();
		//String ProcessNum="62195";
		
		report.log(LogStatus.INFO, "Step 32. Click the OK button");
		objgoal.clickGLOKButton();
		
		report.log(LogStatus.INFO, "Step 33. Click the Monitor Process button.");
		objgoal.clickMonitorProcessButton();
		
		report.log(LogStatus.INFO, "Step 34. Click Refresh button until status of the process is Succeeded");
		objgoal.clickRefreshIcon();
		
		report.log(LogStatus.INFO, "Step 35. The status of the scheduled process is Succeeded");
		objgoal.verifyProcessStatus(ProcessNum);
	
		sAssert.assertAll();
				
	}

}