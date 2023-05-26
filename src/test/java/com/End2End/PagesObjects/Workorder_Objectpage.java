package com.End2End.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;
import com.utility.Utility;

public class Workorder_Objectpage extends BaseClass {

	By client_dropdown = By.xpath("//mat-select[@formcontrolname='selectedClient']");
	By add_work = By.xpath("//button//span[contains(text(),'Add A Work')]");
	By client_dropdown1 = By.xpath("(//mat-select[@formcontrolname='selectedClient'])[2]");
	By instruction = By.xpath("//textarea[@formcontrolname='textIns']");
	By click_next = By.xpath("//div[contains(@class,'d-flex w-100 justify-content-end ng-star-inserted')]//button//span[contains(text(),'Next')]");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By Geo = By.xpath("//input[@type='text']");
	By vertical = By.xpath("ps__rail-y");
	By job_site = By.xpath("body > app-component:nth-child(4) > mat-drawer-container:nth-child(2) > mat-drawer-content:nth-child(5) > vertical-layout-1:nth-child(1) > div:nth-child(1) > div:nth-child(1) > fuse-sidebar:nth-child(1) > navbar:nth-child(1) > navbar-vertical-style-1:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > span:nth-child(2)");
	

	public void select_client(WebDriver driver) {
		
		commFunc.Explicitywait(driver, client_dropdown);
		commFunc.Click(driver, client_dropdown);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> client = driver.findElements(By.xpath("//div[@role='listbox']//mat-option//span"));
		int client_size = client.size();
		for (int i = 0; i < client_size; i++) {
			String get_client_name = client.get(i).getText();
			String actual_name = "Shane watson";
			if (get_client_name.equalsIgnoreCase(actual_name)) {
				commFunc.Click(driver, By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'Shane')]"));
				break;
			}
		}
		}
		

	public void add_work(WebDriver driver,String inst) throws InterruptedException {
		commFunc.Explicitywait(driver, add_work);
		commFunc.Click(driver, add_work);
		Thread.sleep(2000);

		commFunc.Explicitywait(driver, client_dropdown1);
		commFunc.Click(driver, client_dropdown1);
		List<WebElement> client = driver.findElements(By.xpath("//div[@role='listbox']//mat-option//span"));
		int client_size = client.size();
		for (int i = 0; i < client_size; i++) {
			String get_client_name = client.get(i).getText();
			String actual_name = "Shane watson";
			if (get_client_name.equalsIgnoreCase(actual_name)) {
				commFunc.Click(driver, By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'Shane')]"));
				break;
			}
		}
		
		commFunc.sendKeys(driver, instruction, inst);
		Thread.sleep(2000);
		commFunc.Click(driver, click_next);
		commFunc.Click(driver, By.xpath("//div[contains(@class,'d-flex justify-content-end ng-star-inserted')]//button//span[contains(text(),'Next')]"));
	}
	
	public void add_work_stepTwo(WebDriver driver) {
		driver.findElement(By.xpath("//input[@formcontrolname='address']")).sendKeys(Keys.TAB);
		commFunc.Click(driver, By.xpath("//div[contains(@class,'d-flex justify-content-end ng-star-inserted')]//button//span[contains(text(),'Next')]"));
		
	}
	
	public void add_notify(WebDriver driver) {
		WebElement ele = driver.findElement(By.xpath("(//input[@type='number'])[2]"));
		ele.sendKeys("60");
	}
	
	public void validate_work(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Unable to add workorder']"));
		if(driver.findElements(By.xpath("//h2[text()='Unable to add workorder']")).size()!=0) {
			System.err.println("Work Order unable to add");
			commFunc.Click(driver,btn_ok);
		}
		else {
			System.out.println("Work Order added successfully");
		}
	}
	
	public void set_geo(WebDriver driver) throws InterruptedException {
		driver.navigate().to("https://app.newstaging.workstatus.io/dashboard/job-site");
		commFunc.sendKeys(driver, Geo, "Noida");
		driver.findElement(Geo).sendKeys(Keys.TAB);
	}

	

}
