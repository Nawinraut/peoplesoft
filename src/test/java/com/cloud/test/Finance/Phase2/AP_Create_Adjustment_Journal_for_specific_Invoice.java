package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateSubledgerJournalEntryPage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.SubledgerJournalEntryPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Create_Adjustment_Journal_for_specific_Invoice extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Adjustment Journal for Invoice")
	public void Cloud_Adj_Journal_Spec_Invoice(String UserName,String Password,String Ledger,String AccountingDate,String JournalCategory,String Description,String CompletionStatus,String LegalEntity,String AccountingValue1,String AccountingValue2,String Company,String Region,String Country,String Service,String Location,String Department,String NaturalAccount1,String NaturalAccount2,String Intercompany,String FundSource,String Future1,String AccountingClass1,String AccountingClass2,String Debit,String Credit)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Invoices link and verify its navigated to Invoices Page or not");
		InvoicesPage objInvoices=objHome.clickInvoices();
		if(objInvoices.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Invoices Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Invoices Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objInvoices.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Adjustment Journal link and verify its navigated to Create Subledger Journal Entry page or not");
		CreateSubledgerJournalEntryPage objCreateSubledger=objInvoices.clickCreateAdjustmentJournalLink();
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
				//report.log(LogStatus.PASS, "Step 8.1.Selected given Ledger from the list is "+Ledger);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Ledger from the list is not selected");
			}
			
			
			String fromDateParts[] = AccountingDate.split("-");
			String fromMonth  = fromDateParts[0];
			String fromDay  = fromDateParts[1];
			String fromYear = fromDateParts[2];
			report.log(LogStatus.INFO, "Step 9. Click on Accounting Date button");
			//objSubRequest.isFromInvoiceDtBtnDisplayed();
			objCreateSubledger.clickAccountingDateButton();
			report.log(LogStatus.INFO, "Step 9.1. Select Accounting Date Month");
			//objSubRequest.isFromInvoiceMonthDisplayed();
			objCreateSubledger.selectAccountingDateMonth(fromMonth);
			report.log(LogStatus.INFO, "Step 9.2. Select Accounting Date");
			objCreateSubledger.selectAccountingDate(fromDay);
			
			report.log(LogStatus.INFO, "Step 10. Click on Category Search Icon");
			objCreateSubledger.clickCategorySearchIcon();
			report.log(LogStatus.INFO, "Step 10.1. Click on Category Search link");
			objCreateSubledger.clickCategorySearchLink();
			report.log(LogStatus.INFO, "Step 10.2. Click in the Journal Category field. Enter the desired information into the Journal Category field. Enter a valid value");
			if(JournalCategory != "")
			{
				objCreateSubledger.enterJournalCategory(JournalCategory);
				report.log(LogStatus.PASS, "Step 10.2.1. Journal Category is entered successfully: "+JournalCategory);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 10.2.1. Journal Category is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 10.3. Click on Journal Category Search button");
			objCreateSubledger.clickJournalCategorySearchButton();
			
			report.log(LogStatus.INFO, "Step 10.4. Select Journal Category from list");
			objCreateSubledger.selectJournalCategory(JournalCategory);
			
			report.log(LogStatus.INFO, "Step 10.5. Click on Journal Category Ok button");
			objCreateSubledger.clickJournalCategoryOkButton();
			
			report.log(LogStatus.INFO, "Step 11. Click in the Description field. Enter the desired information into the Description field. Enter a valid value");
			if(Description != "")
			{
				objCreateSubledger.enterDescription(Description);
				report.log(LogStatus.PASS, "Step 11.1.Description is entered successfully: "+Description);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Description is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 12. Select Completion Status from list");
			if(CompletionStatus != "")
			{
				objCreateSubledger.selectCompletionStatus(CompletionStatus);
				report.log(LogStatus.PASS, "Step 12.1.Selected given Completion Status from the list is "+CompletionStatus);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 12.1.Given Completion Status from the list is not selected");
			}
		
			report.log(LogStatus.INFO, "Step 13. Select Legal Entity from list");
			if(LegalEntity != "")
			{
				objCreateSubledger.SelectLegalEntity(LegalEntity);
				report.log(LogStatus.PASS, "Step 13.1.Selected given Legal Entity from the list is "+LegalEntity);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 13.1.Given Legal Entity from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 14. Click on Add Row button");
			objCreateSubledger.clickAddRowButton();
			
			int LineNumber = 1;
			report.log(LogStatus.INFO, "Step 15.1. Click in the Accounting Value field. Enter the desired information into the Accounting Value field. Enter a valid value");
			if(AccountingValue1!= "") {
				
				objCreateSubledger.enterAccountValue(LineNumber,AccountingValue1);
				report.log(LogStatus.PASS, "Step 15.1.Accounting Value is entered successfully: "+AccountingValue1);
			}else {
				report.log(LogStatus.FAIL, "Step 15.1.Accounting Value is not entered");
			}
			
			///////////////////////////////////////////
			
			/*report.log(LogStatus.INFO, "Step 15. Click on Accounts button");
			objCreateSubledger.clickAccount1Button();
			
			report.log(LogStatus.INFO, "Step 15. Click on Company Search Icon");
			objCreateSubledger.isCompanySearchIconDisplayed();
			objCreateSubledger.clickCompanySearchIcon();
			objCreateSubledger.verifySearchEvent(Company);
			report.log(LogStatus.INFO, "Step 16. Select Company from dropdown");
			objCreateSubledger.selectEvent(Company);
			//objCrtInvoice.verifyEvent(Company);
			
			report.log(LogStatus.INFO, "Step 17. Click on  Region Search Icon");
			objCreateSubledger.isRegionSearchIconDisplayed();
			objCreateSubledger.clickRegionSearchIcon();
			objCreateSubledger.verifySearchEvent(Region);
			report.log(LogStatus.INFO, "Step 18. Select Region from dropdown");
			objCreateSubledger.selectEvent(Region);
			//objCrtInvoice.verifyEvent(Region);
			
			report.log(LogStatus.INFO, "Step 19. Click on Country Search Icon");
			objCreateSubledger.isCountrySearchIconDisplayed();
			objCreateSubledger.clickCountrySearchIcon();
			objCreateSubledger.verifySearchEvent(Country);
			report.log(LogStatus.INFO, "Step 20. Select Country from dropdown");
			objCreateSubledger.selectEvent(Country);
			//objCrtInvoice.verifyEvent(Country);
			
			report.log(LogStatus.INFO, "Step 21. Click on Service Search Icon");
			objCreateSubledger.isServiceSearchIconDisplayed();
			objCreateSubledger.clickServiceSearchIcon();
			objCreateSubledger.verifySearchEvent(Service);
			report.log(LogStatus.INFO, "Step 22. Select Service from dropdown");
			objCreateSubledger.selectEvent(Service);
			//objCrtInvoice.verifyEvent(Service);
			
			report.log(LogStatus.INFO, "Step 23. Click on Location Search Icon");
			objCreateSubledger.isLocationSearchIconDisplayed();
			objCreateSubledger.clickLocationSearchIcon();
			objCreateSubledger.verifySearchEvent(Location);
			report.log(LogStatus.INFO, "Step 24. Select Location from dropdown");
			//SeleniumUtils.delay(5000);
			objCreateSubledger.selectEvent(Location);
			SeleniumUtils.delay(3000);
			//objCrtInvoice.verifyEvent(Location);
			
			report.log(LogStatus.INFO, "Step 25. Click on Department Search Icon");
			objCreateSubledger.isDepartmentSearchIconDisplayed();
			objCreateSubledger.clickDepartmentSearchIcon();
			objCreateSubledger.verifySearchEvent(Department);
			report.log(LogStatus.INFO, "Step 26. Select Department from dropdown");
			objCreateSubledger.selectEvent(Department);
			//objCrtInvoice.verifyEvent(Department);
			SeleniumUtils.delay(3000);
			
			report.log(LogStatus.INFO, "Step 27. Click on Natural Account Search Icon");
			objCreateSubledger.clickNaturalAccountSearchIcon();
			report.log(LogStatus.INFO, "Step 27.1. Verify that Natural Account Search link");
			objCreateSubledger.isAccountSearchLinkDisplayed();
			report.log(LogStatus.INFO, "Step 27.2. Click on Natural Account Search link");
			objCreateSubledger.clickAccountSearchLink();
			report.log(LogStatus.INFO, "Step 27.3. Enter the Natural Account Value in Value text field");
			objCreateSubledger.enterAccountValue(NaturalAccount1);
			report.log(LogStatus.INFO, "Step 27.4. Click on Natural Account Search button");
			objCreateSubledger.clickAccountSearchButton();
			report.log(LogStatus.INFO, "Step 27.5. Select Department from dropdown");
			objCreateSubledger.selectEvent(NaturalAccount1);
			report.log(LogStatus.INFO, "Step 27.6. Click on Natural Account Ok button");
			objCreateSubledger.isAccountOkButtonDisplayed();
			objCreateSubledger.clickAccountOkButton();
			
			report.log(LogStatus.INFO, "Step 28. Click on Intercompany Search Icon");
			objCreateSubledger.isIntercompanySearchIconDisplayed();
			objCreateSubledger.clickIntercompanySearchIcon();
			report.log(LogStatus.INFO, "Step 29. Select Intercompany from dropdown");
			objCreateSubledger.selectEvent(Intercompany);
			SeleniumUtils.delay(5000);
			//objCrtInvoice.verifyEvent(Intercompany);

			report.log(LogStatus.INFO, "Step 30. Click on FundSource Search Icon");
			objCreateSubledger.isFundSourceSearchIconDisplayed();
			objCreateSubledger.clickFundSourceSearchIcon();
			report.log(LogStatus.INFO, "Step 31. Select FundSource from dropdown");
			objCreateSubledger.selectEvent(FundSource);
			//objCrtInvoice.verifyEvent(FundSource);
			
			report.log(LogStatus.INFO, "Step 32. Click on Future1 Search Icon");
			objCreateSubledger.isFuture1SearchIconDisplayed();
			objCreateSubledger.clickFuture1SearchIcon();
			report.log(LogStatus.INFO, "Step 33. Select Future1 from dropdown");
			objCreateSubledger.selectEvent(Future1);
			//objCrtInvoice.verifyEvent(Future1);
			
			report.log(LogStatus.INFO, "Step 34. Click on Pop up Ok button");
			objCreateSubledger.clickAccountPopUp1_OkButton();*/
			
			
			////////////////////////////////////////////
			
			report.log(LogStatus.INFO, "Step 16. Select Accounting Class from list");
			if(AccountingClass1 != "")
			{
				objCreateSubledger.SelectAccountingClass1(AccountingClass1);
				report.log(LogStatus.PASS, "Step 16.1.Selected given Accounting Class from the list is "+AccountingClass1);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 16.1.Given Accounting Class from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 17. Click in the Debit field. Enter the desired information into the Debit field. Enter a valid value");
			if(Debit != "")
			{
				objCreateSubledger.enterDebit(Debit);
				objCreateSubledger.clickCredit();
				report.log(LogStatus.PASS, "Step 17.1.Debit is entered successfully: "+Debit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 17.1.Debit is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 18. Click on Add Row button");
			objCreateSubledger.clickAddRowButton();
			
			LineNumber = 2;
			report.log(LogStatus.INFO, "Step 19. Click in the Accounting Value field. Enter the desired information into the Accounting Value field. Enter a valid value");
			if(AccountingValue2!= "") {
				
				objCreateSubledger.enterAccountValue(LineNumber,AccountingValue2);
				report.log(LogStatus.PASS, "Step 19.1.Accounting Value is entered successfully: "+AccountingValue2);
			}else {
				report.log(LogStatus.FAIL, "Step 19.1.Accounting Value is not entered");
			}
			/////////////////////////
			
			/*report.log(LogStatus.INFO, "Step 38. Click on Accounts button");
			objCreateSubledger.clickAccount2Button();
			
			report.log(LogStatus.INFO, "Step 39. Click on Company Search Icon");
			objCreateSubledger.isCompanySearchIconDisplayed();
			objCreateSubledger.clickCompanySearchIcon();
			objCreateSubledger.verifySearchEvent(Company);
			report.log(LogStatus.INFO, "Step 40. Select Company from dropdown");
			objCreateSubledger.selectEvent(Company);
			//objCrtInvoice.verifyEvent(Company);
			
			report.log(LogStatus.INFO, "Step 41. Click on  Region Search Icon");
			objCreateSubledger.isRegionSearchIconDisplayed();
			objCreateSubledger.clickRegionSearchIcon();
			objCreateSubledger.verifySearchEvent(Region);
			report.log(LogStatus.INFO, "Step 42. Select Region from dropdown");
			objCreateSubledger.selectEvent(Region);
			//objCrtInvoice.verifyEvent(Region);
			
			report.log(LogStatus.INFO, "Step 43. Click on Country Search Icon");
			objCreateSubledger.isCountrySearchIconDisplayed();
			objCreateSubledger.clickCountrySearchIcon();
			objCreateSubledger.verifySearchEvent(Country);
			report.log(LogStatus.INFO, "Step 44. Select Country from dropdown");
			objCreateSubledger.selectEvent(Country);
			//objCrtInvoice.verifyEvent(Country);
			
			report.log(LogStatus.INFO, "Step 46. Click on Service Search Icon");
			objCreateSubledger.isServiceSearchIconDisplayed();
			objCreateSubledger.clickServiceSearchIcon();
			objCreateSubledger.verifySearchEvent(Service);
			report.log(LogStatus.INFO, "Step 47. Select Service from dropdown");
			objCreateSubledger.selectEvent(Service);
			//objCrtInvoice.verifyEvent(Service);
			
			report.log(LogStatus.INFO, "Step 48. Click on Location Search Icon");
			objCreateSubledger.isLocationSearchIconDisplayed();
			objCreateSubledger.clickLocationSearchIcon();
			objCreateSubledger.verifySearchEvent(Location);
			report.log(LogStatus.INFO, "Step 49. Select Location from dropdown");
			//SeleniumUtils.delay(5000);
			objCreateSubledger.selectEvent(Location);
			SeleniumUtils.delay(3000);
			//objCrtInvoice.verifyEvent(Location);
			
			report.log(LogStatus.INFO, "Step 50. Click on Department Search Icon");
			objCreateSubledger.isDepartmentSearchIconDisplayed();
			objCreateSubledger.clickDepartmentSearchIcon();
			objCreateSubledger.verifySearchEvent(Department);
			report.log(LogStatus.INFO, "Step 51. Select Department from dropdown");
			objCreateSubledger.selectEvent(Department);
			//objCrtInvoice.verifyEvent(Department);
			SeleniumUtils.delay(3000);
			
			report.log(LogStatus.INFO, "Step 52. Click on Natural Account Search Icon");
			objCreateSubledger.clickNaturalAccountSearchIcon();
			report.log(LogStatus.INFO, "Step 52.1. Verify that Natural Account Search link");
			objCreateSubledger.isAccountSearchLinkDisplayed();
			report.log(LogStatus.INFO, "Step 52.2. Click on Natural Account Search link");
			objCreateSubledger.clickAccountSearchLink();
			report.log(LogStatus.INFO, "Step 52.3. Enter the Natural Account Value in Value text field");
			objCreateSubledger.enterAccountValue(NaturalAccount2);
			report.log(LogStatus.INFO, "Step 52.4. Click on Natural Account Search button");
			objCreateSubledger.clickAccountSearchButton();
			report.log(LogStatus.INFO, "Step 52.5. Select Department from dropdown");
			objCreateSubledger.selectEvent(NaturalAccount2);
			report.log(LogStatus.INFO, "Step 52.6. Click on Natural Account Ok button");
			objCreateSubledger.isAccountOkButtonDisplayed();
			objCreateSubledger.clickAccountOkButton();
			
			report.log(LogStatus.INFO, "Step 53. Click on Intercompany Search Icon");
			objCreateSubledger.isIntercompanySearchIconDisplayed();
			objCreateSubledger.clickIntercompanySearchIcon();
			report.log(LogStatus.INFO, "Step 54. Select Intercompany from dropdown");
			objCreateSubledger.selectEvent(Intercompany);
			SeleniumUtils.delay(5000);
			//objCrtInvoice.verifyEvent(Intercompany);

			report.log(LogStatus.INFO, "Step 55. Click on FundSource Search Icon");
			objCreateSubledger.isFundSourceSearchIconDisplayed();
			objCreateSubledger.clickFundSourceSearchIcon();
			report.log(LogStatus.INFO, "Step 56. Select FundSource from dropdown");
			objCreateSubledger.selectEvent(FundSource);
			//objCrtInvoice.verifyEvent(FundSource);
			
			report.log(LogStatus.INFO, "Step 57. Click on Future1 Search Icon");
			objCreateSubledger.isFuture1SearchIconDisplayed();
			objCreateSubledger.clickFuture1SearchIcon();
			report.log(LogStatus.INFO, "Step 58. Select Future1 from dropdown");
			objCreateSubledger.selectEvent(Future1);
			//objCrtInvoice.verifyEvent(Future1);
			
			report.log(LogStatus.INFO, "Step 59. Click on Pop up Ok button");
			objCreateSubledger.clickAccountPopUp2_OkButton();*/
			
			////////////////////////////
			
			report.log(LogStatus.INFO, "Step 20. Click on Accounting Class Search Icon");
			objCreateSubledger.clickAccountingClassList2SearchIcon();
			report.log(LogStatus.INFO, "Step 20.1. Click on Accounting Class Search link");
			objCreateSubledger.clickAccountingClassList2SearchLink();
			report.log(LogStatus.INFO, "Step 20.2. Click in the Accounting Class field. Enter the desired information into the Accounting Class field. Enter a valid value");
			if(JournalCategory != "")
			{
				objCreateSubledger.enterAccountingClass(AccountingClass2);
				report.log(LogStatus.PASS, "Step 20.2.1. Accounting Class is entered successfully: "+AccountingClass2);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 20.2.1. Accounting Class is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 20.3. Click on Accounting Class Search button");
			objCreateSubledger.clickAccountingClassSearchButton();
			
			report.log(LogStatus.INFO, "Step 20.4. Select Accounting Class from list");
			objCreateSubledger.selectAccountingClass(AccountingClass2);
			
			report.log(LogStatus.INFO, "Step 20.5. Click on Accounting Class Ok button");
			objCreateSubledger.clickAccountingClassOkButton();
			
			
			report.log(LogStatus.INFO, "Step 21. Click in the Credit field. Enter the desired information into the Credit field. Enter a valid value");
			if(Debit != "")
			{
				objCreateSubledger.enterCredit(Credit);
				objCreateSubledger.clickDebit();
				report.log(LogStatus.PASS, "Step 21.1. Credit is entered successfully: "+Credit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 21.1. Credit is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 22. Click on Save button and verify its navigated to Subledger Journal Entry page or not");
			SubledgerJournalEntryPage objSubledger=objCreateSubledger.clickSave();
			if(objSubledger.isPostButtonDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 22.1.Navigation to Subledger Journal Entry Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 22.1.Navigation to Subledger Journal Entry Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 23. Click on Post button");
			objSubledger.clickPostButton();
			
			report.log(LogStatus.INFO, "Step 24. Click on Warning Ok button");
			objSubledger.clickWarningOkButton();
			
			report.log(LogStatus.INFO, "Step 25. Click on Confirmation Ok button");
			objSubledger.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 26. Click on Save Menu");
			objSubledger.clicSaveMenu();
			
			report.log(LogStatus.INFO, "Step 27. Click on Save and close list");
			objSubledger.clicSaveAndCloseList();
			
	}

}
