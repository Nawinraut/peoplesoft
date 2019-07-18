package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CreateJournalPage extends BasePageObject{

	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'showLessBatchName')]")
	 private WebElement txtJournalBatch;
   
   @FindBy(how=How.XPATH, using = "//textarea[contains(@id,'showLessBatchDescription')]")
   private WebElement txtJBatchDescription;
   
   @FindBy(how=How.XPATH, using = "//img[contains(@id,':clLAdds::icon')]")
   private WebElement btnAttachments;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,':ifPopup::content')]")
   private WebElement btnBrowse;
   
   // Title field
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'popTitleInputText::content')]")
   private WebElement txtTitle;
   
 
   @FindBy(how=How.XPATH, using = "//button[contains(@id,'dc_cb1')]")
   private WebElement btnOk;
   
   @FindBy(how=How.XPATH, using = "//input[contains(@id,'showLessJournalName::content')]")
   private WebElement txtJournal;
   
   @FindBy(how=How.XPATH, using = "//textarea[contains(@id,'showLessJournalDescription::content')]")
   private WebElement txtJDescription;
   
   //Select a ledger for a journal entry
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'LedgerName1::content')]")
   private WebElement selectLedger;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'CategoryNameId1::content')]")
   private WebElement selectCategory;
   
   @FindBy(how=How.XPATH, using = "//select[contains(@id,'pt1:ap1:CurrencyCode1::content')]")
   private WebElement selectCurrency;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:CurrencyConversionType1::lovIconId')]")
   private WebElement srchConversionRateType;

@FindBy(how=How.XPATH, using = ".//*[contains(@id,'pt1:ap1:CurrencyConversionType1::dropdownPopup::popupsearch')]")
  private WebElement lnkConversionRateTypeSearch;

@FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId:value00::content')]")
  private WebElement txtConversionRateTypeName;

@FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId:value10::content')]")
private WebElement txtConversionRateTypeDescription;

@FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId::search')]")
  private WebElement btnConversionRateTypeSearch;

@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:CurrencyConversionType1_afrLovInternalTableId::db')]/table/tbody")
  private WebElement strConversionRateType;

@FindBy(how=How.XPATH, using = ".//*[contains(@id,'lovDialogId::ok')]")
  private WebElement btnConversionRateTypeOk;

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:CurrencyConversionRate1::content')]")
	private WebElement txtConversionRate;
   
   @FindBy(how=How.XPATH, using = "//a[contains(@id,'pt1:ap1:CurrencyConversionDate1::glyph')]")
   private WebElement btnConversionDate;

	@FindBy(how=How.XPATH, using = "//select[contains(@id,'pt1:ap1:CurrencyConversionDate1::pop::cd::mSel::content')]")
	   private WebElement selectConversionMonth;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:CurrencyConversionDate1::pop::cd::cg')]")
	   private WebElement tbleConversionDate;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'pt1:ap1:DefaultEffectiveDate1::glyph')]")
	   private WebElement btnAccountingDate;

	@FindBy(how=How.XPATH, using = "//select[contains(@id,'pt1:ap1:DefaultEffectiveDate1::pop::cd::mSel::content')]")
	   private WebElement selectAccountingDateMonth;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:DefaultEffectiveDate1::pop::cd::cg')]")
	   private WebElement tbleAccountingDate;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'accountKBIMG::icon')]")
   private WebElement btnAccount;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value00::lovIconId')]")
   private WebElement srchCompany;
   
   // Search text(Dynamic) for Accounting   
  // @FindBy(how=How.XPATH, using = "//td/span[text()=\"+categoryName+\"]")
  // private WebElement srchtext;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value10::lovIconId')]")
   private WebElement srchRegion;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value20::lovIconId')]")
   private WebElement srchCountry;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value30::lovIconId')]")
   private WebElement srchService;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value40::lovIconId')]")
   private WebElement srchLocation;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value50::lovIconId')]")
   private WebElement srchDepartment;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value60::lovIconId')]")
   private WebElement srchNaturalAccount;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'accountSPOP_query:value60_afrLovInternalTableId::db')]/table/tbody")
   private WebElement strNaturalAccount;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value70::lovIconId')]")
   private WebElement srchIntercompany;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value80::lovIconId')]")
   private WebElement srchFundSource;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value90::lovIconId')]")
   private WebElement srchFuture1;
   
   // Ok button in Account pop up(1)
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id, 'jeLineAppTable:_ATp:t3:0:accountSEl')]")
   private WebElement btnAccOkPop;
   
