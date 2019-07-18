package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateElectronicPaymentFilesPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Create_Electronic_Payment_Files extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Electronic Payment Files by Payables Supervisor")
	public void AP_Create_Elec_Payment_Files(String UserName,String Password,String DisbursementBankAccount,String Currency,String BusinessUnit,String FromPaymentDate,String ToPaymentDate,String PaymentProcessRequest,String PaymentDocument)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Electronic Payment Files link and verify its navigated to Create  Electronic Payment Files page or not");
		CreateElectronicPaymentFilesPage objCreatePaymentFile=objOverview.clickCreateElectronicPaymentFiles();
			if(objCreatePaymentFile.isDisbursementBankAccountDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Electronic Payment Files Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Electronic Payment Files Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Select Disbursement Bank Account from list");
			if(DisbursementBankAccount != "")
			{
				objCreatePaymentFile.SelectDisbursementBankAccount(DisbursementBankAccount);
				report.log(LogStatus.PASS, "Step 8.1.Selected given Disbursement Bank Account from the list is "+DisbursementBankAccount);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 8.1.Given Disbursement Bank Account from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 9. Select Disbursement Bank Account from list");
			if(Currency != "")
			{
				objCreatePaymentFile.selectCurrency(Currency);
				report.log(LogStatus.PASS, "Step 9.1.Selected given Currency from the list is: "+Currency);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.1.Given Currency from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 10. Select Business Unit from list");
			if(BusinessUnit != "")
			{
				objCreatePaymentFile.SelectBusinessUnit(BusinessUnit);
				report.log(LogStatus.PASS, "Step 10.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 10.1.Given Business Unit from the list is not selected");
			}
			
			String fromDateParts[] = FromPaymentDate.split("-");
			String fromMonth  = fromDateParts[0];
			String fromDay  = fromDateParts[1];
			String fromYear = fromDateParts[2];
			report.log(LogStatus.INFO, "Step 11. Click on From Payment Date button");
			objCreatePaymentFile.clickFromPaymentDateButton();
			/*report.log(LogStatus.INFO, "Step 12. Select Year from Calander");
			objCreatePaymentFile.SelectYearFromDatePickerFromPaymentYear(fromYear);*/
			report.log(LogStatus.INFO, "Step 11.1. Select From Payment Month");
			objCreatePaymentFile.selectFromPaymentDateMonth(fromMonth);
			report.log(LogStatus.INFO, "Step 11.2. Select From Payment Date");
			objCreatePaymentFile.selectFromPaymentDate(fromDay);
			
			String toDateParts[] = ToPaymentDate.split("-");
			String toMonth  = toDateParts[0];
			String toDay  = toDateParts[1];
			String toYear = toDateParts[2];
			report.log(LogStatus.INFO, "Step 12. Click on To Payment Date button");
			objCreatePaymentFile.clickToPaymentDateButton();
			/*report.log(LogStatus.INFO, "Step 12. Select Year from Calander");
			objCreatePaymentFile.SelectYearFromDatePickerToPaymentYear(toYear);*/
			report.log(LogStatus.INFO, "Step 12.1. Select To Payment Month");
			objCreatePaymentFile.selectToPaymentDateMonth(toMonth);
			report.log(LogStatus.INFO, "Step 12.2. Select To Payment Date");
			objCreatePaymentFile.selectToPaymentDate(toDay);
			
			report.log(LogStatus.INFO, "Step 13. Click on Payment Process Request Search Icon");
			objCreatePaymentFile.isPaymentProcessRequestSearchIconDisplayed();
			objCreatePaymentFile.clickPaymentProcessRequestSearchIcon();
			report.log(LogStatus.INFO, "Step 13.1. Click on Payment Process Request Search link");
			objCreatePaymentFile.clickPaymentProcessRequestSearchLink();	
			report.log(LogStatus.INFO, "Step 13.2. Enter the Party Value in Payment Process Request text field");
			objCreatePaymentFile.enterPaymentProcessRequest(PaymentProcessRequest);
			
			report.log(LogStatus.INFO, "Step 13.3. Click on Payment Process Request Search button");
			objCreatePaymentFile.clickPaymentProcessRequestSearchButton();
			report.log(LogStatus.INFO, "Step 13.4. Select Payment Process Request");
			objCreatePaymentFile.selectPaymentProcessRequest(PaymentProcessRequest);
			report.log(LogStatus.INFO, "Step 13.5. Click on Payment Process Request Ok button");
			objCreatePaymentFile.clickPaymentProcessRequestOkButton();
			
			report.log(LogStatus.INFO, "Step 14. Select Payment Document from list");
			if(PaymentDocument != "")
			{
				objCreatePaymentFile.selectPaymentDocument(PaymentDocument);
				report.log(LogStatus.PASS, "Step 14.1.Selected given Payment Document from the list is "+PaymentDocument);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 14.1.Given Payment Document from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 15. Click on Submit button");
			objCreatePaymentFile.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 16. Click on Confirmation Ok Button");
			objCreatePaymentFile.isConfOkBtnDisplayed();
			String ProcessId=objCreatePaymentFile.ConfirmationProcessId();
			objCreatePaymentFile.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 17. Click on Home Image");
			objHome.clickImgHome();
			
			report.log(LogStatus.INFO, "Step 18. Click on Navigator Icon");
			objHome.clickNavigatorIcon();
			
			report.log(LogStatus.INFO, "Step 19. Click on Schedule Process link and verify its navigated to Scheduled  Processes Page or not");
			ScheduledProcessesPage objScheduled =objHome.clickScheduledProcesses();
			if(objScheduled.isScheduleNewProcessBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 19.1.Navigation to Scheduled New Processes Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 19.1.Navigation to Scheduled New Processes Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 20. Click on refresh button and verify the Status of submitted process is Succeeded or not");
			//String ProcessId="61356";
			objScheduled.clickRefreshButton();
			if(ProcessId != "")
			{
				objScheduled.ScheduleNewProcessIDStatus(ProcessId);
				//report.log(LogStatus.PASS, "Step 20.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 20.1.The Status of submitted process is not Succeeded");
			}

			
	}

}
