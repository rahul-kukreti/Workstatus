package com.End2End.Test_Regression;


import java.util.ArrayList;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

public class BugReport extends BaseClass {

	@Test(testName = "Click Bug Report tab", priority = 10, enabled = true)
	public void click_support_feat() {
		logger = rep.startTest("Bug report scenarios");
		System.out.println("//For clicking on bug report link..!!");
		bg.click_BugReportlink(driver);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(3));
		bg.validate_reportlink(driver);
		logger.log(LogStatus.INFO, "Bug report link opened successfully!");

	}

	@Test(testName = "Validate blank title", priority = 11, enabled = true)
	public void blank_title() throws InterruptedException {
		System.out.println("//For validatinig blank title..!!");
		driver.navigate().refresh();
		bg.blank_title(driver);
		// bg.click_file(driver,"joins.png");
		bg.severity(driver);
		bg.reproducible(driver);
		bg.platform(driver);
		
		bg.captcha_bug(driver);
		bg.btn_click(driver);
		String str = driver.switchTo().alert().getText();
		String cap = "Invalid Captcha";
		System.out.println("Alert messagae:" + str);
		driver.switchTo().alert().accept();
		if(cap.equalsIgnoreCase(str)) {
			bg.captcha_bug(driver);
			bg.btn_click(driver);
		}
		logger.log(LogStatus.INFO, "Validate blank title successfully!" + '\n' + "Alert message: " + str);

	}

	@Test(testName = "Validate blank email", priority = 12, enabled = true)
	public void blank_description() throws InterruptedException {
		System.out.println("//For validatinig blank email..!!");
		driver.navigate().refresh();
		bg.blank_email(driver);
		bg.severity(driver);
		bg.reproducible(driver);
		bg.platform(driver);
		bg.captcha_bug(driver);
		bg.btn_click(driver);
		String str = driver.switchTo().alert().getText();
		String cap = "Invalid Captcha";
		System.out.println("Alert messagae:" + str);
		driver.switchTo().alert().accept();
		if(cap.equalsIgnoreCase(str)) {
			bg.captcha_bug(driver);
			bg.btn_click(driver);
		}
		logger.log(LogStatus.INFO, "Validate blank email successfully!" + '\n' + "Alert message: " + str);

	}
	
	@Test(testName = "Validate blank captcha", priority = 13, enabled = true)
	public void blank_platform() throws InterruptedException {
		System.out.println("//For validatinig blank captcha..!!");
		driver.navigate().refresh();
		bg.bug_details(driver);
		bg.severity(driver);
		bg.reproducible(driver);
		bg.platform(driver);
		//bg.captcha_bug(driver);
		bg.btn_click(driver);
		String str = driver.switchTo().alert().getText();
		System.out.println("Alert messagae:" + str);
		driver.switchTo().alert().accept();
		logger.log(LogStatus.INFO, "Validate blank captcha successfully!" + '\n' + "Alert message: " + str);

	}
	
	@Test(testName = "Validate bug report form successfully", priority = 14, enabled = true)
	public void bugreport_submit() throws InterruptedException {
		System.out.println("//For Validating bug report form..!!");
		driver.navigate().refresh();
		bg.bug_details(driver);
		bg.severity(driver);
		bg.reproducible(driver);
		bg.platform(driver);
		bg.captcha_bug(driver);
		bg.btn_click(driver);
		
		try {
		bg.validate_bugpage(driver);
		}
		
		catch(Exception e) {
			Thread.sleep(4000);
		if(ExpectedConditions.alertIsPresent()==null) {
			
			System.out.println("No alert is present");
			
		}
		
		else {
			//String str = driver.switchTo().alert().getText();
			//String cap = "Invalid Captcha";
			//System.out.println("Alert messagae:" + str);
			bg.captcha_bug(driver);
			bg.btn_click(driver);
			bg.validate_bugpage(driver);
		}
		}
		
		logger.log(LogStatus.INFO, "Validate bug report form successfully!");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}
 
}