// Ok button in Account pop up(2)
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id, 'jeLineAppTable:_ATp:t3:1:accountSEl')]")
   private WebElement btnAccOkPop2;
   
 //1st Account field
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'AppTable:_ATp:t3::db')]/table/tbody/tr[1]/td[4]")
   private WebElement tabAccount_1st;
   
   //2nd Account field
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'AppTable:_ATp:t3::db')]/table/tbody/tr[2]/td[4]")
   private WebElement tabAccount;
   //Account select search link
   //@FindBy(how=How.XPATH, using = ".//*[contains(@id,'Popup::popupsearch')]")
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'value60::dropdownPopup::popupsearch')]")
   private WebElement lnkAccountSearch;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId:value00::content')]")
   private WebElement txtAccValue;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'QueryId::search')]")
   private WebElement btnAccSearch;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'lovDialogId::ok')]")
   private WebElement btnAccOk;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'jeLineAppTable:_ATp:t3:0:accountCS::content')]")
   private WebElement txtJournalLinesAccount1;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'jeLineAppTable:_ATp:t3:2:accountCS::content')]")
   private WebElement txtJournalLinesAccount1_2ndJrnl;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:t3:0:EnteredDr::content')]")
   private WebElement txtDebit;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:t3:2:EnteredDr::content')]")
   private WebElement txtDebit2;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'jeLineAppTable:_ATp:t3:1:accountCS::content')]")
   private WebElement txtJournalLinesAccount2;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'jeLineAppTable:_ATp:t3:3:accountCS::content')]")
   private WebElement txtJournalLinesAccount2_2ndJrnl;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'_ATp:t3:1:EnteredCr::content')]")
   private WebElement txtCredit;
   
   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'_ATp:t3:3:EnteredCr::content')]")
   private WebElement txtCredit2;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:addHeaderIcon::icon')]")
   private WebElement btnAddicon;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,':saveBatch')]/table/tbody/tr/td[1]/a/span")
   private WebElement btnSave;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'general_accounting_journals:0:MAnt2:1:pt1:ap1:saveBatch::popEl')]")
   private WebElement btnSaveMenu;
   
   @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_general_accounting_journals:0:MAnt2:1:pt1:ap1:cmi4']")
   private WebElement btnSaveAndClose;
 
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'completeButton')]/table/tbody/tr/td[1]/a/span")
   private WebElement btnComplete;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'postBatch')]/table/tbody/tr/td[1]/a")
   private WebElement btnPost;
   
   @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:ap1:commandToolbarButton5')]")
   private WebElement btnCancel;
 
   @FindBy(how=How.XPATH, using = "//button[contains(@id,'serResponsePopupDialogButtonOk')]")
   private WebElement btnConfOk;
   
   public WebDriverWait wdwait;
 
   /**
	* Initializing page objects for Create Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/  
   
   public CreateJournalPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtJournalBatch));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Create Journal Page *****************************");
	       this.getScreenDetails();
	    }
   
   //Enter text into Journal Batch field
   public void enterJournalBatch(String journalBatch){
	   txtJournalBatch.clear();
	   txtJournalBatch.click();
	   txtJournalBatch.sendKeys(journalBatch);
	   report.log(LogStatus.PASS, "Journal Batch is entered successfully: "+journalBatch);
   }
   
   public boolean isJournalBatchDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, txtJournalBatch, context.getReactTimeout());
	   return txtJournalBatch.isDisplayed();
	   }
   
 //Enter text into Journal Batch Description text area field
   public void enterBatchDescription(String batchDescription){
	   txtJBatchDescription.clear();
	   txtJBatchDescription.click();
	   txtJBatchDescription.sendKeys(batchDescription);
	   report.log(LogStatus.PASS, "Journal Batch Description is entered successfully: "+batchDescription);
   }
      
   public boolean isBatchDescriptionDisplayed(){
	  // return SeleniumUtils.isDisplayed(driver, txtJBatchDescription, context.getReactTimeout());
	   return txtJBatchDescription.isDisplayed();
   }
   // Attachments Button 
   public void clickAttachmentsButton(){	
	   btnAttachments.click();
	   wdwait.until(ExpectedConditions.visibilityOf(btnOk));
	   report.log(LogStatus.PASS, "Clicked on Attachments Button");
   }
   
   public boolean isAttachmentsBtnDisplayed() throws InterruptedException{
	   //return SeleniumUtils.isDisplayed(driver, btnAttachments, context.getReactTimeout());
	   return btnAttachments.isDisplayed();
	 
   }
   
   // Browse button
   
   public void clickBrowseWithFile(String filePath){
	   SeleniumUtils.delay(2000);
	   btnBrowse.sendKeys(filePath);
	   SeleniumUtils.delay(2000);
	   report.log(LogStatus.PASS, "Clicked on Browse Button and file attached successfully");
   }
   
   public boolean isFileUploaded(String fileName) throws InterruptedException{
	   SeleniumUtils.delay(15000);
	   if (txtTitle.getAttribute("value").equals(fileName))
		   return true;
	   else
		   return false;
		   
   }
   public boolean isBrowseBtnDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, btnBrowse, context.getReactTimeout());
	   return btnBrowse.isDisplayed();
   }
   
   // Title field
   
   public boolean isTitleFieldDisplayed(){
	   	return SeleniumUtils.isDisplayed(driver, txtTitle, context.getReactTimeout());
	   }
   //Attachments Ok button
   
   public void clickAttachmentsOkButton(){	
	   this.getScreenDetails("Attachments Pop-up");
	   btnOk.click();
	   SeleniumUtils.delay(3000);
	   report.log(LogStatus.PASS, "Clicked on Ok Button");
   }
   
   public boolean isAttachmentsOkBtnDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, btnOk, context.getReactTimeout());
	   return btnOk.isDisplayed();
   }
   
   //Journal 
   
   public void enterJournal(String journal){
	   txtJournal.clear();
	   txtJournal.click();
	   txtJournal.sendKeys(journal);
	   report.log(LogStatus.PASS, "Journal  is entered successfully: "+journal);
   }
   
   public boolean isJournalDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, txtJournal, context.getReactTimeout());
	   return txtJournal.isDisplayed();
	   } 
   
   //Journal Description
   
   public void enterJournalDescription(String journalDescription){
	   txtJDescription.clear();
	   txtJDescription.click();
	   txtJDescription.sendKeys(journalDescription);
	   report.log(LogStatus.PASS, "Journal Description is entered successfully: "+journalDescription);
   }
   
   public boolean isJournalDescriptionDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, txtJDescription, context.getReactTimeout());
	   return txtJDescription.isDisplayed();
	   } 
   
   //Category list
   public void SelectCategory(String strCategory) throws InterruptedException{
	 selectCategory.clear();
   	selectCategory.click();
   	selectCategory.sendKeys(strCategory);
   	//selectCategory.sendKeys(Keys.ARROW_DOWN);
   	selectCategory.sendKeys(Keys.ENTER);
   	SeleniumUtils.delay(000);
   	selectCategory.click();
   	SeleniumUtils.delay(3000);
    report.log(LogStatus.PASS, "Selected given Category from the list is: "+strCategory);
   }
  
   public boolean isSelectCategoryDisplayed(){
	  // return SeleniumUtils.isDisplayed(driver, selectCategory, context.getReactTimeout());
	   return selectCategory.isDisplayed();
	   } 
   
   
   //Account button
  
   public void clickAccountButton(){	
	   btnAccount.click();
	   wdwait.until(ExpectedConditions.visibilityOf(srchCompany));
	   report.log(LogStatus.PASS, "Clicked on Account Button");  
	   
   }
   
   public boolean isAccountBtnDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnAccount, context.getReactTimeout());
	   
   }
  
  // Search Company 
   
   public void clickCompanySearchIcon() throws InterruptedException{
	   
	   SeleniumUtils.delay(5000);
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", srchCompany);*/
    	srchCompany.click();
    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value00::dropdownPopup::popupsearch')]")));
	   report.log(LogStatus.PASS, "Clicked on Company Search Icon");
	   
   }
   
   public void clickSearchIcon(WebElement element) throws InterruptedException{
	   
	   SeleniumUtils.delay(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", element);
	   
	   report.log(LogStatus.PASS, "Clicked on Search Icon");
   }
   
   
   public boolean isCompanySearchIconDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, srchCompany, context.getReactTimeout());
	   return srchCompany.isDisplayed();
   } 
   
   // Accounting text search
   
   // Search Region
   
   public void clickRegionSearchIcon() throws InterruptedException{	
	   //SeleniumUtils.delay(3000);
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", srchRegion);*/
    	srchRegion.click();
    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value10::dropdownPopup::popupsearch')]")));
	   report.log(LogStatus.PASS, "Clicked on Region Search Icon");
   }
   
   public boolean isRegionSearchIconDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, srchRegion, context.getReactTimeout());
	   return srchRegion.isDisplayed();
   } 
   
   // Search Country
   
   public void clickCountrySearchIcon() throws InterruptedException{
	   //SeleniumUtils.delay(3000);
	   /*JavascriptExecutor js = (JavascriptExecutor)driver;
   		js.executeScript("arguments[0].click();", srchCountry);*/
	   srchCountry.click();
	   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value20::dropdownPopup::popupsearch')]")));
	   //srchCountry.click();
	   report.log(LogStatus.PASS, "Clicked on Country Search Icon");
   }
   
   public boolean isCountrySearchIconDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, srchCountry, context.getReactTimeout());
   } 
   // Search Service
   
   public void clickServiceSearchIcon() throws InterruptedException{	
	  // SeleniumUtils.delay(3000);
	   /*JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", srchService);*/
	   srchService.click();
    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value30::dropdownPopup::popupsearch')]")));
	   report.log(LogStatus.PASS, "Clicked on Service Search Icon");
   }
   
   
   public boolean isServiceSearchIconDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, srchService, context.getReactTimeout());
	   return srchService.isDisplayed();
   }
   
   // Search Location
   
   public void clickLocationSearchIcon() throws InterruptedException{
	   
	  
	    //SeleniumUtils.delay(8000);
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", srchLocation);*/
	   	srchLocation.click();
    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value40::dropdownPopup::popupsearch')]")));
	   report.log(LogStatus.PASS, "Clicked on Location Search Icon");
   }
   
   public boolean isLocationSearchIconDisplayed(){
   
   	//return SeleniumUtils.isDisplayed(driver, srchLocation, context.getReactTimeout());
   	return srchLocation.isDisplayed();
   }
   
   // Search Department
   
   public void clickDepartmentSearchIcon() throws InterruptedException{	
	  // SeleniumUtils.delay(3000);
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", srchDepartment);*/
	   	srchDepartment.click();
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value50::dropdownPopup::popupsearch')]")));
	 
	   report.log(LogStatus.PASS, "Clicked on Department Search Icon");
   }
   
  
   public boolean isDepartmentSearchIconDisplayed(){
   	
   	//return SeleniumUtils.isDisplayed(driver, srchDepartment, context.getReactTimeout());
   	return srchDepartment.isDisplayed();
   }
