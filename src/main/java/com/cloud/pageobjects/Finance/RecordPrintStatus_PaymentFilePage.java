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

public class RecordPrintStatus_PaymentFilePage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:Manag1:2:ap1:cb2')]")
    private WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:Manag1:2:ap1:commandButton3')]")
    private WebElement btnRecordthePrintStatus;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton4')]")
    private WebElement btnReprint;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_FOd1::msgDlg::cancel')]")
    private WebElement btnConfOk;
	
	
public WebDriverWait wdwait; 
    
	/**
	* Initializing page objects for Manage Journals Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public RecordPrintStatus_PaymentFilePage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(btnSubmit));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	    
	        System.out.println("******************************* Record Print Status:Payment File Page *****************************");
	       this.getScreenDetails();
	    }
    
  //Submit
	   
	   public void clickSubmitButton(){	
		   btnSubmit.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnRecordthePrintStatus));
		   report.log(LogStatus.PASS, "Clicked on submit button"); 
	   }
	   
	   public boolean isSubmitBtnDisplayed(){
		   return btnSubmit.isDisplayed();
	   }
	   
//Record the Print Status 
	   
	   public void clickRecordthePrintStatusButton(){	
		   btnRecordthePrintStatus.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Record the Print Status button"); 
	   }
	   
	   public boolean isRecordthePrintStatusBtnDisplayed(){
		   return btnRecordthePrintStatus.isDisplayed();
	   }
// Reprint Button	   
public void clickRePrintButton(){	
		   
		   JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnReprint);
	    	//btnTasks.click();
	    	//wdwait.until(ExpectedConditions.visibilityOf(lnkCreateAccouinting));
	    	
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		  // btnFormat.click();
		   report.log(LogStatus.PASS, "Clicked on RePrint button"); 
		   
	   }
	   
	   public boolean isRePrintBtnDisplayed(){
		   return btnReprint.isDisplayed();
	   }
	   
 //Confirmation Ok
	   
	   public PaymentFilePage clickConfOkButton() throws TestException{	
		   btnConfOk.click();
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok button"); 
		   return new PaymentFilePage(driver, report);
		   
	   }
	   
	   public boolean isConfOkBtnDisplayed(){
		   return btnConfOk.isDisplayed();
	   }
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Record Print Status:Payment File Page is Loaded Successfully");
		 if(btnSubmit.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Record Print Status:Payment File Page</span></a>");
	   	return new Item(xyz);
   }


}
