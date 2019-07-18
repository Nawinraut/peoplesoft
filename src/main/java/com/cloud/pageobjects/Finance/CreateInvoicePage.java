package com.cloud.pageobjects.Finance;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class CreateInvoicePage extends BasePageObject{
	private static final boolean True = false;

	public WebDriver driver;
	
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic2::content')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic2::content')]")
	    private WebElement selectBusinessUnit;
	
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::lovIconId')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'0:MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::lovIconId')]")
	    private WebElement iconSrchSupplier;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
	    private WebElement txtSupplier;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Id:value10::content')]")
	    private WebElement txtSupplierNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::_afrLovInternalQueryId::search')]")
	    private WebElement btnSupplierSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:r2:0:ic3::lovDialogId::ok')]")
	    private WebElement btnSupplierOk;
	
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:i2::content')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':0:MAnt2:1:pm1:r1:0:ap1:r2:0:i2::content')]")
	    private WebElement txtNumber;
	
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:i3::content')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'0:MAnt2:1:pm1:r1:0:ap1:r2:0:i3::content')]")
	    private WebElement txtAmount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:sh2::_afrDscl')]")
	    private WebElement iconLinesExpand;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:create::icon')]")
	    private WebElement btnAddRow;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'i1::content')]")
	    private WebElement txtInvoiceGroup;
	 
	 @FindBy(how=How.XPATH, using = "//div[contains(@id,'ap1:at2:_ATp:ta2::db')]//tr[2]/td[4]")
	    private WebElement tabAmmount;
	 
	
	 
	 //@FindBy(how=How.XPATH, using = "//select[contains(@id,'so1::content')]")
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'0:ap1:r2:0:so1::content')]")
	    private WebElement selectType;
	 
	 //@FindBy(how=How.XPATH, using = "//input[contains(@id,'so3::content')]")
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'0:ap1:r2:0:so3::content')]")
	    private WebElement selectPaymentTerms;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'so3::content')]")
	    private WebElement selectAction;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'ap1:cg1::icon')]")
	    private WebElement btnGo;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'msgDlg::cancel')]")
	    private WebElement btnWarningOk;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value00::content')]")
	    private WebElement txtInvoice;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value11::content')]")
	    private WebElement txtDate;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'q1::search')]")
	    private WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:cb3')]")
	    private WebElement btnApply;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:cb4')]")
	    private WebElement btnOk;
	 
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'0:sb1::content')]")
	 @FindBy(how=How.XPATH, using = "//input[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:r13:1:at1:_ATp:ta1:0:sb1::content']")
	    private WebElement chkBoxCorrect;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ta1:0:i3::content')]")
	    private WebElement txtInvoiceAmount;
	 
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,'payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:a1:clLAdds::icon')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:r2:0:a1:clLAdds::icon')]")
	    private WebElement iconAttachments;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'popDatatypeCodeChoiceListIDNew::content')]")
	    private WebElement selectFile;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'socPopCategory::content')]")
	    private WebElement selectCatagory;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ifPopup::content')]")
	    private WebElement btnBrowse;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'popTitleInputText::content')]")
	    private WebElement txtTitle;
	
	 @FindBy(how=How.XPATH, using = "//textarea[contains(@id,'itPopFileText::content')]")
	    private WebElement typeTextarea;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'atapnru::content')]")
	    private WebElement typeURLTextarea;
	 
	 
	 //@FindBy(how=How.XPATH, using = "//*[contains(@id,'invoices:0:MAnt2:1:pm1:r1:0:ap1:r2:0:a1:dc_cb1')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:r2:0:a1:dc_cb1')]")
	    private WebElement btnAttachmentsOk;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATp:ta2:0:i26::content')]")
	    private WebElement txtAmountcell;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'0:kf1CS::content')]")
	    private WebElement txtDistCombination;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:0:ap1:at2:_ATp:ta2:0:kf1KBIMG::icon')]")
	    private WebElement btnDistCombination;
	
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
	   
	   @FindBy(how=How.XPATH, using = ".//*[contains(@id,'value60::dropdownPopup::popupsearch')]")
	   private WebElement lnkAccountSearch;
	   
	   @FindBy(how=How.XPATH, using = ".//input[contains(@id,'QueryId:value00::content')]")
	   private WebElement txtAccValue;
	   
	   @FindBy(how=How.XPATH, using = ".//button[contains(@id,'QueryId::search')]")
	   private WebElement btnAccSearch;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[1]|//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[2]")
	   private WebElement tableAccSearch; 
	   
	   @FindBy(how=How.XPATH, using = ".//button[contains(@id,'lovDialogId::ok')]")
	   private WebElement btnAccOk;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value70::lovIconId')]")
	   private WebElement srchIntercompany;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value80::lovIconId')]")
	   private WebElement srchFundSource;
	   
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'query:value90::lovIconId')]")
	   private WebElement srchFuture1;
	   
	 // Allocate Menu
	   @FindBy(how=How.XPATH, using = "//a[contains(@id,'ap1:at2:_ATp:ctb4::popEl')]")
	   private WebElement menuAllocate;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:cm19')]")
	   private WebElement lstAllLines_Allocate;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:cm20')]")
	   private WebElement lstSpecificLines_Allocate;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:d19::ok')]")
	   private WebElement btnAllLinesConfOk;
	   
	 // Allocate Freight Pop Up
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:d18::_ttxt')]")
	   private WebElement lblAllocateFreight;
	   
	   @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:at2:cb31')]")
	   private WebElement btnSaveAndClose_AllocateFreight;
	 
	// Ok button in Account pop up(1)
	   
	   @FindBy(how=How.XPATH, using = "//button[contains(@id,'ATp:ta2:0:kf1SEl')]")
	   private WebElement btnAccOkPop;
	 
	// invoice Save button 
	 //  @FindBy(how=How.XPATH, using = "//*[contains(@id,'invoices:0:MAnt2:1:pm1:r1:0:ap1:ct5')]")
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:ct5')]")
	   private WebElement btnSave;
	   
	// invoice Save button 
	   //@FindBy(how=How.XPATH, using = "//*[contains(@id,'payables_invoices:0:MAnt2:1:pm1:sm2::disAcr')]")
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:sm2::disAcr')]")
	   private WebElement btnInvoiceSummary;
	   
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:cl1')]")
	   private WebElement btnInvoiceHeaderSummary;
	   
	// invoice Save button 
	   @FindBy(how=How.XPATH, using = ".//*[@id='_FOd1::msgDlg::cancel']")
	   private WebElement btnInformationOkpop;  
	  
	 // Save and Close Button
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb14')]")
	   private WebElement btnSaveAndClose;
	 
	// menu invoice Action
	   //@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:me1']")
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:me1')]/div/table/tbody/tr/td[3]/div")
	   private WebElement menuInvoiceActions;
	   
	   //@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm1']")
	   //@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm1']|//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm1']//td[2]")
	   @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm1']|//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm1']//td[2]|//*[@id='_FOpt1:_FOr1:1:_FONSr2:0:MAnt2:1:pm1:r1:0:ap1:cm1']/td[2]")
	   private WebElement menuValidate;  
	   
	   //@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:0:ap1:cm16']")
	   @FindBy(how=How.XPATH, using = " //*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:cm16')]")
	   private WebElement menuPostLedger;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cmi2')]")
	   private WebElement menuPayInFull;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:r9:1:paymentDocumentNameId::content')]")
	    private WebElement selectPaymentDocument;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:r9:1:it1::content')]")
	    private WebElement txtPaymentNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:pifbtn1')]")
	    private WebElement btnSubmit;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:r9:1:paymentProfileNameId::content')]")
	    private WebElement selectPaymentProProfile;

	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'paymentProfileNameId::lovIconId')]")
	    private WebElement srchPaymentProProfileicon;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'Popup::popupsearch')]")
	   private WebElement lnkPaymentProProfileSearch;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'bankAccountNamePIFId::content')]")
	    private WebElement inputBankAcount;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'paymentDocumentNameId::content')]")
	    private WebElement inputPaymentDocument;
	   
	   //@FindBy(how=How.XPATH, using = "//*[contains(@id,'invoices:0:MAnt2:1:pm1:r1:0:ap1:cb43')]")
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:0:ap1:cb43')]")
	   private WebElement btnConfOk;
	   
	   @FindBy(how=How.XPATH, using = " .//*[@id='_FOd1::msgDlg::cancel']")
	   private WebElement btnPayFullConfOk;
	   
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:ta3:0:i49::content')]")
	    private WebElement txtAllocateFreightAmount1;
	  
	   @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:ta3:1:i49::content')]")
	    private WebElement txtAllocateFreightAmount2;
	   
	public WebDriverWait wdwait; 
	
	 public CreateInvoicePage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Create Invoice Page *****************************");
	       this.getScreenDetails();
	    }
	
	 
	//BusinessUnit list
	   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
	   	selectBusinessUnit.click();
	   	//SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
	   	selectBusinessUnit.sendKeys(strBusinessUnit);
	   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
	   	selectBusinessUnit.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(3000);
	    report.log(LogStatus.PASS, "Selected given Bussiness Unit from the list is: "+strBusinessUnit);
	   }
	   
	   public boolean isSelectBusinessUnitDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
		   } 
	   
	   
	   // Search: Supplier Icon
	   
	   public void clickSearchSupplierIcon(){	
		   iconSrchSupplier.click();
		   wdwait.until(ExpectedConditions.visibilityOf(txtSupplier));
		   report.log(LogStatus.PASS, "Clicked on Supplier Search icon");  
		   
	   }
	   
	   public boolean isSearchSupplierIconDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, iconSrchSupplier, context.getReactTimeout());
	   }
	   
	   // Search :
	   
	 //Enter text into Supplier field
	   public void enterSupplier(String strSupplier){
		   txtSupplier.clear();
		   txtSupplier.click();
		   txtSupplier.sendKeys(strSupplier);
		   report.log(LogStatus.PASS, "Entered Supplier is: "+strSupplier);
	   }
	   
	   public boolean isSupplierDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtSupplier, context.getReactTimeout());
		   }
	  // Supplier Number Field
	   
	   public void clickSupplierNumber(){
		   txtSupplierNumber.click();
		   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
	   }
	   
	   
	   
	   
	// Supplier Search Button 
	   public void clickSupplierSearchButton(String eventName){
		   btnSupplierSearch.click();
		  // WebDriverWait wait = new WebDriverWait(driver, 50);
		   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
		   report.log(LogStatus.PASS, "Clicked on Supplier Search Button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isSupplierSearchBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnSupplierSearch, context.getReactTimeout());		 
	   }
	   
	// Supplier Search Ok Button 
	   public void clickSupplierOkButton(){	
		 
		   btnSupplierOk.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Supplier Ok Button");
	   }
	   
	   public boolean isSupplierOkBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver,  btnSupplierOk, context.getReactTimeout());		 
	   }  
	   	   
	 //Enter text into Number field
	   public void enterNumber(String number){
		   SeleniumUtils.delay(5000);
		   txtNumber.clear();
		   txtNumber.click();
		   txtNumber.sendKeys(number);
		   report.log(LogStatus.PASS, "Number is entered successfully: "+number);
	   }
	   
	   public boolean isNumberDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtNumber, context.getReactTimeout());
		   }   
	   
	 //Enter text into Amount field
	   public void enterAmount(String amount){
		   txtAmount.clear();
		   txtAmount.click();
		   txtAmount.sendKeys(amount);
		   txtAmount.sendKeys(Keys.TAB);
		   report.log(LogStatus.PASS, "Amount is entered successfully: "+amount);
		   SeleniumUtils.delay(5000);
	   }
	   
	   public boolean isAmountDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtAmount, context.getReactTimeout());
		   }   
	   
	   
	// Supplier Attachments Button 
	   public void clickAttachmentsButton(){	
		   iconAttachments.click();
		   wdwait.until(ExpectedConditions.visibilityOf(selectFile));
		   report.log(LogStatus.PASS, "Clicked on Attachments Button");
	   }
	   
	   public boolean isAttachmentsBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver,  iconAttachments, context.getReactTimeout());		 
	   }  
	   
	  // Select File  
	   public void selectfileType(String strFile){
		  
	    	//report.log(LogStatus.PASS, "Select File type from SelectFile dropdown");
	    	Select objSelect = new Select(selectFile);
	    	//selectFile.click();
	    	objSelect.selectByVisibleText(strFile);
	    	//objSelect.selectByIndex(strFile);
	    	SeleniumUtils.delay(5000);
	    	report.log(LogStatus.PASS, "Selected File  is: "+strFile);
	    }
	   
	   public boolean isfileTypeDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, selectFile, context.getReactTimeout());
		   return selectFile.isDisplayed();
	   }
	   
	// Select File 
	   public void selectCatagory(String strCatagory){
	    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
	    	Select objSelect = new Select(selectCatagory);
	    	objSelect.selectByVisibleText(strCatagory);
	    	SeleniumUtils.delay(5000);
	    	report.log(LogStatus.PASS, "Selected Catagory  is: "+strCatagory);
	    } 
	   
	   public boolean isCatagoryDisplayed(){
//		   return SeleniumUtils.isDisplayed(driver,selectCatagory, context.getReactTimeout());
		   return selectCatagory.isDisplayed();
	   }
	   
	// Browse button
	   
	   public void clickBrowseWithFile(String filePath){
		   SeleniumUtils.delay(2000);
		   btnBrowse.sendKeys(filePath);
		  
		   report.log(LogStatus.PASS, "Clicked on Browse Button and file attached successfully");
	   }
	   
	   public boolean isBrowseBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnBrowse, context.getReactTimeout());
		   //return btnBrowse.isDisplayed();
	   }
	   
	  // Title field verification  
	   public boolean isFileUploaded(String fileName) throws InterruptedException{
		   SeleniumUtils.delay(15000);
		   if (txtTitle.getAttribute("value").equals(fileName))
			   return true;
		   else
			   return false;	    
	   }
	   
	   // Text File type Text area field
	   
	   
	   public void enterTypeTextArea(String strText){
		   typeTextarea.clear();
		   typeTextarea.click();
		   typeTextarea.sendKeys(strText);
		   report.log(LogStatus.PASS, "Entered Text is: "+strText);
	   }
	   
	   public boolean isTypeTextAreaDisplayed(){
//		   return SeleniumUtils.isDisplayed(driver, typeTextarea, context.getReactTimeout());
		   return typeTextarea.isDisplayed();
		   } 
	   
	   // URL File Type TextArea
	   
	   public void enterURLTextArea(String strURL){
		   typeURLTextarea.clear();
		   typeURLTextarea.click();
		   typeURLTextarea.sendKeys(strURL);
		   report.log(LogStatus.PASS, "Entered Text is: "+strURL);
	   }
	   
	   public boolean isURLTextAreaDisplayed(){
//		   return SeleniumUtils.isDisplayed(driver, typeURLTextarea, context.getReactTimeout());
		   return typeURLTextarea.isDisplayed();
		   } 
	   
	  //Attachments Ok Button	   
	   public void clickAttachmentsOkButton(){
		   this.getScreenDetails("Attachments Pop-up");
		   btnAttachmentsOk.click();
		   SeleniumUtils.delay(5000);
		   //wdwait.until(ExpectedConditions.visibilityOf(txtAmountcell));
		   report.log(LogStatus.PASS, "Clicked on Ok Button");
	   }
	  
	   public boolean isAttachmentsOkBtnDisplayed(){
//		   return SeleniumUtils.isDisplayed(driver, btnAttachmentsOk, context.getReactTimeout());
		   return btnAttachmentsOk.isDisplayed();
	   } 
	   
	   // Enter into Amount Cell
	   
	   public void enterAmountCell(String strCellAmount){
		   txtAmountcell.clear();
		   txtAmountcell.click();
		   txtAmountcell.sendKeys(strCellAmount);
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Entered Amount is: "+strCellAmount);
	   }
	   
	   public boolean isAmountCellDisplayed(){
//		   return SeleniumUtils.isDisplayed(driver, txtAmountcell, context.getReactTimeout());
		   return txtAmountcell.isDisplayed();
		   } 
	   
	   // Distribution Combination Textbox
	   
	   public void clickDistributionCombField(){
		  
		   txtDistCombination.click();
		   String DistributionComb = txtDistCombination.getText();
		   //wdwait.until(ExpectedConditions.visibilityOf(menuValidate));
		   if(DistributionComb.isEmpty()) {
			   SeleniumUtils.delay(2000);
		   }
		   report.log(LogStatus.PASS, "Clicked on Distribution Combination field");
	   }
	  
	   public boolean isDistributionCombFieldDisplayed(){
//		   return SeleniumUtils.isDisplayed(driver, txtDistCombination, context.getReactTimeout());
		   return txtDistCombination.isDisplayed();
		   } 

	   
	   // Distribution Combination Button
	   
	   public void clickDistCombinationButton(){	
		   btnDistCombination.click();
		   wdwait.until(ExpectedConditions.visibilityOf(srchCompany));
		   report.log(LogStatus.PASS, "Clicked on Distribution Combination Button");
	   }
	   
	   public boolean isDistCombinationBtnDisplayed(){
//		   return SeleniumUtils.isDisplayed(driver, btnDistCombination, context.getReactTimeout());
		   return btnDistCombination.isDisplayed();
	   }
	   
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
//		   return SeleniumUtils.isDisplayed(driver, srchFuture1, context.getReactTimeout());
		   return srchFuture1.isDisplayed();
	   }
	   
	   
	// Ok button in Account Pop up(1)
	   
	   public void clickAccountPopOkButton(){	
		   this.getScreenDetails("Distribution Combination ID Pop-up");
		   btnAccOkPop.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Account Ok Button");
	   }
	   
	   public boolean isAccountPopOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnAccOkPop, context.getReactTimeout());
	   }
	   
	  // Save button
	   
	   public void clickSaveButton(){	
		   SeleniumUtils.delay(5000);
		   btnSave.click();
		   SeleniumUtils.delay(10000);
		   //wdwait.until(ExpectedConditions.visibilityOf(btnInvoiceSummary));
		   wdwait.until(ExpectedConditions.visibilityOf(btnInvoiceHeaderSummary));
		   report.log(LogStatus.PASS, "Clicked on Save Button");
	   }
	   
	   public boolean isSaveButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSave, context.getReactTimeout());
	   	
	   }
	   
	   // Invoice Actions menu
	   public void clickActionsMenu(){
		   SeleniumUtils.delay(3000);
		   menuInvoiceActions.click();
		   this.getScreenDetails();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(menuValidate));
		   report.log(LogStatus.PASS, "Clicked on Invoice Actions Menu");
	   }
	  
	   public boolean isActionsMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuInvoiceActions, context.getReactTimeout());
	   	
	   }
	   
	// Validate list item from Invoice Actions menu
	   
	   public void selectValidateMenu(){	
		   menuValidate.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(btnInformationOkpop));
		   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
	   }
	   
	   public boolean isValidateMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuValidate, context.getReactTimeout());
	   	
	   }
	   
	   
	// Pay in Full Actions Menu
		
		public void selectPayInFullActionsMenu(){	
				menuPayInFull.click();
			  // SeleniumUtils.delay(8000);
				wdwait.until(ExpectedConditions.visibilityOf(selectPaymentProProfile));
			   report.log(LogStatus.PASS, "Clicked on Pay in Full in Invoice Actions Menu");
		}
		
		public boolean isPayInFullActionsMenuDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, menuPayInFull, context.getReactTimeout());
			
		}
		
		// Select Payment Process Profile
		
		   public void SelectPaymentProcessProfile(String strPmtProcProfile) throws InterruptedException{
		   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
			   selectPaymentProProfile.click();
		   	SeleniumUtils.isDisplayed(driver, selectPaymentProProfile, context.getReactTimeout());
		   	selectPaymentProProfile.sendKeys(strPmtProcProfile);
		   	//selectPaymentProProfile.sendKeys(Keys.ARROW_DOWN);
		   	selectPaymentProProfile.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Selected Payment Process Profile  is: "+strPmtProcProfile);
		   }
		   
		  
		   
		// Select Bank Account
			
		   public void SelectBankAccount(String strBankAcount) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   inputBankAcount.click();
			   inputBankAcount.sendKeys(strBankAcount);
			   inputBankAcount.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(3000);
		   	inputBankAcount.click();
		   	SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Selected Bank Acount  is: "+strBankAcount);
		   }
		   
		   public boolean isSelectPaymentProcessProfileDisplayed(){
			   //return SeleniumUtils.isDisplayed(driver, selectPaymentProProfile, context.getReactTimeout());
			   return selectPaymentProProfile.isDisplayed();
			   
			   } 
		   public void clickPaymentProProfileSearchIcon() throws InterruptedException{
		 	   
		    	SeleniumUtils.delay(2000);
		 		JavascriptExecutor js = (JavascriptExecutor)driver;
		     	js.executeScript("arguments[0].click();", srchPaymentProProfileicon);
		     	wdwait.until(ExpectedConditions.visibilityOf(lnkPaymentProProfileSearch));
		     	//SeleniumUtils.delay(3000);
		 	   report.log(LogStatus.PASS, "Clicked on Payment ProProfile Search Icon");
		    }
		   public void selectPaymentProProfileValue(String eventName){	
		    	WebDriverWait wait = new WebDriverWait(driver, 50);
		 	   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'paymentProfileNameId::dropdownPopup::dropDownContent::db')]//span[text()= '"+eventName+"']")));	   
		 	   //SeleniumUtils.delay(2000);
		 	   eventLink.click(); 
		 	   SeleniumUtils.delay(2000);
		 	  selectPaymentProProfile.sendKeys(Keys.ENTER);
		 	 SeleniumUtils.delay(2000);
		 	   report.log(LogStatus.PASS, "Selected Payment ProProfile from list");
		    }
		   
		// Select PaymentDocument
			
		   public void SelectPaymentDocument(String strPaymentDocument) throws InterruptedException{
			   /*String PaymentDocument=inputPaymentDocument.getText();
			   System.out.println("PaymentDocument"+PaymentDocument);
			   if(PaymentDocument==""){*/
				   
				   SeleniumUtils.delay(3000);
				   inputPaymentDocument.clear();
				   inputPaymentDocument.click();
				   inputPaymentDocument.sendKeys(strPaymentDocument);
				   inputPaymentDocument.sendKeys(Keys.ENTER);
				   	SeleniumUtils.delay(3000);
				   	inputPaymentDocument.click();
				   	SeleniumUtils.delay(3000); 
			  // }
					   
			   
		    report.log(LogStatus.PASS, "Selected PaymentDocument  is: "+strPaymentDocument);
		   }
	   
	  
		   // Click on Payment Number Text field
		   
		   public void clickPaymentNumber(){
			   if(txtPaymentNumber.isEnabled()) {
				   SeleniumUtils.delay(2000);
				   txtPaymentNumber.click();
			   }else {
				   SeleniumUtils.delay(5000);
				   txtPaymentNumber.click();
			   }
			   
			   
			  
			  // report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button"); 
		   }
		   
		 // Submit button  
		   public void clickSubmitButton(){	
			   this.getScreenDetails("Pay in Full Pop-up");
			   btnSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnPayFullConfOk));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
		   }
		   
		   public boolean isSubmitBtnDisplayed() throws InterruptedException{
			   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());		 
		   }
	 // Information Pop up Ok button  
	   public void clickInformationOkButton(){	
		   btnInformationOkpop.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Ok button in Information Pop-up");
	   }
	   
	   public boolean isInformationOkBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnInformationOkpop, context.getReactTimeout());
	   	
	   }
	   
	   
	   
	// Post  Ledger list item from Invoice Actions menu 
	   
	   public void selectPostLedgerMenu(){	
		   menuPostLedger.click();
		   //SeleniumUtils.delay(8000);
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Selected Validate item Invoice Actions Menu");
	   }
	   
	   public boolean isPostLedgerMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuPostLedger, context.getReactTimeout());
	   	
	   }
	// Confirmation Ok button
	   
	   public boolean isConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());  	
	   }  
	   
	   public void clickConfOkButton(){	
		   this.getScreenDetails("Confirmation Pop-up");
		   SeleniumUtils.delay(2000);
		   btnConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
		  // report.log(LogStatus.PASS, ""+message);
	   }
	   
	   // Pay in Full Pop-up Confirmation Ok button
	   
	   public boolean isPayinFullConfOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnPayFullConfOk, context.getReactTimeout());  	
	   }  
	   
	   public void clickPayinFullConfOkButton(){	
		   this.getScreenDetails("Confirmation Pop-up");
		   btnPayFullConfOk.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   }
	   
	   // Select Type dropdown
	   
	   public void selectType(String strType){
		   SeleniumUtils.delay(5000);
	    	//report.log(LogStatus.PASS, "Select File type from SelectFile dropdown");
	    	Select objSelect = new Select(selectType);
	    	//selectType.click();
	    	objSelect.selectByVisibleText(strType);
	    	//objSelect.selectByIndex(strFile);
	    	SeleniumUtils.delay(2000);
	    	report.log(LogStatus.PASS, "Selected given Type from the list is "+strType);
	    }
	   
	   public boolean isTypeDisplayed(){
		   return selectType.isDisplayed();
	   }
	   
	 //Payment Terms
	   public void SelectPaymentTerms(String strPaymentTerms) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
		   selectPaymentTerms.clear();
		   selectPaymentTerms.click();
		   	//SeleniumUtils.isDisplayed(driver, selectPaymentTerms, context.getReactTimeout());
		   	selectPaymentTerms.sendKeys(strPaymentTerms);
		   	selectPaymentTerms.sendKeys(Keys.ARROW_DOWN);
		   	selectPaymentTerms.sendKeys(Keys.ENTER);
		   	SeleniumUtils.delay(3000);
		    report.log(LogStatus.PASS, "Selected given Payment Terms from the list is: "+strPaymentTerms);
	   }
	   
	   public boolean isPaymentTermsDisplayed(){
		   return selectPaymentTerms.isDisplayed();
		   } 

	   
	   // Select Action Dropdown
	   
	   public void selectAction(String strAction){
		    SeleniumUtils.delay(2000);
	    	//report.log(LogStatus.PASS, "Select File type from SelectFile dropdown");
	    	Select objSelect = new Select(selectAction);
	    	//selectFile.click();
	    	objSelect.selectByVisibleText(strAction);
	    	//objSelect.selectByIndex(strFile);
	    	SeleniumUtils.delay(2000);
	    	report.log(LogStatus.PASS, "Selected Action  is: "+strAction);
	    }
	   
	   public boolean isActionDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, selectAction, context.getReactTimeout());
	   }
	   
	   // Click on Invoice Group
	   public void clickInvoiceGroup(){
		   txtInvoiceGroup.click();
	    }
	   
	   
	   //  Go Button
	   
	   public void clickGoButton(){
		   //SeleniumUtils.delay(15000);
		   btnGo.click();
		   SeleniumUtils.delay(10000);
		   if(btnWarningOk.isDisplayed()) {
			   this.getScreenDetails("Warning Pop-up");
			   JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", btnWarningOk);
			   //btnWarningOk.click();
			   btnGo.click();
		   }
		   
		   wdwait.until(ExpectedConditions.visibilityOf(txtInvoice));
		  // SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Go bitton");
	   }
	   
	   public boolean isGoBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnGo, context.getReactTimeout());
	   	
	   }
	   
	   // Invoice Text field in Correct Unmatched Invoices pop-up
	   
	   public void enterInvoice(String strInvoice) throws InterruptedException{
		   SeleniumUtils.delay(3000);
		   txtInvoice.clear();
		   txtInvoice.click();
		   txtInvoice.sendKeys(strInvoice);
		   //txtInvoice.click();
		   txtDate.click();
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Invoice Number is entered successfully: "+strInvoice);
	   }
	   
	   public boolean isInvoiceDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtInvoice, context.getReactTimeout());
		   } 
	   
	   // Search Button  in Correct Unmatched Invoices pop-up
	   public void clickSearchButton(){	
		   btnSearch.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Search button");
		   this.getScreenDetails("Correct Unmatched Invoices Pop-up");
	   }
	   
	   public boolean isSearchBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSearch, context.getReactTimeout());
	   	
	   }
	   
	   // Click on Correct Check-box in Correct Unmatched Invoices pop-up
	   
	   public void clickCorrectChkBox(){
		   SeleniumUtils.delay(5000);
		   chkBoxCorrect.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Correct Checkbox");
	   }
	   
	   public void isCorrectChkBoxDisplayed(){
	   //public boolean isCorrectChkBoxDisplayed(){
		   if(chkBoxCorrect.isDisplayed()) {
			   System.out.println("Object is displaying");
		   }else {
			   System.out.println("Object is not displaying");
		   }
			   
		  // return chkBoxCorrect.isDisplayed();
	   	
	   }
	   
	   // Apply Button in Correct Unmatched Invoices pop-up
	   
	   public void clickApplyButton(){	
		   btnApply.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Apply button");
	   }
	   
	   public boolean isAppyBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnApply, context.getReactTimeout());
	   	
	   }
	   
	   // Ok Button in Correct Unmatched Invoices pop-up
	   
	   
	   public void clickOkButton(){	
		   btnOk.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Ok button");
	   }
	   
	   public boolean isOkBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnOk, context.getReactTimeout());
	   	
	   }
	   
	   // Save and Close Button
	   public void clickSaveAndCloseButton(){	
		   btnSaveAndClose.click();
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Clicked on Save And Close button");
	   }
	   
	   public boolean isSaveAndCloseBtnDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnSaveAndClose, context.getReactTimeout());
	   	
	   }
	   
	// Click on Allocate Menu
	   
	   public void clickAllocateMenu(){	
		   this.getScreenDetails();
		   menuAllocate.click();
		   wdwait.until(ExpectedConditions.visibilityOf(lstAllLines_Allocate));
		   report.log(LogStatus.PASS, "Clicked on Allocate Menu");
	   }
	   
	   public boolean isAllocateMenuDisplayed(){
		   return menuAllocate.isDisplayed();
	   	
	   }
	   
	   // Click on Allocate All Lines List
	   
	   public void clickAllLinesList(){	
		   lstAllLines_Allocate.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnAllLinesConfOk));
		   report.log(LogStatus.PASS, "Clicked on All Lines List");
		   this.getScreenDetails("Confirmation Pop-Up");
	   }
	   
	   public boolean isAllLinesListDisplayed(){
		   return lstAllLines_Allocate.isDisplayed();
	   	
	   }
	   
	   // Click on lstAllSecLines_Allocate
	   public void clickSpecificLinesList(){	
		   lstSpecificLines_Allocate.click();
		   wdwait.until(ExpectedConditions.visibilityOf(lblAllocateFreight));
		   report.log(LogStatus.PASS, "Clicked on Specific Lines List");
		   this.getScreenDetails("Allocate Freight Pop Up");
	   }
	   
	   public boolean isSpecificLinesListDisplayed(){
		   return lstSpecificLines_Allocate.isDisplayed();
	   	
	   }
	   
	   // click on All Lines Confirmation
	   public void clickAllLinesConfOk(){	
		   btnAllLinesConfOk.click();
		   //wdwait.until(ExpectedConditions.visibilityOf(lstAllLines_Allocate));
		   report.log(LogStatus.PASS, "Clicked on All Lines List confirmation Ok");
		   SeleniumUtils.delay(5000);
	   }
	   
	   public boolean isAllLinesConfOkDisplayed(){
		   return btnAllLinesConfOk.isDisplayed();
	   	
	   }
	   
