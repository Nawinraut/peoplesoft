package com.cloud.pageobjects.Finance;

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
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PaymentFilePage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:Manag1:1:ap1:commandButton3')]")
    private WebElement btnRecordPrintStatus;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:commandButton4')]")
    private WebElement btnReprint;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton1')]")
    private WebElement btnDone;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_FOd1::msgDlg::cancel')]")
    private WebElement btnConfOk;
	
	
	@FindBy(how=How.XPATH, using = "//a[contains(text(),'Actions')]")
    private WebElement mnuAction;
	
	@FindBy(how=How.XPATH, using = "//td[contains(text(),'Terminate Payment Process')]")
    private WebElement lstTerminatePaymentProcess;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:commandButton5')]")
    private WebElement btnTerminatedConfOk;
	
	
public WebDriverWait wdwait; 
    
	/**
	* Initializing page objects for Manage Journals Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public PaymentFilePage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(btnDone));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	    
	        System.out.println("******************************* Payment File Page *****************************");
	       this.getScreenDetails();
	    }
    
  //btnRecordPrintStatus
	   
	   public RecordPrintStatus_PaymentFilePage clickRecordPrintStatusButton() throws TestException{	
		   wdwait.until(ExpectedConditions.visibilityOf(btnRecordPrintStatus));
		   btnRecordPrintStatus.click();
		   report.log(LogStatus.PASS, "Clicked on Record Print Status button"); 
		   return new RecordPrintStatus_PaymentFilePage(driver, report);
		   
	   }
	   
	   public boolean isRecordPrintStatusBtnDisplayed(){
		   return btnRecordPrintStatus.isDisplayed();
	   }
	   
//btnRecordPrintStatus
	   
	   public ReprintPaymentDocuments_PaymentFilePage clickReprintButton() throws TestException{	
		   wdwait.until(ExpectedConditions.visibilityOf(btnReprint));
		   btnReprint.click();
		   report.log(LogStatus.PASS, "Clicked on Reprint button"); 
		   return new ReprintPaymentDocuments_PaymentFilePage(driver, report);
		   
	   }
	   
	   public boolean isReprintBtnDisplayed(){
		   return btnReprint.isDisplayed();
	   }	   
	   
	   
	   
	   
//Done button
	   
	   public ManagePaymentFilesPage clickDoneButton() throws TestException{	
		   btnDone.click();
		   report.log(LogStatus.PASS, "Clicked on Done button"); 
		   return new ManagePaymentFilesPage(driver, report);
		   
	   }
	   
	   public boolean isDoneBtnDisplayed(){
		   return btnDone.isDisplayed();
	   }
	   
	   
//Confirmation Ok
	   
	   public void clickConfOkButton() throws TestException{	
		   btnConfOk.click();
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok button"); 
		   
		   
	   }
	   
	   public boolean isConfOkBtnDisplayed(){
		   return btnConfOk.isDisplayed();
	   }
	   
//Menu Action
	   
	   public void clickActionMenu(){	
		   
		   mnuAction.click();
		   wdwait.until(ExpectedConditions.visibilityOf(lstTerminatePaymentProcess));
		   report.log(LogStatus.PASS, "Clicked on Action Menu"); 
		   
	   }
	   
	   public boolean isActionMenuDisplayed(){
		   return mnuAction.isDisplayed();
	   }
//TerminatePaymentProcess List
	   
	   public void clickTerminatePaymentProcessList(){	
		   
		   lstTerminatePaymentProcess.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnTerminatedConfOk));
		   report.log(LogStatus.PASS, "Clicked on TerminatePaymentProcess List"); 
		   
	   }
	   
	   public boolean isTerminatePaymentProcessListDisplayed(){
		   return lstTerminatePaymentProcess.isDisplayed();
	   }
	   
//Terminated Ok
	   
	   public void clickTerminatedOkButton() throws TestException{	
		   btnTerminatedConfOk.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Terminated Confiramtion Ok button"); 
		     
	   }
	   
	   public boolean isTerminatedOkBtnDisplayed(){
		   return btnTerminatedConfOk.isDisplayed();
	   }
	   
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Payment File Page is Loaded Successfully");
		 if(btnDone.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Payment File Page</span></a>");
	   	return new Item(xyz);
   }


}
