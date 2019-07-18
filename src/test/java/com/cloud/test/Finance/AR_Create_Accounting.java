package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.BillingPage;
import com.cloud.pageobjects.Finance.CreateReceivablesAccounting_BasicOptionsPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Create_Accounting extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is How to Create Accounting")
	public void AR_Create_Accounting(String UserName,String Password,String PrintFormat,String Ledger,String EndDate,String CreateAccounting,String AccountingMode)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Billing link and verify its navigated to Billing page or not");
		BillingPage objBilling=objHome.clickBilling();
		
		report.log(LogStatus.INFO, "Step 5. Click on Tasks Button");
		objBilling.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Create Accounting link and verify its navigated to Basic Options page or not ");
		CreateReceivablesAccounting_BasicOptionsPage objBasicOpt=objBilling.clickCreateAccountingLink();
		if(objBasicOpt.isPrintFormatListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.Navigation to Basic Options page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Select Print Format from list");
		if(PrintFormat != "")
		{
			objBasicOpt.selectPrintFormatList(PrintFormat);
			report.log(LogStatus.PASS, "Step 7.1.Selected given PrintFormat from the list is "+PrintFormat);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Given PrintFormat from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Ledger from list");
		if(Ledger != "")
		{
			objBasicOpt.SelectLedgerList(Ledger);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Ledger from the list is "+Ledger);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Ledger from the list is not selected");
		}
		
		String endDateParts[] = EndDate.split("-");
		String endMonth  = endDateParts[0];
		String endDay  = endDateParts[1];
		String endYear = endDateParts[2];
		report.log(LogStatus.INFO, "Step 9. Click on End Date button");
		objBasicOpt.clickEndDateButton();
		report.log(LogStatus.INFO, "Step 9.1. Select End Date Month");
		objBasicOpt.selectEndDateMonth(endMonth);
		report.log(LogStatus.INFO, "Step 9.2. Select End Date Date");
		objBasicOpt.selectEndDate(endDay);
		
		report.log(LogStatus.INFO, "Step 10. Select Create Accounting from list");
		if(CreateAccounting != "")
		{
			objBasicOpt.selectCreateAccounting(CreateAccounting);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Create Accounting from the list is "+CreateAccounting);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Given Create Accounting from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 11. Select Create Accounting from list");
		if(AccountingMode != "")
		{
			objBasicOpt.selectAccountingMode(AccountingMode);
			report.log(LogStatus.PASS, "Step 11.1.Selected given Accounting Mode from the list is "+AccountingMode);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Given Create Accounting Mode from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click on Submit button");
		objBasicOpt.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 13. Click on Ok cinfirmation button");
		objBasicOpt.clickConfOkButton();
		
		
		
	}
}
