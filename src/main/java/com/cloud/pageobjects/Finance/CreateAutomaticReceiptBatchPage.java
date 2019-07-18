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

public class CreateAutomaticReceiptBatchPage extends BasePageObject{
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'operatingUnitId::content')]")
    private WebElement selectBusinessUit;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'receiptMethodId::content')]")
	    private WebElement selectReceiptMethod;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'id6::glyph')]")
	    private WebElement btnFromDueDate;

	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'id6::pop::cd::mSel::content')]")
	    private WebElement selectFromDueDateMonth;
	 
	 @FindBy(how=How.XPATH, using = "//table[contains(@id,'id6::pop::cd::cg')]")
	    private WebElement tableFromDueDate;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'id4::glyph')]")
	    private WebElement btnToDueDate;

	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'id4::pop::cd::mSel::content')]")
	    private WebElement selectToDueDateMonth;
	 
	 @FindBy(how=How.XPATH, using = "//table[contains(@id,'id4::pop::cd::cg')]")
	    private WebElement tableToDueDate;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'customerIdLowId::lovIconId')]")
	    private WebElement iconFromCustomerNamesearch;

	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	    private WebElement txtCustomerName;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value10::content')]")
	    private WebElement txtAccNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId::search')]")
	    private WebElement btnSearch_CustomerName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnOk_CustomerName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'actb1::popEl')]")
	    private WebElement menuSubmit;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'commandMenuItem3')]")
	    private WebElement lstSubmitApproveFormat;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'msgDlg::cancel')]")
	    private WebElement btnInfOk;
	
	 
	
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public CreateAutomaticReceiptBatchPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(selectBusinessUit));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Create Automatic Receipt Batch Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	 // select Business Uit List
		   
		   public void SelectBusinessUitList(String strBusinessUit) throws InterruptedException{
			   
			   selectBusinessUit.click();
			   selectBusinessUit.clear();
			   selectBusinessUit.sendKeys(strBusinessUit);
			   selectBusinessUit.sendKeys(Keys.ENTER);
			   selectBusinessUit.click();
			   	SeleniumUtils.delay(3000);
			   // report.log(LogStatus.PASS, "Selected Import Process  is: "+strImportProcess);
			   }
			   
		   public boolean isBusinessUitListDisplayed(){
			   return selectBusinessUit.isDisplayed();
			   } 
			   
		   // select Receipt Method  List
		   
		   public void SelectReceiptMethod(String strReceiptMethod) throws InterruptedException{
			   
			   selectReceiptMethod.click();
			   selectReceiptMethod.sendKeys(strReceiptMethod);
			  // selectReceiptMethod.sendKeys(Keys.ENTER);
			   selectReceiptMethod.click();
			   	SeleniumUtils.delay(3000);
			   // report.log(LogStatus.PASS, "Selected Import Process  is: "+strImportProcess);
			   }
			   
		   public boolean isReceiptMethodDisplayed(){
			   return selectReceiptMethod.isDisplayed();
			   } 
		   
		   
		// click on From Due Date  Calendar button
		      
		   public boolean isFromDueDateBtnDisplayed(){
		    	return btnFromDueDate.isEnabled();
		    	
		    }
		    public void clickFromDueDateButton(){	    	
		    	btnFromDueDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromDueDateMonth));
		    	//SeleniumUtils.delay(3000);
		    	report.log(LogStatus.PASS, "Clicked on From Due Date Button");
		    }
		   
		   // Select From Date Month from Calander
		    public void selectFromDueDateMonth(String fromMonth){
		    	Select objSelect = new Select(selectFromDueDateMonth);
		    	objSelect.selectByVisibleText(fromMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tableFromDueDate));
		    	report.log(LogStatus.PASS, "Selected From Due Date Month is: "+fromMonth);
		    } 
		   
		   public boolean isFromDueDateMonthDisplayed(){
			   return selectFromDueDateMonth.isEnabled();
		   }
		   
		   // Select From Invoice Date
		   public void selectFromDueDate(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'id6::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(fromDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Due Date is "+fromDate);
					   break;
					   
				   }
				  } 
				  
			  }
		   
		   
		// click on To Due Date  Calendar button
		      
		   public boolean isToDueDateBtnDisplayed(){
		    	return btnToDueDate.isEnabled();
		    	
		    }
		    public void clickToDueDateButton(){	    	
		    	btnToDueDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectToDueDateMonth));
		    	//SeleniumUtils.delay(3000);
		    	report.log(LogStatus.PASS, "Clicked on To Due Date Button");
		    }
		   
		   // Select From Date Month from Calander
		    public void selectToDueDateMonth(String toMonth){
		    	Select objSelect = new Select(selectToDueDateMonth);
		    	objSelect.selectByVisibleText(toMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tableToDueDate));
		    	report.log(LogStatus.PASS, "Selected To Due Date Month is: "+toMonth);
		    } 
		   
		   public boolean isToDueDateMonthDisplayed(){
			   return selectFromDueDateMonth.isEnabled();
		   }
		   
		   // Select From Invoice Date
		   public void selectToDueDate(String toDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'id4::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(toDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Due Date is "+toDate);
					   break;
					   
				   }
				  } 
				  
			  }
		   
		   
		   // Search icon From Customer Name 
		   
		   public void clickFromCustomerNameSearchIcon() throws InterruptedException{ 
			   iconFromCustomerNamesearch.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtCustomerName));
			   report.log(LogStatus.PASS, "Clicked on Payment Process Request Search Icon");
		   }
		   
		   public boolean isFromCustomerNameSearchIconDisplayed(){
			   return iconFromCustomerNamesearch.isDisplayed();
		   }
		   
		   // Enter Customer Name in Party field
		   
		   public void enterCustomerName(String strJournalCategory) throws InterruptedException{
			   //SeleniumUtils.delay(2000);
			   txtCustomerName.clear();
			   txtCustomerName.click();
			   txtCustomerName.sendKeys(strJournalCategory);
			   txtAccNumber.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Entered value for Customer Name is: "+strJournalCategory);
		   }
		   
		   
		   public boolean isCustomerNameDisplayed(){
			   return txtCustomerName.isDisplayed();
			   } 
		   
		   
		// Search button in Customer Name
		   public void clickCustomerNameSearchButton(){	
			   btnSearch_CustomerName.click();
			   SeleniumUtils.delay(3000);
			   //btnAccSearch.click();
			   report.log(LogStatus.PASS, "Clicked on Customer Name Search Button");
		   }
		   
		   public boolean isCustomerNameSearchButtonDisplayed(){
			   return btnSearch_CustomerName.isDisplayed();
		   } 
		   
		 //Select Event (select given text from dropdown)
		   public void selectCustomerName(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'afrLovInternalTableId::db')]//span[contains(text(), '"+eventName+"')]")));	   
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		// Payment Process Request Ok button
		   public boolean isCustomerNameOkButtonDisplayed(){
			   return btnOk_CustomerName.isDisplayed();
		   }
		   
		   public void clickCustomerNameOkButton(){	
			   btnOk_CustomerName.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Customer Name Ok Button");   
		   } 
		   
		   // Click on Submit Menu
		   
		   public boolean isSubmitMenuDisplayed(){
			   return menuSubmit.isDisplayed();
		   }
		   
		   public void clickSubmitMenu(){	
			   menuSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lstSubmitApproveFormat));
			   report.log(LogStatus.PASS, "Clicked on Submit menu");   
		   } 
		   
		// Click on Submit, Approve, and Format list
		   public boolean isSubmitApproveFormatDisplayed(){
			   return lstSubmitApproveFormat.isDisplayed();
		   }
		   
		   public void clickSubmitApproveFormat(){	
			   lstSubmitApproveFormat.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
			   report.log(LogStatus.PASS, "Clicked on Submit, Approve, and Format list");
			   this.getScreenDetails("Information Pop-up");
			   
		   } 
		   
		// Click on Information Ok button
		   public boolean isInfoOkButtonDisplayed(){
			   return btnInfOk.isDisplayed();
		   }
		   
		   public void clickInfoOkButton(){	
			   btnInfOk.click();
			   report.log(LogStatus.PASS, "Clicked on Information Ok button");   
		   } 
		   
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Create Automatic Receipt Batch Page is Loaded Successfully");
	    	 if(selectBusinessUit.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Automatic Receipt Batch Page</span></a>");
		   	return new Item(xyz);
	   }

}
