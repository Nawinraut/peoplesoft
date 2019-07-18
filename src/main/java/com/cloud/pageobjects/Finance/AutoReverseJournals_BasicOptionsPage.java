package com.cloud.pageobjects.Finance;

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

public class AutoReverseJournals_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'basicReqBody:paramDynForm_Attribute2_ATTRIBUTE2::content')]")
	    private WebElement selectReversalPeriod;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestHeader:reqDesc::content')]")
	   private WebElement txtSubmissionNotes;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:requestBtns:submitButton')]")
	   private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:confirmationPopup:pt_ol1')]")
	   private WebElement lblConfMsg;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:confirmationPopup:confirmSubmitDialog::ok')]")
	   private WebElement btnConfOK;
	 
	 public WebDriverWait wdwait; 
	    
		/**
		* Initializing page objects for Manage Journals Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public AutoReverseJournals_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     wdwait.until(ExpectedConditions.visibilityOf(selectReversalPeriod));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		    
		        System.out.println("******************************* Basic Options Page *****************************");
		       this.getScreenDetails();
		    }
	    
	 // Reversal Period Value verification
	    public void selectReversalPeriodList(String strReversalPeriod){	
	    	Select objSelect=new Select(selectReversalPeriod);
	    	objSelect.selectByVisibleText(strReversalPeriod);
	    }
	    
	    public boolean isReversalPeriodListDisplayed(){
		 	   return selectReversalPeriod.isDisplayed();
		    } 
	    // Click on Submission Notes field
	    public void clickSubmissionNotesField(){	
	    	txtSubmissionNotes.click();
	    }
	    
	    // Search Submit button Reversal Period
	    
	    public void clickSubmitButton(){
	    	SeleniumUtils.delay(2000);
	    	btnSubmit.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(btnConfOK));
	 	   report.log(LogStatus.PASS, "Clicked on Submit Button");
	    }
	    public boolean isSubmitBtnDisplayed(){
		 	   return btnSubmit.isDisplayed();
		    }
	    
	    // Click on Confirmation Ok button
	    public JournalsPage clickConfOkButton() throws TestException{
	    	SeleniumUtils.delay(5000);
	    	btnConfOK.click();
	 	   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	 	   return new JournalsPage(driver, report);
	    }
	    public boolean isConfOkBtnDisplayed(){
		 	   return btnConfOK.isDisplayed();
		    }
	    
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
	    	 if(selectReversalPeriod.isDisplayed())
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
