package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Project extends BaseClass {

	@Test(testName = "Add duplicate project", priority = 41, enabled = false)
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
	
	@Test(testName = "Add new project", priority = 42, enabled = false)
	public void new_project() {
		System.out.println("//For Adding new project");
		project.add_newProject(driver);
		project.validate_new_project(driver);
		logger.log(LogStatus.INFO, "New project validated successfully!");
		
	}
	
	@Test(testName = "Edit new project", priority = 43, enabled = true)
	public void edit_project() {
		logger = rep.startTest("Project scenarios");
		System.out.println("//For Editing new project");
		login.login(driver);
		business.click_module(driver, "Projects");
		project.edit_project(driver);
		project.validate_editproject(driver);
		logger.log(LogStatus.INFO, "New project edited validated successfully!");
}
}