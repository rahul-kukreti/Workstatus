package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Project extends BaseClass {

	@Test(testName = "Add new project project", priority = 41, enabled = true)
	public void click_businessoption() throws InterruptedException {
		logger = rep.startTest("Project scenarios");
		System.out.println("//For Adding new project");
		//login.login(driver);//remove when full fledge
		business.click_module(driver, "Projects");
		project.click_project_btn(driver);
		project.duplicate_details(driver);
		project.validate_new_project(driver);
		logger.log(LogStatus.INFO, "New project validated successfully!");
	}

	@Test(testName = "Add duplicate project", priority = 42, enabled = true)
	public void new_project() throws InterruptedException {
		System.out.println("//For Adding duplicate project");
		project.click_project_btn(driver);
		project.duplicate_details(driver);
		project.validate_duplicate_project(driver);
		logger.log(LogStatus.INFO, "Duplicate project validated successfully!");

	}

	@Test(testName = "Edit new project", priority = 43, enabled = true)
	public void edit_project() {
		System.out.println("//For Editing new project");
		project.edit_project(driver);
		project.validate_editproject(driver);
		logger.log(LogStatus.INFO, "New project edited validated successfully!");
	}

	@Test(testName = "Archive project", priority = 44, enabled = true)
	public void archieve_project() {
		System.out.println("//For archieve project");
		project.Archieve_project(driver);
		project.validate_archive(driver);
		logger.log(LogStatus.INFO, "Project moved to archive successfully!");
	}

	@Test(testName = "Un-archive project", priority = 45, enabled = true)
	public void Un_archieve_project() {
		System.out.println("//For un-archieve project");
		project.click_archive_tab(driver);
		project.un_archieve(driver);
		project.validate_unArchive(driver);
		logger.log(LogStatus.INFO, "Project moved to Un-archive successfully!");
	}
	
	@Test(testName = "Check move project", priority = 46, enabled = true)
	public void check_move() {
		System.out.println("//For move project");
		project.Move_project(driver);
		logger.log(LogStatus.INFO, "Project not moved without organization!");
	}
}