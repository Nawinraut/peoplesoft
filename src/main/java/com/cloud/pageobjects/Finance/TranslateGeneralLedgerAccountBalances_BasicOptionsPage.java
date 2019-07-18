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

public class TranslateGeneralLedgerAccountBalances_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc2::content')]")
    private WebElement selectTargetCurrency;
 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:soc3::content')]")
	    private WebElement selectAccountingPeriod;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'dynam1:0:attribute81Id::content')]")
	    private WebElement selectBalancingSegment;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dynam1:0:attribute81Id::lovIconId')]")
	    private WebElement srchBalancingSegmenticon;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfText;
	 
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
	    
	    
	    public TranslateGeneralLedgerAccountBalances_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(txtSubmissionNotes));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Basic Options Page *****************************");
		       this.getScreenDetails();
		    }
	    
	 // Select Target Currency  
		   public void selectTargetCurrencyList(String strTargetCurrency){
			  
		    	Select objSelect = new Select(selectTargetCurrency);
		    	objSelect.selectByVisibleText(strTargetCurrency);
		    }
		   
		   public boolean isTargetCurrencyListDisplayed(){
			   return selectTargetCurrency.isDisplayed();
		   }
	    
	 // Select Accounting Period
		   public void selectAccountingPeriodList(String strAccountingPeriod){
			   SeleniumUtils.delay(2000);
		    	Select objSelect = new Select(selectAccountingPeriod);
		    	objSelect.selectByVisibleText(strAccountingPeriod);
		    }
		   
		   public boolean isAccountingPeriodListDisplayed(){
			   return selectAccountingPeriod.isDisplayed();
		   }
		   
		// Select Balancing Segment 
		   public void selectBalancingSegmentList(String strBalancingSegment){
			   SeleniumUtils.delay(5000);
		    	Select objSelect = new Select(selectBalancingSegment);
		    	objSelect.selectByVisibleText(strBalancingSegment);
		    }
		   
		   public boolean isBalancingSegmentListDisplayed(){
			   return selectBalancingSegment.isDisplayed();
		   }
		   
		   // Search BalancingSegment Icon
		   
		   public void clickBalancingSegmentSearchIcon(String eventName) throws InterruptedException{
			   srchBalancingSegmenticon.click();
		    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
			   report.log(LogStatus.PASS, "Clicked on Location Search Icon");
		   }
		   
		   public boolean isBalancingSegmentSearchIconDisplayed(){
		    return srchBalancingSegmenticon.isDisplayed();
		   }
		   
		 //Select Event (select given text from dropdown)
		   public void selectEvent(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
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
			   String strProcess =lblConfText.getText();
			   btnConfOk.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, ""+strProcess+" and Clicked on Confirmation Ok Button");
			  
		   }
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
	    	 if(txtSubmissionNotes.isDisplayed())
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
