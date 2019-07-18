package com.cloud.pageobjects.HCM;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloud.exceptions.TestException;
import com.cloud.models.Item;
import com.cloud.pageobjects.BasePageObject;
import com.cloud.utils.Screenshot;
import com.cloud.utils.SeleniumUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Contains object properties and methods for GoPerformanceals Page. 
 * @author CIBER 
 * @param 
 * @return 
 * @throws
 */
public class PerformancePage extends BasePageObject {
	
	//public WebDriver driver;
	//public WebDriverWait wdwait;
	
	@FindBy(xpath = "//h1[contains(.,'Evaluations')]")
	private WebElement txtEvaluations;
	
	@FindBy(how=How.XPATH, using = "//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:_FOTsr1:0:cil1::icon']")
	private WebElement searchIcon;
	
	@FindBy(how=How.XPATH, using = "//button[contains(.,'Done')]|//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:1:AP9:ctb4']|//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_career_goals:0:MAnt2:1:AP1:ctb4']")
	private WebElement btnDone;
	
	@FindBy(how=How.XPATH, using = "//*[contains(@id,':0:_FOTsdiHRG_GOALS_TaskList_itemNode::icon')]")
	private WebElement btnTasks;
	
	@FindBy(xpath = "//a[contains(@title,'Search: Goal Name')]")
	private WebElement lnkGoalName;
	
	@FindBy(xpath = "//a[contains(.,'Manage Goal Plans')]")
	private WebElement lnkMGP;
	
	@FindBy(xpath = "//input[contains(@name,'CareerandPerformance:0:MAnt2:2:ph1:r1:0:r12:1:sp3:it6')]")
	private WebElement txtGoalName;
	
	@FindBy(xpath = "//*[contains(@id,':0:_FOTsdiPerformanceManagement_PerfMyOrganizationLite_itemNode::icon')]")
	//*[@id="_FOpt1:_FOr1:0:_FOSrMANAGER_RESOURCES_HRA_HCMPERFORMANCE_FUSE_PERFORMANCE:0:_FOTsdiPerformanceManagement_PerfMyOrganizationLite_itemNode::icon"]
	private WebElement iconMyOrg;
	
	@FindBy(xpath = "//*[contains(@id,':0:_FOTrPerformanceManagement_PerfMyOrganizationLite_itemNode:1:sp1:cil1::icon')]")
	private WebElement btnFilter;
	
	@FindBy(xpath = "//*[contains(@id,':0:_FOTsdiPerformanceManagement_PerfMyOrganizationLite_itemNode::icon')]")
	private WebElement btnAdd;
	
	@FindBy(xpath = "//a[contains(@id,'CareerandPerformance:0:MAnt2:2:sp3:id3::glyph')]")
	private WebElement dateActaulComp;
	
	@FindBy(xpath = "//button[contains(@accesskey,'K')]|//*[@id='_FOd1::msgDlg::cancel']|//button[contains(@id,':submitConfirm::ok')]|//button[contains(@id,':ph1:dialog1::ok')]|//button[contains(@id,'::ok')]")
	private WebElement btnOK;
	
	@FindBy(xpath = "//*[contains(@id,':0:r1:0:ITPdc1j_id_1:ITsel::icon')]|//*[contains(@id,':ph1:r1:0:r1:0:ITPdc1j_id_1:ITsel::icon')]|//*[contains(@id,':sp11:reg1:0:r1:0:ITPdc1j_id_1:ITsel::icon')]")
	private WebElement btnGoals;
	
	@FindBy(xpath = "//*[contains(@id,':sp11:reg1:0:r1:0:ITPdc1j_id_2:ITsel::icon')]|//*[contains(@id,':ph1:r4:0:r1:0:ITPdc1j_id_2:ITsel::icon')]")
	private WebElement btnOverallSummary;
	
	//@FindBy(xpath = "//textarea[contains(@name,':ph1:r2:0:r1:0:ITPdtl:0:richTextEditor1::src')]")
	@FindBy(xpath = "//*[contains(@id,':ph1:r2:0:r1:0:ITPdtl:0:richTextEditor1::_cic')]")
	private WebElement txtareaComments;
	
		@FindBy(xpath = "//a[contains(@title,'Add Goal')]")
	private WebElement btnAddGoal;
	
	//@FindBy(xpath = "//a[contains(@title,'Search: Review Period')]")
	@FindBy(xpath = "//a[contains(@title,'Review Period')]")
	private WebElement lnkReviewPeriod;
	
	@FindBy(xpath = "//*[contains(@id,':0:sp2:soc3::drop')]|//*[contains(@id,':1:sp1:soc2::drop')]")
	private WebElement listReviewPeriod;
	
	@FindBy(xpath = "(//input[contains(@name,'goals:0:MAnt2:2:AP2:sml1')])[1]")
	private WebElement chkPerDocType;
	
