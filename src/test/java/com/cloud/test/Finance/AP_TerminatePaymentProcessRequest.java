/**
Test Name: TC_TerminatePaymentProcessRequest
 Created By: Ciber
 Creation Date:May 22,2018
 Modified By:
 Modified Date:
 Test Description: This script is used for to Terminate Payment Process Request
 Prerequisite: Test data should be proper before running this script
 */
package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.SignOffPage;
import com.cloud.pageobjects.Finance.ManagePaymentFilesPage;
import com.cloud.pageobjects.Finance.ManagePaymentProcessRequestsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.pageobjects.Finance.PaymentFilePage;
import com.cloud.pageobjects.Finance.PrintPaymentDocumentsPage;
import com.cloud.pageobjects.Finance.ReviewInstallmentsPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class AP_TerminatePaymentProcessRequest extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass = DataProviderRepository.class, description = "This test is to Terminate Payment Process Request")
	public void AP_Terminate_Pmt_Pro_Request(String UserName,String Password,String Name,String CreationDate)throws TestException,InterruptedException, TestException {
		sAssert=new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		LoginPage objLogin = new LoginPage(driver, report);
	
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		
		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");

		HomePage objHome =objLogin.loginToCloudApplication(UserName,Password);
		sAssert.assertTrue(objHome.isHomeImageDisplayed());
		
		report.log(LogStatus.INFO, "Step 3. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 4. Click on Payments link");
		OverviewPage objOverview=objHome.clickPayments();
		
		report.log(LogStatus.INFO, "Step 5. Click on Taksks button ");
		sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 6. Click on Manage Payment Process Requests link");
		objOverview.isManagePaymentProcessRequestsLinkDisplayed(); 
		ManagePaymentProcessRequestsPage objMngRequest=objOverview.clickManagePaymentProcessRequestsLink();
		
		report.log(LogStatus.INFO, "Step 7. Enter Name in Name field");
		objMngRequest.isNameDisplayed();
		objMngRequest.enterName(Name);
		
		
		if (CreationDate!=""){
		report.log(LogStatus.INFO, "Step 8. Click on Creation Date button");
		objMngRequest.isCreationDateBtnDisplayed();
		objMngRequest.clickCreationDateButton();
		
			String creationDateParts[] = CreationDate.split("-");
			String creationMonth  = creationDateParts[0];
			String creationDay  = creationDateParts[1];
			String creationYear = creationDateParts[2];
			report.log(LogStatus.INFO, "Step 9. Select Month and Creation Date from Calendar");
			objMngRequest.isCreationDateMonthDisplayed();
			objMngRequest.selectCreationDateMonth(creationMonth);
			objMngRequest.selectCreationDate(creationDay);	
		}
		
		report.log(LogStatus.INFO, "Step 10. Click on Search button");
		objMngRequest.isSearchBtnDisplayed();
		objMngRequest.clickSearchButton();

		report.log(LogStatus.INFO, "Step 11. Click on Action Image");
		objMngRequest.isActionImageDisplayed();
		PaymentFilePage objPmntFile=objMngRequest.clickActionImg();
		
		report.log(LogStatus.INFO, "Step 12. Click on Action Menu");
		objPmntFile.isActionMenuDisplayed();
		objPmntFile.clickActionMenu();
		
		report.log(LogStatus.INFO, "Step 13. Click on Terminate Payment Process List");
		objPmntFile.isTerminatePaymentProcessListDisplayed();
		objPmntFile.clickTerminatePaymentProcessList();
		
		report.log(LogStatus.INFO, "Step 14. Click on Terminated Confirmation Ok Button");
		objPmntFile.isTerminatedOkBtnDisplayed();
		objPmntFile.clickTerminatedOkButton();
		
		report.log(LogStatus.INFO, "Step 15. Click on Confirmation Ok Button");
		objPmntFile.clickConfOkButton();
		
		sAssert.assertAll();
	}

}
