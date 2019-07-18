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
 * Contains object properties and methods for Home Page. @author
 * CIBER @param @return @throws
 */
public class TaleoHomePage extends BasePageObject {

	public WebDriver driver;
	public WebDriverWait wdwait;

	@FindBy(xpath = "//h1[contains(.,'Welcome to your Talent Management suite!')]")
	private WebElement txtHome;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'UIShome::icon')]")
	private WebElement imgHome;

	@FindBy(xpath = "(//a[contains(.,'Recruiting')])[2]")
	private WebElement lnkRecruiting;

	@FindBy(how = How.XPATH, using = "//*[@id='pt1:_UISlg1']")
	private WebElement lnkSignOut;

	public TaleoHomePage(WebDriver driver, ExtentTest report) throws TestException {
		super(report);
		this.driver = driver;
		wdwait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
		wdwait.until(ExpectedConditions.visibilityOf(txtHome));
		if (!isDisplayed()) {
			throw new TestException(this.getClass().getName() + " is not loaded");
		}
		System.out.println("******************************* Home Page *****************************");
		this.getScreenDetails();
	}

	public boolean isHomeImageDisplayed() {
		return imgHome.isDisplayed();
	}

	public void clickSignOut() {
		lnkSignOut.click();
		SeleniumUtils.delay(5000);
		report.log(LogStatus.PASS, "Clicked on signout link");
	}

	
	public void clickRecruiting() throws TestException {
		lnkRecruiting.click();
		SeleniumUtils.delay(5000);
		report.log(LogStatus.PASS, "Clicked on Recruiting link");

	}

	public boolean isDisplayed() {
		report.log(LogStatus.PASS, "Home Page is Loaded Successfully");
		return SeleniumUtils.isDisplayed(driver, txtHome, context.getFindTimeout());
	}

	public Item getScreenDetails() {
		String xyz = Screenshot.takeScreenshotX(driver, "EntryHome", context);
		report.addScreenCapture(xyz);
		String projectPath = System.getProperty("user.dir");
		String sShotPath = projectPath + "/report/" + xyz;
		report.log(LogStatus.INFO, "<a href='" + sShotPath + "'><span class='label info'>Home Page</span></a>");
		return new Item(xyz);
	}

	public Item getScreenDetails(String strTitle) {
		String xyz = Screenshot.takeScreenshotX(driver, strTitle, context);
		report.addScreenCapture(xyz);
		String projectPath = System.getProperty("user.dir");
		String fullprojectPath = projectPath + "/report/" + xyz;
		report.log(LogStatus.INFO,
				"<a href='" + fullprojectPath + "'><span class='label info'>" + strTitle + "</span></a>");
		return new Item(xyz);
	}
}
