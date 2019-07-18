package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TransferAsset_AssetPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ATp:table1:0:newUnits::content')]")
	    private WebElement txtNewUnits_R1;
	 
	 @FindBy(how=How.XPATH, using = "//img[contains(@id,'AP1:AT2:_ATp:create::icon')]")
	    private WebElement btnAddRow;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ATp:table1:1:newUnits::content')]")
	    private WebElement txtNewUnits_R2;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ATp:table1:1:employeeId::content')]")
	    private WebElement selectEmployeeName_R2;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ATp:table1:1:kf1CS::content')]")
	    private WebElement txtDeprExpAccountField_R2;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ATp:table1:1:kf3CS::content')]")
	    private WebElement selectLocationField_R2;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATp:table1:1:kf3KBIMG::icon')]")
	    private WebElement btnLocation_R2;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'kf3SPOP_query:value00::lovIconId')]")
	    private WebElement srchLocation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'kf3SEl')]")
	    private WebElement btnLocationOk;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP1:commandButton2')]")
	    private WebElement btnSubmit;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public TransferAsset_AssetPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnAddRow));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Transfer Asset Page *****************************");
		       this.getScreenDetails();
		    }
	    
	  //Value New Units field Row1
		   
		   public void enterNewUnitsField1(String strAssetNumber) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   txtNewUnits_R1.clear();
			   txtNewUnits_R1.click();
			   txtNewUnits_R1.sendKeys(strAssetNumber);
			   txtNewUnits_R1.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isNewUnitsField1Displayed(){
			   return txtNewUnits_R1.isDisplayed();
			   } 
		   // Add Row button
		   
		   public void clickAddRowButton(){
			 
			   btnAddRow.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtNewUnits_R2));
			   report.log(LogStatus.PASS, "Clicked on Add Row Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isAddRowBtnDisplayed(){
			   return btnAddRow.isDisplayed();
		   }
		   
		   //Value New Units field Row2
		   
		   public void enterNewUnitsField2(String strAssetNumber) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   txtNewUnits_R2.clear();
			   txtNewUnits_R2.click();
			   txtNewUnits_R2.sendKeys(strAssetNumber);
			   txtNewUnits_R2.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isNewUnitsField2Displayed(){
			   return txtNewUnits_R2.isDisplayed();
			   } 
		   
		   //Value employee Name field Row2
		   
		   public void selectEmployeeNameField2(String strAssetNumber) throws InterruptedException{
			   selectEmployeeName_R2.clear();
			   selectEmployeeName_R2.click();
			   selectEmployeeName_R2.sendKeys(strAssetNumber);
			   selectEmployeeName_R2.sendKeys(Keys.ENTER);
			   selectEmployeeName_R2.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isEmployeeNameField2Displayed(){
			   return selectEmployeeName_R2.isDisplayed();
			   } 
		   //Value Depreciation Expense Account  field Row2
		   
		   public void enterDepreciationExpenseAccountField2(String strAssetNumber) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   txtDeprExpAccountField_R2.clear();
			   txtDeprExpAccountField_R2.click();
			   txtDeprExpAccountField_R2.sendKeys(strAssetNumber);
			   txtDeprExpAccountField_R2.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isDepreciationExpenseAccountField2Displayed(){
			   return txtDeprExpAccountField_R2.isDisplayed();
			   }
		   //Value Location field Row2
		   
		   public void selectLocationField2(String strAssetNumber) throws InterruptedException{
			   selectLocationField_R2.clear();
			   selectLocationField_R2.click();
			   selectLocationField_R2.sendKeys(strAssetNumber);
			   selectLocationField_R2.sendKeys(Keys.ENTER);
			   selectLocationField_R2.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isLocationField2Displayed(){
			   return selectLocationField_R2.isDisplayed();
			   } 
		   
		   // Submit button
		   
		   public void clickSubmitButton(){
			 //SeleniumUtils.delay(2000);
			   btnSubmit.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			   SeleniumUtils.delay(2000);
			   this.getScreenDetails();
		   }
		   
		   public boolean isSubmitBtnDisplayed(){
			   return btnSubmit.isDisplayed();
		   } 
		   // Location button
		   
		   public void clickLocation_Field2Button(){
			 //SeleniumUtils.delay(2000);
			   btnLocation_R2.click();
			   wdwait.until(ExpectedConditions.visibilityOf(srchLocation));
			   report.log(LogStatus.PASS, "Clicked on Location Button");
			   SeleniumUtils.delay(2000);
			   this.getScreenDetails();
		   }
		   
		   public boolean isLocation_Field2BtnDisplayed(){
			   return btnLocation_R2.isDisplayed();
		   } 
		   
		// Search Location Icon
		   
		   public void clickLocationSearchIcon(String eventName) throws InterruptedException{
			   srchLocation.click();
		    	wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+eventName+"')]")));
			   report.log(LogStatus.PASS, "Clicked on Location Search Icon");
		   }
		   
		   public boolean isLocationSearchIconDisplayed(){
		   
		   //	return SeleniumUtils.isDisplayed(driver, srchLocation, context.getReactTimeout());
		    return srchLocation.isDisplayed();
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
		   // Location Ok
		   public void clickLocationOkButton(){
				 //SeleniumUtils.delay(2000);
			   btnLocationOk.click();
				  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
				   report.log(LogStatus.PASS, "Clicked on Ok Button");
				   SeleniumUtils.delay(2000);
				   this.getScreenDetails();
			   }
			   
			   public boolean isLocationOkBtnDisplayed(){
				   return btnLocationOk.isDisplayed();
			   } 
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Transfer Asset page is Loaded Successfully");
	    	 if(btnAddRow.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Transfer Asset Page</span></a>");
		   	return new Item(xyz);
	   }


}
