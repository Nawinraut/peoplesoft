package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.CreateBankStatementTransactions_BasicOptionsPage;
import com.cloud.pageobjects.Finance.ManageReceiptsPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Generate_Cash_Transactions extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Generate Cash Transactions")
	public void Cloud_Generate_Cash_Transaction(String UserName,String Password,String BankAccount,String StatementID,String FromStatementEndDate,String ToStatementEndDate)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Generate Cash Transactions link and verify its navigated to Basic Options page or not");
		CreateBankStatementTransactions_BasicOptionsPage objBscOptions=objOverview.clickGenerateCashTransactionsLink();
			if(objBscOptions.isSelectBankAccountDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Bank Account from list");
			if(BankAccount != "")
			{
				objBscOptions.SelectBankAccount(BankAccount);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Bank Account from the list is "+BankAccount);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Bank Account from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click in the Statement ID. Enter the desired information into the Statement ID field. Enter a valid value");
			if(StatementID!= "") {
				objBscOptions.selectStatementID(StatementID);
				report.log(LogStatus.PASS, "Step 9.1.Statement ID is entered successfully: "+StatementID);
			}else {
				report.log(LogStatus.FAIL, "Step 9.1.Statement ID is not entered");
			}
			
			String fromDateParts[] = FromStatementEndDate.split("-");
			String fromMonth  = fromDateParts[0];
			String fromDay  = fromDateParts[1];
			String fromYear = fromDateParts[2];
			report.log(LogStatus.INFO, "Step 10. Click on From Statement End Date button");
			objBscOptions.clickFromStatementEndDateButton();
			report.log(LogStatus.INFO, "Step 10.1. Select From Statement End Date Month");
			objBscOptions.selectFromStatementEndDtMonth(fromMonth);
			report.log(LogStatus.INFO, "Step 10.2. Select From Statement End Date");
			objBscOptions.selectFromStatementEndDate(fromDay);
			
			String toDateParts[] = ToStatementEndDate .split("-");
			String toMonth  = toDateParts[0];
			String toDay  = toDateParts[1];
			String toYear = toDateParts[2];
			report.log(LogStatus.INFO, "Step 11. Click on To Statement End Date button");
			objBscOptions.clickToStatementEndDateButton();
			report.log(LogStatus.INFO, "Step 11.1. Select To Statement End Date Month");
			objBscOptions.selectToStatementEndDtMonth(toMonth);
			report.log(LogStatus.INFO, "Step 11.2. Select To Statement End Date");
			objBscOptions.selectToStatementEndDate(toDay);
			objBscOptions.clickSubmissionNotesText();
			
			report.log(LogStatus.INFO, "Step 12. Click on Submit button");
			objBscOptions.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 13. Click on confirmation Ok button");
			objBscOptions.clickConfOkButton();
	}

}
