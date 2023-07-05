package com.End2End.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;

public class Schedules_Objectpage extends BaseClass {

	By schedule_module = By.xpath("//a[@href='/dashboard/schedules']");
	By add_btn = By.xpath("//button//span//mat-icon[contains(text(),'add')]");
	By member = By.xpath("//mat-select[@formcontrolname='member']");
	By save_btn = By.xpath("(//button//span[contains(text(),'Save')])");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By schedule_name = By.xpath("//div[contains(@aria-describedby,'cdk-describedby-message')]//h4");
	By description = By.xpath("//input[@formcontrolname='description']");
	By delete_scheudle = By.xpath("//button//span[contains(text(),'Delete')]");
	By delete_one_schedule = By.xpath("//div//button[contains(text(),'No, delete only one!')]");
	By delete_all_schedule = By.xpath("//div//button[contains(text(),'Yes, delete all!')]");

	public void add_schedule(WebDriver driver) throws InterruptedException {

		commFunc.scrollIntoElement(driver, schedule_module);
		commFunc.Click(driver, add_btn);
		commFunc.Click(driver, member);
		Thread.sleep(5000);
		try {
			List<WebElement> memberlist = driver.findElements(By.xpath("//div[@role='listbox']//mat-option//span"));
			int member_size = memberlist.size();
			for (int i = 0; i < member_size; i++) {

				String member_names = memberlist.get(i).getText();
				String actual_name = "Rahul";
				if (member_names.equalsIgnoreCase(actual_name)) {
					commFunc.Click(driver,
							By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'Rahul')]"));
				}
			}
		} catch (StaleElementReferenceException e) {

		}
	}

	public void click_saveBtn(WebDriver driver) {
		commFunc.Explicitywait(driver, save_btn);
		commFunc.Click(driver, save_btn);
	}

	public void verify_schedule(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Schedule added successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Schedule added successfully.']")).size() != 0) {
			System.out.println("Schedule added successfully");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Schedule not added successfully");
		}
	}

	public void verifyDuplicate_schedule(WebDriver driver) {

		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Schedule exist on same date and time']"));
		if (driver.findElements(By.xpath("//h2[text()='Schedule exist on same date and time']")).size() != 0) {
			System.out.println("Duplicated Schedule validated successfully");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Schedule Duplicated");
		}
	}

	public void edit_scheduled(WebDriver driver) throws InterruptedException {
		commFunc.Explicitywait(driver, schedule_name);
		commFunc.Click(driver, schedule_name);
		Thread.sleep(2000);
		driver.findElement(description).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(description).sendKeys(Keys.chord(Keys.CONTROL, "x"));

	}

	public void validate_edit_schedule(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Schedule updated successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Schedule updated successfully.']")).size() != 0) {
			System.out.println("Schedule updated successfully!");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Schedule does not updated successfully!");
		}
	}

	public void validate_delete_schedule_one(WebDriver driver) {
		commFunc.Explicitywait(driver, schedule_name);
		commFunc.Click(driver, schedule_name);
		commFunc.Click(driver, delete_scheudle);
		commFunc.Click(driver, delete_one_schedule);
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Schedule deleted successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Schedule deleted successfully.']")).size() != 0) {
			System.out.println("Schedule deleted successfully!");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Schedule does not deleted successfully!");
		}

	}

	public void validatae_schedule_all(WebDriver driver) {
		commFunc.Explicitywait(driver, schedule_name);
		commFunc.Click(driver, schedule_name);
		commFunc.Click(driver, delete_scheudle);
		commFunc.Click(driver, delete_all_schedule);
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Schedule deleted successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Schedule deleted successfully.']")).size() != 0) {
			System.out.println("Schedule deleted successfully!");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Schedule does not deleted successfully!");
		}
		
	}

}
