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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EditInvoicePage extends BasePageObject{
	
	public WebDriver driver;
	 //@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:me1']")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:1:ap1:me1')]//div[@class='xm9']")
	    private WebElement menuInvActionsEdit;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_payables_payables_invoices:0:MAnt2:1:pm1:r1:1:ap1:cmi2']")
	    private WebElement menuPayFullEdit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:sh2::_afrDscl')]")
	    private WebElement iconLinesExpand;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:create::icon')]")
	    private WebElement btnAddRow;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:ta2:0:pgl8')]")
	    private WebElement cell1Invoice;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:at2:_ATp:ctb2')]")
	    private WebElement btnCancelLine;

	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pm1:r1:1:ap1:r9:1:paymentProfileNameId::content')]")
	    private WebElement selectPaymentProProfile;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'paymentProfileNameId::lovIconId')]")
	    private WebElement srchPaymentProProfileicon;
	 
	 @FindBy(how=How.XPATH, using = ".//*[contains(@id,'Popup::popupsearch')]")
	   private WebElement lnkPaymentProProfileSearch;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'bankAccountNamePIFId::content')]")
	    private WebElement inputBankAcount;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'paymentDocumentNameId::content')]")
	    private WebElement inputPaymentDocument;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:1:ap1:r9:1:paymentDocumentNameId::content')]")
	    private WebElement selectPaymentDocument;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:1:ap1:r9:1:it1::content')]")
	    private WebElement txtPaymentNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:pm1:r1:1:ap1:pifbtn1')]")
	    private WebElement btnSubmit;
	 
	 
	// @FindBy(how=How.XPATH, using = "//button[@id='_FOd1::msgDlg::cancel']")
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'msgDlg::cancel')]")
	    private WebElement btnInfoOk;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:cb43')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:cb14')]")
	    private WebElement btnSaveClose;
	 
	
	 @FindBy(how=How.XPATH, using = "//td[contains(text(),'Post to Ledger')]")
	   private WebElement menuPost;
	 
	 @FindBy(how=How.XPATH, using = "//td[contains(text(),'Validate')]")
	   private WebElement menuValidate;
	 
	 @FindBy(how=How.XPATH, using = "//a[text()='Validated']")
	   private WebElement lnkValidate_Lbl;
	
	 
	 @FindBy(how=How.XPATH, using = "//td[contains(text(),'Apply or Unapply Prepayments')]")
	   private WebElement menuApplyorUnapplyPrepayments;
	 
	
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'_ATp:_qbeTbr::icon')]")
	   private WebElement iconQyeryByExample;
	 
	 @FindBy(how=How.XPATH, using = "//table[contains(@id,'at1:_ATp:ta1::ch::d2::t2')]//input[contains(@id,'_c4::content')]")
	   private WebElement txtQyeryByExample_Field1;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'_ATp:cb1')]")
	   private WebElement btnQyeryByExample_Apply;
	
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:cb19')]")
	   private WebElement btnQyeryByExample_Done;
	
	public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/

public EditInvoicePage(WebDriver driver, ExtentTest report) throws TestException {
     super(report);
	 this.driver=driver; 
	 wdwait=new WebDriverWait(driver, 60);
     PageFactory.initElements(driver, this);
     
     wdwait.until(ExpectedConditions.visibilityOf(menuInvActionsEdit));
     if (!isDisplayed()) 
     {
        throw new TestException(this.getClass().getName() + " is not loaded");
     }
     
        System.out.println("******************************* Edit Invoice Page *****************************");
       this.getScreenDetails();
    }
	
	//Invoice Actions menu
	public void clickActionsMenu(){	
		SeleniumUtils.delay(5000);
			menuInvActionsEdit.click();
			
			 wdwait.until(ExpectedConditions.visibilityOf(menuValidate));
			// wdwait.until(ExpectedConditions.visibilityOf(menuPayFullEdit));
		   SeleniumUtils.delay(8000);
		   report.log(LogStatus.PASS, "Clicked on Invoice Actions Menu");
		   this.getScreenDetails();
	}
	
	public boolean isActionsMenuDisplayed(){
		  // return SeleniumUtils.isDisplayed(driver, menuInvActionsEdit, context.getReactTimeout());
		   return menuInvActionsEdit.isDisplayed();
		
	}
	
	// Validate list item from Invoice Actions menu
	   
	   public void selectValidateMenu(){	
		   menuValidate.click();
		   wdwait.until(ExpectedConditions.visibilityOf(lnkValidate_Lbl));
		   //SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected Validate list Actions Menu");
		   this.getScreenDetails();
	   }
	   
	   public boolean isValidateMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuValidate, context.getReactTimeout());
	   	
	   }
	
	// Validate list item from Invoice Actions menu
	   
	   public void selectPostMenu(){
		   SeleniumUtils.delay(5000);
		   menuPost.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Selected Post list Actions Menu");
		   this.getScreenDetails();
	   }
	   
	   public boolean isPostMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuPost, context.getReactTimeout());
	   	
	   }
	   
