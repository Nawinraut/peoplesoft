package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.pageobjects.Finance.TransferAsset_AssetPage;
import com.cloud.pageobjects.Finance.TransferAssetsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class FA_Transfer_Assets extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Transfer Assets")
	public void Cloud_Transfer_Assets(String UserName,String Password,String AssetNumber,String NewUnits_R1,String NewUnits_R2,String EmployeeName_R2,String DepreciationExpenseAccount_R2,String Location_R2)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Transfer Assets link and verify its navigated to Transfer Assets page or not ");
		TransferAssetsPage objTrnAssets=objAssets.clickTransferAssetsLink();
		if(objTrnAssets.isAssetNumberDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Transfer Assets page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Transfer Assets page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Click in the Asset Number field. Enter the desired information into the Asset Number field. Enter a valid value");
		if(AssetNumber!= "") {
			objTrnAssets.enterAssetNumber(AssetNumber);
			report.log(LogStatus.PASS, "Step 8.1.Asset Number is entered successfully: "+AssetNumber);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Asset Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click on Search button");
		objTrnAssets.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 10. Select Asset Number Cell");
		objTrnAssets.selectEvent(AssetNumber);
		
		report.log(LogStatus.INFO, "Step 11. Click on Transfer Asset  button and verify its navigated to Transfer Asset page or not ");
		TransferAsset_AssetPage objTrnsAsset = objTrnAssets.clickTransferAssetButton();
		if(objTrnsAsset.isAddRowBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 11.1.Navigation to Transfer Asset page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Navigation to Transfer Asset page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 12. Click in the New Units field. Enter the desired information into the New Units field. Enter a valid value");
		if(NewUnits_R1!= "") {
			objTrnsAsset.enterNewUnitsField1(NewUnits_R1);
			report.log(LogStatus.PASS, "Step 12.1.New Units is entered successfully: "+NewUnits_R1);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.New Units is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click on Add Row button");
		objTrnsAsset.clickAddRowButton();
		
		report.log(LogStatus.INFO, "Step 14. Click in the New Units field. Enter the desired information into the New Units field. Enter a valid value");
		if(NewUnits_R2!= "") {
			objTrnsAsset.enterNewUnitsField2(NewUnits_R2);
			report.log(LogStatus.PASS, "Step 14.1.New Units is entered successfully: "+NewUnits_R2);
		}else {
			report.log(LogStatus.FAIL, "Step 14.1.New Units is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 15. Select Employee Name from List");
		if(EmployeeName_R2!= "") {
			objTrnsAsset.selectEmployeeNameField2(EmployeeName_R2);
			report.log(LogStatus.PASS, "Step 15.1.Selected given Employee Name from the list is: "+EmployeeName_R2);
		}else {
			report.log(LogStatus.FAIL, "Step 15.1.Given Employee Name from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 16. Click in the Depreciation Expense Account field. Enter the desired information into the Depreciation Expense Account field. Enter a valid value");
		if(DepreciationExpenseAccount_R2 != "") {
			objTrnsAsset.enterDepreciationExpenseAccountField2(DepreciationExpenseAccount_R2);
			report.log(LogStatus.PASS, "Step 16.1.Depreciation Expense Account is entered successfully: "+DepreciationExpenseAccount_R2);
		}else {
			report.log(LogStatus.FAIL, "Step 16.1.Depreciation Expense Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Select Location from List");
		if(Location_R2 != "") {
			//objTrnsAsset.selectLocationField2(Location_R2);
			objTrnsAsset.clickLocation_Field2Button();
			objTrnsAsset.clickLocationSearchIcon(Location_R2);
			objTrnsAsset.selectEvent(Location_R2);
			objTrnsAsset.clickLocationOkButton();
			report.log(LogStatus.PASS, "Step 17.1.Selected given Location from the list is: "+Location_R2);
		}else {
			report.log(LogStatus.FAIL, "Step 17.1.Given Location from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 18. Click on Submit button");
		objTrnsAsset.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 19. Click on Done button");
		objTrnAssets.clickDoneButton();
		
	}

}
