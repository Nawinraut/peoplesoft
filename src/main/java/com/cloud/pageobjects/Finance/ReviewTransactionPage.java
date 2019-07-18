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

public class ReviewTransactionPage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:m1')]/div/table/tbody/tr/td[3]")
    private WebElement menuActions;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:cmi2')]/td[2]")
    private WebElement lstManageAdjustments;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:onLineAccounting')]")
    private WebElement lstPostToLedger;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ap110:cb110')]")
    private WebElement btnConfOk;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'msgDlg::cancel')]")
    private WebElement btnInfOk;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:saveMenu::popEl')]")
    private WebElement menuSave;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:cmi10')]")
    private WebElement lstSaveAndClose;
	
	
	public WebDriverWait wdwait;
	
	public ReviewTransactionPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(menuActions));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Review Transaction Page *****************************");
	       this.getScreenDetails();
	    }
	
	
	// Actions Menu  
	   public void clickActionsMenu(){	
		   menuActions.click();
		  wdwait.until(ExpectedConditions.visibilityOf(lstManageAdjustments));
		   report.log(LogStatus.PASS, "Clicked on Actions Menu");
	   }
	   
	   public boolean isActionsMenuDisplayed(){
		   return menuActions.isDisplayed();
	   	
	   } 
	   
	   //lstPostToLedger
	   
	   public void clickPostToLedgerList(){	
		   lstPostToLedger.click();
		  wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Post To Ledger List");
	   }
	   
	   public boolean isPostToLedgerListDisplayed(){
		   return menuActions.isDisplayed();
	   	
	   } 
	
	// lst Manage Adjustments 
	   public ManageAdjustmentsPage clickManageAdjustmentsList() throws TestException{	
		   lstManageAdjustments.click();
		   report.log(LogStatus.PASS, "Clicked on Manage Adjustments List");
		   return new ManageAdjustmentsPage(driver,report);
	   }
	   
	   public boolean isManageAdjustmentsListDisplayed(){
		   return lstManageAdjustments.isDisplayed();
	   	
	   } 
	   
	// Conf Ok Button
	   public boolean isConfOkButtonDisplayed(){
		   return btnInfOk.isDisplayed();  	
	   }  
	   
	   public void clickConfOkButton(){	
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   }
	   
	// Save Menu  
	   public void clickSaveMenu(){	
		   SeleniumUtils.delay(2000);
		   menuSave.click();
		  wdwait.until(ExpectedConditions.visibilityOf(lstSaveAndClose));
		   report.log(LogStatus.PASS, "Clicked on Save Menu");
	   }
	   
	   public boolean isSaveMenuDisplayed(){
		   return menuActions.isDisplayed();
	   	
	   } 
	   
	// lst Save and Close
	   public void clickSaveAndCloseList(){	
		   SeleniumUtils.delay(2000);
		   lstSaveAndClose.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
		   report.log(LogStatus.PASS, "Clicked on Save And Close List");  
	   }
	   
	   public boolean isSaveAndCloseListDisplayed(){
		   return lstSaveAndClose.isDisplayed();
	   	
	   } 
	   
	// Info Ok Button
	   public boolean isInfOkButtonDisplayed(){
		   return btnInfOk.isDisplayed();  	
	   }  
	   
	   public void clickInfOkButton(){	
		   btnInfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Information Ok Button");
	   }
	   
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Review TransactionPage is Loaded Successfully");
    	 if(menuActions.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Review Transaction Page</span></a>");
	   	return new Item(xyz);
   }

}
