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
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ManageCustomersPage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1:value10::content')]")
    private WebElement txtOrganizationName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:q1::search')]")
    private WebElement btnSearch;
	
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table1:0:commandLink1')]")
	@FindBy(how=How.XPATH, using = "//span[contains(@id,'AT1:_ATp:table1:0:commandLink1')]//a[@class='xmi']//span[@title='"+"']")
    private WebElement lnkAccountNumber;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table1:0:outputText61')]")
    private WebElement lnkSiteNumber;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:cb1')]")
    private WebElement btnDone;
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public ManageCustomersPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	    // wdwait.until(ExpectedConditions.visibilityOf(txtOrganizationName));
	     wdwait.until(ExpectedConditions.visibilityOf(btnDone));
	     
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Manage Customers Page *****************************");
	       this.getScreenDetails();
	    }
    
  //Enter text into Organization Name field
	   public void enterOrganizationName(String strSupplier){
		   txtOrganizationName.clear();
		   txtOrganizationName.click();
		   txtOrganizationName.sendKeys(strSupplier);
		   txtOrganizationName.click();
		  
	   }
	   
	   public boolean isOrganizationNameFieldDisplayed(){
		   return txtOrganizationName.isDisplayed();
		   }
	   
	//  Search Button 
	   public void clickSearchButton(){
		   btnSearch.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.visibilityOf(lnkAccountNumber));
		   report.log(LogStatus.PASS, "Clicked on Search Button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isSearchBtnDisplayed() throws InterruptedException{
		   return btnSearch.isDisplayed();		 
	   }
	   
	   
	   // Click on Account Number Link
	   public EditAccountPage clickAccountNumberLink() throws TestException{
		   this.getScreenDetails();
		   lnkAccountNumber.click();
		   report.log(LogStatus.PASS, "Clicked on Account Number Link");
		   return new EditAccountPage(driver, report);
	   }
	   
	   public boolean isAccountNumberLnkDisplayed() throws InterruptedException{
		   return lnkAccountNumber.isDisplayed();		 
	   }
	   
	 //lnkSiteNumber 
	   public EditSitePage clickSiteNumberLink() throws TestException{
		   this.getScreenDetails();
		   lnkSiteNumber.click();
		   report.log(LogStatus.PASS, "Clicked on Site Number Link");
		   return new EditSitePage(driver, report);
	   }
	   
	   public boolean isSiteNumberLnkDisplayed() throws InterruptedException{
		   return lnkSiteNumber.isDisplayed();		 
	   }
	   
	   //btnDone
	//  Warning Yes 
	   public void clickDoneButton(){
		   btnDone.click();
		  // wdwait.until(ExpectedConditions.visibilityOf(lstCorrectRecord));
		   report.log(LogStatus.PASS, "Clicked on Done Button");
		  
	   }
	   
	   public boolean isDoneBtnDisplayed() throws InterruptedException{
		   return btnDone.isDisplayed();		 
	   }
	   
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Manage Customers page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Customers Page</span></a>");
	   	return new Item(xyz);
   }

}
