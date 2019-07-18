package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
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

public class BankStatementReport_BasicOptionsPage extends BasePageObject{
	public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE8::content')]")
    private WebElement inputBankAccount;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE9::glyph')]")
    private WebElement btnFromStatementEndDt;
 
 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE9::pop::cd::mSel::content')]")
    private WebElement selectFromStatementEndMonth;
 
 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE9::pop::cd::cg')]")
    private WebElement tbleFromStatementEndDt;
 
 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE10::glyph')]")
    private WebElement btnToStatementEndDt;
 
 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE10::pop::cd::mSel::content')]")
    private WebElement selectToStatementEndMonth;
 
 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_ATTRIBUTE10::pop::cd::cg')]")
    private WebElement tbleToStatementEndDt;
 
 @FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestHeader:reqDesc::content')]")
 private WebElement txtSubmissionNotes;

@FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:submitButton')]")
 private WebElement btnSubmit;

@FindBy(how=How.XPATH, using = "//*[contains(@id,'r1:requestBtns:confirmationPopup:pt_ol1')]")
 private WebElement lblConfirmation;

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
 
 
 public BankStatementReport_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	    
	     wdwait.until(ExpectedConditions.visibilityOf(inputBankAccount));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	     
	        System.out.println("******************************* Basic Options Page *****************************");
	       this.getScreenDetails();
	    }
 
		//Select Bank Account
		 
		 public void SelectBankAccountList(String strBankAccount) throws InterruptedException{
			   this.getScreenDetails();
			   inputBankAccount.clear();
			   inputBankAccount.click();
			   inputBankAccount.sendKeys(strBankAccount);
			   //inputBankAccount.sendKeys(Keys.ENTER);
			   inputBankAccount.click();
		  	SeleniumUtils.delay(3000);
		 }
		 
		 public boolean isBankAccountDisplayed(){
			   return inputBankAccount.isDisplayed();
			   } 
		 
		// click on From Entered Date button
	      
		   public boolean isFromEnteredDateBtnDisplayed(){
			   return btnFromStatementEndDt.isDisplayed();
		    	
		    }
		    public void clickFromEnteredDateButton(){	    	
		    	btnFromStatementEndDt.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromStatementEndMonth));
		    	report.log(LogStatus.PASS, "Clicked on From Statement End Date Button");
		    }
		   
		   // Select From Entered Month from Calander
		    public void selectFromEnteredDtMonth(String fromMonth){
		    	Select objSelect = new Select(selectFromStatementEndMonth);
		    	objSelect.selectByVisibleText(fromMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleFromStatementEndDt));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected From Statement End Date Month  is: "+fromMonth);
		    } 
		   
		   public boolean isFromEnteredDtMonthDisplayed(){
			   return selectFromStatementEndMonth.isDisplayed();
			   
		   }   
	   
		// Select From Statement End Date
		   public void selectFromEnteredDate(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_ATTRIBUTE9::pop::cd::cg')]//td"));  
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
			   return btnToStatementEndDt.isDisplayed();
		    	
		    }
		    public void clickToEnteredDateButton(){	    	
		    	btnToStatementEndDt.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectToStatementEndMonth));
		    	report.log(LogStatus.PASS, "Clicked on To Statement End Date Button");
		    }
		   
		   // Select To Entered Month from Calander
		    public void selectToEnteredDtMonth(String toMonth){
		    	Select objSelect = new Select(selectToStatementEndMonth);
		    	objSelect.selectByVisibleText(toMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleToStatementEndDt));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected To Statement End Date Month  is: "+toMonth);
		    } 
		   
		   public boolean isToEnteredDtMonthDisplayed(){
			   return selectToStatementEndMonth.isDisplayed();
			   
		   }   
	   
		// Select From Statement End Date
		   public void selectToEnteredDate(String toDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'paramDynForm_ATTRIBUTE10::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(toDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected To Statement End Date is "+toDate);
					   break;
					   
				   }
				  } 
				   
			  }  
 
		//txtSubmissionNotes
		   public void clickSubmissionNotes() {
			   txtSubmissionNotes.click();
			   SeleniumUtils.delay(2000);
			   }
		   
	   // submit button
		   
		   public void clickSubmitButton(){	
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
			   System.out.println("String is "+ConfMessage.substring(8,14));
			   return ConfMessage.substring(8,14);
		   }
		   
		
		   //Conf Ok Button
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
		
		 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
 	 if(inputBankAccount.isDisplayed())
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
