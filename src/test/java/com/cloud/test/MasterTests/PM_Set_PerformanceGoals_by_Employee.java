/**
 Test Name: PM_Set_PerformanceGoals_for_an_Emp_by_Manager
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to set performance goals by an Employee
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
import com.cloud.pageobjects.HCM.CareerandPerformancePage;
import com.cloud.pageobjects.HCM.PerformancePage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class PM_Set_PerformanceGoals_by_Employee extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to set performance goals by an Employee")	
	public void PM_Set_PerfGoals_by_Emp(String UserName,String Password,String ReviewPeriod,String GoalName,String SearchCompName, String CompetencyName,String GoalType) throws TestException,InterruptedException
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
		PerformancePage objPerf=objcp.clickPerformanceEvaluations();
		if(objPerf.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.Performance Page is Loaded Successfully");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.Performance Page is not Loaded");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click the My Manager Evaluations: Ciber 2019 Review Period… list");
		objPerf.clickReviewPeriodList();
		
		report.log(LogStatus.INFO, "Step 8. Click the Ciber Review Period list item");
		if(ReviewPeriod != "")
		{
			objPerf.selectReviewPeriodList(ReviewPeriod);
			report.log(LogStatus.PASS, "Step 8.1.Review Period is selected successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Value of Review Period is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Set Goals link for any of the Employee");
		if(GoalName != "")
		{
			objPerf.clickSetGoalsEmp("Set Goals");
			report.log(LogStatus.PASS, "Step 9.1.Clicked on SetGoals link successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Not clicked on SetGoals link");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click Continue button on Create Performance Document");
		if(objPerf.isContinueButtonDisplayed()) 
		{
			objPerf.clickContinueButton();
		}
		else
		{
			report.log(LogStatus.PASS, "Step 10.1.Continue button is not displayed");
		}
			
		
		report.log(LogStatus.INFO, "Step 11. Click the Add button");
		objPerf.clickAddButton();
		
		report.log(LogStatus.INFO, "Step 12.Click in the Name field");
		report.log(LogStatus.INFO, "Step 13.Enter the desired information into the Name field.");
		if(SearchCompName != "")
		{
			objPerf.enterCompName(SearchCompName);
			report.log(LogStatus.PASS, "Step 13.1.Competency Name to search is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Value of Competency Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click the Search button.");
		objPerf.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 15. Click the Managing Change cell");
		objPerf.selectCompetency(CompetencyName);
		
		report.log(LogStatus.INFO, "Step 16. Click the OK button.");
		objPerf.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 17. Click the Goals button.");
		objPerf.clickGoalsIcon();
		
		report.log(LogStatus.INFO, "Step 18. Click the Add Goal button");
		objPerf.clickAddGoalButton();
		
		report.log(LogStatus.INFO, "Step 19. Click the Library Goal list item");
		objPerf.selectGoalTypeNew(GoalType);
		
		report.log(LogStatus.INFO, "Step 20. Click in the Goal Name field.");
		report.log(LogStatus.INFO, "Step 21. Enter the desired information into the Goal Name field");
		if(GoalName != "")
		{
			objPerf.enterGoalName(GoalName);
			report.log(LogStatus.PASS, "Step 21.1.Goal Name is entered successfully");
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 21.1.Value of Goal Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 22. Click the Save and Close button.");
		objPerf.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 23. Click the OK button.");
		objPerf.clickGLOKButton();
		
		report.log(LogStatus.INFO, "Step 24. Click the Share button.");
		objPerf.clickShareButton();
		
		report.log(LogStatus.INFO, "Step 25. Click the OK button.");
		objPerf.clickOkButton();
			
		sAssert.assertAll();
				
	}

}