package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Signup extends BaseClass {
	
	@Test(testName = "Click Signup tab", priority = 1, enabled = true)
	public void click_signup_tab() {
		logger = rep.startTest("SignUp scenarios");
		System.out.println("//For clicking on signUp tab..!!");
		sign.click_signup_tab(driver);
		sign.validate_signup_page_url(driver);
		logger.log(LogStatus.INFO, "Sign-up tab successfully opened!");
	}
	
	@Test(testName = "Duplicate user validation", priority = 2, enabled = true)
	public void duplicateForm() throws InterruptedException {
		
		System.out.println("//For validating duplicate user..!!");
		sign.duplicate_user(driver);
		sign.click_checkbox(driver);
		sign.click_signup_btn(driver);
		sign.validate_duplicacy(driver);
		logger.log(LogStatus.INFO, "Duplicate user validated successfully!");
	}
	
	@Test(testName = "New user validation", priority = 3, enabled = true)
	public void add_user() throws InterruptedException {
		System.out.println("//For validating new user!!");
		sign.pasteEmail(driver);
		sign.validatae_newUser(driver);
		logger.log(LogStatus.INFO, "New user validated successfully!");
	}

}
