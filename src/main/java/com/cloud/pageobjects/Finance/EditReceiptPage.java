package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.steadystate.css.parser.Locatable;

public class EditReceiptPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:ATm')]/div/table/tbody/tr/td[3]/div")
	    private WebElement menuActionRcpDetails;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:cmi7')]")
	    private WebElement lstAddOpenReceivables;
	 
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:m1')]/td[2]")
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:1:pt1:RMF:1:pt1:REF:0:ap1:AT1:_ATp:m1']/td[2]")
	    private WebElement lstMore;
	 
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:cmi1')]/td[2]")
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:1:pt1:RMF:1:pt1:REF:0:ap1:AT1:_ATp:cmi1']/td[2]")
	    private WebElement lstCreateOnAccountApplication_More;
	 
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:1:pt1:RMF:1:pt1:REF:0:ap1:AT1:_ATp:cmi4']/td[2]")
	    private WebElement lstCreateWriteOff_More;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:it12::content')]")
	    private WebElement txtApplicationAmount;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'ap1:id14::glyph')]")
	    private WebElement btnAccountingDate;
		
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'ap1:id14::pop::cd::mSel::content')]")
		private WebElement selectAccountingMonth;
	
	@FindBy(how=How.XPATH, using = "//table[contains(@id,'ap1:id14::pop::cd::cg')]")
		private WebElement tableAccountingDate;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:cb22')]")
	    private WebElement btnOK_ApplicationAmount;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ap1:AT1:soc6::content')]")
	    private WebElement selectReceivablesActivity;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:AT1:cb12')]")
	    private WebElement btnOK_CreateWriteOff;
	  
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:cmi5')]/td[2]")
	    private WebElement lstCreateChargeback;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'soc1::content')]")
	    private WebElement selectType_Chargeback;
	
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'id1::glyph')]")
	    private WebElement btnDueDate_Chargeback;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'id1::pop::cd::mSel::content')]")
	    private WebElement selectDueDateMonth_Chargeback;
	 
	 @FindBy(how=How.XPATH, using = "//table[contains(@id,'id1::pop::cd::cg')]")
	    private WebElement tableDueDate_Chargeback;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:AT1:cb16')]")
	    private WebElement btnSaveAndClose_Chargeback;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'msgDlg::cancel')]")
	    private WebElement btnInfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:q1:value50::lovIconId')]")
	    private WebElement iconSearchTransactionCustomerName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtCustomerName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtAccountNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnTransCustomerNameSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnTransCustomerNameOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:q1:value80::content')]")
	    private WebElement txtAmount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:q1::search')]")
	    private WebElement btnReceivableSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':pt1:REF:0:ap1:AT1:_ATp:AT7:_ATp:t3::db')]")
	    private WebElement tableReceivableTransSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:2:pt1:REF:0:ap1:AT1:_ATp:cb2']")
	    private WebElement btnTransAdd;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:2:pt1:REF:0:ap1:AT1:_ATp:cb3']")
	    private WebElement btnTransDone;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:table3::db')]/table/tbody/tr/td[4]")
	    private WebElement tablRcptDetails;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':menu1')]/div/table/tbody/tr/td[3]")
	    private WebElement menuActions;
	 
	// @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:2:pt1:REF:0:ap1:commandMenuItem2']")
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_receivables_receivables_balances:0:MAnt2:2:pt1:REF:0:ap1:commandMenuItem2']|//*[contains(@id,'AP1:commandMenuItem2')]")
	    private WebElement lstPostLadger;
	 
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb110')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb110')]|//*[contains(@id,'AP1:cb110')]")
	    private WebElement btnConfOk;
	 
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton122')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton122')]|//*[contains(@id,'AP1:cb7')]/table/tbody/tr/td[1]/a")
	    private WebElement btnSaveAndClose;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:commandButton1')]")
	    private WebElement btnSave;
	 
	 
	 
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public EditReceiptPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(menuActions));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }

	        System.out.println("******************************* Edit Receipt Page *****************************");
	       this.getScreenDetails();
	    }
    
    // Invoice Actions menu
	   public void clickReceiptDetailsActionsMenu(){
		   wdwait.until(ExpectedConditions.visibilityOf(menuActionRcpDetails));
		   menuActionRcpDetails.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(lstAddOpenReceivables));
		   report.log(LogStatus.PASS, "Clicked on Receipt Details Actions Menu");
	   }
	  
	   public boolean isReceiptDetailsActionMenuDisplayed(){
		   return menuActionRcpDetails.isDisplayed();
	   	
	   }
