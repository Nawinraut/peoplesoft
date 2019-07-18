package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.ManageRevaluationsPage;
import com.cloud.pageobjects.Finance.PeriodClosePage;
import com.cloud.pageobjects.Finance.TranslateGeneralLedgerAccountBalances_BasicOptionsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class GL_Process_Translation extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to do Translation")
	public void Cloud_Process_Translation(String UserName,String Password,String TargetCurrency,String AccountingPeriod,String BalancingSegment)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Period Close link and verify its navigated to Period Close Page or not");
		PeriodClosePage objPrdClose=objHome.clickPeriodCloseLink();
		if(objPrdClose.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Period Close Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Period Close  Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objPrdClose.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Translate Balances link and verify its navigated to Basic Options page or not ");
		TranslateGeneralLedgerAccountBalances_BasicOptionsPage objBscOptions=objPrdClose.clickTranslateBalancesLink();
		if(objBscOptions.isAccountingPeriodListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Target Currency from List");
		if(TargetCurrency!= "") {
			objBscOptions.selectTargetCurrencyList(TargetCurrency);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Target Currency from the list is: "+TargetCurrency);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Given Target Currency from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Select Accounting Period from List");
		if(AccountingPeriod!= "") {
			objBscOptions.selectAccountingPeriodList(AccountingPeriod);
			report.log(LogStatus.PASS, "Step 9.1.Selected given Accounting Period from the list is: "+AccountingPeriod);
		}else {
			report.log(LogStatus.FAIL, "Step 9.1.Given Accounting Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Select Balancing Segment from List");
		if(BalancingSegment!= "") {
			objBscOptions.clickBalancingSegmentSearchIcon(BalancingSegment);
			objBscOptions.selectEvent(BalancingSegment);
			objBscOptions.clickSubmissionNotesField();
			report.log(LogStatus.PASS, "Step 10.1.Selected given Balancing Segment from the list is: "+BalancingSegment);
		}else {
			report.log(LogStatus.FAIL, "Step 10.1.Given Balancing Segment from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click on Submit button");
		objBscOptions.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 12. Click on Confirmation Ok button");
		objBscOptions.clickConfOkButton();
	}

}
