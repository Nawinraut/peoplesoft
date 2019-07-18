package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateSubledgerJournalEntryPage extends BasePageObject{
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ledgerNameId::content')]")
	    private WebElement selectLedger;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'mjept1:AP1:id2::glyph')]")
	    private WebElement btnAccountingDate;
		
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'mjept1:AP1:id2::pop::cd::mSel::content')]")
    private WebElement selectAccountingMonth;
	
	@FindBy(how=How.XPATH, using = "//table[contains(@id,'mjept1:AP1:id2::pop::cd::cg')]")
    private WebElement tableAccountingDate;
 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'userCategoryNameId::lovIconId')]")
	    private WebElement iconCategoryList;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'userCategoryNameId::dropdownPopup::popupsearch')]")
	    private WebElement lnkCategoryListSearch;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtJournalCategory;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtJournalCategoryDescription;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnJournalCategorySearch;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnJournalCategoryOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:it1::content')]")
	    private WebElement txtDescription;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'mjept1:AP1:soc1::content')]")
	    private WebElement selectCompletionStatus;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'mjept1:AP1:legalEntityNameId::content')]")
	    private WebElement selectLegalEntity;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'mjept1:AP1:AT2:_ATp:create::icon')]")
	    private WebElement btnAddRow;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'mjept1:AP1:AT2:_ATp:table2:0:kf1KBIMG::icon')]")
	    private WebElement btnAccount1;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'mjept1:AP1:AT2:_ATp:table2:0:kf1SEl')]")
	    private WebElement btnAccount1_Ok;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'table2:0:acctgClassMeaningId::content')]")
	    private WebElement selectAccountingClass1;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'table2:0:it6::content')]")
	    private WebElement txtDebit1;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'table2:0:it4::content')]")
	    private WebElement txtCredit1;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'mjept1:AP1:AT2:_ATp:table2:1:kf1KBIMG::icon')]")
	    private WebElement btnAccount2;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'mjept1:AP1:AT2:_ATp:table2:1:kf1SEl')]")
	    private WebElement btnAccount2_Ok;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'ATp:table2:1:acctgClassMeaningId::lovIconId')]")
	    private WebElement iconAccountingClassList2;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'ATp:table2:1:acctgClassMeaningId::dropdownPopup::popupsearch')]")
	    private WebElement lnkAccountingClassList2Search;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtAccountingClass;
	
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnAccountingClassSearch;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnAccountingClassOk;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'table2:1:it6::content')]")
	    private WebElement txtDebit2;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'table2:1:it4::content')]")
	    private WebElement txtCredit2;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:ctb2')]/table")
	    private WebElement btnSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:plam7')]")
	    private WebElement lblSave;
	 
	 // Account Pop-up
	 
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value00::lovIconId')]")
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value00::lovIconId')]")
	  private WebElement srchCompany;
	   
	   // Search text(Dynamic) for Accounting   
	  // @FindBy(how=How.XPATH, using = "//td/span[text()=\"+categoryName+\"]")
	  // private WebElement srchtext;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value10::lovIconId')]")
	   private WebElement srchRegion;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value20::lovIconId')]")
	   private WebElement srchCountry;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value30::lovIconId')]")
	   private WebElement srchService;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value40::lovIconId')]")
	   private WebElement srchLocation;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value50::lovIconId')]")
	   private WebElement srchDepartment;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value60::lovIconId')]")
	   private WebElement srchNaturalAccount;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'value60::dropdownPopup::popupsearch')]")
	   private WebElement lnkAccountSearch;
	   
	   @FindBy(how=How.XPATH, using = "//input[contains(@id,'QueryId:value00::content')]")
	   private WebElement txtAccValue;
	   
	   @FindBy(how=How.XPATH, using = "//button[contains(@id,'QueryId::search')]")
	   private WebElement btnAccSearch;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[1]|//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[2]")
	   private WebElement tableAccSearch; 
	   
	   @FindBy(how=How.XPATH, using = "//button[contains(@id,'lovDialogId::ok')]")
	   private WebElement btnAccOk;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value70::lovIconId')]")
	   private WebElement srchIntercompany;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value80::lovIconId')]")
	   private WebElement srchFundSource;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value90::lovIconId')]")
	   private WebElement srchFuture1;
	   
	 
	 
	 
	public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
   
	    
	    public CreateSubledgerJournalEntryPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(selectLedger));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Create Subledger Journal Entry Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	  //Ledger list
		   public void SelectLedger(String strLedger) throws InterruptedException{
			   selectLedger.clear();
			   selectLedger.click();
			   selectLedger.sendKeys(strLedger);
			   selectLedger.sendKeys(Keys.ENTER);
			   SeleniumUtils.delay(3000);
			   selectLedger.click();
		   	SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Selected given Ledger from the list is: "+strLedger);
		   }
		   
		   public boolean isSelectLedgerDisplayed(){
			   return selectLedger.isDisplayed();
			   } 
		   
		// Search icon CategoryList
		   
		   public void clickCategorySearchIcon() throws InterruptedException{ 
			   iconCategoryList.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lnkCategoryListSearch));
			   report.log(LogStatus.PASS, "Clicked on Category Search Icon");
		   }
		   
		   public boolean isCategorySearchIconDisplayed(){
			   return iconCategoryList.isDisplayed();
		   }
		   
		// Search Link for Category
		   
		   public void clickCategorySearchLink() throws InterruptedException{
			   wdwait.until(ExpectedConditions.visibilityOf(lnkCategoryListSearch));
			   lnkCategoryListSearch.click();
			    wdwait.until(ExpectedConditions.visibilityOf(txtJournalCategory));
			   report.log(LogStatus.PASS, "Clicked on Category Search link");
		   }
		   
		   public boolean isCategorySearchLinkDisplayed(){
			   return lnkCategoryListSearch.isDisplayed();
		   } 
		   
		   // Enter party value in Party field
		   
		   public void enterJournalCategory(String strJournalCategory) throws InterruptedException{
			   //SeleniumUtils.delay(2000);
			   txtJournalCategory.clear();
			   txtJournalCategory.click();
			   txtJournalCategory.sendKeys(strJournalCategory);
			  // txtJournalCategory.sendKeys(Keys.ENTER);
			   txtJournalCategoryDescription.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Entered value for Journal Category is: "+strJournalCategory);
		   }
		   
		   
		   public boolean isJournalCategoryDisplayed(){
			   return txtJournalCategory.isDisplayed();
			   } 
		   
		   
		// Search button in JournalCategory
		   public void clickJournalCategorySearchButton(){	
			       btnJournalCategorySearch.click();
					SeleniumUtils.delay(3000);
			   //btnAccSearch.click();
			   report.log(LogStatus.PASS, "Clicked on Journal Category Search Button");
		   }
		   
		   public boolean isJournalCategorySearchButtonDisplayed(){
			   return btnJournalCategorySearch.isDisplayed();
		   } 
		   
		 //Select Event (select given text from dropdown)
		   public void selectJournalCategory(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'userCategoryNameId_afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));	   
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		// Journal Category Ok button
		   
		   public boolean isJournalCategoryOkButtonDisplayed(){
			   return btnJournalCategoryOk.isDisplayed();
		   }
		   
		   public void clickJournalCategoryOkButton(){	
			   btnJournalCategoryOk.click();
			   SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on JournalCategory Ok Button");   
		   }
		   
		   // click on From Invoice Date Calendar button
		      
		   public boolean isAccountingDateBtnDisplayed(){
		    	return btnAccountingDate.isDisplayed();
		    	
		    }
		    public void clickAccountingDateButton(){
		    	SeleniumUtils.delay(3000);
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
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'mjept1:AP1:id2::pop::cd::cg')]//td"));  
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

		   // Enter Description field
		   
		   public void enterDescription(String strDescription) throws InterruptedException{
			   //SeleniumUtils.delay(2000);
			   txtDescription.clear();
			   txtDescription.click();
			   txtDescription.sendKeys(strDescription);
			  // txtJournalCategory.sendKeys(Keys.ENTER);
			  // txtJournalCategoryDescription.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Entered value for Description is: "+strDescription);
		   }
		   
		   // Select selectCompletionStatus
		   public void selectCompletionStatus(String strCompletionStatus){
		    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
		    	Select objSelect = new Select(selectCompletionStatus);
		    	objSelect.selectByVisibleText(strCompletionStatus);
		    	
		    	SeleniumUtils.delay(1000);
		    	//report.log(LogStatus.PASS, "Selected Completion Status  is: "+strCompletionStatus);
		    } 
		   
		 //LegalEntity list
		   public void SelectLegalEntity(String strLegalEntity) throws InterruptedException{
		   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   selectLegalEntity.click();
		   	//SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
			   selectLegalEntity.sendKeys(strLegalEntity);
		   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
			   selectLegalEntity.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(3000);
		   // report.log(LogStatus.PASS, "Selected LegalEntity is: "+strLegalEntity);
		   }
		   
		   public boolean isLegalEntityDisplayed(){
			   return selectLegalEntity.isDisplayed();
			   } 
		  // Add Row button
		   
		   public boolean isAddRowButtonDisplayed(){
			   return btnAddRow.isDisplayed();
			   } 
		   
		   public void clickAddRowButton(){	
			   btnAddRow.click();
			   //SeleniumUtils.delay(5000);
			   //wdwait.until(ExpectedConditions.visibilityOf(btnAccount1));
			   report.log(LogStatus.PASS, "Clicked on Add Row Button"); 
			   SeleniumUtils.delay(2000);
		   }
		   
		  //  Click btnAccount1
		   
		   public boolean isAccount1ButtonDisplayed(){
			   return btnAccount1.isDisplayed();
			   } 
		   
		   public void clickAccount1Button(){
			   SeleniumUtils.delay(2000);
			   JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", btnAccount1);
			  // btnAccount1.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnAccount1_Ok));
			   report.log(LogStatus.PASS, "Clicked on Account Button");   
		   }
		   
		   // Click on Accounts Pop up Ok button
		   
		   public boolean isAccountPopUp1_OkButtonDisplayed(){
			   return btnAccount1_Ok.isDisplayed();
			   } 
		   
		   public void clickAccountPopUp1_OkButton(){	
			   btnAccount1_Ok.click();
			   //wdwait.until(ExpectedConditions.visibilityOf(btnAccount1_Ok));
			   report.log(LogStatus.PASS, "Clicked on Account Button");   
		   }
		   
		  // AccountValue In Line 
		   public void enterAccountValue(int rownum,String strAccountValue){ 
			   
			   int r=rownum;
			   int j=r-1;
			  
			   SeleniumUtils.delay(10000);
			   WebElement txtAccountValue =driver.findElement(By.xpath("//*[contains(@id,'AP1:AT2:_ATp:table2:"+j+":kf1CS::content')]"));
			   SeleniumUtils.delay(5000);
			   txtAccountValue.click();
			   txtAccountValue.clear();
			   txtAccountValue.sendKeys(strAccountValue); 
		    	SeleniumUtils.delay(2000);
		    	//report.log(LogStatus.PASS, "Entered Amount in cell  is: "+strCellAmount);
			   }
		   // selectAccountingClass1
		   
		   public void SelectAccountingClass1(String strAccountingClass1) throws InterruptedException{
			   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   selectAccountingClass1.click();
			   	//SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
			   selectAccountingClass1.sendKeys(strAccountingClass1);
			   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
			   selectAccountingClass1.sendKeys(Keys.ENTER);
			   selectAccountingClass1.click();
			   	SeleniumUtils.delay(3000);
			   // report.log(LogStatus.PASS, "Selected LegalEntity is: "+strAccountingClass1);
			   }
			   
			   public boolean isAccountingClass1Displayed(){
				   return selectAccountingClass1.isDisplayed();
				   } 
			   
			   // Enter Debit field
			   
			   public void enterDebit(String strDebit) throws InterruptedException{
				   //SeleniumUtils.delay(2000);
				   txtDebit1.clear();
				   txtDebit1.click();
				   txtDebit1.sendKeys(strDebit);
				  // txtJournalCategory.sendKeys(Keys.ENTER);
				  // txtJournalCategoryDescription.click();
				   SeleniumUtils.delay(2000);
				  // report.log(LogStatus.PASS, "Entered value for Debit is: "+strDebit);
			   } 
			   
			   public boolean isDebit1Displayed(){
				   return txtDebit1.isDisplayed();
				   } 
			   // Click on Credit1
			   public void clickCredit() throws InterruptedException{
				   //SeleniumUtils.delay(2000);
				   txtCredit1.click();
			   }
			//  Click btnAccount2
			   
			   public boolean isAccount2ButtonDisplayed(){
				   return btnAccount2.isDisplayed();
				   } 
			   
			   public void clickAccount2Button(){
				   SeleniumUtils.delay(2000);
				   JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", btnAccount2);
				   //btnAccount2.click();
				   wdwait.until(ExpectedConditions.visibilityOf(btnAccount2_Ok));
				   report.log(LogStatus.PASS, "Clicked on Account Button");   
			   }
			   
			// Click on Accounts Pop up 2 Ok button
			   
			   public boolean isAccountPopUp2_OkButtonDisplayed(){
				   return btnAccount2_Ok.isDisplayed();
				   } 
			   
			   public void clickAccountPopUp2_OkButton(){	
				   btnAccount2_Ok.click();
				   //wdwait.until(ExpectedConditions.visibilityOf(btnAccount1_Ok));
				   report.log(LogStatus.PASS, "Clicked on Account Button");   
			   }
			   
			   // Enter Credit field
			   
			   public void enterCredit(String strDebit) throws InterruptedException{
				   //SeleniumUtils.delay(2000);
				   txtCredit2.clear();
				   txtCredit2.click();
				   txtCredit2.sendKeys(strDebit);
				  // txtJournalCategory.sendKeys(Keys.ENTER);
				  // txtJournalCategoryDescription.click();
				   SeleniumUtils.delay(2000);
				   //report.log(LogStatus.PASS, "Entered value for Debit is: "+strDebit);
			   } 
			   
			   public boolean isCredit2Displayed(){
				   return txtDebit2.isDisplayed();
				   } 
			   // Click on Credit1
			   public void clickDebit() throws InterruptedException{
				   //SeleniumUtils.delay(2000);
				   txtDebit2.click();
			   }
			   
			// Search icon Accounting Class List 2
			   
			   public void clickAccountingClassList2SearchIcon() throws InterruptedException{ 
				   iconAccountingClassList2.click();
				   wdwait.until(ExpectedConditions.visibilityOf(lnkAccountingClassList2Search));
				   report.log(LogStatus.PASS, "Clicked on Accounting Class List Search Icon");
			   }
			   
			   public boolean isAccountingClassList2SearchIconDisplayed(){
				   return iconAccountingClassList2.isDisplayed();
			   }
			   
			// Search Link for Accounting Class List2
			   
			   public void clickAccountingClassList2SearchLink() throws InterruptedException{
				   wdwait.until(ExpectedConditions.visibilityOf(lnkAccountingClassList2Search));
				   lnkAccountingClassList2Search.click();
				    wdwait.until(ExpectedConditions.visibilityOf(txtAccountingClass));
				   report.log(LogStatus.PASS, "Clicked on Accounting Class List Search link");
			   }
			   
			   public boolean isAccountingClassList2SearchLinkDisplayed(){
				   return lnkAccountingClassList2Search.isDisplayed();
			   } 
			   
			   // Enter party value in Party field
			   
			   public void enterAccountingClass(String strJournalCategory) throws InterruptedException{
				   //SeleniumUtils.delay(2000);
				   txtAccountingClass.clear();
				   txtAccountingClass.click();
				   txtAccountingClass.sendKeys(strJournalCategory);
				   txtAccountingClass.sendKeys(Keys.ENTER);
				   
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Entered value for Accounting Class is: "+strJournalCategory);
			   }
			   
			   
			   public boolean isAccountingClassDisplayed(){
				   return txtAccountingClass.isDisplayed();
				   } 
			   
			   
			// Search button in JournalCategory
			   public void clickAccountingClassSearchButton(){	
				   btnAccountingClassSearch.click();
					SeleniumUtils.delay(3000);
				   //btnAccSearch.click();
				   report.log(LogStatus.PASS, "Clicked on Accounting Class Search Button");
			   }
			   
			   public boolean isAccountingClassSearchButtonDisplayed(){
				   return btnAccountingClassSearch.isDisplayed();
			   } 
			   
			 //Select Event (select given text from dropdown)
			   public void selectAccountingClass(String eventName) throws InterruptedException { 
				   
				   WebDriverWait wait = new WebDriverWait(driver, 50);
				   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'acctgClassMeaningId_afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));	   
				   SeleniumUtils.delay(2000);
				   eventLink.click(); 
				   SeleniumUtils.delay(5000);
				   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
				   }
			   
			// Journal Accounting Class Ok button
			   
			   public boolean isAccountingClassOkButtonDisplayed(){
				   return btnAccountingClassOk.isDisplayed();
			   }
			   
			   public void clickAccountingClassOkButton(){	
				   SeleniumUtils.delay(3000);
				   btnAccountingClassOk.click();
				   SeleniumUtils.delay(3000);
				   report.log(LogStatus.PASS, "Clicked on Accounting Class Ok Button");   
			   }   
			
		   // Click on Save button
			   
			   public boolean isSaveButtonDisplayed(){
				   return btnSave.isDisplayed();
			   } 
			   
			   public SubledgerJournalEntryPage clickSave() throws TestException{
					
					btnSave.click();
					SeleniumUtils.delay(3000);
					wdwait.until(ExpectedConditions.visibilityOf(lblSave));
					report.log(LogStatus.PASS, "Clicked on Save link");
					return new SubledgerJournalEntryPage(driver,report);
				 }  
			   
			   
			   /////////////////////////////
			   
			// Search Company 
			   
			   public void clickCompanySearchIcon() throws InterruptedException{
				   
				   SeleniumUtils.delay(3000);
					/*JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", srchCompany);*/
				   	srchCompany.click();
			    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value00::dropdownPopup::popupsearch')]")));
			    	report.log(LogStatus.PASS, "Clicked on Company Search Icon");
				   
			   }
			   
			   public boolean isCompanySearchIconDisplayed(){
				  // return SeleniumUtils.isDisplayed(driver, srchCompany, context.getReactTimeout());
				   return srchCompany.isDisplayed();
			   } 
			   
			// Search Region
			   
			   public void clickRegionSearchIcon() throws InterruptedException{	
				  // SeleniumUtils.delay(3000);
					/*JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", srchRegion);*/
				   	srchRegion.click();
			    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value10::dropdownPopup::popupsearch')]")));
				   //srchRegion.click();
				   report.log(LogStatus.PASS, "Clicked on Region Search Icon");
			   }
			   
			   public boolean isRegionSearchIconDisplayed(){
				   //return SeleniumUtils.isDisplayed(driver, srchRegion, context.getReactTimeout());
				   return srchRegion.isDisplayed();
			   } 
			   
			   
			// Search Country
			   
			   public void clickCountrySearchIcon() throws InterruptedException{
				  // SeleniumUtils.delay(3000);
				/*   JavascriptExecutor js = (JavascriptExecutor)driver;
			   	js.executeScript("arguments[0].click();", srchCountry);*/
				   srchCountry.click();
			   	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value20::dropdownPopup::popupsearch')]")));
			   	//SeleniumUtils.delay(3000);
				   //srchCountry.click();
				   report.log(LogStatus.PASS, "Clicked on Country Search Icon");
			   }
			   
			   public boolean isCountrySearchIconDisplayed(){
				   //return SeleniumUtils.isDisplayed(driver, srchCountry, context.getReactTimeout());
				   return srchCountry.isDisplayed();
				   
			   } 
			   // Search Service
			   
			   public void clickServiceSearchIcon() throws InterruptedException{	
				   //SeleniumUtils.delay(3000);
				   /*JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", srchService);*/
				   srchService.click();
			    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value30::dropdownPopup::popupsearch')]")));
				   report.log(LogStatus.PASS, "Clicked on Service Search Icon");
			   }
			   
			   
			   public boolean isServiceSearchIconDisplayed(){
				   //return SeleniumUtils.isDisplayed(driver, srchService, context.getReactTimeout());
				   return srchService.isDisplayed();
			   }
			   
			   // Search Location
			   
			   public void clickLocationSearchIcon() throws InterruptedException{
				   
				  // srchLocation.click();
				   // SeleniumUtils.delay(8000);
					/*JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", srchLocation);*/
				   srchLocation.click();
			    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value40::dropdownPopup::popupsearch')]")));
				   report.log(LogStatus.PASS, "Clicked on Location Search Icon");
			   }
			   
			   public boolean isLocationSearchIconDisplayed(){
			   
			   //	return SeleniumUtils.isDisplayed(driver, srchLocation, context.getReactTimeout());
			    return srchLocation.isDisplayed();
			   }
			   
			   // Search Department
			   
			   public void clickDepartmentSearchIcon() throws InterruptedException{	
				   //SeleniumUtils.delay(3000);
				/*	JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", srchDepartment);*/
				   	srchDepartment.click();
					wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value50::dropdownPopup::popupsearch')]")));
				   //srchDepartment.click();
				   report.log(LogStatus.PASS, "Clicked on Department Search Icon");
			   }
			   
			  
			   public boolean isDepartmentSearchIconDisplayed(){
			   	
			   	//return SeleniumUtils.isDisplayed(driver, srchDepartment, context.getReactTimeout());
				   return srchDepartment.isDisplayed();
			   }
			   
			// Search Natural Account
			   
			   public void clickNaturalAccountSearchIcon() throws InterruptedException{	
				   WebDriverWait wait = new WebDriverWait(driver, 50);
				   //WebElement srchNaturalAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'query:value60::lovIconId')]")));
				   WebElement elementsrchNaturalAccount = wait.until(ExpectedConditions.elementToBeClickable(srchNaturalAccount));
				   SeleniumUtils.isDisplayed(driver, srchNaturalAccount, context.getReactTimeout());   
				   elementsrchNaturalAccount.click();
				   SeleniumUtils.delay(5000);
				   report.log(LogStatus.PASS, "Clicked on Natural Account Search Icon");
			   }
			   
			   public boolean isNaturalAccountSearchIconDisplayed(){
				   //return SeleniumUtils.isDisplayed(driver, srchNaturalAccount, context.getReactTimeout());
				   return srchNaturalAccount.isDisplayed();
			   }
			   
			 //Search link for Account
			   
			   public void clickAccountSearchLink() throws InterruptedException{	
				   
				   WebDriverWait wait = new WebDriverWait(driver, 50);	 
				   WebElement elementlnkAccountSearch = wait.until(ExpectedConditions.elementToBeClickable(lnkAccountSearch));
				   
				   // SeleniumUtils.delay(3000);
				    elementlnkAccountSearch.click();
				    SeleniumUtils.delay(5000);
					/*JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", lnkAccountSearch);*/
				   report.log(LogStatus.PASS, "Clicked on Account Search link");
			   }
			   
			   public boolean isAccountSearchLinkDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, lnkAccountSearch, context.getReactTimeout());
			   }  
			   
			 //Value for Search
			   
			   public void enterAccountValue(String value) throws InterruptedException{
				   SeleniumUtils.delay(3000);
				   txtAccValue.clear();
				   txtAccValue.click();
				   txtAccValue.sendKeys(value);
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Entered value for Natural Account is: "+value);
			   }
			   
			   public boolean isAccountValueDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, txtAccValue, context.getReactTimeout());
				   } 
			   
			// Search button in Account
			   public void clickAccountSearchButton(){	
						/*JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", btnAccSearch);*/
				   	btnAccSearch.click();
						SeleniumUtils.delay(3000);
				   //btnAccSearch.click();
				   report.log(LogStatus.PASS, "Clicked on Account Search Button");
			   }
			   
			   public boolean isAccountSearchButtonDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, btnAccSearch, context.getReactTimeout());
			   } 
			   
			//  Ok Button for Natural Account
			   
			   public void clickAccountOkButton(){	
				   
				   WebDriverWait wait = new WebDriverWait(driver, 50);	 
				   WebElement elementbtnAccOk = wait.until(ExpectedConditions.elementToBeClickable(btnAccOk));
				    //SeleniumUtils.delay(3000);
				   elementbtnAccOk.click();
				  
				    /*SeleniumUtils.delay(2000);
				   btnAccOk.click();*/
				   SeleniumUtils.delay(5000);
				   report.log(LogStatus.PASS, "Clicked on Account Ok Button");
				   
			   }
			   
			   public boolean isAccountOkButtonDisplayed(){
				   return SeleniumUtils.isDisplayed(driver, btnAccOk, context.getReactTimeout());
			   }  
			   
			// Search Intercompany
			   
			   public void clickIntercompanySearchIcon() throws InterruptedException{	
				   //SeleniumUtils.delay(3000);
				  /* JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", srchIntercompany);*/
				   srchIntercompany.click();
					wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value70::dropdownPopup::popupsearch')]")));
				   //srchIntercompany.click();
				   report.log(LogStatus.PASS, "Clicked on Intercompany Search Icon");
			   }
			   
			   public boolean isIntercompanySearchIconDisplayed(){
				  // return SeleniumUtils.isDisplayed(driver, srchIntercompany, context.getReactTimeout());
				   return srchIntercompany.isDisplayed();
			   }
			  
			   // Search Fund Source
			   
			   public void clickFundSourceSearchIcon() throws InterruptedException{	
				   //SeleniumUtils.delay(3000);
				  /* JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", srchFundSource);*/
				   srchFundSource.click();
					wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value80::dropdownPopup::popupsearch')]")));
				  // srchFundSource.click();
				   report.log(LogStatus.PASS, "Clicked on FundSource Search Icon");
			   }
			   
			   public boolean isFundSourceSearchIconDisplayed(){
				   //return SeleniumUtils.isDisplayed(driver, srchFundSource, context.getReactTimeout());
				   return srchFundSource.isDisplayed();
			   }
			   
			   // Search Future1
			   
			   public void clickFuture1SearchIcon() throws InterruptedException{
				  // SeleniumUtils.delay(3000);
				  /* JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", srchFuture1);*/
				   srchFuture1.click();
					wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value90::dropdownPopup::popupsearch')]")));
					//SeleniumUtils.delay(3000);
				   report.log(LogStatus.PASS, "Clicked on Future1 Search Icon");
			   }
			   
			   public boolean isFuture1SearchIconDisplayed(){
//				   return SeleniumUtils.isDisplayed(driver, srchFuture1, context.getReactTimeout());
				   return srchFuture1.isDisplayed();
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
			   
			   public void verifySearchEvent(String eventName) throws InterruptedException { 
				   WebDriverWait wait = new WebDriverWait(driver, 15);
				   //WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '"+eventName+"')]")));
				   //WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
				   WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '"+eventName+"')]")));
				   //SeleniumUtils.isDisplayed(driver, eventText, context.getReactTimeout());
				   report.log(LogStatus.PASS, "Verified list is: "+eventName);
				   }
			   
			   public void verifyEvent(String eventName) throws InterruptedException { 
				   WebDriverWait wait = new WebDriverWait(driver, 50);
				   //WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='"+eventName+"']")));
				   WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+eventName+"']")));
				   SeleniumUtils.isDisplayed(driver, eventText, context.getReactTimeout()); 
				   report.log(LogStatus.PASS, "Selected and verified list is: "+eventName);
				   }
			   
	    @Override
			public boolean isDisplayed() {
				// TODO Auto-generated method stub
				//return  btnTasks.isDisplayed();
				
				 report.log(LogStatus.PASS, "Create Subledger Journal Entry page is Loaded Successfully");
		    	 if(selectLedger.isDisplayed())
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
			   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Subledger Journal Entry Page</span></a>");
			   	return new Item(xyz);
		   }

}
