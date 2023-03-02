package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Member extends BaseClass {

	@Test(testName = "New Member sent invitation", priority = 26, enabled = false)
	public void new_member() {
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
		logger = rep.startTest("New Member scenario");
		System.out.println("//For sending duplicate request");
		business.click_module(driver, "Members");
		member.click_addmember(driver);
		member.member_details(driver);
		member.click_save(driver);
		member.validate_Duplicate_memberRequest(driver);
		logger.log(LogStatus.INFO, "Duplicate member request validated successfully.!");
	}

	@Test(testName = "For tracking", priority = 30, enabled = false)
	public void tracking() {
		System.out.println("//For tracking a member");
		member.click_tracking(driver);
		member.validate_tracking(driver);
		logger.log(LogStatus.INFO, "Member tracking validated successfully.!");
	}

	@Test(testName = "For logout", priority = 31, enabled = false)
	public void logout() {
		member.logout(driver);
	}

	@Test(testName = "For online filtering records", priority = 32, enabled = false)
	public void filter_online() throws InterruptedException {
		System.out.println("//For online filtering records");
		member.login_old(driver);
		business.click_module(driver, "Members");
		member.click_filter(driver);
		member.validate_online_tracking(driver, "ONLINE");
		logger.log(LogStatus.INFO, "Online filtering records validated successfully.!");
	}

	@Test(testName = "For offline filtering records", priority = 33, enabled = false)
	public void filter_offline() throws InterruptedException {
		System.out.println("//For offline filtering records");
		member.click_filter(driver);
		member.validate_offline_tracking(driver, "OFFLINE");
		logger.log(LogStatus.INFO, "Offline filtering records validated successfully.!");
	}

	@Test(testName = "For clear filter records", priority = 34, enabled = false)
	public void clear_filter() {
		System.out.println("//For clearing filter");
		member.clear_filter(driver);
		logger.log(LogStatus.INFO, "clear filtering records validated successfully.!");
	}

	@Test(testName = "For Resend invitation link", priority = 35, enabled = true)
	public void Resend_invitation() {
		//logger = rep.startTest("New Member scenario");
		System.out.println("//For Resend invitation");
		//member.login_old(driver);
		//business.click_module(driver, "Members");
		member.click_invitedTab(driver);
		member.resend_link(driver);
		member.validate_resend(driver);
		logger.log(LogStatus.INFO, "Member resend request sent successfully!");
	}

	@Test(testName = "For Edit invitation update", priority = 36, enabled = true)
	public void EditInvite() throws InterruptedException {
		System.out.println("//For Edit invite updation");
		member.edit_invite(driver);
		Thread.sleep(3000);
		member.click_save(driver);
		member.validate_editInvite(driver);
		logger.log(LogStatus.INFO, "Member edit invitation updated successfully!");
 	}
	

	@Test(testName = "For cancel request", priority = 37, enabled = true)
	public void Cancel_request() {
		//logger = rep.startTest("New Member scenario");
		System.out.println("//For cancel request");
		//member.login_old(driver);
		member.cancel_invite(driver);
		member.validate_cancelInvite(driver);
		logger.log(LogStatus.INFO, "Member request cancelled successfully!");
 	}

}
