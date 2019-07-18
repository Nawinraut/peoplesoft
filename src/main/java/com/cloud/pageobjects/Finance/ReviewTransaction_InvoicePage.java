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

public class ReviewTransaction_InvoicePage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:mb1::oc')]")
	    private WebElement menuAction;
	 
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:onLineAccounting')]")
	 @FindBy(how=How.XPATH, using = "//td[contains(text(),'Post to Ledger')]")
	    private WebElement menuPostToLadger;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:cb110')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:saveMenu::popEl')]")
	    private WebElement menuSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap110:cmi10')]")
	    private WebElement lstSaveAndClose;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='_FOd1::msgDlg::cancel']")
	    private WebElement btnInfOk;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ReviewTransaction_InvoicePage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(menuAction));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Review Transaction Invoice Page *****************************");
		       this.getScreenDetails();
		    }
	 // Invoice Actions menu
		   public void clickActionsMenu(){	
			   SeleniumUtils.delay(5000);
			   menuAction.click();
			   wdwait.until(ExpectedConditions.visibilityOf(menuPostToLadger));
			   report.log(LogStatus.PASS, "Clicked on  Actions Menu");
		   }
		  
		   public boolean isActionsMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuAction, context.getReactTimeout());
		   	
		   }
	    // Post to Ledger list item from  Actions menu 
		   
		   public void selectPostLedgerMenu(){	
			   menuPostToLadger.click();
			   //SeleniumUtils.delay(8000);
			   wdwait.until(ExpectedConditions.visibilityOf(menuAction));
			   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
		   }
		   
		   public boolean isPostLedgerMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuPostToLadger, context.getReactTimeout());
		   	
		   }
// Confirmation Ok button
		   
		   public boolean isConfOkButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
		   }  
		   
		   public void clickConfOkButton(){	
			   this.getScreenDetails("Confirmation Pop-up");
			   btnConfOk.click();
			   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
			   SeleniumUtils.delay(1000);
			 
		   }
		   
		   // Save Menu
		   public void clickSaveMenu(){	
			   SeleniumUtils.delay(2000);
			   menuSave.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lstSaveAndClose));
			   report.log(LogStatus.PASS, "Clicked on Save Menu");
		   }
		  
		   public boolean isSaveMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuSave, context.getReactTimeout());
		   	
		   }
		   
		   // Save and Close Button
		   
		   public void clickSaveAndCloseList(){	
			   lstSaveAndClose.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
			   report.log(LogStatus.PASS, "Clicked on Save and Close list");
		   }
		  
		   public boolean isSaveAndCloseDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, lstSaveAndClose, context.getReactTimeout());
		   	
		   }
// Confirmation Ok button
		   
		   public boolean isInfoOkButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnInfOk, context.getReactTimeout());  	
		   }  
		   
		   public void clickInfoOkButton(){	
			   this.getScreenDetails("Information Pop-up");
			   btnInfOk.click();
			   SeleniumUtils.delay(1000);
			   report.log(LogStatus.PASS, "Clicked on Information Ok Button");
			  
		   }
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Edit Transaction Page is Loaded Successfully");
	    	 if(menuAction.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Review Transaction Invoice Page</span></a>");
		   	return new Item(xyz);
	   }


}
