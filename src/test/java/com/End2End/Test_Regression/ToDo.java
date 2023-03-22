package com.End2End.Test_Regression;

import org.testng.annotations.Test;

public class ToDo extends BaseClass {

	@Test(testName = "Add To-DO", priority = 47, enabled = true)
	public void add_todo() {
		logger = rep.startTest("To-Do's scenarios");
		System.out.println("//For Add To-dos");
		member.logout(driver); //open when full fledge running
		member.login_old(driver);
		business.click_module(driver, "To-dos");
	}

}