// Amount Text field in Correct Unmatched Invoices pop-up
	   
	   public void enterAmountInInvoice(String strInvoiceAmount) throws InterruptedException{
		   SeleniumUtils.delay(3000);
		   txtInvoiceAmount.clear();
		   txtInvoiceAmount.click();
		   txtInvoiceAmount.sendKeys(strInvoiceAmount);
		   report.log(LogStatus.PASS, "Entered value for Invoice Amountis: "+strInvoiceAmount);
	   }
	   
	   public boolean isamountInInvoiceeDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtInvoiceAmount, context.getReactTimeout());
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
	   
	   
	   public void selectCorrectUnmatchedInvoices(String InvoiceNumber,String cellAmount)
		{
		   JavascriptExecutor js = (JavascriptExecutor) driver; 
	    	List<WebElement> InvoiceRows = driver.findElements(By.xpath("//*[contains(@id,'ap1:r13:1:at1:_ATp:ta1::db')]//div//td[1]"));
	    	System.out.println("Statement Rows are"+InvoiceRows.size());
	    	
	    	if(InvoiceRows.size()==1) {
	    		String InvouceData = driver.findElement(By.xpath("//*[contains(@id,'ap1:r13:1:at1:_ATp:ta1::db')]//tr[1]//div//td[1]")).getText();
				System.out.println("Data is"+InvouceData);
				if(InvouceData.equalsIgnoreCase(InvoiceNumber)) {
					 SeleniumUtils.delay(5000);
					 
					 WebElement CorrectCheckBox =driver.findElement(By.xpath("//label[@class='x1da']"));
					 CorrectCheckBox.click();
					
					 SeleniumUtils.delay(10000);
					 this.getScreenDetails("Correct Unmatched Invoices Pop-up");
					 WebElement AmountCell =driver.findElement(By.xpath("//input[contains(@id,'ta1:0:i3::content')]"));
					 AmountCell.clear();
					 AmountCell.click();
					 AmountCell.sendKeys(cellAmount);
					 report.log(LogStatus.INFO, "Clicked on Correct Check-Box and Enter the Amount is :"+cellAmount);
					 this.getScreenDetails("Correct Unmatched Invoices Pop-up");

				 }
	    	}else if(InvoiceRows.size()>1) {
	    		
	    		int r;
				for (r=1;r<=InvoiceRows.size();r++)
				  {
					 String InvouceData = driver.findElement(By.xpath("//*[contains(@id,'ap1:r13:1:at1:_ATp:ta1::db')]//tr["+r+"]//div//td[1]")).getText();
					System.out.println("Data is"+InvouceData);
					 int i=r-1;
					 if(InvouceData.equalsIgnoreCase(InvoiceNumber)) {
						 SeleniumUtils.delay(5000);
						 
						 WebElement CorrectCheckBox =driver.findElement(By.xpath("//span[contains(@id,'_ATp:ta1:"+i+":sb1')]//label[@class='x1da']"));
						 
						 CorrectCheckBox.click();
						 WebDriverWait wait = new WebDriverWait(driver, 60);
						  
						WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'ta1:"+i+":i3::content')]")));
						 SeleniumUtils.delay(10000);
						 this.getScreenDetails("Correct Unmatched Invoices Pop-up");
						 WebElement AmountCell =driver.findElement(By.xpath("//input[contains(@id,'ta1:"+i+":i3::content')]"));
						 
						 AmountCell.clear();
						 AmountCell.click();
						 AmountCell.sendKeys(cellAmount);
						 report.log(LogStatus.INFO, "Clicked on Correct Check-Box and Enter the Amount is :"+cellAmount);
						 this.getScreenDetails("Correct Unmatched Invoices Pop-up");
						 break;
					 }
									
				  } 
	    		
	    	}else {
	    		report.log(LogStatus.INFO, "Data is not available");
	    	}

			
			   
		  }
	   
	   public void clickDistCombinationType(int rownum){ 
		   int r=rownum;
		   int j=r-1;
		  /* WebElement TypeCollumn =driver.findElement(By.xpath("//*[contains(@id,'0:ap1:at2:_ATp:ta2::db')]/table/tbody/tr["+r+"]/td[3]"));
		   TypeCollumn.click();*/
		   WebElement SelectType =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:"+j+":so12::content')]"));
		   		SeleniumUtils.delay(2000);
			   SelectType.click();
			   SeleniumUtils.delay(10000);		   
	    	
		   }
	   
	   // Expand Lines icon
	   
	   public void clickExpandLinesIcon(){	
		   iconLinesExpand.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnAddRow));
		   report.log(LogStatus.PASS, "Clicked on Expand Lines icon");  
		   
	   }
	   
	   public boolean isExpandLinesIconDisplayed(){
		   return iconLinesExpand.isDisplayed();
	   }
	   
	   public void selectDistCombinationType(int rownum,String strType){
		   int r=rownum;
		   int j=r-1;
		  /* WebElement TypeCollumn =driver.findElement(By.xpath("//*[contains(@id,'0:ap1:at2:_ATp:ta2::db')]/table/tbody/tr["+r+"]/td[3]"));
		   TypeCollumn.click();*/
		   WebElement SelectType =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:"+j+":so12::content')]"));
		   SeleniumUtils.delay(2000);
		  /* if(r>1) {
			   SelectType.click();
			   SeleniumUtils.delay(10000);
		   }*/
		   
	    	Select objSelect = new Select(SelectType);
	    	objSelect.selectByVisibleText(strType);
	    	SeleniumUtils.delay(2000);
	    	//report.log(LogStatus.PASS, "Selected Type  is: "+strType);
		   }
	   
	   public void enterDistCombinationAmount(int rownum,String strCellAmount){ 
		   int r=rownum;
		   int j=r-1;
		  /* WebElement AmountCollumn =driver.findElement(By.xpath("//*[contains(@id,'0:ap1:at2:_ATp:ta2::db')]/table/tbody/tr["+r+"]/td[4]"));
		   AmountCollumn.click();*/
		   WebElement txtAmountCell =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:"+j+":i26::content')]"));
		   SeleniumUtils.delay(2000);
		   txtAmountCell.click();
		   txtAmountCell.clear();
		   txtAmountCell.sendKeys(strCellAmount); 
		   //txtAmountCell.click();
		   SeleniumUtils.delay(2000);
		   WebElement txtDistCombinationValue =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:"+j+":kf1CS::content')]"));
		  
		   txtDistCombinationValue.click();
		  // txtAmountCell.sendKeys(Keys.TAB);
	    	//SeleniumUtils.delay(2000);
	    	//report.log(LogStatus.PASS, "Entered Amount in cell  is: "+strCellAmount);
		   }
	   
	   public void enterDistCombinationValue(int rownum,String strDistCombinationValue){ 
		   
		   int r=rownum;
		   int j=r-1;
		  /* WebElement AmountCollumn =driver.findElement(By.xpath("//*[contains(@id,'0:ap1:at2:_ATp:ta2::db')]/table/tbody/tr["+r+"]/td[4]"));
		   AmountCollumn.click();*/
		   SeleniumUtils.delay(5000);
		   WebElement txtDistCombinationValue =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:"+j+":kf1CS::content')]"));
		   SeleniumUtils.delay(5000);
		   txtDistCombinationValue.click();
		   txtDistCombinationValue.clear();
		   txtDistCombinationValue.sendKeys(strDistCombinationValue); 
		   txtDistCombinationValue.sendKeys(Keys.TAB);
	    	SeleniumUtils.delay(2000);
	    	//report.log(LogStatus.PASS, "Entered Amount in cell  is: "+strCellAmount);
		   }
	   public void clickAmountTab(){	
		   tabAmmount.click();
		   SeleniumUtils.delay(5000);
		   
	   }
	   
	   
	   public void clickDistCombinationAmount_Freight(int rownum,String strCellAmount){ 
		   SeleniumUtils.delay(5000);
		   int r=rownum;
		  int j=r-1;
		  /* WebElement AmountCollumn =driver.findElement(By.xpath("//*[contains(@id,'0:ap1:at2:_ATp:ta2::db')]/table/tbody/tr["+r+"]/td[4]"));
		   AmountCollumn.click();*/
		  // WebElement txtAmountCell =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:"+r+":i26::content')]"));
		   WebElement txtAmountCell =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:2:i26::content')]"));
		 
		   SeleniumUtils.delay(5000);
		   txtAmountCell.click();
		   txtAmountCell.clear();
		   txtAmountCell.sendKeys(strCellAmount);	
	    	SeleniumUtils.delay(5000);
	    	//report.log(LogStatus.PASS, "Entered Amount in cell  is: "+strCellAmount);
		   }
	   
	   public void clickDistCombinationIcon(int rownum){ 
		   int r=rownum;
		   int j=r-1;
		   SeleniumUtils.delay(2000);
		   WebElement btndistCombCell =driver.findElement(By.xpath("//*[contains(@id,'0:ap1:at2:_ATp:ta2:"+j+":kf1KBIMG::icon')]"));
		   SeleniumUtils.delay(2000);
		   wdwait.until(ExpectedConditions.visibilityOf(btndistCombCell));
		   btndistCombCell.click();	
		   wdwait.until(ExpectedConditions.visibilityOf(srchCompany));
	    	report.log(LogStatus.PASS, "Clicked on Distribution Combination icon");
	    	this.getScreenDetails("Distribution Combination Pop-Up");
		   } 
	   
	   public void clickDistCombinationPopUpOkButton(int rownum){ 
		   this.getScreenDetails("Distribution Combination Pop-Up");
		   int r=rownum;
		   int j=r-1;
		   SeleniumUtils.delay(2000);
		   WebElement btndistPopUpOk =driver.findElement(By.xpath("//*[contains(@id,'ap1:at2:_ATp:ta2:"+j+":kf1SEl')]"));
		   SeleniumUtils.delay(2000);
		   btndistPopUpOk.click();	
		  // wdwait.until(ExpectedConditions.visibilityOf(srchCompany));
		   SeleniumUtils.delay(2000);
	    	report.log(LogStatus.PASS, "Clicked on Distribution Combination Pop-Up Ok Button");
		   } 
	   
	   public void enterAllocateFreightAmount(int rownum,String strCellAmount){ 
		   System.out.println("value is"+ strCellAmount);
		   Actions action = new Actions(driver);
		   SeleniumUtils.delay(2000);
		   int r=rownum;
		   int j=r-1;
		  // SeleniumUtils.delay(2000);
		  /* WebElement AmountCollumn =driver.findElement(By.xpath("//*[contains(@id,'0:ap1:at2:_ATp:ta2::db')]/table/tbody/tr["+r+"]/td[4]"));
		   AmountCollumn.click();*/
		   WebElement txtAmountLine =driver.findElement(By.xpath("//Input[contains(@id,'_ATp:ta3:"+j+":i49::content')]"));
		   SeleniumUtils.delay(5000);
		   action.doubleClick(txtAmountLine);
		   action.perform();
		   //txtAmountLine.click();
		   SeleniumUtils.delay(10000);
		   txtAmountLine.sendKeys(strCellAmount);
		  // txtAmountLine.clear();
		  // js.executeScript("arguments[0].value='100.00';", txtAmountLine);
		   //txtAmountLine.sendKeys(strCellAmount); 
		   
	    	SeleniumUtils.delay(10000);
	    	//report.log(LogStatus.PASS, "Entered Amount in cell  is: "+strCellAmount);
		   }
	   
	  //
	   public void enterAllocateFreightAmountCell(int rownum,String strCellAmount){ 
		   if(rownum == 1) {
			   txtAllocateFreightAmount1.clear();
			   txtAllocateFreightAmount1.click();
			   txtAllocateFreightAmount1.sendKeys(strCellAmount);
		   }else {
			   txtAllocateFreightAmount2.clear();
			   txtAllocateFreightAmount2.click();
			   txtAllocateFreightAmount2.sendKeys(strCellAmount);
		   }
		   }
	   // Click in Allocate Freight Save and Close Button
	   public void clickSaveAndClose_AllocateFreightButton(){	
		   btnSaveAndClose_AllocateFreight.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnInformationOkpop));
		   report.log(LogStatus.PASS, "Clicked on Save And Close button");
	   }
	   
	   public boolean isSaveAndClose_AllocateFreightBtnDisplayed(){
		   return btnSaveAndClose_AllocateFreight.isDisplayed();
	   	
	   }
	   
	   public void selectNaturalAccountFromTable(String NAccount) throws InterruptedException { 
		   //List<WebElement> NAccRows = driver.findElements(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]//div//td[1]"));
	    	//System.out.println("Statement Rows are"+NAccRows.size());
	    	List<WebElement> Table1NAccRows = driver.findElements(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[1]//div//td[1]"));
	    	
	    	//int r;
			//for (r=1;r<=NAccRows.size();r++)
			 // {
				int j,k;
				for(j=1;j<=Table1NAccRows.size();j++) {
					 String NAccData1 = driver.findElement(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[1]//tr["+j+"]//div//td[1]")).getText();
					 System.out.println("1st Data is"+NAccData1);
					 
					 if(NAccData1.equalsIgnoreCase(NAccount)) {
						 SeleniumUtils.delay(5000);
						 WebElement NAccDataElement = driver.findElement(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[1]//tr["+j+"]//div//td[1]"));
						 NAccDataElement.click();
						 break;
					 }
					 if(j==(Table1NAccRows.size()+1)) {
						 
						 WebDriverWait wait = new WebDriverWait(driver, 15);
						  
						 WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[2]//span[contains(text(), '"+NAccount+"')]")));
						 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eventText);
						 Thread.sleep(2000);
						 eventText.click();
					 }
				}
				
				//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[2]//span[contains(text(),'671970')]
				/*List<WebElement> Table2NAccRows = driver.findElements(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[2]//div//td[1]"));
				for(k=1;k<=Table2NAccRows.size();k++) {
					
					 String NAccData2 = driver.findElement(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[2]//tr["+k+"]//div//td[1]")).getText();
					 System.out.println("2nd Data is"+NAccData2);
					
					if(NAccData2.equalsIgnoreCase(NAccount)) {
						 SeleniumUtils.delay(5000);
						 WebElement NAccDataElement = driver.findElement(By.xpath("//*[contains(@id,'query:value60_afrLovInternalTableId::db')]/table[2]//tr["+k+"]//div//td[1]"));
						 NAccDataElement.click();
						 break;
					 }
				}*/
				
				 //SeleniumUtils.delay(5000);
				
								
			 // } 
		 
		   }
	 
	   
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Create Invoice page is Loaded Successfully");
    	 if(selectBusinessUnit.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Invoice Page</span></a>");
	   	return new Item(xyz);
   }

}
