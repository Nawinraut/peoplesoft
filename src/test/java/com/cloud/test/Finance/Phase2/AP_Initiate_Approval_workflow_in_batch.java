package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.InitiateApprovalWorkflow_SubmitRequestPage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Initiate_Approval_workflow_in_batch extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is to Apply Missing Conversion Rates")
	public void Cloud_Initiate_App_WrkFlw_Batch(String UserName,String Password,String BusinessUnit,String FromInvoiceDate,String ToInvoiceDate,String PartyName)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Invoice link and verify its navigated to Invoice Page or not");
		InvoicesPage objInvoice=objHome.clickInvoices();
		if(objInvoice.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Invoice Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Invoice Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button");
		//sAssert.assertTrue(objInvoice.isTasksBtnDisplayed());
		objInvoice.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Initiate Approval Workflow  link and verify its navigated to Submit Request Page or not");
		InitiateApprovalWorkflow_SubmitRequestPage objSubRequest=objInvoice.clickInitiateApprovalWorkflowLink();
		if(objSubRequest.isSelectBusinessUnitDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Submit Request Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Submit Request Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Bussiness Unit from list");
		if(BusinessUnit != "")
		{
			objSubRequest.SelectBusinessUnit(BusinessUnit);
			report.log(LogStatus.PASS, "Step 8.1.Selected Business Unit from the list is "+BusinessUnit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Bank Account from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click on Party Search Icon");
		objSubRequest.isPartySearchIconDisplayed();
		objSubRequest.clickPartySearchIcon();
		report.log(LogStatus.INFO, "Step 9.1. Click on Party Search link");
		objSubRequest.isPartySearchLinkDisplayed();
		objSubRequest.clickPartySearchLink();	
		report.log(LogStatus.INFO, "Step 9.2. Enter the Party Value in Suplier Or Party text field");
		objSubRequest.isPartyValueDisplayed();
		objSubRequest.enterPartyValue(PartyName);
		
		report.log(LogStatus.INFO, "Step 9.3. Click on Party Search button");
		objSubRequest.isPartySearchButtonDisplayed();
		objSubRequest.clickPartySearchButton();
		report.log(LogStatus.INFO, "Step 9.4. Select Party from dropdown");
		objSubRequest.selectEvent(PartyName);
		report.log(LogStatus.INFO, "Step 9.5. Click on Party Ok button");
		objSubRequest.isPartyOkButtonDisplayed();
		objSubRequest.clickPartyOkButton();
		
		String fromDateParts[] = FromInvoiceDate.split("-");
		String fromMonth  = fromDateParts[0];
		String fromDay  = fromDateParts[1];
		String fromYear = fromDateParts[2];
		report.log(LogStatus.INFO, "Step 10. Click on From Invoice Date button");
		//objSubRequest.isFromInvoiceDtBtnDisplayed();
		objSubRequest.clickFromInvoiceDtButton();
		report.log(LogStatus.INFO, "Step 10.1. Select From Invoice Date Month");
		//objSubRequest.isFromInvoiceMonthDisplayed();
		objSubRequest.selectFromInvoiceMonth(fromMonth);
		report.log(LogStatus.INFO, "Step 10.2. Select From Invoice Date");
		objSubRequest.selectFromInvoiceDate(fromDay);
		
		String toDateParts[] = ToInvoiceDate.split("-");
		String toMonth  = toDateParts[0];
		String toDay  = toDateParts[1];
		String toYear = toDateParts[2];
		report.log(LogStatus.INFO, "Step 11. Click on To Invoice Date button");
		objSubRequest.isToInvoiceDtBtnDisplayed();
		objSubRequest.clickToInvoiceDtButton();
		report.log(LogStatus.INFO, "Step 11.1. Select To Invoice Date Month");
		//objSubRequest.isToInvoiceMonthDisplayed();
		objSubRequest.selectToInvoiceMonth(toMonth);
		report.log(LogStatus.INFO, "Step 11.2. Select To Invoice Date");
		objSubRequest.selectToInvoiceDate(toDay);
		objSubRequest.clickInvoiceNumber();
		
		report.log(LogStatus.INFO, "Step 12. Click the Submit button");
		objSubRequest.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 13. Click the Confirmation Ok button");
		objSubRequest.clickConfOkButton();
	}

}
