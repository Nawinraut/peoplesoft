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

public  class CashBalancesPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//img[contains(@id,'_TasksList::icon')]")
    private WebElement btnTasks;
	
	@FindBy(how=How.XPATH, using = "//a[contains(.,'Create Bank Account Transfer')]")
    private WebElement lnkCreateBankAccountTransfer;
	
	@FindBy(how=How.XPATH, using = "//a[contains(.,'Create Payee')]")
    private WebElement lnkCreatePayee;
	
	@FindBy(how=How.XPATH, using = "//a[contains(.,'Create Ad Hoc Payment')]")
    private WebElement lnkCreateAdHocPayment;
	
	 
public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/

	    
	 public CashBalancesPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Cash Balances Page *****************************");
	       this.getScreenDetails();
	    }
	 
	 public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    	
	    }
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkCreateBankAccountTransfer));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	       
	    
// Create Bank Account Transfer link
	    
	    public boolean isCreateBankAccountTransferLinkDisplayed(){ 
	    	return lnkCreateBankAccountTransfer.isDisplayed();
	    }
	    
	    public CreateBankAccountTransferPage clickCreateBankAccountTransferLink()throws TestException{
	    	lnkCreateBankAccountTransfer.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Bank Account Transfer Link");
	    	return new CreateBankAccountTransferPage(driver,report);
	    }
	 
	//lnkCreatePayee
	    public boolean isCreatePayeeLinkDisplayed(){ 
	    	return lnkCreatePayee.isDisplayed();
	    }
	    
	    public CreatePayeePage clickCreatePayeeLink()throws TestException{
	    	lnkCreatePayee.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Payee Link");
	    	return new CreatePayeePage(driver,report);
	    } 
	    
	  //Create Ad Hoc Payment
	    public boolean isCreateAdHocPaymentLinkDisplayed(){ 
	    	return lnkCreateAdHocPayment.isDisplayed();
	    }
	    
	    public CreateAdHocPaymentPage clickCreateAdHocPaymentLink()throws TestException{
	    	lnkCreateAdHocPayment.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Ad Hoc Payment Link");
	    	return new CreateAdHocPaymentPage(driver,report);
	    }   
	    
	    
	    
	 @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Cash Balances Page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Cash Balances Page</span></a>");
		   	return new Item(xyz);
	   
		}


}
