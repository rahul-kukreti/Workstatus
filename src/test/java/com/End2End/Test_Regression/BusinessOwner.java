package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class BusinessOwner extends BaseClass {

	@Test(testName = "Click business option", priority = 20, enabled = false)
	public void click_businessoption() {
		logger = rep.startTest("Business option");
		System.out.println("//For selecting business option");
		business.click_businessOption(driver);
		business.click_continue_btn(driver);
		business.validate_businessCheckbox(driver);
		logger.log(LogStatus.INFO, "Business checkbox selected successfully.!");
	}

	@Test(testName = "Click business option", priority = 21, enabled = false)
	public void click_ofcOptin() {
		System.out.println("//For selecting office option");
		business.click_OfcOption(driver);
		business.click_continue_btn(driver);
		business.validate_ofcCheckbox(driver);
		logger.log(LogStatus.INFO, "Office checkbox selected successfully.!");

	}

	@Test(testName = "Duplicate Organization details", priority = 22, enabled = false)
	public void Duplicate_organization_details() throws InterruptedException {
		System.out.println("//For putting duplicate organization details..");
		business.Organisation(driver);
		business.dropdownValues(driver);
		business.validate_Duplicateorganization(driver);
		logger.log(LogStatus.INFO, "Duplicate Organization details validated successfully.!");
	}

	@Test(testName = "New Organization details", priority = 23, enabled = false)
	public void new_organization() {
		System.out.println("//For putting new organization details..");
		business.newName(driver);
		business.validate_organizationDetails(driver);
		logger.log(LogStatus.INFO, "New Organization details validated successfully.!");

	}
	@Test(testName = "Checkboxes selected", priority = 24, enabled = true)
	public void checkboxesSelect() {
		logger = rep.startTest("Business option"); //baad m hata denge
		business.click_checkboxes(driver);
		business.validate_checkboxes(driver);
		logger.log(LogStatus.INFO, "checkboxes validated successfully.!");
	}
	
	
	//p[text()=' Hello, Jack ']

}
