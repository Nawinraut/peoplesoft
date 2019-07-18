package com.cloud.pageobjects.Finance;

import java.util.List;

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

public class JournalBatchNotificationPage extends BasePageObject{
public WebDriver driver;
	
	@FindBy(xpath = "//h1[contains(.,'Journal Batch')]")
	 private WebElement txtExpenses;
	
	
	  @FindBy(xpath = "//*[@id='ctb4']")
	 //@FindBy(how=How.XPATH, using = "//*[@id='ctb4']/a")
	 private WebElement buttonApprove;
	 
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='ctb3']/a")
	 private WebElement buttonReject;
	 
	 //********************************
	 private List<WebElement> rowcount;
	
	 public WebDriverWait wdwait; 
		/**
		* Initializing page objects for Journal Page.
		* @author Ciber
		* @param driver
		* @return
		* @throws TestException
		*/
	    

	    public JournalBatchNotificationPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    //driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='_adfvdlg']")));
		     //wdwait.until(ExpectedConditions.visibilityOf(txtExpenses));
		     wdwait.until(ExpectedConditions.visibilityOf(buttonApprove));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		       
		        System.out.println("******************************* Journal Batch Page *****************************");
		       
		       this.getScreenDetails();
		    }

	     
	    public void clickPerformActions(String Action){
	    	System.out.println(Action);
	    	if(Action.equalsIgnoreCase("Approve")) {
	    		SeleniumUtils.delay(5000);
				   buttonApprove.click();
				   SeleniumUtils.delay(5000);
				   report.log(LogStatus.PASS, "Clicked on Approve button");
	    	}
	    	else {
	    		 SeleniumUtils.delay(5000);
				   buttonReject.click();
				   SeleniumUtils.delay(5000);
				   report.log(LogStatus.PASS, "Clicked on Reject button");
	    	}
			 
			   
			  }
		   public void clickApproveButton(){
			  // driver.switchTo().frame(driver.findElement(By.id("afr::PushIframe")));
			 //  driver.switchTo().window("Expense Report Approval.*");
			   SeleniumUtils.delay(5000);
			   buttonApprove.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Approve button");
			  }
		   
		   public void clickRejectButton(){
				  // driver.switchTo().frame(driver.findElement(By.id("afr::PushIframe")));
				 //  driver.switchTo().window("Expense Report Approval.*");
				   SeleniumUtils.delay(5000);
				   buttonReject.click();
				   SeleniumUtils.delay(5000);
				   report.log(LogStatus.PASS, "Clicked on Reject button");
				  }
		   
		 	
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Journal Batch page is Loaded Successfully");
	    	
	    	if(txtExpenses.isDisplayed())
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
		   	String xyz = Screenshot.takeScreenshotX(driver, "EntryExpense Reports", context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Journal Batch Page</span></a>");
		   	return new Item(xyz);
	   }

}
