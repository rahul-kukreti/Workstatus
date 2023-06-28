package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class Project_ObjectPage extends BaseClass {

	// xpath for project

	By add_project = By.xpath("//span[contains(text(),'New Project')]");
	By project_name = By.xpath("//input[@formcontrolname='projectName']");
	By manager = By.xpath("//mat-select[@formcontrolname='managers']");
	By users = By.xpath("//mat-select[@formcontrolname='users']");
	By description = By.xpath("//input[@formcontrolname='description']");
	By save_project = By.xpath("//span[contains(text(),'Save')]");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By btn_close = By.xpath("//button[text()='Close']");
	By yes_archieve = By.xpath("//button[contains(text(),'Yes')]");
	By archieve_tab = By.xpath("//div[@role='tab']//child::div[text()='Archived']");
	By active_tab = By.xpath("//div[@role='tab']//child::div[text()='Active']");
	By btn_back = By.xpath("//button[contains(@class,'mat-focus-indicator new_modal_back_btn_theme')]");

	public void click_project_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, add_project);
		commFunc.Click(driver, add_project);
	}

	public void duplicate_details(WebDriver driver) throws InterruptedException {

		commFunc.sendKeys(driver, project_name, (conf.get_project()));
		Thread.sleep(2000);
		commFunc.jclick(driver, manager);
		Thread.sleep(2000);
		commFunc.Click(driver, By.xpath("//span[contains(text(),'Jack (Manager)')]"));
		driver.findElement(manager).sendKeys((Keys.TAB));
		Thread.sleep(2000);
		commFunc.Click(driver, users);
		commFunc.Click(driver, By.xpath("//span[contains(text(),'Rahul (User)')]"));
		driver.findElement(users).sendKeys((Keys.TAB));
		commFunc.sendKeys(driver, description, (conf.get_Project_desc()));
		commFunc.Click(driver, save_project);

	}

	public void validate_duplicate_project(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Project name already exist.']"));
		if (driver.findElements(By.xpath("//h2[text()='Project name already exist.']")).size() != 0) {
			System.out.println("Project already exit");
			commFunc.Click(driver, btn_ok);
			commFunc.Click(driver, btn_back);
		}

	}

	public void add_newProject(WebDriver driver) {
		driver.findElement(project_name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		commFunc.sendKeys(driver, project_name, (conf.get_newproject()));
		commFunc.Click(driver, save_project);
	}

	public void validate_new_project(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Project added successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Project added successfully.']")).size() != 0) {
			System.out.println("New project added successfully");
			commFunc.Click(driver, btn_ok);

		}
	}

	public void edit_project(WebDriver driver) {
		commFunc.Click(driver, By.xpath("//div[contains(text(),'Project name')]"));
		commFunc.Click(driver, By.xpath("(//button//span//child::mat-icon[contains(text(),'more_vert ')])[1]"));
		commFunc.Click(driver, By.xpath("//span[text()=' Edit project ']"));
		commFunc.Click(driver, save_project);

	}

	public void Archieve_project(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commFunc.Click(driver, By.xpath("(//button//span//child::mat-icon[contains(text(),'more_vert ')])[1]"));
		commFunc.Click(driver, By.xpath("//span[text()=' Archive project ']"));

		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Are you sure you want to archive this project?']"));
		if (driver.findElements(By.xpath("//h2[text()='Are you sure you want to archive this project?']"))
				.size() != 0) {
			commFunc.Click(driver, yes_archieve);
		}
		else {
			System.err.println("popup message not appear!");
		}
	}

	public void validate_archive(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Project archived successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Project archived successfully.']")).size() != 0) {
			System.out.println("Project archieved successfully!");
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("Project are not in archieve!");
		}
	}

	public void validate_editproject(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Project updated successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Project updated successfully.']")).size() != 0) {
			System.out.println("Project edited successfully!");
			commFunc.Click(driver, btn_close);
		} else {
			System.err.println("Project not updated successfully!");
		}
	}

	public void click_archive_tab(WebDriver driver) {
		commFunc.Explicitywait(driver, archieve_tab);
		commFunc.Click(driver, archieve_tab);
	}

	public void un_archieve(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//button//span//child::mat-icon[contains(text(),'more_vert ')]"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, By.xpath("//button//span//child::mat-icon[contains(text(),'more_vert ')]"));
		commFunc.Click(driver, By.xpath("//span[text()=' Unarchive project ']"));
	}

	public void validate_unArchive(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Project unarchived successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Project unarchived successfully.']")).size() != 0) {
			System.out.println("Project un-archive successfully!");
			commFunc.Click(driver, btn_ok);
			commFunc.Click(driver, active_tab);
		} else {
			System.err.println("Project  cannot un-archive successfully!");
		}
	}

	public void Move_project(WebDriver driver) {
		commFunc.Click(driver, By.xpath("(//button//span//child::mat-icon[contains(text(),'more_vert ')])[1]"));
		commFunc.Click(driver, By.xpath("//span[text()=' Move project ']"));
		//commFunc.Explicitywait(driver, By.xpath("//h2[contains(text(),'you can't move projects as you are associated with')]"));
		//if (driver.findElements(By.xpath("//h2[contains(text(),'you can't move projects as you are associated with')]")).size() != 0) {
			System.out.println("First create second organization to move project!");
			commFunc.Click(driver, btn_ok);
		//}
		//else {
			//System.err.println("popup message not appear!");
		//}
	}

}
