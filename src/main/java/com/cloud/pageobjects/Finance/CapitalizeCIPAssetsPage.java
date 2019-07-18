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

public class CapitalizeCIPAssetsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP1:q1:value20::content')]")
	    private WebElement txtAssetNumber;
	 
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP1:q1:value30::content')]")
	    private WebElement txtDescription;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'AP1:q1:value40::content')]")
	    private WebElement selectAssetType;
	
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP1:q1::search')]")
	    private WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:tbl1:_ATp:t1::db')]/table/tbody/tr/td[1]")
	    private WebElement tbleCapitalizeCIPAssets;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP1:tbl1:_ATp:commandButton1')]")
	    private WebElement btnCapitalize;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'AP1:dpis::glyph')]")
	   private WebElement btnDatePlacedinService;

	@FindBy(how=How.XPATH, using = "//select[contains(@id,'AP1:dpis::pop::cd::mSel::content')]")
	   private WebElement selectDatePlacedinServiceMonth;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:dpis::pop::cd::cg')]")
	   private WebElement tbleDatePlacedinServiceDate;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'AP1:cb1')]")
	   private WebElement btnOk_DatePlacedService;
	
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP1:commandButton2')]")
	    private WebElement btnDone;
	 
	
	
	 
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public CapitalizeCIPAssetsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(btnDone));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Capitalize CIP Assets Page *****************************");
		       this.getScreenDetails();
		    }
	    
	  //Value for Asset Number
		   
		   public void enterAssetNumber(String strAssetNumber) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   txtAssetNumber.clear();
			   txtAssetNumber.click();
			   txtAssetNumber.sendKeys(strAssetNumber);
			   txtDescription.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isAssetNumberDisplayed(){
			   return txtAssetNumber.isDisplayed();
			   } 
		   
	   // Select Asset Type list
		   public void selectAssetTypeList(String strAssetType){
			   SeleniumUtils.delay(3000);
			   Select objSelect=new Select(selectAssetType);
			   objSelect.selectByVisibleText(strAssetType);
			 
		   }
		   
		   public boolean isAssetTypeListDisplayed(){
			   return txtAssetNumber.isDisplayed();
			   } 
		// Search button
		   
		   public void clickSearchButton(){
			 //SeleniumUtils.delay(2000);
			   btnSearch.click();
			   wdwait.until(ExpectedConditions.visibilityOf(tbleCapitalizeCIPAssets));
			   report.log(LogStatus.PASS, "Clicked on Search Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isSearchBtnDisplayed(){
			   return btnSearch.isDisplayed();
		   }
		   
		 //Select Event (select given text from dropdown)
		   public void selectEvent(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'AP1:tbl1:_ATp:t1::db')]//div//td[contains(.,'"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		   // Capitalize button
		   
		   public void clickCapitalizeButton(){
			 //SeleniumUtils.delay(2000);
			   btnCapitalize.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnDatePlacedinService));
			   report.log(LogStatus.PASS, "Clicked on Capitalize Button");
			   this.getScreenDetails("New Date Placed in Service Pop-up"); 
		   }
		   
		   public boolean isCapitalizeBtnDisplayed(){
			   return btnCapitalize.isDisplayed();
		   }
		   
		   // Done button
		   
		   public void clickDoneButton(){
			   SeleniumUtils.delay(2000);
			   btnDone.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
			   report.log(LogStatus.PASS, "Clicked on Done Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isDoneBtnDisplayed(){
			   return btnDone.isDisplayed();
		   }
		   
		// click on  Date Placed in Service button
		   
		   public boolean isDatePlacedinServiceBtnDisplayed(){
			   return btnDatePlacedinService.isDisplayed();
		    	
		    }
		    public void clickDatePlacedinServiceButton(){
		    	SeleniumUtils.delay(5000);
		    	btnDatePlacedinService.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectDatePlacedinServiceMonth));
		    	report.log(LogStatus.PASS, "Clicked on Date Placed in Service Button");
		    }
		   
		   // Select  Conversion Month from Calander
		    public void selectDatePlacedinServiceMonth(String conversionMonth){
		    	Select objSelect = new Select(selectDatePlacedinServiceMonth);
		    	objSelect.selectByVisibleText(conversionMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleDatePlacedinServiceDate));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected Date Placed in Service Month  is: "+conversionMonth);
		    } 
		   
		   public boolean isDatePlacedinServiceMonthDisplayed(){
			   return selectDatePlacedinServiceMonth.isDisplayed();
			   
		   }
		   
		   // Select  Conversion Date
		   public void selectDatePlacedinServiceDate(String conversionDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'AP1:dpis::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(conversionDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected Placed in Service Date is "+conversionDate);
					   this.getScreenDetails("New Date Placed in Service Pop-up");
					   break;
					   
				   }
				  } 
				   
			  }
		   
 // btnOk_DatePlacedService
		   
		   public void clickOk_DatePlacedServiceButton(){
			   SeleniumUtils.delay(2000);
			   btnOk_DatePlacedService.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(btnDone));
			   report.log(LogStatus.PASS, "Clicked on Ok Button");
			   this.getScreenDetails();
			   SeleniumUtils.delay(5000);
		   }
		   
		   public boolean isOk_DatePlacedServiceBtnDisplayed(){
			   return btnOk_DatePlacedService.isDisplayed();
		   }
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Capitalize CIP Assets page is Loaded Successfully");
	    	 if(btnDone.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Capitalize CIP Assets Page</span></a>");
		   	return new Item(xyz);
	   }


}
