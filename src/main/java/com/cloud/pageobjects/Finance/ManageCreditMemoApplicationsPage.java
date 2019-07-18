package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
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

public class ManageCreditMemoApplicationsPage extends BasePageObject{
	
	public WebDriver driver;
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'qryId1:value00::content')]")
    private WebElement selectBusinessUnit;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'qryId1:value30::content')]")
    private WebElement txtTransactionNumber;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'qryId1:value50::content')]")
    private WebElement txtTransactionReference;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'qryId1::search')]")
    private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//img[contains(@id,'_ATp:edit::icon')]")
	 private WebElement btnEdit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'t1::db')]")
    private WebElement tableCreditMemo;
	
	
	public WebDriverWait wdwait; 
	
	 public ManageCreditMemoApplicationsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Manage Credit Memo Applications Page *****************************");
	       this.getScreenDetails();
	    }
	
	 
	//BusinessUnit list
	   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
	   	selectBusinessUnit.click();
	   	selectBusinessUnit.sendKeys(strBusinessUnit);
	    selectBusinessUnit.sendKeys(Keys.ENTER);
	   	selectBusinessUnit.click();
	   	//SeleniumUtils.delay(2000);
	    
	   }
	   
	   public boolean isSelectBusinessUnitDisplayed(){
		   return selectBusinessUnit.isDisplayed();
		   } 
	   
	   // Transaction Number  field 
	   
	   public void enterTransactionNumber(String strTransactionNumber) throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtTransactionNumber.clear();
		   txtTransactionNumber.click();
		   txtTransactionNumber.sendKeys(strTransactionNumber);
		   txtTransactionReference.click();
		  // report.log(LogStatus.PASS, "Transaction Number is entered successfully: "+strTransactionNumber);
	   }
	   
	   public boolean isTransactionNumberDisplayed(){
		   return txtTransactionNumber.isDisplayed();
		   } 
	   
	// Search Button  
	   public void clickSearchButton(){	
		   btnSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(tableCreditMemo));
		   report.log(LogStatus.PASS, "Clicked on Search button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isSearchBtnDisplayed(){
		   return btnSearch.isDisplayed();
	   	
	   }
	   
	 //Select Event (select given text from dropdown)
	   public void selectTransactionCell(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'t1::db')]//*[contains(text(), '"+eventName+"')]")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   
		   }
	   
	   
	   
	   @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Manage Credit Memo Applications Page is Loaded Successfully");
	    	 if(selectBusinessUnit.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Credit Memo Applications Page</span></a>");
		   	return new Item(xyz);
	   }

}
