package com.End2End.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;
import com.codoid.products.exception.FilloException;

public class Clients_Objectpage extends BaseClass {
	
	//xpath for client
	
	By add_client = By.xpath("//button//span[text()=' Add new client ']");
	By project_name = By.xpath("//mat-select[@formcontrolname='projects']");
	By continue_btn = By.xpath("(//button//span[text()=' Continue '])[2]");
	By continue_btn1 = By.xpath("(//button//span[text()=' Continue '])[3]");
	By savebtn = By.xpath("//button//span[contains(text(),'Save')]");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By client_details = By.xpath("//mat-header-row//mat-header-cell//div[contains(text(),'Client Details')]");
	By action = By.xpath("//mat-row//mat-cell//button//child::mat-icon[contains(text(),'more_vert')]");
	By edit_client = By.xpath("//div[@role='menu']//button//span[contains(text(),'Edit')]");
	By archive_client = By.xpath("//div[@role='menu']//button//span[contains(text(),'Archive')]");
	By restore_client = By.xpath("//div[@role='menu']//button//span[contains(text(),'Restore')]");
	By phone = By.xpath("//input[@formcontrolname='clientPhone']");
	By archive_tab = By.xpath("//div[@role='tab']//div[text()='Archive']");
	By active_tab = By.xpath("//div[@role='tab']//div[text()='Active']");
	
	public void add_client_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, add_client);
		commFunc.Click(driver, add_client);
	}
	
	public void save_client_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, savebtn);
		commFunc.Click(driver, savebtn);
	}
	
	public void continue_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, continue_btn);
		commFunc.Click(driver, continue_btn);
	}
	
	public void continue_btn1(WebDriver driver) {
		commFunc.Explicitywait(driver, continue_btn1);
		commFunc.Click(driver, continue_btn1);
	}
	
	public void get_country_code(WebDriver driver) {
		
		commFunc.Click(driver, By.xpath("//mat-select[@formcontrolname='code']"));
		List<WebElement> list_size = driver.findElements(By.xpath("//div[@role='listbox']//mat-option"));
		int count_list = list_size.size();
		
		for(int i=0; i<count_list; i++) {
			
			String code_list = list_size.get(i).getText();
			String expected_code = "India +91";
			
			if(code_list.equalsIgnoreCase(expected_code)) {
				
				commFunc.Click(driver, By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'India +91')]"));
				break;
				
				
			}
			
		}
	}
	
	public void select_project(WebDriver driver, String p_name) {
		commFunc.Click(driver, project_name);
		commFunc.Click(driver, By.xpath("//mat-option//span[contains(text(),'"+ p_name+ "')]"));
		driver.findElement(project_name).sendKeys((Keys.TAB));
		
		
	}
	
	public void get_currentDate(WebDriver driver) throws InterruptedException {
		
		commFunc.Click(driver, By.xpath("//button[@aria-label='Open calendar']"));
		Thread.sleep(2000);
		commFunc.Click(driver, By.xpath("//div[contains(@class,'mat-calendar-body-today')]"));
	}
	
	public void validate_client(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Client added successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Client added successfully.']")).size()!=0) {
			System.out.println("Client added successfully");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			commFunc.Click(driver, btn_ok);
		}
		else {
			
			System.err.println("Client are not added successfully");
		}
	}
	
	public void edit_client(WebDriver driver) throws FilloException {
		commFunc.Explicitywait(driver, client_details);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, client_details);
		commFunc.Click(driver, client_details);
		commFunc.Click(driver, action);
		commFunc.Click(driver, edit_client);
		commFunc.Click(driver, By.xpath("(//button//span[text()=' Continue '])[1]"));
		commFunc.Click(driver, phone);
		driver.findElement(phone).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(phone).sendKeys(Keys.chord(Keys.CONTROL, "x"));
		
		String client_phone = record.getField("Client_Phone_Update");
		commFunc.put_field_data(driver,"clientPhone", client_phone);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, continue_btn);
		commFunc.Click(driver, continue_btn1);
	}
	
	public void validate_edit_client(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Client updated successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Client updated successfully.']")).size()!=0) {
			System.out.println("Client edited successfully");
			commFunc.Click(driver, btn_ok);
		}
		
		else {
			System.err.println("Client not edited successfully");
		}
	}
	
	public void archive_client(WebDriver driver) {
		commFunc.Click(driver, action);
		commFunc.Click(driver, archive_client);
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Client archived successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Client archived successfully.']")).size()!=0){
			System.out.println("Client moved to Archive");
			commFunc.Click(driver, btn_ok);
		}
		
		else {
			System.err.println("Client not moved to archive");
		}
		
		commFunc.Click(driver, archive_tab);
	}
	
	public void unarchived_Client(WebDriver driver) {
		commFunc.Explicitywait(driver, archive_tab);
		commFunc.Click(driver, archive_tab);
		commFunc.Click(driver, action);
		commFunc.Click(driver, restore_client);
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Client unarchived successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Client unarchived successfully.']")).size()!=0) {
			System.out.println("Client unarchived successfully");
			commFunc.Click(driver, btn_ok);
			commFunc.Click(driver, active_tab);
		}
		else {
			System.err.println("Client not unarchived successfully");
		}
	}
	

}
