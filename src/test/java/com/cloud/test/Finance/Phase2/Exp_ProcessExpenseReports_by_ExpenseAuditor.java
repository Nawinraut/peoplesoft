/**
 Test Name: Exp_ProcessExpenseReports_by_ExpenseAuditor
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Process Expense Reports by Expense Auditor
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class Exp_ProcessExpenseReports_by_ExpenseAuditor extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Process Expense Reports by Expense Auditor")	
	public void Exp_ProcessER_by_ExpenseAuditor(String UserName,String Password,String SearchName,String ProcessName,String BusinessUnit) throws TestException,InterruptedException
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
		
		report.log(LogStatus.INFO, "Step 5. Click the horizontal scrollbar.");
		report.log(LogStatus.INFO, "Step 6. Click the vertical scrollbar.");
		report.log(LogStatus.INFO, "Step 7. Click the More... link.");
		//ScheduledProcessesPage objSPP=objHome.clickScheduledProcesses();
		ScheduledProcessesPage objSPP=objHome.clickScheduledProcessesLink();
		
		report.log(LogStatus.INFO, "Step 8. Click the Schedule New Process button.");
		objSPP.clickScheduleNewProcessButton();
		
		report.log(LogStatus.INFO, "Step 9. Click the Name list.");
		objSPP.clickSearchScheduleNewProcessIcon();
		
		report.log(LogStatus.INFO, "Step 10. Click the Search... link.");
		objSPP.clickScheduleNewProcessSearchLink();
		
		report.log(LogStatus.INFO, "Step 11. Click in the Name field.");
		report.log(LogStatus.INFO, "Step 12. Enter the desired information into the Name field.");
		objSPP.enterName(SearchName);
		
		report.log(LogStatus.INFO, "Step 13. Click the Search button.");
		objSPP.clickNameSearchButton();
		
		report.log(LogStatus.INFO, "Step 14. Click the Process Expense Reimbursements and Cash Advances cell.");
		objSPP.selectProcessName(ProcessName);
		
		report.log(LogStatus.INFO, "Step 15. Click the OK button.");
		objSPP.clickNameOkButton();
		
		report.log(LogStatus.INFO, "Step 15. Click the OK button.");
		objSPP.clickScheduleNewProcessOkButton();
		
		report.log(LogStatus.INFO, "Step 16. Click the Business Unit list.");
		report.log(LogStatus.INFO, "Step 17. Click the Ciber1 Business Unit list item.");
		objSPP.selectBusUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 18. Click the Submit button");
		objSPP.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 19. Click the OK button.");
		objSPP.clickConfOkButton();
		
	}

}