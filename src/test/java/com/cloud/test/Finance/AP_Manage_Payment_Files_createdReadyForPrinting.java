package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.ManagePaymentFilesPage;
import com.cloud.pageobjects.Finance.ManagePaymentProcessRequestsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.PaymentFilePage;
import com.cloud.pageobjects.Finance.PrintPaymentDocumentsPage;
import com.cloud.pageobjects.Finance.RecordPrintStatus_PaymentFilePage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Manage_Payment_Files_createdReadyForPrinting extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is Payment Files created and ready for printing by Payables Supervisor")
	public void AP_Pmnt_File_CrtReady_Print(String UserName,String Password,String Name,String Status)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Manage Payment Process Requests link");
		objOverview.isManagePaymentProcessRequestsLinkDisplayed(); 
		ManagePaymentProcessRequestsPage objMngRequest=objOverview.clickManagePaymentProcessRequestsLink();
		
		report.log(LogStatus.INFO, "Step 8. Enter Name in Name field");
		objMngRequest.isNameDisplayed();
		objMngRequest.enterName(Name);
		
		report.log(LogStatus.INFO, "Step 9. Click on Search button");
		objMngRequest.isSearchBtnDisplayed();
		objMngRequest.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 10. Fetch the Payment File Number");
		String Reference =objMngRequest.fetchPaymentFileNumber();
		
		report.log(LogStatus.INFO, "Step 11. Click on Home Image icon");
		objHome.isHomeImageDisplayed();
		objHome.clickImgHome();
		
		report.log(LogStatus.INFO, "Step 12. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 13. Click on Payments link and verify its navigated to Overview Page or not");
		OverviewPage objOverview1=objHome.clickPayments();
		if(objOverview1.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 14.1.Navigation to Overview Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 14.1.Navigation to Overview Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 15. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview1.clickTasksButton();
		
		
		report.log(LogStatus.INFO, "Step 16. Click on ManagePaymentFiles link and verify its navigated to Manage Payment Files page or not");
		ManagePaymentFilesPage objMngPmntFiles=objOverview.clickManagePaymentFilesLink();
			if(objMngPmntFiles.isDoneBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 16.1.Navigation to Manage Payment Files Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 16.1.Navigation to Manage Payment Files Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 17. Click in the Reference field. Enter the desired information into the Reference field. Enter a valid value");
			if(Reference!= "") {
				
				objMngPmntFiles.enterReference(Reference);
				report.log(LogStatus.PASS, "Step 17.1.Reference is entered successfully: "+Reference);
			}else {
				report.log(LogStatus.FAIL, "Step 17.1.Reference is not entered");
			}
			
			/*report.log(LogStatus.INFO, "Step 9. Select Status from list");
			if(Status != "")
			{
				objMngPmntFiles.selectStatuslist(Status);
				report.log(LogStatus.PASS, "Step 9.1.Selected given Status from the list is "+Status);
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 9.1.Given Status from the list is not selected");
			}*/
			
			report.log(LogStatus.INFO, "Step 18. Click on Search button");
			objMngPmntFiles.clickSearchButton();
			
			report.log(LogStatus.INFO, "Step 19. Click on Action button and verify its navigated to Print Payment Documents page or not");
			PrintPaymentDocumentsPage objRcdPrint=objMngPmntFiles.clickActionButtn();
			if(objRcdPrint.isFormatBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 19.1.Navigation to Print Payment Documents Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 19.1.Navigation to Print Payment Documents Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 20. Click on Print button");
			objRcdPrint.clickPrintButton();
			
			report.log(LogStatus.INFO, "Step 21. Click on Confirmation Ok button and verify its navigated to Manage Payment File page or not");
			ManagePaymentFilesPage objMngPmntFile=objRcdPrint.clickConfOkButton();
			if(objMngPmntFile.isDoneBtnDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 21.1.Navigation to Manage Payment File Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 21.1.Navigation to  Manage Payment File Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 22. Click on Done button");
			objMngPmntFile.clickDoneButton();
			
	}

}