// Search Natural Account
   
   public void clickNaturalAccountSearchIcon() throws InterruptedException{	
	   WebDriverWait wait = new WebDriverWait(driver, 50);
	   //WebElement srchNaturalAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'query:value60::lovIconId')]")));
	   WebElement elementsrchNaturalAccount = wait.until(ExpectedConditions.elementToBeClickable(srchNaturalAccount));
	   SeleniumUtils.isDisplayed(driver, srchNaturalAccount, context.getReactTimeout()); 
/*	   
  		SeleniumUtils.delay(30000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", srchNaturalAccount);*/
	   
	   elementsrchNaturalAccount.click();
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Natural Account Search Icon");
   }
   
   public boolean isNaturalAccountSearchIconDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, srchNaturalAccount, context.getReactTimeout());
   }
// Search Intercompany
   
   public void clickIntercompanySearchIcon() throws InterruptedException{	
	   //SeleniumUtils.delay(3000);
	  /* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", srchIntercompany);*/
		srchIntercompany.click();
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value70::dropdownPopup::popupsearch')]")));
	   
	   report.log(LogStatus.PASS, "Clicked on Intercompany Search Icon");
   }
   
   public boolean isIntercompanySearchIconDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, srchIntercompany, context.getReactTimeout());
	   return srchIntercompany.isDisplayed();
   }
  
   // Search Fund Source
   
   public void clickFundSourceSearchIcon() throws InterruptedException{	
	   //SeleniumUtils.delay(3000);
	  /* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", srchFundSource);*/
		srchFundSource.click();
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value80::dropdownPopup::popupsearch')]")));
	  
	   report.log(LogStatus.PASS, "Clicked on FundSource Search Icon");
   }
   
   public boolean isFundSourceSearchIconDisplayed(){
	  // return SeleniumUtils.isDisplayed(driver, srchFundSource, context.getReactTimeout());
	   return srchFundSource.isDisplayed();
   }
   
   // Search Future1
   
   public void clickFuture1SearchIcon() throws InterruptedException{
	   //SeleniumUtils.delay(3000);
	  /* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", srchFuture1);*/
	   srchFuture1.click();
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value90::dropdownPopup::popupsearch')]")));
		//SeleniumUtils.delay(3000);
	   report.log(LogStatus.PASS, "Clicked on Future1 Search Icon");
   }
   
   public boolean isFuture1SearchIconDisplayed(){
	  // return SeleniumUtils.isDisplayed(driver, srchFuture1, context.getReactTimeout());
	   return srchFuture1.isDisplayed();
   }
   
   //Account TAB
   
   public void clickAccountTab(){
	   SeleniumUtils.delay(2000);
	   tabAccount.click();
	   //SeleniumUtils.delay(3000);
	   wdwait.until(ExpectedConditions.visibilityOf(txtJournalLinesAccount2));
	   //report.log(LogStatus.PASS, "Clicked on Account Tab");
   }
   
   
   
   public void clickAccountTab_2ndJournal(){
	   SeleniumUtils.delay(2000);
	   tabAccount_1st.click();
	   //SeleniumUtils.delay(3000);
	   wdwait.until(ExpectedConditions.visibilityOf(txtJournalLinesAccount1_2ndJrnl));
	   //report.log(LogStatus.PASS, "Clicked on Account Tab");
   }
   
   
   public void clickAccountTab_2Tab(){
	   SeleniumUtils.delay(2000);
	   tabAccount.click();
	   //SeleniumUtils.delay(3000);
	   wdwait.until(ExpectedConditions.visibilityOf(txtJournalLinesAccount2_2ndJrnl));
	   //report.log(LogStatus.PASS, "Clicked on Account Tab");
   }
   
   public boolean isAccountTabDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, tabAccount, context.getReactTimeout());
   } 
   
   //Search link for Account
   
   public void clickAccountSearchLink() throws InterruptedException{	
	   
	   WebDriverWait wait = new WebDriverWait(driver, 50);	 
	   WebElement elementlnkAccountSearch = wait.until(ExpectedConditions.elementToBeClickable(lnkAccountSearch));
	   
	   // SeleniumUtils.delay(3000);
	    elementlnkAccountSearch.click();

	    wdwait.until(ExpectedConditions.visibilityOf(txtAccValue));
	    
	   // SeleniumUtils.delay(5000);
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lnkAccountSearch);*/
	   report.log(LogStatus.PASS, "Clicked on Account Search link");
   }
   
   public boolean isAccountSearchLinkDisplayed(){
	   //return SeleniumUtils.isDisplayed(driver, lnkAccountSearch, context.getReactTimeout());
	   return lnkAccountSearch.isDisplayed();
   } 
   
   //Value for Search 
   
   public void enterAccountValue(String value) throws InterruptedException{
	   SeleniumUtils.delay(3000);
	   txtAccValue.clear();
	   txtAccValue.click();
	   txtAccValue.sendKeys(value);
	   report.log(LogStatus.PASS, "Entered value for Natural Account is: "+value);
   }
   
   public boolean isAccountValueDisplayed(){
	  // return SeleniumUtils.isDisplayed(driver, txtAccValue, context.getReactTimeout());
	   return txtAccValue.isDisplayed();
	   } 
   
   
   // Search button in Account
   public void clickAccountSearchButton(){	
			/*JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnAccSearch);*/
			btnAccSearch.click();
			SeleniumUtils.delay(3000);
	   
	   report.log(LogStatus.PASS, "Clicked on Account Search Button");
   }
   
   public boolean isAccountSearchButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnAccSearch, context.getReactTimeout());
   } 
   
  // Select Natural Account from Table
   
   public void selectNaturalAccountvalue(){	
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnAccSearch);
		
		strNaturalAccount.click();
		SeleniumUtils.delay(3000);
  report.log(LogStatus.PASS, "Clicked on Account Search Button");
}
   
   public void selectNaturalAccountvalueFromTable(String eventName){
	   
	   
	   WebDriverWait wait = new WebDriverWait(driver, 50);
	   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'accountSPOP_query:value60_')]//span[contains(text(), '"+eventName+"')]")));	   
	   SeleniumUtils.delay(2000);
	   eventLink.click(); 
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
   
   }
   
  
  //  Ok Button for Natural Account
   
   public void clickAccountOkButton(){	
	   this.getScreenDetails("Account Pop-up");
	   WebDriverWait wait = new WebDriverWait(driver, 50);	 
	   WebElement elementbtnAccOk = wait.until(ExpectedConditions.elementToBeClickable(btnAccOk));
	    //SeleniumUtils.delay(3000);
	   elementbtnAccOk.click();
	  
	    /*SeleniumUtils.delay(2000);
	   btnAccOk.click();*/
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Account Ok Button");
	   
   }
   
   public void clickAccountOkButton1(){	
	   
	  /* WebDriverWait wait = new WebDriverWait(driver, 50);	 
	   WebElement elementbtnAccOk = wait.until(ExpectedConditions.elementToBeClickable(btnAccOk));*/
	   JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnAccOk);
	   
	   //WebDriverWait wait = new WebDriverWait(driver, 50);	 
	  // WebElement elementbtnAccOk = wait.until(ExpectedConditions.elementToBeClickable(btnAccOk));
	    //SeleniumUtils.delay(3000);
	   //elementbtnAccOk.click();
	  
	    /*SeleniumUtils.delay(2000);
	   btnAccOk.click();*/
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Account Ok Button");
   }
   
   public boolean isAccountOkButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnAccOk, context.getReactTimeout());
   }
   
   // Ok button in Account Pop up(1)
   
   public void clickAccountPopOkButton(){
	   this.getScreenDetails("Account Pop-up");
	   btnAccOkPop.click();
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Account Ok Button");
   }
   
   public boolean isAccountPopOkButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnAccOkPop, context.getReactTimeout());
   }
   
