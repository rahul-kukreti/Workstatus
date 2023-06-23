package com.End2End.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;

public class Schedules_Objectpage extends BaseClass {
	
	By schedule_module = By.xpath("//a[@href='/dashboard/schedules']");
	By add_btn = By.xpath("//button//span//mat-icon[contains(text(),'add')]");
	By member = By.xpath("//mat-select[@formcontrolname='member']");
	By save_btn = By.xpath("//button//span[contains(text(),'Save')]");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	
	
	public void add_schedule(WebDriver driver) throws InterruptedException {
		
		commFunc.scrollIntoElement(driver, schedule_module);
		commFunc.Click(driver, add_btn);
		commFunc.Click(driver, member);
		Thread.sleep(5000);
		try {
		List<WebElement> memberlist = driver.findElements(By.xpath("//div[@role='listbox']//mat-option//span"));
		int member_size = memberlist.size();
		for(int i =0; i<member_size; i++) {
			
			String member_names = memberlist.get(i).getText();
			String actual_name = "Vijay";
			if(member_names.equalsIgnoreCase(actual_name)) {
				commFunc.Click(driver, By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'Vijay')]"));
			}
		}
	}
		catch(StaleElementReferenceException e) {
			
		}
	}
	
	
	
	public void click_saveBtn(WebDriver driver) {
		commFunc.Explicitywait(driver, save_btn);
		commFunc.Click(driver, save_btn);
	}
	
	public void verify_schedule(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Schedule added successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Schedule added successfully.']")).size()!=0) {
			System.out.println("Schedule added successfully");
			commFunc.Click(driver, btn_ok);
		}
		else {
			System.err.println("Schedule not added successfully");
		}
	}
	
	
	public void verifyDuplicate_schedule(WebDriver driver) {
		
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Schedule exist on same date and time']"));
		if(driver.findElements(By.xpath("//h2[text()='Schedule exist on same date and time']")).size()!=0) {	
			System.out.println("Duplicated Schedule validated successfully");
			commFunc.Click(driver, btn_ok);
		}
		else {
			System.err.println("Schedule Duplicated");
		}
	}
	

}
