package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.pageobjects.Finance.EditSourceLinePage;
import com.cloud.pageobjects.Finance.PrepareSourceLinesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(TestNGListeners.class)
public class FA_Prepare_Source_Lines extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Prepare Source Lines")
	public void Cloud_Prepare_Source_Lines(String UserName,String Password,String Queue,String InvoiceNumber,String Supplier,String SupplierName,String QueueEdit,String AssetNumber,String Description,String Major,String Minor,String ClassCode,String EmployeeName,String Location,String DepreciationExpenseAccount)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Assets link and verify its navigated to Assets Page or not");
		AssetsPage objAssets=objHome.clickAssets();
		if(objAssets.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Assets Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Assets Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objAssets.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Prepare Source Lines link and verify its navigated to Prepare Source Lines page or not");
		PrepareSourceLinesPage objPreSrcLines=objAssets.clickPrepareSourceLinesLink();
		if(objPreSrcLines.isInvoiceNumberDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Prepare Source Lines Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Prepare Source Lines Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Queue from list");
		if(Queue != "")
		{
			objPreSrcLines.selectQueueList(Queue);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Queue from the list is "+Queue);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Queue from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click in the Invoice Number. Enter the desired information into the Invoice Number field. Enter a valid value");
		if(InvoiceNumber != "") {
			objPreSrcLines.enterInvoiceNumber(InvoiceNumber);
			report.log(LogStatus.PASS, "Step 9.1.Invoice Number is entered successfully: "+InvoiceNumber);
		}else {
			report.log(LogStatus.FAIL, "Step 9.1.Invoice Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click on Supplier Search Icon");
		objPreSrcLines.isSearchSupplierIconDisplayed();
		objPreSrcLines.clickSearchSupplierIcon();
		
		report.log(LogStatus.INFO, "Step 10.1. Enter Supplier Name");
		objPreSrcLines.isSupplierNameDisplayed();
		objPreSrcLines.enterSupplierName(Supplier);
		
		report.log(LogStatus.INFO, "Step 10.2. Click on Supplier Search Button");
		objPreSrcLines.isSupplierSearchBtnDisplayed();
		objPreSrcLines.clickSupplierSearchButton(SupplierName);
		
		report.log(LogStatus.INFO, "Step 10.3. Select Supplier Cell");
		objPreSrcLines.selectEvent(SupplierName);
		
		report.log(LogStatus.INFO, "Step 10.4. Click on Supplier Ok Button");
		objPreSrcLines.isSupplierOkBtnDisplayed();
		objPreSrcLines.clickSupplierOkButton();
		
		report.log(LogStatus.INFO, "Step 11. Click on Search Button");
		objPreSrcLines.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 12. Select Source Line Cell");
		objPreSrcLines.selectSourcelineCell();
		
		report.log(LogStatus.INFO, "Step 13. Click the Actions menu");
		objPreSrcLines.clickActionsMenu_Sourceline();
		
		report.log(LogStatus.INFO, "Step 14. Select Edit list from Actions menu and verify its navigated to Edit Source Line Page or not");
		EditSourceLinePage objEditSrcLine=objPreSrcLines.selectEditList_Sourceline();
		if(objEditSrcLine.isAssetNumberDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 14.1.Navigation to Edit Source Line Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Navigation to Edit Source Line Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 15. Select Queue from list");
		if(QueueEdit != "")
		{
			objEditSrcLine.selectQueueList(QueueEdit);
			report.log(LogStatus.PASS, "Step 15.1.Selected given Queue from the list is "+QueueEdit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Given Queue from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 16. Click in the Asset Number. Enter the desired information into the Asset Number field. Enter a valid value");
		if(AssetNumber != "") {
			objEditSrcLine.enterAssetNumber(AssetNumber);
			report.log(LogStatus.PASS, "Step 16.1.Asset Number is entered successfully: "+AssetNumber);
		}else {
			report.log(LogStatus.FAIL, "Step 16.1.Asset Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click in the Description. Enter the desired information into the Description field. Enter a valid value");
		if(Description != "") {
			objEditSrcLine.enterDescription(Description);
			report.log(LogStatus.PASS, "Step 17.1.Description is entered successfully: "+Description);
		}else {
			report.log(LogStatus.FAIL, "Step 17.1.Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 18. Click on Category button");
		objEditSrcLine.clickCategoryButton();
		
		report.log(LogStatus.INFO, "Step 19. Select Major from list");
		if(Major != "")
		{
			objEditSrcLine.SelectMajor(Major);

			report.log(LogStatus.PASS, "Step 19.1.Selected given Major from the list is "+Major);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 19.1.Given Major from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 20. Select Minor from list");
		if(Minor != "")
		{
			objEditSrcLine.SelectMinor(Minor);
			
			report.log(LogStatus.PASS, "Step 20.1.Selected given Minor from the list is "+Minor);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 20.1.Given Minor from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 21. Click on Category Ok button");
		objEditSrcLine.clickCategoryOkButton();
		
		report.log(LogStatus.INFO, "Step 22. Select Class Code from list");
		if(ClassCode != "")
		{
			objEditSrcLine.SelectClassCodeList(ClassCode);
			report.log(LogStatus.PASS, "Step 22.1.Selected given Class Code from the list is "+ClassCode);
		}
		else
		{
			report.log(LogStatus.PASS, "Step 22.1.Class Code from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 23. Select Employee Name from List");
		if(EmployeeName!= "") {
			objEditSrcLine.selectEmployeeName(EmployeeName);
			report.log(LogStatus.PASS, "Step 23.1.Selected given Employee Name from the list is: "+EmployeeName);
		}else {
			report.log(LogStatus.FAIL, "Step 23.1.Given Employee Name from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 24. Click in the Depreciation Expense Account. Enter the desired information into the Depreciation Expense Account field. Enter a valid value");
		if(DepreciationExpenseAccount != "") {
			objEditSrcLine.enterDepreciationExpenseAccountField(DepreciationExpenseAccount);
			report.log(LogStatus.PASS, "Step 24.1.Depreciation Expense Account is entered successfully: "+DepreciationExpenseAccount);
		}else {
			report.log(LogStatus.FAIL, "Step 24.1.Depreciation Expense Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 25. Select Location from List");
		if(Location != "") {
			
			objEditSrcLine.clickLocationButton();
			objEditSrcLine.clickLocationSearchIcon(Location);
			objEditSrcLine.selectEvent(Location);
			objEditSrcLine.clickLocationOkButton();
			report.log(LogStatus.PASS, "Step 25.1.Selected given Location from the list is: "+Location);
		}else {
			report.log(LogStatus.FAIL, "Step 25.1.Given Location from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 26. Click on Save and Close button");
		objEditSrcLine.clickSaveAndCloseButton();
	}

}
