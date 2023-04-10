package com.End2End.PagesObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;

public class Todo_Objectpage extends BaseClass {

	By add_todo = By.xpath("//button//child::span[text()=' Add to-dos ']");
	By todo_name = By.xpath("//input[@formcontrolname='name']");
	By project_name = By.xpath("//mat-select[@formcontrolname='project_id']");
	By member_name = By.xpath("//mat-select[@formcontrolname='member']");
	By todo_priority = By.xpath("//mat-select[@formcontrolname='priority']");
	By open_calander = By.xpath("(//button[@aria-label='Open calendar'])[1]");
	By close_calander = By.xpath("(//button[@aria-label='Open calendar'])[2]");
	By description = By.xpath("//textarea[@formcontrolname='description']");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");

	public void click_addTodo_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, add_todo);
		commFunc.Click(driver, add_todo);
	}

	public void todo_details(WebDriver driver, String name, String p_name, String m_name) {

		commFunc.sendKeys(driver, todo_name, name);
		commFunc.Click(driver, project_name);
		commFunc.Click(driver, By.xpath("(//mat-option//span[text()='" + p_name + "'])[1]"));
		commFunc.Click(driver, member_name);
		commFunc.Click(driver, By.xpath("//span[contains(text(),'" + m_name + "')]"));
		driver.findElement(member_name).sendKeys((Keys.TAB));
	}

	public void get_current_date(WebDriver driver) {

		List<WebElement> date = driver.findElements(By.xpath("//button[@aria-label='Open calendar']"));

		Iterator<WebElement> it = date.iterator();
		while (it.hasNext()) {
			commFunc.Click(driver, open_calander);
			driver.findElement(By.xpath("//div[contains(@class,'mat-calendar-body-today')]")).click();
			commFunc.Click(driver, close_calander);
			driver.findElement(By.xpath("//div[contains(@class,'mat-calendar-body-today')]")).click();
			break;

		}

	}

	// For details for next page
	public void todo_detail(WebDriver driver, String priority, String descrip) {
		commFunc.Click(driver, todo_priority);
		commFunc.Click(driver, By.xpath("//span[contains(text(),'" + priority + "')]"));
		commFunc.Click(driver, description);
		commFunc.sendKeys(driver, description, descrip);
	}
	
	public void validate_todo(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Todo created successfully.']"));
		if(driver.findElements(By.xpath("//h2[text()='Todo created successfully.']")).size()!=0) {
			System.out.println("To-do created successfully!");
			commFunc.Click(driver, btn_ok);
		}
		else{
			System.err.println("To-do cannot able to created successfully!");
		}
	}
}
