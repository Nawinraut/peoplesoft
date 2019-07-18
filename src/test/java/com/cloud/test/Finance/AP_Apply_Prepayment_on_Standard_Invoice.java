package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.EditInvoicePage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.ManageInvoicesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Apply_Prepayment_on_Standard_Invoice extends BaseWebTest{
	
	SoftAssert sAssert;

	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Cancel Line In Invoice")
	public void AP_Apply_Prepayment_On_Stnd_Inv(String UserName,String Password,String BusinessUnit,String PartyName,String InvoiceNumber,String Amount,String PrePaymentNumber)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Invoices link");
		InvoicesPage objInvoices=objHome.clickInvoices();
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objInvoices.isTasksBtnDisplayed());
		objInvoices.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Manage Invoices link");
		objInvoices.isCreateInvoiceLinkDisplayed(); 
		ManageInvoicesPage objMngInvoice=objInvoices.clickManageInvoiceLink();
		
		report.log(LogStatus.INFO, "Step 7. Select Bussiness Unit");
		objMngInvoice.isSelectBusinessUnitDisplayed();
		objMngInvoice.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 8. Enter Invoice Number");
		objMngInvoice.isInvoiceNumberDisplayed();
		objMngInvoice.enterInvoiceNumber(InvoiceNumber);
		
		report.log(LogStatus.INFO, "Step 9. Click on Supplier or Party Search Icon");
		objMngInvoice.isSearchSupplierOrPartyIconDisplayed();
		objMngInvoice.clickSearchSupplierOrPartyIcon();
		
		report.log(LogStatus.INFO, "Step 10. Enter Party Name");
		objMngInvoice.isPartyNameDisplayed();
		objMngInvoice.enterPartyName(PartyName);
		objMngInvoice.clickSupplierNumber();
		
		report.log(LogStatus.INFO, "Step 11. Click on Supplier Search Button");
		objMngInvoice.isSupplierSearchBtnDisplayed();
		objMngInvoice.clickSupplierSearchButton();
		
		report.log(LogStatus.INFO, "Step 12. Select Supplier Cell");
		objMngInvoice.selectEvent(PartyName);
		
		report.log(LogStatus.INFO, "Step 13. Click on Supplier Ok Button");
		objMngInvoice.isSupplierOkBtnDisplayed();
		objMngInvoice.clickSupplierOkButton();
		SeleniumUtils.delay(1000);
		objMngInvoice.clickInvoiceAmountField();
		
		report.log(LogStatus.INFO, "Step 14. Click on Invoice Search Button");
		objMngInvoice.isInvoiceSearchBtnDisplayed();
		objMngInvoice.clickInvoiceSearchButton(InvoiceNumber);
		
		report.log(LogStatus.INFO, "Step 15. Select Invoice link Cell");
		objMngInvoice.selectInvoiceEvent(InvoiceNumber);
		
		report.log(LogStatus.INFO, "Step 16. Click on Invoice Actions Menu");
		objMngInvoice.isActionsMenuDisplayed();
		objMngInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 17. Select Edit item from Actions Menu");
		objMngInvoice.isEditMenuDisplayed(); 
		EditInvoicePage objEditInvoice=objMngInvoice.selectEditMenu();
		
		report.log(LogStatus.INFO, "Step 18. Click on Action menu");
		objEditInvoice.isActionsMenuDisplayed();
		objEditInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 19. Select Apply or Unapply Prepayments list from Action menu");
		objEditInvoice.isApplyOrUnapplyPrepaymentsMenuDisplayed();
		objEditInvoice.selectApplyOrUnapplyPrepaymentsMenu();
		
		report.log(LogStatus.INFO, "Step 20. Click on Qyery by Example icon");
		objEditInvoice.isQyeryByExampleiconDisplayed();
		objEditInvoice.clickQyeryByExampleicon(PrePaymentNumber);
		
		report.log(LogStatus.INFO, "Step 21. Select Prepayment and enter the Cell Amount");
		objEditInvoice.selectApplyOrUnapplyPrepayments(PrePaymentNumber, Amount);
		
		report.log(LogStatus.INFO, "Step 22. Click on Apply button");
		objEditInvoice.isApplyOrUnapplyPrepayments_ApplyButtonDisplayed();
		objEditInvoice.clicApplyOrUnapplyPrepayments_ApplyButton();
		
		report.log(LogStatus.INFO, "Step 23. Click on Done button");
		objEditInvoice.isApplyOrUnapplyPrepayments_DoneButtonDisplayed();
		objEditInvoice.clicApplyOrUnapplyPrepayments_doneButton();
		
		report.log(LogStatus.INFO, "Step 24. Click on Action Menu");
		objEditInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 25. Select Validate list from Action Menu");
		objEditInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 26. Click on Action Menu");
		objEditInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 27. Select Post list from Action Menu");
		objEditInvoice.selectPostMenu();
		
		report.log(LogStatus.INFO, "Step 28. Select Ok button");
		objEditInvoice.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 29. Click on Save and Close button");
		objEditInvoice.clickSaveAndCloseButton();
		
		
		
	}

}