// Ok button in Account Pop up(2)
   
   public void clickAccountPop2OkButton(){
	   this.getScreenDetails();
	   btnAccOkPop2.click();
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Account Ok Button");
	   this.getScreenDetails();
   }
   
   public boolean isAccountPopOk2ButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnAccOkPop2, context.getReactTimeout());
   } 
   
   // Journal Lines Account Field1
   
   public void enterJournalLinesAccountField1(String debit){
	   SeleniumUtils.delay(3000);
	   txtJournalLinesAccount1.clear();
	   txtJournalLinesAccount1.click();
	   txtJournalLinesAccount1.sendKeys(debit);
	   SeleniumUtils.delay(5000);
	  // report.log(LogStatus.PASS, "Entered Dabit is: "+debit);
   }
   
   
   public boolean isJournalLinesAccountField1Displayed(){
	   return txtJournalLinesAccount1.isDisplayed();
	   }
   
// Journal Lines Account Field1 for 2nd Journal
   
   public void enterJournalLinesAccountField1_2ndJournal(String debit){
	   SeleniumUtils.delay(5000);
	   txtJournalLinesAccount1_2ndJrnl.clear();
	   txtJournalLinesAccount1_2ndJrnl.click();
	   txtJournalLinesAccount1_2ndJrnl.sendKeys(debit);
	   SeleniumUtils.delay(5000);
	  // report.log(LogStatus.PASS, "Entered Dabit is: "+debit);
   }
   // Debit text box
   
   public void enterDebit(String debit){
	   txtDebit.clear();
	   txtDebit.click();
	   txtDebit.sendKeys(debit);
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Debit is entered successfully: "+debit);
   }
   
   public boolean isDebitDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, txtDebit, context.getReactTimeout());
	   }
   
