package com.cloud.test.Finance;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HomePage;
import com.cloud.pageobjects.LoginPage;
import com.cloud.pageobjects.Finance.BillingPage;
import com.cloud.pageobjects.Finance.CreateOrganizationCustomerPage;
import com.cloud.pageobjects.Finance.CreateSiteProfilePage;
import com.cloud.pageobjects.Finance.EditAccountPage;
import com.cloud.pageobjects.Finance.EditSitePage;
import com.cloud.pageobjects.Finance.ManageCustomersPage;
import com.cloud.util.DataProviderRepository;
import com.relevantcodes.extentreports.LogStatus;

public class AR_Create_Customer extends BaseWebTest{
	SoftAssert sAssert;
	public WebDriverWait wdwait;
	
	@Test(dataProvider = "CloudDataProviderUtil_Finance", dataProviderClass =DataProviderRepository.class, description = "This test is How to Create a Credit Memo Transaction")
	public void AR_Create_Customer(String UserName,String Password,String Name,String AccountDescription,String AccountAddressSet,String SiteName,String AddressLine1,String City,String CityName,String PostalCode,String SiteLanguage,String Purpose1,String Purpose2,String BilltoSite,String OrganizationName,String ProfileClass)throws TestException,InterruptedException, TestException {
		
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
		
		report.log(LogStatus.INFO, "Step 5. Click on Billing link and verify its navigated to Billing Page or not");
		BillingPage objBilling=objHome.clickBilling();
		if(objBilling.isTasksBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 5.1.Navigation to Accounts Receivable Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 5.1.Navigation to Accounts Receivable Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 6. Click on Taksks button ");
		//sAssert.assertTrue(objOverview.isTasksBtnDisplayed());
		objBilling.clickTasksButton();
		
		report.log(LogStatus.INFO, "Step 7. Click on Create Customer link and verify its navigated to Create Customer page or not");
		CreateOrganizationCustomerPage objCrtOrgCust=objBilling.clickCreateCustomerLink();
		if(objCrtOrgCust.isNameFieldDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 7.1.Navigation to Create Organization Customer Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 7.1.Navigation to Create Organization Customer Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 8. Click in the Name field. Enter the desired information into the Name field. Enter a valid value");
		if(Name!= "") {
			objCrtOrgCust.enterName(Name);
			report.log(LogStatus.PASS, "Step 8.1.Name is entered successfully: "+Name);
		}else {
			report.log(LogStatus.FAIL, "Step 8.1.Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 9. Click in the Account Description field. Enter the desired information into the Account Description field. Enter a valid value");
		if(AccountDescription!= "") {
			objCrtOrgCust.enterAccountDescription(AccountDescription);
			report.log(LogStatus.PASS, "Step 9.1.Account Description is entered successfully: "+AccountDescription);
		}else {
			report.log(LogStatus.FAIL, "Step 9.1.Account Description is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 10. Select Account Address Set from list");
		if(AccountAddressSet != "")
		{
			objCrtOrgCust.selectAccountAddressSet(AccountAddressSet);
			report.log(LogStatus.PASS, "Step 10.1.Selected given Account Address Set from the list is "+AccountAddressSet);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 10.1.Given Account Address Set from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 11. Click in the Site Name field. Enter the desired information into the Site Name field. Enter a valid value");
		if(SiteName!= "") {
			objCrtOrgCust.enterSiteName(SiteName);
			report.log(LogStatus.PASS, "Step 11.1.Site Name is entered successfully: "+SiteName);
		}else {
			report.log(LogStatus.FAIL, "Step 11.1.Site Name is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 12. Click in the Address Line 1  field. Enter the desired information into the Address Line 1 field. Enter a valid value");
		if(AddressLine1 != "") {
			objCrtOrgCust.enterAddressLine1(AddressLine1);
			report.log(LogStatus.PASS, "Step 12.1.Address Line 1 is entered successfully: "+AddressLine1 );
		}else {
			report.log(LogStatus.FAIL, "Step 12.1.Address Line 1  is not entered");
		}
		
		// City
		report.log(LogStatus.INFO, "Step 13. Click on City search icon");
		objCrtOrgCust.clickSearchCityIcon();
		report.log(LogStatus.INFO, "Step 13.1. Click on City search link");
		objCrtOrgCust.clickSearchCityLink();
		report.log(LogStatus.INFO, "Step 13.2. Click in the City field. Enter the desired information into the City field. Enter a valid value");
		objCrtOrgCust.enterCity(City);
		report.log(LogStatus.INFO, "Step 13.3. Click on City search button");
		objCrtOrgCust.clickCitySearchButton(CityName);
		report.log(LogStatus.INFO, "Step 13.4. Select City from list");
		objCrtOrgCust.selectCity(CityName);
		report.log(LogStatus.INFO, "Step 13.5. Click on City Ok button");
		objCrtOrgCust.clickCityOkButton();
		
		report.log(LogStatus.INFO, "Step 14. Click in the Postal Code field. Enter the desired information into the Postal Code field. Enter a valid value");
		if(PostalCode != "") {
			objCrtOrgCust.enterPostalCode(PostalCode);
			report.log(LogStatus.PASS, "Step 14.1.Postal Code is entered successfully: "+PostalCode);
		}else {
			report.log(LogStatus.PASS, "Step 14.1.Postal Code  is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 15. Select SiteLanguage Set from list");
		if(SiteLanguage != "")
		{
			objCrtOrgCust.SelectSiteLanguage(SiteLanguage);
			report.log(LogStatus.PASS, "Step 15.1.Selected given Site Language from the list is "+SiteLanguage);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 15.1.Given Site Language from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 16. Click on Add Row button");
		objCrtOrgCust.clickAddRowButton();
		
		report.log(LogStatus.INFO, "Step 16. Select Purpose Set from list");
		if(Purpose1 != "")
		{
			objCrtOrgCust.SelectPurpose_R1(Purpose1);
			report.log(LogStatus.PASS, "Step 17.1.Selected given Purpose from the list is "+Purpose1);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 17.1.Given Purpose from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 18. Click on Add Row button");
		objCrtOrgCust.clickAddRowButton();
		
		report.log(LogStatus.INFO, "Step 19. Select Purpose Set from list");
		if(Purpose2 != "")
		{
			objCrtOrgCust.SelectPurpose_R2(Purpose2);
			report.log(LogStatus.PASS, "Step 19.1.Selected given Purpose from the list is "+Purpose2);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 19.1.Given Purpose from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 20. Select BilltoSite from list");
		if(BilltoSite != "")
		{
			objCrtOrgCust.SelectBilltoSite_R2(BilltoSite);
			report.log(LogStatus.PASS, "Step 20.1.Selected given Bill to Site from the list is "+BilltoSite);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 20.1.Given Bill to Site from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 21. Click on Save and Close button and verify its navigated to Manage Customers page or not");
		ManageCustomersPage objMngCustomer=objCrtOrgCust.clickSaveAndCloseButton();
		if(objMngCustomer.isOrganizationNameFieldDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 21.1.Navigation to Manage Customers Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 21.1.Navigation to Manage Customers Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 22. Click in the Organization Name field. Enter the desired information into the Organization Name field. Enter a valid value");
		if(OrganizationName != "") {
			objMngCustomer.enterOrganizationName(OrganizationName);
			report.log(LogStatus.PASS, "Step 22.1.Organization Name is entered successfully: "+OrganizationName);
		}else {
			report.log(LogStatus.PASS, "Step 22.1.Organization Name  is not entered");
		}
		
		report.log(LogStatus.INFO, "Step 23. Click on Search button");
		objMngCustomer.clickSearchButton();
		
		report.log(LogStatus.INFO, "Step 24. Click on Account Number link and verify its navigated to Edit Account page or not");
		EditAccountPage objEdtAccount=objMngCustomer.clickAccountNumberLink();
		if(objEdtAccount.isProfileHistoryLnkDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 24.1.Navigation to Edit Account Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 24.1.Navigation to Edit Account Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 25. Click on Profile History link");
		objEdtAccount.clickProfileHistoryLink();
		
		report.log(LogStatus.INFO, "Step 25. Click on Actions menu");
		objEdtAccount.clickActionsMenu();
		
		report.log(LogStatus.INFO, "Step 26. Click on Correct Record list");
		objEdtAccount.selectCorrectRecordList();
		
		report.log(LogStatus.INFO, "Step 27. Select Profile Class from list");
		if(ProfileClass != "")
		{
			objEdtAccount.selectProfileClassList(ProfileClass);
			report.log(LogStatus.PASS, "Step 27.1.Selected given Profile Class from the list is "+ProfileClass);
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 27.1.Given Profile Class from the list is not selected");
		}
		
		report.log(LogStatus.INFO, "Step 28. Click on Warning Yes button");
		objEdtAccount.clickWarningYesButton();
		
		report.log(LogStatus.INFO, "Step 29. Click on Save and Close button and verify its navigated to Manage Customers page or not");
		ManageCustomersPage objMngCustomerAc=objEdtAccount.clickSaveAndCloseButton();
		if(objMngCustomerAc.isSiteNumberLnkDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 29.1.Navigation to Manage Customers Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 29.1.Navigation to Manage Customers Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 30. Click on Account Number link and verify its navigated to Edit Account page or not");
		EditSitePage objEdtSite=objMngCustomerAc.clickSiteNumberLink();
		if(objEdtSite.isProfileHistoryLnkDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 30.1.Navigation to Edit Account Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 30.1.Navigation to Edit Account Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 31. Click on Profile History link");
		objEdtSite.clickProfileHistoryLink();
		
		report.log(LogStatus.INFO, "Step 32. Click on Create Site Profile button and verify its navigated to Create Site Profile page or not");
		CreateSiteProfilePage objCrtSiteProf=objEdtSite.clickCreateSiteProfileButton();
		if(objCrtSiteProf.isSaveAndCloseBtnDisplayed()) 
		{
			report.log(LogStatus.PASS, "Step 32.1.Navigation to Create Site Profile Page is success");	
		}
		else
		{
			report.log(LogStatus.FAIL, "Step 32.1.Navigation to Create Site Profile Page is failed");	
		}
		
		report.log(LogStatus.INFO, "Step 33. Click on Save and Close button");
		objCrtSiteProf.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 34. Click on Save and Close button");
		objEdtSite.clickSaveAndCloseButton();
		
		report.log(LogStatus.INFO, "Step 35. Click onDone button");
		objMngCustomer.clickDoneButton();
		
	}

}