	@FindBy(xpath = "//button[contains(.,'Next')]")
	private WebElement btnNext;
	
	@FindBy(xpath = "//button[contains(@id,'r1:1:q4::search')]")
	private WebElement btnSearch1;
	
	@FindBy(xpath = "//button[contains(.,'Search')]")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//*[contains(@id,':MAnt2:1:ph1:submit')]|//button[contains(.,'Submit')]|//*[contains(@id,':sp11:submitButton')]|//*[contains(@id,':ph1:submitButton')]")
	private WebElement btnSubmit;
		
	@FindBy(xpath = "//button[contains(.,'Yes')]|//button[contains(@id,::yes')]")
	private WebElement btnYes;

	
	@FindBy(xpath = "//*[contains(@id,':ph1:d6::yes')]|//button[contains(@id,':ph1:d1::yes')]|//button[contains(@id,':ph1:d3::yes')]|//button[contains(@id,':sp2:lv21:1:lv10:1:t2:0:d3::yes')]")
	private WebElement btnYes1;
	//@FindBy(xpath = "//button[contains(@id,'itemNode:0:sp2:lv21:1:lv10:1:t2:0:d3::yes')]")
	
	@FindBy(xpath = "//a[contains(@title,'Select Date')]")
	private WebElement iconSelectDate;
	
	@FindBy(xpath = "//input[contains(@name,'PERFORMANCE:0:MAnt2:1:ph1:r1:0:r1:0:ITPdtl:0:Conte1:0:q1:value00')]|//input[contains(@name,'CareerandPerformance:0:MAnt2:2:ph1:r1:0:r1:0:ITPdtl:0:Conte1:0:q1:value00')]")
	//@FindBy(xpath = "//input[contains(@name,'CareerandPerformance:0:MAnt2:2:ph1:r1:0:r1:0:ITPdtl:0:Conte1:0:q1:value00')]")
	private WebElement txtCompName;
	
	@FindBy(xpath = "//button[contains(.,'Apply')]")
	private WebElement btnApply;
	
	@FindBy(xpath = "//*[contains(@id,':0:_FOTrPerformanceManagement_PerfMyOrganizationLite_itemNode:1:sp1:np1:cni2::disclosureAnchor')]")
	private WebElement tabTaskCompStatus;
	
	@FindBy(xpath = "//button[contains(.,'Save and Close')]|//*[contains(@id,':sp3:commandButton2')]")
	private WebElement btnSaveandClose;
	
	@FindBy(xpath = "//*[contains(@id,':0:MAnt2:1:ph1:saveMenuButton')]/table/tbody/tr/td[1]/a")
	private WebElement btnSave;
	
	@FindBy(xpath = "//*[contains(@id,'CareerandPerformance:0:MAnt2:2:ph1:publish')]")
	private WebElement btnShare;
	
	
	@FindBy(xpath = "(//button[contains(.,'OK')])")
	//@FindBy(xpath = "//button[@type='button'][contains(@id,'FOd1::msgDlg::cancel')][contains(.,'OK')]")
	private WebElement btnGLOK;
	
	@FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_CareerandPerformance:0:MAnt2:1:ph1:r2:0:uyu']")
	private WebElement btnSubmitforApproval;
	
	/*@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement btnSubmit;*/
	
	@FindBy(xpath = "//*[contains(@id,':0:sp2:lv21::db')]")
	private WebElement tableEmps;
	
	@FindBy(xpath = "//*[contains(@id,':0:MAnt2:1:sp1:lv21:0:lv10::db')]")
	private WebElement tableGoals;
	
	//@FindBy(xpath = "//*[contains(@id,':0:MAnt2:2:sp11:reg1:0:r1:0:ITPdtl:0:lv1::db')]")
	@FindBy(xpath = "//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1::db')]")
	private WebElement tableSelfGoals;
	
	@FindBy(xpath = "//button[contains(.,'Continue')]|//button[contains(@class,'p_AFHoverTarget xzi p_AFTextOnly')]")
	private WebElement btnContinue;
	
	@FindBy(xpath = "//button[contains(.,'Add')]|//button[contains(@id,':ph1:r1:0:r1:0:ITPdtl:0:cb2')]")
	private WebElement buttonAdd;
	
  //  @FindBy(how=How.XPATH,using="//*[contains(@id,':ph1:commandToolbarButton1')]/table/tbody/tr/td[1]/a")
    @FindBy(how=How.XPATH,using=" //*[contains(@id,':ph1:commandToolbarButton1')]")
  	private WebElement btnShareandRelease;
    
    @FindBy(xpath = "//textarea[contains(@name,':ph1:rte1::src')]")
   // @FindBy(xpath = "//*[contains(@id,':ph1:rte1::cont')]")
    private WebElement txtShareandReleaseComments;
    
