package com.End2End.PagesObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.End2End.Test_Regression.BaseClass;

public class Member_ObjectPage extends BaseClass {

	// Xpath for project module

	By New_member = By.xpath("//button//span[text()=' Invite new members ']");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By member_email = By.xpath("//input[@formcontrolname='memberEmail']");
	By save_btn = By.xpath("//button//span[text()=' Save ']");
	By accept_btn = By.xpath("//a[contains(@href,'https://app.newstaging.workstatus.io/auth')]");
	By name = By.xpath("//input[@formcontrolname='name']");
	By phone = By.xpath("//input[@formcontrolname='phone']");
	By password = By.xpath("//input[@formcontrolname='password']");
	By passwordConfirm = By.xpath("//input[@formcontrolname='passwordConfirm']");
	By search_mail = By.xpath("//input[@id='login']");
	By account_btn = By.xpath("//span[contains(text(),'Save an account')]");
	By action_icon = By.xpath("(//button//mat-icon[text()='more_vert'])[1]");
	By edit_limitIcon = By.xpath("//span[contains(text(),'Edit limit')]");
	By weekly = By.xpath("//input[@formcontrolname='weekelylimit']");
	By hour = By.xpath("//input[@formcontrolname='hourly_pay_rate']");
	By save_limit = By.xpath("//button//span[text()=' Save ']");
	By tracking = By.xpath("//span[text()=' Disable tracking ']");
	By filter = By.xpath("//button[contains(@class,'mat-focus-indicator')]//span[text()='Filters']");
	By dropdown = By.xpath("//label[text()=' User Type ']//following-sibling::mat-form-field[contains(@class,'mat-form-field')]");
	By filterbtn = By.xpath("//button//span[text()=' Apply ']");
	By filterbtnc = By.xpath("//button//span[text()=' Clear ']");
	By online = By.xpath("//mat-cell[@role='cell']//span[text()=' Online ']");
	By offline = By.xpath("//mat-cell[@role='cell']//span[text()=' Offline ']");
	By logout = By.xpath("(//div[@aria-haspopup='true'])[2]");
	By logout_confrm = By.xpath("//button[text()='Yes']");
	By email = By.xpath("//input[@formcontrolname='email']");

	public void click_addmember(WebDriver driver) {
		commFunc.Explicitywait(driver, New_member);
		commFunc.Click(driver, New_member);
	}

	public void member_details(WebDriver driver) {
		commFunc.sendKeys(driver, member_email, (conf.get_newMember()));
		commFunc.Click(driver, By.xpath("(//mat-select[@formcontrolname])[1]"));
		commFunc.Click(driver, By.xpath("//span[text()='Project Manager']"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, By.xpath("(//mat-select[@formcontrolname])[2]"));
		commFunc.Click(driver, By.xpath("//mat-pseudo-checkbox//following-sibling::span[text()=' Crm ']"));

	}

	public void click_save(WebDriver driver) {
		commFunc.Explicitywait(driver, save_btn);
		commFunc.Click(driver, save_btn);
	}

	public void validate_memberRequest(WebDriver driver) {
		commFunc.Explicitywait(driver,
				By.xpath("//div[contains(text(),'Member invitation request has been successfully se')]"));
		if (driver
				.findElements(By.xpath("//div[contains(text(),'Member invitation request has been successfully se')]"))
				.size() != 0) {
			System.out.println("Member request sent successfully!");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Member request cannot be able to sent successfully!");
		}
	}

	public void validate_Duplicate_memberRequest(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Member already exists in this organisation.']"));
		if (driver.findElements(By.xpath("//h2[text()='Member already exists in this organisation.']")).size() != 0) {
			System.out.println("Duplicate member request validated successfully!");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Member request sent successfully!");
		}
		commFunc.Click(driver, By.xpath("//div[text()=' Member ']"));
	}

	public void getWindow(WebDriver driver) throws InterruptedException {
		driver.get("https://yopmail.com/en/");
		driver.findElement(By.xpath("//input[@id='login']")).clear();
		commFunc.sendKeyswithEnter(driver, search_mail, (conf.get_newMember()));
		driver.switchTo().frame("ifmail");
		commFunc.Explicitywait(driver, accept_btn);
		commFunc.actionsClick(driver, accept_btn);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		try {
			Thread.sleep(5000);
			commFunc.sendKeyswithEnter(driver, name, (conf.get_nmemberName()));
			commFunc.sendKeyswithEnter(driver, phone, (conf.getphone()));
			commFunc.sendKeyswithEnter(driver, password, (conf.getpassword()));
			commFunc.sendKeyswithEnter(driver, passwordConfirm, (conf.getConfirm_passowrd()));
			sign.click_checkbox(driver);
			sign.validatae_newUser(driver);
		} catch (Exception e) {

		}
	}

	public void click_save_account(WebDriver driver) {
		commFunc.Explicitywait(driver, account_btn);
		commFunc.jclick(driver, account_btn);
	}

	public void validate_newMember(WebDriver driver, String name) {
		commFunc.Explicitywait(driver, By.xpath("//mat-row//ul//li[text()=' " + name + " ']"));
		if (driver.findElements(By.xpath("//mat-row//ul//li[text()=' " + name + " ']")).size() != 0) {
			System.out.println("New member added successfully!");
		} else {
			System.err.println("New member are not added successfully!");
		}
	}

	public void edit_limit(WebDriver driver) {
		commFunc.Click(driver, By.xpath("//div[text()=' Member ']"));
		commFunc.Click(driver, action_icon);
		commFunc.Click(driver, edit_limitIcon);
	}

	public void limit_details(WebDriver driver) {
		commFunc.sendKeyswithEnter(driver, weekly, (conf.get_week()));
		driver.findElement(hour).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		commFunc.sendKeyswithEnter(driver, hour, (conf.get_week()));
	}

	public void click_limit(WebDriver driver) {
		commFunc.Explicitywait(driver, save_limit);
		commFunc.Click(driver, save_limit);
	}

	public void validate_limit(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Member limit updated successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Member limit updated successfully.']")).size() != 0) {
			System.out.println("Member weekly limit updated successfully.");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Member weekly limit does not updated successfully.");
		}
	}

