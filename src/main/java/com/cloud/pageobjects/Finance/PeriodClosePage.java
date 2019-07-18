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

public class PeriodClosePage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'FOTsdiPeriodCloseRegionalArea::icon')]")
	    private WebElement btnTasks;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Revalue Balances')]")
	    private WebElement lnkRevalueBalances;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Translate Balances')]")
	    private WebElement lnkTranslateBalances;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Transfer Balances to Secondary Ledgers')]")
	    private WebElement lnkTransferBalancestoSecondaryLedgers;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Create Balance Sheet Closing Journals')]")
	    private WebElement lnkCreateBalanceSheetClosingJournals;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Create Income Statement Closing Journals')]")
	    private WebElement lnkCreateIncomeStatementClosingJournals;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Manage Accounting Periods')]")
	    private WebElement lnkManageAccountingPeriods;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public PeriodClosePage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Period Close Page *****************************");
		       this.getScreenDetails();
		    }

	    public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    	
	    }
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkRevalueBalances));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	    
	    //Revalue Balances Link
	    public ManageRevaluationsPage clickRevalueBalancesLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkRevalueBalances));
			lnkRevalueBalances.click();
			report.log(LogStatus.PASS, "Clicked on Revalue Balances link");
			return new ManageRevaluationsPage(driver,report);
		 }
	    
	    // Translate Balances Link
	    public TranslateGeneralLedgerAccountBalances_BasicOptionsPage clickTranslateBalancesLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkTranslateBalances));
			lnkTranslateBalances.click();
			report.log(LogStatus.PASS, "Clicked on Translate Balances link");
			return new TranslateGeneralLedgerAccountBalances_BasicOptionsPage(driver,report);
		 }
	    
	    //Transfer Balances to Secondary Ledgers Link
	    public TransferBalancestoSecondaryLedger_BasicOptionsPage clickTransferBalancestoSecondaryLedgersLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkTransferBalancestoSecondaryLedgers));
			lnkTransferBalancestoSecondaryLedgers.click();
			report.log(LogStatus.PASS, "Clicked on Transfer Balances to Secondary Ledgers link");
			return new TransferBalancestoSecondaryLedger_BasicOptionsPage(driver,report);
		 }
	    
	    //lnkCreateBalanceSheetClosingJournals
	    public CreateBalanceSheetClosingJournals_BasicOptionsPage clickCreateBalanceSheetClosingJournalsLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkCreateBalanceSheetClosingJournals));
			lnkCreateBalanceSheetClosingJournals.click();
			report.log(LogStatus.PASS, "Clicked on Create Balance Sheet Closing Journals link");
			return new CreateBalanceSheetClosingJournals_BasicOptionsPage(driver,report);
		 }
	    
	    // lnkCreateIncomeStatementClosingJournals
	    public CreateIncomeStatementClosingJournals_BasicOptionsPage clickCreateIncomeStatementClosingJournalsLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkCreateIncomeStatementClosingJournals));
			lnkCreateIncomeStatementClosingJournals.click();
			report.log(LogStatus.PASS, "Clicked on Create  Income Statement Closing Journals link");
			return new CreateIncomeStatementClosingJournals_BasicOptionsPage(driver,report);
		 }
	   // lnkManageAccountingPeriods
	    public ManageAccountingPeriodsPage clickManageAccountingPeriodsLink() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(lnkManageAccountingPeriods));
			lnkManageAccountingPeriods.click();
			report.log(LogStatus.PASS, "Clicked on Manage Accounting Periods link");
			return new ManageAccountingPeriodsPage(driver,report);
		 }
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Period Close page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Period Close Page</span></a>");
		   	return new Item(xyz);
	   }

}
