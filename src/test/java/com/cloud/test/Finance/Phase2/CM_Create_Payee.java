package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CashBalancesPage;
import com.cloud.pageobjects.Finance.CreatePayeePage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Create_Payee extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Payee")
	public void Cloud_Create_Payee(String UserName,String Password,String Name,String Description,String AccountNumber,String Currency,String AccountType,String Bank,String BankBranch,String RoutingNumber)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Payee link and verify its navigated to Create Payee page or not");
		CreatePayeePage objCrtPayee=objBalances.clickCreatePayeeLink();
			if(objCrtPayee.isNameFieldDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Payee Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Payee Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Click in the Name. Enter the desired information into the Name field. Enter a valid value");
			if(Name != "") {
				objCrtPayee.enterName(Name);
				report.log(LogStatus.PASS, "Step 8.1.Name is entered successfully: "+Name);
			}else {
				report.log(LogStatus.FAIL, "Step 8.1.Name is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click in the Description. Enter the desired information into the Description field. Enter a valid value");
			if(Description != "") {
				objCrtPayee.enterDescription(Description);
				report.log(LogStatus.PASS, "Step 9.1.Description is entered successfully: "+Description);
			}else {
				report.log(LogStatus.FAIL, "Step 9.1.Description is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 10. Click on Save button");
			objCrtPayee.clickSaveButton();
			
			report.log(LogStatus.INFO, "Step 11. Click on Create button and verify its navigated to Create Bank Account Pop-up window or not");
			objCrtPayee.clickCreateButton();
			if(objCrtPayee.isAccountNumberFieldDisplayed()) 
			{
				//objCrtPayee.clickWarningYesButton();
				
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Bank Account Pop-up window is success");	
			}
			else
			{
				objCrtPayee.clickCreateButton();
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Bank Account Pop-up window is failed");	
			}
			
			if(objCrtPayee.isAccountNumberFieldDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 11.1.Navigation to Create Bank Account Pop-up window is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Navigation to Create Bank Account Pop-up window is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 12. Click in the Account Number. Enter the desired information into the Account Number field. Enter a valid value");
			if(AccountNumber != "") {
				objCrtPayee.enterAccountNumber(AccountNumber);
				report.log(LogStatus.PASS, "Step 12.1.Account Number is entered successfully: "+AccountNumber);
			}else {
				report.log(LogStatus.FAIL, "Step 12.1.Account Number is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 13. Select Currency from list");
			if(Currency != "")
			{
				objCrtPayee.SelectCurrency(Currency);
				report.log(LogStatus.PASS, "Step 13.1.Selected given Currency from the list is "+Currency);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 12.1.Given Currency from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 14. Select Account Type from list");
			if(AccountType != "")
			{
				objCrtPayee.SelectAccountType(AccountType);
				report.log(LogStatus.PASS, "Step 14.1.Selected given Account Type from the list is "+AccountType);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 14.1.Given Account Type from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 15. Click in the Bank. Enter the desired information into the Bank field. Enter a valid value");
			if(Bank != "") {
				objCrtPayee.enterBank(Bank);
				report.log(LogStatus.PASS, "Step 15.1.Bank is entered successfully: "+Bank);
			}else {
				report.log(LogStatus.FAIL, "Step 15.1.Bank is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 16. Click in the Bank Branch. Enter the desired information into the Bank Brach field. Enter a valid value");
			if(BankBranch != "") {
				objCrtPayee.enterBankBranch(BankBranch);
				report.log(LogStatus.PASS, "Step 16.1.Bank Branch is entered successfully: "+BankBranch);
			}else {
				report.log(LogStatus.FAIL, "Step 16.1.Bank Branch is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 17. Click in the Routing Number. Enter the desired information into the Routing Number field. Enter a valid value");
			if(RoutingNumber != "") {
				objCrtPayee.enterRoutingNumber(RoutingNumber);
				report.log(LogStatus.PASS, "Step 17.1.Routing Number is entered successfully: "+RoutingNumber);
			}else {
				report.log(LogStatus.FAIL, "Step 17.1.Routing Number is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 18. Click on Ok button");
			objCrtPayee.clickOkButton();
			
			report.log(LogStatus.INFO, "Step 19. Click on Save And Close button");
			objCrtPayee.clickSaveAndCloseButton();
			
			report.log(LogStatus.INFO, "Step 20. Click on Information Ok button");
			objCrtPayee.clickInfOkButton();
				
	}

}
