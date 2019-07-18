/**
 Test Name: Taleo_CreateCandidate
 Created By: Ciber
 Creation Date:July 24,2018
 Modified By:
 Modified Date:
End Date:
 Test Description: This script is used to create a candidate
 Prerequisite: Test data should be proper before running this script
 */

package com.cloud.test.HCM2;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloud.BaseWebTest;
import com.cloud.exceptions.TestException;
import com.cloud.pageobjects.HCM.TaleoHomePage;
import com.cloud.pageobjects.HCM.TaleoLoginPage;
import com.cloud.util.DataProviderRepository;
import com.cloud.utils.TestNGListeners;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestNGListeners.class)
public class Taleo_CreateCandidate extends BaseWebTest {
	SoftAssert sAssert;
	public WebDriverWait wdwait;

	@Test(dataProvider = "CloudDataProviderUtil_HCM_Phase2", dataProviderClass = DataProviderRepository.class, description = "This test is to create a candidate")
	public void PM_TrackCompletionStatusPD_Mgr(String UserName, String Password, String WorkersType,
			String PerformanceDocuments) throws TestException, InterruptedException, IOException {
		sAssert = new SoftAssert();
		report.log(LogStatus.INFO, "Step 1. Launch Cloud application and Sign in.");
		TaleoLoginPage objLogin = new TaleoLoginPage(driver, report);
		sAssert.assertTrue(objLogin.isUserNameDisplayed());
		if (objLogin.isUserNameDisplayed()) {
			report.log(LogStatus.PASS, "Step 1.1.Cloud application is launched successfully");
		} else {
			report.log(LogStatus.FAIL, "Step 1.1.Launching of Cloud application is  failed");
		}

		report.log(LogStatus.INFO, "Step 2. Enter Valid UserName and Password to login.");
		//TaleoHomePage objHome = objLogin.loginToCloudApplication(UserName, Password);
		TaleoHomePage objHome = objLogin.loginToCloudApplication("recruiter", "Taleo@123");
		
		report.log(LogStatus.INFO, "Step 3. Click the Recruiting link");
		objHome.clickRecruiting();
		
		driver.findElement(By.xpath("//img")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		

		sAssert.assertAll();

	}

}