// Add Open Receivables list item from Actions menu
	   
	   public void selectAddOpenReceivablesList(){	
		   lstAddOpenReceivables.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(iconSearchTransactionCustomerName));
		   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
		   this.getScreenDetails();
	   }
	   
	   public boolean isAddOpenReceivablesListDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstAddOpenReceivables, context.getReactTimeout());
	   	
	   }
	   
// More list item from Actions menu On Account Application List
	   
	   public void selectMoreList_OnAccountApplicationList(){
		   SeleniumUtils.delay(3000);
		   lstMore.click();
		   report.log(LogStatus.PASS, "Clicked on More Link");
		   //SeleniumUtils.delay(3000);
		   wdwait.until(ExpectedConditions.visibilityOf(lstCreateOnAccountApplication_More));
		   if(lstCreateOnAccountApplication_More.isDisplayed()) {
			   this.getScreenDetails();
			   JavascriptExecutor js = (JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click()", lstCreateOnAccountApplication_More);
			   System.out.println("clicked on On Account Application List");
			   wdwait.until(ExpectedConditions.visibilityOf(txtApplicationAmount));
		   }
		   
	   }
	   
	   public boolean isMoreListDisplayed(){
		   return lstMore.isDisplayed();
	   	
	   }
	   
	   public boolean isCreateOnAccountApplicationListDisplayed(){
		   return lstCreateOnAccountApplication_More.isDisplayed();
	   	
	   }
	   
// More list item from Actions menu CreateWriteOff List
	   
	   public void selectMoreList_CreateWriteOffList(){
		   SeleniumUtils.delay(3000);
		   lstMore.click();
		   report.log(LogStatus.PASS, "Clicked on More Link");
		   //SeleniumUtils.delay(3000);
		   wdwait.until(ExpectedConditions.visibilityOf(lstCreateWriteOff_More));
		   if(lstCreateWriteOff_More.isDisplayed()) {
			   this.getScreenDetails();
			   JavascriptExecutor js = (JavascriptExecutor)driver;
			   js.executeScript("arguments[0].click()", lstCreateWriteOff_More);
			   System.out.println("clicked on Create  Write Off List");
			   wdwait.until(ExpectedConditions.visibilityOf(selectReceivablesActivity));
		   }
		   
	   }
	   
	   public boolean isCreateWriteOffListDisplayed(){
		   return lstCreateWriteOff_More.isDisplayed();
	   	
	   }
	   
	 //Enter Application Amount field
	   public void enterApplicationAmount(String strAmount){
		   txtApplicationAmount.clear();
		   txtApplicationAmount.click();
		   txtApplicationAmount.sendKeys(strAmount);
		   txtApplicationAmount.click();
		   report.log(LogStatus.PASS, "Entered Application Amount is: "+strAmount);
	   }
	   
	   public boolean isApplicationAmountDisplayed(){
		   return txtApplicationAmount.isDisplayed();
		   }
	   
// Click Ok button for Application amount
	   
	   public void clickOkApplicationAmountButton(){	
		   btnOK_ApplicationAmount.click();
		   wdwait.until(ExpectedConditions.visibilityOf(txtApplicationAmount));
		   report.log(LogStatus.PASS, "Clicked Ok button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isOkApplicationAmountBtnDisplayed(){
		   return btnOK_ApplicationAmount.isDisplayed();
	   	
	   }
	   
	   
// Create Chargeback  list item from Actions menu
	   
	   public void selectReceivablesActivityList(String strReceivablesActivity){	
		   Select objSelect=new Select(selectReceivablesActivity);
		   objSelect.selectByVisibleText(strReceivablesActivity);
		   
	   }
	   
	   public boolean isReceivablesActivityListDisplayed(){
		   return selectReceivablesActivity.isDisplayed();
	   	
	   }
	   
// Click Ok button for Create Write Off
	   
	   public void clickOkCreateWriteOffButton(){
		   this.getScreenDetails();
		   btnOK_CreateWriteOff.click();
		   report.log(LogStatus.PASS, "Clicked Ok button");
		   
	   }
	   
	   public boolean isOkCreateWriteOffBtnDisplayed(){
		   return btnOK_CreateWriteOff.isDisplayed();
	   	
	   }
	   
// Create Chargeback  list item from Actions menu
	   
	   public void selectCreateChargebackList(){	
		   lstCreateChargeback.click();
		   wdwait.until(ExpectedConditions.visibilityOf(selectType_Chargeback));
		   report.log(LogStatus.PASS, "Selected Create Chargeback list");
		   this.getScreenDetails("Create Chargeback Pup-up");
	   }
	   
	   public boolean isCreateChargebackListDisplayed(){
		   return lstCreateChargeback.isDisplayed();
	   	
	   }
	   
   // Select Type Chargeback
	   public void selectTypeChargebackList(String strType){
		   Select objSelect=new Select(selectType_Chargeback);
		   objSelect.selectByVisibleText(strType);
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected given Chargeback  Type list is "+strType);
		   this.getScreenDetails();
	   }
	   
	   public boolean isTypeChargebackListDisplayed(){
		   return selectType_Chargeback.isDisplayed();
	   	
	   }
	   
	// click on Due Date  Chargeback
	      
	   public boolean isChargebackDueDateBtnDisplayed(){
	    	return btnDueDate_Chargeback.isEnabled();
	    	
	    }
	    public void clickChargebackDueDateButton(){	    	
	    	btnDueDate_Chargeback.click();
	    	 wdwait.until(ExpectedConditions.visibilityOf(selectDueDateMonth_Chargeback));
	    	//SeleniumUtils.delay(3000);
	    	report.log(LogStatus.PASS, "Clicked on Due Date Button");
	    }
	   
	   // Select From Date Month from Calander
	    public void selectChargebackDueDateMonth(String fromMonth){
	    	Select objSelect = new Select(selectDueDateMonth_Chargeback);
	    	objSelect.selectByVisibleText(fromMonth);
	    	 wdwait.until(ExpectedConditions.visibilityOf(tableDueDate_Chargeback));
	    	report.log(LogStatus.PASS, "Selected Due Date Month is: "+fromMonth);
	    } 
	   
	   public boolean isChargebackDueDateMonthDisplayed(){
		   return selectDueDateMonth_Chargeback.isEnabled();
	   }
	   
	   // Select From Invoice Date
	   public void selectChargebackDueDate(String fromDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'id1::pop::cd::cg')]//td"));  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(fromDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected Due Date is "+fromDate);
				   break;
				   
			   }
			  } 
			  
		  }
	   
	// btnSaveAndClose_Chargeback Button  
	   public void clickChargeback_SaveAndCloseButton(){	
		   btnSaveAndClose_Chargeback.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
		   report.log(LogStatus.PASS, "Clicked on Save And Close button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isChargeback_SaveAndCloseBtnDisplayed(){
		   return btnSaveAndClose_Chargeback.isDisplayed();
	   	
	   }
// Info Ok button
	   
	   public boolean isInfOkButtonDisplayed(){
		   return btnInfOk.isDisplayed();  	
	   }  
	   
	   public void clickInfOkButton(){	
		   btnInfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Information Ok Button");
		   
	   }
	   
	// Search: Supplier Icon
	   
	   public void clickSrchTransactionCustomerNameIcon(){	
		   iconSearchTransactionCustomerName.click();
		   wdwait.until(ExpectedConditions.visibilityOf(txtCustomerName));
		   report.log(LogStatus.PASS, "Clicked on Account Number Search icon");  
		   
	   }
	   
	   public boolean isSearchTransactionCustomerNameIconDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, iconSearchTransactionCustomerName, context.getReactTimeout());
	   }
	   
	   // Search :
	   
	 //Enter text into Customer Name field
	   public void enterTransactionCustomerName(String strCustomerName){
		   txtCustomerName.clear();
		   txtCustomerName.click();
		   txtCustomerName.sendKeys(strCustomerName);
		   report.log(LogStatus.PASS, "Entered Customer Name is: "+strCustomerName);
	   }
	   
	   public boolean isCustomerNameDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtCustomerName, context.getReactTimeout());
		   }
	  // Account Number Field
	   
	   public void clickAccountNumber(){
		   txtAccountNumber.click();
		   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
	   }
	   
	   
	// Supplier Search Button 
	   public void clickCustomerNameSearchButton(String eventName){
		   btnTransCustomerNameSearch.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   report.log(LogStatus.PASS, "Clicked on Customer NameSearch Button");
	   }
	   
	   public boolean isCustomerNameSearchBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnTransCustomerNameSearch, context.getReactTimeout());		 
	   }
	   
	 //Select Event (select given text from dropdown)
	   public void selectEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	// Supplier Search Ok Button 
	   public void clickCustomerNameOkButton(){	
		   this.getScreenDetails();
		   btnTransCustomerNameOk.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Customer Name Ok Button");
	   }
	   
	   public boolean isCustomerNameOkBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver,  btnTransCustomerNameOk, context.getReactTimeout());		 
	   } 
	   
	  //
	   
	   public void clickAmountField(){	
		   txtAmount.click();
	   }
	   
	// Add Open Receivable Search Button 
	   public void clickReceivableSearchButton(){
		   btnReceivableSearch.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.visibilityOf(btnTransAdd));
		   report.log(LogStatus.PASS, "Clicked on Receivable Search Button");
		  
	   }
	   
	   public boolean isReceivableSearchBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnReceivableSearch, context.getReactTimeout());		 
	   }
	   
   // Select Receivables Cell
	   
	   public void selectReceivablesCell(String ReceivablesCell)
		{
		   WebDriverWait wait = new WebDriverWait(driver, 50);
			  
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,':pt1:REF:0:ap1:AT1:_ATp:AT7:_ATp:t3::db')]//td[2]/div//td[1]//span[contains(text(), '"+ReceivablesCell+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected Receivables Cell is: "+ReceivablesCell);
		   
			
		  }  
	   
	//     Add Open Receivable Add Button
	   
	   public void clickReceivableAddButton(){
		   btnTransAdd.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		  // wdwait.until(ExpectedConditions.visibilityOf(btnTransAdd));
		   report.log(LogStatus.PASS, "Clicked on Add Button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isReceivableAddBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnTransAdd, context.getReactTimeout());		 
	   }
	   
	   // Done button
	   
	   public void clickReceivableDoneButton(){
		   btnTransDone.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.visibilityOf(tablRcptDetails));
		   report.log(LogStatus.PASS, "Clicked on Done Button");
	   }
	   
	   public boolean isReceivableDoneBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnTransDone, context.getReactTimeout());		 
	   }
	   
	   // Actions menu
	   public void clickActionsMenu(){
		   SeleniumUtils.delay(3000);
		   menuActions.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(lstPostLadger));
		   report.log(LogStatus.PASS, "Clicked on Actions Menu");
		   
	   }
	  
	   public boolean isActionsMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuActions, context.getReactTimeout());
	   }
