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

public class CreateAdHocPaymentPage extends BasePageObject{
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:icl1::content')]")
	private WebElement selectFromAccount;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:icl21::content')]")
	private WebElement selectPayee;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:icl22::content')]")
	private WebElement selectAccountPayee;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:id1::glyph')]")
    private WebElement btnPaymentDate;
 
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:id1::pop::cd::mSel::content')]")
    private WebElement selectPaymentMonth;
 
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:id1::pop::cd::cg')]")
    private WebElement tblePaymentDate;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:it1::content')]")
	    private WebElement txtPaymentAmount;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:kf2CS::content')]")
	    private WebElement txtOffsetAccount;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl3::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl4::content')]")
	    private WebElement selectPaymentMethod;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl5::content')]")
	    private WebElement selectPaymentProfile;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:cb7')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:cb1')]")
	    private WebElement btnConfYes;
	
	 
public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/

	    
	 public CreateAdHocPaymentPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(selectFromAccount));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Create Ad Hoc Payment Page *****************************");
	       this.getScreenDetails();
	    }
	 
	 
	//From Account 
		 public void SelectFromAccount(String strFromAccount) throws InterruptedException{
			   selectFromAccount.click();
			   selectFromAccount.clear();
			   selectFromAccount.sendKeys(strFromAccount);
			   selectFromAccount.sendKeys(Keys.ENTER);
			   selectFromAccount.click();
		  	SeleniumUtils.delay(3000);
		 }
		 
		 public boolean isFromAccountListDisplayed(){
			   return selectFromAccount.isDisplayed();  	
		 }
		 
		//Payee
			 public void SelectPayee(String strPayee) throws InterruptedException{
				 selectPayee.click();
				 selectPayee.clear();
				 selectPayee.sendKeys(strPayee);
				 selectPayee.sendKeys(Keys.ENTER);
				 selectPayee.click();
			  	SeleniumUtils.delay(3000);
			 }
			 
			 public boolean isPayeeListDisplayed(){
				   return selectPayee.isDisplayed();  	
			 }
			 
			//Account Payee
			 public void SelectAccountPayee(String strAccountPayee) throws InterruptedException{
				 SeleniumUtils.delay(3000);
				 selectAccountPayee.click();
				 selectAccountPayee.clear();
				 selectAccountPayee.sendKeys(strAccountPayee);
				 selectAccountPayee.sendKeys(Keys.ENTER);
				 selectAccountPayee.click();
			  	SeleniumUtils.delay(5000);
			 }
			 
			 public boolean isAccountPayeeListDisplayed(){
				   return selectAccountPayee.isDisplayed();  	
			 }
			 
			// click on  Payment Date   button
		      
			   public boolean isPaymentDateBtnDisplayed(){
				   return btnPaymentDate.isDisplayed();
			    	
			    }
			    public void clickPaymentDateButton(){	    	
			    	btnPaymentDate.click();
			    	 wdwait.until(ExpectedConditions.visibilityOf(selectPaymentMonth));
			    	report.log(LogStatus.PASS, "Clicked on Transfer Date Button");
			    }
			   
			   // Select  Payment Month from Calander
			    public void selectPaymentMonth(String PaymentMonth){
			    	Select objSelect = new Select(selectPaymentMonth);
			    	objSelect.selectByVisibleText(PaymentMonth);
			    	 wdwait.until(ExpectedConditions.visibilityOf(tblePaymentDate));
			    	//SeleniumUtils.delay(5000);
			    	report.log(LogStatus.PASS, "Selected End Date Month  is: "+PaymentMonth);
			    } 
			    
			    public boolean isPaymentMonthDisplayed(){
					   return selectPaymentMonth.isDisplayed();
					   
				   }
				   
				   // Select  End Date
				   public void selectPaymentDate(String PaymentDate)
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'AP2:id1::pop::cd::cg')]//td"));  
						for (WebElement cell:dates)
						  {
							String date=cell.getText();
						   if (date.equalsIgnoreCase(PaymentDate))
						   {
						     cell.click();
							   SeleniumUtils.delay(2000);
							   report.log(LogStatus.PASS, "Selected Payment Date is "+PaymentDate);
							   break;
							   
						   }
						  } 
						   
					  }
				   
				 //Payment Amount  
					 public void enterPaymentAmount(String strPaymentAmount) throws InterruptedException{
						   txtPaymentAmount.click();
						   txtPaymentAmount.clear();
						   txtPaymentAmount.sendKeys(strPaymentAmount);
					  	
					 }
					 
					 public boolean isPaymentAmountDisplayed(){
						   return txtPaymentAmount.isDisplayed();  	
					 }
					 
					// Offset Account 
					   public void enterOffsetAccountField(String strOffsetAccount) {
						  
						   txtOffsetAccount.click();
						   txtOffsetAccount.clear();
						   txtOffsetAccount.sendKeys(strOffsetAccount);
						   txtOffsetAccount.click();
					    	//SeleniumUtils.delay(3000);
						   this.getScreenDetails();
					   }
					   
					   public boolean isOffsetAccountFieldDisplayed(){
						   return txtOffsetAccount.isDisplayed();  	
					   }
					 
				// Business Unit 
					 
					 public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
						   selectBusinessUnit.click();
						   selectBusinessUnit.clear();
						   selectBusinessUnit.sendKeys(strBusinessUnit);
						   selectBusinessUnit.sendKeys(Keys.ENTER);
						   selectBusinessUnit.click();
					  	SeleniumUtils.delay(3000);
					 }
					 
					 public boolean isBusinessUnitListDisplayed(){
						   return selectBusinessUnit.isDisplayed();  	
					 }
					 // Payment Method 
					 
					 public void SelectPaymentMethod(String strPaymentMethod) throws InterruptedException{
						   selectPaymentMethod.click();
						   selectPaymentMethod.clear();
						   selectPaymentMethod.sendKeys(strPaymentMethod);
						   selectPaymentMethod.sendKeys(Keys.ENTER);
						   selectPaymentMethod.click();
					  	SeleniumUtils.delay(3000);
					 }
					 
					 public boolean isPaymentMethodListDisplayed(){
						   return selectPaymentMethod.isDisplayed();  	
					 }	
					 
					 // Payment Profile  
					 
					 public void SelectPaymentProfile(String strPaymentProfile) throws InterruptedException{
						   selectPaymentProfile.click();
						   selectPaymentProfile.clear();
						   selectPaymentProfile.sendKeys(strPaymentProfile);
						   selectPaymentProfile.sendKeys(Keys.ENTER);
						   selectPaymentProfile.click();
					  	SeleniumUtils.delay(3000);
					 }
					 
					 public boolean isPaymentProfileListDisplayed(){
						   return selectPaymentProfile.isDisplayed();  	
					 }	
					 
					// Submit Button
					   public boolean isSubmitButtonDisplayed(){
						   return btnSubmit.isDisplayed();  	
					   }  
				   
					   public void clickSubmitButton(){
						   btnSubmit.click();
						   wdwait.until(ExpectedConditions.visibilityOf(btnConfYes));
						   report.log(LogStatus.PASS, "Clicked on Submit Button"); 
						   this.getScreenDetails("Confirmation Pop-up");
					   } 
					 
					   
					   // Confirmation Yes Button
					   public boolean isConfYesBtnDisplayed(){
						   return btnConfYes.isDisplayed();  	
					   }  
				   
					   public void clickConfYesButton(){
						   btnConfYes.click();
						   report.log(LogStatus.PASS, "Clicked on Confirmation Yes Button"); 
					   }  
	 
	 @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Create Ad Hoc Payment Page is Loaded Successfully");
	    	 if(selectFromAccount.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Ad Hoc Payment Page</span></a>");
		   	return new Item(xyz);
	   
		}


}
