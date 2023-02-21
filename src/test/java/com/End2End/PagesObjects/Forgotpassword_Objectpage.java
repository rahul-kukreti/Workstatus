package com.End2End.PagesObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class Forgotpassword_Objectpage extends BaseClass {

	By fp_link = By.xpath("//a[@href='/auth/forgot-password']");
	By email_field = By.xpath("//input[@formcontrolname='email']");
	By search_mail = By.xpath("//input[@id='login']");
	By reset_btn = By.xpath("//a[contains(@href,'https://app.newstaging.workstatus.io/auth/reset-password')]");
	By button = By.xpath("//button[contains(text(),'OK')]");
	By password = By.xpath("//input[@formcontrolname='password']");
	By passwordConfirm = By.xpath("//input[@formcontrolname='passwordConfirm']");
	By reset_pass = By.xpath("//span[contains(text(),'Reset Password')]");

	public void click_fpLink(WebDriver driver) {
		commFunc.Explicitywait(driver, fp_link);
		commFunc.Click(driver, fp_link);
	}

	public void validate_fpLink(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h1[text()=' Recover Your Password ']"));
		if (driver.findElements(By.xpath("//h1[text()=' Recover Your Password ']")).size() != 0) {
			System.out.println("Reset page displayed!");
		} else {
			System.err.println("Reset page is not displayed!");
		}
	}

	public void email_field(WebDriver driver) {
		driver.findElement(email_field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		commFunc.sendKeyswithEnter(driver, email_field, (conf.getemail()));
	}

	public void wrong_email(WebDriver driver) {
		commFunc.sendKeyswithEnter(driver, email_field, (conf.getWrong_email()));
	}

	public void validate_invalidEmail(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Email not found.']"));
		if (driver.findElements(By.xpath("//h2[text()='Email not found.']")).size() != 0) {
			System.out.println("Email not found.!");
			commFunc.Click(driver, button);
		} else {
			System.err.println("Wrong email popup is not displayed!");
		}
	}
	
	public void validate_ValidEmail(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//div[contains(text(),'Reset your password')]"));
		if (driver.findElements(By.xpath("//div[contains(text(),'Reset your password')]")).size() != 0) {
			System.out.println("Email sent to user..!");
		} else {
			System.err.println("Wrong email popup is not displayed!");
		}
	}

	public void getWindow(WebDriver driver) throws InterruptedException {

		driver.navigate().to("https://yopmail.com/en/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='login']")).clear();
		commFunc.sendKeyswithEnter(driver, search_mail, (conf.getemail()));
		driver.switchTo().frame("ifmail");
		commFunc.Explicitywait(driver, reset_btn);
		commFunc.actionsClick(driver, reset_btn);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(4));
		commFunc.Explicitywait(driver, By.xpath("//input[@formcontrolname='password']"));
		commFunc.sendKeyswithEnter(driver, password,(conf.getpassword()));
		commFunc.sendKeyswithEnter(driver, passwordConfirm,(conf.getConfirm_passowrd()));
	}
	
	public void click_resetbtn(WebDriver driver) {
		commFunc.Explicitywait(driver, reset_pass);
		commFunc.Click(driver, reset_pass);
	}

	
	public void validate_resetpass(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Password updated successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Password updated successfully.']")).size()!=0) {
			System.out.println("Reset password validate succcessfully!");
			commFunc.Click(driver, button);
		}
		else {
			System.err.println("Email not found..!");
		}
	}
	 
}