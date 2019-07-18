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

public class InitiateApprovalWorkflow_SubmitRequestPage extends BasePageObject{
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_BUSINESSUNIT::content')]")
	private WebElement selectBusinessUnit;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_SUPPLIER::lovIconId')]")
    private WebElement srchParty;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_SUPPLIER::dropdownPopup::popupsearch')]")
    private WebElement lnkPartySearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_afrLovInternalQueryId:value00::content')]")
    private WebElement txtParty;
	

	@FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId::search')]")
    private WebElement btnPartySearch;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'::lovDialogId::ok')]")
    private WebElement btnPartyOk;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'ATTRIBUTE3_ATTRIBUTE3::glyph')]")
    private WebElement btnFromInvoiceDt;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'_ATTRIBUTE3::pop::cd::mSel::content')]")
    private WebElement calFromInvoiceMonth;
	
	@FindBy(how=How.XPATH, using = "//table[contains(@id,'paramDynForm_ATTRIBUTE3_ATTRIBUTE3::pop::cd::cg')]")
    private WebElement calendarFromInvoiceDt;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'ATTRIBUTE4_ATTRIBUTE4::glyph')]")
    private WebElement btnToInvoiceDt;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'_ATTRIBUTE4::pop::cd::mSel::content')]")
    private WebElement calToInvoiceMonth;
	
	@FindBy(how=How.XPATH, using = "//table[contains(@id,'paramDynForm_ATTRIBUTE4_ATTRIBUTE4::pop::cd::cg')]")
    private WebElement calendarToInvoiceDt;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_INVOICENUM::content')]")
    private WebElement txtInvoiceNumber;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:submitButton')]")
    private WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'requestBtns:confirmationPopup:pt_ol1')]")
	private WebElement lblConfText;
	 
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
    
    
    public InitiateApprovalWorkflow_SubmitRequestPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUnit));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Submit Request Page *****************************");
	       this.getScreenDetails();
	    }
    
  //BusinessUnit list
	   public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
	   
	   	selectBusinessUnit.click();  	
	   	selectBusinessUnit.sendKeys(strBusinessUnit);
	   	//selectBusinessUnit.sendKeys(Keys.ARROW_DOWN);
	   	selectBusinessUnit.sendKeys(Keys.ENTER);
	   	SeleniumUtils.delay(3000);
	   // report.log(LogStatus.PASS, "Selected Business Unit  is: "+strBusinessUnit);
	   }
	   
	   public boolean isSelectBusinessUnitDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, selectBusinessUnit, context.getReactTimeout());
		   } 
	   
	// Search Party Icon
	   
	   public void clickPartySearchIcon() throws InterruptedException{ 
		   srchParty.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Party Search Icon");
	   }
	   
	   public boolean isPartySearchIconDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, srchParty, context.getReactTimeout());
	   }
	   
	// Search Link for Party
	   
	   public void clickPartySearchLink() throws InterruptedException{	
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);	 
		   WebElement elementlnkAccountSearch = wait.until(ExpectedConditions.elementToBeClickable(lnkPartySearch));
		    elementlnkAccountSearch.click();
		    wdwait.until(ExpectedConditions.visibilityOf(txtParty));
		   report.log(LogStatus.PASS, "Clicked on Party Search link");
	   }
	   
	   public boolean isPartySearchLinkDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, lnkPartySearch, context.getReactTimeout());
	   } 
	   
	   // Enter party value in Party field
	   
	   public void enterPartyValue(String value) throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtParty.clear();
		   txtParty.click();
		   txtParty.sendKeys(value);
		   txtParty.sendKeys(Keys.ENTER);
		   SeleniumUtils.delay(2000);
		   report.log(LogStatus.PASS, "Entered value for Party is: "+value);
	   }
	   
	   
	   public boolean isPartyValueDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, txtParty, context.getReactTimeout());
		   } 
	   
	   
	// Search button in Party
	   public void clickPartySearchButton(){	
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", btnPartySearch);
				SeleniumUtils.delay(3000);
		   //btnAccSearch.click();
		   report.log(LogStatus.PASS, "Clicked on Party Search Button");
	   }
	   
	   public boolean isPartySearchButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnPartySearch, context.getReactTimeout());
	   } 
	   
	   // Click txtSupplierNumber
	   
	   public void clickInvoiceNumber() throws InterruptedException{
		   SeleniumUtils.delay(2000);
		   txtInvoiceNumber.click();
		   this.getScreenDetails();
		  
	   }
	   
	 //Select Event (select given text from dropdown)
	   public void selectEvent(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'paramDynForm_SUPPLIER_afrLovInternalTableId::db')]//td/span[contains(text(), '"+eventName+"')]")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   }
	   
	   // Select Invoice from Table
	   
	 //Select Event (select given text from dropdown)
	   public void selectInvoice(String eventName) throws InterruptedException { 
		   
		   WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, '_ATp:t1::db')]//span[contains(text(), '"+eventName+"')]")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   this.getScreenDetails();
		   }
	// Party Ok button
	   
	   public boolean isPartyOkButtonDisplayed(){
		   return SeleniumUtils.isDisplayed(driver, btnPartyOk, context.getReactTimeout());
	   }
	   
	   public void clickPartyOkButton(){	
		   WebDriverWait wait = new WebDriverWait(driver, 50);	 
		   WebElement elementbtnAccOk = wait.until(ExpectedConditions.elementToBeClickable(btnPartyOk));
		   elementbtnAccOk.click();
		   SeleniumUtils.delay(3000);
		   report.log(LogStatus.PASS, "Clicked on Party Ok Button");   
	   }

	   
	   // click on From Invoice Date Calendar button
	      
	   public boolean isFromInvoiceDtBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnFromInvoiceDt, context.getReactTimeout());
	    	
	    }
	    public void clickFromInvoiceDtButton(){	    	
	    	 btnFromInvoiceDt.click();
	    	 wdwait.until(ExpectedConditions.visibilityOf(calFromInvoiceMonth));
	    	//SeleniumUtils.delay(3000);
	    	report.log(LogStatus.PASS, "Clicked on From Invoice Date Button");
	    }
	   
	   // Select From Date Month from Calander
	    public void selectFromInvoiceMonth(String fromMonth){
	    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
	    	Select objSelect = new Select(calFromInvoiceMonth);
	    	objSelect.selectByVisibleText(fromMonth);
	    	 wdwait.until(ExpectedConditions.visibilityOf(calendarFromInvoiceDt));
	    	//SeleniumUtils.delay(5000);
	    	report.log(LogStatus.PASS, "Selected From Invoice Month  is: "+fromMonth);
	    } 
	   
	   public boolean isFromInvoiceMonthDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,calFromInvoiceMonth, context.getReactTimeout());
	   }
	   
	   // Select From Invoice Date
	   public void selectFromInvoiceDate(String fromDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'paramDynForm_ATTRIBUTE3_ATTRIBUTE3::pop::cd::cg')]//td"));  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(fromDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected From Invoice date is "+fromDate);
				   break;
				   
			   }
			  } 
			  
		  }
    
    
	// click on To Invoice Date Calendar button
	      
	   public boolean isToInvoiceDtBtnDisplayed(){
	    	return SeleniumUtils.isDisplayed(driver, btnToInvoiceDt, context.getReactTimeout());
	    	
	    }
	    public void clickToInvoiceDtButton(){	    	
	    	btnToInvoiceDt.click();
	    	 wdwait.until(ExpectedConditions.visibilityOf(calToInvoiceMonth));
	    	//SeleniumUtils.delay(3000);
	    	report.log(LogStatus.PASS, "Clicked on To Invoice Date Button");
	    }
	   
	   // Select To Date Month from Calander
	    public void selectToInvoiceMonth(String toMonth){
	    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
	    	Select objSelect = new Select(calToInvoiceMonth);
	    	objSelect.selectByVisibleText(toMonth);
	    	 wdwait.until(ExpectedConditions.visibilityOf(calendarToInvoiceDt));
	    	//SeleniumUtils.delay(5000);
	    	report.log(LogStatus.PASS, "Selected To Invoice Month  is: "+toMonth);
	    } 
	   
	   public boolean isToInvoiceMonthDisplayed(){
		   return SeleniumUtils.isDisplayed(driver,calToInvoiceMonth, context.getReactTimeout());
	   }
	   
	// Select To Invoice Date
	   public void selectToInvoiceDate(String toDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'paramDynForm_ATTRIBUTE4_ATTRIBUTE4::pop::cd::cg')]//td"));  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(toDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected To Invoice date is "+toDate);
				   break;
				   
			   }
			  } 
			  
		  }
	   
	// Submit Button
	   public boolean isSubmitButtonDisplayed(){
		   return btnSubmit.isDisplayed();  	
	   }  
   
	   public void clickSubmitButton(){
		   btnSubmit.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Submit Button"); 
		   this.getScreenDetails("confirmation Pop-up");
		 
	   } 
	 
	   
	   // Confirmation Ok Button
	   public boolean isConfOkBtnDisplayed(){
		   return btnConfOk.isDisplayed();  	
	   }  
   
	   public void clickConfOkButton(){
		   btnConfOk.click();
		   report.log(LogStatus.PASS, "Clicked on Confirmation Ok Button"); 
	   }  
 
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Submit Request Page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Submit Request Page</span></a>");
	   	return new Item(xyz);
   }

}