// Debit text box
   
   public void enterDebit_2ndJournal(String debit){
	   txtDebit2.clear();
	   txtDebit2.click();
	   txtDebit2.sendKeys(debit);
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Debit is entered successfully: "+debit);
   }
   
   //Journal Lines Account Field2
   public void enterJournalLinesAccountField2(String debit){
	   SeleniumUtils.delay(3000);
	   txtJournalLinesAccount2.click();
	   txtJournalLinesAccount2.clear();
	   txtJournalLinesAccount2.click();
	   txtJournalLinesAccount2.sendKeys(debit);
	   SeleniumUtils.delay(5000);
	  // report.log(LogStatus.PASS, "Entered Dabit is: "+debit);
   }
   
   public boolean isJournalLinesAccountField2Displayed(){
	   return txtJournalLinesAccount2.isDisplayed();
	   }
   
 //Journal Lines Account Field2
   public void enterJournalLinesAccountField2_2ndJournal(String debit){
	   SeleniumUtils.delay(3000);
	   txtJournalLinesAccount2_2ndJrnl.click();
	   txtJournalLinesAccount2_2ndJrnl.clear();
	   txtJournalLinesAccount2_2ndJrnl.click();
	   txtJournalLinesAccount2_2ndJrnl.sendKeys(debit);
	   SeleniumUtils.delay(5000);
	  // report.log(LogStatus.PASS, "Entered Dabit is: "+debit);
   }
   