    @FindBy(xpath = "//*[@id='_FOpt1:_FOr1:0:_FOSrMANAGER_RESOURCES_HRA_HCMPERFORMANCE_FUSE_PERFORMANCE:0:MAnt2:1:ph1:r2:0:r1:0:ITPdtl:0:r1:0:richTextEditor1::cont']")
    private WebElement txtManagerComments;
	
	private List<WebElement> rowcount;
	private List<WebElement> rowcount1;
	 public PerformancePage(WebDriver driver, ExtentTest report) throws TestException 
	 {
	     super(report);
		 this.driver=driver; 
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
	     wdwait.until(ExpectedConditions.visibilityOf(txtEvaluations));
	     if (!isDisplayed()) 
	     {
	        throw new TestException(this.getClass().getName() + " is not loaded");
	     }
	     System.out.println("******************************* Performance Page *****************************");
	     this.getScreenDetails();
	 }
	 
	 
	 public void clickSetGoals(String strEmpName)
     {
            int r;
            rowcount=(List<WebElement>) tableEmps.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			int found=0;
            for (r=0;r<=rownum;r++)
              {
                   WebElement eleEmplyee = driver.findElement(By.xpath("//*[contains(@id,'ManagerOverviewLite_itemNode:0:sp2:lv21:"+r+":ol1')]"));
                   String strEmplyee=eleEmplyee.getText();
                   System.out.println("Employee name is: "+strEmplyee);
                   if(strEmplyee.equalsIgnoreCase(strEmpName)) 
                   {
                         List<WebElement> linkSize = driver.findElements(By.xpath("//a[contains(@id,'sp2:lv21:"+r+"')]"));
                         linkSize.size();
                         int t=0;
                         for(t=0;t<=linkSize.size();t++) 
                         {
                                String strLinkName=linkSize.get(t).getText();
                                if((strLinkName.equalsIgnoreCase("Set Goals"))) 
                                {
                                       linkSize.get(t).click();
                                       SeleniumUtils.delay(8000);
                                       report.log(LogStatus.PASS, "Clicked on Set Goals Link");
                                       found=1;
                                       break;
                                }
                         }
                   }

                 if (found==1)
				 {
					break;
				}
              } 
       }

	 public void clickGoals(String strEmpName,String GoalName)
     {
            int r;
            rowcount=(List<WebElement>) tableEmps.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			int found=0;
            for (r=0;r<=rownum;r++)
              {
                   WebElement eleEmplyee = driver.findElement(By.xpath("//*[contains(@id,'ManagerOverviewLite_itemNode:0:sp2:lv21:"+r+":ol1')]"));
                   String strEmplyee=eleEmplyee.getText();
                   System.out.println("Employee name is: "+strEmplyee);
                   if(strEmplyee.equalsIgnoreCase(strEmpName)) 
                   {
                         List<WebElement> linkSize = driver.findElements(By.xpath("//a[contains(@id,'sp2:lv21:"+r+"')]"));
                         linkSize.size();
                         int t=0;
                         for(t=0;t<=linkSize.size();t++) 
                         {
                                String strLinkName=linkSize.get(t).getText();
                                if((strLinkName.equalsIgnoreCase(GoalName))) 
                                {
                                       linkSize.get(t).click();
                                       SeleniumUtils.delay(10000);
                                       report.log(LogStatus.PASS, "Clicked on "+GoalName+" Link");
                                       found=1;
                                       break;
                                }
                         }
                   }

                 if (found==1)
				 {
					break;
				}
              } 
       }
	 
