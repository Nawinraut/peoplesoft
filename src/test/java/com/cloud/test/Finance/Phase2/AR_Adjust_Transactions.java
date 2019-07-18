package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.BillingPage;
import com.cloud.pageobjects.Finance.ManageAdjustmentsPage;
import com.cloud.pageobjects.Finance.ManageTransactionsPage;
import com.cloud.pageobjects.Finance.ReviewTransactionPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Adjust_Transactions extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Adjust Transaction")
	public void Cloud_Adjust_Transactions(String UserName,String Password,String BusinessUnit,String TransactionNumber,String ReceivablesActivity,String AdjustmentType,String AdjustmentReason)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Billing link and verify its navigated to Billing Page or not");
		BillingPage objBilling=objHome.clickBilling();
		if(objBilling.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Billing Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Billing Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objBilling.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Manage Transactions link and verify its navigated to Manage Transactions page or not");
		ManageTransactionsPage objMngTransection=objBilling.clickManageTransactionsLink();
			if(objMngTransection.isSelectBusinessUnitDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Manage Transactions Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Manage Transactions Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objMngTransection.SelectBusinessUnit(BusinessUnit);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Business Unit from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click in the Transaction Number Value field. Enter the desired information into the Transaction Number field. Enter a valid value");
			if(TransactionNumber!= "") {
				
				objMngTransection.enterTransactionNumber(TransactionNumber);
				report.log(LogStatus.PASS, "Step 9.1.Transaction Number Value is entered successfully: "+TransactionNumber);
			}else {
				report.log(LogStatus.FAIL, "Step 9.1.Transaction Number Value is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 10. Click on Search button");
			objMngTransection.clickTransactionSearchButton();
			
			report.log(LogStatus.INFO, "Step 11. Select the Transection Number Cell and Verify its navigated to Review Transaction page or not");
			ReviewTransactionPage objRvwTransection=objMngTransection.selectTransactionCell(TransactionNumber);
			if(objRvwTransection.isActionsMenuDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 11.1.Navigation to Review Transaction Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Navigation to Review Transaction Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 12. Click on Actions Menu");
			objRvwTransection.clickActionsMenu();
			
			report.log(LogStatus.INFO, "Step 13. Click on Manage Adjustments list item and Verify its navigated to Manage Adjustments page or not");
			ManageAdjustmentsPage objMngAdj=objRvwTransection.clickManageAdjustmentsList();
			if(objMngAdj.isCreateBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 13.1.Navigation to Manage Adjustments Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 13.1.Navigation to Manage Adjustments Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 14. Click on Create button and Verify its navigated to Create Adjustments Pop-up window or not");
			objMngAdj.clickCreateButton();
			if(objMngAdj.isReceivablesActivityDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 14.1.Navigation to Create Adjustments Pop-up window is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 14.1.Navigation to Create Adjustments Pop-up window is failed");	
			}
			
			
			report.log(LogStatus.INFO, "Step 15. Select Receivables Activity from list");
			if(ReceivablesActivity  != "")
			{
				objMngAdj.SelectReceivablesActivity(ReceivablesActivity);
				report.log(LogStatus.PASS, "Step 15.1.Selected given Receivables Activity from the list is "+ReceivablesActivity);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 15.1.Given Receivables Activity from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 16. Select Adjustment Type from list");
			if(AdjustmentType != "")
			{
				objMngAdj.SelectAdjustmentType(AdjustmentType);
				report.log(LogStatus.PASS, "Step 16.1.Selected given Adjustment Type from the list is "+AdjustmentType);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 16.1.Given Adjustment Type from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 17. Select Adjustment Reason from list");
			if(AdjustmentReason != "")
			{
				objMngAdj.SelectAdjustmentReason(AdjustmentReason);
				report.log(LogStatus.PASS, "Step 17.1.Selected given Adjustment Reason from the list is "+AdjustmentReason);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 17.1.Given Adjustment Reason from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 18. Click on Submit button");
			objMngAdj.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 19. Click on Information Ok button");
			objMngAdj.clickInfOkButton();
			
			report.log(LogStatus.INFO, "Step 20. Click on Done button and Verify its navigated to Review Transaction page or not");
			objMngAdj.clickDoneButton();
			if(objRvwTransection.isSaveMenuDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 20.1.Navigation to Review Transaction Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 20.1.Navigation to Review Transaction Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 21. Click on Save menu");
			objRvwTransection.clickSaveMenu();
			
			report.log(LogStatus.INFO, "Step 22. Click on Save And Close List");
			objRvwTransection.clickSaveAndCloseList();
			
			report.log(LogStatus.INFO, "Step 23. Click on Information Ok button");
			objRvwTransection.clickInfOkButton();
			
			report.log(LogStatus.INFO, "Step 24. Click on Done button");
			objMngTransection.clickDoneButton();
			
	}

}
