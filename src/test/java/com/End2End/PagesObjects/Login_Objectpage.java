package com.End2End.PagesObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.End2End.Test_Regression.BaseClass;
import com.utility.Utility;


public class Login_Objectpage extends BaseClass {
	
    //xpath for login and logout--------------------------------------------------
	
	
	By email = By.xpath("//input[@formcontrolname='email']");
	By password = By.xpath("//input[@formcontrolname='password']");
	By login_tab = By.xpath("//mat-panel-title//a[text()=' Login ']");
	By btn_ok = By.xpath("//button[text()='OK']");
	By search_mail = By.xpath("//input[@id='login']");
	By confirm_account = By.xpath("//a[contains(@href,'https://app.newstaging.workstatus.io/auth/account-verification/')]");
    By logoutbtn = By.xpath("//span[contains(text(),'Logout')]");
	By loginbtn_mail = By.xpath("//button//span[text()=' Login now! ']");
	By logout_confrm = By.xpath("//button[text()='Yes']");
	

	public void click_login_tab(WebDriver dirver) {
		commFunc.Explicitywait(dirver, login_tab);
		commFunc.Click(dirver, login_tab);
	}

	public void login(WebDriver driver) {
		commFunc.sendKeys(driver, email, (conf.getemail_new()));
		commFunc.sendKeyswithEnter(driver, password, (conf.getpassword()));
	}

	public void validatae_confirmation(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[@id='swal2-title']"));
		if (driver.findElements(By.xpath("//h2[@id='swal2-title']")).size() != 0) {
			System.out.println("Confirmation is required to login successfully..!!");
		}

		else {
			System.err.println("Confirmation message is not displayed..!!");
		}
		commFunc.Click(driver, btn_ok);
	}

	public void getWindow(WebDriver driver) throws InterruptedException {
		
		driver.navigate().to("https://yopmail.com/en/");
		commFunc.sendKeyswithEnter(driver, search_mail, (conf.getemail_new()));
		Thread.sleep(8000);
		driver.switchTo().frame("ifmail");
		commFunc.Explicitywait(driver, confirm_account);
		commFunc.actionsClick(driver, confirm_account);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(12000);
		Utility.captureScreenShot(driver, "confirmed_login");
		driver.navigate().to("https://app.newstaging.workstatus.io/auth/login");
		
	}
	
	public void validate_login(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h1[contains(text(),'Lets get Started')]"));
		
		if(driver.findElements(By.xpath("//h1[contains(text(),'Lets get Started')]")).size()!=0) {
			System.out.println("User successfully logged in!!");
		}
		else {
			System.err.println("User cannot able to login please check!");
		}
	}
	
	//---------------------For logout-----------------------------------------------------
	
	public void click_logout(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		commFunc.Explicitywait(driver,logoutbtn);
		commFunc.Click(driver, logoutbtn);
		Thread.sleep(4000);
		commFunc.Explicitywait(driver, logout_confrm);
		commFunc.Click(driver, logout_confrm);
		commFunc.Explicitywait(driver, btn_ok);
		if(driver.findElements(By.xpath("//h2[text()='Logout successful.']")).size()!=0) {
		commFunc.Click(driver, btn_ok);
		System.out.println("Log out successfully!");
	}
		else {
			System.err.println("Some issue in logout!");
			}
		}

}
