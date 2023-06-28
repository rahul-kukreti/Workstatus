package com.End2End.PagesObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;
import com.codoid.products.exception.FilloException;

public class Todo_Objectpage extends BaseClass {

	By add_todo = By.xpath("//button//child::span[text()='Add to-do ']");
	By todo_name = By.xpath("//input[@formcontrolname='name']");
	By project_name = By.xpath("//mat-select[@formcontrolname='project_id']");
	By member_name = By.xpath("//mat-select[@formcontrolname='member']");
	By todo_priority = By.xpath("//mat-select[@formcontrolname='priority']");
	By open_calander = By.xpath("(//button[@aria-label='Open calendar'])[1]");
	By close_calander = By.xpath("(//button[@aria-label='Open calendar'])[2]");
	By description = By.xpath("//textarea[@formcontrolname='description']");
	By btn_ok = By.xpath("//button[contains(text(),'OK')]");
	By action_icon = By.xpath("(//button//mat-icon[text()='more_vert'])[1]");
	By selectproject = By.xpath("//mat-select[@formcontrolname='selectedProjects']");
	By searchproject = By.xpath("//input[@placeholder='Search projects']");

	public void click_addTodo_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, add_todo);
		commFunc.Click(driver, add_todo);
	}

	public void todo_details(WebDriver driver, String name, String p_name, String m_name) {

		commFunc.sendKeys(driver, todo_name, name);
		commFunc.Click(driver, project_name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, By.xpath("(//mat-option//span[text()='" + p_name + "'])"));
		commFunc.Click(driver, member_name);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, By.xpath("//mat-select[@formcontrolname='member']"));
		commFunc.jclick(driver, By.xpath("//div[@role='listbox']//child::span[contains(text(),'" + m_name + "')]"));
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
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

	public void validate_todo(WebDriver driver) throws FilloException {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Todo created successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Todo created successfully.']")).size() != 0) {
			System.out.println("To-do created successfully!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			commFunc.Click(driver, btn_ok);
			commFunc.Click(driver, selectproject);
			String filter_project = record.getField("Filter_Project");
			todo.filter_project(driver, "Berd", filter_project);
			//commFunc.Click(driver,By.xpath("//button//span[text()=' Apply ']"));
		} else {
			System.err.println("To-do cannot able to created successfully!");
		}
	}

	public void todo_action(WebDriver driver, String action) {
		commFunc.Explicitywait(driver, action_icon);
		commFunc.Click(driver, action_icon);
		commFunc.Click(driver, By.xpath("//div[@role='menu']//child::button//span[contains(text(),'" + action + "')]"));

	}

	public void validate_viewtoDo(WebDriver driver) throws InterruptedException {

		commFunc.Explicitywait(driver, By.xpath("//button//span[contains(text(),'Edit To-do')]"));
		if (driver.findElements(By.xpath("//button//span[contains(text(),'Edit To-do')]")).size() != 0) {
			Thread.sleep(4000);
			commFunc.Click(driver, By.xpath("//button//span[contains(text(),'Edit To-do')]"));
			System.out.println("To-do viewed successfully.");
			business.click_continue_btn(driver);
		}

		else {
			System.out.println("hello ji");
			commFunc.Click(driver,
					By.xpath("//ancestor::div[text()='Back']//parent::div//child::span[@class='mat-button-wrapper']"));

		}
	}

	public void edit_toDo(WebDriver driver) throws InterruptedException {

		Thread.sleep(4000);
		WebElement ele = driver.findElement(By.xpath(
				"//ancestor::span[contains(text(),'Browse Files')]//parent::div[contains(@class,'customFileUpload')]//child::input[@type='file']"));
		ele.sendKeys(System.getProperty("user.dir") + "\\UploadData\\" + "joins.png");
		Thread.sleep(3000);
		member.click_limit(driver);

	}

	public void validate_edit_toDo(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Todo updated successfully.']"));
		if (driver.findElements(By.xpath("//h2[text()='Todo updated successfully.']")).size() != 0) {
			System.out.println("To-Do edited successfully!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			commFunc.Click(driver, btn_ok);
		} else {
			System.err.println("To-Do not edited successfully!");
		}
	}

	public void validate_filter(WebDriver driver, String p_name) throws InterruptedException {

		commFunc.Explicitywait(driver, By.xpath("//mat-select[@formcontrolname='selectedProjects']"));

		Thread.sleep(3000);
		commFunc.Click(driver, selectproject);
		commFunc.Click(driver, By.xpath("//mat-option//span[contains(text(),'" + p_name + "')]"));
		Thread.sleep(3000);
        
	}

	public void filter_project(WebDriver driver, String name, String filter_project) {
		commFunc.Click(driver, searchproject);
		commFunc.sendKeys(driver, searchproject, name);
		commFunc.Click(driver, By.xpath("//mat-option//span[contains(text(),'" + filter_project + "')]"));
		commFunc.Click(driver,By.xpath("//button//span[text()=' Apply ']"));
	}
	
	public void validate_filter_project(WebDriver driver,String actual_name) throws InterruptedException {
		
		Thread.sleep(2000);
		List<WebElement> project_name = driver.findElements(By.xpath("//ancestor::mat-table//child::div//child::p[contains(text(),'Exit360')]"));
		
		int countOffilterValue = project_name.size();
		
		for(int i = 0; i<countOffilterValue; i++) {
			
			String expected_name = project_name.get(i).getText();
			if(expected_name.equalsIgnoreCase(actual_name)) {
				System.out.println("project filter out successfully");
				
			}
			else {
				System.err.println("project is not filter out successfully");
			}
		}
	}
	
	public void validate_complete_tdo(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Todo marked completed successfully.']"));
		
		if(driver.findElements(By.xpath("//h2[text()='Todo marked completed successfully.']")).size()!=0) {
			System.out.println("To-Do completed successfully");
			commFunc.Click(driver, btn_ok);
		}
		
		else {
			System.err.println("To-Do not completed successfully");
		}
	}
	
	public void validatae_reopen_Todo(WebDriver driver) {
		
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Todo re-opened successfully.']"));
		
		if(driver.findElements(By.xpath("//h2[text()='Todo re-opened successfully.']")).size()!=0) {
			System.out.println("To-Do reopen successfully");
			commFunc.Click(driver, btn_ok);
		}
		
		else {
			System.err.println("To-Do not re-open successfully");
		}
	}
	
	public void validate_delete_Todo(WebDriver driver) {
		
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Todo deleted successfully.']"));
		
		if(driver.findElements(By.xpath("//h2[text()='Todo deleted successfully.']")).size()!=0) {
			System.out.println("To-Do delete successfully");
			commFunc.Click(driver, btn_ok);
		}
		
		else {
			System.err.println("To-Do not deleted successfully");
		}
	}
	
}
