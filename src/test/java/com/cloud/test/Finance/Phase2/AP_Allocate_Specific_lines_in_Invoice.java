package com.cloud.test.Finance.Phase2;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.CreateInvoicePage;
import com.cloud.pageobjects.Finance.InvoicesPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.LogStatus;

public class AP_Allocate_Specific_lines_in_Invoice extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is How to Allocate Specific Lines in Invoice")
	public void Cloud_Allocate_Spec_Lines_Inv(String UserName,String Password,String BusinessUnit,String Supplier,String Number,String Amount,String TypeCell1,String TypeCell2,String TypeCell3,String AmountCell1,String AmountCell2,String AmountCell3,String DistributionCombinationValue1,String DistributionCombinationValue2,String FreightAmount,String FreightLineNumber,String Company,String Region,String Country,String Service,String Location,String Department,String NaturalAccountSearch1,String NaturalAccountLine1,String NaturalAccountSearch2,String NaturalAccountLine2,String Intercompany,String FundSource,String Future1)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Invoices link and verify its navigated to Invoices Page or not");
		InvoicesPage objInvoices=objHome.clickInvoices();
		if(objInvoices.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Invoices Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Invoices Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		objInvoices.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Invoices link and verify its navigated to Create Invoice page or not");
		CreateInvoicePage objCrtInvoice=objInvoices.clickCreateInvoiceLink();
		if(objCrtInvoice.isSelectBusinessUnitDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Invoice Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Invoice Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Select Bussiness Unit");
		objCrtInvoice.SelectBusinessUnit(BusinessUnit);
	
		report.log(LogStatus.INFO, "Step 9. Click on Supplier Search Icon");
		objCrtInvoice.isSearchSupplierIconDisplayed();
		objCrtInvoice.clickSearchSupplierIcon();
		
		report.log(LogStatus.INFO, "Step 10. Enter Supplier Name");
		objCrtInvoice.isSupplierDisplayed();
		objCrtInvoice.enterSupplier(Supplier);
		objCrtInvoice.clickSupplierNumber();
	
		report.log(LogStatus.INFO, "Step 11. Click on Supplier Search Button");
		objCrtInvoice.isSupplierSearchBtnDisplayed();
		objCrtInvoice.clickSupplierSearchButton(Supplier);
		
		report.log(LogStatus.INFO, "Step 12. Select Supplier Cell");
		objCrtInvoice.selectEvent(Supplier);
		
		report.log(LogStatus.INFO, "Step 13. Click on Supplier Ok Button");
		objCrtInvoice.isSupplierOkBtnDisplayed();
		objCrtInvoice.clickSupplierOkButton();
		
		report.log(LogStatus.INFO, "Step 14. Enter the Number in Number text field");
		objCrtInvoice.isNumberDisplayed();
		objCrtInvoice.enterNumber(Number);
		
		report.log(LogStatus.INFO, "Step 15. Enter the Amount in Amount text field");
		objCrtInvoice.isAmountDisplayed();
		objCrtInvoice.enterAmount(Amount);
		objCrtInvoice.clickExpandLinesIcon();
		
		// Line Number 1
		
		int LineNumber=1;
		report.log(LogStatus.INFO, "Step 16. Select Type List from Line1");
		if(TypeCell1!= "") {
			objCrtInvoice.selectDistCombinationType(LineNumber,TypeCell1);
			report.log(LogStatus.PASS, "Step 16.1.Selected given Type from the list is "+TypeCell1);
		}else {
			report.log(LogStatus.FAIL, "Step 16.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 17.1. Click in the Distribution Combination Amount field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(AmountCell1!= "") {
			
			objCrtInvoice.enterDistCombinationAmount(LineNumber,AmountCell1);
			report.log(LogStatus.PASS, "Step 17.1.Distribution Combination Amount is entered successfully: "+AmountCell1);
		}else {
			report.log(LogStatus.FAIL, "Step 17.1.Distribution Combination Amount is not entered");
		}
		
		//String DistributionCombinationValue1 ="10.01.01.01.01.01.671500.00.000.0000";
		
		report.log(LogStatus.INFO, "Step 18. Click in the Distribution Combination Value field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(DistributionCombinationValue1!= "") {
			
			objCrtInvoice.enterDistCombinationValue(LineNumber,DistributionCombinationValue1);
			report.log(LogStatus.PASS, "Step 18.1.Distribution Combination Value is entered successfully: "+DistributionCombinationValue1);
		}else {
			report.log(LogStatus.FAIL, "Step 18.1.Distribution Combination Value is not entered");
		}
		
		/*report.log(LogStatus.INFO, "Step 18. Click on DistCombinationIcon");
		objCrtInvoice.clickDistCombinationIcon(LineNumber);
		
		report.log(LogStatus.INFO, "Step 19. Click on Company Search Icon");
		objCrtInvoice.isCompanySearchIconDisplayed();
		objCrtInvoice.clickCompanySearchIcon();
		objCrtInvoice.verifySearchEvent(Company);
		report.log(LogStatus.INFO, "Step 20. Select Company from dropdown");
		objCrtInvoice.selectEvent(Company);
		//objCrtInvoice.verifyEvent(Company);
		
		report.log(LogStatus.INFO, "Step 21. Click on  Region Search Icon");
		objCrtInvoice.isRegionSearchIconDisplayed();
		objCrtInvoice.clickRegionSearchIcon();
		objCrtInvoice.verifySearchEvent(Region);
		report.log(LogStatus.INFO, "Step 22. Select Region from dropdown");
		objCrtInvoice.selectEvent(Region);
		//objCrtInvoice.verifyEvent(Region);
		
		report.log(LogStatus.INFO, "Step 23. Click on Country Search Icon");
		objCrtInvoice.isCountrySearchIconDisplayed();
		objCrtInvoice.clickCountrySearchIcon();
		objCrtInvoice.verifySearchEvent(Country);
		report.log(LogStatus.INFO, "Step 24. Select Country from dropdown");
		objCrtInvoice.selectEvent(Country);
		//objCrtInvoice.verifyEvent(Country);
		
		report.log(LogStatus.INFO, "Step 25. Click on Service Search Icon");
		objCrtInvoice.isServiceSearchIconDisplayed();
		objCrtInvoice.clickServiceSearchIcon();
		objCrtInvoice.verifySearchEvent(Service);
		report.log(LogStatus.INFO, "Step 26. Select Service from dropdown");
		objCrtInvoice.selectEvent(Service);
		//objCrtInvoice.verifyEvent(Service);
		
		report.log(LogStatus.INFO, "Step 27. Click on Location Search Icon");
		objCrtInvoice.isLocationSearchIconDisplayed();
		objCrtInvoice.clickLocationSearchIcon();
		objCrtInvoice.verifySearchEvent(Location);
		report.log(LogStatus.INFO, "Step 28. Select Location from dropdown");
		//SeleniumUtils.delay(5000);
		objCrtInvoice.selectEvent(Location);
		SeleniumUtils.delay(3000);
		//objCrtInvoice.verifyEvent(Location);
		
		report.log(LogStatus.INFO, "Step 29. Click on Department Search Icon");
		objCrtInvoice.isDepartmentSearchIconDisplayed();
		objCrtInvoice.clickDepartmentSearchIcon();
		objCrtInvoice.verifySearchEvent(Department);
		report.log(LogStatus.INFO, "Step 30. Select Department from dropdown");
		objCrtInvoice.selectEvent(Department);
		//objCrtInvoice.verifyEvent(Department);
		SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 31. Click on Natural Account Search Icon");
		objCrtInvoice.clickNaturalAccountSearchIcon();
		report.log(LogStatus.INFO, "Step 32. Verify that Natural Account Search link");
		objCrtInvoice.isAccountSearchLinkDisplayed();
		report.log(LogStatus.INFO, "Step 33. Click on Natural Account Search link");
		objCrtInvoice.clickAccountSearchLink();
		report.log(LogStatus.INFO, "Step 34. Enter the Natural Account Value in Value text field");
		//objCrtInvoice.enterAccountValue(NaturalAccountSearch1);
		objCrtInvoice.enterAccountValue(NaturalAccountLine1);
		report.log(LogStatus.INFO, "Step 35. Click on Natural Account Search button");
		objCrtInvoice.clickAccountSearchButton();
		report.log(LogStatus.INFO, "Step 36. Select Department from dropdown");
		//objCrtInvoice.selectNaturalAccountFromTable(NaturalAccountLine1);
		objCrtInvoice.selectEvent(NaturalAccountLine1);
		report.log(LogStatus.INFO, "Step 37. Click on Natural Account Ok button");
		objCrtInvoice.isAccountOkButtonDisplayed();
		objCrtInvoice.clickAccountOkButton();
		
		report.log(LogStatus.INFO, "Step 38. Click on Intercompany Search Icon");
		objCrtInvoice.isIntercompanySearchIconDisplayed();
		objCrtInvoice.clickIntercompanySearchIcon();
		report.log(LogStatus.INFO, "Step 39. Select Intercompany from dropdown");
		objCrtInvoice.selectEvent(Intercompany);
		SeleniumUtils.delay(5000);
		//objCrtInvoice.verifyEvent(Intercompany);

		report.log(LogStatus.INFO, "Step 40. Click on FundSource Search Icon");
		objCrtInvoice.isFundSourceSearchIconDisplayed();
		objCrtInvoice.clickFundSourceSearchIcon();
		report.log(LogStatus.INFO, "Step 41. Select FundSource from dropdown");
		objCrtInvoice.selectEvent(FundSource);
		//objCrtInvoice.verifyEvent(FundSource);
		
		report.log(LogStatus.INFO, "Step 42. Click on Future1 Search Icon");
		objCrtInvoice.isFuture1SearchIconDisplayed();
		objCrtInvoice.clickFuture1SearchIcon();
		report.log(LogStatus.INFO, "Step 43. Select Future1 from dropdown");
		objCrtInvoice.selectEvent(Future1);
		//objCrtInvoice.verifyEvent(Future1);
		//SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 44. Click on Distribution Combination Pop-Up Ok button");
		objCrtInvoice.clickDistCombinationPopUpOkButton(LineNumber);*/
		
		// Line Number 2
		
		LineNumber=2;
		report.log(LogStatus.INFO, "Step 19. Select Type List from Line2");
		if(TypeCell2!= "") {
			objCrtInvoice.clickDistCombinationType(LineNumber);
			objCrtInvoice.selectDistCombinationType(LineNumber,TypeCell2);
			report.log(LogStatus.PASS, "Step 19.1.Selected given Type from the list is "+TypeCell2);
		}else {
			report.log(LogStatus.FAIL, "Step 19.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 20. Click in the Distribution Combination Amount field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(AmountCell2!= "") {
			
			objCrtInvoice.enterDistCombinationAmount(LineNumber,AmountCell2);
			report.log(LogStatus.PASS, "Step 20.1.Distribution Combination Amount is entered successfully: "+AmountCell2);
		}else {
			report.log(LogStatus.FAIL, "Step 20.1.Distribution Combination Amount is not entered");
		}
		
		//String DistributionCombinationValue2 ="10.01.01.01.01.01.671500.00.000.0000";
		
		report.log(LogStatus.INFO, "Step 22. Click in the Distribution Combination Value field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(DistributionCombinationValue2!= "") {
			
			objCrtInvoice.enterDistCombinationValue(LineNumber,DistributionCombinationValue2);
			report.log(LogStatus.PASS, "Step 22.1.Distribution Combination Value is entered successfully: "+DistributionCombinationValue2);
		}else {
			report.log(LogStatus.FAIL, "Step 22.1.Distribution Combination Value is not entered");
		}
		
		/*report.log(LogStatus.INFO, "Step 47. Click on DistCombination Icon");
		objCrtInvoice.clickDistCombinationIcon(LineNumber);
		
		report.log(LogStatus.INFO, "Step 48. Click on Company Search Icon");
		objCrtInvoice.isCompanySearchIconDisplayed();
		objCrtInvoice.clickCompanySearchIcon();
		objCrtInvoice.verifySearchEvent(Company);
		report.log(LogStatus.INFO, "Step 49. Select Company from dropdown");
		objCrtInvoice.selectEvent(Company);
		//objCrtInvoice.verifyEvent(Company);
		
		report.log(LogStatus.INFO, "Step 50. Click on  Region Search Icon");
		objCrtInvoice.isRegionSearchIconDisplayed();
		objCrtInvoice.clickRegionSearchIcon();
		objCrtInvoice.verifySearchEvent(Region);
		report.log(LogStatus.INFO, "Step 51. Select Region from dropdown");
		objCrtInvoice.selectEvent(Region);
		//objCrtInvoice.verifyEvent(Region);
		
		report.log(LogStatus.INFO, "Step 52. Click on Country Search Icon");
		objCrtInvoice.isCountrySearchIconDisplayed();
		objCrtInvoice.clickCountrySearchIcon();
		objCrtInvoice.verifySearchEvent(Country);
		report.log(LogStatus.INFO, "Step 53. Select Country from dropdown");
		objCrtInvoice.selectEvent(Country);
		//objCrtInvoice.verifyEvent(Country);
		
		report.log(LogStatus.INFO, "Step 54. Click on Service Search Icon");
		objCrtInvoice.isServiceSearchIconDisplayed();
		objCrtInvoice.clickServiceSearchIcon();
		objCrtInvoice.verifySearchEvent(Service);
		report.log(LogStatus.INFO, "Step 55. Select Service from dropdown");
		objCrtInvoice.selectEvent(Service);
		//objCrtInvoice.verifyEvent(Service);
		
		report.log(LogStatus.INFO, "Step 56. Click on Location Search Icon");
		objCrtInvoice.isLocationSearchIconDisplayed();
		objCrtInvoice.clickLocationSearchIcon();
		objCrtInvoice.verifySearchEvent(Location);
		report.log(LogStatus.INFO, "Step 57. Select Location from dropdown");
		//SeleniumUtils.delay(5000);
		objCrtInvoice.selectEvent(Location);
		SeleniumUtils.delay(3000);
		//objCrtInvoice.verifyEvent(Location);
		
		report.log(LogStatus.INFO, "Step 58. Click on Department Search Icon");
		objCrtInvoice.isDepartmentSearchIconDisplayed();
		objCrtInvoice.clickDepartmentSearchIcon();
		objCrtInvoice.verifySearchEvent(Department);
		report.log(LogStatus.INFO, "Step 59. Select Department from dropdown");
		objCrtInvoice.selectEvent(Department);
		//objCrtInvoice.verifyEvent(Department);
		SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 60. Click on Natural Account Search Icon");
		objCrtInvoice.clickNaturalAccountSearchIcon();
		report.log(LogStatus.INFO, "Step 61. Verify that Natural Account Search link");
		objCrtInvoice.isAccountSearchLinkDisplayed();
		report.log(LogStatus.INFO, "Step 62. Click on Natural Account Search link");
		objCrtInvoice.clickAccountSearchLink();
		report.log(LogStatus.INFO, "Step 63. Enter the Natural Account Value in Value text field");
		//objCrtInvoice.enterAccountValue(NaturalAccountSearch2);
		objCrtInvoice.enterAccountValue(NaturalAccountLine2);
		report.log(LogStatus.INFO, "Step 64. Click on Natural Account Search button");
		objCrtInvoice.clickAccountSearchButton();
		report.log(LogStatus.INFO, "Step 65. Select Department from dropdown");
		//objCrtInvoice.selectNaturalAccountFromTable(NaturalAccountLine1);
		objCrtInvoice.selectEvent(NaturalAccountLine2);
		report.log(LogStatus.INFO, "Step 67. Click on Natural Account Ok button");
		objCrtInvoice.isAccountOkButtonDisplayed();
		objCrtInvoice.clickAccountOkButton();
		
		report.log(LogStatus.INFO, "Step 68. Click on Intercompany Search Icon");
		objCrtInvoice.isIntercompanySearchIconDisplayed();
		objCrtInvoice.clickIntercompanySearchIcon();
		report.log(LogStatus.INFO, "Step 69. Select Intercompany from dropdown");
		objCrtInvoice.selectEvent(Intercompany);
		SeleniumUtils.delay(5000);
		//objCrtInvoice.verifyEvent(Intercompany);

		report.log(LogStatus.INFO, "Step 70. Click on FundSource Search Icon");
		objCrtInvoice.isFundSourceSearchIconDisplayed();
		objCrtInvoice.clickFundSourceSearchIcon();
		report.log(LogStatus.INFO, "Step 71. Select FundSource from dropdown");
		objCrtInvoice.selectEvent(FundSource);
		//objCrtInvoice.verifyEvent(FundSource);
		
		report.log(LogStatus.INFO, "Step 72. Click on Future1 Search Icon");
		objCrtInvoice.isFuture1SearchIconDisplayed();
		objCrtInvoice.clickFuture1SearchIcon();
		report.log(LogStatus.INFO, "Step 73. Select Future1 from dropdown");
		objCrtInvoice.selectEvent(Future1);
		//objCrtInvoice.verifyEvent(Future1);
		//SeleniumUtils.delay(3000);
		
		report.log(LogStatus.INFO, "Step 74. Click on Distribution Combination Pop-Up Ok button");
		objCrtInvoice.clickDistCombinationPopUpOkButton(LineNumber);*/
		
		// Line Number 3
		LineNumber=3;
		report.log(LogStatus.INFO, "Step 23. Select Type List from Line3");
		if(TypeCell3!= "") {
			objCrtInvoice.clickDistCombinationType(LineNumber);
			objCrtInvoice.selectDistCombinationType(LineNumber,TypeCell3);
			report.log(LogStatus.PASS, "Step 23.1.Selected given Type from the list is "+TypeCell3);
		}else {
			report.log(LogStatus.FAIL, "Step 23.1.Given Type from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 24. Click in the Distribution Combination Amount field. Enter the desired information into the Distribution Combination field. Enter a valid value");
		if(AmountCell3!= "") {
			
			objCrtInvoice.clickDistCombinationAmount_Freight(LineNumber,AmountCell3);
			report.log(LogStatus.PASS, "Step 24.1.Distribution Combination Amount is entered successfully: "+AmountCell3);
		}else {
			report.log(LogStatus.FAIL, "Step 24.1.Distribution Combination Amount is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 25.Click on Allocate Menu");
		objCrtInvoice.clickAllocateMenu();
		
		
		report.log(LogStatus.INFO, "Step 26. Click on Specific Lines from Allocate Menu");
		objCrtInvoice.clickSpecificLinesList();
		
		
		report.log(LogStatus.INFO, "Step 27. Click in the Freight Amount field. Enter the desired information into the Freight Amount field. Enter a valid value");
		if(FreightAmount!= "") {
			int LineNum = Integer.parseInt(FreightLineNumber);
			objCrtInvoice.enterAllocateFreightAmountCell(LineNum,FreightAmount);
			//objCrtInvoice.enterAllocateFreightAmount(LineNum,FreightAmount);
			report.log(LogStatus.PASS, "Step 27.1.Freight Amount is entered successfully: "+FreightAmount);
		}else {
			report.log(LogStatus.FAIL, "Step 27.1.Freight Amount is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 28. Click on Save and Close button in Allocate Freight Pop Up");
		objCrtInvoice.clickSaveAndClose_AllocateFreightButton();
		
		report.log(LogStatus.INFO, "Step 29. Click on Infirmation Ok button");
		objCrtInvoice.clickInformationOkButton();
		
		objCrtInvoice.clickSaveButton();
		
		report.log(LogStatus.INFO, "Step 30. Click on Actions Menu");
		objCrtInvoice.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 31. Click on Velidate list");
		objCrtInvoice.selectValidateMenu();
		
		report.log(LogStatus.INFO, "Step 32. Click on Infirmation Ok button");
		objCrtInvoice.clickInformationOkButton();
		
		report.log(LogStatus.INFO, "Step 33. Click on Save and Close button");
		objCrtInvoice.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 34. Click on Infirmation Ok button");
		objCrtInvoice.clickInformationOkButton();
	}

}
