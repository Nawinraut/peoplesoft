package com.cloud.pageobjects.Finance;

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

public class CreatePayeePage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ap1:lessN::content')]")
	    private WebElement txtName;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ap1:lessD::content')]")
	    private WebElement txtDescription;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:APsv2')]")
	    private WebElement btnSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:d2::yes')]")
	    private WebElement btnWarningYes;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'ap1:AT1:_ATp:create::icon')]")
	    private WebElement btnCreate;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:_ATp:ATt1::db')]//table//div//td[1]")
	    private WebElement tableBankAccounts;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'it7::content')]")
	    private WebElement txtAccountNumber;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'soc2::content')]")
	    private WebElement selectCurrency;
	
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'soc1::content')]")
	    private WebElement selectAccountType;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'it6::content')]")
	    private WebElement txtBank;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'it3::content')]")
	    private WebElement txtBankBranch;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'it5::content')]")
	    private WebElement txtRoutingNumber;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:AT1:FAsc1')]")
	    private WebElement btnOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:APscl2')]")
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
   
	    
	 public CreatePayeePage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(txtName));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     
	        System.out.println("******************************* Create Payee Page *****************************");
	       this.getScreenDetails();
	    }
	 
	// Name
	   public void enterName(String strName) {
		  
		   txtName.click();
		   txtName.clear();
		   txtName.sendKeys(strName);
	    	//SeleniumUtils.delay(3000);
	   }
	   
	   public boolean isNameFieldDisplayed(){
		   return txtName.isDisplayed();  	
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
	   
	// click on  Save button
	      
	   public boolean isSaveBtnDisplayed(){
		   return btnSave.isDisplayed();
	    	
	    }
	    public void clickSaveButton(){	    	
	    	btnSave.click();
	    	
	    	/*if(btnWarningYes.isDisplayed()) {
	    		btnWarningYes.click();
	    	}*/
	    	 //wdwait.until(ExpectedConditions.visibilityOf(selectEndDateMonth));
	    	report.log(LogStatus.PASS, "Clicked on Save Button");
	    	SeleniumUtils.delay(5000);
	    }
	    
	    //Warning Yes button
	    public boolean isWarningYesBtnDisplayed(){
			   return btnWarningYes.isDisplayed();
		    	
		    }
		    public void clickWarningYesButton(){	    	
		    	btnWarningYes.click(); 
		    	report.log(LogStatus.PASS, "Clicked on Warning Yes Button");
		    	
		    }
	    
	 // click on  Create button
	      
		   public boolean isCreateBtnDisplayed(){
			   return btnCreate.isDisplayed();
		    	
		    }
		    public void clickCreateButton(){
		    	SeleniumUtils.delay(3000);
		    	btnCreate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(txtAccountNumber));
		    	report.log(LogStatus.PASS, "Clicked on Create Button");
		    	 this.getScreenDetails("Create Bank Account Pop-up");
		    }
		    
		 // AccountNumber
			   public void enterAccountNumber(String strAccountNumber) {
				   txtAccountNumber.click();
				   txtAccountNumber.clear();
				   txtAccountNumber.sendKeys(strAccountNumber);
				   
			    	//SeleniumUtils.delay(3000);
			   }
			   
			   public boolean isAccountNumberFieldDisplayed(){
				   return txtAccountNumber.isDisplayed();  	
			   }
			   
		//Currency	
			   
			   public void SelectCurrency(String strCurrency) {
				  Select objSelect=new Select(selectCurrency);
				  objSelect.selectByVisibleText(strCurrency);
			    	//SeleniumUtils.delay(3000);
			   }
			   
			   public boolean isCurrencyListDisplayed(){
				   return selectCurrency.isDisplayed();  	
			   }
			   
	//Account Type	
			   
			   public void SelectAccountType(String strAccountType) {
				  //SeleniumUtils.delay(5000);
				  Select objSelect=new Select(selectAccountType);
				  objSelect.selectByVisibleText(strAccountType);
			    	
			   }
			   
			   public boolean isAccountTypeListDisplayed(){
				   return selectAccountType.isDisplayed();  	
			   }
			   
			// Bank
			   public void enterBank(String strBank) {
				   txtBank.click();
				   txtBank.clear();
				   txtBank.sendKeys(strBank);
			    	//SeleniumUtils.delay(3000);
			   }
			   
			   public boolean isBankFieldDisplayed(){
				   return txtBank.isDisplayed();  	
			   }
			   
			// Bank Branch
			   public void enterBankBranch(String strBankBranch) {
				   txtBankBranch.click();
				   txtBankBranch.clear();
				   txtBankBranch.sendKeys(strBankBranch);
			    	//SeleniumUtils.delay(3000);
			   }
			   
			   public boolean isBankBranchFieldDisplayed(){
				   return txtBankBranch.isDisplayed();  	
			   }  
			   
			// Routing Number
			   public void enterRoutingNumber(String strRoutingNumber) {
				   txtRoutingNumber.click();
				   txtRoutingNumber.clear();
				   txtRoutingNumber.sendKeys(strRoutingNumber);
			    	//SeleniumUtils.delay(3000);
			   }
			   
			   public boolean isRoutingNumberFieldDisplayed(){
				   return txtRoutingNumber.isDisplayed();  	
			   } 
			   
			   // click on  Ok button
			      
			   public boolean isOkBtnDisplayed(){
				   return btnOk.isDisplayed();
			    	
			    }
			    public void clickOkButton(){	    	
			    	btnOk.click();
			    	 wdwait.until(ExpectedConditions.visibilityOf(tableBankAccounts));
			    	report.log(LogStatus.PASS, "Clicked on Ok Button");
			    	 this.getScreenDetails();
			    }
			    
			    // click on  SaveAndClose button
			      
				   public boolean isSaveAndCloseBtnDisplayed(){
					   return btnSaveAndClose.isDisplayed();
				    	
				    }
				    public void clickSaveAndCloseButton(){	    	
				    	btnSaveAndClose.click();
				    	SeleniumUtils.delay(2000);
				    	/*if(btnWarningYes.isDisplayed()) {
				    		btnWarningYes.click();
				    	}*/
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
			
			 report.log(LogStatus.PASS, "Create Payee page is Loaded Successfully");
	    	 if(txtName.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Create Payee Page</span></a>");
		   	return new Item(xyz);
	   
		}

}
