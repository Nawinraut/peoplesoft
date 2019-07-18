package com.cloud.pageobjects.Finance;

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

public class ManageReceiptsPage extends BasePageObject{
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value00::content')]")
    private WebElement selectBusinessUnit;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value10::content')]")
    private WebElement txtReceiptNumber;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value50::content')]")
    private WebElement txtBatch;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'q1::search')]")
    private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:t1::db')]")
    private WebElement tableMngRcpt;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton1')]")
    private WebElement btnDone;
	
	public WebDriverWait wdwait;
	public ManageReceiptsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Manage Receipts Page *****************************");
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
	   
 // Receipt Number  field 
	   
	   public void enterReceiptNumber(String strReceiptNumber) throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtReceiptNumber.clear();
		   txtReceiptNumber.click();
		   txtReceiptNumber.sendKeys(strReceiptNumber);
		   txtBatch.click();
		  // report.log(LogStatus.PASS, "Transaction Number is entered successfully: "+strTransactionNumber);
	   }
	   
	   public boolean isReceiptNumberNumberDisplayed(){
		   return txtReceiptNumber.isDisplayed();
		   } 
	// Search Button  
	   public void clickSearchButton(){	
		   btnSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(tableMngRcpt));
		   report.log(LogStatus.PASS, "Clicked on Search button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isSearchBtnDisplayed(){
		   return btnSearch.isDisplayed();
	   	
	   }
	   
	 //Select Event (select given text from dropdown)
	   public EditReceiptPage selectManageReceiptsCell(String eventName) throws InterruptedException, TestException { 
		   SeleniumUtils.delay(2000);
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATp:t1::db')]//*[text()= '"+eventName+"']")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   //SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   return new EditReceiptPage(driver, report);
		   
		   }
	   
	// done Button  
	   public void clickDoneButton(){	
		   btnDone.click();
		   report.log(LogStatus.PASS, "Clicked on Done button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isDoneBtnDisplayed(){
		   return btnDone.isDisplayed();
	   	
	   }
	
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Manage Receipts Page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Receipts Page</span></a>");
	   	return new Item(xyz);
   }

}
