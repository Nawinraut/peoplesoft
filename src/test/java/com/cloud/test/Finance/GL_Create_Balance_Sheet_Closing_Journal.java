package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateBalanceSheetClosingJournals_BasicOptionsPage;
import com.cloud.pageobjects.Finance.PeriodClosePage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(TestNGListeners.class)
public class GL_Create_Balance_Sheet_Closing_Journal extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Balance Sheet Closing Journals")
	public void GL_Crt_BalanceSht_Clos_Jrnl(String UserName,String Password,String AccountingPeriod,String ClosingAccount,String Category)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Balance Sheet Closing Journals link and verify its navigated to Basic Options page or not ");
		CreateBalanceSheetClosingJournals_BasicOptionsPage objBscOptions=objPrdClose.clickCreateBalanceSheetClosingJournalsLink();
		if(objBscOptions.isAccountingPeriodListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Accounting Period from List");
		if(AccountingPeriod != "") {
			objBscOptions.SelectAccountingPeriodList(AccountingPeriod);
			report.log(LogStatus.PASS, "Step 8.1.Selected given Accounting Period from the list is: "+AccountingPeriod);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Given Accounting Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click in the Closing Account Field. Enter the desired information into the Closing Account field. Enter a valid value");
		if(ClosingAccount != "") {
			objBscOptions.enterClosingAccountField(ClosingAccount);
			report.log(LogStatus.PASS, "Step 9.1.Closing Account is entered successfully: "+ClosingAccount);
		}else {
			report.log(LogStatus.FAIL, "Step 9.1.Closing Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Select Category from List");
		if(Category != "") {
			objBscOptions.SelectCategoryList(Category);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Category from the list is: "+Category);
		}else {
			report.log(LogStatus.FAIL, "Step 10.1.Given Category from the list is not selected");
		}
		objBscOptions.clickSubmissionNotesField();
		
		report.log(LogStatus.INFO, "Step 11. Click the Submit button");
		objBscOptions.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 12. Click the Confirmation Ok button");
		objBscOptions.clickConfOkButton();
	}

}
