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

public class EditSitePage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:cushowDetailItem3::ti')]/div")
    private WebElement lnkProfileHistory;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'cupanel1:siteProfileButton')]")
    private WebElement btnCreateSiteProfile;
	
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
    
    
    public EditSitePage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(lnkProfileHistory));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Edit Site Page *****************************");
	       this.getScreenDetails();
	    }
    
    //  Profile History Link 
	   public void clickProfileHistoryLink(){
		   lnkProfileHistory.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnCreateSiteProfile));
		   report.log(LogStatus.PASS, "Clicked on Profile History Link");
		   this.getScreenDetails();
	   }
	   
	   public boolean isProfileHistoryLnkDisplayed() throws InterruptedException{
		   return lnkProfileHistory.isDisplayed();		 
	   }
	   
	//  CreateSiteProfile 
	   public CreateSiteProfilePage clickCreateSiteProfileButton() throws TestException{
		   btnCreateSiteProfile.click();
		   report.log(LogStatus.PASS, "Clicked on Create Site Profile Button");
		  return new CreateSiteProfilePage(driver, report);
	   }
	   
	//  Save And Close 
	   public ManageCustomersPage clickSaveAndCloseButton() throws TestException{
		   btnSaveAndClose.click();
		   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
		  return new ManageCustomersPage(driver, report);
	   }
	   
	   public boolean isSaveAndCloseBtnDisplayed() throws InterruptedException{
		   return btnSaveAndClose.isDisplayed();		 
	   }
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Edit Site page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Site Page</span></a>");
	   	return new Item(xyz);
   }

}
