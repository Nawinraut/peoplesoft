package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.ExpensesPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class Exp_ManageDelegatesby_an_Employee extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Manage Delegates by an Employee")
	public void Exp_ManageDelegatesByEmp(String UserName,String Password,String SearchPerson,String PersonName)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Expenses link and verify its navigated to Expenses Page or not");
		ExpensesPage objExp=objHome.clickExpenses();
		if(objExp.isDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Expenses Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Expenses Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click the Tasks button.");
		objExp.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click the Manage Delegates link.");
		objExp.clickManageDelegates();
		
		report.log(LogStatus.INFO, "Step 8. Click the Add button.");
		objExp.clickAddButton();
		
		report.log(LogStatus.INFO, "Step 9. Click the Search and Select: Person button.");
		objExp.clickSearchSelectIcon();
		
		report.log(LogStatus.INFO, "Step 10. Click in the Person field.");
		report.log(LogStatus.INFO, "Step 11. Enter the desired information into the Person field.");
		objExp.enterExpenseLocation(SearchPerson);
		
		report.log(LogStatus.INFO, "Step 12. Click the Search button.");
		objExp.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 14. Click the Person Name cell.");
		objExp.selectPersonName(PersonName);
		
		report.log(LogStatus.INFO, "Step 15. Click the OK button.");
		objExp.clickLocationOkButton();
		
		report.log(LogStatus.INFO, "Step 16. Click the Save List Item");
		objExp.clickSaveAndCloseButton();
				
	}

}
