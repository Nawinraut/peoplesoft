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

public class ManageTransactionsPage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value00::content')]")
    private WebElement selectBusinessUnit;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value40::content')]")
    private WebElement txtTransactionNumber;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value70::content')]")
    private WebElement txtReference;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'q1::search')]")
    private WebElement btnSearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table2::db')]")
    private WebElement tableMngTransaction;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb1')]")
    private WebElement btnDone;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'msgDlg::cancel')]")
    private WebElement btnInfOk;

	
	
	public WebDriverWait wdwait;
	
	public ManageTransactionsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Manage Transactions Page *****************************");
	       this.getScreenDetails();
	    }
	//BusinessUnit list
	   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
	   	selectBusinessUnit.click();
	   	selectBusinessUnit.clear();
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
		   txtReference.click();
		   report.log(LogStatus.PASS, "Transactio nNumber is entered successfully: "+strTransactionNumber);
	   }
	   
	   public boolean isTransactionNumberDisplayed(){
		   return txtTransactionNumber.isDisplayed();
		   } 
	
	// Search Button  
	   public void clickTransactionSearchButton(){	
		   btnSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(tableMngTransaction));
		   report.log(LogStatus.PASS, "Clicked on Search button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isTransactionSearchBtnDisplayed(){
		   return btnSearch.isDisplayed();
	   	
	   }
	   
	   //Select Event (select given text from dropdown)
	   public ReviewTransactionPage selectTransactionCell(String eventName) throws InterruptedException, TestException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATp:table2::db')]//*[text()='"+eventName+"']")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   //SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   return new ReviewTransactionPage(driver,report);
		   }
	   
	// Done Button
	   public boolean isDoneButtonDisplayed(){
		   return btnDone.isDisplayed();  	
	   }  
	   
	 public void clickDoneButton(){	
		   btnDone.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Done Button");
	   }
	   
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Manage Transactions Page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Transactions Page</span></a>");
	   	return new Item(xyz);
   }

}