// Post  Ledger list item from  Actions menu 
	   
	   public void selectPostLedgerMenu(){	
		   lstPostLadger.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Selected Post Ledger List");
		   this.getScreenDetails("Confirmation Pop-up");
	   }
	   
	   public boolean isPostLedgerMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lstPostLadger, context.getReactTimeout());
	   	
	   }
	   
	   // Conf Ok button
	   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
	   
	   public void clickConfOkButton(){	
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
		   
	   }
	   
	   //Save and Close button
	   
	   public boolean isSaveAndCloseButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSaveAndClose, context.getReactTimeout());  	
	   }  
	   
	   public void clickSaveAndCloseButton(){	
		   //this.getScreenDetails("Confirmation Pop-up");
		   btnSaveAndClose.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Save and Close Button");
		   
	   }
	   
	   // Save button
	   public boolean isSaveButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSave, context.getReactTimeout());  	
	   }  
	   
	   public void clickSaveButton(){	
		   //this.getScreenDetails("Confirmation Pop-up");
		   btnSave.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Save Button");
		   
	   }
	   
	   
	   //Select Event (select given text from dropdown)
	   public void selectReceiptDetailsTransections(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATp:table3::db')]//tr[.//text()= '"+eventName+"']")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   
		   }
	   
	   
	// click on From Invoice Date Calendar button
	      
	   public boolean isAccountingDateBtnDisplayed(){
	    	return btnAccountingDate.isDisplayed();
	    	
	    }
	    public void clickAccountingDateButton(){	    	
	    	btnAccountingDate.click();
	    	 wdwait.until(ExpectedConditions.visibilityOf(selectAccountingMonth));
	    	//SeleniumUtils.delay(3000);
	    	report.log(LogStatus.PASS, "Clicked on Accounting Date Button");
	    }
	   
	   // Select From Date Month from Calander
	    public void selectAccountingDateMonth(String fromMonth){
	    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
	    	Select objSelect = new Select(selectAccountingMonth);
	    	objSelect.selectByVisibleText(fromMonth);
	    	 //wdwait.until(ExpectedConditions.visibilityOf(calendarFromInvoiceDt));
	    	SeleniumUtils.delay(2000);
	    	report.log(LogStatus.PASS, "Selected Accounting Date Month is: "+fromMonth);
	    } 
	   
	   public boolean isAccountingDateDisplayed(){
		   return selectAccountingMonth.isDisplayed();
	   }
	   
	   // Select From Invoice Date
	   public void selectAccountingDate(String fromDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'ap1:id14::pop::cd::cg')]//td"));  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(fromDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected Accounting Date is "+fromDate);
				   break;
				   
			   }
			  } 
			  
		  }
	   
	   
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Edit Receipt page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Receipt Page</span></a>");
	   	return new Item(xyz);
   } 


}
