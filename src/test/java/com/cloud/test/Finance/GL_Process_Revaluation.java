package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.ManageRevaluationsPage;
import com.cloud.pageobjects.Finance.PeriodClosePage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class GL_Process_Revaluation extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Process Revaluation")
	public void GL_Process_Revaluation(String UserName,String Password,String LedgerorLedgerSet,String Revaluation,String AccountingPeriod)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Revalue Balances link and verify its navigated to Manage Revaluations page or not ");
		ManageRevaluationsPage objMngRev=objPrdClose.clickRevalueBalancesLink();
		if(objMngRev.isGenerateButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Manage Revaluations page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Manage Revaluations page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Revaluation cell");
		//objMngRev.selectRevaluationCell("Revalue Euro");
		objMngRev.selectRevaluationCell(Revaluation);

		report.log(LogStatus.INFO, "Step 9. Click on Generate button and verify its navigated to Generate Revaluation Pop up window or not");
		objMngRev.clickGenerateButton();
		if(objMngRev.isSubmissionNotesfieldDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 9.1.Navigation to Generate Revaluation Pop up window is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Navigation to Generate Revaluation Pop up window is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 10. Select Ledger or Ledger Set from List");
		if(LedgerorLedgerSet!= "") {
			objMngRev.selectLedgerSetList(LedgerorLedgerSet);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Ledger or Ledger Set from the list is: "+LedgerorLedgerSet);
		}else {
			report.log(LogStatus.FAIL, "Step 10.1.Given Ledger or Ledger Set from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 11. Select Revaluation from List");
		if(Revaluation!= "") {
			objMngRev.selectRevaluationList(Revaluation);
			report.log(LogStatus.PASS, "Step 11.1.Selected given Revaluation from the list is: "+Revaluation);
		}else {
			report.log(LogStatus.FAIL, "Step 11.1.Given Revaluation from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Select Accounting Period from List");
		if(AccountingPeriod!= "") {
			objMngRev.selectAccountingPeriodList(AccountingPeriod);
			objMngRev.clickSubmissionNotesField();
			report.log(LogStatus.PASS, "Step 12.1.Selected given Accounting Period from the list is: "+AccountingPeriod);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Given Accounting Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click on Submit button");
		objMngRev.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 14. Click on Confirmation Ok button");
		objMngRev.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 15. Click on Close button");
		objMngRev.clickCloseButton();
		
		report.log(LogStatus.INFO, "Step 16. Click on Done button");
		objMngRev.clickDoneButton();
	}

}
