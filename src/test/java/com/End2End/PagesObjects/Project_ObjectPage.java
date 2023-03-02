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

}
