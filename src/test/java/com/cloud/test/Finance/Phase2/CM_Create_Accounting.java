package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateAccounting_BasicOptionsPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Create_Accounting extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Accounting")
	public void Cloud_CM_Create_Accounting(String UserName,String Password,String SubledgerApplication,String Ledger,String EndDate,String TransfertoGeneralLedger,String PostinGeneralLedger)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Accounting link and verify its navigated to Basic Options page or not ");
		CreateAccounting_BasicOptionsPage objBasicOpt=objOverview.clickCreateAccountingLink();
		if(objBasicOpt.isSubledgerApplicationListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Subledger Application from list");
		if(SubledgerApplication != "")
		{
			objBasicOpt.SelectSubledgerApplication(SubledgerApplication);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Subledger Application from the list is: "+SubledgerApplication);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Subledger Application from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Select Ledger from list");
		if(Ledger != "")
		{
			objBasicOpt.SelectLedger(Ledger);
			report.log(LogStatus.PASS, "Step 9.1.Selected given Ledger from the list is: "+Ledger);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given Ledger from the list is not selected");
		}
		
		String endDateParts[] = EndDate.split("-");
		String endMonth  = endDateParts[0];
		String endDay  = endDateParts[1];
		String endYear = endDateParts[2];
		report.log(LogStatus.INFO, "Step 10. Click on End Date button");
		objBasicOpt.clickEndDateButton();
		report.log(LogStatus.INFO, "Step 10.1. Select End Date Month");
		objBasicOpt.selectEndDateMonth(endMonth);
		report.log(LogStatus.INFO, "Step 10.2. Select End Date");
		objBasicOpt.selectEndDate(endDay);
		
		report.log(LogStatus.INFO, "Step 11. Select Transfer to General Ledger from list");
		if(TransfertoGeneralLedger != "")
		{
			objBasicOpt.SelectTransferGeneralLedger(TransfertoGeneralLedger);
			report.log(LogStatus.PASS, "Step 11.1.Selected given Transfer to General Ledger from the list is: "+TransfertoGeneralLedger);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Given Transfer to General Ledger from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Select Post in General Ledger from list");
		if(PostinGeneralLedger != "")
		{
			objBasicOpt.SelectPostGeneralLedger(PostinGeneralLedger);
			report.log(LogStatus.PASS, "Step 12.1.Selected given Post in General Ledger from the list is: "+PostinGeneralLedger);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Given Post in General Ledger from the list is not selected");
		}
		
		objBasicOpt.clickSubmissionNotesText();
		
		report.log(LogStatus.INFO, "Step 13. Click on Submit button");
		objBasicOpt.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 14. Click on confirmation Ok button");
		objBasicOpt.clickConfOkButton();
		
	}
}
