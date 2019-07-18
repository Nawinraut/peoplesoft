package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.ScheduledProcessesPage;
import com.cloud.pageobjects.Finance.SendSeparateRemittanceAdvice_BasicOptions;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Send_Separate_Remittance_Advice extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is to Apply Missing Conversion Rates")
	public void Cloud_Send_Separate_Remittance(String UserName,String Password,String PaymentFile ,String Format)throws TestException,InterruptedException, TestException {
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Send Separate Remittance Advice link and verify its navigated to Basic Options Page or not");
		SendSeparateRemittanceAdvice_BasicOptions objBasicOption=objOverview.clickSendSeparateRemittanceAdviceLink();
			if(objBasicOption.isSearchPaymentFileIconDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Basic Options Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Basic Options Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Click on Payment File Search Icon");
			objBasicOption.isSearchPaymentFileIconDisplayed();
			objBasicOption.clickSearchPaymentFileIcon();
			report.log(LogStatus.INFO, "Step 8.1. Click on Payment File Search link");
			objBasicOption.isSearchPaymentFileLinkDisplayed();
			objBasicOption.clickSearchPaymentFileLink();
			report.log(LogStatus.INFO, "Step 8.2. Enter the Payment File Reference Value in Payment File Reference text field");
			objBasicOption.isPaymentFileReferenceDisplayed();
			objBasicOption.enterPaymentFileReference(PaymentFile);
			
			report.log(LogStatus.INFO, "Step 8.3. Click on Payment File Search button");
			objBasicOption.isPaymentFileSearchBtnDisplayed();
			objBasicOption.clickPaymentFileSearchButton(PaymentFile);
			report.log(LogStatus.INFO, "Step 8.4. Select Payment File Reference from dropdown");
			objBasicOption.selectEvent(PaymentFile);
			report.log(LogStatus.INFO, "Step 8.5. Click on Payment File Ok button");
			objBasicOption.isPaymentFileOkBtnDisplayed();
			objBasicOption.clickPaymentFileOkButton();
			
			report.log(LogStatus.INFO, "Step 9. Select Format from list");
			if(Format != "")
			{
				objBasicOption.selectFormatList(Format);
				objBasicOption.clickSubmissionNote();
				report.log(LogStatus.PASS, "Step 9.1.Selected given Format from the list is "+Format);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.1.Given Format from the list is not selected");
			}
			
			
			report.log(LogStatus.INFO, "Step 10. Click on Submit Button");
			objBasicOption.isSubmitBtnDisplayed();
			objBasicOption.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 11. Click on Confirmation Ok Button");
			objBasicOption.isConfOkBtnDisplayed();
			String ProcessId=objBasicOption.ConfirmationProcessId();
			objBasicOption.clickConfOkButton();
			
			report.log(LogStatus.INFO, "Step 12. Click on Home Image");
			objHome.clickImgHome();
			
			report.log(LogStatus.INFO, "Step 13. Click on Navigator Icon");
			objHome.clickNavigatorIcon();
			
			report.log(LogStatus.INFO, "Step 14. Click on Schedule Process link and verify its navigated to Scheduled  Processes Page or not");
			ScheduledProcessesPage objScheduled =objHome.clickScheduledProcesses();
			if(objScheduled.isScheduleNewProcessBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 14.1.Navigation to Scheduled New Processes Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 14.1.Navigation to Scheduled New Processes Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 15. Click on refresh button and verify the Status of submitted process is Succeeded or not");
			//String ProcessId="61356";
			objScheduled.clickRefreshButton();
			if(ProcessId != "")
			{
				objScheduled.ScheduleNewProcessIDStatus(ProcessId);
				//report.log(LogStatus.PASS, "Step 14.1.Selected given Business Unit from the list is "+BusinessUnit);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 15.1.The Status of submitted process is not Succeeded");
			}

			
	}

}
