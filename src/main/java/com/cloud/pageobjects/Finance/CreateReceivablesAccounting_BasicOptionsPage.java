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

public class CreateReceivablesAccounting_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute1_ATTRIBUTE1::content')]")
    private WebElement selectPrintFormat;
 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'LedgerName::content')]")
	    private WebElement selectLedger;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'Attribute12_ATTRIBUTE12::glyph')]")
	    private WebElement btnEndDate;
 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute12_ATTRIBUTE12::pop::cd::mSel::content')]")
	    private WebElement selectEndDateMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'Attribute12_ATTRIBUTE12::pop::cd::cg')]")
	    private WebElement tableEndDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute13_ATTRIBUTE13::content')]")
	    private WebElement selectCrtAccounting;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'Attribute15_ATTRIBUTE15::content')]")
	    private WebElement selectAccMode;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':requestBtns:confirmationPopup:pt_ol1')]")
	    private WebElement lblConfirmation;
	 
 public WebDriverWait wdwait; 
	/**
	* Initializing page objects for Journal Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public CreateReceivablesAccounting_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(selectPrintFormat));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Basic Options Page *****************************");
	       this.getScreenDetails();
	    }
    
	 // Select Print Format list
	    public boolean isPrintFormatListDisplayed(){
			   return selectPrintFormat.isDisplayed();
		   } 
		   
		    public void selectPrintFormatList(String strPrintFormat){
		    	Select objSelect = new Select(selectPrintFormat);
		    	objSelect.selectByVisibleText(strPrintFormat);
		    }  
	    
		 // select Ledger List
			   
			   public void SelectLedgerList(String strLedger) throws InterruptedException{
				   
				   selectLedger.click();
				   selectLedger.clear();
				   selectLedger.sendKeys(strLedger);
				  // selectLedger.sendKeys(Keys.ENTER);
				   selectLedger.click();
				   	SeleniumUtils.delay(3000);
				   // report.log(LogStatus.PASS, "Selected Import Process  is: "+strImportProcess);
				   }
				   
				   public boolean isLedgerListDisplayed(){
					   return selectLedger.isDisplayed();
					   } 
				   
				// click on End Date  Calendar button
				      
				   public boolean isEndDateBtnDisplayed(){
				    	return btnEndDate.isEnabled();
				    	
				    }
				    public void clickEndDateButton(){	    	
				    	btnEndDate.click();
				    	 wdwait.until(ExpectedConditions.visibilityOf(selectEndDateMonth));
				    	//SeleniumUtils.delay(3000);
				    	report.log(LogStatus.PASS, "Clicked on End Date Button");
				    }
				   
				   // Select From Date Month from Calander
				    public void selectEndDateMonth(String endMonth){
				    	Select objSelect = new Select(selectEndDateMonth);
				    	objSelect.selectByVisibleText(endMonth);
				    	 wdwait.until(ExpectedConditions.visibilityOf(tableEndDate));
				    	report.log(LogStatus.PASS, "Selected End Date Month is: "+endMonth);
				    } 
				   
				   public boolean isEndDateMonthDisplayed(){
					   return selectEndDateMonth.isEnabled();
				   }
				   
				   // Select From Invoice Date
				   public void selectEndDate(String endDate)
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'Attribute12_ATTRIBUTE12::pop::cd::cg')]//td"));  
						for (WebElement cell:dates)
						  {
							String date=cell.getText();
						   if (date.equalsIgnoreCase(endDate))
						   {
						     cell.click();
							   SeleniumUtils.delay(2000);
							   report.log(LogStatus.PASS, "Selected End date is "+endDate);
							   break;
							   
						   }
						  } 
						  
					  }
			    
				// Select Create Accounting  list
				    public boolean isCreateAccountingListDisplayed(){
						   return selectCrtAccounting.isDisplayed();
					   } 
					   
				    public void selectCreateAccounting(String strCrtAccounting){
				    	Select objSelect = new Select(selectCrtAccounting);
				    	objSelect.selectByVisibleText(strCrtAccounting);
				    }  
				    
				 // Select Accounting  Mode
				    public boolean isAccountingModeDisplayed(){
						   return selectAccMode.isDisplayed();
					   } 
					   
				    public void selectAccountingMode(String strAccountingMode){
				    	Select objSelect = new Select(selectAccMode);
				    	objSelect.selectByVisibleText(strAccountingMode);
				    }   
				    
				 // submit button
					   
					   public void clickSubmitButton(){	
						   SeleniumUtils.delay(3000);
						   btnSubmit.click();
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
						   return ConfMessage.substring(8,13);
					   }
					   
					
			   // Conf Ok Button
					   public boolean isConfOkButtonDisplayed(){
						   return btnConfOk.isDisplayed();  	
					   }  
					   
					   public void clickConfOkButton(){	
						   String ConfMessage=lblConfirmation.getText();
						   btnConfOk.click();
						   report.log(LogStatus.PASS, ""+ConfMessage+" Clicked on Confirmation Ok Button");
					   }

    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Basic Options Page is Loaded Successfully");
    	 if(selectPrintFormat.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Basic Options Page</span></a>");
	   	return new Item(xyz);
   }


}
