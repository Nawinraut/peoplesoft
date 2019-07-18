package com.cloud.pageobjects.Finance;

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

public class AccountsReceivablePage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//img[contains(@id,'_FndTasksList::icon')]")
    private WebElement btnTasks;
	 
	 //@FindBy(how=How.XPATH, using = "//a[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:_FOTRaT:0:RAtl1']")
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Create Receipt')]")
	    private WebElement lnkCreateReceipt;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Create Automatic Receipts')]")
	    private WebElement lnkCreateAutomaticReceipts;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Manage Credit Memo Applications')]")
	    private WebElement lnkManageCreditMemoApplications;
	  
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Review Customer Account Details')]")
	    private WebElement lnkReviewCustomerAccountDetails;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Manage Receipts')]")
	    private WebElement lnkManageReceipts;
	 
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public AccountsReceivablePage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Accounts Receivable Page *****************************");
		       this.getScreenDetails();
		    }

	 
	    public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    	
	    }
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkCreateReceipt));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	    
	    // Create Receipt
	    
	    public CreateReceiptPage clickCreateReceiptLink()throws TestException{
	    	lnkCreateReceipt.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Receipt Link");
	    	return new CreateReceiptPage(driver,report);
	    }
	    
	   
	    public boolean isCreateReceiptLinkDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, lnkCreateReceipt, context.getReactTimeout());
	    	
	    }
	    
	    //lnkCreateAutomaticReceipts
	    public CreateAutomaticReceiptBatchPage clickCreateAutomaticReceiptsLink()throws TestException{
	    	lnkCreateAutomaticReceipts.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Receipt Link");
	    	return new CreateAutomaticReceiptBatchPage(driver,report);
	    }
	    
	   
	    public boolean isCreateAutomaticReceiptsLinkDisplayed(){
	    	return lnkCreateAutomaticReceipts.isDisplayed();
	    	
	    }
	    
	  //Manage Credit Memo Applications link
	    public ManageCreditMemoApplicationsPage clickManageCreditMemoApplicationsLink()throws TestException{
	    	lnkManageCreditMemoApplications.click();
	    	report.log(LogStatus.PASS, "Clicked on Manage Credit Memo Applications Link");
	    	return new ManageCreditMemoApplicationsPage(driver,report);
	    }
	    
	   
	    public boolean isManageCreditMemoApplicationsLinkDisplayed(){
	    	return lnkManageCreditMemoApplications.isDisplayed();
	    	
	    } 
	    
	  //Review Customer Account Details link
	    public ReviewCustomerAccountDetailsPage clickReviewCustomerAccountDetailsLink()throws TestException{
	    	lnkReviewCustomerAccountDetails.click();
	    	report.log(LogStatus.PASS, "Clicked on Review Customer Account Details Link");
	    	return new ReviewCustomerAccountDetailsPage(driver,report);
	    }
	    
	   
	    public boolean isReviewCustomerAccountDetailsLinkDisplayed(){
	    	return lnkReviewCustomerAccountDetails.isDisplayed();
	    	
	    } 
	    
	  //Review Manage Receipts link
	    public ManageReceiptsPage clickManageReceiptsLink()throws TestException{
	    	lnkManageReceipts.click();
	    	report.log(LogStatus.PASS, "Clicked on Manage Receipts Link");
	    	return new ManageReceiptsPage(driver,report);
	    }
	    
	   
	    public boolean isManageReceiptsLinkDisplayed(){
	    	return lnkManageReceipts.isDisplayed();
	    	
	    } 
	    
	    
	    
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Accounts Receivable page is Loaded Successfully");
	    	 if(btnTasks.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Accounts Receivable Page</span></a>");
		   	return new Item(xyz);
	   }

}
