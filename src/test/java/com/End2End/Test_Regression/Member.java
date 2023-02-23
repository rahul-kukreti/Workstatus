package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Member extends BaseClass {

	@Test(testName = "New Member sent invitation", priority = 26, enabled = false)
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

	@Test(testName = "For setup new member", priority = 27, enabled = false)
	public void setup_window() throws InterruptedException {
		System.out.println("//For setup new member.");
		member.getWindow(driver);
		member.click_save_account(driver);
		sign.validatae_newUser(driver);
		login.login(driver);
		business.click_module(driver, "Members");
		member.validate_newMember(driver, "Rahul");
		logger.log(LogStatus.INFO, "New member validated successfully.!");
	}

	@Test(testName = "For editing limit", priority = 28, enabled = false)
	public void Limit() {
		System.out.println("//For editing limit");
		member.edit_limit(driver);
		member.limit_details(driver);
		member.click_limit(driver);
		member.validate_limit(driver);
		logger.log(LogStatus.INFO, "Member limit edited validated successfully.!");

	}
	
	@Test(testName = "For duplicate request", priority = 29, enabled = false)
	public void duplicateRequest() {
		System.out.println("//For sending duplicate request");
		member.click_addmember(driver);
		member.member_details(driver);
		member.click_save(driver);
		member.validate_Duplicate_memberRequest(driver);
		logger.log(LogStatus.INFO, "Duplicate member request validated successfully.!");
	}
	
	@Test(testName = "For tracking", priority = 30, enabled = true)
     public void tracking() {
		logger = rep.startTest("New Member scenario");
		System.err.println("//For tracking a member");
		business.click_module(driver, "Members");//baad m hata dena
	}
}
