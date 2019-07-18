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

public class EditAccountPage extends BasePageObject{
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:cushowDetailItem5::ti')]/div")
    private WebElement lnkProfileHistory;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:cuapplicationsTable3:_ATp:ATm')]/div/table/tbody/tr/td[3]/div")
    private WebElement mnuActions;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:cuapplicationsTable3:_ATp:cucorrectRecordMenu')]/td[2]")
    private WebElement lstCorrectRecord;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:profileClassId::content')]")
    private WebElement inputProfileClass;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:cb111')]")
    private WebElement btnWarningYes;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:cucommandButton2')]")
    private WebElement btnSaveAndClose;
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public EditAccountPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(lnkProfileHistory));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Edit Account Page *****************************");
	       this.getScreenDetails();
	    }
    
    //  Profile History Link 
	   public void clickProfileHistoryLink(){
		   lnkProfileHistory.click();
		   wdwait.until(ExpectedConditions.visibilityOf(mnuActions));
		   report.log(LogStatus.PASS, "Clicked on Profile History Link");
		   this.getScreenDetails();
	   }
	   
	   public boolean isProfileHistoryLnkDisplayed() throws InterruptedException{
		   return lnkProfileHistory.isDisplayed();		 
	   }
    
	//  Actions Menu 
		   public void clickActionsMenu(){
			   mnuActions.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lstCorrectRecord));
			   report.log(LogStatus.PASS, "Clicked on Actions Menu");
			  
		   }
		   
		   public boolean isActionsMenuDisplayed() throws InterruptedException{
			   return mnuActions.isDisplayed();		 
		   }
		   
		//  Correct Record List
		   public void selectCorrectRecordList(){
			   lstCorrectRecord.click();
			   wdwait.until(ExpectedConditions.visibilityOf(inputProfileClass));
			   report.log(LogStatus.PASS, "Clicked on Correct Record List");
			  
		   }
		   
		   public boolean isCorrectRecordLstDisplayed() throws InterruptedException{
			   return lstCorrectRecord.isDisplayed();		 
		   }
		   
		//  inputProfileClass
		   public void selectProfileClassList(String strProfileClass){
			   SeleniumUtils.delay(5000);
			   inputProfileClass.clear();
			   inputProfileClass.click();
			   inputProfileClass.sendKeys(strProfileClass);
			   inputProfileClass.sendKeys(Keys.ENTER);
			   inputProfileClass.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnWarningYes));
		   }
		   
		   public boolean isProfileClassLstDisplayed(){
			   return inputProfileClass.isDisplayed();		 
		   }
		   
		//  Warning Yes 
		   public void clickWarningYesButton(){
			   SeleniumUtils.delay(5000);
			   btnWarningYes.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(lstCorrectRecord));
			   wdwait.until(ExpectedConditions.visibilityOf(btnSaveAndClose));
			   report.log(LogStatus.PASS, "Clicked on Warning Yes Button");
			  
		   }
		   
		   public boolean isWarningYesBtnDisplayed() throws InterruptedException{
			   return btnWarningYes.isDisplayed();		 
		   }
		   
		//  Save And Close 
		   public ManageCustomersPage clickSaveAndCloseButton() throws TestException{
			   SeleniumUtils.delay(5000);
			   btnSaveAndClose.click();
			   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
			  return new ManageCustomersPage(driver, report);
		   }
		      
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Edit Account page is Loaded Successfully");
    	 if(lnkProfileHistory.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Account Page</span></a>");
	   	return new Item(xyz);
   }

}
