package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreatePositivePayFile_BasicOptionsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Create_Positive_Pay_File extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Positive Pay File by Payables Supervisor")
	public void AP_Crt_Positive_Pay_File(String UserName,String Password,String PaymentProcessProfile,String FromPaymentDate,String ToPaymentDate)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Positive Pay  link and verify its navigated to Basic Options Page or not");
		CreatePositivePayFile_BasicOptionsPage objBasicOp=objOverview.clickCreatePositivePayFileLink();
			if(objBasicOp.isPaymentProcessProfileDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Payment Process Profile from list");
			if(PaymentProcessProfile != "")
			{
				objBasicOp.selectPaymentProcessProfile(PaymentProcessProfile);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Payment Process Profile from the list is "+PaymentProcessProfile);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Business Unit from the list is not selected");
			}
			
			String fromDateParts[] = FromPaymentDate.split("-");
			String fromMonth  = fromDateParts[0];
			String fromDay  = fromDateParts[1];
			String fromYear = fromDateParts[2];
			report.log(LogStatus.INFO, "Step 9. Click on From Payment Date button");
			//objSubRequest.isFromInvoiceDtBtnDisplayed();
			objBasicOp.clickFromPaymentDateButton();
			report.log(LogStatus.INFO, "Step 9.1. Select From Payment Date Month");
			//objSubRequest.isFromInvoiceMonthDisplayed();
			objBasicOp.selectFromPaymentMonth(fromMonth);
			report.log(LogStatus.INFO, "Step 9.2. Select From Payment Date");
			objBasicOp.selectFromPaymentDate(fromDay);
			
			String toDateParts[] = ToPaymentDate.split("-");
			String toMonth  = toDateParts[0];
			String toDay  = toDateParts[1];
			String toYear = toDateParts[2];
			report.log(LogStatus.INFO, "Step 10. Click on To Payment Date button");
			objBasicOp.clickToPaymentDateButton();
			report.log(LogStatus.INFO, "Step 10.1. Select To Payment Date Month");
			//objSubRequest.isToInvoiceMonthDisplayed();
			objBasicOp.selectToPaymentMonth(toMonth);
			report.log(LogStatus.INFO, "Step 10.2. Select To Payment Date");
			objBasicOp.selectToPaymentDate(toDay);
			objBasicOp.clickSubmissionNote();
		
			report.log(LogStatus.INFO, "Step 11. Click on Submit Button");
			objBasicOp.isSubmitBtnDisplayed();
			objBasicOp.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 12. Click on Confirmation Ok Button");
			objBasicOp.isConfOkBtnDisplayed();
			String ProcessId=objBasicOp.ConfirmationProcessId();
			objBasicOp.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 13. Click on Home Image");
			objHome.clickImgHome();
			
			report.log(LogStatus.INFO, "Step 14. Click on Navigator Icon");
			objHome.clickNavigatorIcon();
			
			report.log(LogStatus.INFO, "Step 15. Click on Schedule Process link and verify its navigated to Scheduled  Processes Page or not");
			ScheduledProcessesPage objScheduled =objHome.clickScheduledProcesses();
			if(objScheduled.isScheduleNewProcessBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 15.1.Navigation to Scheduled New Processes Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 15.1.Navigation to Scheduled New Processes Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 16. Click on refresh button and verify the Status of submitted process is Succeeded or not");
			objScheduled.clickRefreshButton();
			if(ProcessId != "")
			{
				objScheduled.ScheduleNewProcessIDStatus(ProcessId);
				//report.log(LogStatus.PASS, "Step 14.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 16.1.The Status of submitted process is not Succeeded");
			}

	}

}
