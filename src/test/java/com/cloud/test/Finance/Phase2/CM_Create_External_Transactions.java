package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateExternalTransactionPage;
import com.cloud.pageobjects.Finance.Overview_BankStatementPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Create_External_Transactions extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create External Transactions")
	public void Cloud_Create_Ext_Transactions(String UserName,String Password,String BankAccount,String BusinessUnit,String Amount,String TransactionType,String Description,String OffsetAccount)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on CreateTransaction link and verify its navigated to Create External Transaction page or not ");
		CreateExternalTransactionPage objExternal=objOverview.clickCreateTransactionLink();
		if(objExternal.isBankAccountDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create External Transaction page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create External Transaction page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Bank Account from list");
		if(BankAccount != "")
		{
			objExternal.SelectBankAccount(BankAccount);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Bank Account from the list is "+BankAccount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Bank Account from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Select Business Unit from list");
		if(BusinessUnit != "")
		{
			objExternal.SelectBusinessUnit(BusinessUnit);
			report.log(LogStatus.PASS, "Step 9.1.Selected given Business Unit from the list is "+BusinessUnit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given Business Unit from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click in the Amount field. Enter the desired information into the Amount field. Enter a valid value");
		if(Amount!= "") {
			
			objExternal.enterAmount(Amount);
			report.log(LogStatus.PASS, "Step 10.1.Amount is entered successfully: "+Amount);
		}else {
			report.log(LogStatus.FAIL, "Step 10.1.Amount is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 11. Select Transaction Type from list");
		if(TransactionType != "")
		{
			objExternal.SelectTransactionType(TransactionType);
			report.log(LogStatus.PASS, "Step 11.1.Selected given Transaction Type from the list is "+TransactionType);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Given Transaction Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click in the Description field. Enter the desired information into the Description field. Enter a valid value");
		if(Description!= "") {
			
			objExternal.enterDescription(Description);
			report.log(LogStatus.PASS, "Step 12.1.Description is entered successfully: "+Description);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click in the OffsetAccount Value field. Enter the desired information into the OffsetAccount Value field. Enter a valid value");
		if(OffsetAccount!= "") {
			
			objExternal.enterOffsetAccountField(OffsetAccount);
			report.log(LogStatus.PASS, "Step 13.1.OffsetAccount Value is entered successfully: "+OffsetAccount);
		}else {
			report.log(LogStatus.FAIL, "Step 13.1.OffsetAccount Value is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click on Save And Close button ");
		objExternal.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 15. Click on Information Ok button ");
		objExternal.clickInfOkButton();
	}

}
