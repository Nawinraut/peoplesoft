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

public class ManageAdjustmentsPage extends BasePageObject{

public WebDriver driver;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'create::icon')]")
    private WebElement btnCreate;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'actvty::content')]")
    private WebElement selectReceivablesActivity;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'selectOneChoice1::content')]")
    private WebElement selectAdjustmentType;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'selectOneChoice2::content')]")
    private WebElement selectAdjustmentReason;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'AT1:saveBtn1')]")
    private WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'msgDlg::cancel')]")
    private WebElement btnInfOk;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'activeCommandToolbarButton1')]")
    private WebElement btnDone;
	
	public WebDriverWait wdwait;
	
	public ManageAdjustmentsPage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(btnCreate));
	     if (!isDisplayed()) {
	            throw new TestException(this.getClass().getName() + " is not loaded");
	        }
	     
	        System.out.println("******************************* Manage Adjustments Page *****************************");
	       this.getScreenDetails();
	    }
	
	
	// Create Button  
	   public void clickCreateButton(){	
		   btnCreate.click();
		   wdwait.until(ExpectedConditions.visibilityOf(selectReceivablesActivity));
		   report.log(LogStatus.PASS, "Clicked on Create button");
		   this.getScreenDetails();
	   }
	   
	   public boolean isCreateBtnDisplayed(){
		   return btnCreate.isDisplayed();
	   	
	   }
	   
	 //Receivables Activity list
	   public void SelectReceivablesActivity(String strBusinessUnit) throws InterruptedException{
	   	selectReceivablesActivity.click();
	   	selectReceivablesActivity.sendKeys(strBusinessUnit);
	   	selectReceivablesActivity.sendKeys(Keys.ENTER);
	   	selectReceivablesActivity.click();
	   	//SeleniumUtils.delay(2000);
	    
	   }
	   
	   public boolean isReceivablesActivityDisplayed(){
		   return selectReceivablesActivity.isDisplayed();
		   } 
	   
	   //Adjustment Type 
	   
	   public void SelectAdjustmentType(String strAdjustmentType) throws InterruptedException{
		   SeleniumUtils.delay(2000);
	    	Select objSelect = new Select(selectAdjustmentType);
	    	objSelect.selectByVisibleText(strAdjustmentType);
	    	SeleniumUtils.delay(2000);
		    
		   }
		   
		   public boolean isAdjustmentTypeDisplayed(){
			   return selectAdjustmentType.isDisplayed();
			   } 
		   
		 //Adjustment Reason 
		   
		   public void SelectAdjustmentReason(String strAdjustmentReason) throws InterruptedException{
			   SeleniumUtils.delay(2000);
		    	Select objSelect = new Select(selectAdjustmentReason);
		    	objSelect.selectByVisibleText(strAdjustmentReason);
		    	SeleniumUtils.delay(2000);
			    
			   }
			   
		   public boolean isAdjustmentReasonDisplayed(){
			   return selectAdjustmentReason.isDisplayed();
			   } 
		   
		// submit button
		   
		   public void clickSubmitButton(){
			 SeleniumUtils.delay(2000);
			   btnSubmit.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnInfOk));
			   report.log(LogStatus.PASS, "Clicked on Submit Button");
			   this.getScreenDetails("Information Pop-up");
		   }
		   
		   public boolean isSubmitBtnDisplayed(){
			   return btnSubmit.isDisplayed();
		   	
		   }
		   
		// Information Ok Button
		   public boolean isInfOkButtonDisplayed(){
			   return btnInfOk.isDisplayed();  	
		   }  
		   
		   public void clickInfOkButton(){	
			   btnInfOk.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Information Ok Button");
		   }
	
		// Done Button
		   public boolean isDoneButtonDisplayed(){
			   return btnDone.isDisplayed();  	
		   }  
		   
		 /*  public void clickDoneButton(){	
			   btnDone.click();
			   SeleniumUtils.delay(2000);
			   report.log(LogStatus.PASS, "Clicked on Done Button");
		   }*/
		   
		   public ReviewTransactionPage clickDoneButton() throws TestException{	
			   btnDone.click();
			   report.log(LogStatus.PASS, "Clicked on Done Button");
			   return new ReviewTransactionPage(driver,report);
		   }
		   
	
	@Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Manage Adjustments Page is Loaded Successfully");
    	 if(btnCreate.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Manage Adjustments Page</span></a>");
	   	return new Item(xyz);
   }

}
