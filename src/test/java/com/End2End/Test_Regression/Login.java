package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Login extends BaseClass {
	
	@Test(testName = "Click Signup tab", priority = 4, enabled = true)
	public void click_loginbtn() {
		logger = rep.startTest("Login scenarios");
		System.out.println("//For clicking on login butotn..!!");
		//login.click_login_tab(driver);//need to remove this before full fledge running code
		login.login(driver);
		login.validatae_confirmation(driver);
		logger.log(LogStatus.INFO, "login tab successfully opened!");

}
	@Test(testName = "Confirm Login", priority = 5, enabled = true)
	public void ConfirmingLogin() throws InterruptedException {
		System.out.println("//For login successfully via a confirming email..");
		login.getWindow(driver);
		logger.log(LogStatus.INFO, "New user confirmed successfully!");
	}
	
	@Test(testName = "Success Login", priority = 6, enabled = true)
	public void Success_login() {
		System.out.println("//For validating success login.");
		login.login(driver);
		login.validate_login(driver);
		logger.log(LogStatus.INFO,"User logged in successfully!.");
	}
	
	@Test(testName = "Success Logout", priority = 7, enabled = true)
	public void Success_logout() throws InterruptedException {
		System.out.println("//For validating success logout.");
		login.click_logout(driver);
		logger.log(LogStatus.INFO,"User logOut successfully!.");
	}
	
	
}
