package com.cloud.pageobjects.Finance;

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

public class CreateExternalTransactionPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'bankAccountEditId::content')]")
	    private WebElement selectBankAccount;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'businessUnitEditId::content')]")
	    private WebElement selectBusinessUnit;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'cetpanel1:it2::content')]")
	    private WebElement txtAmount;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'cetpanel1:soc1::content')]")
	    private WebElement selectTransactionType;
	 
	 @FindBy(how=How.XPATH, using = "//textarea[contains(@id,'cetpanel1:it3::content')]")
	    private WebElement txtDescription;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'cetpanel1:kf2CS::content')]")
	    private WebElement txtOffsetAccount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'cetpanel1:ctb1')]//table//tr/td[1]/a")
	    private WebElement btnSaveAndClose;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'msgDlg::cancel')]")
	    private WebElement btnInfOk;
	 
	 
public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
    
	    
	    public CreateExternalTransactionPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(selectBankAccount));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Create External Transaction Page *****************************");
		       this.getScreenDetails();
		    }
	    
	   // Bank  Account
		   public void SelectBankAccount(String strBankAccount) throws InterruptedException{
			   //this.getScreenDetails();
			   selectBankAccount.click();
			   selectBankAccount.clear();
			   selectBankAccount.sendKeys(strBankAccount);
			   selectBankAccount.sendKeys(Keys.ENTER);
			   selectBankAccount.click();
		    	SeleniumUtils.delay(3000);
		   }
		   
		   public boolean isBankAccountDisplayed(){
			   return selectBankAccount.isDisplayed();
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
			 
			// Amount  
			 public void enterAmount(String strAmount) throws InterruptedException{
				 SeleniumUtils.delay(3000);
				 txtAmount.click();
				 txtAmount.clear();
				 txtAmount.sendKeys(strAmount);
			  	
			 }
			 
			 public boolean isAmountDisplayed(){
				   return txtAmount.isDisplayed();  	
			 }
			 
			//Transaction Type	
			   
			   public void SelectTransactionType(String strAccountType) {
				  //SeleniumUtils.delay(5000);
				  Select objSelect=new Select(selectTransactionType);
				  objSelect.selectByVisibleText(strAccountType);
			    	
			   }
			   
			   public boolean isTransactionTypeListDisplayed(){
				   return selectTransactionType.isDisplayed();  	
			   }
			// Description
			   public void enterDescription(String strDescription) {
				  
				   txtDescription.click();
				   txtDescription.clear();
				   txtDescription.sendKeys(strDescription);
				   txtDescription.click();
			    	//SeleniumUtils.delay(3000);
			   }
			   
			   public boolean isDescriptionFieldDisplayed(){
				   return txtDescription.isDisplayed();  	
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
			   
			// click on  SaveAndClose button
			      
			   public boolean isSaveAndCloseBtnDisplayed(){
				   return btnSaveAndClose.isDisplayed();
			    	
			    }
			    public void clickSaveAndCloseButton(){	    	
			    	btnSaveAndClose.click();
			    	SeleniumUtils.delay(2000);
			    	 wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
			    	report.log(LogStatus.PASS, "Clicked on Save And Close Button");
			    	 this.getScreenDetails("Information Pop-up");
			    }
			    
		    // click on Information Ok button
		      
			   public boolean isInfOkBtnDisplayed(){
				   return btnInfOk.isDisplayed();
			    	
			    }
			    public void clickInfOkButton(){	
			    	SeleniumUtils.delay(2000);
			    	btnInfOk.click();
			    	// wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
			    	report.log(LogStatus.PASS, "Clicked on Information Ok Button");
			    	 				    }
		   
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Create External Transaction Page is Loaded Successfully");
	    	 if(selectBankAccount.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create External Transaction Page</span></a>");
		   	return new Item(xyz);
	   }

}
