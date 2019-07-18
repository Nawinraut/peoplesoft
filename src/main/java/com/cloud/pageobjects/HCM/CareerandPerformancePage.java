package com.cloud.pageobjects.HCM;

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

/**
 * Contains object properties and methods for CareerandPerformance Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class CareerandPerformancePage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Career and Performance')]")
	private WebElement txtCareerandPerformance;
	
	@FindBy(xpath = "//span[contains(.,'Goals')]")
	private WebElement iconGoals;
	
	@FindBy(xpath = "//span[contains(.,'Performance Evaluations')]")
	private WebElement iconPerfEval;
	
	 public CareerandPerformancePage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtCareerandPerformance));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* CareerandPerformance Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isCareerandPerformancePageDisplayed(){
		 report.log(LogStatus.PASS, "Directory page is Displayed");
		 return txtCareerandPerformance.isDisplayed();
		}
	 
	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "CareerandPerformance Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtCareerandPerformance, context.getFindTimeout());
    }
	 
	 public GoalsPage clickGoals() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(iconGoals));
			iconGoals.click();
			report.log(LogStatus.PASS, "Clicked on Goals link");
			return new GoalsPage(driver,report);
		 }
	
	 
	 public PerformancePage clickPerformanceEvaluations() throws TestException{
			wdwait.until(ExpectedConditions.visibilityOf(iconPerfEval));
			iconPerfEval.click();
			report.log(LogStatus.PASS, "Clicked on Performance Evaluation link");
			return new PerformancePage(driver,report);
		 }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryCareerandPerformanceInformation", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>CareerandPerformanceInformation Page</span></a>");
	    	return new Item(xyz);
	    }
	  
	  public Item getScreenDetails(String strTitle){
		   	String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>"+strTitle+"</span></a>");
		   	return new Item(xyz);
	   }
}
