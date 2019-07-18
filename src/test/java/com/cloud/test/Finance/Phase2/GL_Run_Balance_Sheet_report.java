package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class GL_Run_Balance_Sheet_report extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Submit Trial Balance Report")
	public void Cloud_Run_Balance_Sheet_report(String UserName,String Password,String Name,String NameCell,String AccountingPeriod,String AmountType,String Company)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Schedule Process link and verify its navigated to Scheduled  Processes Page or not");
		ScheduledProcessesPage objScheduled =objHome.clickScheduledProcesses();
		if(objScheduled.isScheduleNewProcessBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Scheduled New Processes Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Scheduled New Processes Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Schedule New Process button and verify its navigated to Scheduled New Processes Pop-up or not");
		objScheduled.clickScheduleNewProcessButton();
		if(objScheduled.isSearchScheduleNewProcessIconDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 6.1.Navigation to Scheduled New Processes Pop-up is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 6.1.Navigation to Scheduled New Processes Pop-up is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 7. Click on Scheduled New Processes Name list icon ");
		objScheduled.clickSearchScheduleNewProcessIcon();
		
		report.log(LogStatus.INFO, "Step 8. Click on Scheduled New Processes Search link and verify its navigated to Search and Select: Name Pop-up or not");
		objScheduled.clickScheduleNewProcessSearchLink();
		if(objScheduled.isNameDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 8.1.Navigation to Search and Select: Name Pop-up is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 8.1.Navigation to Search and Select: Name Pop-up is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 9. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
		if(Name != "")
		{
			objScheduled.enterName(NameCell);
			report.log(LogStatus.PASS, "Step 9.1.Name is entered successfully: "+Name);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 9.1.Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Click on Search and Select: Name Search button");
		objScheduled.clickNameSearchButton();
		report.log(LogStatus.INFO, "Step 11. Select the Name Cell in Search and Select: Name pop-up");
		objScheduled.clickNameSearchButton();
		objScheduled.selectEvent(NameCell);
		report.log(LogStatus.INFO, "Step 12. Click on OK button in Search and Select: Name pop-up");
		objScheduled.clickNameOkButton();
		
		report.log(LogStatus.INFO, "Step 13. Click on OK button in Shedule New Process Pop-up and verify its navigated to Process Details Pop-up window or not");
		objScheduled.clickScheduleNewProcessOkButton();
		if(objScheduled.isProcessDetailsTitleDisplayed()) {
			report.log(LogStatus.PASS, "Step 13.1.Navigation to Process Details Pop-up window is success");
		}else {
			report.log(LogStatus.FAIL, "Step 13.1.Navigation to Process Details Pop-up window is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 14. Select Accounting Period");
		if(AccountingPeriod != "")
		{
			objScheduled.SelectAccountingPeriodList_BasicOptions(AccountingPeriod);
			report.log(LogStatus.PASS, "Step 14.1.Selected given Accounting Period from the list is "+AccountingPeriod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Given Accounting Period from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 15. Select Amount Type");
		if(AmountType != "")
		{
			objScheduled.SelectAmountTypeList_BasicOptions(AmountType);
			report.log(LogStatus.PASS, "Step 15.1.Selected given Amount Type from the list is "+AccountingPeriod);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Given Amount Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 16. Click on Balancing Segment button");
		objScheduled.clickBalancingSegmentButton();
		
		report.log(LogStatus.INFO, "Step 17. Select Add Fields List");
		objScheduled.selectAddFieldsList("Company");
		
		report.log(LogStatus.INFO, "Step 18. Select Company List");
		objScheduled.clickCompanySearchIcon();
		objScheduled.selectCompanyList(Company);
		
		report.log(LogStatus.INFO, "Step 19. Click on Company Ok button");
		objScheduled.clickCompanyOkButton();
		objScheduled.clickSubmissionNotes();
		
		report.log(LogStatus.INFO, "Step 20. Click on Submit button");
		objScheduled.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Confirmation Ok button");
		String ProcessId = objScheduled.ConfirmationProcessId();
		objScheduled.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on refresh button");
		objScheduled.clickRefreshButton();
		
		report.log(LogStatus.INFO, "Step 23. Click on Trial Balance Report cell");
		objScheduled.selectTrialBalanceReportCell(ProcessId);
		
		report.log(LogStatus.INFO, "Step 24. Click on Default Document Link");
		//objScheduled.clickDefaultDocumentLink();
		objScheduled.clickDefaultDocumnetLink();
		
		driver.switchTo().parentFrame();
		
		
		
	}

}
