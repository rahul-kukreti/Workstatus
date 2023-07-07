package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class TimeOff_Objectpage extends BaseClass {

	By timeOff_module = By.xpath("//a[@href='/dashboard/timeoff']");
	By timeoff_button = By.xpath("//button//span[contains(text(),'Request')]");
	By setting_timeoff = By.xpath("//button[@routerlink='/dashboard/settings/timeoff']");
	By add_policy_btn = By.xpath("//button//span[contains(text(),'Add policy')]");
	By toggle_btn = By.xpath("//label[@class='mat-slide-toggle-label']//child::div[@class='mat-slide-toggle-thumb']");
	By save_btn = By.xpath("//button//span[contains(text(),'Save')]");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By action_icon = By.xpath("//button//mat-icon[text()='more_vert']");
	By checkbox = By.xpath("//mat-checkbox[@formcontrolname='allDay']");
	By edit_request = By.xpath("//button//span[contains(text(),'Edit Request ')]");
	By approve_tab = By.xpath("//div[@role='tab']//child::label[contains(text(),'Approved')]");
	By deny_tab = By.xpath("//div[@role='tab']//child::label[contains(text(),'Denied')]");

	public void click_timeoff_module(WebDriver driver) {
		commFunc.scrollIntoElement(driver, timeOff_module);
	}

	public void timeOff_request(WebDriver driver) {
		commFunc.Explicitywait(driver, timeoff_button);
		commFunc.Click(driver, timeoff_button);
	}

	public void add_policy(WebDriver driver) {
		commFunc.Explicitywait(driver, setting_timeoff);
		commFunc.Click(driver, setting_timeoff);
		commFunc.Click(driver, add_policy_btn);
		commFunc.Click(driver, toggle_btn);
	}

	public void save_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, save_btn);
		commFunc.Click(driver, save_btn);
	}

	public void validate_policy(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//div[contains(text(),'Policy successfully added.')]"));
		if (driver.findElements(By.xpath("//div[contains(text(),'Policy successfully added.')]")).size() != 0) {
			System.out.println("Policy added successfully!");
			commFunc.Click(driver, btn_ok);
		}
	}

	public void click_action_icon(WebDriver driver) {
		commFunc.Explicitywait(driver, action_icon);
		commFunc.Click(driver, action_icon);
	}

	public void policy_dropdown(WebDriver driver, String name) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, By.xpath("//div[@role='menu']//child::button//span[contains(text(),'" + name + "')]"));

	}

	public void edit_view_policy(WebDriver driver) {
		commFunc.selectDropdown(driver, "balance", "Yes");
		commFunc.selectDropdown(driver, "approval", "Yes");

	}

	public void validateEdit_policy(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//div[contains(text(),'Policy Updated successfully.')]"));
		if (driver.findElements(By.xpath("//div[contains(text(),'Policy Updated successfully.')]")).size() != 0) {
			System.out.println("Policy updated successfully!");
			commFunc.Click(driver, btn_ok);
		}
	}

	public void validateArchive_policy(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//div[contains(text(),'Policy archived successfully.')]"));
		if (driver.findElements(By.xpath("//div[contains(text(),'Policy archived successfully.')]")).size() != 0) {
			System.out.println("Policy archive successfully!");
			commFunc.Click(driver, btn_ok);
		}
	}

	public void unArchive(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, By.xpath("//mat-select[@placeholder='Select policy']"));
		commFunc.Click(driver, By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'Archive Policy')]"));
	}

	public void validate_UnArchive_policy(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//div[contains(text(),'Policy unarchived successfully.')]"));
		if (driver.findElements(By.xpath("//div[contains(text(),'Policy unarchived successfully.')]")).size() != 0) {
			System.out.println("Policy unarchived successfully!");
			commFunc.Click(driver, btn_ok);
			commFunc.Click(driver, By.xpath("//mat-select[@placeholder='Select policy']"));
			commFunc.Click(driver,
					By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'Active Policy')]"));
		}
	}

	public void Timoff_details(WebDriver driver) {
		commFunc.Click(driver, checkbox);

	}
	
	public void validate_timeOff(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Timeoff request created successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Timeoff request created successfully.']")).size() != 0) {
			System.out.println("TimeOff added successfully!");
			commFunc.Click(driver, btn_ok);
		}
	}
	
	public void edit_timeoff(WebDriver driver) {
		commFunc.Click(driver, edit_request);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, checkbox);
	}
	
	public void validate_Edit_timeOff(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Timeoff request updated successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Timeoff request updated successfully.']")).size() != 0) {
			System.out.println("TimeOff Updated successfully!");
			commFunc.Click(driver, btn_ok);
		}
	}
	
	public void validate_Approve_timeOff(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		commFunc.Click(driver, By.xpath("//div//button[text()='Submit']"));
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Status of timeoff request successfully updated.']"));
		if (driver.findElements(By.xpath("//h2[text()='Status of timeoff request successfully updated.']")).size() != 0) {
			System.out.println("TimeOff status approve successfully!");
			commFunc.Click(driver, btn_ok);
		}
	}
	
	public void validate_Deny_timeOff(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		commFunc.Click(driver, By.xpath("//div//button[text()='Submit']"));
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Status of timeoff request successfully updated.']"));
		if (driver.findElements(By.xpath("//h2[text()='Status of timeoff request successfully updated.']")).size() != 0) {
			System.out.println("TimeOff status deny successfully!");
			commFunc.Click(driver, btn_ok);
			commFunc.Click(driver, deny_tab);
		}
	}
	
	public void deny_time(WebDriver driver) {
		commFunc.Explicitywait(driver, approve_tab);
		commFunc.Click(driver, approve_tab);
	}
}