	 public void clickSetGoalsEmp(String strGoalName)
		{	
		 
			rowcount=(List<WebElement>) tableGoals.findElements(By.tagName("tr"));
			int rownum=rowcount.size();
			/*List<WebElement> linkSize = driver.findElements(By.xpath("//a[contains(@id,':0:MAnt2:1:sp1:lv21:')]"));
		 int rownum=linkSize.size();*/
		 System.out.println("Number of rows is: "+rownum);
		 	int found=0;
			for (int row=0;row<rownum;row++)
			{
				WebElement cellNametext=driver.findElement(By.xpath("//*[contains(@id,':0:MAnt2:1:sp1:lv21:0:lv10:"+row+":t2:0:pgl13')]"));
				String actualGoalName=cellNametext.getText();
				System.out.println("actual Goal Name is "+actualGoalName);
				if(actualGoalName.contains(strGoalName))
				{
					//driver.findElement(By.xpath("//*[contains(@id,':0:MAnt2:1:sp1:lv21:"+row+":lv10:0:t2:0:cl2')]")).click();
					driver.findElement(By.xpath("//*[contains(@id,':0:MAnt2:1:sp1:lv21:0:lv10:"+row+":t2:0:cl2')]")).click();
					SeleniumUtils.delay(8000);
					this.getScreenDetails("Clicked on SetGoals link");
					found=1;
					break;
					 
				}
			}
			if (found==0)
			{
				report.log(LogStatus.FAIL, "Selected Goal Name is "+strGoalName+" is not listed in the search list");
			}
		}
	 
	  
	 public void rateOverallSummary(String rateNumber)
		{	
		 	if(rateNumber.equalsIgnoreCase("1"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:1:emp_prf:sr3:Non1::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else if(rateNumber.equalsIgnoreCase("2"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:1:emp_prf:sr3:Non2::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							}
						else if(rateNumber.equalsIgnoreCase("3"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:1:emp_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							}
						else if(rateNumber.equalsIgnoreCase("4"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:1:emp_prf:sr3:Non4::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
						}
						else if(rateNumber.equalsIgnoreCase("5"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:1:emp_prf:sr3:Non5::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
						}
						else 
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:1:emp_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
						}
			WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:1:wkrcmt')]"));
			//txtComments.click();
//	        txtComments.sendKeys(strComments);
			Actions actions = new Actions(driver);
			actions.moveToElement(txtComments);
			actions.click();
			this.getScreenDetails("clicked on comments textarea");
			actions.sendKeys("Thank You");
			actions.build().perform();
	        SeleniumUtils.delay(3000);
	        this.getScreenDetails("entered comments");
			report.log(LogStatus.PASS, "Entered Comments");
			
			report.log(LogStatus.INFO, "Click the vertical scrollbar.");
			SeleniumUtils.scroll(driver, 0, 200);
		}
	 
	 
	 public void rateMgrOverallSummary(String rateNumber)
		{	
		 	if(rateNumber.equalsIgnoreCase("1"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:1:mgr_prf:sr3:Non1::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else if(rateNumber.equalsIgnoreCase("2"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:1:mgr_prf:sr3:Non2::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							}
						else if(rateNumber.equalsIgnoreCase("3"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:1:mgr_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							}
						else if(rateNumber.equalsIgnoreCase("4"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:1:mgr_prf:sr3:Non4::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
						}
						else if(rateNumber.equalsIgnoreCase("5"))
						{
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:1:mgr_prf:sr3:Non5::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
						}
						else 
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:1:mgr_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
						}
			WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:1:mgrcmt')]"));
			//txtComments.click();
//	        txtComments.sendKeys(strComments);
			Actions actions = new Actions(driver);
			actions.moveToElement(txtComments);
			actions.click();
			this.getScreenDetails("clicked on comments textarea");
			actions.sendKeys("Good Job");
			actions.build().perform();
	        SeleniumUtils.delay(3000);
	        this.getScreenDetails("entered comments");
			report.log(LogStatus.PASS, "Entered Comments");
			
			report.log(LogStatus.INFO, "Click the vertical scrollbar.");
			SeleniumUtils.scroll(driver, 0, 200);
		}
	
	 
	 public int NoOfDutiesAndComp;
	 public int NoOfGoals;
	 public int TotalGoals;
	 public int getGoalsCount() {
		 	String strDutiesComp=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdc1:ITPsv0:0:pgl9')]/tbody/tr/td[3]/span")).getText();
			String getNumberFromDCDutiesAndComp=strDutiesComp.substring(2,3);
			NoOfDutiesAndComp = Integer.parseInt(getNumberFromDCDutiesAndComp);			
			System.out.println(NoOfDutiesAndComp);
			
			String strGoals=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdc1j_id_1:ITPsv1:0:pgl9')]/tbody/tr/td[3]/span")).getText();
			String getNumberFromGoals=strGoals.substring(2,3);
			NoOfGoals = Integer.parseInt(getNumberFromGoals);			
			System.out.println(NoOfGoals);
			TotalGoals=NoOfDutiesAndComp+NoOfGoals;
			return TotalGoals;
	 }
	  
	 public void selfRateDCORGoals(String GoalType)
		{	
		 
		 	String strDutiesComp=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdc1:ITPsv0:0:pgl9')]/tbody/tr/td[3]/span")).getText();
		 	
			String getNumberFromDCDutiesAndComp=strDutiesComp.substring(2,3);
			NoOfDutiesAndComp = Integer.parseInt(getNumberFromDCDutiesAndComp);			
						
			String strGoals=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdc1j_id_1:ITPsv1:0:pgl9')]/tbody/tr/td[3]/span")).getText();
			String getNumberFromGoals=strGoals.substring(2,3);
			NoOfGoals = Integer.parseInt(getNumberFromGoals);			
					
			TotalGoals=NoOfDutiesAndComp+NoOfGoals;
		 	System.out.println("number of DC is: "+NoOfDutiesAndComp+"number of Goals is: "+NoOfGoals);
			if(GoalType.equalsIgnoreCase("Duties and Competencies"))
			{
				for (int row=0;row<NoOfDutiesAndComp;row++)
				{
						if(row==0)
						{
							//assign Exceeds expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:emp_pro:sr3:Non4::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:ec_pro_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:wkr_cmt::content')]"));
							
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Exceeds expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==1)
						{
							//assign Exceptional  
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:emp_pro:sr3:Non5::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:ec_pro_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Exceptional");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==2)
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:emp_pro:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:ec_pro_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Meets expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==3)
						{
							//Below expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:emp_pro:sr3:Non2::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:ec_pro_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Below expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==4)
						{
							//Unsatisfactory 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:emp_pro:sr3:Non1::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:ec_pro_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Unsatisfactory");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else 
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:emp_pro:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:ec_pro_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Meets expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
				}
			}
		
			else if(GoalType.equalsIgnoreCase("Goals"))
			{
				for (int row=0;row<NoOfGoals;row++)
				{
						if(row==0)
						{
							//assign Exceeds expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:emp_prf:sr3:Non4::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:ec_prf_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:wkr_cmt::content')]"));
							
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Exceeds expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==1)
						{
							//assign Exceptional  
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:emp_prf:sr3:Non5::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:ec_prf_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Exceptional");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==2)
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:emp_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:ec_prf_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Meets expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==3)
						{
							//Below expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:emp_prf:sr3:Non2::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:ec_prf_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Below expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==4)
						{
							//Unsatisfactory 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:emp_prf:sr3:Non1::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:ec_prf_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Unsatisfactory");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else 
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:emp_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:ec_prf_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:wkr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Meets expectations");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						NoOfDutiesAndComp=NoOfDutiesAndComp+1;
				}
	
			}
		
		
		}
	
	 
	 public void mgrRateDCORGoals(String GoalType)
		{	
		 
		 	String strDutiesComp=driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdc1:ITPsv0:0:pgl9')]/tbody/tr/td[3]/span")).getText();
		 	
			String getNumberFromDCDutiesAndComp=strDutiesComp.substring(2,3);
			NoOfDutiesAndComp = Integer.parseInt(getNumberFromDCDutiesAndComp);			
						
			String strGoals=driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdc1j_id_1:ITPsv1:0:pgl9')]/tbody/tr/td[3]/span")).getText();
			String getNumberFromGoals=strGoals.substring(2,3);
			NoOfGoals = Integer.parseInt(getNumberFromGoals);			
					
			TotalGoals=NoOfDutiesAndComp+NoOfGoals;
		 	System.out.println("number of DC is: "+NoOfDutiesAndComp+"number of Goals is: "+NoOfGoals);
			if(GoalType.equalsIgnoreCase("Duties and Competencies"))
			{
				for (int row=0;row<NoOfDutiesAndComp;row++)
				{
						if(row==0)
						{
							//assign Exceeds expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mgr_pro:sr3:Non4::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else if(row==1)
						{
							//assign Exceptional  
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mgr_pro:sr3:Non5::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mc_pro_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mgr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Exceptional");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==2)
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mgr_pro:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==3)
						{
							//Below expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mgr_pro:sr3:Non2::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
						}
						else if(row==4)
						{
							//Unsatisfactory 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mgr_pro:sr3:Non1::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else 
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+row+":si2:dc_sirl3:mgr_pro:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
				}
			}
		
			else if(GoalType.equalsIgnoreCase("Goals"))
			{
				for (int row=0;row<NoOfGoals;row++)
				{
						if(row==0)
						{
							//assign Exceeds expectations 
							//driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:emp_prf:sr3:Non4::icon')]")).click();
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mgr_prf:sr3:Non4::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else if(row==1)
						{
							//assign Exceptional  
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mgr_prf:sr3:Non5::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mc_prf_ic::icon')]")).click();
							SeleniumUtils.delay(4000);
							this.getScreenDetails("clicked on comments icon");
							report.log(LogStatus.PASS, "Clicked on Comments icon");
							
							//WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':sp11:reg1:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:wkr_cmt::content')]"));
							WebElement txtComments=driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mgr_cmt::content')]"));
							//txtComments.click();
//					        txtComments.sendKeys(strComments);
							Actions actions = new Actions(driver);
							actions.moveToElement(txtComments);
							actions.click();
							this.getScreenDetails("clicked on comments textarea");
							actions.sendKeys("Exceptional");
							actions.build().perform();
					        SeleniumUtils.delay(3000);
					        this.getScreenDetails("entered comments");
							report.log(LogStatus.PASS, "Entered Comments");
							
							report.log(LogStatus.INFO, "Click the vertical scrollbar.");
							SeleniumUtils.scroll(driver, 0, 200);
						}
						else if(row==2)
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mgr_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else if(row==3)
						{
							//Below expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mgr_prf:sr3:Non2::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else if(row==4)
						{
							//Unsatisfactory 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mgr_prf:sr3:Non1::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						else 
						{
							//Meets expectations 
							driver.findElement(By.xpath("//*[contains(@id,':ph1:r4:0:r1:0:ITPdtl:0:lv1:"+NoOfDutiesAndComp+":si2:dc_sirl3:mgr_prf:sr3:Non3::icon')]")).click();
							SeleniumUtils.delay(5000);
							this.getScreenDetails("clicked on rating");
							report.log(LogStatus.PASS, "Clicked on Rating type");
							
						}
						NoOfDutiesAndComp=NoOfDutiesAndComp+1;
				}
	
			}
		
		
		}
	
	 public void enterCompName(String strCompName)
	 {
		 txtCompName.click(); 
		 txtCompName.clear();
		 txtCompName.sendKeys(strCompName);
		 report.log(LogStatus.PASS, "Entered Competency Name is: "+strCompName);
	 }
	 
	 public void selectMeetingHeldDate(String noOfDays)
		{
			WebElement dateWidget = driver.findElement(By.xpath("//*[@id='_FOpt1:_FOr1:0:_FOSrMANAGER_RESOURCES_HRA_HCMPERFORMANCE_FUSE_PERFORMANCE:0:_FOTrPerformanceManagement_ManagerOverviewLite_itemNode:0:sp2:lv21:1:lv10:1:t2:0:id2::pop::cd::cg']"));
			List<WebElement> rows=dateWidget.findElements(By.tagName("tr")); 
			List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
			  
			  for (WebElement cell:columns)
			  {
			   if (cell.getText().equals(noOfDays))
			   {
			     cell.click();
				   SeleniumUtils.delay(3000);
				   System.out.println("Selected date value is: "+noOfDays);
				   break;
			   }
			  } 
			  
			  this.getScreenDetails("Selected cell vale");
			}
	 
	 public void enterWorkerComments(String strComments)
	 {
		// txtareaComments.click(); 
//		 txtareaComments.sendKeys(strComments);
		 Actions actions = new Actions(driver);
		 actions.moveToElement(txtareaComments);
		 actions.click();
		 this.getScreenDetails("clicked on comments textarea");
		 actions.sendKeys(strComments);
		 actions.build().perform();
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered comments is: "+strComments);
	 }
	 
	 public void enterGoalName(String strGoalName)
	 {
		 txtGoalName.click(); 
		 txtGoalName.sendKeys(strGoalName);
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered Goal Name is: "+strGoalName);
	 }
	 
	 
	 public void enterShareandReleaseComments(String strShareandReleaseComments)
	 {
		 txtShareandReleaseComments.click(); 
		 txtShareandReleaseComments.sendKeys(strShareandReleaseComments);
		/* Actions actions = new Actions(driver);
		 actions.moveToElement(txtShareandReleaseComments);
		 actions.click();
		 this.getScreenDetails("clicked on comments textarea");
		 actions.sendKeys(strShareandReleaseComments);
		 actions.build().perform();*/
		 SeleniumUtils.delay(2000);
		 report.log(LogStatus.PASS, "Entered comments is: "+strShareandReleaseComments);
	
	 }
	 
	 
	 public void enterManagerComments(String strComments)
	 {
		 txtManagerComments.click(); 
		 txtManagerComments.sendKeys(strComments);
		 SeleniumUtils.delay(3000);
		 report.log(LogStatus.PASS, "Entered Manager comments is: "+strComments);
	
	 }
	 
	 public void clickSearchIcon()
	 {
		 searchIcon.click();
		 SeleniumUtils.delay(5000);
	 }
	
	 public void clickDoneButton()
	 {
		 btnDone.click();
		 SeleniumUtils.delay(3000);
	 }
	 
	 //td[contains(.,'Library Goal')])[3]
	 public void selectGoalType(String strGoalType)
	 {
		 //driver.findElement(By.xpath("(//td[contains(.,'"+strGoalType+"')])[3]")).click();
		 driver.findElement(By.xpath("(//td[contains(.,'"+strGoalType+"')])")).click();
		 SeleniumUtils.delay(6000);
		 this.getScreenDetails("Selected GoalType value");
	 }
	 
	 public void selectGoalTypeNew(String strGoalType)
	 {
		 driver.findElement(By.xpath("(//td[contains(.,'"+strGoalType+"')])[3]")).click();
		 SeleniumUtils.delay(6000);
		 this.getScreenDetails("Selected GoalType value");
	 }
	 
	 public void clickGoalNameList()
	 {
		 lnkGoalName.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on Goal Name List");
	 }
	 
	 public void clickTasksButton()
	 {
		 btnTasks.click();
		 wdwait.until(ExpectedConditions.visibilityOf(lnkMGP));
		 this.getScreenDetails("Clicked Tasks button");
	 }
	 
	 
	 public void clickMyOrganization()
	 {
		 iconMyOrg.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Clicked My Organization icon");
	 }
	 
	 
	 public void clickFilterButton()
	 {
		 btnFilter.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Clicked on Filter button");
	 }
	
	 public void selectWorkersType(String strWorkerType)
	 {
		 if(strWorkerType.equalsIgnoreCase("All reports"))
		 {
			 driver.findElement(By.xpath("//input[contains(@id,':0:_FOTrPerformanceManagement_PerfMyOrganizationLite_itemNode:1:sp1:levelId:_1')]")).click();
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Selected Workers");
		 }
		 else
		 {
			 driver.findElement(By.xpath("//input[contains(@id,':0:_FOTrPerformanceManagement_PerfMyOrganizationLite_itemNode:1:sp1:levelId:_0')]")).click();
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Selected Workers");
		 }
	 }
	 
	
	 public void checkPerformanceDocuments(String strPerfDoc)
	 {
		 if(strPerfDoc.equalsIgnoreCase("2018 Performance Evaluation"))
		 {
			 driver.findElement(By.xpath("//input[contains(@id,':0:_FOTrPerformanceManagement_PerfMyOrganizationLite_itemNode:1:sp1:pdList:_2')]")).click();
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Checked Performance Documents");
		 }
		 else if(strPerfDoc.equalsIgnoreCase("2019 evaluation"))
		 {
			 driver.findElement(By.xpath("//input[contains(@id,':0:_FOTrPerformanceManagement_PerfMyOrganizationLite_itemNode:1:sp1:pdList:_1')]")).click();
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Checked Performance Documents");
		 }
		 else
		 {
			 driver.findElement(By.xpath("//input[contains(@id,':0:_FOTrPerformanceManagement_PerfMyOrganizationLite_itemNode:1:sp1:pdList:_0')]")).click();
			 SeleniumUtils.delay(2000);
			 this.getScreenDetails("Checked Performance Documents");
		 }
	 }
	 
	 
	 public void clickReviewPeriodLink()
	 {
		 lnkReviewPeriod.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked Review Period Link");
	 }
	 
	 
	 public void clickReviewPeriodList()
	 {
		 listReviewPeriod.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked Review Period List");
	 }
	 
	 public void checkPerfDocType()
	 {
		 chkPerDocType.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Checked PerfDocType checkbox");
	 }
	 
	 public void selectReviewPeriod(String strReviewPeriod)
	 {
		 driver.findElement(By.xpath("(//td[contains(.,'"+strReviewPeriod+"')])[2]")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Selected Review Period List value");
	 }
	 
	 //li[contains(.,'Ciber Review Period')]")
	 public void selectReviewPeriodList(String strReviewPeriod)
	 {
		 driver.findElement(By.xpath("(//li[contains(.,'"+strReviewPeriod+"')])")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Selected Review Period List value");
	 }
	 
	 
	 public void selectGoalName(String strGoalName)
	 {
		 driver.findElement(By.xpath("(//td[contains(.,'"+strGoalName+"')])[2]")).click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Selected GoalName value");
	 }
	 
	 public void selectReviewPeriod1(String strReviewPeriod)
	 {
		 driver.findElement(By.xpath("(//td[contains(.,'"+strReviewPeriod+"')])")).click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Selected Review Period List value");
	 }
	
	
	 
	 public void clickOkButton()
	 {
		 btnOK.click();
		 //wdwait.until(ExpectedConditions.visibilityOf(txtCGP));
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on OK button");
	 }
	 
	 
	 public void clickGoalsIcon()
	 {
		 btnGoals.click();
		 //wdwait.until(ExpectedConditions.visibilityOf(txtCGP));
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on Goals icon");
	 }
	 
	 public void clickOverallSummary()
	 {
		 btnOverallSummary.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on OverallSummary icon");
	 }
	 
	 public void clickAddGoalButton()
	 {
		 btnAddGoal.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Clicked on Add Goal button");
	 }
	
	 
	 public void clickNextButton()
	 {
		 btnNext.click();
		// wdwait.until(ExpectedConditions.visibilityOf(txtCGPG));
		 SeleniumUtils.delay(6000);
		 this.getScreenDetails("Clicked on Next button");
	 }
	 
	 
	 public void clickSearchResButton()
	 {
		 btnSearch1.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Search button");
	 }
	 
	 
	 public void clickSubmitButton()
	 {
		 btnSubmit.click();
		 SeleniumUtils.delay(8000);
		 this.getScreenDetails("Clicked on Submit button");
	 }
	 
	 
	 public void clickYesButton()
	 {
		 btnYes.click();
		 SeleniumUtils.delay(4000);
		 this.getScreenDetails("Clicked on Yes button");
	 }
	 
	 
	 public void clickSelectDateIcon()
	 {
		 iconSelectDate.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Clicked on Select Date");
	 }
	 
	 public void clickYesConfrimButton()
	 {
		// btnYes1.click();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("arguments[0].click();", btnYes1);
		 SeleniumUtils.delay(4000);
		 this.getScreenDetails("Clicked on Yes button");
	 }
	 
	 public void clickSearchButton()
	 {
		 btnSearch.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Clicked on Search button");
	 }
	 
	 
	 public void clickApplyButton()
	 {
		 btnApply.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on Apply button");
	 }
	 
	 
	 public void clickTaskCompStatus()
	 {
		 tabTaskCompStatus.click();
		 SeleniumUtils.delay(3000);
		 this.getScreenDetails("Clicked on Task Completion Status");
	 }
	 
	 
	 public void clickSaveAndCloseButton()
	 {
		 btnSaveandClose.click();
		 SeleniumUtils.delay(6000);
		 this.getScreenDetails("Clicked on Save and Close button");
	 }
	 
	 
	 public void clickShareButton()
	 {
		 btnShare.click();
		 SeleniumUtils.delay(6000);
		 this.getScreenDetails("Clicked on Share button");
	 }
	 
	 
	 public void clickSaveButton()
	 {
		 btnSave.click();
		 SeleniumUtils.delay(5000);
		 this.getScreenDetails("Clicked on Save button");
	 }
	 
	 public void clickGLOKButton()
	 {
		 btnGLOK.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on OK button on confiramtion dailog");
	 }
	 
	 
	 public void clickSubmitForApprovalButton()
	 {
		 btnSubmitforApproval.click();
		 SeleniumUtils.delay(2000);
		 this.getScreenDetails("Clicked on Submit for Approval button");
	 }
	
	 
	 public boolean isContinueButtonDisplayed()
	 {
		 List<WebElement> ele=driver.findElements(By.xpath("//button[contains(.,'Continue')]"));
		 if(ele.size()<=0)
			 return false;
		 else
			 return true;
	 }
	 	 
	 public void clickContinueButton()
	 {
		 btnContinue.click();
		 /* JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("arguments[0].click();", btnContinue);*/
        //  new Actions(driver).moveToElement(btnContinue).click().perform();
		 //wdwait.until(ExpectedConditions.visibilityOf(buttonAdd));
		 SeleniumUtils.delay(8000);
		 this.getScreenDetails("Clicked on Continue button");
	 }
	 
	 
	 public void clickAddButton()
	 {
		 this.getScreenDetails("Clicked on SetGoals link");
		 buttonAdd.click();
		 SeleniumUtils.delay(2000);
		 wdwait.until(ExpectedConditions.visibilityOf(txtCompName));
		 this.getScreenDetails("Clicked on Add button");
	 }
	 
	//span[contains(.,'Managing Change')]
	 public void selectCompetency(String strCompName)
	 {
		driver.findElement(By.xpath("//span[contains(.,'"+strCompName+"')]")).click();
		SeleniumUtils.delay(3000);
		this.getScreenDetails("Clicked on Competency cell");
	 }
	
	 
	 public void clickActaulCompDate()
	 {
	    	dateActaulComp.click();
	    	SeleniumUtils.delay(2000);
	    	report.log(LogStatus.PASS, "Clicked on Select Actual Completion Date picker");
	    	
	 }
	 
	//*[@id="_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_CareerandPerformance:0:MAnt2:2:sp3:id3::pop::cd::cg"]
	 public void selectDayFromActualCompDate(String noOfDays)
	 {
			WebElement dateWidget = driver.findElement(By.xpath("//table[contains(@id,':0:MAnt2:2:sp3:id3::pop::cd::cg')]"));
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
			  this.getScreenDetails("Select Day from Actual Completion Date");
			}
	 
	 public void clickShareandRelease() throws TestException{
			btnShareandRelease.click();
			//SeleniumUtils.delay(8000);
			 wdwait.until(ExpectedConditions.visibilityOf(btnOK));
			this.getScreenDetails("clicked Share and Release button");
			report.log(LogStatus.PASS, "Clicked on ShareandRelease button");
		}
	
	 public boolean isDisplayed() {
    	 report.log(LogStatus.PASS, "Performance Page is Loaded Successfully");
    	 return SeleniumUtils.isDisplayed(driver, txtEvaluations, context.getFindTimeout());
    }
	 
	  public Item getScreenDetails(){
	    	String xyz = Screenshot.takeScreenshotX(driver, "EntryPerformance", context);
	    	report.addScreenCapture(xyz);
	    	String projectPath = System.getProperty("user.dir");   	
	    	String sShotPath = projectPath+"/report/"+xyz;
	    	report.log(LogStatus.INFO, "<a href='"+sShotPath+"'><span class='label info'>Performance Page</span></a>");
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
