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

public class CreateBalanceSheetClosingJournals_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'soc3::content')]")
	    private WebElement selectAccountingPeriod;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'kf1CS::content')]")
	    private WebElement txtClosingAccount;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'soc1::content')]")
	    private WebElement selectCategory;
	 
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
	    
	    
	    public CreateBalanceSheetClosingJournals_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(selectAccountingPeriod));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Basic Options Page *****************************");
		       this.getScreenDetails();
		    }
	 // Accounting Period  List
	    public void SelectAccountingPeriodList(String strAccountingPeriod){
	    	  SeleniumUtils.delay(2000);
			  Select objSelect= new Select(selectAccountingPeriod);
			  objSelect.selectByVisibleText(strAccountingPeriod);
		   }
		   
		   public boolean isAccountingPeriodListDisplayed(){
			   return selectAccountingPeriod.isDisplayed();
			   }
		   
		   // Closing Account  List
		    public void enterClosingAccountField(String strClosingAccount){
		    	txtClosingAccount.clear();
		    	txtClosingAccount.click();
		    	txtClosingAccount.sendKeys(strClosingAccount);
			   }
			   
			   public boolean isClosingAccountFieldDisplayed(){
				   return txtClosingAccount.isDisplayed();
				   }
		   
		// Category  List
		    public void SelectCategoryList(String strCategory){
		    	  SeleniumUtils.delay(2000);
				  Select objSelect= new Select(selectCategory);
				  objSelect.selectByVisibleText(strCategory);
			   }
			   
			   public boolean isCategoryListDisplayed(){
				   return selectCategory.isDisplayed();
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
	    	 if(selectAccountingPeriod.isDisplayed())
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
