package com.cloud.pageobjects.Finance;

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

public class TransferBalancestoSecondaryLedger_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'primaryLedgerNameId::content')]")
	    private WebElement inputPrimaryLedger;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'secondaryLedgerNameId::content')]")
	    private WebElement inputSecondaryLedger;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc10::content')]")
	    private WebElement selectAmountType;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc1::content')]")
	    private WebElement selectPrmLedgerPeriod;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc4::content')]")
	    private WebElement selectSecndLedgerPeriod;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'sbc1::content')]")
	    private WebElement chkRunJournalImport;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'sbc2::content')]")
	    private WebElement chkCrtSummaryJournals;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'sbc3::content')]")
	    private WebElement chkRunAutoPosting ;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:pt_ol1')]")
	    private WebElement lblConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:confirmSubmitDialog::ok')]")
		private WebElement btnConfOk;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public TransferBalancestoSecondaryLedger_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(inputPrimaryLedger));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Basic Options Page *****************************");
		       this.getScreenDetails();
		    }
	    // Primary Ledger List
	    public void SelectPrimaryLedgerList(String strPrimaryLedger) throws InterruptedException{
			   this.getScreenDetails();
			   inputPrimaryLedger.click();
			   inputPrimaryLedger.sendKeys(strPrimaryLedger);
			   inputPrimaryLedger.sendKeys(Keys.ENTER);
			   inputPrimaryLedger.click();
		   }
		   
		   public boolean isPrimaryLedgerListDisplayed(){
			   return inputPrimaryLedger.isDisplayed();
			   }
		   
		   // Secondary Ledger List
		    public void SelectSecondaryLedgerList(String strPrimaryLedger) throws InterruptedException{
				   
				   inputSecondaryLedger.click();
				   inputSecondaryLedger.sendKeys(strPrimaryLedger);
				   inputSecondaryLedger.sendKeys(Keys.ENTER);
				   inputSecondaryLedger.click();
			   }
			   
			   public boolean isSecondaryLedgerListDisplayed(){
				   return inputPrimaryLedger.isDisplayed();
				   }
			   
			// Amount Type  List
			    public void SelectAmountTypeList(String strAmountType){
			    	  SeleniumUtils.delay(2000);
					  Select objSelect= new Select(selectAmountType);
					  objSelect.selectByVisibleText(strAmountType);
				   }
				   
				   public boolean isAmountTypeListDisplayed(){
					   return selectAmountType.isDisplayed();
					   }
				   
			// Primary Ledger Period   List
			    public void SelectPrimaryLedgerPeriodList(String strPrmLedgerPeriod){
					   
					  Select objSelect= new Select(selectPrmLedgerPeriod);
					  objSelect.selectByVisibleText(strPrmLedgerPeriod);
				   }
				   
				   public boolean isPrimaryLedgerPeriodListDisplayed(){
					   return selectPrmLedgerPeriod.isDisplayed();
					   }
	    
			// Secondary Ledger Period    List
			    public void SelectSecondaryLedgerPeriodList(String strSecndLedgerPeriod){
			    	SeleniumUtils.delay(2000);
					  Select objSelect= new Select(selectSecndLedgerPeriod);
					  objSelect.selectByVisibleText(strSecndLedgerPeriod);
				   }
				   
				   public boolean isSecondaryLedgerPeriodListDisplayed(){
					   return selectSecndLedgerPeriod.isDisplayed();
					   }	
				   
			// Run Journal Import  Checkbox
			    public void SelectRunJournalImportCheckBox(){
					 if(chkRunJournalImport.isSelected()) {
						 report.log(LogStatus.PASS, "Run Journal Import Checkbox is already in selected state");
					 }else {
						 chkRunJournalImport.click();
					     report.log(LogStatus.PASS, "Selected on Run Journal Import Checkbox"); 
					 }
			    	
				   }
				   
				   public boolean isRunJournalImportCheckBoxDisplayed(){
					   return chkRunJournalImport.isDisplayed();
					   }
		// Create Summary Journals Checkbox
		    public void SelectCreateSummaryJournalsCheckBox(){
		    	if(chkCrtSummaryJournals.isSelected()) {
					 report.log(LogStatus.PASS, "Create Summary Journals Checkbox is already in selected state");
				 }else {
					 chkCrtSummaryJournals.click();
					 report.log(LogStatus.PASS, "Clicked on Create Summary Journals Checkbox"); 
				 }
		    
			   }
			   
			   public boolean isCreateSummaryJournalsCheckBoxDisplayed(){
				   return chkCrtSummaryJournals.isDisplayed();
				   } 
			   
		// Run Automatic Posting  Checkbox
		    public void SelectRunAutomaticPostingCheckBox(){ 
		    	if(chkRunAutoPosting.isSelected()) {
					 report.log(LogStatus.PASS, "Run Automatic Posting Checkbox is already in selected state");
				 }else {
					 chkRunAutoPosting.click();
				     report.log(LogStatus.PASS, "Clicked on Run Automatic Posting Checkbox"); 
				 }
		    	
			   }
			   
		   public boolean isRunAutomaticPostingCheckBoxDisplayed(){
			   return chkRunAutoPosting.isDisplayed();
			   }  
		   
		   // Submit button
		   
		   public void clickSubmitButton(){
			   SeleniumUtils.delay(2000);
			   btnSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			   SeleniumUtils.delay(2000);
			   this.getScreenDetails("Confirmation Pop-up");
		   }
		   
		   public boolean isSubmitBtnDisplayed(){
			   return btnSubmit.isDisplayed();
		   } 
		   
		   //
		   public void clickSubmissionNotesField(){
				 //SeleniumUtils.delay(2000);
			   txtSubmissionNotes.click(); 
			   }
		   
		// Conf Massege 
		   public String ConfirmationProcessId() {
			   SeleniumUtils.delay(4000);
			   String ConfMessage=lblConfOk.getText();
			   //System.out.println("String is "+ConfMessage);
			   return ConfMessage.substring(8,13);
		   }
		   
		// Confirmation Ok Button
		   public boolean isConfOkBtnDisplayed(){
			   return btnConfOk.isDisplayed();  	
		   }  
	   
		   public void clickConfOkButton(){
			   String ConfMessage=lblConfOk.getText();
			   btnConfOk.click();
			   report.log(LogStatus.PASS, ""+ConfMessage+" Clicked on Confirmation Ok Button"); 
		   }  
				   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
	    	 if(inputPrimaryLedger.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Basic Options Page</span></a>");
		   	return new Item(xyz);
	   }

}
