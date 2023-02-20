package com.End2End.Test_Regression;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class BugReport extends BaseClass {

	@Test(testName = "Click Bug Report tab", priority = 10, enabled = true)
	public void click_support_feat() {
		logger = rep.startTest("Bug report scenarios");
		System.out.println("//For clicking on bug report link..!!");
		bg.click_BugReportlink(driver);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		bg.validate_reportlink(driver);
		logger.log(LogStatus.INFO, "Bug report link opened successfully!");

	}
	
	@Test(testName = "Validate blank title", priority = 11, enabled = true)
	public void blank_title() {
		System.out.println("//For validatinig blank title..!!");
		bg.blank_title(driver);
		bg.click_file(driver,"joins.png");
		bg.severity(driver);
	}
	
}
