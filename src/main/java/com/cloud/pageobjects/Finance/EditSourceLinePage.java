package com.cloud.pageobjects.Finance;

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

public class EditSourceLinePage extends BasePageObject{
	
public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'ap1:queueName1::content')]")
    private WebElement selectQueue;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ap1:inputText4::content')]")
	    private WebElement txtAssetNumber;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'ap1:descriptionId1::content')]")
	    private WebElement txtDescription;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'categoryFlexField1KBIMG::icon')]")
	    private WebElement btnCategory;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'categoryFlexField1SPOP_query:value00::content')]")
	    private WebElement txtMajor;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'categoryFlexField1SPOP_query:value10::content')]")
	    private WebElement txtMinor;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'categoryFlexField1SEl')]")
	    private WebElement btnCategoryOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AdditionCatDFFVOIteratorclassCode__FLEX_EMPTY::content')]")
	    private WebElement selectClassCode;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table1:0:employeeNameId::content')]")
	    private WebElement selectEmployeeName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATp:table1:0:employeeNameId::lovIconId')]")
	    private WebElement iconEmployeeName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'dropdownPopup::popupsearch')]")
	    private WebElement lnkSearchEmployeeName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId:value00::content')]")
	    private WebElement txtEmployeeName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'afrLovInternalQueryId::search')]")
	    private WebElement btnSearchEmployeeName;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'lovDialogId::ok')]")
	    private WebElement btnOkEmployeeName;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table1:0:kf3CS::content')]")
	    private WebElement txtDepreciationExpAccount;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ATp:table1:0:kf1KBIMG::icon')]")
	    private WebElement btnLocation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_query:value00::lovIconId')]")
	    private WebElement srchLocation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'kf1SEl')]")
	    private WebElement btnLocationOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ap1:saveButton1')]/table/tbody/tr/td[1]/a")
	    private WebElement btnSaveAndClose;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public EditSourceLinePage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(selectQueue));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Edit Source Line Page *****************************");
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
	    
	  //Enter text into Asset Number field
		   public void enterAssetNumber(String number){
			   SeleniumUtils.delay(2000);
			   txtAssetNumber.clear();
			   txtAssetNumber.click();
			   txtAssetNumber.sendKeys(number);
			  
		   }
		   
		   public boolean isAssetNumberDisplayed(){
			   return txtAssetNumber.isDisplayed();
			   }
		   
		   //Enter text into Description field
		   public void enterDescription(String number){
			   txtDescription.clear();
			   txtDescription.click();
			   txtDescription.sendKeys(number);
			  
		   }
		   
		   public boolean isDescriptionDisplayed(){
			   return txtDescription.isDisplayed();
			   }  
		   
		// Category button   
		   public boolean isCategoryButtonDisplayed(){
			   return btnCategory.isDisplayed();  	
		   }  
	   
		   public void clickCategoryButton(){
			   SeleniumUtils.delay(2000);
			   btnCategory.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtMajor));
			   report.log(LogStatus.PASS, "Clicked on Category button Button");
			  
		   } 
		   
		   // Major list
		   public void SelectMajor(String strMajor) throws InterruptedException{
			   this.getScreenDetails();
			   SeleniumUtils.delay(2000);
			   txtMajor.click();
			   txtMajor.sendKeys(strMajor);
			  // txtMajor.sendKeys(Keys.ARROW_DOWN);
			   txtMajor.sendKeys(Keys.ENTER);
			   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMajor+"')]")));
		   	//SeleniumUtils.delay(3000);
		   // report.log(LogStatus.PASS, "Selected Major  is: "+strMajor);
		   }
		   
		   public boolean isSelectMajorDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtMajor, context.getReactTimeout());
			   } 
		   
		// Minor list
		   public void SelectMinor(String strMinor) throws InterruptedException{
			   SeleniumUtils.delay(2000);
			   txtMinor.click();
			   txtMinor.sendKeys(strMinor);
			  // txtMajor.sendKeys(Keys.ARROW_DOWN);
			   txtMinor.sendKeys(Keys.ENTER);
			   wdwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr//td[contains(text(), '"+strMinor+"')]")));
			   
		   		//SeleniumUtils.delay(3000);
		   // report.log(LogStatus.PASS, "Selected Minor  is: "+strMinor);
		    this.getScreenDetails();
		   }
		   
		   public boolean isSelectMinorDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtMinor, context.getReactTimeout());
			   }  
		   
		   // Click on Major field
		   public void clickMajorText(){
			   txtMajor.click();
		   } 
		// Category Ok button   
		   public boolean isCategoryOkButtonDisplayed(){
			   return btnCategoryOk.isDisplayed();  
			   
		   }  
	   
		   public void clickCategoryOkButton(){
			   btnCategoryOk.click();
			   report.log(LogStatus.PASS, "Clicked on Category Ok button Button");
			  
		   } 
		   
		// Class Code list
		   public void SelectClassCodeList(String strClassCode) throws InterruptedException{
			   SeleniumUtils.delay(2000);
			   selectClassCode.clear();
			   selectClassCode.click();
			   selectClassCode.sendKeys(strClassCode);
			  // txtMajor.sendKeys(Keys.ARROW_DOWN);
			   selectClassCode.sendKeys(Keys.ENTER);
			   selectClassCode.click();
			   //this.getScreenDetails();
		   }
		   
		   public boolean isClassCodeListDisplayed(){
			   return selectClassCode.isDisplayed();
			   } 
		   // Employee  Name
		   public void selectEmployeeName(String strEmployeeName) throws InterruptedException{
			   SeleniumUtils.delay(2000);
			   selectEmployeeName.clear();
			   selectEmployeeName.click();
			   selectEmployeeName.sendKeys(strEmployeeName);
			   selectEmployeeName.sendKeys(Keys.ENTER);
			   selectEmployeeName.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isEmployeeNameDisplayed(){
			   return selectEmployeeName.isDisplayed();
			   }
		   // Depreciation Expense AccountField
		   public void enterDepreciationExpenseAccountField(String strDepreciationExpAccount) throws InterruptedException{
			   SeleniumUtils.delay(2000);
			   txtDepreciationExpAccount.clear();
			   txtDepreciationExpAccount.click();
			   txtDepreciationExpAccount.sendKeys(strDepreciationExpAccount);
			   txtDepreciationExpAccount.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isDepreciationExpenseAccountFieldDisplayed(){
			   return txtDepreciationExpAccount.isDisplayed();
			   }
		   // Location button
		   
		   public void clickLocationButton(){
			 //SeleniumUtils.delay(2000);
			   btnLocation.click();
			   wdwait.until(ExpectedConditions.visibilityOf(srchLocation));
			   report.log(LogStatus.PASS, "Clicked on Location Button");
			   SeleniumUtils.delay(2000);
			   this.getScreenDetails();
		   }
		   
		   public boolean isLocation_Field2BtnDisplayed(){
			   return btnLocation.isDisplayed();
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
				 	SeleniumUtils.delay(2000);
			   		btnLocationOk.click();
				  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
				   report.log(LogStatus.PASS, "Clicked on Ok Button");
				   SeleniumUtils.delay(2000);
				   this.getScreenDetails();
			   }
			   
			   public boolean isLocationOkBtnDisplayed(){
				   return btnLocationOk.isDisplayed();
			   } 
			// Save and Close
			   public void clickSaveAndCloseButton(){
					 //SeleniumUtils.delay(2000);
				   btnSaveAndClose.click();
					  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
					   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
					   SeleniumUtils.delay(2000);
					   this.getScreenDetails();
				   }
				   
				   public boolean isSaveAndCloseBtnDisplayed(){
					   return btnSaveAndClose.isDisplayed();
				   } 
			   
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Edit Source Line page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Edit Source Line Page</span></a>");
		   	return new Item(xyz);
	   }

}
