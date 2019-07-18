package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreatePaymentFileAccompanyingLetter_BasicOptionsPage;
import com.cloud.pageobjects.Finance.ManagePaymentProcessRequestsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Payment_File_Accompanying_Letter extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Submit Payment File Accompanying Letter")
	public void AP_Payment_File_Acc_Letter(String UserName,String Password,String PaymentProcessName)throws TestException,InterruptedException, TestException {
		
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
		objMngRequest.enterName(PaymentProcessName);
		
		report.log(LogStatus.INFO, "Step 9. Click on Search button");
		objMngRequest.isSearchBtnDisplayed();
		objMngRequest.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 10. Fetch the Payment File Number");
		String PaymentFileReference =objMngRequest.fetchPaymentFileNumber();
		
		report.log(LogStatus.INFO, "Step 11. Click on Home Image icon");
		objHome.isHomeImageDisplayed();
		objHome.clickImgHome();
		
		report.log(LogStatus.INFO, "Step 12. Click on Navigator Icon");
		objHome.clickNavigatorIcon();
		
		report.log(LogStatus.INFO, "Step 13. Click on Payments link and verify its navigated to Overview Page or not");
		OverviewPage objOverview1=objHome.clickPayments();
		if(objOverview.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 13.1.Navigation to Overview Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 13.1.Navigation to Overview Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 14. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objOverview.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 15. Click on Create Payment File Accompanying Letter link and verify its navigated to Create Payment File Accompanying Letter page or not");
		CreatePaymentFileAccompanyingLetter_BasicOptionsPage objCreatePmntLetter=objOverview.clickPaymentFileAccompanyingLetter();
			if(objCreatePmntLetter.isSearchPaymentFileIconDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 15.1.Navigation to Create Payment File Accompanying Letter Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 15.1.Navigation to Create Payment File Accompanying Letter Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 16. Click on Payment File Search Icon");
			objCreatePmntLetter.clickSearchPaymentFileIcon();
			report.log(LogStatus.INFO, "Step 16.1. Click on Payment File Search link");
			objCreatePmntLetter.clickPaymentFileSearchLink();	
			report.log(LogStatus.INFO, "Step 16.2. Click in the Payment File Reference field. Enter the desired information into the Payment File Reference field. Enter a valid value");
			if(PaymentFileReference!= "") {
				
				objCreatePmntLetter.enterPaymentFileReference(PaymentFileReference);
				objCreatePmntLetter.clickAdminReferenceField();
				report.log(LogStatus.PASS, "Step 16.2.1.Payment File Reference is entered successfully: "+PaymentFileReference);
			}else {
				report.log(LogStatus.FAIL, "Step 16.2.1.Payment File Reference is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 16.3. Click on Payment File Reference Search button");
			objCreatePmntLetter.clickPaymentFileReferenceSearchButton();
			report.log(LogStatus.INFO, "Step 16.4. Select Payment File Reference");
			objCreatePmntLetter.selectPaymentFileReference(PaymentFileReference);
			report.log(LogStatus.INFO, "Step 16.5. Click on Payment File Reference Ok button");
			objCreatePmntLetter.clickPaymentFileReferenceOkButton();
			objCreatePmntLetter.clickSubmissionNotesField();
			
			report.log(LogStatus.INFO, "Step 17. Click on Submit button");
			objCreatePmntLetter.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 18. Click on Confirmation Ok button");
			objCreatePmntLetter.clickConfOkButton();
			
	}
	
}
