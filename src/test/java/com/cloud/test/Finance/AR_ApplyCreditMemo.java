package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.ApplyCreditMemoPage;
import com.cloud.pageobjects.Finance.ManageCreditMemoApplicationsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

//@Listeners(TestNGListeners.class)
public class AR_ApplyCreditMemo extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Apply Credit Memo")
	public void AR_Apply_Credit_Memo(String UserName,String Password,String BusinessUnit,String TransactionNumber,String TransactionNumber_Edit)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Accounts Receivable link and verify its navigated to Accounts Receivable Page or not");
		AccountsReceivablePage objAccRcvl=objHome.clickAccountsReceivable();
		if(objAccRcvl.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to AccountsReceivable Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Accounts Receivable Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objAccRcvl.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Manage Credit Memo Applications link and verify its navigated to Manage Credit Memo Applications page or not");
		ManageCreditMemoApplicationsPage objManageCredit=objAccRcvl.clickManageCreditMemoApplicationsLink();
			if(objManageCredit.isSelectBusinessUnitDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Manage Credit Memo Applications Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Manage Credit Memo Applications Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objManageCredit.SelectBusinessUnit(BusinessUnit);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Business Unit from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click in the Transaction Number Value field. Enter the desired information into the Transaction Number field. Enter a valid value");
			if(TransactionNumber!= "") {
				
				objManageCredit.enterTransactionNumber(TransactionNumber);
				report.log(LogStatus.PASS, "Step 9.1.Transaction Number Value is entered successfully: "+TransactionNumber);
			}else {
				report.log(LogStatus.FAIL, "Step 9.1.Transaction Number Value is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 10. Click on Search button");
			objManageCredit.clickSearchButton();
			
			report.log(LogStatus.INFO, "Step 11. Select the Transection Number Cell and Verify its navigated to Apply Credit Memo page or not");
			objManageCredit.selectTransactionCell(TransactionNumber);
			
			ApplyCreditMemoPage objApplyCredit=new ApplyCreditMemoPage(driver,report);
			
			if(objApplyCredit.isAddOpenReceivablesBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 11.1.Navigation to Apply Credit Memo Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Navigation to Apply Credit Memo Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 12. Click on Add Open Receivables button and Verify its navigated to Add Open Receivables pop-up window or not");
			objApplyCredit.clickAddOpenReceivablesButton();
			if(objApplyCredit.isTransactionNumberDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 12.1.Navigation to Add Open Receivables pop-up window is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 12.1.Navigation to Add Open Receivables pop-up window is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 13. Click in the Transaction Number Value field. Enter the desired information into the Transaction Number field. Enter a valid value");
			if(TransactionNumber_Edit!= "") {
				
				objApplyCredit.enterTransactionNumber(TransactionNumber_Edit);
				report.log(LogStatus.PASS, "Step 13.1.Transaction Number Value is entered successfully: "+TransactionNumber_Edit);
			}else {
				report.log(LogStatus.FAIL, "Step 13.1.Transaction Number Value is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 14. Click on Search button");
			objApplyCredit.clickTransactionSearchButton();
			
			report.log(LogStatus.INFO, "Step 15. Select the Transection Number Cell");
			objApplyCredit.selectEvent(TransactionNumber_Edit);
			
			report.log(LogStatus.INFO, "Step 16. Click on Add button");
			objApplyCredit.clickTransactionAddButton();
			
			report.log(LogStatus.INFO, "Step 17. Click on Done button");
			objApplyCredit.clickTransactionDoneButton();
			
			report.log(LogStatus.INFO, "Step 18. Click on Save button");
			objApplyCredit.clickSaveButton();
			
			report.log(LogStatus.INFO, "Step 19. Click on Actions Menu");
			objApplyCredit.clickActionsMenu();
			
			report.log(LogStatus.INFO, "Step 20. Click on Post to Ledger list ");
			objApplyCredit.clickPostToledgerList();
			
			report.log(LogStatus.INFO, "Step 21. Click on confirmation Ok button");
			objApplyCredit.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 22. Click on Save and Close  button");
			objApplyCredit.clickSaveAndCloseButton();
	
	}

}
