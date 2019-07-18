package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreatePaymentPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Create_Manual_Payment extends BaseWebTest{

	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Manual Payment by Payables Supervisor")
	public void Cloud_Create_Manual_Payment(String UserName,String Password,String BusinessUnit,String Supplier,String SupplierCell,String DisbursementBankAccount,String PaymentProcessProfile,String InvoiceNumber)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Payments link and verify its navigated to Overview Page or not");
		OverviewPage objOverview=objHome.clickPayments();
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Payment link and verify its navigated to Create Payment page or not");
		CreatePaymentPage objCreatePayment=objOverview.clickCreatePaymentLink();
			if(objCreatePayment.isSelectBusinessUnitDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Payment Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Payment Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objCreatePayment.SelectBusinessUnit(BusinessUnit);
				//report.log(LogStatus.PASS, "Step 8.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Business Unit from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click on Party Search Icon");
			objCreatePayment.clickPartySearchIcon();
			report.log(LogStatus.INFO, "Step 9.1. Click on Party Search link");
			objCreatePayment.clickPartySearchLink();
			report.log(LogStatus.INFO, "Step 9.2. Click in the Suplier field. Enter the desired information into the Suplier field. Enter a valid value");
			if(Supplier != "")
			{
				objCreatePayment.enterPartyValue(Supplier);
				objCreatePayment.clickSupplierNumber();
				//report.log(LogStatus.PASS, "Step 9.2.1. Supplier is entered successfully: "+Supplier);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.2.1. Supplier is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 9.3. Click on Party Search button");
			objCreatePayment.clickPartySearchButton();
			report.log(LogStatus.INFO, "Step 9.4. Select Party from dropdown");
			objCreatePayment.selectEvent(SupplierCell);
			report.log(LogStatus.INFO, "Step 9.5. Click on Party Ok button");
			objCreatePayment.isPartyOkButtonDisplayed();
			objCreatePayment.clickPartyOkButton();
			
			report.log(LogStatus.INFO, "Step 10. Select Disbursement Bank Account from list");
			if(DisbursementBankAccount != "")
			{
				objCreatePayment.SelectDisbursementBankAccount(DisbursementBankAccount);
				//report.log(LogStatus.PASS, "Step 10.1.Selected given Disbursement Bank Account from the list is "+DisbursementBankAccount);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 10.1.Given Disbursement Bank Account from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 11. Select Payment Process Profile from list");
			if(PaymentProcessProfile != "")
			{
				objCreatePayment.SelectPaymentProcessProfile(PaymentProcessProfile);
				//report.log(LogStatus.PASS, "Step 11.1.Selected given Payment Process Profile from the list is "+PaymentProcessProfile);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Given Payment Process Profile from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 12. Click on Select and Add button and verify its navigated to Select and Add: Invoices to Pay Pop-Up or not");
			if(objCreatePayment.isSelectAndAddButtonEnabled()) {
				objCreatePayment.clickSelectAndAddButton();
			}
			else
			{
				SeleniumUtils.delay(3000);
				objCreatePayment.clickSelectAndAddButton();
			}
			
			if(objCreatePayment.isInvoiceNumberDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 12.1.Navigation to Select and Add: Invoices to Pay Pop-Up is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 12.1.Navigation to Select and Add: Invoices to Pay Pop-Up is failed");	
			}
				
			report.log(LogStatus.INFO, "Step 13. Click in the Invoice Number field. Enter the desired information into the Invoice Number field. Enter a valid value");
			if(InvoiceNumber != "")
			{
				objCreatePayment.enterInvoiceNumber(InvoiceNumber);
				objCreatePayment.clickInvoiceAmount();
				report.log(LogStatus.PASS, "Step 13.1. Invoice Number is entered successfully: "+InvoiceNumber);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 13.1. Invoice Number is not entered");
			}	
			
			report.log(LogStatus.INFO, "Step 14. Click on Invoice Search button");
			objCreatePayment.clickInvoiceSearchButton();
			
			report.log(LogStatus.INFO, "Step 15.Select Invoice Cell");
			objCreatePayment.selectInvoice(InvoiceNumber);
			
			report.log(LogStatus.INFO, "Step 16. Click on Invoice Apply button");
			objCreatePayment.clickInvoiceApplyhButton();
			
			report.log(LogStatus.INFO, "Step 17. Click on Invoice Ok button");
			objCreatePayment.clickInvoiceOkButton();
			
			report.log(LogStatus.INFO, "Step 18. Click on Save and Close button");
			objCreatePayment.clickSaveAndCloseButton();
			
			report.log(LogStatus.INFO, "Step 19. Click on Confirmation Ok button");
			objCreatePayment.clickConfOkButton();
	}
}
