package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.GenerateAllocations_BasicOptionsPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.pageobjects.Finance.ManageJournalsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class GL_Create_Allocation_Journal extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Transfer balances to secondary ledger")
	public void Cloud_Create_Allocation_Journal(String UserName,String Password,String RuleOrRuleSet,String AccountingPeriod,String Source,String Category,String BatchStatus)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Journals link and verify its navigated to Journals Page or not");
		JournalsPage objJournals=objHome.clickJournals();
		if(objJournals.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Journals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Journals  Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objJournals.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Generate General Ledger Allocations link and verify its navigated to Basic Options page or not ");
		GenerateAllocations_BasicOptionsPage objBscOptions=objJournals.clickGenerateGeneralLedgerAllocationsLink();
		if(objBscOptions.isRuleOrRuleSetListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Rule Or Rule Set from List");
		if(RuleOrRuleSet!= "") {
			objBscOptions.selectRuleOrRuleSetList(RuleOrRuleSet);
			objBscOptions.clickSubmissionNote();
			report.log(LogStatus.PASS, "Step 8.1.Selected given Rule Or Rule Set from the list is: "+RuleOrRuleSet);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Given Rule Or Rule Set from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click the Submit button");
		objBscOptions.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 10. Click the Confirmation Ok button");
		objBscOptions.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 11. Click on Navigator Icon");
		objHome.clickImgHome();
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 12. Click on Journals link and verify its navigated to Journals Page or not");
		JournalsPage objJournals1=objHome.clickJournals();
		if(objJournals1.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 12.1.Navigation to Journals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Navigation to Journals  Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 13. Click on Taksks button");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objJournals1.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 14. Click on Manage Journals link and verify its navigated to Manage Journals page or not ");
		ManageJournalsPage objMngJournal=objJournals1.clickManageJournalLink();
		if(objMngJournal.isDoneButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 14.1.Navigation to Manage Journals page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Navigation to Manage Journals page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 15. Select Reversal Period from list");
		if(AccountingPeriod != "")
		{
			objMngJournal.clickAccountingPeriodSearchIcon();
			objMngJournal.clickAccPeriodSearchLink();
			objMngJournal.enterPeriodName(AccountingPeriod);
			objMngJournal.clickPeriodSearchButton();
			objMngJournal.clickPeriodNameValue(AccountingPeriod);
			objMngJournal.clickPeriodOkButton();
			report.log(LogStatus.PASS, "Step 15.1.Selected given Accounting Period from the list is "+AccountingPeriod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Given Accounting Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 16. Select Source from List");
		if(Source!= "") {
			objMngJournal.selectSourceList(Source);
			report.log(LogStatus.PASS, "Step 16.1.Selected given Source from the list is: "+Source);
		}else {
			report.log(LogStatus.FAIL, "Step 16.1.Given Source from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 17. Select Category from List");
		if(Category!= "") {
			objMngJournal.selectCategoryList(Category);
			report.log(LogStatus.PASS, "Step 17.1.Selected given Category from the list is: "+Category);
		}else {
			report.log(LogStatus.FAIL, "Step 17.1.Given Category from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 18. Select Batch Status from List");
		if(BatchStatus!= "") {
			objMngJournal.selectBatchStatusList(BatchStatus);
			report.log(LogStatus.PASS, "Step 18.1.Selected given Batch Status from the list is: "+BatchStatus);
		}else {
			report.log(LogStatus.FAIL, "Step 18.1.Given Batch Status from the list is not selected");
		}
		
		
	}

}
