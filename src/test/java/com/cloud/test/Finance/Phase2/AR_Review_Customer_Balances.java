package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.AccountsReceivablePage;
import com.cloud.pageobjects.Finance.ReviewCustomerAccountDetailsPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Review_Customer_Balances extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Review Customer Balances")
	public void Cloud_Review_Customer_Balances(String UserName,String Password,String Customer)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Accounts Receivable link and verify its navigated to Accounts Receivable Page or not");
		AccountsReceivablePage objAccRcvl=objHome.clickAccountsReceivable();
		if(objAccRcvl.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to AccountsReceivable Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Accounts Receivable Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objAccRcvl.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Review Customer Account Details link and verify its navigated to Review Customer Account Details page or not");
		ReviewCustomerAccountDetailsPage objReviewCustomer=objAccRcvl.clickReviewCustomerAccountDetailsLink();
			if(objReviewCustomer.isCustomerDisplayed()) 
			{
				report.log(LogStatus.PASS, "Step 7.1.Navigation to Review Customer Account Details Page is success");	
			}
			else
			{
				report.log(LogStatus.FAIL, "Step 7.1.Navigation to Review Customer Account Details Page is failed");	
			}
			
			report.log(LogStatus.INFO, "Step 8. Click in the Customer Value field. Enter the desired information into the Customer field. Enter a valid value");
			if(Customer!= "") {
				
				objReviewCustomer.enterCustomer(Customer);
				report.log(LogStatus.PASS, "Step 8.1.Customer Value is entered successfully: "+Customer);
			}else {
				report.log(LogStatus.FAIL, "Step 8.1.Customer Value is not entered");
			}
			
			report.log(LogStatus.INFO, "Step 9. Click on Search button");
			objReviewCustomer.clickSearchButton();
			
			report.log(LogStatus.INFO, "Step 10. Click on Done button");
			objReviewCustomer.clickDoneButton();
			
			
	}

}
