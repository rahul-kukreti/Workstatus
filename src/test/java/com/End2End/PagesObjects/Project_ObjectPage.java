package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class Project_ObjectPage extends BaseClass {
	
	//xpath for project
	
	By add_project = By.xpath("//span[contains(text(),'New Project')]");
	By project_name = By.xpath("//input[@formcontrolname='projectName']");
	By manager = By.xpath("//mat-select[@formcontrolname='managers']");
	By users = By.xpath("//mat-select[@formcontrolname='users']");
	By description = By.xpath("//input[@formcontrolname='description']");
	By save_project = By.xpath("//span[contains(text(),'Save')]");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By btn_close = By.xpath("//button[text()='Close']");
	
	public void click_project_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, add_project);
		commFunc.Click(driver, add_project);
	}

	public void duplicate_details(WebDriver driver) throws InterruptedException {
		
		commFunc.sendKeys(driver, project_name, (conf.get_project()));
		commFunc.Click(driver, manager);
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
		if(driver.findElements(By.xpath("//h2[text()='Project name already exist.']")).size()!=0) {
			System.out.println("Project already exit");
			commFunc.Click(driver, btn_ok);
			
		}
		
	}
	
	public void add_newProject(WebDriver driver) {
		driver.findElement(project_name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		commFunc.sendKeys(driver, project_name, (conf.get_newproject()));
		commFunc.Click(driver, save_project);
	}
	
	public void validate_new_project(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Project added successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Project added successfully.']")).size()!=0) {
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
	
	public void validate_editproject(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Project updated successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Project updated successfully.']")).size()!=0){
			System.out.println("Project edited successfully!");
			commFunc.Click(driver, btn_close);
		}
		else {
			System.err.println("Project not updated successfully!");
		}
	}

}
