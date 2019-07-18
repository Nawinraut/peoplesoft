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

public class AP_Create_a_Standard_Invoice_with_2lines extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Standard Invoice with Attachment")
	public void AP_Standard_Inv_2Lines(String UserName,String Password,String BusinessUnit,String Supplier,String Number,String Amount,String AmountCell1,String AmountCell2,String DistributionCombinationField1,String DistributionCombinationField2)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 6. Click on Create Invoices link");
		objInvoices.isCreateInvoiceLinkDisplayed(); 
		CreateInvoicePage objCrtInvoice=objInvoices.clickCreateInvoiceLink();
		
		report.log(LogStatus.INFO, "Step 7. Select Bussiness Unit");
		objCrtInvoice.isSelectBusinessUnitDisplayed();
		objCrtInvoice.SelectBusinessUnit(BusinessUnit);
		
		report.log(LogStatus.INFO, "Step 8. Click on Supplier Search Icon");
		objCrtInvoice.isSearchSupplierIconDisplayed();
		objCrtInvoice.clickSearchSupplierIcon();
		
		report.log(LogStatus.INFO, "Step 9. Enter Supplier Name");
		objCrtInvoice.isSupplierDisplayed();
		objCrtInvoice.enterSupplier(Supplier);
		objCrtInvoice.clickSupplierNumber();
	
		report.log(LogStatus.INFO, "Step 10. Click on Supplier Search Button");
		objCrtInvoice.isSupplierSearchBtnDisplayed();
		objCrtInvoice.clickSupplierSearchButton(Supplier);
		
		report.log(LogStatus.INFO, "Step 11. Select Supplier Cell");
		objCrtInvoice.selectEvent(Supplier);
		
		report.log(LogStatus.INFO, "Step 12. Click on Supplier Ok Button");
		objCrtInvoice.isSupplierOkBtnDisplayed();
		objCrtInvoice.clickSupplierOkButton();
		
		report.log(LogStatus.INFO, "Step 13. Enter the Number in Number text field");
		objCrtInvoice.isNumberDisplayed();
		objCrtInvoice.enterNumber(Number);
		
		report.log(LogStatus.INFO, "Step 14. Enter the Amount in Amount text field");
		objCrtInvoice.isAmountDisplayed();
		objCrtInvoice.enterAmount(Amount);
		
		report.log(LogStatus.INFO, "Step 15. Click on Expand Lines icon");
		objCrtInvoice.clickExpandLinesIcon();
		
		report.log(LogStatus.INFO, "Step 16. Enter Amount in Amount Cell");
		//objCrtInvoice.isAmountCellDisplayed();
		objCrtInvoice.enterDistCombinationAmount(1, AmountCell1);
		
		report.log(LogStatus.INFO, "Step 17. Click in the Invoice Lines Distribution Combination field. Enter the desired information into the Invoice Lines Distribution Combination field. Enter a valid value");
		if(DistributionCombinationField1 != "")
		{
			objCrtInvoice.enterDistCombinationValue(1, DistributionCombinationField1);
			report.log(LogStatus.PASS, "Step 17.1.Invoice Lines Distribution Combination is entered successfully: "+DistributionCombinationField1);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 17.1.Invoice Lines Distribution Combination is not entered");
		}
		
		objCrtInvoice.clickAmountTab();
		
		report.log(LogStatus.INFO, "Step 18. Enter Amount in Amount Cell");
		//objCrtInvoice.isAmountCellDisplayed();
		objCrtInvoice.enterDistCombinationAmount(2, AmountCell2);
		
		report.log(LogStatus.INFO, "Step 19. Click in the Invoice Lines Distribution Combination field. Enter the desired information into the Invoice Lines Distribution Combination field. Enter a valid value");
		if(DistributionCombinationField2 != "")
		{
			objCrtInvoice.enterDistCombinationValue(2, DistributionCombinationField2);
			report.log(LogStatus.PASS, "Step 19.1.Invoice Lines Distribution Combination is entered successfully: "+DistributionCombinationField1);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 19.1.Invoice Lines Distribution Combination is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 20. Click on Save button");
		objCrtInvoice.isSaveButtonDisplayed();
		objCrtInvoice.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on SaveAndClose button");
		objCrtInvoice.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 22. Click on Information pop-up Ok button");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
		/*report.log(LogStatus.INFO, "Step 49. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 50. Select on Validate item from Invoice Actions Menu");
		objCrtInvoice.isValidateMenuDisplayed();
		objCrtInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 51. Click on Information pop-up Ok button");
		objCrtInvoice.isInformationOkBtnDisplayed();
		objCrtInvoice.clickInformationOkButton();
		
		report.log(LogStatus.INFO, "Step 52. Click on Invoice Actions Menu");
		objCrtInvoice.isActionsMenuDisplayed();
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 53. Select on Post to Ledger item from Invoice Actions Menu");
		objCrtInvoice.isPostLedgerMenuDisplayed();
		objCrtInvoice.selectPostLedgerMenu();
		
		report.log(LogStatus.INFO, "Step 54. Click on Confirmation Ok button");
		objCrtInvoice.isConfOkButtonDisplayed();
		//String message="You have successfully created standard invoice with attachment.";
		objCrtInvoice.clickConfOkButton();*/
	}

}
