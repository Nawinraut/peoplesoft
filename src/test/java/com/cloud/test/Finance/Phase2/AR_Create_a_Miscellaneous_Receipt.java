package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.CreateReceiptPage;
import com.cloud.pageobjects.Finance.EditReceiptPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Create_a_Miscellaneous_Receipt extends BaseWebTest{

	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create a Miscellaneous Receipt")
	public void Cloud_Miscellaneous_Receipt(String UserName,String Password,String ReceiptType,String BusinessUnit,String ReceiptMethod,String ReceiptNumber,String EnteredAmount,String ReceivablesActivity,String BankName,String BranchName,String BankAccount)throws TestException,InterruptedException, TestException {
		
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
		AccountsReceivablePage objAccRcvble=objHome.clickAccountsReceivable();
		if(objAccRcvble.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Accounts Receivable Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Accounts Receivable Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objAccRcvble.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Receipts link and verify its navigated to Create Receipts page or not");
		CreateReceiptPage objCrtRcpt=objAccRcvble.clickCreateReceiptLink();
			if(objCrtRcpt.isSelectBusinessUnitDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Receipts Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Receipts Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Receipt Type from list");
			if(ReceiptType != "")
			{
				objCrtRcpt.SelectReceiptType(ReceiptType);
				//report.log(LogStatus.PASS, "Step 8.1.Selected given Receipt Type from the list is "+ReceiptType);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Receipt Type from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objCrtRcpt.SelectBusinessUnit(BusinessUnit);
				report.log(LogStatus.PASS, "Step 9.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.1.Given Business Unit from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 10. Select Receipt Method from list");
			if(ReceiptMethod != "")
			{
				objCrtRcpt.SelectReceiptMethod(ReceiptMethod);
				/*objCrtRcpt.SelectBankName(BankName);
				objCrtRcpt.SelectBankBranch(BranchName);
				objCrtRcpt.SelectBankAccount(BankAccount);*/
				//report.log(LogStatus.PASS, "Step 10.1.Selected given Receipt Method from the list is "+ReceiptMethod);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 10.1.Given Receipt Method from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 11. Click in the ReceiptNumber field. Enter the desired information into the ReceiptNumber field. Enter a valid value");
			if(ReceiptNumber!= "") {
				objCrtRcpt.enterReceiptNumber(ReceiptNumber);
				//report.log(LogStatus.PASS, "Step 11.1.Receipt Number is entered successfully: "+ReceiptNumber);
			}else {
				report.log(LogStatus.FAIL, "Step 11.1.Receipt Number is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 12. Select Receivables Activity from list");
			if(ReceivablesActivity != "")
			{
				objCrtRcpt.SelectstrReceivablesActivity(ReceivablesActivity);
				//report.log(LogStatus.PASS, "Step 12.1.Selected given Receivables Activity from the list is "+ReceivablesActivity);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 12.1.Given Receivables Activity from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 13. Click in the Entered Amount field. Enter the desired information into the Entered Amount field. Enter a valid value");
			if(EnteredAmount!= "") {
				objCrtRcpt.enterEnteredAmount(EnteredAmount);
				
				//report.log(LogStatus.PASS, "Step 13.1.Entered Amount is entered successfully: "+EnteredAmount);
			}else {
				report.log(LogStatus.FAIL, "Step 13.1.Entered Amount is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 14. Click on Save button");
			objCrtRcpt.clickSaveButton();
			
			report.log(LogStatus.INFO, "Step 15. Click on Information Ok button");
			objCrtRcpt.clickInfOkButton();
			EditReceiptPage objedtRcpt=new EditReceiptPage(driver, report);
			
			report.log(LogStatus.INFO, "Step 16. Click on Actions menu");
			objedtRcpt.clickActionsMenu();
			
			report.log(LogStatus.INFO, "Step 17. Click Post to Ledger list");
			objedtRcpt.selectPostLedgerMenu();
			
			report.log(LogStatus.INFO, "Step 18. Click on confirmation Ok button");
			objedtRcpt.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 19. Click on Save and Close button");
			objedtRcpt.clickSaveAndCloseButton();
			
	}
}
