package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class PrepareSourceLinesPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'q1:value10::content')]")
    private WebElement selectQueue;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value20::content')]")
	    private WebElement txtInvoiceNumber;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'q1:value30::content')]")
	    private WebElement txtDescription;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'q1:value40::lovIconId')]")
	    private WebElement iconSrchSupplier;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId:value00::content')]")
	    private WebElement txtSupplierName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId::search')]")
	    private WebElement btnSupplierSearch;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnSupplierOk;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'q1::search')]")
	    private WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATp:table2::db')]//td[1]")
	    private WebElement tbleSourcelineCell;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AT2:_ATp:ATm')]/div/table/tbody/tr/td[3]/div")
	    private WebElement menuAction_Sourceline;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATp:editSourceLine')]/td[2]")
	    private WebElement lstEdit_Sourceline;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public PrepareSourceLinesPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(selectQueue));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Prepare Source Lines Page *****************************");
		       this.getScreenDetails();
		    }
	    // Select Queue list
	    
	    public void selectQueueList(String strQueue){
			   Select objSelect=new Select(selectQueue);
			   objSelect.selectByVisibleText(strQueue);
		   }
		   
		   public boolean isQueueListDisplayed(){
			   return selectQueue.isDisplayed();
			   }  
	    
	  //Enter text into Invoice Number field
		   public void enterInvoiceNumber(String number){
			   txtInvoiceNumber.clear();
			   txtInvoiceNumber.click();
			   txtInvoiceNumber.sendKeys(number);
			  
		   }
		   
		   public boolean isInvoiceNumberDisplayed(){
			   return txtInvoiceNumber.isDisplayed();
			   }  
	    //txtDescription
		   public void clickDescriptionField(){
			   
			   txtDescription.click(); 
		   }
	    // Search: Supplier Icon
		   
		   public void clickSearchSupplierIcon(){	
			   iconSrchSupplier.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtSupplierName));
			   report.log(LogStatus.PASS, "Clicked on Supplier Search icon");  
			   
		   }
		   
		   public boolean isSearchSupplierIconDisplayed(){
			   return iconSrchSupplier.isDisplayed();
		   }
		   
		   // Search :
		   
		 //Enter text into Supplier Name field
		   public void enterSupplierName(String strSupplier){
			   txtSupplierName.clear();
			   txtSupplierName.click();
			   txtSupplierName.sendKeys(strSupplier);
			   txtSupplierName.click();
			   
		   }
		   
		   public boolean isSupplierNameDisplayed(){
			   return txtSupplierName.isDisplayed();
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
			   return btnSupplierSearch.isDisplayed();		 
		   }
		   
		// Supplier Search Ok Button 
		   public void clickSupplierOkButton(){	
			 
			   btnSupplierOk.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Supplier Ok Button");
		   }
		   
		   public boolean isSupplierOkBtnDisplayed() {
			   return btnSupplierOk.isDisplayed();		 
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
		   
		   // Search button
		   
		   public void clickSearchButton(){
			 //SeleniumUtils.delay(2000);
			   btnSearch.click();
			   wdwait.until(ExpectedConditions.visibilityOf(tbleSourcelineCell));
			   report.log(LogStatus.PASS, "Clicked on Search Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isSearchBtnDisplayed(){
			   return btnSearch.isDisplayed();
		   }
		   
		   //Select the source line cell
		   public void selectSourcelineCell() throws InterruptedException { 
			   tbleSourcelineCell.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Selected Source line Cell");
			   }
		   // Actions menu Source line
		   
		   public void clickActionsMenu_Sourceline(){
			 //SeleniumUtils.delay(2000);
			   menuAction_Sourceline.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lstEdit_Sourceline));
			   report.log(LogStatus.PASS, "Clicked on Actions menu");
			   this.getScreenDetails();
		   }
		   
		   public boolean isActionsMenu_SourcelineDisplayed(){
			   return  menuAction_Sourceline.isDisplayed();
		   }
		  // Select Edit List from Actions Menu 
		   public EditSourceLinePage selectEditList_Sourceline() throws TestException{
			   JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", lstEdit_Sourceline);
				 //SeleniumUtils.delay(2000);
			   	//lstEdit_Sourceline.click();
				   report.log(LogStatus.PASS, "Selected Edit list from Actions menu");
				   return new EditSourceLinePage(driver, report);
			   }
			   
			   public boolean isEditList_SourcelineDisplayed(){
				   return  lstEdit_Sourceline.isDisplayed();
			   }
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Prepare Source Lines Page is Loaded Successfully");
	    	 if(selectQueue.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Prepare Source Lines Page</span></a>");
		   	return new Item(xyz);
	   }

}
