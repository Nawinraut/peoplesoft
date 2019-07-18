package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AdjustAssetsPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.pageobjects.Finance.ChangeFinancialDetailsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class FA_Adjust_Assets extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Adjust Assets")
	public void Cloud_Adjust_Assets(String UserName,String Password,String AssetNumber,String DepreciationMethod,String LifeinYears)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Adjust Assets link and verify its navigated to Adjust Assets page or not ");
		AdjustAssetsPage objAdjAssets=objAssets.clickAdjustAssetsLink();
		if(objAdjAssets.isAssetNumberDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Adjust Assets page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Adjust Assets page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Click in the Asset Number field. Enter the desired information into the Asset Number field. Enter a valid value");
		if(AssetNumber!= "") {
			objAdjAssets.enterAssetNumber(AssetNumber);
			report.log(LogStatus.PASS, "Step 8.1.Asset Number is entered successfully: "+AssetNumber);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Asset Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click on Search button");
		objAdjAssets.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 10. Select Asset Number Cell");
		objAdjAssets.selectEvent(AssetNumber);
		
		report.log(LogStatus.INFO, "Step 11. Click on Change Financial Details  button and verify its navigated to Change Financial Details page or not ");
		ChangeFinancialDetailsPage objCngFinDetails = objAdjAssets.clickChangeFinancialDetailsButton();
		if(objCngFinDetails.isDepreciationMethodDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 11.1.Navigation to Change Financial Details page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Navigation to Change Financial Details page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 12. Select Depreciation Method from List");
		if(DepreciationMethod!= "") {
			objCngFinDetails.selectDepreciationMethod(DepreciationMethod);
			report.log(LogStatus.PASS, "Step 12.1.Selected given Depreciation Method from the list is: "+DepreciationMethod);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Given Depreciation Method from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 13. Select Life in Years from List");
		if(LifeinYears!= "") {
			objCngFinDetails.selectLifeInYears(LifeinYears);
			report.log(LogStatus.PASS, "Step 13.1.Selected given Life in Years from the list is: "+LifeinYears);
		}else {
			report.log(LogStatus.FAIL, "Step 13.1.Given Life in Years from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click on Submit button");
		objCngFinDetails.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 15. Click on Done button");
		objAdjAssets.clickDoneButton();
	}

}
