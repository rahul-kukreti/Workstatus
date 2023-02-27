package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Teams extends BaseClass {

	@Test(testName = "Add new team", priority = 38, enabled = true)
	public void new_member() throws InterruptedException {
		logger = rep.startTest("New Team scenario");
		System.out.println("//For Adding new Team");
		member.login_old(driver);// baad m hata dena esko
		member.logout(driver);
		login.login(driver);
		business.click_module(driver, "Teams");
		teams.click_addTeam(driver);
		teams.team_details(driver);
		teams.validate_team(driver);
		logger.log(LogStatus.INFO, "New Team validate successfully!");
	}
	
	@Test(testName = "Filter validation", priority = 39, enabled = true)
	public void filter() {
		System.out.println("//For validating team filter");
		teams.filter(driver);
		teams.validate_filter(driver);
		logger.log(LogStatus.INFO, "Team filter validate successfully!");
	}
	

}
