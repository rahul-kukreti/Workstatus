package com.End2End.PagesObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import com.End2End.Test_Regression.BaseClass;

public class Member_ObjectPage extends BaseClass {
	
	//Xpath for project module
	
	By New_member = By.xpath("//button//span[text()=' Invite new members ']");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By member_email = By.xpath("//input[@formcontrolname='memberEmail']");
	By save_btn = By.xpath("//button//span[text()=' Save ']");
	By accept_btn = By.xpath("//a[contains(@href,'https://app.newstaging.workstatus.io/auth')]");
	By name = By.xpath("//input[@formcontrolname='name']");
	By phone = By.xpath("//input[@formcontrolname='phone']");
	By password = By.xpath("//input[@formcontrolname='password']");
	By passwordConfirm = By.xpath("//input[@formcontrolname='passwordConfirm']");
	
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
		commFunc.Explicitywait(driver,By.xpath("//div[contains(text(),'Member invitation request has been successfully se')]"));
		if(driver.findElements(By.xpath("//div[contains(text(),'Member invitation request has been successfully se')]")).size()!=0) {
			System.out.println("Member request sent successfully!");
			commFunc.Click(driver, btn_ok);
		}
	}
	
	public void getWindow(WebDriver driver) {
		String originalWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.WINDOW);
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.get("https://yopmail.com/en/");
		driver.findElement(By.xpath("//input[@id='login']")).clear();
		commFunc.sendKeyswithEnter(driver, member_email, (conf.get_newMember()));
		driver.switchTo().frame("ifmail");
		commFunc.Explicitywait(driver, accept_btn);
		commFunc.actionsClick(driver, accept_btn);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		commFunc.sendKeyswithEnter(driver, name,(conf.getname()));
		commFunc.sendKeyswithEnter(driver, phone,(conf.getphone()));
		commFunc.sendKeyswithEnter(driver, password,(conf.getpassword()));
		commFunc.sendKeyswithEnter(driver, passwordConfirm,(conf.getConfirm_passowrd()));
		driver.close();
		driver.switchTo().window(originalWindow);
		driver.navigate().refresh();
	}
}
