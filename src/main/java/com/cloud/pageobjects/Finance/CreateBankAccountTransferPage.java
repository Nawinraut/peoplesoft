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

public class CreateBankAccountTransferPage extends BasePageObject{
	
	public WebDriver driver;
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl1::content')]")
    private WebElement selectFromAccount;
 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl2::content')]")
	    private WebElement selectToAccount;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'AP2:id1::glyph')]")
	    private WebElement btnTransferDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'AP2:id1::pop::cd::mSel::content')]")
	    private WebElement selectTransferDateMonth;
	 
	 @FindBy(how=How.XPATH, using = "//table[contains(@id,'AP2:id1::pop::cd::cg')]")
	    private WebElement tbleTransferDate;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:it1::content')]")
	    private WebElement txtTransferAmount;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl3::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl4::content')]")
	    private WebElement selectPaymentMethod;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:icl5::content')]")
	    private WebElement selectPaymentProfile;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'MAnt2:1:AP2:cb3')]")
	    private WebElement btnSubmit;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'MAnt2:1:AP2:cb1')]")
	    private WebElement btnConfYes;
	 
public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
 
 public CreateBankAccountTransferPage(WebDriver driver, ExtentTest report) throws TestException {
     super(report);
	 this.driver=driver; 
	 wdwait=new WebDriverWait(driver, 60);
     PageFactory.initElements(driver, this);
     
     wdwait.until(ExpectedConditions.visibilityOf(selectFromAccount));
     if (!isDisplayed()) 
     {
        throw new TestException(this.getClass().getName() + " is not loaded");
     }
     
        System.out.println("******************************* Create Bank Account Transfer Page *****************************");
       this.getScreenDetails();
    }
 
 
	//From Account 
	 public void SelectFromAccount(String strFromAccount) throws InterruptedException{
		   selectFromAccount.click();
		   selectFromAccount.clear();
		   selectFromAccount.sendKeys(strFromAccount);
		   selectFromAccount.sendKeys(Keys.ENTER);
		   SeleniumUtils.delay(3000);
		   selectFromAccount.click();
	  	   //SeleniumUtils.delay(3000);
	 }
	 
	 public boolean isFromAccountListDisplayed(){
		   return selectFromAccount.isDisplayed();  	
	 }
	 
	//To Account 
		 public void SelectToAccount(String strToAccount) throws InterruptedException{
			   selectToAccount.click();
			   selectToAccount.clear();
			   selectToAccount.sendKeys(strToAccount);
			   selectToAccount.sendKeys(Keys.ENTER);
			   SeleniumUtils.delay(5000);
			   selectToAccount.click();
			   SeleniumUtils.delay(3000);
		 }
		 
		 public boolean isToAccountListDisplayed(){
			   return selectToAccount.isDisplayed();  	
		 }
		 
		// click on  Transfer Date  button
	      
		   public boolean isTransferDateBtnDisplayed(){
			   return btnTransferDate.isDisplayed();
		    	
		    }
		    public void clickTransferDateButton(){	    	
		    	btnTransferDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectTransferDateMonth));
		    	report.log(LogStatus.PASS, "Clicked on Transfer Date Button");
		    }
		   
		   // Select  Transfer Month from Calander
		    public void selectTransferDateMonth(String TransferMonth){
		    	Select objSelect = new Select(selectTransferDateMonth);
		    	objSelect.selectByVisibleText(TransferMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleTransferDate));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected End Date Month  is: "+TransferMonth);
		    } 
		   
		   public boolean isTransferDateMonthDisplayed(){
			   return selectTransferDateMonth.isDisplayed();
			   
		   }
		   
		   // Select  End Date
		   public void selectTransferDate(String TransferDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//table[contains(@id,'AP2:id1::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(TransferDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected Transfer Date is "+TransferDate);
					   break;
					   
				   }
				  } 
				   
			  }
		   
		   
		 //Transfer Amount  
			 public void enterTransferAmount(String strTransferAmount){
				   SeleniumUtils.delay(3000);
				   txtTransferAmount.click();
				   txtTransferAmount.clear();
				   txtTransferAmount.sendKeys(strTransferAmount);
			  	
			 }
			 
			 public boolean isTransferAmountDisplayed(){
				   return txtTransferAmount.isDisplayed();  	
			 }
			 
		// Business Unit 
			 
			 public void SelectBusinessUnit(String strBusinessUnit) throws InterruptedException{
				   selectBusinessUnit.click();
				   selectBusinessUnit.clear();
				   selectBusinessUnit.sendKeys(strBusinessUnit);
				   selectBusinessUnit.sendKeys(Keys.ENTER);
				   SeleniumUtils.delay(3000);
				   selectBusinessUnit.click();
			  	//SeleniumUtils.delay(3000);
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
				   SeleniumUtils.delay(3000);
				   selectPaymentMethod.click();
			  	//SeleniumUtils.delay(3000);
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
				   SeleniumUtils.delay(3000);
				   selectPaymentProfile.click();
			  	//SeleniumUtils.delay(3000);
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
		
		 report.log(LogStatus.PASS, "Create Bank Account Transfer Page is Loaded Successfully");
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Bank Account Transfer Page</span></a>");
	   	return new Item(xyz);

	}


}
