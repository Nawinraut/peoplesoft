package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreatePaymentFileAccompanyingLetter_BasicOptionsPage;
import com.cloud.pageobjects.Finance.ManagePaymentFilesPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.PaymentFilePage;
import com.cloud.pageobjects.Finance.RecordPrintStatus_PaymentFilePage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Manage_Payment_Files_SubmittedforPrinting extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is Payment Files with Status Submitted for printing by Payables Supervisor")
	public void Cloud_Payment_File_Submit_Print(String UserName,String Password,String Reference,String Status)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Manage Payment Files link and verify its navigated to Manage Payment Files page or not");
		ManagePaymentFilesPage objMngPmntFiles=objOverview.clickManagePaymentFilesLink();
			if(objMngPmntFiles.isDoneBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Manage Payment Files Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Manage Payment Files Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Click in the Reference field. Enter the desired information into the Reference field. Enter a valid value");
			if(Reference!= "") {
				
				objMngPmntFiles.enterReference(Reference);
				report.log(LogStatus.PASS, "Step 8.1.Reference is entered successfully: "+Reference);
			}else {
				report.log(LogStatus.FAIL, "Step 8.1.Reference is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 9. Select Status from list");
			if(Status != "")
			{
				objMngPmntFiles.selectStatuslist(Status);
				report.log(LogStatus.PASS, "Step 9.1.Selected given Status from the list is "+Status);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.1.Given Status from the list is not selected");
			}
			
			report.log(LogStatus.INFO, "Step 10. Click on Search button");
			objMngPmntFiles.clickSearchButton();
			
			report.log(LogStatus.INFO, "Step 11. Click on Action button and verify its navigated to Payment File page or not");
			PaymentFilePage objPaymentFile=objMngPmntFiles.clickActionButton();
			if(objPaymentFile.isDoneBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 11.1.Navigation to Payment File Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 11.1.Navigation to Payment File Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 12. Click on Record Print Status button and verify its navigated to Record Print Status Payment File page or not");
			RecordPrintStatus_PaymentFilePage objRcrdPaymentFile=objPaymentFile.clickRecordPrintStatusButton();
			if(objRcrdPaymentFile.isSubmitBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 12.1.Navigation to Record Print Status Payment File Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 12.1.Navigation to Record Print Status Payment File Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 13. Click on submit button");
			objRcrdPaymentFile.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 14. Click on submit button");
			objRcrdPaymentFile.clickRecordthePrintStatusButton();
			
			
			report.log(LogStatus.INFO, "Step 15. Click on Confirmation Ok button and verify its navigated to Payment File page or not");
			PaymentFilePage objPmntFile=objRcrdPaymentFile.clickConfOkButton();
			if(objPmntFile.isDoneBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 15.1.Navigation to Payment File Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 15.1.Navigation to Payment File Page is failed");	
			}
			
			
			report.log(LogStatus.INFO, "Step 16. Click on Done button and verify its navigated to Manage Payment Files page or not");
			ManagePaymentFilesPage objMngPmntFile=objPmntFile.clickDoneButton();
				if(objMngPmntFiles.isDoneBtnDisplayed()) 
				{
					report.log(LogStatus.PASS, "Step 16.1.Navigation to Manage Payment Files Page is success");	
				}
				else
				{
					report.log(LogStatus.FAIL, "Step 16.1.Navigation to Manage Payment Files Page is failed");	
				}
				
				report.log(LogStatus.INFO, "Step 17. Click on Done button");
				objMngPmntFile.clickDoneButton();
			
	}

}
