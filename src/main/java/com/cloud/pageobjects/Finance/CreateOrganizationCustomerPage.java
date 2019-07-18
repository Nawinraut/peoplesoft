package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateOrganizationCustomerPage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt_r1:0:inputText123::content')]")
    private WebElement txtName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt_r2:0:inputText2::content')]")
    private WebElement txtAccountDescription;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt_r3:0:setIdLovId::content')]")
    private WebElement inputAccountAddressSet;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt_r3:0:dynam1:0:inputText13::content')]")
    private WebElement txtSiteName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':s2:i1:2:inputText2::content')]")
    private WebElement txtAddressLine1;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ListOfValues3::lovIconId')]")
    private WebElement iconSrchCity;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ComboboxListOfValues3::dropdownPopup::popupsearch')]")
    private WebElement lnkSrchCity;
 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtCity;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnCitySearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'::lovDialogId::ok')]")
	    private WebElement btnCityOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'s2:i1:5:inputText7::content')]")
	    private WebElement txtPostalCode;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'inputText12::content')]")
	    private WebElement selectSiteLanguage;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AT1:_ATp:create::icon')]")
	    private WebElement btnAddRow;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'_ATp:table1:0:SiteUseCode::content')]")
	    private WebElement selectPurpose_r1;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'_ATp:table1:1:SiteUseCode::content')]")
	    private WebElement selectPurpose_r2;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table1:1:billToSiteUseIdId::content')]")
	    private WebElement inputBilltoSite_r2;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:cucommandButton2')]")
	    private WebElement btnSaveAndClose;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'dynam1:1:commandButton2')]")
	    private WebElement btnOk_Waring;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public CreateOrganizationCustomerPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(txtName));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Create Organization Customer Page *****************************");
		       this.getScreenDetails();
		    }
	    
	  //Enter text into Name field
		   public void enterName(String strSupplier){
			   txtName.clear();
			   txtName.click();
			   txtName.sendKeys(strSupplier);
			   txtName.click();
			  
		   }
		   
		   public boolean isNameFieldDisplayed(){
			   return txtName.isDisplayed();
			   }
		   
		 //Enter text into Account Description field
		   public void enterAccountDescription(String strSupplier){
			   txtAccountDescription.clear();
			   txtAccountDescription.click();
			   txtAccountDescription.sendKeys(strSupplier);
			   
			  
		   }
		   
		   public boolean isNameAccountDescriptionFieldDisplayed(){
			   return txtAccountDescription.isDisplayed();
			   }
		   
		   //Select Account Address Set
		   public void selectAccountAddressSet(String strSupplier){
			   inputAccountAddressSet.clear();
			   inputAccountAddressSet.click();
			   inputAccountAddressSet.sendKeys(strSupplier);
			   inputAccountAddressSet.sendKeys(Keys.ENTER);
			   inputAccountAddressSet.click();
			  
		   }
		   
		   public boolean isAccountAddressSetFieldDisplayed(){
			   return inputAccountAddressSet.isDisplayed();
			   }
	    
		 //Enter text into txtSiteName
		   public void enterSiteName(String strSupplier){
			   txtSiteName.clear();
			   txtSiteName.click();
			   txtSiteName.sendKeys(strSupplier);
			   
			  
		   }
		   
		   public boolean isSiteNameFieldDisplayed(){
			   return txtSiteName.isDisplayed();
			   }
		   
		 //Enter text into txtAddressLine1
		   public void enterAddressLine1(String strSupplier){
			   txtAddressLine1.clear();
			   txtAddressLine1.click();
			   txtAddressLine1.sendKeys(strSupplier);
			   
			  
		   }
		   
		   public boolean isAddressLine1FieldDisplayed(){
			   return txtAddressLine1.isDisplayed();
			   }
		   
		// Search: City Icon
		   
		   public void clickSearchCityIcon(){	
			   iconSrchCity.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lnkSrchCity));
			    
			   
		   }
		   
		   public boolean isSearchCityIconDisplayed(){
			   return iconSrchCity.isDisplayed();
		   }
		   
		   // Search: City Link
		   
		   public void clickSearchCityLink(){	
			   lnkSrchCity.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtCity));
			    
			   
		   }
		   
		   public boolean isSearchCityLinkDisplayed(){
			   return lnkSrchCity.isDisplayed();
		   }
		   
		   // Search :
		   
		 //Enter text into City field
		   public void enterCity(String strSupplier){
			   txtCity.clear();
			   txtCity.click();
			   txtCity.sendKeys(strSupplier);
			   txtCity.click();
			   txtCity.sendKeys(Keys.ENTER);
		   }
		   
		   public boolean isCityDisplayed(){
			   return txtCity.isDisplayed();
			   }
		  
		    
		// City Search Button 
		   public void clickCitySearchButton(String eventName){
			   btnCitySearch.click();
			  // WebDriverWait wait = new WebDriverWait(driver, 50);
			   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'OfValues3_afrLovInternalTableId::db')]//*[contains(text(), '"+eventName+"')]")));
			   report.log(LogStatus.PASS, "Clicked on City Search Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isCitySearchBtnDisplayed() throws InterruptedException{
			   return btnCitySearch.isDisplayed();		 
		   }
		   
		   //Select Event (select given text from dropdown)
		   public void selectCity(String eventName) throws InterruptedException { 
			   SeleniumUtils.delay(5000);
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'OfValues3_afrLovInternalTableId::db')]//*[contains(text(), '"+eventName+"')]")));	   
			   SeleniumUtils.delay(5000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   
			   }
		   
		// City Search Ok Button 
		   public void clickCityOkButton(){	
			 
			   btnCityOk.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on City Ok Button");
		   }
		   
		   public boolean isCityOkBtnDisplayed() throws InterruptedException{
			   return btnCityOk.isDisplayed();		 
		   }  
		   
		  //txtPostalCode
		   public void enterPostalCode(String strSupplier){
			   txtPostalCode.clear();
			   txtPostalCode.click();
			   txtPostalCode.sendKeys(strSupplier);
			   
		   }
		   
		   public boolean isPostalCodeDisplayed(){
			   return txtPostalCode.isDisplayed();
			   }
		   
		   // selectSiteLanguage
		   
		   public void SelectSiteLanguage(String strSupplier){
			  Select objSelect= new Select(selectSiteLanguage);
			  objSelect.selectByVisibleText(strSupplier);
		   }
		   
		   public boolean isSiteLanguageListDisplayed(){
			   return selectSiteLanguage.isDisplayed();
			   }
		// City Add Row Button 
		   public void clickAddRowButton(){	
			 
			   btnAddRow.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on City Ok Button");
		   }
		   
		   public boolean isAddRowBtnDisplayed() throws InterruptedException{
			   return btnAddRow.isDisplayed();		 
		   } 
		   
		   // selectPurpose_r1
		   
		   public void SelectPurpose_R1(String strSupplier){
			  Select objSelect= new Select(selectPurpose_r1);
			  objSelect.selectByVisibleText(strSupplier);
		   }
		   
		   public boolean isPurpose_R1ListDisplayed(){
			   return selectPurpose_r1.isDisplayed();
			   }
		   // selectPurpose_r2
		   
		   public void SelectPurpose_R2(String strSupplier){
			  Select objSelect= new Select(selectPurpose_r2);
			  objSelect.selectByVisibleText(strSupplier);
		   }
		   
		   public boolean isPurpose_R2ListDisplayed(){
			   return selectPurpose_r2.isDisplayed();
			   }
		   // inputBilltoSite_r2
		   
		   public void SelectBilltoSite_R2(String strBilltoSite){
			   SeleniumUtils.delay(5000);
			   inputBilltoSite_r2.clear();
			   inputBilltoSite_r2.click();
			   inputBilltoSite_r2.sendKeys(strBilltoSite);
			   inputBilltoSite_r2.sendKeys(Keys.ENTER);
			   inputBilltoSite_r2.click();
		   }
		   
		   public boolean isBilltoSite_R2ListDisplayed(){
			   return inputBilltoSite_r2.isDisplayed();
			   }
		   
		// City Add Row Button 
		   public ManageCustomersPage clickSaveAndCloseButton() throws TestException{	
			 
			   btnSaveAndClose.click();
			   SeleniumUtils.delay(5000);
			   if (btnOk_Waring.isDisplayed()) {
				   btnOk_Waring.click();
			   }
			   
			   report.log(LogStatus.PASS, "Clicked on City Ok Button");
			   return new ManageCustomersPage(driver, report);
		   }
		   
		   public boolean isSaveAndCloseBtnDisplayed() throws InterruptedException{
			   return btnSaveAndClose.isDisplayed();		 
		   } 
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Create Organization Customer page is Loaded Successfully");
	    	 if(txtName.isDisplayed())
	    	 {
	    		 return true;
	    		 
	    	 } else {
	    		 return false;
	    	 }     	
		}
	    
	    public Item getScreenDetails(String strTitle){
	        String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
	        report.addScreenCapture(xyz);
	        String projectPath = System.getProperty("user.dir");          
	        String fullprojectPath = projectPath+"/report/"+xyz;
	        report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>"+strTitle+"</span></a>");
	        return new Item(xyz);
	    }
	    
	    
		public Item getScreenDetails(){
		   	String xyz = Screenshot.takeScreenshotX(driver, "EntryLogin", context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Organization Customer Page</span></a>");
		   	return new Item(xyz);
	   }

}
