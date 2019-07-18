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

public class CreateAccounting_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'SubledgerApplicationAttr::content')]")
	    private WebElement selectSubledgerApplication;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'LedgerAttr::content')]")
	    private WebElement selectLedger;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'ATTRIBUTE6_ATTRIBUTE6::glyph')]")
	    private WebElement btnEndDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ATTRIBUTE6_ATTRIBUTE6::pop::cd::mSel::content')]")
	    private WebElement selectEndDateMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATTRIBUTE6_ATTRIBUTE6::pop::cd::cg')]")
	    private WebElement tbleEndDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ATTRIBUTE11_ATTRIBUTE11::content')]")
	    private WebElement selectTransferGeneralLedger;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'ATTRIBUTE12_ATTRIBUTE12::content')]")
	    private WebElement selectPostGeneralLedger;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNotes;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'pt1:r1:requestBtns:submitButton')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'confirmSubmitDialog::ok')]")
	    private WebElement btnConfOk;
	 
 public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
   
	    
	 public CreateAccounting_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(selectSubledgerApplication));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Basic Options Page *****************************");
	       this.getScreenDetails();
	    }
	 
	// Subledger Application 
	   public void SelectSubledgerApplication(String strSubledgerApplication){
		   Select objSelect=new Select(selectSubledgerApplication);
		   objSelect.selectByVisibleText(strSubledgerApplication);
		  
	   }
	   
	   public boolean isSubledgerApplicationListDisplayed(){
		   return selectSubledgerApplication.isDisplayed();  	
	   }
	 
	// Ledger
	   public void SelectLedger(String strLedger) throws InterruptedException{
		  
		   selectLedger.click();
		   selectLedger.clear();
		   selectLedger.sendKeys(strLedger);
		   selectLedger.sendKeys(Keys.ENTER);
		   selectLedger.click();
	    	SeleniumUtils.delay(3000);
	   }
	   
	   public boolean isLedgerListDisplayed(){
		   return selectLedger.isDisplayed();  	
	   }
	   
	// click on  End Date button
	      
	   public boolean isEndDateBtnDisplayed(){
		   return btnEndDate.isDisplayed();
	    	
	    }
	    public void clickEndDateButton(){	    	
	    	btnEndDate.click();
	    	 wdwait.until(ExpectedConditions.visibilityOf(selectEndDateMonth));
	    	report.log(LogStatus.PASS, "Clicked on End Date Button");
	    }
	   
	   // Select  End Month from Calander
	    public void selectEndDateMonth(String fromMonth){
	    	Select objSelect = new Select(selectEndDateMonth);
	    	objSelect.selectByVisibleText(fromMonth);
	    	 wdwait.until(ExpectedConditions.visibilityOf(tbleEndDate));
	    	//SeleniumUtils.delay(5000);
	    	report.log(LogStatus.PASS, "Selected End Date Month  is: "+fromMonth);
	    } 
	   
	   public boolean isEndDateMonthDisplayed(){
		   return selectEndDateMonth.isDisplayed();
		   
	   }
	   
	   // Select  End Date
	   public void selectEndDate(String fromDate)
		{
			List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'_ATTRIBUTE6_ATTRIBUTE6::pop::cd::cg')]//td"));  
			for (WebElement cell:dates)
			  {
				String date=cell.getText();
			   if (date.equalsIgnoreCase(fromDate))
			   {
			     cell.click();
				   SeleniumUtils.delay(2000);
				   report.log(LogStatus.PASS, "Selected End Date is "+fromDate);
				   break;
				   
			   }
			  } 
			   
		  }
	   
	// Transfer to General Ledger  
	   public void SelectTransferGeneralLedger(String strTransferGeneralLedger){
		   Select objSelect=new Select(selectTransferGeneralLedger);
		   objSelect.selectByVisibleText(strTransferGeneralLedger);
		  
	   }
	   
	   public boolean isTransferGeneralLedgerListDisplayed(){
		   return selectTransferGeneralLedger.isDisplayed();  	
	   }
	   
	// PostGeneralLedger
	   public void SelectPostGeneralLedger(String strPostGeneralLedger){
		   Select objSelect=new Select(selectPostGeneralLedger);
		   objSelect.selectByVisibleText(strPostGeneralLedger);
		  
	   }
	   
	   public boolean isPostGeneralLedgerListDisplayed(){
		   return selectPostGeneralLedger.isDisplayed();  	
	   }
	   
	 //txtSubmissionNotes
	   public void clickSubmissionNotesText(){
		   txtSubmissionNotes.click();
		  // report.log(LogStatus.PASS, "Clicked on Stetement ID Ok Button"); 
	   }  
	   
	// Submit Button
	   public boolean isSubmitButtonDisplayed(){
		   return btnSubmit.isDisplayed();  	
	   }  
   
	   public void clickSubmitButton(){
		   btnSubmit.click();
		   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
		   report.log(LogStatus.PASS, "Clicked on Submit Button"); 
		   this.getScreenDetails("Confirmation Pop-up");
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
			
			 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
	    	 if(selectSubledgerApplication.isDisplayed())
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
