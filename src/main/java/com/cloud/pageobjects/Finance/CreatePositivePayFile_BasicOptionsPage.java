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

public class CreatePositivePayFile_BasicOptionsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'paramDynForm_Attribute4_ATTRIBUTE4::content')]")
	    private WebElement selectPaymentProcProfile;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_Attribute2_ATTRIBUTE2::glyph')]")
	    private WebElement btnFromPaymentDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'paramDynForm_Attribute2_ATTRIBUTE2::pop::cd::mSel::content')]")
	    private WebElement selectFromPaymentMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_Attribute2_ATTRIBUTE2::pop::cd::cg')]")
	    private WebElement tbleFromPaymentDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_Attribute3_ATTRIBUTE3::glyph')]")
	    private WebElement btnToPaymentDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'paramDynForm_Attribute3_ATTRIBUTE3::pop::cd::mSel::content')]")
	    private WebElement selectToPaymentMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'paramDynForm_Attribute3_ATTRIBUTE3::pop::cd::cg')]")
	    private WebElement tbleToPaymentDate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'requestHeader:reqDesc::content')]")
	    private WebElement txtSubmissionNote;
	 
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
    
	    
	    public CreatePositivePayFile_BasicOptionsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(selectPaymentProcProfile));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Basic Options Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	    // Select Payment Process Profile list
		   public void selectPaymentProcessProfile(String strPaymentProcessProfile){
		    	//report.log(LogStatus.PASS, "Select Catagory from SelectCatagory dropdown");
		    	Select objSelect = new Select(selectPaymentProcProfile);
		    	objSelect.selectByVisibleText(strPaymentProcessProfile);
		    	
		    	SeleniumUtils.delay(1000);
		    	//report.log(LogStatus.PASS, "Selected Completion Status  is: "+strCompletionStatus);
		    } 
		   
		   public boolean isPaymentProcessProfileDisplayed(){
			   return selectPaymentProcProfile.isDisplayed();
			   } 
	    
	    
		   // click on FromPaymentDate Calendar button
		      
		   public boolean isFromPaymentDateBtnDisplayed(){
		    	return btnFromPaymentDate.isDisplayed();
		    	
		    }
		    public void clickFromPaymentDateButton(){	    	
		    	btnFromPaymentDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromPaymentMonth));
		    	report.log(LogStatus.PASS, "Clicked on From Payment Date Button");
		    }
		   
		   // Select From Date Month from Calander
		    public void selectFromPaymentMonth(String fromMonth){
		    	Select objSelect = new Select(selectFromPaymentMonth);
		    	objSelect.selectByVisibleText(fromMonth);
		    	 //wdwait.until(ExpectedConditions.visibilityOf(calendarFromInvoiceDt));
		    	SeleniumUtils.delay(2000);
		    	report.log(LogStatus.PASS, "Selected From Payment Month  is: "+fromMonth);
		    } 
		   
		   public boolean isFromInvoiceMonthDisplayed(){
			   return selectFromPaymentMonth.isDisplayed();
		   }
		   
		   // Select From Invoice Date
		   public void selectFromPaymentDate(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'paramDynForm_Attribute2_ATTRIBUTE2::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(fromDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Payment date is "+fromDate);
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
		   
		   // Select To Date Month from Calander
		    public void selectToPaymentMonth(String toMonth){
		    	
		    	Select objSelect = new Select(selectToPaymentMonth);
		    	objSelect.selectByVisibleText(toMonth);
		    	 //wdwait.until(ExpectedConditions.visibilityOf(calendarToInvoiceDt));
		    	SeleniumUtils.delay(2000);
		    	report.log(LogStatus.PASS, "Selected To Payment Month  is: "+toMonth);
		    } 
		   
		   public boolean isToPaymentMonthDisplayed(){
			   return selectToPaymentMonth.isDisplayed();
		   }
		   
		// Select To Invoice Date
		   public void selectToPaymentDate(String toDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'paramDynForm_Attribute3_ATTRIBUTE3::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(toDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected To Payment date is "+toDate);
					   break;
					   
				   }
				  } 
				  
			  }
	    
	    //Click on Submission Note field
		   public void clickSubmissionNote(){
			   txtSubmissionNote.click();
			   SeleniumUtils.delay(2000);
			   //report.log(LogStatus.PASS, "Clicked on Supplier Number field");
		   }

		// Submit button  
		   public void clickSubmitButton(){	
			   SeleniumUtils.delay(2000);
			   btnSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			   this.getScreenDetails("Confirmation Pop-up");
		   }
		   
		   public boolean isSubmitBtnDisplayed() throws InterruptedException{
			   return btnSubmit.isDisplayed();	 
		   } 
		   
		// Conf Massege 
		   public String ConfirmationProcessId() {
			   SeleniumUtils.delay(4000);
			   String ConfMessage=lblConfOk.getText();
			   //System.out.println("String is "+ConfMessage);
			   return ConfMessage.substring(8,13);
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
			
			 report.log(LogStatus.PASS, "Basic Options page is Loaded Successfully");
	    	 if(selectPaymentProcProfile.isDisplayed())
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
