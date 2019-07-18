package com.cloud.test.Finance;

import java.io.File;

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

public class AP_Create_a_Standard_Invoice_withFreightLine extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is How to Allocate All Lines in Invoice")
	public void AP_Create_Standard_Inv_Freight(String UserName,String Password,String BusinessUnit,String Supplier,String Number,String FileType,String CategoryType,String FileName,String TextArea,String URL,String Amount,String TypeCell1,String TypeCell2,String TypeCell3,String AmountCell1,String AmountCell2,String AmountCell3,String DistributionCombinationValue1,String DistributionCombinationValue2)throws TestException,InterruptedException, TestException {
		
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
		objCrtInvoice.SelectBusinessUnit(BusinessUnit);
	
		report.log(LogStatus.INFO, "Step 9. Click on Supplier Search Icon");
		objCrtInvoice.isSearchSupplierIconDisplayed();
		objCrtInvoice.clickSearchSupplierIcon();
		
		report.log(LogStatus.INFO, "Step 10. Enter Supplier Name");
		objCrtInvoice.isSupplierDisplayed();
		objCrtInvoice.enterSupplier(Supplier);
		objCrtInvoice.clickSupplierNumber();
	
		report.log(LogStatus.INFO, "Step 11. Click on Supplier Search Button");
		objCrtInvoice.isSupplierSearchBtnDisplayed();
		objCrtInvoice.clickSupplierSearchButton(Supplier);
		
		report.log(LogStatus.INFO, "Step 12. Select Supplier Cell");
		objCrtInvoice.selectEvent(Supplier);
		
		report.log(LogStatus.INFO, "Step 13. Click on Supplier Ok Button");
		objCrtInvoice.isSupplierOkBtnDisplayed();
		objCrtInvoice.clickSupplierOkButton();
		
		report.log(LogStatus.INFO, "Step 14. Enter the Number in Number text field");
		objCrtInvoice.isNumberDisplayed();
		objCrtInvoice.enterNumber(Number);
		
		report.log(LogStatus.INFO, "Step 15. Enter the Amount in Amount text field");
		objCrtInvoice.isAmountDisplayed();
		objCrtInvoice.enterAmount(Amount);
		
		
		
		if (FileType.equalsIgnoreCase("File")) {
			
			report.log(LogStatus.INFO, "Step 15. Click on Attachments Button");
			objCrtInvoice.isAttachmentsBtnDisplayed();
			objCrtInvoice.clickAttachmentsButton();
			
			report.log(LogStatus.INFO, "Step 16. Select File Type from dropdown");
			objCrtInvoice.isfileTypeDisplayed();
			objCrtInvoice.selectfileType(FileType);
						
			report.log(LogStatus.INFO, "Step 17. Select Catagory from dropdown");
			objCrtInvoice.isCatagoryDisplayed();
			objCrtInvoice.selectCatagory(CategoryType);
			
			report.log(LogStatus.INFO, "Step 18. Click on Browse button and upload the file");
			objCrtInvoice.isBrowseBtnDisplayed();
			objCrtInvoice.clickBrowseWithFile(System.getProperty("user.dir")+File.separator+"Cloud_TestData\\Update Address_SPD.pdf");
			objCrtInvoice.isFileUploaded(FileName);
			
			report.log(LogStatus.INFO, "Step 19. Click on Ok button");
			objCrtInvoice.isAttachmentsOkBtnDisplayed();
			objCrtInvoice.clickAttachmentsOkButton();
				
		}else if(FileType.equalsIgnoreCase("Text")){
			
			report.log(LogStatus.INFO, "Step 15. Click on Attachments Button");
			objCrtInvoice.isAttachmentsBtnDisplayed();
			objCrtInvoice.clickAttachmentsButton();
			
			report.log(LogStatus.INFO, "Step 16. Select File Type from dropdown");
			objCrtInvoice.isfileTypeDisplayed();
			objCrtInvoice.selectfileType(FileType);
			
			report.log(LogStatus.INFO, "Step 17. Select Catagory from dropdown");
			objCrtInvoice.isCatagoryDisplayed();
			objCrtInvoice.selectCatagory(CategoryType);
			
			report.log(LogStatus.INFO, "Step 18. Enter Text in File Name or URL field");
			objCrtInvoice.isTypeTextAreaDisplayed();
			objCrtInvoice.enterTypeTextArea(TextArea);
			
			report.log(LogStatus.INFO, "Step 19. Click on Ok button");
			objCrtInvoice.isAttachmentsOkBtnDisplayed();
			objCrtInvoice.clickAttachmentsOkButton();
			
		}else if(FileType.equalsIgnoreCase("URL")) {
			
			report.log(LogStatus.INFO, "Step 15. Click on Attachments Button");
			objCrtInvoice.isAttachmentsBtnDisplayed();
			objCrtInvoice.clickAttachmentsButton();
			
			report.log(LogStatus.INFO, "Step 16. Select File Type from dropdown");
			objCrtInvoice.isfileTypeDisplayed();
			objCrtInvoice.selectfileType(FileType);

			report.log(LogStatus.INFO, "Step 17. Select Catagory from dropdown");
			objCrtInvoice.isCatagoryDisplayed();
			objCrtInvoice.selectCatagory(CategoryType);
			
			report.log(LogStatus.INFO, "Step 18. Enter Text in File Name or URL field");
			objCrtInvoice.isURLTextAreaDisplayed();
			objCrtInvoice.enterURLTextArea(URL);
			
			report.log(LogStatus.INFO, "Step 19. Click on Ok button");
			objCrtInvoice.isAttachmentsOkBtnDisplayed();
			objCrtInvoice.clickAttachmentsOkButton();
			
		}
		
		
		
		
		objCrtInvoice.clickExpandLinesIcon();
		
		// Line Number 1
		
		int LineNumber=1;
		report.log(LogStatus.INFO, "Step 16. Select Type List from Line1");
		if(TypeCell1!= "") {
			objCrtInvoice.selectDistCombinationType(LineNumber,TypeCell1);
			report.log(LogStatus.PASS, "Step 16.1.Selected given Type from the list is "+TypeCell1);
		}else {
			report.log(LogStatus.FAIL, "Step 16.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 17.1. Click in the Distribution Combination Amount field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(AmountCell1!= "") {
			
			objCrtInvoice.enterDistCombinationAmount(LineNumber,AmountCell1);
			report.log(LogStatus.PASS, "Step 17.1.Distribution Combination Amount is entered successfully: "+AmountCell1);
		}else {
			report.log(LogStatus.FAIL, "Step 17.1.Distribution Combination Amount is not entered");
		}
		
		
		report.log(LogStatus.INFO, "Step 18.1. Click in the Distribution Combination Value field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(DistributionCombinationValue1!= "") {
			
			objCrtInvoice.enterDistCombinationValue(LineNumber,DistributionCombinationValue1);
			report.log(LogStatus.PASS, "Step 18.1.Distribution Combination Value is entered successfully: "+DistributionCombinationValue1);
		}else {
			report.log(LogStatus.FAIL, "Step 18.1.Distribution Combination Value is not entered");
		}
		// Line Number 2
		
		LineNumber=2;
		report.log(LogStatus.INFO, "Step 19. Select Type List from Line2");
		if(TypeCell2!= "") {
			objCrtInvoice.clickDistCombinationType(LineNumber);
			objCrtInvoice.selectDistCombinationType(LineNumber,TypeCell2);
			report.log(LogStatus.PASS, "Step 19.1.Selected given Type from the list is "+TypeCell2);
		}else {
			report.log(LogStatus.FAIL, "Step 19.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 20. Click in the Distribution Combination Amount field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(AmountCell2!= "") {
			
			objCrtInvoice.enterDistCombinationAmount(LineNumber,AmountCell2);
			report.log(LogStatus.PASS, "Step 20.1.Distribution Combination Amount is entered successfully: "+AmountCell2);
		}else {
			report.log(LogStatus.FAIL, "Step 20.1.Distribution Combination Amount is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 21. Click in the Distribution Combination Value field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(DistributionCombinationValue2!= "") {
			
			objCrtInvoice.enterDistCombinationValue(LineNumber,DistributionCombinationValue2);
			report.log(LogStatus.PASS, "Step 21.1.Distribution Combination Value is entered successfully: "+DistributionCombinationValue2);
		}else {
			report.log(LogStatus.FAIL, "Step 21.1.Distribution Combination Value is not entered");
		}
		
		// Line Number 3
		LineNumber=3;
		report.log(LogStatus.INFO, "Step 22. Select Type List from Line2");
		if(TypeCell3!= "") {
			objCrtInvoice.clickDistCombinationType(LineNumber);
			objCrtInvoice.selectDistCombinationType(LineNumber,TypeCell3);
			report.log(LogStatus.PASS, "Step 22.1.Selected given Type from the list is "+TypeCell3);
		}else {
			report.log(LogStatus.FAIL, "Step 22.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 23. Click in the Distribution Combination Amount field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(AmountCell3!= "") {
			
			objCrtInvoice.clickDistCombinationAmount_Freight(LineNumber,AmountCell3);
			report.log(LogStatus.PASS, "Step 23.1.Distribution Combination Amount is entered successfully: "+AmountCell2);
		}else {
			report.log(LogStatus.FAIL, "Step 23.1.Distribution Combination Amount is not entered");
		}
		
		
		
		report.log(LogStatus.INFO, "Step 30. Click on Save and Close button");
		objCrtInvoice.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 30. Click on Save and Close button");
		objCrtInvoice.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 31. Click on Infirmation Ok button");
		objCrtInvoice.clickInformationOkButton();
				
	}

}
