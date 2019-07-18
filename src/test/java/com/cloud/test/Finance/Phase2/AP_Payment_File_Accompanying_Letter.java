package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreatePaymentFileAccompanyingLetter_BasicOptionsPage;
import com.cloud.pageobjects.Finance.OverviewPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Payment_File_Accompanying_Letter extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Submit Payment File Accompanying Letter")
	public void Cloud_Payment_File_Acc_Letter(String UserName,String Password,String PaymentFileReference)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Payment File Accompanying Letter link and verify its navigated to Create Payment File Accompanying Letter page or not");
		CreatePaymentFileAccompanyingLetter_BasicOptionsPage objCreatePmntLetter=objOverview.clickPaymentFileAccompanyingLetter();
			if(objCreatePmntLetter.isSearchPaymentFileIconDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Payment File Accompanying Letter Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Payment File Accompanying Letter Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Click on Payment File Search Icon");
			objCreatePmntLetter.clickSearchPaymentFileIcon();
			report.log(LogStatus.INFO, "Step 8.1. Click on Payment File Search link");
			objCreatePmntLetter.clickPaymentFileSearchLink();	
			report.log(LogStatus.INFO, "Step 8.2. Click in the Payment File Reference field. Enter the desired information into the Payment File Reference field. Enter a valid value");
			if(PaymentFileReference!= "") {
				
				objCreatePmntLetter.enterPaymentFileReference(PaymentFileReference);
				objCreatePmntLetter.clickAdminReferenceField();
				report.log(LogStatus.PASS, "Step 10.2.1.Payment File Reference is entered successfully: "+PaymentFileReference);
			}else {
				report.log(LogStatus.FAIL, "Step 10.2.1.Payment File Reference is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 8.3. Click on Payment File Reference Search button");
			objCreatePmntLetter.clickPaymentFileReferenceSearchButton();
			report.log(LogStatus.INFO, "Step 8.4. Select Payment File Reference");
			objCreatePmntLetter.selectPaymentFileReference(PaymentFileReference);
			report.log(LogStatus.INFO, "Step 8.5. Click on Payment File Reference Ok button");
			objCreatePmntLetter.clickPaymentFileReferenceOkButton();
			objCreatePmntLetter.clickSubmissionNotesField();
			
			report.log(LogStatus.INFO, "Step 9. Click on Submit button");
			objCreatePmntLetter.clickSubmitButton();
			
			report.log(LogStatus.INFO, "Step 10. Click on Confirmation Ok button");
			objCreatePmntLetter.clickConfOkButton();
			
	}
	
}
