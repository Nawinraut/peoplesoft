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

public class ReinstateAssetsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:q1:value30::content')]")
	    private WebElement txtAssetNumber;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'AP2:q1:value10::glyph')]")
	    private WebElement btnFromRetirementDate;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'AP2:q1:value10::pop::cd::mSel::content')]")
	    private WebElement selectFromRetirementMonth;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'AP2:q1:value10::pop::cd::cg')]")
	    private WebElement tbleFromRetirementDate;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP2:q1::search')]")
	    private WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'_ATp:table1::db')]//td[1]")
	    private WebElement tbleAssets;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'QueryResultId:_ATp:commandButton4')]")
	    private WebElement btnReinstate;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'QueryResultId:commandButton3')]")
	    private WebElement btnWarningYes;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP2:commandButton5')]")
	    private WebElement btnDone;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ReinstateAssetsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(txtAssetNumber));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Reinstate Assets Page *****************************");
		       this.getScreenDetails();
		    }
	    
	 // click on  End Date button
	      
		   public boolean isFromRetirementDateBtnDisplayed(){
			   return btnFromRetirementDate.isDisplayed();
		    	
		    }
		    public void clickFromRetirementDateButton(){	    	
		    	btnFromRetirementDate.click();
		    	 wdwait.until(ExpectedConditions.visibilityOf(selectFromRetirementMonth));
		    	report.log(LogStatus.PASS, "Clicked on From Retirement Date Button");
		    }
		   
		   // Select  End Month from Calander
		    public void selectFromRetirementMonth(String fromMonth){
		    	Select objSelect = new Select(selectFromRetirementMonth);
		    	objSelect.selectByVisibleText(fromMonth);
		    	 wdwait.until(ExpectedConditions.visibilityOf(tbleFromRetirementDate));
		    	//SeleniumUtils.delay(5000);
		    	report.log(LogStatus.PASS, "Selected From Retirement Month  is: "+fromMonth);
		    } 
		   
		   public boolean isFromRetirementMonthDisplayed(){
			   return selectFromRetirementMonth.isDisplayed();
			   
		   }
		   
		   // Select  FromRetirementDate
		   public void selectFromRetirementDate(String fromDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,'AP2:q1:value10::pop::cd::cg')]//td"));  
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(fromDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Retirement Date is "+fromDate);
					   break;
					   
				   }
				  } 
				   
			  }
	    
	  //Value for Asset Number
		   
		   public void enterAssetNumber(String strAssetNumber) throws InterruptedException{
			   SeleniumUtils.delay(3000);
			   txtAssetNumber.clear();
			   txtAssetNumber.click();
			   txtAssetNumber.sendKeys(strAssetNumber);
			   txtAssetNumber.click();
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
			   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_ATp:table1::db')]//div//td[contains(.,'"+eventName+"')]")));
			   SeleniumUtils.delay(2000);
			   eventLink.click(); 
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
			   }
		   
		   // Reinstate button
		   
		   public void clickReinstateButton(){
			 //SeleniumUtils.delay(2000);
			   btnReinstate.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnWarningYes));
			   report.log(LogStatus.PASS, "Clicked on Reinstate Button");
			   
		   }
		   
		   public boolean isReinstateBtnDisplayed(){
			   return btnReinstate.isDisplayed();
		   }
		   
		   // Warning Yes
		   public void clickWarningYesButton(){
				 //SeleniumUtils.delay(2000);
				   btnWarningYes.click();
				   SeleniumUtils.delay(2000);
				  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
				   report.log(LogStatus.PASS, "Clicked on Warning Yes Button");
				   this.getScreenDetails();
			   }
			   
			   public boolean isWarningYesBtnDisplayed(){
				   return btnWarningYes.isDisplayed();
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
			
			 report.log(LogStatus.PASS, "Reinstate Assets page is Loaded Successfully");
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Reinstate Assets Page</span></a>");
		   	return new Item(xyz);
	   }


}