	public void click_tracking(WebDriver driver) {
		commFunc.Click(driver, By.xpath("//div[text()=' Member ']"));
		commFunc.Click(driver, action_icon);
		commFunc.Explicitywait(driver, tracking);
		commFunc.Click(driver, tracking);
	}

	public void validate_tracking(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Status changed successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Status changed successfully.']")).size() != 0) {
			System.out.println("Tracking work successfully!");
			commFunc.Click(driver, btn_ok);
		}

		else {
			System.err.println("Tracking not work successfully!");

		}

	}

	public void click_filter(WebDriver driver) {
		commFunc.Explicitywait(driver, filter);
		commFunc.Click(driver, filter);
		commFunc.Click(driver, dropdown);
	}

	public void validate_online_tracking(WebDriver driver, String status) throws InterruptedException {
		commFunc.Click(driver, By.xpath("//mat-option//span[text()=' Online Members ']"));
		commFunc.Click(driver, filterbtn);
		commFunc.Explicitywait(driver, online);
        Thread.sleep(4000);
		List<WebElement> onlinevalues = driver.findElements(online);
		int countOffilterValue = onlinevalues.size();
		for (int i = 0; i < countOffilterValue; i++) {
			String filtervalueValuesText = onlinevalues.get(i).getText();
			
			if (filtervalueValuesText.equalsIgnoreCase(status)) {
				System.out.println("Online filter applied successfully");
			}

			else {
				System.err.println("Online filter not applied successfully");
			}

		}

	} 
	
	public void validate_offline_tracking(WebDriver driver, String status) throws InterruptedException {
		commFunc.Click(driver, By.xpath("//mat-option//span[text()=' Offline Members ']"));
		commFunc.Click(driver, filterbtn);
		commFunc.Explicitywait(driver, offline);
        Thread.sleep(4000);
		List<WebElement> offlinevalues = driver.findElements(offline);
		int countOffilterValue = offlinevalues.size();
		for (int i = 0; i < countOffilterValue; i++) {
			String filtervalueValuesText = offlinevalues.get(i).getText();
			
			if (filtervalueValuesText.equalsIgnoreCase(status)) {
				System.out.println("Offline filter applied successfully");
			}

			else {
				System.err.println("Offline filter not applied successfully");
			}

		}

	}
	
	public void logout(WebDriver driver) {
		commFunc.Click(driver, logout);
		commFunc.Explicitywait(driver, logout_confrm);
		commFunc.Click(driver, logout_confrm);
		commFunc.Click(driver, btn_ok);
	}
	
	public void login_old(WebDriver driver) {
		
			commFunc.sendKeyswithEnter(driver, email, (conf.getemail_member_old()));
			commFunc.sendKeyswithEnter(driver, password, (conf.getpass_member_old()));
		}
	
	public void clear_filter(WebDriver driver) {
		commFunc.Explicitywait(driver, filter);
		commFunc.Click(driver, filter);
		commFunc.Click(driver, filterbtnc);
		System.out.println("Applied filter are clear..!");
}
}
