package com.cloud.pageobjects.Finance;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CashtoGeneralLedgerReconciliationReport_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE4::content')]")
    private WebElement inputBankAccount;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE5::content')]")
    private WebElement inputFromAccountingPeriod;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE7::content')]")
    private WebElement inputToAccountingPeriod;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfirmation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;

public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public CashtoGeneralLedgerReconciliationReport_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(inputBankAccount));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Basic Options Page *****************************");
		       this.getScreenDetails();
		    }
	    
	  //Select Bank Account
		   
		   public void SelectBankAccountList(String strBankAccount) throws InterruptedException{
			   this.getScreenDetails();
			   inputBankAccount.clear();
			   inputBankAccount.click();
			   inputBankAccount.sendKeys(strBankAccount);
			   //inputBankAccount.sendKeys(Keys.ENTER);
			   inputBankAccount.click();
		    	SeleniumUtils.delay(3000);
		   }
		   
		   public boolean isBankAccountDisplayed(){
			   return inputBankAccount.isDisplayed();
			   } 
		   
		   //Select From Accounting Period
		   
		   public void SelectFromAccountingPeriodList(String strFromAccountingPeriod){
			   SeleniumUtils.delay(5000);
			   //JavascriptExecutor jse = (JavascriptExecutor) driver;
			   //inputFromAccountingPeriod.clear();
			   inputFromAccountingPeriod.click();
			  
			   //jse.executeScript("inputFromAccountingPeriod.value = strFromAccountingPeriod;");
			   inputFromAccountingPeriod.sendKeys(strFromAccountingPeriod);
			   //inputFromAccountingPeriod.sendKeys(Keys.ENTER);
			   inputFromAccountingPeriod.click();
		    	SeleniumUtils.delay(3000);
		   }
		   
		   public boolean isFromAccountingPeriodDisplayed(){
			   return inputFromAccountingPeriod.isDisplayed();
			   } 
		   
		   //Select To Accounting Period
		   
		   public void SelectToAccountingPeriodList(String strToAccountingPeriod){
			   inputToAccountingPeriod.click();
			   String strtoAccPeriod=inputToAccountingPeriod.getText();
			   if(strtoAccPeriod == "") {
				   inputToAccountingPeriod.clear();
				   inputToAccountingPeriod.click();
				   inputToAccountingPeriod.sendKeys(strToAccountingPeriod);
				   //inputToAccountingPeriod.sendKeys(Keys.ENTER);
				   inputToAccountingPeriod.click();
			    	SeleniumUtils.delay(3000); 
			   } 
		   }
		   
		   public boolean isToAccountingPeriodDisplayed(){
			   return inputToAccountingPeriod.isDisplayed();
			   } 
	    
	  //txtSubmissionNotes
		   public void clickSubmissionNotes() {
			   txtSubmissionNotes.click();
			   SeleniumUtils.delay(2000);
			   }
		   
	   // submit button
		   
		   public void clickSubmitButton(){	
			   SeleniumUtils.delay(3000);
			   btnSubmit.click();
			   //SeleniumUtils.delay(8000);
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			   this.getScreenDetails("Confirmation Pop-up");
		   }
		   
		   public boolean isSubmitBtnDisplayed(){
			   return btnSubmit.isDisplayed();
		   	
		   }
		   
		   // Conf Massege 
		   public String ConfirmationProcessId() {
			   SeleniumUtils.delay(4000);
			   String ConfMessage=lblConfirmation.getText();
			   //System.out.println("String is "+ConfMessage);
			   return ConfMessage.substring(8,13);
		   }
		   
		
// Conf Ok Button
		   public boolean isConfOkButtonDisplayed(){
			   return btnConfOk.isDisplayed();  	
		   }  
		   
		   public void clickConfOkButton(){	
			   String ConfMessage=lblConfirmation.getText();
			   btnConfOk.click();
			   report.log(LogStatus.PASS, ""+ConfMessage+" Clicked on Confirmation Ok Button");
		   }
		   
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
	    	 if(inputBankAccount.isDisplayed())
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
