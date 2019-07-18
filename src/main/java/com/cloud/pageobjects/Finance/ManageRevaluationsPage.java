package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
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

public class ManageRevaluationsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:AT1:_ATp:cb1')]")
	    private WebElement btnGenerate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table3::db')]/table/tbody/tr/td[1]")
	    private WebElement tbleMngRevaluations;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc2::content')]")
	    private WebElement selectLedgerorLedgerSet;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc1::content')]")
	    private WebElement selectRevaluation;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc3::content')]")
	    private WebElement selectAccountingPeriod;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfText;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dialogGenerate::close')]")
	    private WebElement btnClose;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb3')]")
	    private WebElement btnDone;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ManageRevaluationsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnGenerate));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Manage Revaluations Page *****************************");
		       this.getScreenDetails();
		    }
	    
	  //Select Event (select given text from dropdown)
		   public void selectRevaluationCell(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATp:table3::db')]//div//td[contains(.,'"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected Revaluation Cell successfully");
			   }
		   
		   // Submit button
		   
		   public boolean isGenerateButtonDisplayed(){
			   return btnGenerate.isDisplayed();  	
		   }  
		   
		   public void clickGenerateButton(){	
			   btnGenerate.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtSubmissionNotes));
			   report.log(LogStatus.PASS, "Clicked on Generate Button");
			   this.getScreenDetails("Generate Revaluation Pop-up");
		   }  
		   
		// Select Ledger or Ledger Set 
		   public void selectLedgerSetList(String strLedgerSet){
			  
		    	Select objSelect = new Select(selectLedgerorLedgerSet);
		    	objSelect.selectByVisibleText(strLedgerSet);
		    }
		   
		   public boolean isLedgerSetListDisplayed(){
			   return selectLedgerorLedgerSet.isDisplayed();
		   }
		   
		// Select Revaluation
		   public void selectRevaluationList(String strRevaluation){
			   SeleniumUtils.delay(2000);
		    	Select objSelect = new Select(selectRevaluation);
		    	objSelect.selectByVisibleText(strRevaluation);
		    }
		   
		   public boolean isRevaluationListDisplayed(){
			   return selectRevaluation.isDisplayed();
		   }
		   
		// Select Accounting Period
		   public void selectAccountingPeriodList(String strAccountingPeriod){
			   SeleniumUtils.delay(5000);
		    	Select objSelect = new Select(selectAccountingPeriod);
		    	objSelect.selectByVisibleText(strAccountingPeriod);
		    	SeleniumUtils.delay(3000);
		    }
		   
		   public boolean isAccountingPeriodListDisplayed(){
			   return selectAccountingPeriod.isDisplayed();
		   }
		   
		   // click Submission Notes
		   public void clickSubmissionNotesField(){	
			   txtSubmissionNotes.click();
		   }
		   
		   public boolean isSubmissionNotesfieldDisplayed(){
			   return txtSubmissionNotes.isDisplayed();  	
		   }
	 // Submit button
		   
		   public boolean isSubmitButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());  	
		   }  
		   
		   public void clickSubmitButton(){	
			   SeleniumUtils.delay(1000);
			   btnSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   //SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			   this.getScreenDetails("Confirmation Pop-up");
		   }
		   
		// Confirmation Ok Button   
		   public boolean isConfOkButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  
			   //return btnConfOk.isDisplayed();
		   }  
	   
		   public void clickConfOkButton(){
			   SeleniumUtils.delay(2000);
			   String strProcess =lblConfText.getText();
			   btnConfOk.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, ""+strProcess+" and Clicked on Confirmation Ok Button");
			  
		   }
		   
		// Close Button   
		   public boolean isCloseButtonDisplayed(){
			   return btnClose.isDisplayed();  
			  
		   }  
	   
		   public void clickCloseButton(){
			   btnClose.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Close Button");
			   this.getScreenDetails();
			  
		   }
		   
		// Done Button   
		   public boolean isDoneButtonDisplayed(){
			   return btnDone.isDisplayed();  
			  
		   }  
	   
		   public void clickDoneButton(){
			   btnDone.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Done Button");
			  
		   }
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Manage Revaluations page is Loaded Successfully");
	    	 if(btnGenerate.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Revaluations Page</span></a>");
		   	return new Item(xyz);
	   }


}
