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

public class ScheduledProcessesPage extends BasePageObject{
	
	public WebDriver driver;
	
	// Changed Schedule New Process button properties
	 //@FindBy(how=How.XPATH, using = "//div[contains(@id,'pt1:panel:scheduleProcess')]/a[@class='xu0']")
	 @FindBy(how=How.XPATH, using = "//div[contains(@id,'pt1:panel:scheduleProcess')]")
	    private WebElement btnScheduleNewProcess;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::lovIconId')]")
	    private WebElement iconScdlProcessName;
	
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::dropdownPopup::popupsearch')]")
	    private WebElement lnkSrchScdlProcessName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::_afrLovInternalQueryId::search')]")
	    private WebElement btnSearchName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:selectOneChoice2::lovDialogId::ok')]")
	    private WebElement btnOkName;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:snpokbtnid')]")
	    private WebElement btnOkScdlProcessName;
	
	 
	 //Changed properties title of Process details window
	// @FindBy(how=How.XPATH, using = ".//*[@id='pt1:USma:0:MAnt1:0:pt1:srspw1::_ttxt']")
	 	@FindBy(how=How.XPATH, using = "//*[contains(@id,'0:pt1:srspw1::_ttxt')]")
	    private WebElement ttlProcessDetails; 
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Attribute1_ATTRIBUTE1::lovIconId')]")
	    private WebElement iconPaymentFileSearch;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'dropdownPopup::popupsearch')]")
	    private WebElement lnkPaymentFileSearch;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtReference;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnReferenceSearch;
	
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnReferenceOk;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'basicReqBody:paramDynForm_Attribute2::content')]")
	    private WebElement selectFormat;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'jobDisplayNameId::content')]")
	    private WebElement selectImportProcess;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ucmFileId::content')]")
	    private WebElement selectDataFile;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfirmation;
	 
	 //Process Details_Basic Options Pop-up
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'aTTRIBUTE4Id::content')]")
	    private WebElement inputAccPeriod_BscOptions;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'soc4::content')]")
	    private WebElement selectAmountType;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'kff1_ACKFF_KFFButconImage1::icon')]")
	    private WebElement btnBalancingSegment;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'kff1_kffSearchDialog::_ttxt')]")
	    private WebElement ttlBalancingSegment;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'KFFFILTERFilterCriteria:addFields::popEl')]")
	    private WebElement selectAddFields;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'KFFFILTERFilterCriteria:addFieldsIter:0:adFldMenuItem')]/td[2]")
	    private WebElement selectCompany;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'KFFFILTERFilterCriteria:value00::lovIconId')]")
	    private WebElement icnCompanySearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'basicReqBody:dynam1:0:kff1SEl')]")
	    private WebElement btnCompanyOk;
	 //////////////////////////////
	 
	//Process Details_Payables Invoice Aging Report Basic Options Pop-up
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_Party::lovIconId')]")
	    private WebElement iconSearchSupplierOrParty;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ATTRIBUTE7_ATTRIBUTE7::content')]")
	    private WebElement selectIncludeInvoiceDetail;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ATTRIBUTE8_ATTRIBUTE8::content')]")
	    private WebElement selectIncludeSupplierSiteDetail;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ATTRIBUTE13_ATTRIBUTE13::content')]")
	    private WebElement selectAgingPeriod;
	 
	 /////////////////////////////////////////////////
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_BusinessUnit::content')]")
	    private WebElement selectBussinessUnit;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_SupplierName::lovIconId')]")
	    private WebElement iconSearchSupplierName;
	 
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_SupplierName::dropdownPopup::popupsearch')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'::dropdownPopup::popupsearch')]")
	    private WebElement lnkSearchSupplierName;
	
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::_afrLovInternalQueryId:value00::content')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtSupplierName;
	 
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::_afrLovInternalQueryId:value10::content')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value10::content')]")
	    private WebElement txtSupplierNumber;
	 
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::_afrLovInternalQueryId::search')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId::search')]")
	    private WebElement btnSearchSuplName;
	 
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'SupplierName::lovDialogId::ok')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'::lovDialogId::ok')]")
	    private WebElement btnOkSuplName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:basicReqBody:paramDynForm_FromEnteredDate::glyph')]")
	    private WebElement btnFromEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_FromEnteredDate::pop::cd::mSel::content')]")
	    private WebElement selectFromEnteredMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_FromEnteredDate::pop::cd::cg')]")
	    private WebElement tbleFromEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ToEnteredDate::glyph')]")
	    private WebElement btnToEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ToEnteredDate::pop::cd::mSel::content')]")
	    private WebElement selectToEnteredMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ToEnteredDate::pop::cd::cg')]")
	    private WebElement tbleToEnteredDt;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE9_ATTRIBUTE9::content')]")
	    private WebElement selectAccPeriod;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:submitButton')]")
	    private WebElement btnSubmitPrcDetails;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'pt1:panel:processRefreshId::icon')]")
	    private WebElement btnRefresh;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'pt1:attachment1:attachmentMoreLink')]")
	    private WebElement lnkMore;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'1:glPopFileLiveFile')]")
	    private WebElement lnkPDFProcessID;
	 
	 @FindBy(how=How.XPATH, using = ".//*[@id='templateTableBody']/tr[2]/td[1]/span")
	    private WebElement lnkDefaultDocument;
	 
	 @FindBy(xpath = "//span[contains(@class,'dataLink')]")
	  private WebElement lnkDafaultDocument;
	 
	 @FindBy(xpath = "//button[contains(.,'Republish')]")
	 private WebElement btnRepublish;
	 
	
	 @FindBy(xpath = "//*[@id='download']")
	  private WebElement btnDownload;
	 
	 @FindBy(xpath = "//*[contains(@id,':0:_FOTsr1:0:pt1:selectOneChoice2_afrLovInternalTableId::db')]")
	  private WebElement tableProcessNames;
	 
	 @FindBy(xpath = "//select[contains(@id,'ATTRIBUTE1::content')]")
	 private WebElement selBusUnit;
	 
	 private List<WebElement> rowcount;
	
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ScheduledProcessesPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 20);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnScheduleNewProcess));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Scheduled Processes Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    // Schedule New Process button
	    public void clickScheduleNewProcessButton(){	
	    	btnScheduleNewProcess.click();
	    	
	    	//	wdwait.until(ExpectedConditions.visibilityOf(btnOkScdlProcessName));
			   wdwait.until(ExpectedConditions.visibilityOf(iconScdlProcessName));
			   report.log(LogStatus.PASS, "Clicked on Schedule New Process Button");
		   }
		   
		   public boolean isScheduleNewProcessBtnDisplayed() throws InterruptedException{
			   return btnScheduleNewProcess.isDisplayed();		 
		   } 
		// Click on icon Schedule New ProcessName   
		  		   
		   public void clickSearchScheduleNewProcessIcon(){	
			   iconScdlProcessName.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lnkSrchScdlProcessName));
			   report.log(LogStatus.PASS, "Clicked on Schedule New Process Search icon");  
			   
		   }
		   
		   public boolean isSearchScheduleNewProcessIconDisplayed(){
			   return iconScdlProcessName.isDisplayed();
		   }
		   
		 //Search link for Schedule New Process
		   
		   public void clickScheduleNewProcessSearchLink() throws InterruptedException{	

			   lnkSrchScdlProcessName.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtName));
			   report.log(LogStatus.PASS, "Clicked on Account Search link");
		   }
		   
		   public boolean isScheduleNewProcessSearchLinkDisplayed(){
			   return lnkSrchScdlProcessName.isDisplayed();
		   }  
		   
		 //Value for Name
		   
		   public void enterName(String value) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   txtName.clear();
			   txtName.click();
			   txtName.sendKeys(value);
			   txtName.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isNameDisplayed(){
			   return txtName.isDisplayed();
			   } 
		   
		// Select From Statement End Date
		   public void selectSearchAndSelectName(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:selectOneChoice2_afrLovInternalTableId::db']//div//td[1]"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
					System.out.println("data is :"+date);
				   if (date.equalsIgnoreCase(fromDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Statement End Date is "+fromDate);
					   break;
					   
				   }
				  } 
				   
			  }
		   
		   
		   public void selectBusUnit(String strBusUnit)
		   {
			   selBusUnit.click();   
			   Select objSelect = new Select(selBusUnit);
			   objSelect.selectByVisibleText(strBusUnit);
			   SeleniumUtils.delay(3000);
		   }
		   
		   
		// Search button in Account
		   public void clickNameSearchButton(){	
			   		btnSearchName.click();
					SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on Search and Select: Name Search button");
		   }
		   
		   public boolean isNameSearchButtonDisplayed(){
			   return btnSearchName.isDisplayed();
		   } 
		   
		   // Select From Statement End Date
		   
		   public void selectEvent(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			 // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'pt1:selectOneChoice2::lovDialogId::contentContainer')]//span[contains(text(), '"+eventName+"')]")));
			 // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'lovDialogId::contentContainer')]//span[contains(text(), '"+eventName+"')]")));
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'lovDialogId::contentContainer')]//span[.//text()= '"+eventName+"']")));
			   eventLink.click(); 
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
// Select From Statement End Date
		   
		   public void selectSupplierName(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			  WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '"+eventName+"')]")));
			   eventLink.click(); 
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		//  Ok Button for Name
		   
		   public void clickNameOkButton(){	
			   btnOkName.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Name Ok Button");
			   
		   }
		   
		   public boolean isNameOkButtonDisplayed(){
			   return btnOkName.isDisplayed();
		   } 
		   
		   //  Ok Button for  Schedule New Process
		   
		   public void clickScheduleNewProcessOkButton(){	
			   btnOkScdlProcessName.click();
			   wdwait.until(ExpectedConditions.visibilityOf(ttlProcessDetails));
			   //wdwait.until(ExpectedConditions.visibilityOf(selectImportProcess));
			   report.log(LogStatus.PASS, "Clicked on Schedule New Process Ok Button");
			   
		   }
		   
		   public boolean isScheduleNewProcessOkButtonDisplayed(){
			   return btnOkScdlProcessName.isDisplayed();
		   }  
		   
		   // select Import Process
		   
		   public void SelectImportProcess(String strImportProcess) throws InterruptedException{
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   selectImportProcess.click();
			   selectImportProcess.sendKeys(strImportProcess);
			   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
			   selectImportProcess.sendKeys(Keys.ENTER);
			    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectDataFile));
			    element.click();
			   	//SeleniumUtils.delay(3000);
			    report.log(LogStatus.PASS, "Selected Import Process  is: "+strImportProcess);
			   }
			   
			   public boolean isSelectImportProcessDisplayed(){
				   return selectImportProcess.isDisplayed();
				   } 
			   
			// select Import Process
			   
			   public void SelectDataFile(String strDataFile) throws InterruptedException{
				   selectDataFile.click();
				   selectDataFile.sendKeys(strDataFile);
				   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
				   	selectDataFile.sendKeys(Keys.ENTER);
				   	txtSubmissionNotes.click();
				    report.log(LogStatus.PASS, "Selected Data File  is: "+strDataFile);
				   }
				   
				   public boolean isSelectDataFileDisplayed(){
					   return selectDataFile.isDisplayed();
					   } 
				   
				 //txtSubmissionNotes
				   public void clickSubmissionNotes() {
					   SeleniumUtils.delay(5000);
					   txtSubmissionNotes.click();
					   SeleniumUtils.delay(2000);
					   }
				   
			   // submit button
				   
				   public void clickSubmitButton(){	
					   SeleniumUtils.delay(5000);
					   btnSubmit.click();
					   //SeleniumUtils.delay(8000);
					   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
					   report.log(LogStatus.PASS, "Clicked on Submit Button");
					   this.getScreenDetails("Confirmation Pop-up");
				   }
				   
				   public boolean isSubmitBtnDisplayed(){
					   return btnSubmit.isDisplayed();
				   	
				   }
				   
				   // Conf Massege 
				   public String ConfirmationProcessId() {
					   SeleniumUtils.delay(4000);
					   String ConfMessage=lblConfirmation.getText();
					   //System.out.println("String is "+ConfMessage);
					   System.out.println(ConfMessage.substring(8,14));
					   return ConfMessage.substring(8,14);
				   }
				   
				
		   // Conf Ok Button
				   public boolean isConfOkButtonDisplayed(){
					   return btnConfOk.isDisplayed();  	
				   }  
				   
				   public void clickConfOkButton(){	
					   String ConfMessage=lblConfirmation.getText();
					   btnConfOk.click();
					   report.log(LogStatus.PASS, ""+ConfMessage+" Clicked on Confirmation Ok Button");
					   SeleniumUtils.delay(3000);
				   }
				   //Select Bussiness Unit
				   
				   public void SelectBussinessUnit(String strBankAccount) throws InterruptedException{
					   this.getScreenDetails();
					   selectBussinessUnit.clear();
					   selectBussinessUnit.click();
					   selectBussinessUnit.sendKeys(strBankAccount);
					  // txtMajor.sendKeys(Keys.ARROW_DOWN);
					   selectBussinessUnit.sendKeys(Keys.ENTER);
					  // wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
				    	SeleniumUtils.delay(3000);
				   }
				   
				   public boolean isBussinessUnitDisplayed(){
					   return selectBussinessUnit.isDisplayed();
					   } 
				   
				// Click on icon Supplier Name   
		  		   
				   public void clickSearchSupplierNameIcon(){	
					   iconSearchSupplierName.click();
					   wdwait.until(ExpectedConditions.visibilityOf(lnkSearchSupplierName));
					   report.log(LogStatus.PASS, "Clicked on Supplier Search icon");  
					   
				   }
				   
				   public boolean isSearchSupplierNameIconDisplayed(){
					   return iconSearchSupplierName.isDisplayed();
				   }
				   
				   // Click on icon Supplier Or Party Name   
		  		   
				   public void clickSearchSupplierOrPartyIcon(){	
					   iconSearchSupplierOrParty.click();
					   wdwait.until(ExpectedConditions.visibilityOf(lnkSearchSupplierName));
					   report.log(LogStatus.PASS, "Clicked on Supplier Or Party Search icon");  
					   
				   }
				   
				   public boolean isSearchSupplierOrPartyIconDisplayed(){
					   return iconSearchSupplierOrParty.isDisplayed();
				   }
				   
				 //Search link for Schedule New Process
				   
				   public void clickSupplierNameSearchLink() throws InterruptedException{	

					   lnkSearchSupplierName.click();
					   wdwait.until(ExpectedConditions.visibilityOf(txtSupplierName));
					   report.log(LogStatus.PASS, "Clicked on Supplier Search link");
					   this.getScreenDetails();
				   }
				   
				   public boolean isSupplierNameSearchLinkDisplayed(){
					   return lnkSearchSupplierName.isDisplayed();
				   }  
				   
				 //Value for SupplierName
				   
				   public void enterSupplierName(String value) throws InterruptedException{
					   SeleniumUtils.delay(3000);
					   txtSupplierName.clear();
					   txtSupplierName.click();
					   txtSupplierName.sendKeys(value);
					   txtSupplierName.sendKeys(Keys.ENTER);
					   //txtSupplierName.click();
					  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
				   }
				   
				   public boolean isSupplierNameDisplayed(){
					   return txtSupplierName.isDisplayed();
					   } 
				   
				// Search button in Supplier
				   public void clickSupplierSearchButton(){	
					   		btnSearchSuplName.click();
							SeleniumUtils.delay(3000);
					   report.log(LogStatus.PASS, "Clicked on Search and Select: Name Search");
				   }
				   
				   public boolean isSupplierSearchButtonDisplayed(){
					   return btnSearchSuplName.isDisplayed();
				   } 
				   
				//  Ok Button for Name
				   
				   public void clickSupplierOkButton(){	
					   btnOkSuplName.click();
					   SeleniumUtils.delay(5000);
					   report.log(LogStatus.PASS, "Clicked on Name Ok Button");
					   this.getScreenDetails(); 
					   
				   }
				   
				   public boolean isSupplierOkButtonDisplayed(){
					   return btnOkSuplName.isDisplayed();
				   } 
				   
				// click on From Entered Date button
				      
				   public boolean isFromEnteredDateBtnDisplayed(){
					   return btnFromEnteredDt.isDisplayed();
				    	
				    }
				    public void clickFromEnteredDateButton(){	    	
				    	btnFromEnteredDt.click();
				    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on From Entered Date Button");
				    }
				   
				   // Select From Entered Month from Calander
				    public void selectFromEnteredDtMonth(String fromMonth){
				    	Select objSelect = new Select(selectFromEnteredMonth);
				    	objSelect.selectByVisibleText(fromMonth);
				    	 wdwait.until(ExpectedConditions.visibilityOf(tbleFromEnteredDt));
				    	//SeleniumUtils.delay(5000);
				    	report.log(LogStatus.PASS, "Selected From Entered Date Month  is: "+fromMonth);
				    } 
				   
				   public boolean isFromEnteredDtMonthDisplayed(){
					   return selectFromEnteredMonth.isDisplayed();
					   
				   }   
			   
				// Select From Statement End Date
				   public void selectFromEnteredDate(String fromDate)
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_FromEnteredDate::pop::cd::cg')]//td"));  
						for (WebElement cell:dates)
						  {
							String date=cell.getText();
						   if (date.equalsIgnoreCase(fromDate))
						   {
						     cell.click();
							   SeleniumUtils.delay(2000);
							   report.log(LogStatus.PASS, "Selected From Entered Date is "+fromDate);
							   break;
							   
						   }
						  } 
						   
					  }
				   
				// click on To Entered Date button
				      
				   public boolean isToEnteredDateBtnDisplayed(){
					   return btnToEnteredDt.isDisplayed();
				    	
				    }
				    public void clickToEnteredDateButton(){	    	
				    	btnToEnteredDt.click();
				    	 wdwait.until(ExpectedConditions.visibilityOf(selectToEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on To Entered Date Button");
				    }
				   
				   // Select To Entered Month from Calander
				    public void selectToEnteredDtMonth(String toMonth){
				    	Select objSelect = new Select(selectToEnteredMonth);
				    	objSelect.selectByVisibleText(toMonth);
				    	 wdwait.until(ExpectedConditions.visibilityOf(tbleToEnteredDt));
				    	//SeleniumUtils.delay(5000);
				    	report.log(LogStatus.PASS, "Selected To Entered Date Month  is: "+toMonth);
				    } 
				   
				   public boolean isToEnteredDtMonthDisplayed(){
					   return selectToEnteredMonth.isDisplayed();
					   
				   }   
			   
				// Select From Statement End Date
				   public void selectToEnteredDate(String toDate)
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_ToEnteredDate::pop::cd::cg')]//td"));  
						for (WebElement cell:dates)
						  {
							String date=cell.getText();
						   if (date.equalsIgnoreCase(toDate))
						   {
						     cell.click();
							   SeleniumUtils.delay(2000);
							   report.log(LogStatus.PASS, "Selected To Entered End Date is "+toDate);
							   break;
							   
						   }
						  } 
						   
					  }  
				   
				   
				   //Select Accounting Period
				   
				   public void SelectAccountingPeriod(String strAccPeriod) throws InterruptedException{
					   this.getScreenDetails();
					   selectAccPeriod.clear();
					   selectAccPeriod.click();
					   selectAccPeriod.sendKeys(strAccPeriod);
					  // txtMajor.sendKeys(Keys.ARROW_DOWN);
					   //selectAccPeriod.sendKeys(Keys.ENTER);
					  // wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
				    	SeleniumUtils.delay(3000);
				   }
				   
				   public boolean isAccountingPeriodDisplayed(){
					   return selectAccPeriod.isDisplayed();
					   }    
				   
				// Title displayed
				   public boolean isProcessDetailsTitleDisplayed(){
					   return ttlProcessDetails.isDisplayed();
					   } 
				   
				   //btnRefresh
				   public boolean isRefreshButtonDisplayed(){
					   return btnRefresh.isDisplayed();
					   } 
				   
				   public void clickRefreshButton(){
					   SeleniumUtils.delay(5000);
					   btnRefresh.click();
					   SeleniumUtils.delay(2000);
					   btnRefresh.click();
					   SeleniumUtils.delay(5000);
					   btnRefresh.click();
					   SeleniumUtils.delay(3000);
					   btnRefresh.click();
					   SeleniumUtils.delay(3000);
					   btnRefresh.click();
				    	// wdwait.until(ExpectedConditions.visibilityOf(selectToEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on Refresh Button");
				    }
				   
				   
				   public void selectScheduleNewProcessCell(String ProcessID)
					{
				    	List<WebElement> ScheduleProcessRows = driver.findElements(By.xpath("//table[@class='x1jf x1k3']//div//td[1]"));
				    	System.out.println("Statement Rows are"+ScheduleProcessRows.size());
						int r;
						int t=1;
						for (r=1;r<=ScheduleProcessRows.size();r++)
						  {
							// String strProcessId = driver.findElement(By.xpath("//table[@class='x1jf x1k3']//tr["+r+"]//div//td[1]")).getText();
							 String strProcessId = driver.findElement(By.xpath("//*[contains(@id,':0:_FOTsr1:0:pt1:selectOneChoice2_afrLovInternalTableId::db')]/table/tbody/tr["+r+"]/td[1]")).getText();
							System.out.println("Data is"+strProcessId);
							if(strProcessId.equalsIgnoreCase(ProcessID)) {
								int k=r-t;
							
								SeleniumUtils.delay(5000);
								WebElement ProcessName = driver.findElement(By.xpath("//table[@class='x1jf x1k3']//tr["+r+"]//div//td[3]"));
									
								ProcessName.click();
								SeleniumUtils.delay(5000);
								report.log(LogStatus.PASS, "Clicked on Payables Invoice Register Cell");
								 //wdwait.until(ExpectedConditions.visibilityOf(lnkDefaultDocument));

								break;
							}
 
						  } 
						   
					  }
				   
				   public void selectProcessName(String strProcessName)
					{	
						rowcount=(List<WebElement>) tableProcessNames.findElements(By.tagName("tr"));
						int rownum=rowcount.size();
						for (int row=1;row<rownum;row++)
						{	
							WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':0:_FOTsr1:0:pt1:selectOneChoice2_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
							
							String actualText=cellNametext.getText();
							System.out.println("actual text is "+actualText);
							
							if(actualText.equalsIgnoreCase(strProcessName))
							{
								report.log(LogStatus.INFO, "Selected Process Name is "+strProcessName);
								cellNametext.click();
								SeleniumUtils.delay(5000);
								this.getScreenDetails("Selection of Process");
								break;
							}
						}
					}		
				   
				
				   
				   public void clickDefaultDocumnetLink()
		           {
					   
					   SeleniumUtils.delay(10000);
		              //WebElement frame=driver.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:r61:0:if1::f']"));
					   WebElement frame=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r61:0:if1']"));
		              driver.switchTo().frame(frame);
		              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lnkDafaultDocument);
		              this.getScreenDetails("after switching to frame");
		              SeleniumUtils.delay(5000);
		              lnkDafaultDocument.click();
		              SeleniumUtils.delay(5000);
		              this.getScreenDetails("after clicking DafaultDocument link");
		           }
				    
				    
				    public void clickDownloadButton()
				    {
				    	  SeleniumUtils.delay(5000);
			              //WebElement frame=driver.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:r61:0:if1::f']"));
				    	  WebElement frame=driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_tools_scheduled_processes_fuse_plus:0:_FOTsr1:0:pt1:r61:0:if1']"));
			              driver.switchTo().frame(frame);
			             // WebElement element = driver.findElement(By.xpath(".//*[@id='pt1:USma:0:MAnt1:0:pt1:panelgrp378']"));
			              WebElement element = driver.findElement(By.xpath(".//*[@id='download']"));
			              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			              this.getScreenDetails("after switching to frame");
				    	SeleniumUtils.delay(5000);
				    	btnDownload.click();
				    	SeleniumUtils.delay(5000);
				    }
				   //lnkDefaultDocument
				   public boolean isDefaultDocumentDisplayed(){
					   return lnkDefaultDocument.isDisplayed();
					   } 
				   
				  /* public void clickDefaultDocumentLink(){	
					   SeleniumUtils.delay(10000);
					   WebElement frame= driver.findElement(By.xpath("//*[@id='pt1:USma:0:MAnt1:0:pt1:r61:0:if1::f']"));
				    	driver.switchTo().frame(frame);
					   lnkDefaultDocument.click();
					   SeleniumUtils.delay(2000);
				    	// wdwait.until(ExpectedConditions.visibilityOf(selectToEnteredMonth));
				    	report.log(LogStatus.PASS, "Clicked on Default Document link");
				    }*/
				   
				   
				   public void ScheduleNewProcessIDStatus(String ProcessID)
					{
				    	//List<WebElement> ScheduleProcessRows = driver.findElements(By.xpath("//table[@class='x1jf x1k3']//div//td[2]"));
				    	List<WebElement> ScheduleProcessRows = driver.findElements(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//div//td[2]"));
				    	
				    	System.out.println("Statement Rows are"+ScheduleProcessRows.size());
						int r;
						int t=1;
						for (r=1;r<=ScheduleProcessRows.size();r++)
						  {
							 String strProcessId = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[2]")).getText();
							System.out.println("Data is"+strProcessId);
							if(strProcessId.equalsIgnoreCase(ProcessID)) {
								String Status = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[3]")).getText();
								
						              if((Status.equalsIgnoreCase("Succeeded"))) {
						            	  report.log(LogStatus.PASS, "The Status of submitted process ID "+ProcessID+" is Succeeded");
						              }else {
						            	  report.log(LogStatus.FAIL, "The Status of submitted process ID "+ProcessID+" status is "+Status+"");
						              }
								
								break;
							}

						  } 
						   
					  }
				   
		//Payment File Search Icon
				   
				   public void clickPaymentFileSearchIcon(){
					   SeleniumUtils.delay(2000);
					   iconPaymentFileSearch.click();
					   wdwait.until(ExpectedConditions.visibilityOf(lnkPaymentFileSearch));
					   report.log(LogStatus.PASS, "Clicked on Payment File Search icon");  
					   
				   }
				   
				   public boolean isPaymentFileSearchIconDisplayed(){
					   return iconPaymentFileSearch.isDisplayed();
				   }
				   
				 //Search link for Payment File
				   
				   public void clickPaymentFileSearchLink() throws InterruptedException{	

					   lnkPaymentFileSearch.click();
					   wdwait.until(ExpectedConditions.visibilityOf(txtReference));
					   report.log(LogStatus.PASS, "Clicked on Payment File link");
				   }
				   
				   public boolean isPaymentFileSearchLinkDisplayed(){
					   return lnkPaymentFileSearch.isDisplayed();
				   }  
				   
				 //Value for Reference
				   
				   public void enterReference(String value) throws InterruptedException{
					   SeleniumUtils.delay(5000);
					   txtReference.clear();
					   txtReference.click();
					   txtReference.sendKeys(value);
					   txtReference.click();
					  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
				   }
				   
				   public boolean isReferenceDisplayed(){
					   return txtReference.isDisplayed();
					   } 
				   
				   //Search Button for Reference
				   
				   public void clickReferenceSearchButton() throws InterruptedException{	
					   btnReferenceSearch.click();					  
					   report.log(LogStatus.PASS, "Clicked on Payment File link");
				   }
				   
				   public boolean isReferenceSearchButtonDisplayed(){
					   return btnReferenceSearch.isDisplayed();
				   } 
				   
				   //Ok Button for Reference
				   
				   public void clickReferenceOkButton() throws InterruptedException{	
					   btnReferenceOk.click();					  
					   report.log(LogStatus.PASS, "Clicked on Reference Ok button");
					   SeleniumUtils.delay(3000);
				   }
				   
				   public boolean isReferenceOkButtonDisplayed(){
					   return btnReferenceOk.isDisplayed();
				   } 
				   
				// Select Format list
				    public void selectFormat(String strFormat){
				    	SeleniumUtils.delay(3000);
				    	Select objSelect = new Select(selectFormat);
				    	objSelect.selectByVisibleText(strFormat);
				    	SeleniumUtils.delay(3000);
				    }   
				    
				    
    /////////////
				    public void selectPaymentFileRegisterCell_Succeeded(String ProcessID)
					{
				    	List<WebElement> ScheduleProcessRows = driver.findElements(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//div//td[2]"));
				    	System.out.println("Statement Rows are"+ScheduleProcessRows.size());
						int r;
						int t=1;
						for (r=1;r<=ScheduleProcessRows.size();r++)
						  {
							 String strProcessId = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[2]")).getText();
							System.out.println("Data is"+strProcessId);
							if(strProcessId.equalsIgnoreCase(ProcessID)) {
								int k=r-t;
								//String Status = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[3]")).getText();
								for(int j=1;j<=10;j++) {
									String Status = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[3]")).getText();
									if(Status.equalsIgnoreCase("Succeeded")) {
										
										break;
									}else {
										btnRefresh.click();
									}
								}
									
								SeleniumUtils.delay(5000);
								WebElement ProcessName = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[1]"));
								//WebElement ProcessName = driver.findElement(By.xpath(" .//*[@id='pt1:USma:0:MAnt1:0:pt1:panel:result:"+k+":pgl1']"));
								ProcessName.click();
								SeleniumUtils.delay(5000);
								report.log(LogStatus.PASS, "Clicked on Payables Invoice Register Cell");
								 //wdwait.until(ExpectedConditions.visibilityOf(lnkDefaultDocument));

								break;
							}
 
						  } 
						   
					  }			    
				    
				    
    ////////
				    
				    
				    public void selectPaymentFileRegisterCell(String ProcessID)
					{
				    	List<WebElement> ScheduleProcessRows = driver.findElements(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//div//td[2]"));
				    	System.out.println("Statement Rows are"+ScheduleProcessRows.size());
						int r;
						int t=1;
						for (r=1;r<=ScheduleProcessRows.size();r++)
						  {
							 String strProcessId = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[2]")).getText();
							System.out.println("Data is"+strProcessId);
							if(strProcessId.equalsIgnoreCase(ProcessID)) {
								int k=r-t;
								String Status = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[3]")).getText();
								int j=1;
								do {
									if(Status.equalsIgnoreCase("Succeeded")) {
										
										break;
									}
									btnRefresh.click();
									j++;
								}while(j<=10);
									
								SeleniumUtils.delay(5000);
								WebElement ProcessName = driver.findElement(By.xpath("//*[contains(@id,'pt1:panel:result::db')]/table//tr["+r+"]//div//td[1]"));
								//WebElement ProcessName = driver.findElement(By.xpath(" .//*[@id='pt1:USma:0:MAnt1:0:pt1:panel:result:"+k+":pgl1']"));
								ProcessName.click();
								SeleniumUtils.delay(5000);
								report.log(LogStatus.PASS, "Clicked on Payables Invoice Register Cell");
								 //wdwait.until(ExpectedConditions.visibilityOf(lnkDefaultDocument));

								break;
							}
 
						  } 
						   
					  }
				    
				//  1 More Link 
					   
					   public void clickMoreLink(){	
						   SeleniumUtils.delay(3000);
						   lnkMore.click();
						   wdwait.until(ExpectedConditions.visibilityOf(lnkPDFProcessID));
						   report.log(LogStatus.PASS, "Clicked on 1 More Link");
						   
					   }
					   
					   public boolean isMoreLinkDisplayed(){
						   return lnkMore.isDisplayed();
					   }  
					   
					   //  Process Id PDF link
					   
					   public void clickPDFProcessIDLink(){	
						   lnkPDFProcessID.click();
						   report.log(LogStatus.PASS, "Clicked on ProcessID PDF Link");
						   
					   }
					   
					   public boolean isPDFProcessIDLinkDisplayed(){
						   return lnkPDFProcessID.isDisplayed();
					   }  
					   
					 //Select Accounting Period Basic Options Process Details pop-up
					   
					   public void SelectAccountingPeriodList_BasicOptions(String strAccPeriod) throws InterruptedException{
						   this.getScreenDetails();
						   inputAccPeriod_BscOptions.clear();
						   inputAccPeriod_BscOptions.click();
						   inputAccPeriod_BscOptions.sendKeys(strAccPeriod);
						   inputAccPeriod_BscOptions.click();
						  // txtMajor.sendKeys(Keys.ARROW_DOWN);
						   //selectAccPeriod.sendKeys(Keys.ENTER);
						  // wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
					    	SeleniumUtils.delay(3000);
					   }
					   
					   public boolean isAccountingPeriod__BasicOptionsDisplayed(){
						   return inputAccPeriod_BscOptions.isDisplayed();
						   }
					   
		   //Select AmountType Basic Options Process Details pop-up
		   
		   public void SelectAmountTypeList_BasicOptions(String strAmountType){
			   Select objSelect=new Select(selectAmountType);
			   objSelect.selectByVisibleText(strAmountType);
		   }
		   
		   public boolean isAmountType__BasicOptionsDisplayed(){
			   return selectAmountType.isDisplayed();
			   } 
		   
		   // Click on Balancing Segment button
		   
		   public void clickBalancingSegmentButton() {
			   btnBalancingSegment.click();
			   wdwait.until(ExpectedConditions.visibilityOf(ttlBalancingSegment));
			   report.log(LogStatus.PASS, "Clicked on Balancing Segment Button");
			   this.getScreenDetails("Balancing Segment Pop-Up");
		   }
		   
		   public boolean isBalancingSegmentBtnDisplayed(){
			   return btnBalancingSegment.isDisplayed();
			   }
		   
		   //Add Fields list
		   
		   public void selectAddFieldsList(String strAddField){
			   selectAddFields.click();
			   wdwait.until(ExpectedConditions.visibilityOf(selectCompany));
			   selectCompany.click();
		   }
		   
		   public boolean isAddFieldsListDisplayed(){
			   return selectAddFields.isDisplayed();
			   } 
		   
		// Search Company 
		   
		   public void clickCompanySearchIcon() throws InterruptedException{
			   
			   SeleniumUtils.delay(3000);
				/*JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", srchCompany);*/
			   icnCompanySearch.click();
		    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'value00::dropdownPopup::popupsearch')]")));
		    	report.log(LogStatus.PASS, "Clicked on Company Search Icon");
			   
		   }
		   
		   public boolean isCompanySearchIconDisplayed(){
			  // return SeleniumUtils.isDisplayed(driver, srchCompany, context.getReactTimeout());
			   return icnCompanySearch.isDisplayed();
		   } 
		   
		 //Select Event (select given text from dropdown)
		   public void selectCompanyList(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		   // Company  Ok button
		   
		   public void clickCompanyOkButton() throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   btnCompanyOk.click();
		     report.log(LogStatus.PASS, "Clicked on Company Ok Button");
			   
		   }
		   
		   public boolean isCompanyOkBtnDisplayed(){
			  // return SeleniumUtils.isDisplayed(driver, srchCompany, context.getReactTimeout());
			   return btnCompanyOk.isDisplayed();
		   } 
		   
		   public void selectTrialBalanceReportCell(String ProcessID)
			{
			   System.out.println("ProcessID is"+ProcessID);
		    	List<WebElement> ScheduleProcessRows = driver.findElements(By.xpath("//*[contains(@id,'_FOTsr1:0:pt1:panel:result::db')]//div//td[1]"));
		    	System.out.println("Statement Rows are"+ScheduleProcessRows.size());
				int r;
				int t=1;
				for (r=1;r<=ScheduleProcessRows.size();r++)
				  {
					
					 String strProcessId = driver.findElement(By.xpath("//*[contains(@id,'_FOTsr1:0:pt1:panel:result::db')]/table/tbody/tr["+r+"]//div//td[2]")).getText();
					System.out.println("Data is"+strProcessId);
					if(strProcessId.equalsIgnoreCase(ProcessID)) {
					//if(strProcessId==ProcessID) {
						System.out.println("ProcessID is"+ProcessID);
						int k=r-t;
					
						SeleniumUtils.delay(5000);
						WebElement ProcessName = driver.findElement(By.xpath("//*[contains(@id,'_FOTsr1:0:pt1:panel:result::db')]//tr["+r+"]//div//td[1]"));
						String strProcessName=driver.findElement(By.xpath("//*[contains(@id,'_FOTsr1:0:pt1:panel:result::db')]//tr["+r+"]//div//td[1]")).getText();
						System.out.println("Process Name is"+strProcessName);
						ProcessName.click();
						SeleniumUtils.delay(5000);
						//report.log(LogStatus.PASS, "Clicked on Trial Balance Report Cell");
						report.log(LogStatus.PASS, "Clicked on "+strProcessName+" Cell");
						 //wdwait.until(ExpectedConditions.visibilityOf(lnkDefaultDocument));

						break;
					}

				  } 
				   
			  }
		   
		   // Include Invoice Detail list
		   
		   public void selectIncludeInvoiceDetailList(String strIncludeInvoiceDetailList){
			  Select objSelect=new Select(selectIncludeInvoiceDetail);
			  objSelect.selectByVisibleText(strIncludeInvoiceDetailList);
			   
		   }
		   
		   public boolean isIncludeInvoiceDetailListDisplayed(){
			   return selectIncludeInvoiceDetail.isDisplayed();
		   }
		   
// IncludeSupplierSiteDetail
		   
		   public void selectIncludeSupplierSiteDetailList(String strIncludeSupplierSiteDetail){
			  Select objSelect=new Select(selectIncludeSupplierSiteDetail);
			  objSelect.selectByVisibleText(strIncludeSupplierSiteDetail);
			   
		   }
		   
		   public boolean isIncludeSupplierSiteDetailListDisplayed(){
			   return selectIncludeSupplierSiteDetail.isDisplayed();
		   } 
		   
		   // Aging Period List
		   
		   public void selectAgingPeriodList(String strAgingPeriodList){
			  Select objSelect=new Select(selectAgingPeriod);
			  objSelect.selectByVisibleText(strAgingPeriodList);
			   
		   }
		   
		   public boolean isAgingPeriodListDisplayed(){
			   return selectIncludeSupplierSiteDetail.isDisplayed();
		   } 
				   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Scheduled Processes page is Loaded Successfully");
	    	 if(btnScheduleNewProcess.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Scheduled Processes Page</span></a>");
		   	return new Item(xyz);
	   }
}
