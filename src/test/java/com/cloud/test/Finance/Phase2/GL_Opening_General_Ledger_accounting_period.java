package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.EditAccountingPeriodStatusesPage;
import com.cloud.pageobjects.Finance.ManageAccountingPeriodsPage;
import com.cloud.pageobjects.Finance.PeriodClosePage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(TestNGListeners.class)
public class GL_Opening_General_Ledger_accounting_period extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to Manage Accounting Periods for Payables to Open the Period")
	public void Cloud_Opening_Acc_Periods(String UserName,String Password,String Ladger,String PeriodToOpen)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Manage Accounting Periods link and verify its navigated to Manage Accounting Periods page or not ");
		ManageAccountingPeriodsPage objMgmntPeriod=objPrdClose.clickManageAccountingPeriodsLink();
		if(objMgmntPeriod.isDoneButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Manage Accounting Periods page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Manage Accounting Periods page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Click on Ciber1 Primary Ledger link and verify its navigated to Edit Accounting Period Statuses page or not");
		EditAccountingPeriodStatusesPage objEditAccount =objMgmntPeriod.selectTableLadgerCell(Ladger);
		if(objEditAccount.isClosePeriodButtonDisplayed()) {
			report.log(LogStatus.PASS, "Step 8.1.Navigation to Edit Accounting Period Statuses page is success");
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Navigation to Edit Accounting Period Statuses page is failed");
		}
		
		report.log(LogStatus.INFO, "Step 8. Select period to open");
		if(PeriodToOpen != "") {
			objEditAccount.selectEditAccountingPeriodStatuses(PeriodToOpen);
			//report.log(LogStatus.PASS, "Step 8.1.Selected given Open Period from the list is: "+PeriodToOpen);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Given Open Period from the list is not selected");
		}
		
		
		report.log(LogStatus.INFO, "Step 9. Click on Open Period button");
		objEditAccount.clickOpenPeriodButton();
		
		report.log(LogStatus.INFO, "Step 10. Click on Confirmation Ok button");
		objEditAccount.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 11. Click on Done button");
		objEditAccount.clickDoneButton();
		
		report.log(LogStatus.INFO, "Step 12. Click on Done button");
		objMgmntPeriod.clickDoneButton();
	}

}