// Credit text box
   
   public void enterCredit(String credit){
	   txtCredit.clear();
	   txtCredit.click();
	   txtCredit.sendKeys(credit);
	   SeleniumUtils.delay(8000);
	   report.log(LogStatus.PASS, "Credit is entered successfully: "+credit);
   }
   
   public boolean isCreditDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, txtCredit, context.getReactTimeout());
	   }
   
// Credit text box
   
   public void enterCredit_2ndJournal(String credit){
	   txtCredit2.clear();
	   txtCredit2.click();
	   txtCredit2.sendKeys(credit);
	   SeleniumUtils.delay(8000);
	   report.log(LogStatus.PASS, "Credit is entered successfully: "+credit);
   }
// Credit text box
   
   public void clickCreditTab(){
	   txtCredit.sendKeys(Keys.TAB);
	   SeleniumUtils.delay(2000);
	  
   }
   
   public void clickCreditTab_2ndJournal(){
	   txtCredit2.sendKeys(Keys.TAB);
	   SeleniumUtils.delay(2000);
	  
   }
   
   
   // Save  button
   
   public void clickSaveButton(){
	   this.getScreenDetails();
	   btnSave.click();
	   SeleniumUtils.delay(8000);
	   report.log(LogStatus.PASS, "Clicked on Save Button");
   }
   
   public boolean isSaveButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnSave, context.getReactTimeout());
   	
   }
   //  btnSave to Edit Journal Page navigation
   
   public EditJournalPage clickSaveBttn() throws TestException{
	   btnSave.click();
	   //SeleniumUtils.delay(8000);
	   report.log(LogStatus.PASS, "Clicked on Save Button");
	   return new EditJournalPage(driver, report);
   }
   
   // Save Menu
   public void clickSaveManu(){	
	   btnSaveMenu.click();
	   wdwait.until(ExpectedConditions.visibilityOf(btnSaveAndClose));
	   //SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Save Menu");
   }
   
   public boolean isSaveMenuDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnSaveMenu, context.getReactTimeout());
   	
   }
   //' Save and Close' button
   
   public void clickSaveAndCloseButton(){	
	   btnSaveAndClose.click();
	   //SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on SaveAndClose");
	   //report.log(LogStatus.PASS, "Managed incomplete journal entries successfully.");
	   
   }
   
   public boolean isSaveAndCloseDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnSaveAndClose, context.getReactTimeout());
   }
   	
   // Click on Add icon
   
   public void clickAddicon(){	
	   btnAddicon.click();
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Add icon");
   }
   
  
   
   // Complete button
   
   public void clickCompleteButton(){	
	   btnComplete.click();
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Complete Button");
   }
   
   public boolean isCompleteButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnComplete, context.getReactTimeout());
   	
   }
   
