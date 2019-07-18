package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.ManagePaymentProcessRequestsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Payment_File_Register extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is How to Submit Payment File Register Report by Payables Supervisor")
	public void AP_Payment_File_Register(String UserName,String Password,String PaymentProcessName,String Name,String NameCell,String Format)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Payments link and verify its navigated to Overview Page or not");
		OverviewPage objOverview=objHome.clickPayments();
		if(objOverview.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 4.1.Navigation to Overview Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 4.1.Navigation to Overview Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Manage Payment Process Requests link");
		objOverview.isManagePaymentProcessRequestsLinkDisplayed(); 
		ManagePaymentProcessRequestsPage objMngRequest=objOverview.clickManagePaymentProcessRequestsLink();
		
		report.log(LogStatus.INFO, "Step 7. Enter Name in Name field");
		objMngRequest.isNameDisplayed();
		objMngRequest.enterName(PaymentProcessName);
		
		report.log(LogStatus.INFO, "Step 8. Click on Search button");
		objMngRequest.isSearchBtnDisplayed();
		objMngRequest.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 9. Fetch the Payment File Number");
		String Reference =objMngRequest.fetchPaymentFileNumber();
		
		report.log(LogStatus.INFO, "Step 10. Click on Home Image icon");
		objHome.isHomeImageDisplayed();
		objHome.clickImgHome();
		
		report.log(LogStatus.INFO, "Step 11. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		
		report.log(LogStatus.INFO, "Step 12. Click on Schedule New Process button");
		ScheduledProcessesPage objSchProcesses=objHome.clickScheduledProcesses();
		
		report.log(LogStatus.INFO, "Step 13. Click on Schedule New Process button and verify its navigated to Schedule New Process window or not ");
		objSchProcesses.clickScheduleNewProcessButton();
		if(objSchProcesses.isScheduleNewProcessOkButtonDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 13.1.Navigation to Schedule New Process window is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Navigation to Schedule New Process window is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 14. Click on Name Search Icon");
		objSchProcesses.clickSearchScheduleNewProcessIcon();
		
		report.log(LogStatus.INFO, "Step 15. Click on Name Search link");
		objSchProcesses.clickScheduleNewProcessSearchLink();
		
		report.log(LogStatus.INFO, "Step 16. Enter Name");
		objSchProcesses.enterName(Name);
	
		report.log(LogStatus.INFO, "Step 17. Click on Name Search Button");
		objSchProcesses.clickNameSearchButton();
		
		report.log(LogStatus.INFO, "Step 18. Select Name Cell");
		objSchProcesses.selectEvent(NameCell);
		
		report.log(LogStatus.INFO, "Step 19. Click on Name Ok Button");
		objSchProcesses.clickNameOkButton();
		
		report.log(LogStatus.INFO, "Step 20. Click on Schedule New Process Ok Button");
		objSchProcesses.clickScheduleNewProcessOkButton();
		
		report.log(LogStatus.INFO, "Step 21. Click on Payment File Search Icon");
		objSchProcesses.clickPaymentFileSearchIcon();
		
		report.log(LogStatus.INFO, "Step 21.1. Click on Payment File Search link");
		objSchProcesses.clickPaymentFileSearchLink();
		
		report.log(LogStatus.INFO, "Step 21.2. Enter Reference");
		objSchProcesses.enterReference(Reference);
		
		report.log(LogStatus.INFO, "Step 21.3. Click on Reference Search Button");
		objSchProcesses.clickReferenceSearchButton();
		
		report.log(LogStatus.INFO, "Step 21.4. Select Reference Cell");
		objSchProcesses.selectEvent(Reference);
		
		report.log(LogStatus.INFO, "Step 21.5. Click on Reference Ok Button");
		objSchProcesses.clickReferenceOkButton();
		
		report.log(LogStatus.INFO, "Step 22. Select Format from list");
		objSchProcesses.selectFormat(Format);
		objSchProcesses.clickSubmissionNotes();
		
		report.log(LogStatus.INFO, "Step 23. Click on Submit button");
		objSchProcesses.clickSubmitButton();
		
		report.log(LogStatus.INFO, "Step 24. Click on Confirmation Ok button");
		String ProcessId=objSchProcesses.ConfirmationProcessId();
		objSchProcesses.clickConfOkButton();
		
		report.log(LogStatus.INFO, "Step 25. Click on Refresh button");
		objSchProcesses.clickRefreshButton();
		objSchProcesses.clickRefreshButton();
		objSchProcesses.selectPaymentFileRegisterCell_Succeeded(ProcessId);
		//objSchProcesses.selectPaymentFileRegisterCell(ProcessId);
		
		//Temporarily Comented
		/*report.log(LogStatus.INFO, "Step 18. Click on 1 More Link");
		objSchProcesses.clickMoreLink();
		
		report.log(LogStatus.INFO, "Step 19. Click on Process ID PDF Link");
		objSchProcesses.clickPDFProcessIDLink();*/
			
		
	}

}
