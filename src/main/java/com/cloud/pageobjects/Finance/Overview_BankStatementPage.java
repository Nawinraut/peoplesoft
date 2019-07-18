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

public class Overview_BankStatementPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'_TasksList::icon')]")
	    private WebElement btnTasks;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_cash_management_bank_statements_and_reconciliation:0:_FOTRaT:0:RAtl1']")
	    private WebElement lnkCreateBankStatement;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_cash_management_bank_statements_and_reconciliation:0:_FOTRaT:0:RAtl6']")
	    private WebElement lnkSubmitAutoreconciliation;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_cash_management_bank_statements_and_reconciliation:0:_FOTRaT:0:RAtl7']")
	    private WebElement lnkManualReconciliation;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Generate Cash Transactions')]")
	    private WebElement lnkGenerateCashTransactions;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Create Accounting')]")
	    private WebElement lnkCreateAccounting;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Create Transaction')]")
	    private WebElement lnkCreateTransaction;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Cash to General Ledger Reconciliation Report')]")
	    private WebElement lnkCashtoGeneralLedgerReconciliationReport;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(.,'Bank Statement Report')]")
	    private WebElement lnkBankStatementReport;
	 
	 
	 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public Overview_BankStatementPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(btnTasks));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Overview Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    public boolean isTasksBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnTasks, context.getReactTimeout());
	    	
	    }
	    public void clickTasksButton(){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnTasks);
	    	//btnTasks.click();
	    	wdwait.until(ExpectedConditions.visibilityOf(lnkCreateBankStatement));
	    	report.log(LogStatus.PASS, "Clicked on Tasks Button");
	    }
	       
	    
 // Create Bank Statement link
	    
	    public boolean isCreateBankStatementLinkDisplayed(){ 
	    	return SeleniumUtils.isDisplayed(driver, lnkCreateBankStatement, context.getReactTimeout());
	    }
	    
	    public CreateBankStatementPage clickCreateBankStatementLink()throws TestException{
	    	lnkCreateBankStatement.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Bank Statement Link");
	    	return new CreateBankStatementPage(driver,report);
	    }
	    
// lnkSubmitAutoreconciliation
	    public boolean isSubmitAutoreconciliationLinkDisplayed(){ 
	    	return lnkSubmitAutoreconciliation.isDisplayed();
	    }
	    
	    public BasicOptionsPage clickSubmitAutoreconciliationLink()throws TestException{
	    	lnkSubmitAutoreconciliation.click();
	    	report.log(LogStatus.PASS, "Clicked on Submit Autoreconciliation Link");
	    	return new BasicOptionsPage(driver,report);
	    }
	    
	//lnkManualReconciliation    
	    public boolean isManualReconciliationLinkDisplayed(){ 
	    	return lnkManualReconciliation.isDisplayed();
	    }
	    
	    public ManualReconciliationPage clickManualReconciliationLink()throws TestException{
	    	lnkManualReconciliation.click();
	    	report.log(LogStatus.PASS, "Clicked on ManualReconciliation Link");
	    	return new ManualReconciliationPage(driver,report);
	    }
	    
	   // Generate Cash Transactions Link
	    
	    public boolean isGenerateCashTransactionsLinkDisplayed(){ 
	    	return lnkGenerateCashTransactions.isDisplayed();
	    }
	    
	    public CreateBankStatementTransactions_BasicOptionsPage clickGenerateCashTransactionsLink()throws TestException{
	    	lnkGenerateCashTransactions.click();
	    	report.log(LogStatus.PASS, "Clicked on Generate Cash Transactions Link");
	    	return new CreateBankStatementTransactions_BasicOptionsPage(driver,report);
	    }
	    
	 //Create Accounting Link
	   
	    public boolean isCreateAccountingLinkDisplayed(){ 
	    	return lnkCreateAccounting.isDisplayed();
	    }
	    
	    public CreateAccounting_BasicOptionsPage clickCreateAccountingLink()throws TestException{
	    	lnkCreateAccounting.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Accounting Link");
	    	return new CreateAccounting_BasicOptionsPage(driver,report);
	    }
	    
	  //Create Transaction Link  
	    public boolean isCreateTransactionLinkDisplayed(){ 
	    	return lnkCreateTransaction.isDisplayed();
	    }
	    
	    public CreateExternalTransactionPage clickCreateTransactionLink()throws TestException{
	    	lnkCreateTransaction.click();
	    	report.log(LogStatus.PASS, "Clicked on Create Transaction Link");
	    	return new CreateExternalTransactionPage(driver,report);
	    }
	   
	  //Cash to General Ledger Reconciliation Report Link  
	    public boolean isCashtoGeneralLedgerReconciliationReportLinkDisplayed(){ 
	    	return lnkCreateTransaction.isDisplayed();
	    }
	    
	    public CashtoGeneralLedgerReconciliationReport_BasicOptionsPage clickCashtoGeneralLedgerReconciliationReportLink()throws TestException{
	    	lnkCashtoGeneralLedgerReconciliationReport.click();
	    	report.log(LogStatus.PASS, "Clicked on Cash to General Ledger Reconciliation Report Link");
	    	return new CashtoGeneralLedgerReconciliationReport_BasicOptionsPage(driver,report);
	    }
	    
	    
	  //Bank Statement Report Link  
	    public boolean isBankStatementReportLinkDisplayed(){ 
	    	return lnkBankStatementReport.isDisplayed();
	    }
	    
	    public BankStatementReport_BasicOptionsPage clickBankStatementReportLink()throws TestException{
	    	lnkBankStatementReport.click();
	    	report.log(LogStatus.PASS, "Clicked on Bank Statement Report Link");
	    	return new BankStatementReport_BasicOptionsPage(driver,report);
	    }
	    
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Overview page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Overview Page</span></a>");
		   	return new Item(xyz);
	   }


}
