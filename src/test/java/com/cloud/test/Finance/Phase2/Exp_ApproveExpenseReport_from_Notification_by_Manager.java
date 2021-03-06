/**
 Test Name: Exp_ApproveExpenseReport_from_Notification_by_Manager
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used for to Approve Expense Report from Notification by Manager
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
import com.cloud.pageobjects.Finance.ExpenseReportPage;
import com.cloud.pageobjects.Finance.ExpensesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

	@Listeners(TestNGListeners.class)
	public class Exp_ApproveExpenseReport_from_Notification_by_Manager extends BaseWebTest  {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Approve Expense Report from Notification by Manager")	
	public void Exp_ApproveExpenseReport_Mgr(String UserName,String Password) throws TestException,InterruptedException
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
		
		report.log(LogStatus.INFO, "Step 5. Click the Action Required: Expense Report Approval REIM0018610057 for Payab link");
		objHome.selectExpNotification("Expense Report Approval");
		
		SeleniumUtils.swithToWindow(driver, "Expense Report Approval");
		ExpenseReportPage objERP=new ExpenseReportPage(driver,report);
		report.log(LogStatus.INFO, "Step 6. Click the Approve button.");
		objERP.clickApproveButton();
		
	}

}