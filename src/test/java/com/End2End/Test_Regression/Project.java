package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Project extends BaseClass {

	@Test(testName = "Add duplicate project", priority = 41, enabled = true)
	public void click_businessoption() throws InterruptedException {
		logger = rep.startTest("Project scenarios");
		System.out.println("//For Adding duplicate project");
		login.login(driver);
		business.click_module(driver, "Projects");
		project.click_project_btn(driver);
		project.duplicate_details(driver);
		project.validate_duplicate_project(driver);
		logger.log(LogStatus.INFO, "Duplicate project validated successfully!");
	}
}
