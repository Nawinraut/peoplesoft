package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CashtoGeneralLedgerReconciliationReport_BasicOptionsPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Cash_to_General_Ledger_Reconciliation_Report extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Submit Cash to GL Reconciliation")
	public void Cloud_Cash_Gen_Ledg_Re_Report(String UserName,String Password,String BankAccount,String FromAccountingPeriod,String ToAccountingPeriod)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on  Cash to General Ledger Reconciliation link and verify its navigated to Basic Options page or not ");
		CashtoGeneralLedgerReconciliationReport_BasicOptionsPage objBasicOpt=objOverview.clickCashtoGeneralLedgerReconciliationReportLink();
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
		
		report.log(LogStatus.INFO, "Step 9. Select From Accounting Period from list");
		if(FromAccountingPeriod != "")
		{
			objBasicOpt.SelectFromAccountingPeriodList(FromAccountingPeriod);
			report.log(LogStatus.PASS, "Step 9.1.Selected given From Accounting Period from the list is: "+FromAccountingPeriod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given From Accounting Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Select To Accounting Period from list");
		if(ToAccountingPeriod != "")
		{
			objBasicOpt.SelectToAccountingPeriodList(ToAccountingPeriod);
			objBasicOpt.clickSubmissionNotes();
			report.log(LogStatus.PASS, "Step 10.1.Selected given To Accounting Period from the list is: "+ToAccountingPeriod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Given To Accounting Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 20. Click on Submit button");
		objBasicOpt.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Confirmation Ok button");
		String ProcessId = objBasicOpt.ConfirmationProcessId();
		objBasicOpt.clickConfOkButton();
		SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 11. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 12. Click on Schedule Process link and verify its navigated to Scheduled  Processes Page or not");
		ScheduledProcessesPage objScheduled =objHome.clickScheduledProcesses();
		if(objScheduled.isScheduleNewProcessBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 12.1.Navigation to Scheduled New Processes Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Navigation to Scheduled New Processes Page is failed");	
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
