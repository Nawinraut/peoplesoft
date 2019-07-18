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

public class SendSeparateRemittanceAdvice_BasicOptions extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_Attribute1_ATTRIBUTE1::lovIconId')]")
	    private WebElement iconPaymentFile;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_Attribute1_ATTRIBUTE1::dropdownPopup::popupsearch')]")
	    private WebElement lnkPaymentFileSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtPaymentFileReference;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtAdminReference;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnPaymentFileSearch;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnPaymentFileOk;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'paramDynForm_Attribute2::content')]")
	    private WebElement selectFormat;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNote;
	 
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
    
	    
	    public SendSeparateRemittanceAdvice_BasicOptions(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(iconPaymentFile));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Basic Options Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	    // Search: Payment File Icon
		   
		   public void clickSearchPaymentFileIcon(){	
			   iconPaymentFile.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lnkPaymentFileSearch));
			   report.log(LogStatus.PASS, "Clicked on PaymentFile Search icon");  
			   
		   }
		   
		   public boolean isSearchPaymentFileIconDisplayed(){
			   return iconPaymentFile.isDisplayed();
		   }
		   
		   // Search :
		   
		   public void clickSearchPaymentFileLink(){	
			   lnkPaymentFileSearch.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtPaymentFileReference));
			   report.log(LogStatus.PASS, "Clicked on PaymentFile Search Link");  
			   
		   }
		   
		   public boolean isSearchPaymentFileLinkDisplayed(){
			   return lnkPaymentFileSearch.isDisplayed();
		   }
		 //Enter text into Payment File Reference field
		   public void enterPaymentFileReference(String strSupplier){
			   txtPaymentFileReference.clear();
			   txtPaymentFileReference.click();
			   txtPaymentFileReference.sendKeys(strSupplier);
			   report.log(LogStatus.PASS, "Entered Payment File Reference is: "+strSupplier);
		   }
		   
		   public boolean isPaymentFileReferenceDisplayed(){
			   return txtPaymentFileReference.isDisplayed();
			   }
		  // Supplier Number Field
		   
		   public void clickAdminReference(){
			   txtAdminReference.click();
			   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
		   }

		   
		// Supplier Search Button 
		   public void clickPaymentFileSearchButton(String eventName){
			   btnPaymentFileSearch.click();
			  // WebDriverWait wait = new WebDriverWait(driver, 50);
			   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATTRIBUTE1_afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));
			   report.log(LogStatus.PASS, "Clicked on PaymentFile Search Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isPaymentFileSearchBtnDisplayed() throws InterruptedException{
			   return btnPaymentFileSearch.isDisplayed();		 
		   }
		   
		// Supplier Search Ok Button 
		   public void clickPaymentFileOkButton(){	
			   
			   btnPaymentFileOk.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Payment File Ok Button");
		   }
		   
		   public boolean isPaymentFileOkBtnDisplayed() throws InterruptedException{
			   return btnPaymentFileOk.isDisplayed();	 
		   }  
	    
		 //Select Event (select given text from dropdown)
		   public void selectEvent(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATTRIBUTE1_afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		   //Format list
		   
		   public void selectFormatList(String strFile){
		    	Select objSelect = new Select(selectFormat);
		    	objSelect.selectByVisibleText(strFile);
		    	SeleniumUtils.delay(2000);
		    	//report.log(LogStatus.PASS, "Selected Format is: "+strFile);
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
			   SeleniumUtils.delay(4000);
		   }  
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Basic Options Page is Loaded Successfully");
	    	 if(iconPaymentFile.isDisplayed())
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
