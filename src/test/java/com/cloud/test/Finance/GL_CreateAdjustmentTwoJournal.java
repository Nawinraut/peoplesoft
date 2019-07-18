package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateJournalPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class GL_CreateAdjustmentTwoJournal extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Create Adjustment Journal")
	public void GL_Create_Adjustment_Two_Jrnl(String UserName,String Password,String JournalBatch,String Description,String Journal1,String JournalDescription1,String Category,String Journal2,String JournalDescription2,String AccountField1,String AccountField2,String Debit,String Credit)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		
		report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 5. Click on Journals link");
		JournalsPage objJournals=objHome.clickJournals();
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		sAssert.assertTrue(objJournals.isTasksBtnDisplayed());
		objJournals.clickTasksButton();
	
		report.log(LogStatus.INFO, "Step 7. Click on Create Journal link");
		objJournals.isCreateJournalLinkDisplayed(); 
		CreateJournalPage objCrtJournal=objJournals.clickCreateJournalLink();
		
		report.log(LogStatus.INFO, "Step 8. Enter the Journal Batch in Journal Batch text filed");
		objCrtJournal.isJournalBatchDisplayed();
		objCrtJournal.enterJournalBatch(JournalBatch);
		
		report.log(LogStatus.INFO, "Step 9. Enter the Journal Batch Description in Description text area filed");
		objCrtJournal.isBatchDescriptionDisplayed();
		objCrtJournal.enterBatchDescription(Description);
	
		report.log(LogStatus.INFO, "Step 10. Enter the Journal in Journal text filed");
		objCrtJournal.isJournalDisplayed();
		objCrtJournal.enterJournal(Journal1);
		
		report.log(LogStatus.INFO, "Step 11. Enter the Journal Description in Description text area filed");
		objCrtJournal.isJournalDescriptionDisplayed();
		objCrtJournal.enterJournalDescription(JournalDescription1);
		
		report.log(LogStatus.INFO, "Step 12. Select category from Category dropdown");
		objCrtJournal.isSelectCategoryDisplayed();
		objCrtJournal.SelectCategory(Category);
		
		report.log(LogStatus.INFO, "Step 15. Click in the Journal Lines Account field. Enter the desired information into the Journal Lines Account field. Enter a valid value");
		if(AccountField1 != "")
		{
			objCrtJournal.enterJournalLinesAccountField1(AccountField1);
			report.log(LogStatus.PASS, "Step 15.1.Journal Lines Account is entered successfully: "+AccountField1);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Journal Lines Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 16. Click in the Debit field. Enter the desired information into the Debit field. Enter a valid value");
		if(Debit != "")
		{
			objCrtJournal.enterDebit(Debit);
			objCrtJournal.clickAccountTab();
			//report.log(LogStatus.PASS, "Step 16.1.Journal Lines Account is entered successfully: "+Debit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 16.1.Debit is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click in the Journal Lines Account field. Enter the desired information into the Journal Lines Account field. Enter a valid value");
		if(AccountField2 != "")
		{
			objCrtJournal.enterJournalLinesAccountField2(AccountField2);
			report.log(LogStatus.PASS, "Step 17.1.Journal Lines Account is entered successfully: "+AccountField2);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 17.1.Journal Lines Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 18. Click in the Credit field. Enter the desired information into the Credit field. Enter a valid value");
		if(Credit != "")
		{
			objCrtJournal.enterCredit(Credit);
			objCrtJournal.clickCreditTab();
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 18.1.Credit is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 19. Click on Save button");
		objCrtJournal.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Add icon");
		objCrtJournal.clickAddicon();
		
		report.log(LogStatus.INFO, "Step 21. Enter the Journal in Journal text filed");
		objCrtJournal.isJournalDisplayed();
		objCrtJournal.enterJournal(Journal2);
		
		report.log(LogStatus.INFO, "Step 22. Enter the Journal Description in Description text area filed");
		objCrtJournal.isJournalDescriptionDisplayed();
		objCrtJournal.enterJournalDescription(JournalDescription2);
		
		report.log(LogStatus.INFO, "Step 23. Select category from Category dropdown");
		objCrtJournal.isSelectCategoryDisplayed();
		objCrtJournal.SelectCategory(Category);
		
		objCrtJournal.clickAccountTab_2ndJournal();
		
		report.log(LogStatus.INFO, "Step 24. Click in the Journal Lines Account field. Enter the desired information into the Journal Lines Account field. Enter a valid value");
		if(AccountField1 != "")
		{
			objCrtJournal.enterJournalLinesAccountField1_2ndJournal(AccountField1);
			report.log(LogStatus.PASS, "Step 24.1.Journal Lines Account is entered successfully: "+AccountField1);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 24.1.Journal Lines Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 25. Click in the Debit field. Enter the desired information into the Debit field. Enter a valid value");
		if(Debit != "")
		{
			objCrtJournal.enterDebit_2ndJournal(Debit);
			objCrtJournal.clickAccountTab_2Tab();
			//report.log(LogStatus.PASS, "Step 25.1.Journal Lines Account is entered successfully: "+Debit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 25.1.Debit is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 26. Click in the Journal Lines Account field. Enter the desired information into the Journal Lines Account field. Enter a valid value");
		if(AccountField2 != "")
		{
			objCrtJournal.enterJournalLinesAccountField2_2ndJournal(AccountField2);
			report.log(LogStatus.PASS, "Step 26.1.Journal Lines Account is entered successfully: "+AccountField2);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 26.1.Journal Lines Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 27. Click in the Credit field. Enter the desired information into the Credit field. Enter a valid value");
		if(Credit != "")
		{
			objCrtJournal.enterCredit_2ndJournal(Credit);
			objCrtJournal.clickCreditTab_2ndJournal();
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 27.1.Credit is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 28. Click on Complete button");
		objCrtJournal.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 29. Click on Complete button");
		objCrtJournal.clickCompleteButton();
	}

}
