package com.cloud.pageobjects.Finance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ExpensesPage extends BasePageObject{
	
	public WebDriver driver;
	
	 @FindBy(xpath = "//h1[contains(.,'Travel and Expenses')]")
	 private WebElement txtExpenses;
	 
	 @FindBy(how=How.XPATH, using = "//select[contains(@id,'soc1::content')]")
	    private WebElement selectAssetType;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':AP1:cl2::icon')]")
	    private WebElement btnCreate;
	  
	 @FindBy(xpath = "//input[contains(@name,'expenses:0:MAnt2:1:AP1:it1')]")
	    private WebElement txtPurpose;
	 
	 @FindBy(xpath = "//a[contains(@title,'Select Date')]")
	 private WebElement btnSelectDate;
	
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_my_information_expenses:0:_FOTsr1:0:pt0:pt1:r1:0:ITPdtl:0:ctb2']")
	    private WebElement btnCreateExpenseReport;
	 
	 @FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_my_information_expenses:0:_FOTsdiExmWorkArea_FndTasksLis::icon']")
	    private WebElement btnTasks;
	 
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_my_information_expenses:0:_FOTRaT:0:RAtl3"]
	 @FindBy(xpath = "//a[contains(.,'Manage Delegates')]")
	 private WebElement lnkManageDelegates;
	 
	 @FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_my_information_expenses:0:MAnt2:1:pt1:AP1:ctb1']")
	 private WebElement btnAdd;
	 
	// @FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_my_information_expenses:0:MAnt2:1:pt1:AP1:lvDeleg:1:ilovDelegate::lovIconId']")
	 @FindBy(xpath = "//*[contains(@id,'ilovDelegate::lovIconId')]")
	 private WebElement btnSearchSelect;
	 
	 /*@FindBy(xpath = "//input[contains(@name,'afrLovInternalQueryId:value00')]")
	 private WebElement txtPerson;
	 */
	 @FindBy(xpath = "//textarea[contains(@name,'expenses:0:MAnt2:2:AP1:Description')]")
	    private WebElement txtDescription;
	
	  @FindBy(how=How.XPATH, using = "//*[contains(@id,'::lovDialogId::ok')]")
	    private WebElement btnLocationOk;
	  
	  @FindBy(xpath = "//a[contains(@id,'expenses:0:MAnt2:2:AP1:SaveAndCloseButton::popEl')]")
	  	private WebElement btnCloseMenu;
	  
	  @FindBy(xpath = "//*[contains(@id,':0:MAnt2:2:AP1:SaveAndCloseButton')]/table/tbody/tr/td[1]/a")
	  	private WebElement btnClose;
	  
	  @FindBy(xpath = "//*[contains(@id,':0:MAnt2:1:AP1:ctb2')]")
	  	private WebElement btnSubmit;
	 
	  @FindBy(xpath = "//*[contains(@id,':AP1:SaveButton')]")
	  private WebElement btnSave;
	  
	  //@FindBy(xpath = "//*[contains(@id,':0:MAnt2:1:pt1:AP1:APscl2')]")
	  @FindBy(xpath = "//*[contains(@id,'pt1:AP1:APscl2')]")
	  private WebElement btnSaveAndClose;
	  
	  @FindBy(how=How.XPATH, using = "//*[contains(@id,':2:AP1:SaveAndCreateButton')]")
	    private WebElement btnCreateAnother;
	
	  @FindBy(xpath = "//input[contains(@name,'expenses:0:MAnt2:2:AP1:ReceiptAmount')]")
	  private WebElement txtAmount;
		
	 @FindBy(xpath = "//select[contains(@name,'expenses:0:MAnt2:2:AP1:ExpenseTypeId')]")
	 	private WebElement selectType;
	 
	 @FindBy(xpath = "//a[contains(@title,'Search and Select: Expense Location')]")
	 private WebElement linkExpenseLocation;
	 
	 @FindBy(xpath = "//input[contains(@name,'afrLovInternalQueryId:value00')]")
	 private WebElement txtExpenseLocation;
	 
	 @FindBy(how=How.XPATH, using = "//button[contains(.,'Search')]")
		private WebElement btnSearch;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':AP1:Location_afrLovInternalTableId::db')]")
		private WebElement tableExpenseLocation;
	 
	// @FindBy(how=How.XPATH, using = "//*[contains(@id,':pt1:AP1:lvDeleg:1:ilovDelegate_afrLovInternalTableId::db')]")
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,'ilovDelegate_afrLovInternalTableId::db')]")
		private WebElement tablePersonNames;
	 
	 
	 @FindBy(xpath = "//button[contains(@id,'expenses:0:MAnt2:2:AP1:Location::lovDialogId::ok')]")
	 private WebElement buttonOK;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':0:_FOTsr1:0:pt0:pt1:r1:0:ITPdc2j_id_2:ITsel::icon')]")
		private WebElement btnApprovals;
	 
	 @FindBy(how=How.XPATH, using = "//*[contains(@id,':0:_FOTsr1:0:pt0:pt1:r1:0:ITPdtl:1:lv4:0:otPerson')]")
		private WebElement lnkPayblesSpecialist;
	 
	
	 @FindBy(xpath = "//*[@id='ctb4']")
	 //@FindBy(how=How.XPATH, using = "//*[@id='ctb4']/a")
	 private WebElement buttonApprove;
	 
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
	    
	    
	    public ExpensesPage(WebDriver driver, ExtentTest report) throws TestException {
		     super(report);
			 this.driver=driver; 
			 wdwait=new WebDriverWait(driver, 60);
		     PageFactory.initElements(driver, this);
		    
		     wdwait.until(ExpectedConditions.visibilityOf(txtExpenses));
		     if (!isDisplayed()) 
		     {
		        throw new TestException(this.getClass().getName() + " is not loaded");
		     }
		     
		        System.out.println("******************************* Expenses Page *****************************");
		       this.getScreenDetails();
		    }

	  	   public void selectExpensesType(String strExpenseType){
			   	Select objSelect = new Select(selectType);
		    	objSelect.selectByVisibleText(strExpenseType);
		    	 wdwait.until(ExpectedConditions.visibilityOf(linkExpenseLocation));
		    }
		   
		// Create button   
		   public boolean isCreateButtonDisplayed(){
			   return btnCreate.isDisplayed();  	
		   }  
	   
		   public void clickCreatetButton(){
			   btnCreate.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnSelectDate));
			   report.log(LogStatus.PASS, "Clicked on Create button Button");
			  
		   } 
		   
		   public void clickSelectDateIcon(){
			   btnSelectDate.click();
			   SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on SelectDate Button");
			  
		   } 
		   
		  public void enterPurpose(String strPurpose)
		   {
			   txtPurpose.click();
			   txtPurpose.sendKeys(strPurpose);
		   }
	   
		   public void clickCreateExpenseReportButton(){
			   btnCreateExpenseReport.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtPurpose));
			   report.log(LogStatus.PASS, "Clicked on CreateExpenseReport Button");
			  
		   } 
		   
		   
		   public void clickTasksButton(){
			   btnTasks.click();
			   wdwait.until(ExpectedConditions.visibilityOf(lnkManageDelegates));
			   report.log(LogStatus.PASS, "Clicked on Tasks Button");
			  
		   } 
		   
		   
		   public void clickManageDelegates(){
			   lnkManageDelegates.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnAdd));
			   report.log(LogStatus.PASS, "Clicked on Manage Delegates link");
			  
		   } 
		   
		   public void clickAddButton(){
			   btnAdd.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnSearchSelect));
			   report.log(LogStatus.PASS, "Clicked on Add Button");
			  
		   } 
		   
		   public void clickSearchSelectIcon(){
			   btnSearchSelect.click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtExpenseLocation));
			   report.log(LogStatus.PASS, "Clicked on SearchSelect Icon");
			  
		   } 
		  
		  // Description field
		   public void enterDescription(String strDescription){
			   SeleniumUtils.delay(2000);
			   txtDescription.click();
			   txtDescription.clear();
			   txtDescription.sendKeys(strDescription);
			}
		   
		   
		   public void enterAmount(String strAmount){
			   SeleniumUtils.delay(2000);
			   txtAmount.clear();
			   txtAmount.click();
			   txtAmount.sendKeys(strAmount);
			   //report.log(LogStatus.PASS, "Entered Description is: "+strDescription);
		   }
		   
		   public boolean isDescriptionDisplayed(){
			   return SeleniumUtils.isDisplayed(driver, txtDescription, context.getReactTimeout());
			   }
		   
		
		   
		// Location Ok button   
		   public boolean isLocationOkButtonDisplayed(){
			   return btnLocationOk.isDisplayed();  	
		   }  
	   
		   public void clickLocationOkButton(){
			   btnLocationOk.click();
			   this.getScreenDetails("After Ok button click");
			   report.log(LogStatus.PASS, "Clicked on Ok Button");
		   } 
		   
		   public void clickCloseMenu(){
			   btnCloseMenu.click();
			   SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on Close Menu");
		   } 
		
		   
		   public void clickCloseButton(){
			   btnClose.click();
			   wdwait.until(ExpectedConditions.visibilityOf(btnSubmit));
			   report.log(LogStatus.PASS, "Clicked on Close button");
		   }
		   
		   
		   public void clickSubmitButton(){
			   btnSubmit.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Submit button");
		   }
		   
		   
		   public void clickApproveButton(){
			  // driver.switchTo().frame(driver.findElement(By.id("afr::PushIframe")));
			 //  driver.switchTo().window("Expense Report Approval.*");
			   buttonApprove.click();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Approve button");
			  }
		   
		   public void clickSaveButton(){
			   //btnSave.click();
			   JavascriptExecutor js = (JavascriptExecutor)driver;
		         js.executeScript("arguments[0].click();", btnSave);
		      //   new Actions(driver).moveToElement(iconNavigator).click().perform();
			   SeleniumUtils.delay(5000);
			   report.log(LogStatus.PASS, "Clicked on Save Button");
		   }
		   
		   public void clickCreateAnotherButton(){
			   btnCreateAnother.click();
			   SeleniumUtils.delay(6000);
			   report.log(LogStatus.PASS, "Clicked on Create Another Button");
			} 
				
		   
		   public void clickSaveAndCloseButton(){
			   SeleniumUtils.delay(6000);
			   btnSaveAndClose.click();
			   SeleniumUtils.delay(6000);
			   this.getScreenDetails("After Save button click");
			   report.log(LogStatus.PASS, "Clicked on Save And Close Button");
			} 
		   
		   public void clickExpenseLocationLink(){
			   linkExpenseLocation.click();
			   SeleniumUtils.delay(3000);
			   report.log(LogStatus.PASS, "Clicked on Expense Location Link");

		   }
		   
		 
		   public void clickSearchLink(){
			   driver.findElement(By.xpath("//*[contains(@id,':AP1:Location::dropdownPopup::popupsearch')]")).click();
			   wdwait.until(ExpectedConditions.visibilityOf(txtExpenseLocation));
			   report.log(LogStatus.PASS, "Clicked on Expense Location Link");
		   }
		
		   public void selectDayFromSelectDate(String selectDate)
			{
				List<WebElement> dates = driver.findElements(By.xpath("//*[contains(@id,':AP1:StartDate::pop::cd::cg')]//td"));  
				
				for (WebElement cell:dates)
				  {
					String date=cell.getText();
				   if (date.equalsIgnoreCase(selectDate))
				   {
				     cell.click();
					   SeleniumUtils.delay(2000);
					   report.log(LogStatus.PASS, "Selected From Payment Date is "+selectDate);
					   break;
					   
				   }
				  } 
				  
			  }  

		   public void enterExpenseLocation(String strLocation)
			{
				System.out.println("person number is inside method "+strLocation);
				txtExpenseLocation.click();
				txtExpenseLocation.clear();
				txtExpenseLocation.sendKeys(strLocation);
				SeleniumUtils.delay(2000);
				
			}
		   
		   public void clickSearchButton() throws TestException
			 {
				btnSearch.click();
				SeleniumUtils.delay(5000);
				SeleniumUtils.scroll(driver, 0, 1000);
				this.getScreenDetails("Search Results Screen");
			    report.log(LogStatus.PASS, "Clicked on Search button");
			 }
		
		   
		   public void clickSelectApprovalsButton() throws TestException
			 {
			   	btnApprovals.click();
			    wdwait.until(ExpectedConditions.visibilityOf(lnkPayblesSpecialist));
				this.getScreenDetails("After Approvals Click");
			    report.log(LogStatus.PASS, "Clicked on Select Approvals button");
			 }
		   
		   
		   public void clickPayblesSpecialist() throws TestException
			 {
			   lnkPayblesSpecialist.click();
			  // wdwait.until(ExpectedConditions.visibilityOf(buttonApprove));
			   SeleniumUtils.delay(12000);
				this.getScreenDetails("After PayblesSpecialist Click");
			    report.log(LogStatus.PASS, "Clicked on Paybles Specialist Link");
			 }
		   
		   
		   public void selectLocationName(String strLocationName)
			{	
				rowcount=(List<WebElement>) tableExpenseLocation.findElements(By.tagName("tr"));
				int rownum=rowcount.size();
				for (int row=1;row<rownum;row++)
				{	
					WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':AP1:Location_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
					String actualText=cellNametext.getText();
					System.out.println("actual text is "+actualText);
					
					if(actualText.equalsIgnoreCase(strLocationName))
					{
						report.log(LogStatus.INFO, "Selected Location Name is "+strLocationName);
						cellNametext.click();
						SeleniumUtils.delay(5000);
						this.getScreenDetails("Selection of Location");
						break;
					}
				}
			}		
		   
		   
		   public void selectPersonName(String strPersonName)
			{	
				rowcount=(List<WebElement>) tablePersonNames.findElements(By.tagName("tr"));
				int rownum=rowcount.size();
				for (int row=1;row<rownum;row++)
				{	
					//WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':pt1:AP1:lvDeleg:1:ilovDelegate_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
					WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,'ilovDelegate_afrLovInternalTableId::db')]/table/tbody/tr["+row+"]/td[2]/div/table/tbody/tr/td[1]"));
					
					String actualText=cellNametext.getText();
					System.out.println("actual text is "+actualText);
					
					if(actualText.equalsIgnoreCase(strPersonName))
					{
						report.log(LogStatus.INFO, "Selected Person Name is "+strPersonName);
						cellNametext.click();
						SeleniumUtils.delay(5000);
						this.getScreenDetails("Selection of Person");
						break;
					}
				}
			}	
		   
	    @Override
		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			//return  btnTasks.isDisplayed();
			
			 report.log(LogStatus.PASS, "Expenses page is Loaded Successfully");
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
		   	String xyz = Screenshot.takeScreenshotX(driver, "EntryExpenses", context);
		   	report.addScreenCapture(xyz);
		   	String projectPath = System.getProperty("user.dir");    	
		   	String fullprojectPath = projectPath+"/report/"+xyz;
		   	report.log(LogStatus.INFO, "<a href='"+fullprojectPath+"'><span class='label info'>Expenses Page</span></a>");
		   	return new Item(xyz);
	   }
}
