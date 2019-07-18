package com.cloud.pageobjects.Finance;

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

public class GenerateAllocations_BasicOptionsPage extends BasePageObject{
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:basicReqBody:dynam1:0:nameId::content')]")
    private WebElement inputRuleOrRuleSet;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'requestHeader:reqDesc::content')]")
    private WebElement txtSubmissionNote;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':requestBtns:submitButton')]")
    private WebElement btnSubmit;
 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfirmation;
	
	public WebDriverWait wdwait; 
    
	/**
	* Initializing page objects for Manage Journals Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public GenerateAllocations_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(txtSubmissionNote));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	    
	        System.out.println("******************************* Basic Options Page *****************************");
	       this.getScreenDetails();
	    }
    
    //Select Rule or Rule Set List
    public void selectRuleOrRuleSetList(String strRuleOrRuleSet){
    	inputRuleOrRuleSet.clear();
    	inputRuleOrRuleSet.click();
    	inputRuleOrRuleSet.sendKeys(strRuleOrRuleSet);
    	inputRuleOrRuleSet.sendKeys(Keys.ENTER);
    	inputRuleOrRuleSet.click();
 	   
    }
    
    public boolean isRuleOrRuleSetListDisplayed(){
	 	   return inputRuleOrRuleSet.isDisplayed();
	    }
  //Click on Submission Note field
	   public void clickSubmissionNote(){
		   txtSubmissionNote.click();
		   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
	   }

	// Submit button  
	   public void clickSubmitButton(){	
		   
		   btnSubmit.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Submit Button");
		   this.getScreenDetails("Confirmation Pop-up");
	   }
	   
	   public boolean isSubmitBtnDisplayed() throws InterruptedException{
		   return btnSubmit.isDisplayed();	 
	   } 
	   
	// Conf Massege 
	   public String ConfirmationProcessId() {
		   SeleniumUtils.delay(4000);
		   String ConfMessage=lblConfirmation.getText();
		   //System.out.println("String is "+ConfMessage);
		   return ConfMessage.substring(8,13);
	   }
	   
	// Confirmation Ok Button
	   public boolean isConfOkBtnDisplayed(){
		   return btnConfOk.isDisplayed();  	
	   }  

	   public void clickConfOkButton(){
		   String ConfMessage=lblConfirmation.getText();
		   btnConfOk.click();
		   report.log(LogStatus.PASS, ""+ConfMessage+" Clicked on Confirmation Ok Button");
		   SeleniumUtils.delay(3000);
	   }  
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Basic Options Page is Loaded Successfully");
		 if(txtSubmissionNote.isDisplayed())
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
