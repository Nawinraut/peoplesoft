package com.cloud.pageobjects.Finance;

import org.openqa.selenium.JavascriptExecutor;
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

public class PrintPaymentDocumentsPage extends BasePageObject{
	
public WebDriver driver;
	
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:Manag1:1:ap1:commandButton4')]")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton4')]")
    private WebElement btnFormat;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton3')]")
    private WebElement btnCancel;
	
	@FindBy(how=How.XPATH, using = "//div[@class='xm9']")
    private WebElement mnuAction;
	
	@FindBy(how=How.XPATH, using = "//td[@class='xnn'][text()='Terminate Payment Process']")
    private WebElement lstTerminatePaymentProcess;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_FOd1::msgDlg::cancel')]")
    private WebElement btnConfOk;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:commandButton1')]")
    private WebElement btnWarningOk;
	
	
public WebDriverWait wdwait; 
    
	/**
	* Initializing page objects for Manage Journals Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public PrintPaymentDocumentsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(btnFormat));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	    
	        System.out.println("******************************* Print Payment Documents Page *****************************");
	       this.getScreenDetails();
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
		   wdwait.until(ExpectedConditions.visibilityOf(btnWarningOk));
		   report.log(LogStatus.PASS, "Clicked on TerminatePaymentProcess List"); 
		   
	   }
	   
	   public boolean isTerminatePaymentProcessListDisplayed(){
		   return lstTerminatePaymentProcess.isDisplayed();
	   }
	   
    
  //btnFormat
	   
	   public void clickFormatButton(){	
		   
		   JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnFormat);
	    	//btnTasks.click();
	    	//wdwait.until(ExpectedConditions.visibilityOf(lnkCreateAccouinting));
	    	
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		  // btnFormat.click();
		   report.log(LogStatus.PASS, "Clicked on Format button"); 
		   
	   }
	   
	   public boolean isFormatBtnDisplayed(){
		   return btnFormat.isDisplayed();
	   }
	   
public void clickPrintButton(){	
		   
		   JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnFormat);
	    	//btnTasks.click();
	    	//wdwait.until(ExpectedConditions.visibilityOf(lnkCreateAccouinting));
	    	
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		  // btnFormat.click();
		   report.log(LogStatus.PASS, "Clicked on Print button"); 
		   
	   }
	   
	   public boolean isPrintBtnDisplayed(){
		   return btnFormat.isDisplayed();
	   }
	   
//Confirmation Ok
	   
	   public ManagePaymentFilesPage clickConfOkButton() throws TestException{	
		   btnConfOk.click();
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok button"); 
		   return new ManagePaymentFilesPage(driver, report);
		   
	   }
	   
	   public boolean isConfOkBtnDisplayed(){
		   return btnConfOk.isDisplayed();
	   }
	   
	   
//Warning Ok
	   
	   public ManagePaymentProcessRequestsPage clickWarningOkButton() throws TestException{	
		   btnWarningOk.click();
		   report.log(LogStatus.PASS, "Clicked on Warning Ok button"); 
		   return new ManagePaymentProcessRequestsPage(driver, report);
		   
	   }
	   
	   public boolean isWarningOkBtnDisplayed(){
		   return btnWarningOk.isDisplayed();
	   }
	   
	   
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Print Payment Documents Page is Loaded Successfully");
		 if(btnFormat.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Print Payment Documents Page</span></a>");
	   	return new Item(xyz);
   }


}