// Post button
   
   public void clickPostButton(){	
	   btnPost.click();
	  // SeleniumUtils.delay(5000);
	   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
	   report.log(LogStatus.PASS, "Clicked on Post Button");
	   this.getScreenDetails("Confirmation Pop-up");
   }
   
   public boolean isPostButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnPost, context.getReactTimeout());  	
   } 
  
// Confirmation OK button
   
   public void clickConfOkButton(){	
	   
	   btnConfOk.click();
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	  // report.log(LogStatus.PASS, "Journal with Attachment created  successfully");
   }
  
   
   public boolean isConfOkButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
   }  
  // Cancel button
   public void clickCancelButton(){	
	   btnCancel.click();
	   report.log(LogStatus.PASS, "Clicked on Cancel Button");
	  
   }
  
   
   public boolean isCancelButtonDisplayed(){
	   return btnCancel.isDisplayed();	
   }  
  ///////////////////////////// 
   public void clickConfOkButton(String message){	
	   btnConfOk.click();
	   SeleniumUtils.delay(2000);
	   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   report.log(LogStatus.PASS, ""+message);
   }
   
   //Select Event (select given text from dropdown)
   public void selectEvent(String eventName) throws InterruptedException { 
	   
	   WebDriverWait wait = new WebDriverWait(driver, 50);
	   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));	   
	   SeleniumUtils.delay(2000);
	   eventLink.click(); 
	   SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
	   }
   
   // for Location
   
public void selectLocationEvent(String eventName) throws InterruptedException { 
	   
	   WebDriverWait wait = new WebDriverWait(driver, 50);
	  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
	   
	  // Thread.sleep(5000);
	   WebElement eventLink = driver.findElement(By.xpath("//td/span[contains(text(), '"+eventName+"')]"));
	   SeleniumUtils.isDisplayed(driver, eventLink, context.getReactTimeout());  
	   eventLink.click(); 
	   //Thread.sleep(5000);
	   report.log(LogStatus.PASS, "Select Category Category is: "+eventName);
	   }
   
   public void verifyEvent(String eventName) throws InterruptedException { 
	   WebDriverWait wait = new WebDriverWait(driver, 50);
	   WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='"+eventName+"']")));
	   SeleniumUtils.isDisplayed(driver, eventText, context.getReactTimeout()); 
	   report.log(LogStatus.PASS, "Selected and verified list is: "+eventName);
	   }

   public void verifySearchEvent(String eventName) throws InterruptedException { 
	   WebDriverWait wait = new WebDriverWait(driver, 15);
	   WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '"+eventName+"')]")));
	   
	  /* WebElement eventText = driver.findElement(By.xpath("//span[contains(text(), '"+eventName+"')]"));
	   SeleniumUtils.isDisplayed(driver, eventText, context.getReactTimeout());  */	   
	   //eventText.click(); 
	   SeleniumUtils.isDisplayed(driver, eventText, context.getReactTimeout());
	   report.log(LogStatus.PASS, "Verified list is: "+eventName);
	   }
   
// Select  Currency list
   public void selectCurrencyList(String strCurrency){
   	Select objSelect = new Select(selectCurrency);
   	objSelect.selectByVisibleText(strCurrency);
   	SeleniumUtils.delay(2000);
   } 
  
  public boolean isCurrencyListDisplayed(){
	   return selectCurrency.isDisplayed();
	   
  } 
  
  
//search ConversionRateType Period 
  
  public void clickConversionRateTypeSearchIcon() throws InterruptedException{
	   
  	SeleniumUtils.delay(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
   	js.executeScript("arguments[0].click();", srchConversionRateType);
   	SeleniumUtils.delay(3000);

	   report.log(LogStatus.PASS, "Clicked on Conversion Rate Type Search Icon");
  }
  
  public boolean isConversionRateTypeSearchIconDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, srchConversionRateType, context.getReactTimeout());
  } 

  // Search link ConversionRateType
  
  public void clickConversionRateTypeSearchLink(){	
  	lnkConversionRateTypeSearch.click();
  	SeleniumUtils.delay(5000);
	   report.log(LogStatus.PASS, "Clicked on Conversion Rate Type Search link");
  }
  
  public boolean isConversionRateTypeSearchLinkDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, lnkConversionRateTypeSearch, context.getReactTimeout());
  } 
   
  
//Enter text into Period Name  field
  public void enterConversionRateTypeName(String Period){
	  txtConversionRateTypeName.clear();
	  txtConversionRateTypeName.click();
	  txtConversionRateTypeName.sendKeys(Period);
  	SeleniumUtils.delay(3000);
	   report.log(LogStatus.PASS, "Entered Conversion Rate Type Name  is: "+Period);
  } 
  
