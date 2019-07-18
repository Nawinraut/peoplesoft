package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CashBalancesPage;
import com.cloud.pageobjects.Finance.CreateAdHocPaymentPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class CM_Create_Adhoc_Payments extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Adhoc Payments")
	public void Cloud_Create_Adhoc_Payments(String UserName,String Password,String FromAccount,String Payee,String AccountPayee,String PaymentDate,String PaymentAmount,String OffsetAccount,String BusinessUnit,String PaymentMethod,String PaymentProfile)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Ad Hoc Payment link and verify its navigated to Create Ad Hoc Payment page or not ");
		CreateAdHocPaymentPage objCrtAdHoc=objBalances.clickCreateAdHocPaymentLink();
		if(objCrtAdHoc.isFromAccountListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Ad Hoc Payment page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Ad Hoc Payment page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select From Account from list");
		if(FromAccount != "")
		{
			objCrtAdHoc.SelectFromAccount(FromAccount);
			report.log(LogStatus.PASS, "Step 8.1.Selected given From Account from the list is "+FromAccount);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given From Account from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Select To Payee from list");
		if(Payee != "")
		{
			objCrtAdHoc.SelectPayee(Payee);
			report.log(LogStatus.PASS, "Step 9.1.Selected given Payee from the list is "+Payee);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given Payee from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Select To Account Payee from list");
		if(AccountPayee != "")
		{
			objCrtAdHoc.SelectAccountPayee(AccountPayee);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Account Payee from the list is "+AccountPayee);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Given Account Payee from the list is not selected");
		}
		
		String PaymentDateParts[] = PaymentDate.split("-");
		String PaymentMonth  = PaymentDateParts[0];
		String PaymentDay  = PaymentDateParts[1];
		String PaymentYear = PaymentDateParts[2];
		report.log(LogStatus.INFO, "Step 11. Click on Payment Date button");
		objCrtAdHoc.clickPaymentDateButton();
		report.log(LogStatus.INFO, "Step 11.1. Select Payment Date Month");
		objCrtAdHoc.selectPaymentMonth(PaymentMonth);
		report.log(LogStatus.INFO, "Step 11.2. Select Payment Date");
		objCrtAdHoc.selectPaymentDate(PaymentDay);
		
		report.log(LogStatus.INFO, "Step 12.1. Click in the Payment Amount field. Enter the desired information into the Payment Amount field. Enter a valid value");
		if(PaymentAmount!= "") {
			
			objCrtAdHoc.enterPaymentAmount(PaymentAmount);
			report.log(LogStatus.PASS, "Step 12.1.Distribution Payment Amount is entered successfully: "+PaymentAmount);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Distribution Payment Amount is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click in the OffsetAccount Value field. Enter the desired information into the OffsetAccount Value field. Enter a valid value");
		if(OffsetAccount!= "") {
			
			objCrtAdHoc.enterOffsetAccountField(OffsetAccount);
			report.log(LogStatus.PASS, "Step 13.1.OffsetAccount Value is entered successfully: "+OffsetAccount);
		}else {
			report.log(LogStatus.FAIL, "Step 13.1.OffsetAccount Value is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Select Business Unit from list");
		if(BusinessUnit != "")
		{
			objCrtAdHoc.SelectBusinessUnit(BusinessUnit);
			report.log(LogStatus.PASS, "Step 14.1.Selected given Business Unit from the list is "+BusinessUnit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Given Business Unit the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 15. Select Payment Method from list");
		if(PaymentMethod != "")
		{
			objCrtAdHoc.SelectPaymentMethod(PaymentMethod);
			report.log(LogStatus.PASS, "Step 15.1.Selected given Payment Method from the list is "+PaymentMethod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Given Payment Method the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 16. Select Payment Profile from list");
		if(PaymentProfile != "")
		{
			objCrtAdHoc.SelectPaymentProfile(PaymentProfile);
			report.log(LogStatus.PASS, "Step 16.1.Selected given Payment Profile from the list is "+PaymentProfile);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step16.1.Given Payment Profile the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click on Submit button");
		objCrtAdHoc.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 18. Click on Confirmation Yes button");
		objCrtAdHoc.clickConfYesButton();
		
	}

}
