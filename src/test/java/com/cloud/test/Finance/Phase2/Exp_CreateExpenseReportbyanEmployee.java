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

public class Exp_CreateExpenseReportbyanEmployee extends BaseWebTest{
	
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create Expense Report by an Employee")
	public void Exp_ExpenseReportByEmp(String UserName,String Password,String Purpose,String SelectDate,String ExpenseType,String SearchExpenseLocation,String ExpenseLocation,String Amount,String Description,String AnotherSelectDate,String Type,String AnotherAmount,String AnotherDescription)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 6. Click the Create Expense Report button");
		objExp.clickCreateExpenseReportButton();
		
		report.log(LogStatus.INFO, "Step 7. Click in the Purpose field");
		report.log(LogStatus.INFO, "Step 8. Enter the desired information into the Purpose field");
		objExp.enterPurpose(Purpose);
		
		report.log(LogStatus.INFO, "Step 9. Click the Create button.");
		objExp.clickCreatetButton();
		
		report.log(LogStatus.INFO, "Step 10. Click the Select Date button.");
		objExp.clickSelectDateIcon();
		
		report.log(LogStatus.INFO, "Step 11. Select the appropriate date. ");
		objExp.selectDayFromSelectDate(SelectDate);
		
		report.log(LogStatus.INFO, "Step 12. Click the Type list.");
		report.log(LogStatus.INFO, "Step 13. Click the Airfare list item.");
		objExp.selectExpensesType(ExpenseType);
		
		report.log(LogStatus.INFO, "Step 14. Click the Expense Location list.");
		objExp.clickExpenseLocationLink();
		
		report.log(LogStatus.INFO, "Step 15. Click the Search... link.");
		objExp.clickSearchLink();
		
		report.log(LogStatus.INFO, "Step 16. Click in the Expense Location field.");
		report.log(LogStatus.INFO, "Step 17. Enter the desired information into the Expense Location field.");
		objExp.enterExpenseLocation(SearchExpenseLocation);
		
		report.log(LogStatus.INFO, "Step 18. Click the Search button.");
		objExp.clickSearchButton();
	
		report.log(LogStatus.INFO, "Step 19. Click the County, State, United States cell");
		objExp.selectLocationName(ExpenseLocation);
		
		report.log(LogStatus.INFO, "Step 20. Click the OK button.");
		objExp.clickLocationOkButton();
		
		report.log(LogStatus.INFO, "Step 21. Click in the Amount field.");
		report.log(LogStatus.INFO, "Step 22. Enter the desired information into the Amount field.");
		objExp.enterAmount(Amount);
		
		report.log(LogStatus.INFO, "Step 23. Click in the Description  field.");
		report.log(LogStatus.INFO, "Step 24. Enter the desired information into the Description field.");
		objExp.enterDescription(Description);
		
		report.log(LogStatus.INFO, "Step 25. Click the Create Another button");
		objExp.clickCreateAnotherButton();
	
		report.log(LogStatus.INFO, "Step 26. Click the Select Date button.");
		objExp.clickSelectDateIcon();
		
		report.log(LogStatus.INFO, "Step 27. Select the appropriate date. ");
		objExp.selectDayFromSelectDate(AnotherSelectDate);
		
		report.log(LogStatus.INFO, "Step 28. Click the Type list.");
		report.log(LogStatus.INFO, "Step 29. Click the Airfare list item.");
		objExp.selectExpensesType(Type);
		
		report.log(LogStatus.INFO, "Step 30. Click in the Amount field.");
		report.log(LogStatus.INFO, "Step 31. Enter the desired information into the Amount field.");
		objExp.enterAmount(AnotherAmount);
		
		report.log(LogStatus.INFO, "Step 32. Click in the Description  field.");
		report.log(LogStatus.INFO, "Step 33. Enter the desired information into the Description field.");
		objExp.enterDescription(AnotherDescription);
	
		report.log(LogStatus.INFO, "Step 34. Click the Close Menu");
		objExp.clickCloseMenu();
		
		report.log(LogStatus.INFO, "Step 35. Click the Save List Item");
		objExp.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 36. Click the Close button");
		objExp.clickCloseButton();
		
		report.log(LogStatus.INFO, "Step 37. Click on Submit button");
		objExp.clickSubmitButton();
				
	}

}
