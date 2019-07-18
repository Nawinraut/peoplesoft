package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateInvoicePage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Create_Invoice_with_Approvals extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is How to Create Invoice with Approvals")
	public void Cloud_Create_Inv_Approval(String UserName,String Password,String BusinessUnit,String Supplier,String Number,String Amount,String AmountCell,String DistributionCombinationValue)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Invoices link and verify its navigated to Invoices Page or not");
		InvoicesPage objInvoices=objHome.clickInvoices();
		if(objInvoices.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Invoices Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Invoices Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		objInvoices.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Invoices link and verify its navigated to Create Invoice page or not");
		CreateInvoicePage objCrtInvoice=objInvoices.clickCreateInvoiceLink();
		if(objCrtInvoice.isSelectBusinessUnitDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Invoice Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Invoice Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Bussiness Unit from List");
		if(BusinessUnit!= "") {
			objCrtInvoice.SelectBusinessUnit(BusinessUnit);
			//report.log(LogStatus.PASS, "Step 8.1.Selected given Bussiness Unit from the list is "+BusinessUnit);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click on Supplier Search Icon");
		objCrtInvoice.isSearchSupplierIconDisplayed();
		objCrtInvoice.clickSearchSupplierIcon();
		
		report.log(LogStatus.INFO, "Step 9.1. Enter Supplier Name");
		objCrtInvoice.isSupplierDisplayed();
		objCrtInvoice.enterSupplier(Supplier);
		objCrtInvoice.clickSupplierNumber();
	
		report.log(LogStatus.INFO, "Step 9.2. Click on Supplier Search Button");
		objCrtInvoice.isSupplierSearchBtnDisplayed();
		objCrtInvoice.clickSupplierSearchButton(Supplier);
		
		report.log(LogStatus.INFO, "Step 9.3. Select Supplier Cell");
		objCrtInvoice.selectEvent(Supplier);
		
		report.log(LogStatus.INFO, "Step 9.4. Click on Supplier Ok Button");
		objCrtInvoice.isSupplierOkBtnDisplayed();
		objCrtInvoice.clickSupplierOkButton();
		
		
		report.log(LogStatus.INFO, "Step 10. Click in the Number field. Enter the desired information into the Number field. Enter a valid value");
		if(Number!= "") {
			
			objCrtInvoice.enterNumber(Number);
			//report.log(LogStatus.PASS, "Step 10.1.Number is entered successfully: "+Number);
		}else {
			report.log(LogStatus.FAIL, "Step 10.1.Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click in the Amount field. Enter the desired information into the Amount field. Enter a valid value");
		if(Amount!= "") {
			
			objCrtInvoice.enterAmount(Amount);
			//report.log(LogStatus.PASS, "Step 11.1.Amount is entered successfully: "+Amount);
		}else {
			report.log(LogStatus.FAIL, "Step 11.1.Amount is not entered");
		}
		
		objCrtInvoice.clickExpandLinesIcon();
		
		int LineNumber=1;
		
		report.log(LogStatus.INFO, "Step 12. Click in the Distribution Combination Amount field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(AmountCell!= "") {
			
			objCrtInvoice.enterDistCombinationAmount(LineNumber,AmountCell);
			report.log(LogStatus.PASS, "Step 12.1.Distribution Combination Amount is entered successfully: "+AmountCell);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Distribution Combination Amount is not entered");
		}
		
		
		report.log(LogStatus.INFO, "Step 13. Click in the Distribution Combination Value field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(DistributionCombinationValue!= "") {
			
			objCrtInvoice.enterDistCombinationValue(LineNumber,DistributionCombinationValue);
			report.log(LogStatus.PASS, "Step 13.1.Distribution Combination Value is entered successfully: "+DistributionCombinationValue);
		}else {
			report.log(LogStatus.FAIL, "Step 13.1.Distribution Combination Value is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click on Actions Menu");
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 15. Click on Velidate list");
		objCrtInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 16. Click on Infirmation Ok button");
		objCrtInvoice.clickInformationOkButton();
		
		report.log(LogStatus.INFO, "Step 17. Click on Save and Close button");
		objCrtInvoice.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 18. Click on Infirmation Ok button");
		objCrtInvoice.clickInformationOkButton();
		
	}

}
