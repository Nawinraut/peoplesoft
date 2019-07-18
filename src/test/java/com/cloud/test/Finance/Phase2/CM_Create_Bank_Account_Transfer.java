package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CashBalancesPage;
import com.cloud.pageobjects.Finance.CreateBankAccountTransferPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Create_Bank_Account_Transfer extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Bank Account Transfer")
	public void Cloud_Create_Bank_Acc_Transfer(String UserName,String Password,String FromAccount,String ToAccount,String TransferDate,String TransferAmount,String BusinessUnit,String PaymentMethod,String PaymentProfile)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Cash Balances link and verify its navigated to Cash Balances Page or not");
		CashBalancesPage objBalances=objHome.clickCashBalancesLink();
		if(objBalances.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Cash Balances Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Cash Balances Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objBalances.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Bank Account Transfer link and verify its navigated to Create Bank Account Transfer page or not ");
		CreateBankAccountTransferPage objCrtTransfer=objBalances.clickCreateBankAccountTransferLink();
		if(objCrtTransfer.isFromAccountListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Bank Account Transfer page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Bank Account Transfer page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select From Account from list");
		if(FromAccount != "")
		{
			objCrtTransfer.SelectFromAccount(FromAccount);
			report.log(LogStatus.PASS, "Step 8.1.Selected given From Account from the list is "+FromAccount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given From Account from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Select To Account from list");
		if(ToAccount != "")
		{
			objCrtTransfer.SelectToAccount(ToAccount);
			report.log(LogStatus.PASS, "Step 9.1.Selected given To Account from the list is "+ToAccount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given To Account from the list is not selected");
		}
		
		String transferDateParts[] = TransferDate.split("-");
		String transferMonth  = transferDateParts[0];
		String transferDay  = transferDateParts[1];
		String transferYear = transferDateParts[2];
		report.log(LogStatus.INFO, "Step 10. Click on Transfer Date button");
		objCrtTransfer.clickTransferDateButton();
		report.log(LogStatus.INFO, "Step 10.1. Select Transfer Date Month");
		objCrtTransfer.selectTransferDateMonth(transferMonth);
		report.log(LogStatus.INFO, "Step 10.2. Select Transfer Date");
		objCrtTransfer.selectTransferDate(transferDay);
		
		report.log(LogStatus.INFO, "Step 11. Click in the Transfer Amount field. Enter the desired information into the Transfer Amount field. Enter a valid value");
		if(TransferAmount!= "") {
			
			objCrtTransfer.enterTransferAmount(TransferAmount);
			report.log(LogStatus.PASS, "Step 11.1.Distribution Transfer Amount is entered successfully: "+TransferAmount);
		}else {
			report.log(LogStatus.FAIL, "Step 11.1.Distribution Transfer Amount is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 12. Select Business Unit from list");
		if(BusinessUnit != "")
		{
			objCrtTransfer.SelectBusinessUnit(BusinessUnit);
			report.log(LogStatus.PASS, "Step 12.1.Selected given Business Unit from the list is "+BusinessUnit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Given Business Unit the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 13. Select Payment Method from list");
		if(PaymentMethod != "")
		{
			objCrtTransfer.SelectPaymentMethod(PaymentMethod);
			report.log(LogStatus.PASS, "Step 13.1.Selected given Payment Method from the list is "+PaymentMethod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Given Payment Method the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 14. Select Payment Profile from list");
		if(PaymentProfile != "")
		{
			objCrtTransfer.SelectPaymentProfile(PaymentProfile);
			report.log(LogStatus.PASS, "Step 14.1.Selected given Payment Profile from the list is "+PaymentProfile);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step14.1.Given Payment Profile the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click on Submit button");
		objCrtTransfer.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 16. Click on Confirmation Yes button");
		objCrtTransfer.clickConfYesButton();
		
	}
	

}
