package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.EditJournalPage;
import com.cloud.pageobjects.Finance.JournalsPage;
import com.cloud.pageobjects.Finance.ManageJournalsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class GL_Complete_Journal extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to complete the Journal")
	public void GL_Complete_the_Journal(String UserName,String Password,String Journal,String JournalBatch)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		/*GL_IncompleteJournal objLogin1 = new GL_IncompleteJournal();
		String objvalue=objLogin1.newJournal;*/
		
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		
		report.log(LogStatus.INFO, "Step 3. Verify that Home Page is displayed or not");
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 4. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 5. Click on Journals link");
		JournalsPage objJournals=objHome.clickJournals();
				
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		objJournals.clickTasksButton();
 		
		report.log(LogStatus.INFO, "Step 7. Click on Manage Journal link");
		objJournals.isManageJournalLinkDisplayed(); 
		ManageJournalsPage objMngJournal=objJournals.clickManageJournalLink();
		
		report.log(LogStatus.INFO, "Step 8. Enter the Journal  in Journal text field");
		objMngJournal.isJournalDisplayed();
		objMngJournal.enterJournal(Journal);
		
		report.log(LogStatus.INFO, "Step 9. Enter the Journal Batch in Journal Batch text filed");
		objMngJournal.isJournalBatchDisplayed();
		objMngJournal.enterJournalBatch(JournalBatch);
		
		report.log(LogStatus.INFO, "Step 10. Click on Search button");
		objMngJournal.isJournalsSearchButtonDisplayed();
		objMngJournal.clickJournalsSearchButton();
		
		report.log(LogStatus.INFO, "Step 11. Select on Journal Cell");
		objMngJournal.isclickJournalCellLinkDisplayed();
		//objMngJournal.clickJournalCellLink();
		
		EditJournalPage objEdit=objMngJournal.selectJournalCellLink();
		
		report.log(LogStatus.INFO, "Step 12. Click on Complete button");
		objEdit.clickCompleteButton();
		
		objEdit.clickSaveButton();
	}

}
