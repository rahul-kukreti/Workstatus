package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class BusinessOwner extends BaseClass {

	@Test(testName = "Click business option", priority = 20, enabled = true)
	public void click_businessoption() {
	     logger = rep.startTest("Business option scenarios");
		System.out.println("//For selecting business option");
		business.click_businessOption(driver);
		business.validate_businessCheckbox(driver);
		business.click_continue_btn(driver);
		//business.validate_businessCheckbox(driver);
		logger.log(LogStatus.INFO, "Business checkbox selected successfully.!");
	}

	@Test(testName = "Click business option", priority = 21, enabled = true)
	public void click_ofcOptin() {
		System.out.println("//For selecting office option");
		business.click_OfcOption(driver);
		business.validate_ofcCheckbox(driver);
		business.click_continue_btn(driver);
		//business.validate_ofcCheckbox(driver);
		logger.log(LogStatus.INFO, "Office checkbox selected successfully.!");

	}

	@Test(testName = "Duplicate Organization details", priority = 22, enabled = true)
	public void Duplicate_organization_details() throws InterruptedException {
		System.out.println("//For putting duplicate organization details..");
		business.Organisation(driver);
		business.dropdownValues(driver);
		business.validate_Duplicateorganization(driver);
		logger.log(LogStatus.INFO, "Duplicate Organization details validated successfully.!");
	}

	@Test(testName = "New Organization details", priority = 23, enabled = true)
	public void new_organization() {
		System.out.println("//For putting new organization details..");
		business.newName(driver);
		business.validate_organizationDetails(driver);
		logger.log(LogStatus.INFO, "New Organization details validated successfully.!");

	}

	@Test(testName = "Checkboxes selected", priority = 24, enabled = true)
	public void checkboxesSelect() {
		System.out.println("//For selecting checkboxes!");
		business.click_checkboxes(driver);
		business.validate_checkboxes(driver);
		logger.log(LogStatus.INFO, "checkboxes validated successfully.!");
	}

	@Test(testName = "Project Name", priority = 25, enabled = true)
	public void project_name() throws InterruptedException {
		System.out.println("//For entering and validating project name!");
		business.projectName(driver);
		business.dialogbox(driver);
		System.out.println("//dialogue box clicked successfully!");
		business.click_module(driver,"Projects");
		business.validate_project(driver);
		logger.log(LogStatus.INFO, "projects name validated successfully.!");
	}

	// p[text()=' Hello, Jack ']

}
