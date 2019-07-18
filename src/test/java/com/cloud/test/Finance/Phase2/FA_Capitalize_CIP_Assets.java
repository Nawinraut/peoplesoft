package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.pageobjects.Finance.CapitalizeCIPAssetsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class FA_Capitalize_CIP_Assets extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Capitalize CIP Assets by Asset Accountant")
	public void Cloud_Capitalize_CIP_Assets(String UserName,String Password,String AssetNumber,String AssetType,String DatePlacedinService)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Capitalize CIP Assets link and verify its navigated to Capitalize CIP Assets page or not ");
		CapitalizeCIPAssetsPage objCIPAssets=objAssets.clickCapitalizeCIPAssetsLink();
		if(objCIPAssets.isAssetNumberDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Capitalize CIP Assets page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Capitalize CIP Assets page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Click in the Asset Number field. Enter the desired information into the Asset Number field. Enter a valid value");
		if(AssetNumber!= "") {
			objCIPAssets.enterAssetNumber(AssetNumber);
			report.log(LogStatus.PASS, "Step 8.1.Asset Number is entered successfully: "+AssetNumber);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Asset Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 9. Select Asset Type list");
		if(AssetType != "")
		{
			objCIPAssets.selectAssetTypeList(AssetType);  
			report.log(LogStatus.PASS, "Step 9.1.Selected given Asset Type from the list is: "+AssetType);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given Asset Type from the list is not selected");
		}
		report.log(LogStatus.INFO, "Step 10. Click on Search button");
		objCIPAssets.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 11. Select Asset Number Cell");
		objCIPAssets.selectEvent(AssetNumber);
		
		report.log(LogStatus.INFO, "Step 12. Click on Capitalize button");
		objCIPAssets.clickCapitalizeButton();
		
		String DatePlacedinServiceParts[] = DatePlacedinService.split("-");
		String placedinServiceMonth  = DatePlacedinServiceParts[0];
		String placedinServiceDay  = DatePlacedinServiceParts[1];
		String placedinServiceYear = DatePlacedinServiceParts[2];
		report.log(LogStatus.INFO, "Step 13. Click on Placed in Service Date button");
		objCIPAssets.clickDatePlacedinServiceButton();
		report.log(LogStatus.INFO, "Step 13.1. Select Placed in Service Month");
		objCIPAssets.selectDatePlacedinServiceMonth(placedinServiceMonth);
		report.log(LogStatus.INFO, "Step 13.2. Select Conversion Placed in Service Date");
		objCIPAssets.selectDatePlacedinServiceDate(placedinServiceDay);
		
		report.log(LogStatus.INFO, "Step 14. Click on Ok button");
		objCIPAssets.clickOk_DatePlacedServiceButton();
		
		report.log(LogStatus.INFO, "Step 15. Click on Done button");
		objCIPAssets.clickDoneButton();
		
	}

}
