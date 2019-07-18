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

public class CreateSiteProfilePage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:cb2')]")
    private WebElement btnSaveAndClose;
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public CreateSiteProfilePage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(btnSaveAndClose));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Create Site Profile Page *****************************");
	       this.getScreenDetails();
	    }
    
//  Save And Close 
	   public EditSitePage clickSaveAndCloseButton() throws TestException{
		   btnSaveAndClose.click();
		   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
		  return new EditSitePage(driver, report);
	   }
	   
	   public boolean isSaveAndCloseBtnDisplayed() throws InterruptedException{
		   return btnSaveAndClose.isDisplayed();		 
	   }
    
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Create Site Profile page is Loaded Successfully");
    	 if(btnSaveAndClose.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Site Profile Page</span></a>");
	   	return new Item(xyz);
   }

}
