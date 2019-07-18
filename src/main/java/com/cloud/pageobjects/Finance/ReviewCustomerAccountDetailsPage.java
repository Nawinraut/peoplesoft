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
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReviewCustomerAccountDetailsPage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value00::content')]")
    private WebElement txtCustomer;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value10::content')]")
    private WebElement txtBilltoSite;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'q1::search')]")
    private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ATp:t1::db')]")
    private WebElement tableAccountDetails;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:SPb')]")
    private WebElement btnDone;

	
	
	public WebDriverWait wdwait;
	
	public ReviewCustomerAccountDetailsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtCustomer));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Review Customer Account Details Page *****************************");
	       this.getScreenDetails();
	    }
	
	 //Enter Application Amount field
	   public void enterCustomer(String strCustomer){
		   txtCustomer.clear();
		   txtCustomer.click();
		   txtCustomer.sendKeys(strCustomer);
		   txtBilltoSite.click();
		   //report.log(LogStatus.PASS, "Entered value for Customer field is: "+strCustomer);
	   }
	   
	   public boolean isCustomerDisplayed(){
		   return txtCustomer.isDisplayed();
		   }
	   
	// Search Button  
	   public void clickSearchButton(){	
		   btnSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(tableAccountDetails));
		   report.log(LogStatus.PASS, "Clicked on Search button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isSearchBtnDisplayed(){
		   return btnSearch.isDisplayed();
	   	
	   }
	   
// Done button
	   
	   public void clickDoneButton(){
		   btnDone.click();
		   report.log(LogStatus.PASS, "Clicked on Done Button");
	   }
	   
	   public boolean isDoneBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnDone, context.getReactTimeout());		 
	   }
	
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Review Customer Account Details Page is Loaded Successfully");
    	 if(txtCustomer.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Review Customer Account Details Page</span></a>");
	   	return new Item(xyz);
   }


}
