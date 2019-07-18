package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.pageobjects.Finance.ReinstateAssetsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class FA_Reinstate_Assets extends BaseWebTest{

	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Reinstate Assets")
	public void Cloud_Reinstate_Assets(String UserName,String Password,String FromRetirementDate,String AssetNumber)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Reinstate Assets link and verify its navigated to Reinstate Assets page or not ");
		ReinstateAssetsPage objReinstateAssets=objAssets.clickReinstateAssetsLink();
		if(objReinstateAssets.isAssetNumberDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Reinstate Assets page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Reinstate Assets page is failed");	
		}
		
		String fromRetirementDateParts[] = FromRetirementDate.split("-");
		String fromRetirementMonth  = fromRetirementDateParts[0];
		String fromRetirementDay  = fromRetirementDateParts[1];
		String fromRetirementYear = fromRetirementDateParts[2];
		report.log(LogStatus.INFO, "Step 8. Click on from Retirement Date button");
		objReinstateAssets.clickFromRetirementDateButton();
		report.log(LogStatus.INFO, "Step 8.1. Select from Retirement Month");
		objReinstateAssets.selectFromRetirementMonth(fromRetirementMonth);
		report.log(LogStatus.INFO, "Step 8.2. Select from Retirement Date");
		objReinstateAssets.selectFromRetirementDate(fromRetirementDay);
		
		report.log(LogStatus.INFO, "Step 9. Click in the Asset Number field. Enter the desired information into the Asset Number field. Enter a valid value");
		if(AssetNumber!= "") {
			objReinstateAssets.enterAssetNumber(AssetNumber);
			report.log(LogStatus.PASS, "Step 9.1.Asset Number is entered successfully: "+AssetNumber);
		}else {
			report.log(LogStatus.FAIL, "Step 9.1.Asset Number is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click on Search button");
		objReinstateAssets.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 11. Select Asset Number Cell");
		objReinstateAssets.selectEvent(AssetNumber);
		
		report.log(LogStatus.INFO, "Step 12. Click on Reinstate button");
		objReinstateAssets.clickReinstateButton();
		
		report.log(LogStatus.INFO, "Step 13. Click on Warning Yes button");
		objReinstateAssets.clickWarningYesButton();
		
		report.log(LogStatus.INFO, "Step 14. Click on Done button");
		objReinstateAssets.clickDoneButton();
		
	}

}