// Apply or Unapply Prepayments list item from Invoice Actions menu
	   
	   public void selectApplyOrUnapplyPrepaymentsMenu(){
		   
		   SeleniumUtils.delay(2000);
	 		JavascriptExecutor js = (JavascriptExecutor)driver;
	     	js.executeScript("arguments[0].click();", menuApplyorUnapplyPrepayments);
	     	
		   //menuApplyorUnapplyPrepayments.click();
	     	SeleniumUtils.delay(5000);
		   wdwait.until(ExpectedConditions.visibilityOf(iconQyeryByExample));
		   report.log(LogStatus.PASS, "Selected Apply or Unapply Prepayments Actions Menu");
		   this.getScreenDetails("Apply or Unapply Prepayments Pop-Up");
	   }
	   
	   public boolean isApplyOrUnapplyPrepaymentsMenuDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, menuApplyorUnapplyPrepayments, context.getReactTimeout());
	   	
	   }

// Qyery by Example icon
	   
	   public void clickQyeryByExampleicon(String srchValue){
		   if(txtQyeryByExample_Field1.isDisplayed()) {
			   txtQyeryByExample_Field1.clear();
			   txtQyeryByExample_Field1.click();
			   txtQyeryByExample_Field1.sendKeys(srchValue);
			   txtQyeryByExample_Field1.sendKeys(Keys.TAB);
			   txtQyeryByExample_Field1.sendKeys(Keys.ENTER);
			   SeleniumUtils.delay(5000);
			   
		   }else {
			   iconQyeryByExample.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtQyeryByExample_Field1));
			   report.log(LogStatus.PASS, "Clicked on icon Qyery By Example");
			   txtQyeryByExample_Field1.clear();
			   txtQyeryByExample_Field1.click();
			   txtQyeryByExample_Field1.sendKeys(srchValue);
			   txtQyeryByExample_Field1.sendKeys(Keys.TAB);
			   txtQyeryByExample_Field1.sendKeys(Keys.ENTER);
			   SeleniumUtils.delay(5000);
		   }
		   
		  /* iconQyeryByExample.click();
		  SeleniumUtils.delay(5000);
		  wdwait.until(ExpectedConditions.visibilityOf(iconQyeryByExample));
		   report.log(LogStatus.PASS, "Clicked on icon Qyery By Example");*/
		   this.getScreenDetails("Apply or Unapply Prepayments Pop-Up");
	   }
	   
	   public boolean isQyeryByExampleiconDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, iconQyeryByExample, context.getReactTimeout());
	   	
	   }   
	   
	//Apply or Unapply Prepayments Pop-Up Table   
	   public void selectApplyOrUnapplyPrepayments(String PrePaymentNumber,String cellAmount)
		{
		   JavascriptExecutor js = (JavascriptExecutor) driver; 
	    	List<WebElement> InvoiceRows = driver.findElements(By.xpath("//div[contains(@id,'ATp:ta1::db')]/table/tbody//div"));
	    	System.out.println("Statement Rows are"+InvoiceRows.size());
	    	
	    	 if(InvoiceRows.size()>=1) {
	    		
	    		int r;
				for (r=1;r<=InvoiceRows.size();r++)
				  {
					 
					 String PaymentNumber = driver.findElement(By.xpath("//div[contains(@id,'ATp:ta1::db')]/table/tbody/tr["+r+"]//div//td[1]")).getText();
					System.out.println("Data is"+PaymentNumber);
					 int i=r-1;
					 if(PaymentNumber.equalsIgnoreCase(PrePaymentNumber)) {
						 SeleniumUtils.delay(5000);
						 
						 WebElement NumberCell =driver.findElement(By.xpath("//div[contains(@id,'ATp:ta1::db')]/table/tbody/tr["+r+"]//div//td[1]"));
						 
						 NumberCell.click();
						 WebDriverWait wait = new WebDriverWait(driver, 60);
						  
						WebElement eventText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'ATp:ta1::db')]/table/tbody//tr["+r+"]//div//td//input[contains(@id,'i1::content')]")));
						 SeleniumUtils.delay(10000);
						 this.getScreenDetails("Apply or Unapply Prepayments Pop-Up");
						 WebElement AmountCell =driver.findElement(By.xpath("//div[contains(@id,'ATp:ta1::db')]/table/tbody//tr["+r+"]//div//td//input[contains(@id,'i1::content')]"));
						 
						 AmountCell.clear();
						 AmountCell.click();
						 AmountCell.sendKeys(cellAmount);
						 AmountCell.sendKeys(Keys.TAB);
						 report.log(LogStatus.INFO, "Enter the Amount is :"+cellAmount);
						 this.getScreenDetails("Apply or Unapply Prepayments Pop-Up");
						 break;
					 }
									
				  } 
	    		
	    	}else {
	    		report.log(LogStatus.INFO, "Data is not available");
	    	}
   
		  }
	   
	 //Apply or Unapply Prepayments Pop-Up Apply button
		public void clicApplyOrUnapplyPrepayments_ApplyButton(){	
			btnQyeryByExample_Apply.click();
				
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on apply Button");
			   this.getScreenDetails();
		}
		
		public boolean isApplyOrUnapplyPrepayments_ApplyButtonDisplayed(){
			  // return SeleniumUtils.isDisplayed(driver, menuInvActionsEdit, context.getReactTimeout());
			   return btnQyeryByExample_Apply.isDisplayed();
			
		}
		
		//Apply or Unapply Prepayments Pop-Up Done button
				public void clicApplyOrUnapplyPrepayments_doneButton(){	
					SeleniumUtils.delay(5000);
					btnQyeryByExample_Done.click();
					SeleniumUtils.delay(5000);
					wdwait.until(ExpectedConditions.visibilityOf(btnSaveClose));
					   
					   report.log(LogStatus.PASS, "Clicked on apply Button");
					   this.getScreenDetails();
				}
				
				public boolean isApplyOrUnapplyPrepayments_DoneButtonDisplayed(){
					   return btnQyeryByExample_Done.isDisplayed();
					
				}
	// Pay in Full Actions Menu
	
	public void selectPayInFullActionsMenu(){	
			menuPayFullEdit.click();
			 wdwait.until(ExpectedConditions.visibilityOf(selectPaymentProProfile));
		   //SeleniumUtils.delay(8000);
		   report.log(LogStatus.PASS, "Clicked on Invoice Actions Menu");
	}
	
	public boolean isPayInFullActionsMenuDisplayed(){
		   //return SeleniumUtils.isDisplayed(driver, menuPayFullEdit, context.getReactTimeout());
		   return menuPayFullEdit.isDisplayed();
		
	}

	// Select Payment Process Profile
	
	   public void SelectPaymentProcessProfile(String strPmtProcProfile) throws InterruptedException{
	   	//report.log(LogStatus.PASS, "Select any Category from SelectCategory dropdown");
		   selectPaymentProProfile.click();
	   //	SeleniumUtils.isDisplayed(driver, selectPaymentProProfile, context.getReactTimeout());
	   	selectPaymentProProfile.sendKeys(strPmtProcProfile);
	   	//selectPaymentProProfile.sendKeys(Keys.ARROW_DOWN);
	   	selectPaymentProProfile.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(3000);
	    report.log(LogStatus.PASS, "Selected Payment Process Profile  is: "+strPmtProcProfile);
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
	    
	    public boolean isPaymentProProfileSearchIconDisplayed(){
	 	   return SeleniumUtils.isDisplayed(driver, srchPaymentProProfileicon, context.getReactTimeout());
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
		   SeleniumUtils.delay(3000);
		   txtPaymentNumber.click();
		  
		  // report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button"); 
	   }
	   
	 // Submit button  
	   public void clickSubmitButton(){	
		   btnSubmit.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnInfoOk));
		   report.log(LogStatus.PASS, "Clicked on Submit Button");
	   }
	   
	   public boolean isSubmitBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnSubmit, context.getReactTimeout());		 
	   }
	   
	// Invoice Cell 1 click 
	   public void clickCell1Invoice(){
		   //this.getScreenDetails();
		   cell1Invoice.click();
		   report.log(LogStatus.PASS, "Clicked on cell 1");
	   }
	   
	   public boolean isCell1InvoiceDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, cell1Invoice, context.getReactTimeout());		 
	   }
	   
	   
	   // Cancel Line button
	   public void clickCancelLineButton(){	
		   btnCancelLine.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Cance lLine Button");
	   }
	   
	   public boolean isCancelLineBtnDisplayed() throws InterruptedException{
		  // return SeleniumUtils.isDisplayed(driver, btnCancelLine, context.getReactTimeout());	
		   return btnCancelLine.isDisplayed();
	   }
	   
	   
	   // Confirmation Ok Button
	   
	   public void clickConfOkButton(){	
		   btnConfOk.click();
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   }
	   
	   public boolean isConfOkBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnConfOk, context.getReactTimeout());		 
	   }
	   
	   // Information ConformationOk Button
	   
	   public void clickInformationConfOkButton(){	
		   btnInfoOk.click();
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button");
	   }
	   
	   public boolean isInformationConfOkBtnDisplayed() throws InterruptedException{
		   return SeleniumUtils.isDisplayed(driver, btnInfoOk, context.getReactTimeout());		 
	   }
	   
		
	// Save and Close button
		   
		   public void clickSaveAndCloseButton(){
			   SeleniumUtils.delay(3000);
			   btnSaveClose.click();
			   SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
		   }
		   
		   public boolean isSaveAndCloseButtonDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, btnSaveClose, context.getReactTimeout());
		   	
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
		   

	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Edit Invoice page is Loaded Successfully");
    	 if(menuInvActionsEdit.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Invoice Page</span></a>");
	   	return new Item(xyz);
   }

}
