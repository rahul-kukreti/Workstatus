package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.End2End.Test_Regression.BaseClass;

public class Signup_Objectpage extends BaseClass {

	// Xpath for Signup page

	By signup_tab = By.xpath("//mat-panel-title//a[text()=' Set up your Workstatus account ']");
	
	By name = By.xpath("//input[@formcontrolname='name']");
	By email = By.xpath("//input[@formcontrolname='email']");
	By phone = By.xpath("//input[@formcontrolname='phone']");
	By password = By.xpath("//input[@formcontrolname='password']");
	By passwordConfirm = By.xpath("//input[@formcontrolname='passwordConfirm']");
	By checkbox = By.xpath("(//input[@type='checkbox'])[1]");
	By sign_up_btn = By.xpath("//button//span[text()=' Sign up ']");
	By btn_ok = By.xpath("//button[text()='OK']");
	By btn_success = By.xpath("//span[text()=' OK ']");

	public void click_signup_tab(WebDriver dirver) {
		commFunc.Explicitywait(dirver, signup_tab);
		commFunc.Click(dirver, signup_tab);
	}
	
	public void click_signup_btn(WebDriver dirver) {
		commFunc.Explicitywait(dirver, sign_up_btn);
		commFunc.Click(dirver, sign_up_btn);
	}

	public void validate_signup_page_url(WebDriver dirver) {

		String actual_url = "https://app.newstaging.workstatus.io/auth/register";

		String expected_url = driver.getCurrentUrl();

		//Assert.assertEquals(actual_url, expected_url);
		
		if(actual_url.contentEquals(expected_url)) {
			System.out.println("Signup tab opened!");
		}
		else {
			System.err.println("Signup tab is not opened!");
		}
	}
	
	public void click_checkbox(WebDriver driver) {
		commFunc.Explicitywait(driver, checkbox);
		commFunc.Click(driver, checkbox);
	}
	
	public void duplicate_user(WebDriver driver) {
		
		commFunc.sendKeyswithEnter(driver, name,(conf.getname()));
		commFunc.sendKeyswithEnter(driver, email,(conf.getemail()));
		commFunc.sendKeyswithEnter(driver, phone,(conf.getphone()));
		commFunc.sendKeyswithEnter(driver, password,(conf.getpassword()));
		commFunc.sendKeyswithEnter(driver, passwordConfirm,(conf.getConfirm_passowrd()));
		
	}

	public void validate_duplicacy(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//h2[text()='Validation Error.']")).size()!=0) {
			System.out.println("Duplicate form validation successfull!");
			
		}//h1[text()='THANK YOU']
		else{
			System.err.println("Duplicate form cannot be validated!");
		}
		
		commFunc.Click(driver, btn_ok);
	}
	
	public void pasteEmail(WebDriver driver) {
		driver.findElement(email).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		commFunc.sendKeyswithEnter(driver, email,(conf.getemail_new()));
		
	}
	
	public void validatae_newUser(WebDriver driver) throws InterruptedException {
		commFunc.Explicitywait(driver,By.xpath("//h1[text()='THANK YOU']"));
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//h1[text()='THANK YOU']")).size()!=0) {
			System.out.println("New user added successfully!");
		}
		else {
			System.err.println("New user cannot added successfully!");
		}
		
		commFunc.Click(driver, btn_success);
	}
	
}
