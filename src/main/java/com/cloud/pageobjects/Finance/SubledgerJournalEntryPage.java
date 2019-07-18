package com.cloud.pageobjects.Finance;

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

public class SubledgerJournalEntryPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:cb5')]/table")
	    private WebElement btnPost;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:cb15')]")
	    private WebElement btnWarningOk;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:dialog3::contentContainer')]")
	    private WebElement lblConfirmation;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:dialog3::ok')]")
	    private WebElement btnConfOk;
	 
	 @FindBy(how=How.XPATH, using = "//a[contains(@id,'mjept1:AP1:ctb2')]")
	    private WebElement menuSave;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'mjept1:AP1:cmi4')]")
	    private WebElement lstSaveAndClose;
	
	public WebDriverWait wdwait; 
	 
	 
	 /**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
  
	    
	    public SubledgerJournalEntryPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		     
		     wdwait.until(ExpectedConditions.visibilityOf(btnPost));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Subledger Journal Entry Page *****************************");
		       this.getScreenDetails();
		    }
	    
	    
	 // Post button
		   
		   public boolean isPostButtonDisplayed(){
			   return btnPost.isDisplayed();
		   }
		   
		   public void clickPostButton(){
			   SeleniumUtils.delay(2000);
			   btnPost.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnWarningOk));
			   report.log(LogStatus.PASS, "Clicked on Post Button");   
		   }  
		   
		   // Warning Ok button
		   
		   public boolean isWarningOkButtonDisplayed(){
			   return btnWarningOk.isDisplayed();
		   }
		   
		   public void clickWarningOkButton(){	
			   btnWarningOk.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnConfOk));
			   report.log(LogStatus.PASS, "Clicked on Warning Ok Button");   
		   } 
		   
		   // Confirmation Ok Button
		   public boolean isConfOkBtnDisplayed(){
			   return btnConfOk.isDisplayed();  	
		   }  
	   
		   public void clickConfOkButton(){
			   String ConfMsg=lblConfirmation.getText();
			   btnConfOk.click();
			   report.log(LogStatus.PASS, ""+ConfMsg+" Clicked on Confirmation Ok Button"); 
		   }  
		   
		   //Save Menu
		   
		   public boolean isSaveMenuDisplayed(){
			   return menuSave.isDisplayed();
		   }
		   
		   public void clicSaveMenu(){	
			   SeleniumUtils.delay(2000);
			   menuSave.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lstSaveAndClose));
			   report.log(LogStatus.PASS, "Clicked on Save Menu");   
		   } 
		   
		   //Save and Close List
		   
		   public boolean isSaveAndCloseDisplayed(){
			   return lstSaveAndClose.isDisplayed();
		   }
		   
		   public void clicSaveAndCloseList(){	
			   lstSaveAndClose.click();
			  
			   report.log(LogStatus.PASS, "Clicked on Save and Close List");   
		   }  
	    
	    @Override
			public boolean isDisplayed() {
				// TODO Auto-generated method stub
				//return  btnTasks.isDisplayed();
				
				 report.log(LogStatus.PASS, "Subledger Journal Entry page is Loaded Successfully");
		    	 if(btnPost.isDisplayed())
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
			   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Subledger Journal Entry Page</span></a>");
			   	return new Item(xyz);
		   }


}
