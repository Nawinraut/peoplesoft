package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AutoReverseJournals_BasicOptionsPage;
import com.cloud.pageobjects.Finance.EditJournalPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.pageobjects.Finance.ManageJournalsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(TestNGListeners.class)
public class GL_Create_Auto_Reversal_Journal extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Online Journal for regular expense")
	public void GL_Crt_Auto_Reversal_Jrnl(String UserName,String Password,String ReversalPeriod,String Journal,String JournalBatch)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Run AutoReverse link and verify its navigated to Basic Options page or not");
		AutoReverseJournals_BasicOptionsPage objBscOptions=objJournals.clickRunAutoReverseLink();
		if(objBscOptions.isReversalPeriodListDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Reversal Period from list");
		if(ReversalPeriod != "")
		{
			objBscOptions.selectReversalPeriodList(ReversalPeriod);
			objBscOptions.clickSubmissionNotesField();
			report.log(LogStatus.PASS, "Step 8.1.Selected given Reversal Period from the list is "+ReversalPeriod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Given Reversal Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click on Submit button");
		objBscOptions.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 10. Click on confirmation OK button and Verify its navigated to Journals page or not");
		JournalsPage objJournal=objBscOptions.clickConfOkButton();
		if(objJournal.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 10.1.Navigation to Journals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Navigation to Journals Page is failed");	
		}
	
		report.log(LogStatus.INFO, "Step 11. Click on Tasks button");
		objJournal.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 12. Click on Manage Journals link and Verify its navigated to Manage Journals page or not");
		ManageJournalsPage objMngJournal=objJournal.clickManageJournalLink();
		if(objMngJournal.isJournalDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 12.1.Navigation to Manage Journals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 12.1.Navigation to Manage Journals Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 13. Click in the Journal field. Enter the desired information into the Journal field. Enter a valid value");
		if(Journal != "")
		{
			objMngJournal.enterJournal(Journal);
			report.log(LogStatus.PASS, "Step 13.1. Journal is entered successfully: "+Journal);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1. Journal is not entered");
		}
		
		/*report.log(LogStatus.INFO, "Step 14. Click in the Journal Batch field. Enter the desired information into the Journal Batch field. Enter a valid value");
		if(JournalBatch != "")
		{
			objMngJournal.enterJournalBatch(JournalBatch);
			report.log(LogStatus.PASS, "Step 14.1. Journal Batch is entered successfully: "+JournalBatch);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1. Journal Batch is not entered");
		}*/
		
		report.log(LogStatus.INFO, "Step 15. Select Reversal Period from list");
		if(ReversalPeriod != "")
		{
			objMngJournal.clickAccountingPeriodSearchIcon();
			objMngJournal.clickAccPeriodSearchLink();
			objMngJournal.enterPeriodName(ReversalPeriod);
			objMngJournal.clickPeriodSearchButton();
			objMngJournal.clickPeriodNameValue(ReversalPeriod);
			objMngJournal.clickPeriodOkButton();
			report.log(LogStatus.PASS, "Step 15.1.Selected given Reversal Period from the list is "+ReversalPeriod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Given Reversal Period from the list is not selected");
		}
		
		
		report.log(LogStatus.INFO, "Step 16. Click on Search button");
		objMngJournal.clickJournalsSearchButton();
		
		report.log(LogStatus.INFO, "Step 17. Select Journal link and Verify its navigated to Edit Journals page or not");
		EditJournalPage objEdtJrnl=objMngJournal.selectJournalCellLink();
		if(objEdtJrnl.isSaveMenuDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 17.1.Navigation to Edit Journals Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 17.1.Navigation to Edit Journals Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 18. Click on Save menu");
		objEdtJrnl.clickSaveMenu();
		
		report.log(LogStatus.INFO, "Step 19. Click on Save and Close list");
		ManageJournalsPage objMng=objEdtJrnl.clickSaveAndCloseList();
		
		report.log(LogStatus.INFO, "Step 20. Click on Done button");
		objMng.clickDoneButton();
		
	}

}
