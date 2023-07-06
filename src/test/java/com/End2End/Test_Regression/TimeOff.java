package com.End2End.Test_Regression;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;

public class TimeOff extends BaseClass {

	@Test(testName = "Add policy", priority = 66, enabled = true)
	public void add_policy() throws FilloException {
		logger = rep.startTest("TimeOff scenarios");
		login.login(driver);
		System.out.println("//For adding policy");
		time.click_timeoff_module(driver);
		time.add_policy(driver);
		String policy_name = record.getField("Policy Name");
		commFunc.put_field_data(driver, "policyName", policy_name);
		String policy_type = record.getField("Policy Type");
		commFunc.selectDropdown(driver, "accural", policy_type);
		commFunc.put_field_data(driver, "maxAccrualAmount", "9");
		commFunc.selectDropdown(driver, "balance", "No");
		commFunc.selectDropdown(driver, "approval", "No");
		commFunc.selectDropdown(driver, "rollOver", "No");
		commFunc.selectDropdown(driver, "status", "Paid");
		time.save_btn(driver);
		time.validate_policy(driver);
		logger.log(LogStatus.INFO, "policy added successfully!");

	}

	@Test(testName = "Edit/view policy", priority = 67, enabled = true)
	public void edit_view() throws InterruptedException {
		System.out.println("//For view and edit policy");
		time.click_action_icon(driver);
		time.policy_dropdown(driver, "View");
		// To click on back icon
		Thread.sleep(3000);
		commFunc.Click(driver,
				By.xpath("//ancestor::div[text()='Back']//parent::div//child::span[@class='mat-button-wrapper']"));
		time.click_action_icon(driver);
		time.policy_dropdown(driver, "Edit");
		time.edit_view_policy(driver);
		time.save_btn(driver);
		time.validateEdit_policy(driver);
		logger.log(LogStatus.INFO, "policy updated successfully!");

	}

	@Test(testName = "Archive policy", priority = 68, enabled = true)
	public void archive() {
		System.out.println("//For Archive policy");
		time.click_action_icon(driver);
		time.policy_dropdown(driver, "Archive");
		time.validateArchive_policy(driver);
		logger.log(LogStatus.INFO, "policy archive successfully!");
	}

	@Test(testName = "Un-Archive policy", priority = 69, enabled = true)
	public void un_archive() {
		time.unArchive(driver);
		time.click_action_icon(driver);
		time.policy_dropdown(driver, "Unarchive");
		time.validate_UnArchive_policy(driver);
		logger.log(LogStatus.INFO, "policy Un-archive successfully!");

	}

	@Test(testName = "Add timeOff", priority = 70, enabled = true)
	public void add_timeoff() throws InterruptedException, FilloException {
		System.out.println("//For adding timeOff");
		time.click_timeoff_module(driver);
		time.timeOff_request(driver);
		commFunc.selectDropdown(driver, "policy", "Time table");
		Thread.sleep(2000);
		time.Timoff_details(driver);
		String reason = record.getField("Reason");
		commFunc.put_field_data(driver, "reason", reason);
		time.save_btn(driver);
		time.validate_timeOff(driver);
		logger.log(LogStatus.INFO, "TimeOff added successfully!");
	}

	@Test(testName = "Edit/view timeOff", priority = 71, enabled = true)
	public void edit_view_Time() throws InterruptedException {
		System.out.println("//For editing timeOff");
		time.click_action_icon(driver);
		time.policy_dropdown(driver, "View request");
		Thread.sleep(3000);
		time.edit_timeoff(driver);
		time.save_btn(driver);
		time.validate_Edit_timeOff(driver);
		logger.log(LogStatus.INFO, "TimeOff updated successfully!");
	}

	@Test(testName = "Approved timeOff", priority = 72, enabled = true)
	public void approve_timeoff() {
		System.out.println("//For approve timeOff");
		time.click_action_icon(driver);
		time.policy_dropdown(driver, "Approve request");
		time.validate_Approve_timeOff(driver);

	}
}
