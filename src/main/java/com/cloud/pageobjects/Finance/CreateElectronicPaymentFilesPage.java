package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
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

public class CreateElectronicPaymentFilesPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'BankAccountName::content')]")
	    private WebElement selectDisBankAccount;
	 	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute7_ATTRIBUTE7::content')]")
	    private WebElement selectCurrency;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'BusinessUnit::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute16_ATTRIBUTE16::glyph')]")
	    private WebElement btnFromPaymentDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute16_ATTRIBUTE16::pop::cd::mSel::content')]")
	    private WebElement selectFromPaymentMonth;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Attribute16_ATTRIBUTE16::pop::cd::cg')]")
	    private WebElement tableFromPaymentMonth;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'Attribute16_ATTRIBUTE16::pop::cd::ys::content')]")
	    private WebElement txtFromPaymentYear;

	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute16_ATTRIBUTE16::pop::cd::ys::decrement')]")
	    private WebElement btnPrevFromPayment;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute16_ATTRIBUTE16::pop::cd::ys::increment')]")
	    private WebElement btnNextFromPayment;
	
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute17_ATTRIBUTE17::glyph')]")
	    private WebElement btnToPaymentDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute17_ATTRIBUTE17::pop::cd::mSel::content')]")
	    private WebElement selectToPaymentMonth;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Attribute17_ATTRIBUTE17::pop::cd::cg')]")
	    private WebElement tableToPaymentMonth;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'Attribute17_ATTRIBUTE17::pop::cd::ys::content')]")
	    private WebElement txtToPaymentYear;

	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute17_ATTRIBUTE17::pop::cd::ys::decrement')]")
	    private WebElement btnPrevToPayment;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute17_ATTRIBUTE17::pop::cd::ys::increment')]")
	    private WebElement btnNextToPayment;

	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Attribute12_ATTRIBUTE12::lovIconId')]")
	    private WebElement iconPPRsearch;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Attribute12_ATTRIBUTE12::dropdownPopup::popupsearch')]")
	    private WebElement lnkPPRsearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId:value00::content')]")
	    private WebElement txtPaymentProcessRequest;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId::search')]")
	    private WebElement btnSearch_PPR;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnOk_PPR;

	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute3_ATTRIBUTE3::content')]")
	    private WebElement selectPaymentDocument;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
	    private WebElement btnSubmit;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:pt_ol1')]")
	    private WebElement lblConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmationPopup:confirmSubmitDialog::ok')]")
		private WebElement btnConfOk;
	 
	 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public CreateElectronicPaymentFilesPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(selectDisBankAccount));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Create Electronic Payment  Files Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	  //Disbursement Bank Account
		   public void SelectDisbursementBankAccount(String strDisBankAccount) throws InterruptedException{
		    selectDisBankAccount.click();
		   	selectDisBankAccount.sendKeys(strDisBankAccount);
		   	selectDisBankAccount.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(5000);
		    //report.log(LogStatus.PASS, "Selected given Disbursement Bank Account from the list is: "+strDisBankAccount);
		   }
		   
		   public boolean isDisbursementBankAccountDisplayed(){
			   return selectDisBankAccount.isDisplayed();
			   }    
		   
		   // Select Currency 
		   
		   public void selectCurrency(String strCurrency){
			    SeleniumUtils.delay(2000);
		    	Select objSelect = new Select(selectCurrency);
		    	objSelect.selectByVisibleText(strCurrency);
		    	SeleniumUtils.delay(2000);
		    	//report.log(LogStatus.PASS, "Selected given Currency from the list is: "+strCurrency);
		    }
		   
		   public boolean isCurrencyDisplayed(){
			   return selectCurrency.isDisplayed();
		   }  
		   
		 //Business Unit
		   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
		    selectBusinessUnit.click();
		   	selectBusinessUnit.sendKeys(strBusinessUnit);
		   	selectBusinessUnit.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(5000);
		    //report.log(LogStatus.PASS, "Selected given Business Unit from the list is: "+strBusinessUnit);
		   }
		   
		   public boolean isBusinessUnittDisplayed(){
			   return selectDisBankAccount.isDisplayed();
			   } 
		   
		// click on From Payment Date Calendar button
		      
		   public boolean isFromPaymentDateBtnDisplayed(){
		    	return btnFromPaymentDate.isDisplayed();
		    	
		    }
		    public void clickFromPaymentDateButton(){	    	
		    	btnFromPaymentDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromPaymentMonth));
		    	//SeleniumUtils.delay(3000);
		    	report.log(LogStatus.PASS, "Clicked on From Payment Date Button");
		    }
		    
		 // Select From Payment Year from Calander
		    public void SelectYearFromDatePickerFromPaymentYear(String fromYear){
		    	
		    	String HireYearLbl=txtFromPaymentYear.getAttribute("title");
		    	
		    	while (fromYear != HireYearLbl)
		        {
		            if (Integer.parseInt(fromYear) < Integer.parseInt(HireYearLbl))
		            {
		                btnPrevFromPayment.click();
		                String HireYearLbl1=txtFromPaymentYear.getAttribute("title");
		                if(Integer.parseInt(fromYear) == Integer.parseInt(HireYearLbl1))
		                {
		                	break;
		                }
		            }
		            else
		            {
		            	
		                btnNextFromPayment.click();
		                String HireYearLbl2=txtFromPaymentYear.getAttribute("title");
		                if(Integer.parseInt(fromYear) == Integer.parseInt(HireYearLbl2))
		                {
		                	break;
		                }

		            }
		        }
		    	report.log(LogStatus.PASS, "Selected From Payment Year is: "+fromYear);
		    } 
		   
		   // Select From Date Month from Calander
		    public void selectFromPaymentDateMonth(String fromMonth){
		    	Select objSelect = new Select(selectFromPaymentMonth);
		    	objSelect.selectByVisibleText(fromMonth);
		    	 //wdwait.until(ExpectedConditions.visibilityOf(calendarFromInvoiceDt));
		    	SeleniumUtils.delay(2000);
		    	report.log(LogStatus.PASS, "Selected From Payment Date Month is: "+fromMonth);
		    } 
		   
		   public boolean isFromPaymentDateMonthDisplayed(){
			   return selectFromPaymentMonth.isDisplayed();
		   }
		   
		   // Select From Payment Date
		   public void selectFromPaymentDate(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'Attribute16_ATTRIBUTE16::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(fromDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Payment Date is "+fromDate);
					   break;
					   
				   }
				  } 
				  
			  }
		   
		// click on To Payment Date Calendar button
		      
		   public boolean isToPaymentDateBtnDisplayed(){
		    	return btnToPaymentDate.isDisplayed();
		    	
		    }
		    public void clickToPaymentDateButton(){	    	
		    	btnToPaymentDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectToPaymentMonth));
		    	//SeleniumUtils.delay(3000);
		    	report.log(LogStatus.PASS, "Clicked on To Payment Date Button");
		    }
		    
		 // Select From Payment Year from Calander
		    public void SelectYearFromDatePickerToPaymentYear(String fromYear){
		    	
		    	String HireYearLbl=txtToPaymentYear.getAttribute("title");
		    	
		    	while (fromYear != HireYearLbl)
		        {
		            if (Integer.parseInt(fromYear) < Integer.parseInt(HireYearLbl))
		            {
		                btnPrevToPayment.click();
		                String HireYearLbl1=txtToPaymentYear.getAttribute("title");
		                if(Integer.parseInt(fromYear) == Integer.parseInt(HireYearLbl1))
		                {
		                	break;
		                }
		            }
		            else
		            {
		            	
		                btnNextToPayment.click();
		                String HireYearLbl2=txtToPaymentYear.getAttribute("title");
		                if(Integer.parseInt(fromYear) == Integer.parseInt(HireYearLbl2))
		                {
		                	break;
		                }

		            }
		        }
		    	report.log(LogStatus.PASS, "Selected To Payment Year is: "+fromYear);
		    } 
		   
		   
		   // Select From Date Month from Calander
		    public void selectToPaymentDateMonth(String toMonth){
		    	Select objSelect = new Select(selectToPaymentMonth);
		    	objSelect.selectByVisibleText(toMonth);
		    	 //wdwait.until(ExpectedConditions.visibilityOf(calendarFromInvoiceDt));
		    	SeleniumUtils.delay(2000);
		    	report.log(LogStatus.PASS, "Selected To Payment Date Month is: "+toMonth);
		    } 
		   
		   public boolean isToPaymentDateMonthDisplayed(){
			   return selectToPaymentMonth.isDisplayed();
		   }
		   
		   // Select From Payment Date
		   public void selectToPaymentDate(String toDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'Attribute17_ATTRIBUTE17::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(toDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected To Payment Date is "+toDate);
					   break;
					   
				   }
				  } 
				  
			  }
		   
		   // Search icon Payment Process Request
		   
		   public void clickPaymentProcessRequestSearchIcon() throws InterruptedException{ 
			   iconPPRsearch.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lnkPPRsearch));
			   report.log(LogStatus.PASS, "Clicked on Payment Process Request Search Icon");
		   }
		   
		   public boolean isPaymentProcessRequestSearchIconDisplayed(){
			   return iconPPRsearch.isDisplayed();
		   }
		   
		// Search Link for Payment Process Request
		   
		   public void clickPaymentProcessRequestSearchLink() throws InterruptedException{
			   wdwait.until(ExpectedConditions.visibilityOf(lnkPPRsearch));
			   lnkPPRsearch.click();
			    wdwait.until(ExpectedConditions.visibilityOf(txtPaymentProcessRequest));
			   report.log(LogStatus.PASS, "Clicked on Payment Process Request Search link");
		   }
		   
		   public boolean isPaymentProcessRequestSearchLinkDisplayed(){
			   return lnkPPRsearch.isDisplayed();
		   } 
		   
		   // Enter party value in Party field
		   
		   public void enterPaymentProcessRequest(String strJournalCategory) throws InterruptedException{
			   //SeleniumUtils.delay(2000);
			   txtPaymentProcessRequest.clear();
			   txtPaymentProcessRequest.click();
			   txtPaymentProcessRequest.sendKeys(strJournalCategory);
			   txtPaymentProcessRequest.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Entered value for Payment Process Request is: "+strJournalCategory);
		   }
		   
		   
		   public boolean isPaymentProcessRequestDisplayed(){
			   return txtPaymentProcessRequest.isDisplayed();
			   } 
		   
		   
		// Search button in Payment Process Request
		   public void clickPaymentProcessRequestSearchButton(){	
			   btnSearch_PPR.click();
			   SeleniumUtils.delay(3000);
			   //btnAccSearch.click();
			   report.log(LogStatus.PASS, "Clicked on Payment Process Request Search Button");
		   }
		   
		   public boolean isPaymentProcessRequestSearchButtonDisplayed(){
			   return btnSearch_PPR.isDisplayed();
		   } 
		   
		 //Select Event (select given text from dropdown)
		   public void selectPaymentProcessRequest(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));	   
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		// Payment Process Request Ok button
		   
		   public boolean isPaymentProcessRequestOkButtonDisplayed(){
			   return btnOk_PPR.isDisplayed();
		   }
		   
		   public void clickPaymentProcessRequestOkButton(){	
			   btnOk_PPR.click();
			   SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on Payment Process Request Ok Button");   
		   } 
		   
		   // Select Payment Document 
		   
		   public void selectPaymentDocument(String strPaymentDocument){
			    SeleniumUtils.delay(2000);
		    	Select objSelect = new Select(selectPaymentDocument);
		    	objSelect.selectByVisibleText(strPaymentDocument);
		    	SeleniumUtils.delay(2000);
		    	//report.log(LogStatus.PASS, "Selected given Payment Document from the list is: "+strPaymentDocument);
		    }
		   
		   public boolean isPaymentDocumentDisplayed(){
			   return selectPaymentDocument.isDisplayed();
		   }    
		   
		  // submit button
		   
		   public boolean isSubmitButtonDisplayed(){
			   return btnSubmit.isDisplayed();
		   }
		   
		   public void clickSubmitButton(){	
			   btnSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");   
		   } 
		   
		// Conf Massege 
		   public String ConfirmationProcessId() {
			   SeleniumUtils.delay(4000);
			   String ConfMessage=lblConfOk.getText();
			   //System.out.println("String is "+ConfMessage);
			   return ConfMessage.substring(8,14);
		   }
		   
		// Confirmation Ok Button
		   public boolean isConfOkBtnDisplayed(){
			   return btnConfOk.isDisplayed();  	
		   }  
	   
		   public void clickConfOkButton(){
			   String ConfMessage=lblConfOk.getText();
			   btnConfOk.click();
			   report.log(LogStatus.PASS, ""+ConfMessage+" Clicked on Confirmation Ok Button");
			   SeleniumUtils.delay(3000);
		   }  
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Create Electronic Payment  Files Page is Loaded Successfully");
	    	 if(selectDisBankAccount.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Electronic Payment  Files Page</span></a>");
		   	return new Item(xyz);
	   }

}
