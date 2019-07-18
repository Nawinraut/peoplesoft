package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.BankStatementReport_BasicOptionsPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Bank_Statement_Report extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Submit Bank Statement Report")
	public void Cloud_Bank_Statement_Report(String UserName,String Password,String BankAccount,String FromStatementEndDate,String ToStatementEndDate)throws TestException,InterruptedException, TestException {
		
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
		HomePage objHome=objLogin.loginToCloudApplication(UserName,Password);
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Bank Statements Reconciliation link and verify its navigated to Overview Page or not");
		Overview_BankStatementPage objOverview=objHome.clickBankStatementsReconciliation();
		if(objOverview.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Overview Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Overview Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Bank Statement Report link and verify its navigated to Basic Options page or not ");
		BankStatementReport_BasicOptionsPage objBasicOpt=objOverview.clickBankStatementReportLink();
		if(objBasicOpt.isBankAccountDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Bank Account from list");
		if(BankAccount != "")
		{
			objBasicOpt.SelectBankAccountList(BankAccount);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Bank Account from the list is: "+BankAccount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Bank Account from the list is not selected");
		}
		
		String fromDateParts[] = FromStatementEndDate.split("-");
		String fromMonth  = fromDateParts[0];
		String fromDay  = fromDateParts[1];
		String fromYear = fromDateParts[2];
		report.log(LogStatus.INFO, "Step 10. Click the From Statement End  Date button");
		objBasicOpt.clickFromEnteredDateButton();
		report.log(LogStatus.INFO, "Step 10.1. Select From Statement End  Month");
		objBasicOpt.selectFromEnteredDtMonth(fromMonth);
		report.log(LogStatus.INFO, "Step 10.2. Select From  Statement End Date");
		objBasicOpt.selectFromEnteredDate(fromDay);
		
		String toDateParts[] = ToStatementEndDate.split("-");
		String toMonth  = toDateParts[0];
		String toDay  = toDateParts[1];
		String toYear = toDateParts[2];
		report.log(LogStatus.INFO, "Step 11. Click the To Statement End Date button");
		objBasicOpt.clickToEnteredDateButton();
		report.log(LogStatus.INFO, "Step 11.1. Select To Statement End Month");
		objBasicOpt.selectToEnteredDtMonth(toMonth);
		report.log(LogStatus.INFO, "Step 11.2. Select To Statement End Date");
		objBasicOpt.selectToEnteredDate(toDay);
		
		report.log(LogStatus.INFO, "Step 12. Click on Submit button");
		objBasicOpt.clickSubmissionNotes();
		objBasicOpt.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 13. Click on Confirmation Ok button");
		String ProcessId = objBasicOpt.ConfirmationProcessId();
		objBasicOpt.clickConfOkButton();
		SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 14. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 15. Click on Schedule Process link and verify its navigated to Scheduled  Processes Page or not");
		ScheduledProcessesPage objScheduled =objHome.clickScheduledProcesses();
		if(objScheduled.isScheduleNewProcessBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 15.1.Navigation to Scheduled New Processes Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Navigation to Scheduled New Processes Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 16. Click on refresh button");
		objScheduled.clickRefreshButton();
		
		report.log(LogStatus.INFO, "Step 17. Click on Trial Balance Report cell");
		objScheduled.selectTrialBalanceReportCell(ProcessId);
		
		report.log(LogStatus.INFO, "Step 18. Click on Default Document Link");
		//objScheduled.clickDefaultDocumentLink();
		objScheduled.clickDefaultDocumnetLink();
		
	}
	

}
