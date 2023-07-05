package com.End2End.Test_Regression;

import org.testng.annotations.Test;

public class TimeOff extends BaseClass {
	
	@Test(testName = "Add timeOff", priority = 66, enabled = true)
	public void add_timeoff() {
		logger = rep.startTest("TimeOff scenarios");
		System.out.println("//For adding timeOff");
		login.login(driver);
		time.click_timeoff_module(driver);
		time.add_policy(driver);
		
	}

}
