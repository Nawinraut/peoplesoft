package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.CreateAutomaticReceiptBatchPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Create_Automatic_Receipts extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Automatic Receipts by Receivables Specialist")
	public void AR_Create_Automatic_Receipts(String UserName,String Password,String BusinessUnit,String ReceiptMethod,String FromDueDate,String ToDueDate,String CustomerName,String CustomerNameCell)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Automatic Receipts link and verify its navigated to Create Automatic Receipts page or not");
		CreateAutomaticReceiptBatchPage objCreateAutRcpt=objAccRcvl.clickCreateAutomaticReceiptsLink();
			if(objCreateAutRcpt.isBusinessUitListDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Automatic Receipts Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Automatic Receipts Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objCreateAutRcpt.SelectBusinessUitList(BusinessUnit);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Business Unit from the list is not selected");
			}
		
			
			report.log(LogStatus.INFO, "Step 8. Select Receipt Method from list");
			if(ReceiptMethod != "")
			{
				objCreateAutRcpt.SelectReceiptMethod(ReceiptMethod);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Receipt Method from the list is "+ReceiptMethod);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Receipt Method from the list is not selected");
			}
			
			String fromDateParts[] = FromDueDate.split("-");
			String fromMonth  = fromDateParts[0];
			String fromDay  = fromDateParts[1];
			String fromYear = fromDateParts[2];
			report.log(LogStatus.INFO, "Step 11. Click on From Due Date button");
			objCreateAutRcpt.clickFromDueDateButton();
			report.log(LogStatus.INFO, "Step 11.1. Select From Due Month");
			objCreateAutRcpt.selectFromDueDateMonth(fromMonth);
			report.log(LogStatus.INFO, "Step 11.2. Select From Due Date");
			objCreateAutRcpt.selectFromDueDate(fromDay);
			
			String toDateParts[] = ToDueDate.split("-");
			String toMonth  = toDateParts[0];
			String toDay  = toDateParts[1];
			String toYear = toDateParts[2];
			report.log(LogStatus.INFO, "Step 12. Click on To Due Date button");
			objCreateAutRcpt.clickToDueDateButton();
			report.log(LogStatus.INFO, "Step 12.1. Select To Due Month");
			objCreateAutRcpt.selectToDueDateMonth(toMonth);
			report.log(LogStatus.INFO, "Step 12.2. Select To Due Date");
			objCreateAutRcpt.selectToDueDate(toDay);
			
			report.log(LogStatus.INFO, "Step 13. Click on From Customer Name Search Icon");
			objCreateAutRcpt.clickFromCustomerNameSearchIcon();	
			report.log(LogStatus.INFO, "Step 13.2. Enter the Customer Name in Customer Name text field");
			objCreateAutRcpt.enterCustomerName(CustomerName);
			report.log(LogStatus.INFO, "Step 13.3. Click on Customer Name Search button");
			objCreateAutRcpt.clickCustomerNameSearchButton();
			report.log(LogStatus.INFO, "Step 13.4. Select Payment Process Request");
			objCreateAutRcpt.selectCustomerName(CustomerNameCell);
			report.log(LogStatus.INFO, "Step 13.5. Click on Customer Name Ok button");
			objCreateAutRcpt.clickCustomerNameOkButton();
			
			report.log(LogStatus.INFO, "Step 13. Click on Submit menu");
			objCreateAutRcpt.clickSubmitMenu();
			
			report.log(LogStatus.INFO, "Step 13. Click on Submit, Approve, and Format list");
			objCreateAutRcpt.clickSubmitApproveFormat();
			
			report.log(LogStatus.INFO, "Step 14. Click on Ok Button");
			objCreateAutRcpt.clickInfoOkButton();
		
	}

}
