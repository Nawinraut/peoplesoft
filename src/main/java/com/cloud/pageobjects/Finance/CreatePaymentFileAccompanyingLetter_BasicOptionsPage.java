package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
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

public class CreatePaymentFileAccompanyingLetter_BasicOptionsPage extends BasePageObject{
	
public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute1_ATTRIBUTE1::lovIconId')]")
	    private WebElement iconPaymentFileSearch;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute1_ATTRIBUTE1::dropdownPopup::popupsearch')]")
	    private WebElement lnkPaymentFileSearch;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'Attribute1_ATTRIBUTE1::_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtPaymentFileReference;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'Attribute1_ATTRIBUTE1::_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtAdminReference;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnPaymentFileReferenceSearch;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnPaymentFileReferenceOk;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'requestBtns:confirmationPopup:confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfirmation;
	
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	 public CreatePaymentFileAccompanyingLetter_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(iconPaymentFileSearch));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Create Payment File Accompanying Letter Page *****************************");
	       this.getScreenDetails();
	    }
	 
	// Click on icon Payment File   
	   
	   public void clickSearchPaymentFileIcon(){	
		   iconPaymentFileSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(lnkPaymentFileSearch));
		   report.log(LogStatus.PASS, "Clicked on Payment File Search icon");  
		   
	   }
	   
	   public boolean isSearchPaymentFileIconDisplayed(){
		   return iconPaymentFileSearch.isDisplayed();
	   }
	   
	 //Search link for Payment File
	   
	   public void clickPaymentFileSearchLink() throws InterruptedException{	

		   lnkPaymentFileSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(txtPaymentFileReference));
		   report.log(LogStatus.PASS, "Clicked on Payment File Search link");
		   this.getScreenDetails();
	   }
	   
	   public boolean isPaymentFileSearchLinkDisplayed(){
		   return lnkPaymentFileSearch.isDisplayed();
	   }  
	   
	 //Value for Payment File Reference 
	   
	   public void enterPaymentFileReference(String value) throws InterruptedException{
		   SeleniumUtils.delay(3000);
		   txtPaymentFileReference.clear();
		   txtPaymentFileReference.click();
		   txtPaymentFileReference.sendKeys(value);
		  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
	   }
	   
	   public boolean isPaymentFileReferenceDisplayed(){
		   return txtPaymentFileReference.isDisplayed();
		   } 
	   
	   public void clickAdminReferenceField(){	
		   txtAdminReference.click();
		   
	   }
	   
	// Search button in Payment File Reference
	   public void clickPaymentFileReferenceSearchButton(){	
		   btnPaymentFileReferenceSearch.click();
			SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Payment File Reference Search button");
	   }
	   
	   public boolean isPaymentFileReferenceSearchButtonDisplayed(){
		   return btnPaymentFileReferenceSearch.isDisplayed();
	   } 
	   
	   //Select Event (select given text from dropdown)
	   public void selectPaymentFileReference(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	//  Ok Button for Payment File Reference
	   
	   public void clickPaymentFileReferenceOkButton(){	
		   btnPaymentFileReferenceOk.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Payment File Reference Ok Button");
		   this.getScreenDetails(); 
		   
	   }
	   
	   public boolean isPaymentFileReferenceOkButtonDisplayed(){
		   return btnPaymentFileReferenceOk.isDisplayed();
	   } 
	  
	   public void clickSubmissionNotesField(){	
		   txtSubmissionNotes.click();   
	   }
	 
	// submit button
	   
	   public void clickSubmitButton(){
		 SeleniumUtils.delay(2000);
		   btnSubmit.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Submit Button");
		   this.getScreenDetails("Confirmation Pop-up");
	   }
	   
	   public boolean isSubmitBtnDisplayed(){
		   return btnSubmit.isDisplayed();
	   	
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
			
			 report.log(LogStatus.PASS, "Create Payment File Accompanying Letter page is Loaded Successfully");
	    	 if(iconPaymentFileSearch.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Payment File Accompanying Letter Page</span></a>");
		   	return new Item(xyz);
	   }

}
