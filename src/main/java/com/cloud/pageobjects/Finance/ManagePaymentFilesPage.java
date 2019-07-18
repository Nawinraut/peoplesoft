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

public class ManagePaymentFilesPage extends BasePageObject{
	
	public WebDriver driver;
	
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:Manag1:0:AP1:SPb')]")
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:SPb')]")
    private WebElement btnDone;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1:value00::content')]")
    private WebElement txtReference;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1:value10::content')]")
    private WebElement txtAdmReference;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'AP1:q1:value40::content')]")
    private WebElement selectStatus;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1::search')]")
    private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pt1:Manag1:0:AP1:AT1:_ATp:t1::db')]//div")
    private WebElement tableMngPaymentFile;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':commandImageLink1::icon')]")
    private WebElement btnAction;
	
	
	
	public WebDriverWait wdwait; 
    
	/**
	* Initializing page objects for Manage Journals Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public ManagePaymentFilesPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(btnDone));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	    
	        System.out.println("******************************* Manage Payment Files Page *****************************");
	       this.getScreenDetails();
	    }
    
    // Reference field
	   
	   
	   public void enterReference(String strReference){
		   SeleniumUtils.delay(8000);
		   txtReference.clear();
		   txtReference.click();
		   txtReference.sendKeys(strReference);
		   txtReference.click();
	   }
	   
	   public boolean isReferenceDisplayed(){
		   return txtReference.isDisplayed();
		   }
	   
// Status list
	   
	   
	   public void selectStatuslist(String strStatus){
		  Select objSelect=new Select(selectStatus);
		  objSelect.selectByVisibleText(strStatus);
		  
	   }
	   
	   public boolean isStatuslistDisplayed(){
		   return selectStatus.isDisplayed();
		   } 
	   
	// Search button
	   
	   public void clickSearchButton(){	
		   btnSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(tableMngPaymentFile));
		   report.log(LogStatus.PASS, "Clicked on Search button");  
		   
	   }
	   
	   public boolean isSearchBtnDisplayed(){
		   return btnSearch.isDisplayed();
	   }
	   
// Done button
	   
	   public void clickDoneButton(){	
		   btnDone.click();
		   report.log(LogStatus.PASS, "Clicked on Done button");  
		   
	   }
	   
	   public boolean isDoneBtnDisplayed(){
		   return btnDone.isDisplayed();
	   }
	   
	   //btnAction
	   
	   public PaymentFilePage clickActionButton() throws TestException{	
		   wdwait.until(ExpectedConditions.visibilityOf(btnAction));
		   btnAction.click();
		   report.log(LogStatus.PASS, "Clicked on Action button"); 
		   return new PaymentFilePage(driver, report);
		   
	   }
	   
	   public PrintPaymentDocumentsPage clickActionButtn() throws TestException{	
		   wdwait.until(ExpectedConditions.visibilityOf(btnAction));
		   btnAction.click();
		   report.log(LogStatus.PASS, "Clicked on Action button"); 
		   return new PrintPaymentDocumentsPage(driver, report);
		   
	   }
	   
	   
	   public ReprintPaymentDocuments_PaymentFilePage clickActionButtonn() throws TestException{	
		   wdwait.until(ExpectedConditions.visibilityOf(btnAction));
		   btnAction.click();
		   report.log(LogStatus.PASS, "Clicked on Action button"); 
		   return new ReprintPaymentDocuments_PaymentFilePage(driver, report);
		   
	   }
	   
	   public boolean isActionBtnDisplayed(){
		   return btnAction.isDisplayed();
	   }
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Manage Payment Files Page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Payment Files Page</span></a>");
	   	return new Item(xyz);
   }


}