// Search Button in Period Name
  
  public void clickConversionRateTypeSearchButton(){	
  	btnConversionRateTypeSearch.click();
  	SeleniumUtils.delay(5000);
     	this.getScreenDetails();
	   report.log(LogStatus.PASS, "Clicked on Conversion Rate Type Name Search Button");
  }
  
  public boolean isConversionRateTypeSearchButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnConversionRateTypeSearch, context.getReactTimeout());
  } 
  
//Value verification
  public void clickConversionRateTypeValue(String eventName){	
  	WebDriverWait wait = new WebDriverWait(driver, 50);
	   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'pt1:ap1:CurrencyConversionType1_afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));	   
	   //SeleniumUtils.delay(2000);
	   eventLink.click(); 
	   SeleniumUtils.delay(2000);
  	
  	//strPeriodName.click();
	   report.log(LogStatus.PASS, "Selected Conversion Rate Type Name from list");
  }
  
//Search Ok button Accounting Period
  
  public void clickConversionRateTypeOkButton(){
  	SeleniumUtils.delay(2000);
  	btnConversionRateTypeOk.click();
	   report.log(LogStatus.PASS, "Clicked on Conversion Rate Type Ok Button");
  }
  
  public boolean isConversionRateTypeOkButtonDisplayed(){
	   return SeleniumUtils.isDisplayed(driver, btnConversionRateTypeOk, context.getReactTimeout());
  }
  
  
//Enter text into Period Name  field
  public void enterConversionRate(String Period){
	  SeleniumUtils.delay(3000);
	  txtConversionRate.clear();
	  txtConversionRate.click();
	  txtConversionRate.sendKeys(Period);
  	SeleniumUtils.delay(3000);
	   report.log(LogStatus.PASS, "Entered Conversion Rate Type Name  is: "+Period);
  } 
  
  
// click on  Conversion Date button
   
   public boolean isConversionDateBtnDisplayed(){
	   return btnConversionDate.isDisplayed();
    	
    }
    public void clickConversionDateButton(){
    	SeleniumUtils.delay(5000);
    	btnConversionDate.click();
    	 wdwait.until(ExpectedConditions.visibilityOf(selectConversionMonth));
    	report.log(LogStatus.PASS, "Clicked on Conversion Date Button");
    }
   
   // Select  Conversion Month from Calander
    public void selectConversionDateMonth(String conversionMonth){
    	Select objSelect = new Select(selectConversionMonth);
    	objSelect.selectByVisibleText(conversionMonth);
    	 wdwait.until(ExpectedConditions.visibilityOf(tbleConversionDate));
    	//SeleniumUtils.delay(5000);
    	report.log(LogStatus.PASS, "Selected Conversion Month  is: "+conversionMonth);
    } 
   
   public boolean isConversionMonthDisplayed(){
	   return selectConversionMonth.isDisplayed();
	   
   }
   
   // Select  Conversion Date
   public void selectConversionDate(String conversionDate)
	{
		List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'pt1:ap1:CurrencyConversionDate1::pop::cd::cg')]//td"));  
		for (WebElement cell:dates)
		  {
			String date=cell.getText();
		   if (date.equalsIgnoreCase(conversionDate))
		   {
		     cell.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Selected Conversion Date is "+conversionDate);
			   break;
			   
		   }
		  } 
		   
	  }
   
// click on  Accounting Date button
   
   public boolean isAccountingDateBtnDisplayed(){
	   return btnAccountingDate.isDisplayed();
    	
    }
    public void clickAccountingDateButton(){
    	SeleniumUtils.delay(5000);
    	btnAccountingDate.click();
    	 wdwait.until(ExpectedConditions.visibilityOf(selectAccountingDateMonth));
    	report.log(LogStatus.PASS, "Clicked on Accounting Date Button");
    }
   
   // Select  Accounting Month from Calander
    public void selectAccountingDateMonth(String accountingMonth){
    	Select objSelect = new Select(selectAccountingDateMonth);
    	objSelect.selectByVisibleText(accountingMonth);
    	 wdwait.until(ExpectedConditions.visibilityOf(tbleAccountingDate));
    	//SeleniumUtils.delay(5000);
    	report.log(LogStatus.PASS, "Selected Accounting Month  is: "+accountingMonth);
    } 
   
   public boolean isAccountingDateMonthDisplayed(){
	   return selectAccountingDateMonth.isDisplayed();
	   
   }
   
   // Select  Accounting Date
   public void selectAccountingDate(String accountingDate)
	{
		List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'pt1:ap1:DefaultEffectiveDate1::pop::cd::cg')]//td"));  
		for (WebElement cell:dates)
		  {
			String date=cell.getText();
		   if (date.equalsIgnoreCase(accountingDate))
		   {
		     cell.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Selected Accounting Date is "+accountingDate);
			   break;
			   
		   }
		  } 
		   
	  }
   
   @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Create Journal page is Loaded Successfully");
		 return SeleniumUtils.isDisplayed(driver, txtJournalBatch, context.getFindTimeout()); 	
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Journal Page</span></a>");
	   	return new Item(xyz);
  }

}
