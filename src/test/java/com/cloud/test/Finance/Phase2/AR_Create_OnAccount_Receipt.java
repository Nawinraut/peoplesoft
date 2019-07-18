package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.EditReceiptPage;
import com.cloud.pageobjects.Finance.ManageReceiptsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Create_OnAccount_Receipt extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create a Credit Memo Transaction")
	public void Cloud_Create_OnAccount_Receipt(String UserName,String Password,String BusinessUnit,String ReceiptNumber,String ApplicationAmount,String ApplicationDate)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Manage Receipts link and verify its navigated to Manage Receipts page or not");
		ManageReceiptsPage objMngRcpt=objAccRcvble.clickManageReceiptsLink();
			if(objMngRcpt.isSelectBusinessUnitDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Manage Receipts Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Manage Receipts Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objMngRcpt.SelectBusinessUnit(BusinessUnit);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Business Unit from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click in the ReceiptNumber field. Enter the desired information into the ReceiptNumber field. Enter a valid value");
			if(ReceiptNumber!= "") {
				objMngRcpt.enterReceiptNumber(ReceiptNumber);
				report.log(LogStatus.PASS, "Step 9.1.Receipt Number is entered successfully: "+ReceiptNumber);
			}else {
				report.log(LogStatus.FAIL, "Step 9.1.Receipt Number is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 10. Click on Search button");
			objMngRcpt.clickSearchButton();
			
			report.log(LogStatus.INFO, "Step 11. Select the Receipt Number Cell and Verify its navigated to Edit Receipt page or not");
			EditReceiptPage objEdtRcpt=objMngRcpt.selectManageReceiptsCell(ReceiptNumber);
			if(objEdtRcpt.isReceiptDetailsActionMenuDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 11.1.Navigation to Edit Receipt Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Navigation to Edit Receipt Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 12. Click on Transaction Cell");
			objEdtRcpt.selectReceiptDetailsTransections("Transaction");
			
			report.log(LogStatus.INFO, "Step 13. Click on Receipt Details Actions Menu");
			objEdtRcpt.clickReceiptDetailsActionsMenu();
			
			report.log(LogStatus.INFO, "Step 14. Click on More List and Create On-Account Application list");
			objEdtRcpt.selectMoreList_OnAccountApplicationList();
			
			//report.log(LogStatus.INFO, "Step 15. Click on Create On-Account Application list");
			//objEdtRcpt.selectCreateOnAccountApplicationList();
			
			
			report.log(LogStatus.INFO, "Step 16. Click in the Application Amount field. Enter the desired information into the Application Amount  field. Enter a valid value");
			if(ApplicationAmount != "") {
				objEdtRcpt.enterApplicationAmount(ApplicationAmount);
				report.log(LogStatus.PASS, "Step 16.1.Application Amount  is entered successfully: "+ApplicationAmount );
			}else {
				report.log(LogStatus.FAIL, "Step 16.1.Application Amount  is not entered");
			}
			
			String fromDateParts[] = ApplicationDate.split("-");
			String fromMonth  = fromDateParts[0];
			String fromDay  = fromDateParts[1];
			String fromYear = fromDateParts[2];
			report.log(LogStatus.INFO, "Step 17. Click on Accounting Date button");
			objEdtRcpt.clickAccountingDateButton();
			report.log(LogStatus.INFO, "Step 17.1. Select Accounting Date Month");
			objEdtRcpt.selectAccountingDateMonth(fromMonth);
			report.log(LogStatus.INFO, "Step 17.2. Select Accounting Date");
			objEdtRcpt.selectAccountingDate(fromDay);
			
			report.log(LogStatus.INFO, "Step 18. Click on Ok button");
			objEdtRcpt.clickOkApplicationAmountButton();
			
			report.log(LogStatus.INFO, "Step 19. Click on Save button");
			objEdtRcpt.clickSaveButton();
			
			report.log(LogStatus.INFO, "Step 20. Click on Actions Menu");
			objEdtRcpt.clickActionsMenu();
			
			report.log(LogStatus.INFO, "Step 21. Click on Post to Ledger List");
			objEdtRcpt.selectPostLedgerMenu();
			
			report.log(LogStatus.INFO, "Step 22. Click on Confirmation Ok button");
			objEdtRcpt.clickConfOkButton();	
			
	}

}
