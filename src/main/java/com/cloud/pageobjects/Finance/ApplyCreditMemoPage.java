package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
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
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ApplyCreditMemoPage extends BasePageObject{
	
	public WebDriver driver;
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':ckaddReceivable')]")
    private WebElement btnAddOpenReceivables;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value00::content')]")
    private WebElement txtTransactionNumber;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value40::content')]")
    private WebElement txtAmount;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'q1::search')]")
    private WebElement btnTransactionSearch;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ckcb7')]")
	 private WebElement btnTransactionAdd;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ckcb8')]")
	 private WebElement btnTransactionDone;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:t2::db')]")
    private WebElement tableAddOpenReceivables;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ckap1:ckcb11')]")
    private WebElement btnSave;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ckap1:m1')]/div/table/tbody/tr/td[3]")
    private WebElement menuActions;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ckap1:onLineAccounting')]/td[2]")
    private WebElement lstPostToledger;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ckap1:ckcb12')]")
    private WebElement btnSaveAndClose;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ckap1:cb110')]")
	   private WebElement btnConfOk;
	
	public WebDriverWait wdwait; 
	
	 public ApplyCreditMemoPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(btnAddOpenReceivables));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Apply Credit Memo Page *****************************");
	       this.getScreenDetails();
	    }
	 
	// Add Open Receivables button  
	   public void clickAddOpenReceivablesButton(){	
		   btnAddOpenReceivables.click();
		   wdwait.until(ExpectedConditions.visibilityOf(txtTransactionNumber));
		   report.log(LogStatus.PASS, "Clicked on Add Open Receivables button");
		   this.getScreenDetails("Add Open Receivables Pop-up");
	   }
	   
	   public boolean isAddOpenReceivablesBtnDisplayed(){
		   return btnAddOpenReceivables.isDisplayed();
	   	
	   }
	 
	 // Transaction Number  field 
	   
	   public void enterTransactionNumber(String strTransactionNumber) throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtTransactionNumber.clear();
		   txtTransactionNumber.click();
		   txtTransactionNumber.sendKeys(strTransactionNumber);
		   txtAmount.click();
		   report.log(LogStatus.PASS, "Transactio nNumber is entered successfully: "+strTransactionNumber);
	   }
	   
	   public boolean isTransactionNumberDisplayed(){
		   return txtTransactionNumber.isDisplayed();
		   } 
	   
	// Search Button  for Add Open Receivables
	   public void clickTransactionSearchButton(){	
		   btnTransactionSearch.click();
		   wdwait.until(ExpectedConditions.visibilityOf(tableAddOpenReceivables));
		   report.log(LogStatus.PASS, "Clicked on Search button");
		   this.getScreenDetails("Add Open Receivables Pop-up");
	   }
	   
	   public boolean isTransactionSearchBtnDisplayed(){
		   return btnTransactionSearch.isDisplayed();
	   	
	   }
	   
	   //Select Event (select given text from dropdown)
	   public void selectEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATp:t2::db')]//span[contains(text(), '"+eventName+"')]")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	// Add Button  for Add Open Receivables
	   public void clickTransactionAddButton(){	
		   btnTransactionAdd.click();
		   wdwait.until(ExpectedConditions.visibilityOf(tableAddOpenReceivables));
		   report.log(LogStatus.PASS, "Clicked on Add button");
	   }
	   
	   public boolean isTransactionAddBtnDisplayed(){
		   return btnTransactionAdd.isDisplayed();
	   	
	   }  
	   
	// done Button  for Add Open Receivables
	   public void clickTransactionDoneButton(){	
		   btnTransactionDone.click();
		  // wdwait.until(ExpectedConditions.visibilityOf(tableAddOpenReceivables));
		   report.log(LogStatus.PASS, "Clicked on Done button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isTransactiondoneBtnDisplayed(){
		   return btnTransactionDone.isDisplayed();
	   	
	   }  
	
	// Save Button  
	   public void clickSaveButton(){
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].click();", btnSave);
		  // btnSave.click();
		   SeleniumUtils.delay(5000);
		  // wdwait.until(ExpectedConditions.visibilityOf(tableAddOpenReceivables));
		   report.log(LogStatus.PASS, "Clicked on Save button");
	   }
	   
	   public boolean isSaveBtnDisplayed(){
		   return btnSave.isDisplayed();
	   	
	   }  
	   
	// Actions Menu  
	   public void clickActionsMenu(){	
		   menuActions.click();
		  wdwait.until(ExpectedConditions.visibilityOf(lstPostToledger));
		   report.log(LogStatus.PASS, "Clicked on Actions Menu");
	   }
	   
	   public boolean isActionsMenuDisplayed(){
		   return menuActions.isDisplayed();
	   	
	   } 
	   
	// lst PostToledger 
	   public void clickPostToledgerList(){	
		   lstPostToledger.click();
		  wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Post To ledger List");
		   this.getScreenDetails("Confirmation Pop-up");
	   }
	   
	   public boolean isPostToledgerListDisplayed(){
		   return lstPostToledger.isDisplayed();
	   	
	   } 
	   
// Confirmation Ok button
	   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
	   
	   public void clickConfOkButton(){	
		   
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   }
	   
	// Save And Close Button  
	   public void clickSaveAndCloseButton(){	
		   btnSaveAndClose.click();
		  // wdwait.until(ExpectedConditions.visibilityOf(tableAddOpenReceivables));
		   report.log(LogStatus.PASS, "Clicked on Save And Close button");
	   }
	   
	   public boolean isSaveAndCloseBtnDisplayed(){
		   return btnSaveAndClose.isDisplayed();
	   	
	   }  
	   
	 @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Apply Credit Memo Page is Loaded Successfully");
	    	 if(btnAddOpenReceivables.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Apply Credit Memo Page</span></a>");
		   	return new Item(xyz);
	   }


}
