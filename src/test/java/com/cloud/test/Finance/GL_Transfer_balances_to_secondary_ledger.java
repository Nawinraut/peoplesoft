package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.PeriodClosePage;
import com.cloud.pageobjects.Finance.TransferBalancestoSecondaryLedger_BasicOptionsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(TestNGListeners.class)
public class GL_Transfer_balances_to_secondary_ledger extends BaseWebTest{

	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Transfer balances to secondary ledger")
	public void GL_Transfer_bal_Sec_Ledger(String UserName,String Password,String PrimaryLedger,String SecondaryLedger,String AmountType,String PrimaryLedgerPeriod,String SecondaryLedgerPeriod)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Transfer Balances to Secondary Ledgers link and verify its navigated to Basic Options page or not ");
		TransferBalancestoSecondaryLedger_BasicOptionsPage objBscOptions=objPrdClose.clickTransferBalancestoSecondaryLedgersLink();
		if(objBscOptions.isPrimaryLedgerListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Primary Ledger from List");
		if(PrimaryLedger!= "") {
			objBscOptions.SelectPrimaryLedgerList(PrimaryLedger);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Primary Ledger from the list is: "+PrimaryLedger);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Given Primary Ledger from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Select Secondary Ledger from List");
		if(SecondaryLedger!= "") {
			objBscOptions.SelectSecondaryLedgerList(SecondaryLedger);
			report.log(LogStatus.PASS, "Step 9.1.Selected given Secondary Ledger from the list is: "+SecondaryLedger);
		}else {
			report.log(LogStatus.FAIL, "Step 9.1.Given Secondary Ledger from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 10. Select Amount Type from List");
		if(AmountType!= "") {
			objBscOptions.SelectAmountTypeList(AmountType);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Amount Type from the list is: "+SecondaryLedger);
		}else {
			report.log(LogStatus.FAIL, "Step 10.1.Given Amount Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 11. Select Primary Ledger Period from List");
		if(PrimaryLedgerPeriod != "") {
			objBscOptions.SelectPrimaryLedgerPeriodList(PrimaryLedgerPeriod);
			report.log(LogStatus.PASS, "Step 11.1.Selected given Primary Ledger Period from the list is: "+PrimaryLedgerPeriod);
		}else {
			report.log(LogStatus.FAIL, "Step 11.1.Given Primary Ledger Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 12. Select Secondary Ledger Period from List");
		if(SecondaryLedgerPeriod != "") {
			objBscOptions.SelectSecondaryLedgerPeriodList(SecondaryLedgerPeriod);
			report.log(LogStatus.PASS, "Step 12.1.Selected given Secondary Ledger Period from the list is: "+SecondaryLedgerPeriod);
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Given Secondary Ledger Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 13. Select the Run Journal Import option");
		objBscOptions.SelectRunJournalImportCheckBox();
		
		report.log(LogStatus.INFO, "Step 14. Select the Create Summary Journals option");
		objBscOptions.SelectCreateSummaryJournalsCheckBox();
		
		report.log(LogStatus.INFO, "Step 15. Select the Run Automatic Posting  option");
		objBscOptions.SelectRunAutomaticPostingCheckBox();
		objBscOptions.clickSubmissionNotesField();
		
		report.log(LogStatus.INFO, "Step 16. Click the Submit button");
		objBscOptions.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 17. Click the Confirmation Ok button");
		objBscOptions.clickConfOkButton();
		
	}
}
