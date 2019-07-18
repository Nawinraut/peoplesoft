package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AssetsPage;
import com.cloud.pageobjects.Finance.CreateAccountingForAssets_BasicOptionsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class FA_CreateAccounting extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Accounting for Fixed Assets")
	public void Cloud_FA_Create_Accounting(String UserName,String Password,String EndDate,String AccountingMode,String ProcessEvents,String PostinGeneralLedger)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Accounting link and verify its navigated to Basic Options page or not ");
		CreateAccountingForAssets_BasicOptionsPage objBasicOpt=objAssets.clickCreateAccountingLink();
		if(objBasicOpt.isEndDateBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options page is failed");	
		}
		
		String endDateParts[] = EndDate.split("-");
		String endMonth  = endDateParts[0];
		String endDay  = endDateParts[1];
		String endYear = endDateParts[2];
		report.log(LogStatus.INFO, "Step 8. Click on End Date button");
		objBasicOpt.clickEndDateButton();
		report.log(LogStatus.INFO, "Step 8.1. Select End Date Month");
		objBasicOpt.selectEndDateMonth(endMonth);
		report.log(LogStatus.INFO, "Step 8.2. Select End Date");
		objBasicOpt.selectEndDate(endDay);
		
		report.log(LogStatus.INFO, "Step 9. Select Accounting Mode from list");
		if(AccountingMode != "")
		{
			objBasicOpt.SelectAccountingMode(AccountingMode);
			report.log(LogStatus.PASS, "Step 9.1.Selected given Accounting Mode from the list is: "+AccountingMode);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Given Accounting Mode from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Select Process Events from list");
		if(ProcessEvents != "")
		{
			objBasicOpt.SelectProcessEvents(ProcessEvents);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Process Events from the list is: "+ProcessEvents);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Given Process Events from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 11. Select Post in General Ledger from list");
		if(PostinGeneralLedger != "")
		{
			objBasicOpt.SelectPostGeneralLedger(PostinGeneralLedger);
			report.log(LogStatus.PASS, "Step 11.1.Selected given Post in General Ledger from the list is: "+PostinGeneralLedger);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1.Given Post in General Ledger from the list is not selected");
		}
		
		objBasicOpt.clickSubmissionNotesText();
		
		report.log(LogStatus.INFO, "Step 12. Click on Submit button");
		objBasicOpt.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 13. Click on confirmation Ok button");
		objBasicOpt.clickConfOkButton();
		
	}

}
