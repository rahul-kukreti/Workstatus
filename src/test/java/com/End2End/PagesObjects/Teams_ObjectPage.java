package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class Teams_ObjectPage extends BaseClass {
	
	
	//xpath for teams
	
	By add_team_icon = By.xpath("//button//span[contains(text(),'Add Team')]");
	By name = By.xpath("//input[@formcontrolname='name']");
	By teammates = By.xpath("(//mat-select[@role='combobox'])[2]");
	By teamLeaad = By.xpath("(//mat-select[@role='combobox'])[3]");
	By save_team = By.xpath("//button//span[text()=' Save ']");
	By project = By.xpath("(//mat-select[@role='combobox'])[4]");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By filter = By.xpath("//button[contains(@class,'mat-focus-indicator')]//span[text()='Filters ']");
	By filterbtn = By.xpath("//button//span[text()=' Apply ']");
	By filterbtnc = By.xpath("//button//span[text()=' Clear ']");
	
	public void click_addTeam(WebDriver driver) {
		commFunc.Explicitywait(driver, add_team_icon);
		commFunc.Click(driver, add_team_icon);
	}
	
	public void team_details(WebDriver driver) throws InterruptedException {
		commFunc.sendKeyswithEnter(driver, name,(conf.get_Teamname()));
		commFunc.Click(driver, teammates);
		commFunc.Click(driver, By.xpath("(//mat-pseudo-checkbox//parent::mat-option)[2]"));
		Thread.sleep(2000);
		driver.findElement(teammates).sendKeys((Keys.TAB));
		commFunc.Click(driver, teamLeaad);
		commFunc.Click(driver, By.xpath("(//mat-pseudo-checkbox//parent::mat-option)[2]"));
		Thread.sleep(2000);
		driver.findElement(teamLeaad).sendKeys((Keys.TAB));
		commFunc.Click(driver, project);
		commFunc.Click(driver, By.xpath("(//mat-pseudo-checkbox//parent::mat-option)[2]"));
		Thread.sleep(2000);
		driver.findElement(project).sendKeys((Keys.TAB));
		Thread.sleep(2000);
		commFunc.Click(driver, save_team);
	}
	
	public void validate_team(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Team created successfully']"));
		if(driver.findElements(By.xpath("//h2[text()='Team created successfully']")).size()!=0) {
			System.out.println("Team created successfully.");
			commFunc.Click(driver, btn_ok);
		}
		else {
			System.err.println("Team is not created successfully.");
		}
	}
	
	public void filter(WebDriver driver) {
		commFunc.Click(driver, filter);
		commFunc.Click(driver, teammates);
		commFunc.Click(driver, By.xpath("//mat-option//span[text()=' cvBuilder ']"));
		commFunc.Click(driver, filterbtn);
		
	}
	
	public void validate_filter(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//span[text()=' There are no teams! ']"));
		if(driver.findElements(By.xpath("//span[text()=' There are no teams! ']")).size()!=0) {
			System.out.println("Filters are validated successfully.");
			commFunc.Click(driver, filter);
			commFunc.Click(driver, filterbtnc);
			
		}
		else {
			System.err.println("Filters are not validated successfully.");
		}
	}

}
