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

public class ChangeFinancialDetailsPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//input[contains(@id,'AP2:methodCodeId::content')]")
	    private WebElement selectDeprMethod;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'AP2:LifeYearId::content')]")
	    private WebElement selectLifeinYears;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(@id,'AP2:commandButton1')]")
	    private WebElement btnSubmit;
	 
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    
	    
	    public ChangeFinancialDetailsPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(selectDeprMethod));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		     
		        System.out.println("******************************* Change Financial Details Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	  //Depreciation Method
		   
		   public void selectDepreciationMethod(String strDeprMethod) throws InterruptedException{
			   selectDeprMethod.clear();
			   selectDeprMethod.click();
			   selectDeprMethod.sendKeys(strDeprMethod);
			   selectDeprMethod.sendKeys(Keys.ENTER);
			   selectDeprMethod.click();
			  // report.log(LogStatus.PASS, "Entered value for Nameis: "+value);
		   }
		   
		   public boolean isDepreciationMethodDisplayed(){
			   return selectDeprMethod.isDisplayed();
			   } 
		   
	    //Life in Years 
		   
		   public void selectLifeInYears(String strLifeinYears) throws InterruptedException{
			   SeleniumUtils.delay(2000);
			   Select objSelect = new Select(selectLifeinYears);
			   objSelect.selectByVisibleText(strLifeinYears);
			   this.getScreenDetails();
			   
		   }
		   
		   public boolean isLifeInYearsDisplayed(){
			   return selectLifeinYears.isDisplayed();
			   } 
		   
		   // Submit button
		   
		   public void clickSubmitButton(){
			   SeleniumUtils.delay(2000);
			   btnSubmit.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(tbleAssets));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			   this.getScreenDetails();
			   SeleniumUtils.delay(2000);
		   }
		   
		   public boolean isSubmitBtnDisplayed(){
			   return btnSubmit.isDisplayed();
		   }
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Change Financial Details page is Loaded Successfully");
	    	 if(selectDeprMethod.isDisplayed())
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
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Change Financial Details Page</span></a>");
		   	return new Item(xyz);
	   }

}
