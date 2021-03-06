package com.cloud.pageobjects.HCM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

/**
 * Contains object properties and methods for MyDcouments Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class MyDocumentsPage extends BasePageObject {
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
		
	@FindBy(how=How.XPATH, using = "//h1[contains(.,'Document Records')]")
	private WebElement txtManageDocumentRecords;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':AP1:ls1:ctb1::icon')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:1:AP1:ls1:ctb1::icon"]
	private WebElement btnCreate;
	
	//@FindBy(how=How.XPATH, using = "//a[contains(@title,'Search: Document Type')]")
	@FindBy(xpath = "//*[contains(@id,':AP1:Docum1:0:documentType::lovIconId')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_MY_TEAM:0:MAnt2:4:AP1:Docum1:0:documentType::lovIconId"]
	private WebElement linkDocumentType;
	
	@FindBy(how=How.XPATH, using = "//input[contains(@id,'afrLovInternalQueryId:value00::content')]")
	private WebElement txtDocumentType;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':AP1:Docum1:0:documentType_afrLovInternalTableId::db')]")
	private WebElement tableDcoumentType;
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':2:AP1:Docum1:0:documentType::lovDialogId::ok')]")
	private WebElement btnOK;
		
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':AP1:Docum1:0:inputText6::content')]")
	private WebElement txtDocumentName;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':2:AP1:Docum1:0:inputDate3::glyph')]")
	private WebElement btnFromDate;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':2:AP1:Docum1:0:inputDate2::glyph')]")
	private WebElement btnToDate;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,':2:AP1:Docum1:0:inputDate3::pop::cd::mSel::content')]")
	private WebElement selectFromDateMonth;
	
	@FindBy(how=How.XPATH, using = "//select[contains(@id,':2:AP1:Docum1:0:inputDate2::pop::cd::mSel::content')]")
	private WebElement selectToDateMonth;
	
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,':AP1:a1:applicationsTable:_ATp:create::icon')]")
	@FindBy(how=How.XPATH, using = "//img[contains(@id,'applicationsTable:_ATp:create::icon')]")
	private WebElement btnAddAttachment;
	
	//@FindBy(how=How.XPATH, using = "//input[contains(@type,'file')]")
	@FindBy(how=How.XPATH, using = "//input[contains(@id,':desktopFile::content')]")
	private WebElement btnBrowse;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':2:AP1:tt1:submit')]/a")
	//@FindBy(how=How.XPATH, using = "//*[contains(@id,':2:AP1:tt1:submit')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:_FOTr2:2:AP1:tt1:submit"]
	private WebElement btnSubmit;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Yes')]")
	private WebElement btnYes;
	
	
	@FindBy(how=How.XPATH, using = "//button[contains(@id,':AP1:tt1:okConfirmationDialog')]")
	private WebElement confirmationOK;
	
	
	 public MyDocumentsPage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtManageDocumentRecords));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* MyDcouments Contacts Page *****************************");
	     this.getScreenDetails();
	 }

	 public boolean isMyDetailsPageDisplayed(){
	    	return txtManageDocumentRecords.isDisplayed();
	    }
	 
	 public void clickCreateButton()
	 {
		 btnCreate.click();
		 //SeleniumUtils.delay(5000);
		 wdwait.until(ExpectedConditions.visibilityOf(linkDocumentType));
		 report.log(LogStatus.PASS, "Clicked on Create button");
		 this.getScreenDetails("Create Button");
	 }
	 
	 
	 public void clickAddButton()
	 {
		 btnAddAttachment.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Add button click");
	 }
	 
	 public void uploadAddressProof()
	 {
		 String pathToAddressProof=System.getProperty("user.dir")+File.separator+"Cloud_TestData\\Address proof.pdf";
		 btnBrowse.sendKeys(pathToAddressProof);
		/* driver.switchTo()
		 .activeElement()
		 .sendKeys(pathToAddressProof);*/
		 SeleniumUtils.delay(12000);
		 this.getScreenDetails("Upload Address Proof");
	 }
	 
	 public void clickSubmitButton()
	 {
		 btnSubmit.click();
		// SeleniumUtils.delay(5000);
		 wdwait.until(ExpectedConditions.visibilityOf(btnYes));
		 this.getScreenDetails("After Submit Button click");
	 }
	 
	 
	 public void clickYesButton()
	 {
		 btnYes.click();
		 wdwait.until(ExpectedConditions.visibilityOf(confirmationOK));
		 this.getScreenDetails("After Yes Button click");
	 }
	 
	 
	 
	 public void clickConfirmationOKButton()
	 {
		 confirmationOK.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("After Ok button click");
	 }
	 
	 public void clickBrowseButton()
	 {
		 btnBrowse.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails();
	 }
	 
	 public void clickFromDatePicker()
	 {
		 btnFromDate.click();
		 SeleniumUtils.delay(2000);
	 }
	 
	 public void clickToDatePicker()
	 {
		 btnToDate.click();
		 SeleniumUtils.delay(2000);
	 }
	 
	 public void clickOKButton()
	 {
		 btnOK.click();
		 //SeleniumUtils.delay(5000);
		 wdwait.until(ExpectedConditions.visibilityOf(txtDocumentName));
		 this.getScreenDetails("After Ok Button click");
	 }
	 
	 public void clickSearchButton()
	 {
		 btnSearch.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Search Results");
	 }
	 
	 
	 public void clickPersonlaFiles()
	 {
		 tableDcoumentType.click();
	 }
	 
	 public void selectDocumentTypeCell(String eventName) throws InterruptedException{	
		 WebDriverWait wait = new WebDriverWait(driver, 50);
		   WebElement eventLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'_afrLovInternalTableId::db')]//*[text()= '"+eventName+"']")));	   
		   SeleniumUtils.delay(2000);
		   eventLink.click(); 
		   SeleniumUtils.delay(5000);
		   report.log(LogStatus.PASS, "Selected from list is: "+eventName);
		   
	   }
	 
	 public void selectFromDateMonth(String strMonthName)
	 {
	    	report.log(LogStatus.PASS, "Select any value from Month dropdown");
	    	Select objSelect = new Select(selectFromDateMonth);
	    	objSelect.selectByVisibleText(strMonthName);
	    	SeleniumUtils.delay(2000);
	 }
	 
	 public void selectToDateMonth(String strMonthName)
	 {
	    	report.log(LogStatus.PASS, "Select any value from Month dropdown");
	    	Select objSelect = new Select(selectToDateMonth);
	    	objSelect.selectByVisibleText(strMonthName);
	    	SeleniumUtils.delay(2000);
	 }
	 
	 public void selectFromDate(String noOfDays)
		{
			//WebElement dateWidget = driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:_FOTr5:2:AP1:Docum1:0:inputDate3::pop::cd']/tbody/tr[2]/td"));
			WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,':2:AP1:Docum1:0:inputDate3::pop::cd')]/tbody/tr[2]/td"));
			List<WebElement> rows=dateWidget.findElements(By.tagName("tr")); 
			List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
			  
			  for (WebElement cell:columns)
			  {
			   if (cell.getText().equals(noOfDays))
			   {
			     cell.click();
				   SeleniumUtils.delay(3000);
				   break;
			   }
			  } 
			  this.getScreenDetails("FromDate Selected");
			}
	 
	 public void selectToDate(String noOfDays)
		{
			//WebElement dateWidget = driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrPER_HCMPEOPLETOP_FUSE_PER_INFO:0:_FOTr5:2:AP1:Docum1:0:inputDate2::pop::cd::cg']"));
			WebElement dateWidget = driver.findElement(By.xpath("//*[contains(@id,':2:AP1:Docum1:0:inputDate2::pop::cd::cg')]"));
			List<WebElement> rows=dateWidget.findElements(By.tagName("tr")); 
			List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
			  
			  for (WebElement cell:columns)
			  {
			   if (cell.getText().equals(noOfDays))
			   {
			     cell.click();
				   SeleniumUtils.delay(3000);
				   break;
			   }
			  } 
			  this.getScreenDetails("ToDate Selected");
			}
	 
	 public void clickSearchFromDocumentTypeList() throws AWTException
	 {
		 //new Actions(driver).moveToElement(linkDocumentType).click().perform();
		 // Create object of Robot class
		  Robot robot=new Robot();
		  linkDocumentType.click();
		  robot.keyPress(KeyEvent.VK_ENTER);
		  
		 
		 
		 SeleniumUtils.delay(5000);
		 System.out.println("test click");
		 driver.findElement(By.xpath("//*[contains(@id,':AP1:Docum1:0:documentType::dropdownPopup::popupsearch')]")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Search Results");
	 }
	 
	 
		
	 public void enterDocumentType(String strDocumentType)
	 {
		 txtDocumentType.click();
		 txtDocumentType.sendKeys(strDocumentType);
		 SeleniumUtils.delay(2000);
	 }
	
	 
	 public void enterDocumentName(String strDocumentName)
	 {
		 txtDocumentName.click();
		 txtDocumentName.sendKeys(strDocumentName);
		 SeleniumUtils.delay(2000);
	 }
	 
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "My Dcouments Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtManageDocumentRecords, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "MyDcouments", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>MyDcouments Contacts Page</span></a>");
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
