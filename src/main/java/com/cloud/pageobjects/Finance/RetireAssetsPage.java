package com.cloud.pageobjects.Finance;

import org.openqa.selenium.By;
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

public class RetireAssetsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 //@FindBy(how=How.XPATH, using = "//input[contains(@id,'AP1:q1:value10::content')]")
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP1:q1:value20::content')]")
	    private WebElement txtAssetNumber;
	 
	 //@FindBy(how=How.XPATH, using = "//input[contains(@id,'AP1:q1:value20::content')]")
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP1:q1:value30::content')]")
	    private WebElement txtDescription;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP1:q1::search')]")
	    private WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AP1:findAssetVCQueryResultId:_ATp:t1::db')]//td[1]")
	    private WebElement tbleAssets;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP1:findAssetVCQueryResultId:_ATp:cb2')]")
	    private WebElement btnRetireCost;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'Searc1:0:AP1:cb1')]")
	    private WebElement btnDone;
	 
	
	//*[contains(@id,'AP1:findAssetVCQueryResultId:_ATp:t1::db')]//div//td[contains(.,'7799')]
	 
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public RetireAssetsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(txtAssetNumber));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Retire Assets Page *****************************");
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
	    
		// Search button
		   
		   public void clickSearchButton(){
			 //SeleniumUtils.delay(2000);
			   btnSearch.click();
			   wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
			   report.log(LogStatus.PASS, "Clicked on Search Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isSearchBtnDisplayed(){
			   return btnSearch.isDisplayed();
		   }
		   
		 //Select Event (select given text from dropdown)
		   public void selectEvent(String eventName) throws InterruptedException { 
			   
			   WebDriverWait wait = new WebDriverWait(driver, 50);
			  // WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/span[contains(text(), '"+eventName+"')]")));
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'AP1:findAssetVCQueryResultId:_ATp:t1::db')]//div//td[contains(.,'"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		   // RetireCost button
		   
		   public RetireCostPage clickRetireCostButton() throws TestException{
			 //SeleniumUtils.delay(2000);
			   btnRetireCost.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
			   report.log(LogStatus.PASS, "Clicked on Retire Cost Button");
			   return new RetireCostPage(driver, report);
		   }
		   
		   public boolean isRetireCostBtnDisplayed(){
			   return btnRetireCost.isDisplayed();
		   }
		   
		   // Done button
		   
		   public void clickDoneButton(){
			 //SeleniumUtils.delay(2000);
			   btnDone.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
			   report.log(LogStatus.PASS, "Clicked on Done Button");
			   this.getScreenDetails();
		   }
		   
		   public boolean isDoneBtnDisplayed(){
			   return btnDone.isDisplayed();
		   }
	    
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Retire Assets page is Loaded Successfully");
	    	 if(txtAssetNumber.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Retire Assets Page</span></a>");
		   	return new Item(xyz);
	   }


}
