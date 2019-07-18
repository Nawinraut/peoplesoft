/**
 Test Name: PM_Set_PerfGoals_by_Emp
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Self Evaluate by an Employee
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.HCM;

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
public class PM_Self_Evaluate_by_an_Employee extends BaseWebTest {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Self Evaluate by an Employee")
	public void PM_Self_Evaluate_by_an_Emp(String UserName, String Password, String ReviewPeriod, String SelfRating) throws TestException, InterruptedException {
		sAssert = new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		if (objLogin.isUserNameDisplayed()) {
			report.log(LogStatus.PASS, "Step 1.1.Cloud application is launched successfully");
		} else {
			report.log(LogStatus.FAIL, "Step 1.1.Launching of Cloud application is  failed");
		}

		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		HomePage objHome = objLogin.loginToCloudApplication(UserName, Password);

		report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		if (objHome.isHomeImageDisplayed()) {
			report.log(LogStatus.PASS, "Step 3.1.Navigation to Home Page is success");
		} else {
			report.log(LogStatus.FAIL, "Step 3.1.Navigation to Home Page is failed");
		}

		report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
		objHome.clickNavigatorIcon();

		report.log(LogStatus.INFO, "Step 5. Click the Career and Performance Link");
		CareerandPerformancePage objcp = objHome.clickCareerandPerformance();

		report.log(LogStatus.INFO, "Step 6. Click the Goals Link");
		PerformancePage objPerf = objcp.clickPerformanceEvaluations();
		if (objPerf.isDisplayed()) {
			report.log(LogStatus.PASS, "Step 6.1.Performance Page is Loaded Successfully");
		} else {
			report.log(LogStatus.FAIL, "Step 6.1.Performance Page is not Loaded");
		}

		report.log(LogStatus.INFO, "Step 7. Click the My Manager Evaluations: Ciber 2019 Review Period… list");
		objPerf.clickReviewPeriodList();

		report.log(LogStatus.INFO, "Step 8. Click the Ciber Review Period list item");
		if (ReviewPeriod != "") {
			objPerf.selectReviewPeriodList(ReviewPeriod);
			report.log(LogStatus.PASS, "Step 8.1.Review Period is selected successfully");
		} else {
			report.log(LogStatus.FAIL, "Step 8.1.Value of Review Period is not selected");
		}

		report.log(LogStatus.INFO, "Step 9. Click the Worker Self-Evaluation link for any of the Goal");
		objPerf.clickSetGoalsEmp("Worker Self-Evaluation");
		
		report.log(LogStatus.INFO, "Step 10. Click Continue button on Create Performance Document");
		objPerf.selfRateDCORGoals("Duties and Competencies");
		
		report.log(LogStatus.INFO, "Step 11. Click the Goals button.");
		objPerf.clickGoalsIcon();
		
		report.log(LogStatus.INFO,"Step 12. Click Continue button on Create Performance Document");
		objPerf.selfRateDCORGoals("Goals");
		 		
		report.log(LogStatus.INFO, "Step 13. Click the Overall Summary button.");
		objPerf.clickOverallSummary();
		
		report.log(LogStatus.INFO, "Step 14. Click the Overall Summary button.");
		objPerf.rateOverallSummary(SelfRating);

		report.log(LogStatus.INFO, "Step 15. Click the Submit button.");
		objPerf.clickSubmitButton();
	
		report.log(LogStatus.INFO, "Step 16. Click the Yes button.");
		objPerf.clickYesConfrimButton();
		
		report.log(LogStatus.INFO, "Step 17. Click the OK button.");
		objPerf.clickOkButton();
		 
		sAssert.assertAll();

	}

}