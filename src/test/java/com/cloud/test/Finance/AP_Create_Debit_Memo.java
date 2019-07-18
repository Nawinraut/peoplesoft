package com.cloud.test.Finance;

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

public class AP_Create_Debit_Memo extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is How to Create Manual Debit Memo")
	public void AP_Create_Debit_Memo(String UserName,String Password,String BusinessUnit,String Supplier,String Dr_Memo_Number,String Amount,String Type,String PaymentTerms,String Action,String Invoice_Number,String Amount_Cell)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 8. Select Bussiness Unit");
		objCrtInvoice.isSelectBusinessUnitDisplayed();
		objCrtInvoice.SelectBusinessUnit(BusinessUnit);
		
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
		if(Dr_Memo_Number!= "") {
			
			objCrtInvoice.enterNumber(Dr_Memo_Number);
			//report.log(LogStatus.PASS, "Step 10.1.Number is entered successfully: "+Dr_Memo_Number);
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
		
		
		report.log(LogStatus.INFO, "Step 12. Select Type from List");
		if(Type!= "") {
			objCrtInvoice.selectType(Type);
			//report.log(LogStatus.PASS, "Step 12.1.Selected given Type from the list is "+TypeCell1);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 13. Select Payment Terms from list");
		if(PaymentTerms!= "") {
			objCrtInvoice.SelectPaymentTerms(PaymentTerms);
			//report.log(LogStatus.PASS, "Step 13.1.Selected given Payment Terms from the list is "+PaymentTerms);
		}else {
			report.log(LogStatus.FAIL, "Step 13.1.Given Payment Terms from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 14. Select Action from dropdown");
		objCrtInvoice.isActionDisplayed();
		objCrtInvoice.selectAction(Action);
		objCrtInvoice.clickInvoiceGroup();
		
		report.log(LogStatus.INFO, "Step 15. Click on Go button");
		objCrtInvoice.isGoBtnDisplayed();
		objCrtInvoice.clickGoButton();
		
		
		report.log(LogStatus.INFO, "Step 16. Click in the Invoice Number field. Enter the desired information into the Invoice Number field. Enter a valid value");
		if(Invoice_Number!= "") {
			
			objCrtInvoice.enterInvoice(Invoice_Number);
			//report.log(LogStatus.PASS, "Step 16.1.Invoice Number is entered successfully: "+Invoice_Number);
		}else {
			report.log(LogStatus.FAIL, "Step 16.1.Invoice Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click on Search button");
		objCrtInvoice.isSearchBtnDisplayed();
		objCrtInvoice.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 18. Click on Correct Check-Box and Enter the desired information into the Amount field");
		objCrtInvoice.selectCorrectUnmatchedInvoices(Invoice_Number,Amount_Cell);
		
		/*report.log(LogStatus.INFO, "Step 22. Click on Correct Check-Box");
		objCrtInvoice.isCorrectChkBoxDisplayed();
		objCrtInvoice.clickCorrectChkBox();
		
		report.log(LogStatus.INFO, "Step 23. Enter Invoice Amount number");
		objCrtInvoice.isamountInInvoiceeDisplayed();
		objCrtInvoice.enterAmountInInvoice(Amount_Cell);*/
		
		report.log(LogStatus.INFO, "Step 19. Click on Apply button");
		objCrtInvoice.isAppyBtnDisplayed();
		objCrtInvoice.clickApplyButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Ok button");
		objCrtInvoice.isAccountOkButtonDisplayed();
		objCrtInvoice.clickOkButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 22. Select on Validate Invoice Actions Menu");
		objCrtInvoice.isValidateMenuDisplayed();
		objCrtInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 23. Click on Information Ok Button");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
		report.log(LogStatus.INFO, "Step 24. Click on Save And Close Button");
		objCrtInvoice.isSaveAndCloseBtnDisplayed();
		objCrtInvoice.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 25. Click on Information Ok Button");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
	}

}
