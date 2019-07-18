package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateJournalPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class GL_Create_Online_Journal_for_regular_expense extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Online Journal for regular expense")
	public void GL_Crt_Online_Jrnl_Regular_Exp(String UserName,String Password,String JournalBatch,String JournalBatchDescription,String Journal,String JournalDescription,String Category,String AccountField1,String Debit,String AccountField2,String Credit)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Journals link and verify its navigated to Journals Page or not");
		JournalsPage objJournals=objHome.clickJournals();
		if(objJournals.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Journals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Journals Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objJournals.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Journal link and verify its navigated to Create Journal page or not");
		CreateJournalPage objCreateJournal=objJournals.clickCreateJournalLink();
		if(objCreateJournal.isJournalBatchDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Journal Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Journal Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Click in the Journal Batch field. Enter the desired information into the Journal Batch field. Enter a valid value");
		if(JournalBatch != "")
		{
			objCreateJournal.enterJournalBatch(JournalBatch);
			//report.log(LogStatus.PASS, "Step 8.1. Journal Batch is entered successfully: "+JournalBatch);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1. Journal Batch is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click in the Journal Batch Description field. Enter the desired information into the Journal Batch Description field. Enter a valid value");
		if(JournalBatchDescription != "")
		{
			objCreateJournal.enterBatchDescription(JournalBatchDescription);
			//report.log(LogStatus.PASS, "Step 9.1. Journal Batch Description is entered successfully: "+JournalBatchDescription);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1. Journal Batch Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click in the Journal  field. Enter the desired information into the Journal field. Enter a valid value");
		if(Journal != "")
		{
			objCreateJournal.enterJournal(Journal);
			//report.log(LogStatus.PASS, "Step 10.1. Journal  is entered successfully: "+Journal);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1. Journal is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click in the Journal Description field. Enter the desired information into the Journal Description field. Enter a valid value");
		if(JournalDescription != "")
		{
			objCreateJournal.enterJournalDescription(JournalDescription);
			//report.log(LogStatus.PASS, "Step 11.1. Journal Description is entered successfully: "+JournalDescription);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 11.1. Journal Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 12. Select Category from list");
		if(Category != "")
		{
			objCreateJournal.SelectCategory(Category);
			//report.log(LogStatus.PASS, "Step 12.1.Selected given Category from the list is "+Category);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Given Category from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 13. Click in the Journal Lines Account field. Enter the desired information into the Journal Lines Account field. Enter a valid value");
		if(AccountField1 != "")
		{
			objCreateJournal.enterJournalLinesAccountField1(AccountField1);
			report.log(LogStatus.PASS, "Step 13.1. Journal Lines Account is entered successfully: "+AccountField1);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1. Journal Lines Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 14. Click in the Debit field. Enter the desired information into the Debit field. Enter a valid value");
		if(Debit != "")
		{
			objCreateJournal.enterDebit(Debit);
			report.log(LogStatus.PASS, "Step 14.1. Debit is entered successfully: "+Debit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1. Debit is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 15. Click in the Journal Lines Account field. Enter the desired information into the Journal Lines Account field. Enter a valid value");
		if(AccountField2 != "")
		{
			objCreateJournal.clickAccountTab();
			objCreateJournal.enterJournalLinesAccountField2(AccountField2);
			report.log(LogStatus.PASS, "Step 16.1. Journal Lines Account is entered successfully: "+AccountField2);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 16.1. Journal Lines Account is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 17. Click in the Credit field. Enter the desired information into the Credit field. Enter a valid value");
		if(Credit != "")
		{
			objCreateJournal.enterCredit(Credit);
			report.log(LogStatus.PASS, "Step 17.1. Credit is entered successfully: "+Credit);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 17.1. Credit is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 18. Click on Save button");
		objCreateJournal.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 19. Click on Complete button");
		objCreateJournal.clickCompleteButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Post button");
		objCreateJournal.clickPostButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Confirmation Ok button");
		objCreateJournal.clickConfOkButton();
			
	}

}
