package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Member extends BaseClass {

	@Test(testName = "New Member sent invitation", priority = 26, enabled = true)
	public void click_businessoption() {
		logger = rep.startTest("New Member scenario");
		System.out.println("//For Adding new member");
		business.click_module(driver, "Members");
		member.click_addmember(driver);
		member.member_details(driver);
		member.click_save(driver);
		member.validate_memberRequest(driver);
		logger.log(LogStatus.INFO, "New member invitation sent successfully.!");
	}
	
	@Test(testName = "For setup new member", priority = 27, enabled = true)
	public void setup_window() {
		member.getWindow(driver);
		
	}
	
}
