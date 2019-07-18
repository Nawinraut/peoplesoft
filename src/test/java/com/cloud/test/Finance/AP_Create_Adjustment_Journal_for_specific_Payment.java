package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateSubledgerJournalEntryPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.SubledgerJournalEntryPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Create_Adjustment_Journal_for_specific_Payment extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Adjustment Journal for Specific Payment")
	public void AP_Adj_Journal_Spec_Payment(String UserName,String Password,String Ledger,String JournalCategory,String Description,String CompletionStatus,String LegalEntity,String AccountingValue1,String AccountingValue2,String AccountingClass1,String AccountingClass2,String Debit,String Credit)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Payments link and verify its navigated to Overview Page or not");
		OverviewPage objOverview=objHome.clickPayments();
		if(objOverview.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Overview Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Overview Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Adjustment Journal link and verify its navigated to Create Subledger Journal Entry page or not");
		CreateSubledgerJournalEntryPage objCreateSubledger=objOverview.clickCreateAdjustmentJournalLink();
			if(objCreateSubledger.isSelectLedgerDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Subledger Journal Entry Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Subledger Journal Entry Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Ledger from list");
			if(Ledger != "")
			{
				objCreateSubledger.SelectLedger(Ledger);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Ledger from the list is "+Ledger);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Ledger from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click on Category Search Icon");
			objCreateSubledger.clickCategorySearchIcon();
			report.log(LogStatus.INFO, "Step 9.1. Click on Category Search link");
			objCreateSubledger.clickCategorySearchLink();
			report.log(LogStatus.INFO, "Step 9.2. Click in the Journal Category field. Enter the desired information into the Journal Category field. Enter a valid value");
			if(JournalCategory != "")
			{
				objCreateSubledger.enterJournalCategory(JournalCategory);
				report.log(LogStatus.PASS, "Step 9.2.1. Journal Category is entered successfully: "+JournalCategory);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.2.1. Journal Category is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 9.3. Click on Journal Category Search button");
			objCreateSubledger.clickJournalCategorySearchButton();
			
			report.log(LogStatus.INFO, "Step 9.4. Select Journal Category from list");
			objCreateSubledger.selectJournalCategory(JournalCategory);
			
			report.log(LogStatus.INFO, "Step 9.5. Click on Journal Category Ok button");
			objCreateSubledger.clickJournalCategoryOkButton();
			
			report.log(LogStatus.INFO, "Step 10. Click in the Description field. Enter the desired information into the Description field. Enter a valid value");
			if(Description != "")
			{
				objCreateSubledger.enterDescription(Description);
				report.log(LogStatus.PASS, "Step 10.1.Description is entered successfully: "+Description);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 10.1.Description is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 11. Select Completion Status from list");
			if(CompletionStatus != "")
			{
				objCreateSubledger.selectCompletionStatus(CompletionStatus);
				report.log(LogStatus.PASS, "Step 11.1.Selected given Completion Status from the list is "+CompletionStatus);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Given Completion Status from the list is not selected");
			}
		
			report.log(LogStatus.INFO, "Step 12. Select Legal Entity from list");
			if(LegalEntity != "")
			{
				objCreateSubledger.SelectLegalEntity(LegalEntity);
				report.log(LogStatus.PASS, "Step 12.1.Selected given Legal Entity from the list is "+LegalEntity);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 12.1.Given Legal Entity from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 13. Click on Add Row button");
			objCreateSubledger.clickAddRowButton();
			
			int LineNumber = 1;
			report.log(LogStatus.INFO, "Step 14. Click in the Accounting Value field. Enter the desired information into the Accounting Value field. Enter a valid value");
			if(AccountingValue1!= "") {
				
				objCreateSubledger.enterAccountValue(LineNumber,AccountingValue1);
				report.log(LogStatus.PASS, "Step 14.1.Accounting Value is entered successfully: "+AccountingValue1);
			}else {
				report.log(LogStatus.FAIL, "Step 14.1.Accounting Value is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 15. Select Accounting Class from list");
			if(AccountingClass1 != "")
			{
				objCreateSubledger.SelectAccountingClass1(AccountingClass1);
				report.log(LogStatus.PASS, "Step 15.1.Selected given Accounting Class from the list is "+AccountingClass1);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 15.1.Given Accounting Class from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 16. Click in the Debit field. Enter the desired information into the Debit field. Enter a valid value");
			if(Debit != "")
			{
				objCreateSubledger.enterDebit(Debit);
				objCreateSubledger.clickCredit();
				report.log(LogStatus.PASS, "Step 16.1.Debit is entered successfully: "+Debit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 16.1.Debit is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 17. Click on Add Row button");
			objCreateSubledger.clickAddRowButton();
			
			LineNumber = 2;
			report.log(LogStatus.INFO, "Step 18. Click in the Accounting Value field. Enter the desired information into the Accounting Value field. Enter a valid value");
			if(AccountingValue2!= "") {
				
				objCreateSubledger.enterAccountValue(LineNumber,AccountingValue2);
				report.log(LogStatus.PASS, "Step 18.1.Accounting Value is entered successfully: "+AccountingValue2);
			}else {
				report.log(LogStatus.FAIL, "Step 18.1.Accounting Value is not entered");
			}
			

			report.log(LogStatus.INFO, "Step 19. Click on Accounting Class Search Icon");
			objCreateSubledger.clickAccountingClassList2SearchIcon();
			report.log(LogStatus.INFO, "Step 19.1. Click on Accounting Class Search link");
			objCreateSubledger.clickAccountingClassList2SearchLink();
			report.log(LogStatus.INFO, "Step 19.2. Click in the Accounting Class field. Enter the desired information into the Accounting Class field. Enter a valid value");
			if(JournalCategory != "")
			{
				objCreateSubledger.enterAccountingClass(AccountingClass2);
				report.log(LogStatus.PASS, "Step 19.2.1. Accounting Class is entered successfully: "+AccountingClass2);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 19.2.1. Accounting Class is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 19.3. Click on Accounting Class Search button");
			objCreateSubledger.clickAccountingClassSearchButton();
			
			report.log(LogStatus.INFO, "Step 19.4. Select Accounting Class from list");
			objCreateSubledger.selectAccountingClass(AccountingClass2);
			
			report.log(LogStatus.INFO, "Step 19.5. Click on Accounting Class Ok button");
			objCreateSubledger.clickAccountingClassOkButton();
			
			
			report.log(LogStatus.INFO, "Step 20. Click in the Credit field. Enter the desired information into the Credit field. Enter a valid value");
			if(Debit != "")
			{
				objCreateSubledger.enterCredit(Credit);
				objCreateSubledger.clickDebit();
				report.log(LogStatus.PASS, "Step 20.1. Credit is entered successfully: "+Credit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 20.1. Credit is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 21. Click on Save button and verify its navigated to Subledger Journal Entry page or not");
			SubledgerJournalEntryPage objSubledger=objCreateSubledger.clickSave();
			if(objSubledger.isPostButtonDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 21.1.Navigation to Subledger Journal Entry Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 21.1.Navigation to Subledger Journal Entry Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 22. Click on Post button");
			objSubledger.clickPostButton();
			
			report.log(LogStatus.INFO, "Step 23. Click on Warning Ok button");
			objSubledger.clickWarningOkButton();
			
			report.log(LogStatus.INFO, "Step 24. Click on Confirmation Ok button");
			objSubledger.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 25. Click on Save Menu");
			objSubledger.clicSaveMenu();
			
			report.log(LogStatus.INFO, "Step 26. Click on Save and close list");
			objSubledger.clicSaveAndCloseList();
			
	}

}
