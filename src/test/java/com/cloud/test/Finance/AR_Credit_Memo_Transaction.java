package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.BillingPage;
import com.cloud.pageobjects.Finance.CreateTransactionPage;
import com.cloud.pageobjects.Finance.ReviewTransactionPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Credit_Memo_Transaction extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create a Credit Memo Transaction")
	public void AR_Credit_Memo_Transaction(String UserName,String Password,String TransactionClass,String BusinessUnit,String TransactionSource,String BilltoName,String Description,String UOM,String Quantity,String UnitPrice)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Transactions link and verify its navigated to Create Transactions page or not");
		CreateTransactionPage objCrtTransection=objBilling.clickCreateTransactionLink();
			if(objCrtTransection.isSelectBusinessUnitDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Transactions Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Transactions Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Transaction Class from list");
			if(TransactionClass != "")
			{
				objCrtTransection.SelectTransactionClass(TransactionClass);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Transaction Class from the list is "+TransactionClass);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Transaction Class from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objCrtTransection.SelectBusinessUnit(BusinessUnit);
				//report.log(LogStatus.PASS, "Step 9.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.1.Given Business Unit from the list is not selected");
			}
			
			
			/*report.log(LogStatus.INFO, "Step 10. Select Transaction Source from list");
			if(TransactionSource != "")
			{
				objCrtTransection.SelectTransactionSource(TransactionSource);
				report.log(LogStatus.PASS, "Step 10.1.Selected given Transaction Source from the list is "+TransactionSource);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 10.1.Given Transaction Source from the list is not selected");
			}*/
			
			
			report.log(LogStatus.INFO, "Step 10. Click on Transaction Source Search Icon");
			objCrtTransection.clickSearchTransactionSourceIcon();
			
			report.log(LogStatus.INFO, "Step 10.1. Click on Transaction Source Search Link");
			objCrtTransection.clickSearchTransactionSourceLink();
			
			report.log(LogStatus.INFO, "Step 10.2. Enter Transaction Source Name");
			objCrtTransection.enterSupplier(TransactionSource);
			objCrtTransection.clickSupplierNumber();
		
			report.log(LogStatus.INFO, "Step 10.3. Click on Transaction Source Search Button");
			objCrtTransection.clickSupplierSearchButton();
			
			report.log(LogStatus.INFO, "Step 10.4. Select Transaction Source Cell");
			objCrtTransection.selectEvent(TransactionSource);
			
			report.log(LogStatus.INFO, "Step 10.5. Click on Transaction Source Ok Button");
			objCrtTransection.clickSupplierOkButton();
			
			report.log(LogStatus.INFO, "Step 11. Click on Bill-to Name Search Icon");
			objCrtTransection.clickSearchSupplierIcon();
			
			report.log(LogStatus.INFO, "Step 11.1. Enter Bill-to Name");
			
			objCrtTransection.enterSupplier(BilltoName);
			objCrtTransection.clickSupplierNumber();
		
			report.log(LogStatus.INFO, "Step 11.2. Click on Bill-to Name Search Button");
			objCrtTransection.clickSupplierSearchButton();
			
			report.log(LogStatus.INFO, "Step 11.3. Select Bill-to Name Cell");
			objCrtTransection.selectEvent(BilltoName);
			
			report.log(LogStatus.INFO, "Step 11.4. Click on Bill-to Name Ok Button");
			objCrtTransection.clickSupplierOkButton();
			
			report.log(LogStatus.INFO, "Step 12. Click in the Description field. Enter the desired information into the Description field. Enter a valid value");
			if(Description!= "") {
				objCrtTransection.enterDescription(Description);
				report.log(LogStatus.PASS, "Step 12.1.Description is entered successfully: "+Description);
			}else {
				report.log(LogStatus.FAIL, "Step 12.1.Description is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 13. Select UOM from list");
			if(UOM != "")
			{
				objCrtTransection.SelectUOMCell(UOM);
				report.log(LogStatus.PASS, "Step 13.1.Selected given UOM from the list is "+UOM);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 13.1.Given UOM from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 14. Click in the Quantity field. Enter the desired information into the Quantity field. Enter a valid value");
			if(Quantity!= "") {
				objCrtTransection.enterQuantity(Quantity);
				report.log(LogStatus.PASS, "Step 14.1.Quantity is entered successfully: "+Quantity);
			}else {
				report.log(LogStatus.FAIL, "Step 14.1.Quantity is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 15. Click in the Unit Price field. Enter the desired information into the Unit Price field. Enter a valid value");
			if(UnitPrice!= "") {
				objCrtTransection.enterUnitPrice(UnitPrice);
				report.log(LogStatus.PASS, "Step 15.1.Unit Price is entered successfully: "+UnitPrice);
			}else {
				report.log(LogStatus.FAIL, "Step 15.1.Unit Price is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 16. Click on Complete and Create Another Menu");
			objCrtTransection.clickCompleteandCreateAnotherMenu();
			
			report.log(LogStatus.INFO, "Step 17. Click on Complete and Review List and verify its navigated to Review Transactions page or not");
			ReviewTransactionPage objRvwTransection=objCrtTransection.clickCompleteandReviewList();
			if(objRvwTransection.isActionsMenuDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 17.1.Navigation to Review Transactions Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 17.1.Navigation to Review Transactions Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 18. Click on Actions Menu");
			objRvwTransection.clickActionsMenu();
			
			report.log(LogStatus.INFO, "Step 19. Click on Post to Ledger List");
			objRvwTransection.clickPostToLedgerList();
			
			report.log(LogStatus.INFO, "Step 20. Click on Confirmation Ok button");
			objRvwTransection.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 21. Click on Save Menu");
			objRvwTransection.clickSaveMenu();
			
			report.log(LogStatus.INFO, "Step 22. Click on Save and Close List");
			objRvwTransection.clickSaveAndCloseList();
	}

}
