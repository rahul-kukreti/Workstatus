package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Forgotpassword extends BaseClass {

	@Test(testName = "Click forgot password link", priority = 15, enabled = false)
	public void click_support_feat() {
		//logger = rep.startTest("Forgot password scenarios");
		System.out.println("//For clicking on forgot password link..!!");
		fp.click_fpLink(driver);
		fp.validate_fpLink(driver);
		logger.log(LogStatus.INFO, "forgot password link successfully!");

	}

	@Test(testName = "Click invalid email in forgot password ", priority = 16, enabled = false)
	public void validate_wrongemail() {
		System.out.println("//For validating wrong email..!!");
		fp.wrong_email(driver);
		fp.validate_invalidEmail(driver);
		logger.log(LogStatus.INFO, "Inavlid email for forgot password validated successfully!");

	}

	@Test(testName = "Click valid email in forgot password ", priority = 17, enabled = false)
	public void validate_validemail() {
		System.out.println("//For validating valid email..!!");
		fp.email_field(driver);
		fp.validate_ValidEmail(driver);
		logger.log(LogStatus.INFO, "Valid email for forgot password validated successfully!");
	}

	@Test(testName = "forgot password ", priority = 18, enabled = false)
	public void forgot_password() throws InterruptedException {
		System.out.println("//For validating forgot password..!!");
		fp.getWindow(driver);
		fp.click_resetbtn(driver);
		fp.validate_resetpass(driver);
		logger.log(LogStatus.INFO, "Forgot password validated successfully!");
	}
	
	@Test(testName = "Login for business owner", priority = 19, enabled = true)
	public void login_for_businesOwner() {
		logger = rep.startTest("Forgot password scenarios");
		Login.Success_login();
		logger.log(LogStatus.INFO, "Login successful for business owner!");
	}
}
