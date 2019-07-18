package com.cloud.pageobjects.Finance;

import org.openqa.selenium.JavascriptExecutor;
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

public class ReprintPaymentDocuments_PaymentFilePage extends BasePageObject{
	
public WebDriver driver;
	
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:commandButton4')]")
    private WebElement btnContinue;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:commandButton2')]")
    private WebElement btnContinue2;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,'ap1:ReprintActionSelection::content')]")
    private WebElement selectAction;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,'ap1:commandButton3')]")
    private WebElement btnRePrintContinue;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,'_FOd1::msgDlg::cancel')]")
    private WebElement btnConfOk;
	
public WebDriverWait wdwait; 
    
	/**
	* Initializing page objects for Manage Journals Page.
	* @author Ciber
	* @param driver
	* @return
	* @throws TestException
	*/
    
    
    public ReprintPaymentDocuments_PaymentFilePage(WebDriver driver, ExtentTest report) throws TestException {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 60);
	     PageFactory.initElements(driver, this);
	     
	     wdwait.until(ExpectedConditions.visibilityOf(btnContinue));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	    
	        System.out.println("******************************* Reprint Payment Documents:Payment File Page *****************************");
	       this.getScreenDetails();
	    }
    
    
    public void selectActionList(String Action) {
    	 SeleniumUtils.delay(5000);
    	Select objSelect=new Select(selectAction);
    	objSelect.selectByVisibleText(Action);
    	selectAction.sendKeys(Keys.TAB);
    	SeleniumUtils.delay(10000);
    	
    }
    
  //Confirmation Ok
	   
	   public void clickConfOkButton() throws TestException{
		   SeleniumUtils.delay(20000);
		   if(btnConfOk.isDisplayed()){
			   btnConfOk.click();
			   btnContinue.click();
		   }
		   
	   }
	   
	   public boolean isConfOkBtnDisplayed(){
		   return btnConfOk.isDisplayed();
	   }
    
    public void clickContinueButton(){	
		   
		   JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", btnContinue);
	    	
	    	 SeleniumUtils.delay(20000);
			   if(btnConfOk.isDisplayed()){
				   btnConfOk.click();
				   SeleniumUtils.delay(5000);
				   btnContinue2.click();
				   wdwait.until(ExpectedConditions.visibilityOf(btnRePrintContinue));
			   }
	    	//btnTasks.click();
	    	//wdwait.until(ExpectedConditions.visibilityOf(lnkCreateAccouinting));
	    	
		  // wdwait.until(ExpectedConditions.visibilityOf(btnRePrintContinue));
		  // btnFormat.click();
		   report.log(LogStatus.PASS, "Clicked on Continue button"); 
		   this.getScreenDetails();
		   
	   }
	   
	   public boolean isContinueBtnDisplayed(){
		   return btnContinue.isDisplayed();
	   }
	   
	   
	   public PaymentFilePage clickRePrintContinue() throws TestException{
		   //SeleniumUtils.delay(8000);
		   btnRePrintContinue.click();
		   report.log(LogStatus.PASS, "Clicked on Reprint Continue Button button"); 
		   return new PaymentFilePage(driver, report);
		   
	   }
	   
	   public boolean isRePrintContinueBtnDisplayed(){
		   return btnRePrintContinue.isDisplayed();
	   }
	   
    @Override
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		//return  btnTasks.isDisplayed();
		
		 report.log(LogStatus.PASS, "Reprint Payment Documents:Payment File Page is Loaded Successfully");
		 if(btnContinue.isDisplayed())
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
	   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Reprint Payment Documents:Payment File Page</span></a>");
	   	return new Item(xyz);
   }


}
