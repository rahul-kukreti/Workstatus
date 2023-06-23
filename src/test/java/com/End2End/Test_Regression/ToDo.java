package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;

public class ToDo extends BaseClass {

	@Test(testName = "Add To-DO", priority = 47, enabled = true)
	public void add_todo() throws FilloException {
		logger = rep.startTest("To-Do's scenarios");
		System.out.println("//For Add To-dos");
		 member.logout(driver); //open when full fledge running
		member.login_old(driver);
		member.interrupt(driver);
		business.click_module(driver, "To-dos");
		todo.click_addTodo_btn(driver);

		// To get To-do name from sheet
		String Name = record.getField("Name");

		// To get To-do project name from sheet
		String p_name = record.getField("P_Name");

		// To get To-do member name from sheet
		String m_name = record.getField("M_Name");
		todo.todo_details(driver, Name, p_name, m_name);
		business.click_continue_btn(driver);
		todo.get_current_date(driver);

		// To get To-do priority from sheet
		String priority = record.getField("Priority");

		// To get To-do description from sheet
		String description = record.getField("Description");
		todo.todo_detail(driver, priority, description);
		member.click_limit(driver);
		member.interrupt(driver);
		todo.validate_todo(driver);
		logger.log(LogStatus.INFO, "ToDo created successfully!");

	}

	@Test(testName = "View To-Do", priority = 48, enabled = true)
	public void view_todo() throws InterruptedException {

		todo.todo_action(driver, "View ToDo");
		System.out.println("//For View To-dos");
		todo.validate_viewtoDo(driver);
		logger.log(LogStatus.INFO, "View Todo validated successfully");
	}

	@Test(testName = "Edit To do", priority = 49, enabled = true)
	public void edit_todo() throws InterruptedException {
		System.out.println("//For Edit To-dos");
		todo.edit_toDo(driver);
		todo.validate_edit_toDo(driver);
		logger.log(LogStatus.INFO, "Edit Todo validated successfully");
	}

	@Test(testName = "Filter To-Do", priority = 50, enabled = true)
	public void filter_todo() throws FilloException, InterruptedException {
		System.out.println("//For Filter To-dos");
		// To get To-do project name from sheet
		String p_name = record.getField("P_Name");
		todo.validate_filter(driver, p_name);
		logger.log(LogStatus.INFO, "Filter To-Do validated successfully");
	}

	@Test(testName = "filter project", priority = 51, enabled = true)
	public void filter_project() throws FilloException, InterruptedException {
		System.out.println("//For Filter project");
		String filter_project = record.getField("Filter_Project");
		todo.filter_project(driver, "Exit", filter_project);
		todo.validate_filter_project(driver, "Exit360");
		logger.log(LogStatus.INFO, " project Filter To-Do validated successfully");
		driver.navigate().refresh();
	}

	@Test(testName = "complete ToDo", priority = 52, enabled = true)
	public void complete_todo() {
		System.out.println("For complete ToDo");
		todo.todo_action(driver, "Complete ToDo");
		todo.validate_complete_tdo(driver);
		logger.log(LogStatus.INFO, "To-Do completed successfully");

	}

	@Test(testName = "Re-open ToDo", priority = 53, enabled = true)
	public void ReOpen_ToDo() {
		System.out.println("For Re-open ToDo");
		todo.todo_action(driver, "Reopen Todo");
		todo.validatae_reopen_Todo(driver);
		logger.log(LogStatus.INFO, "To-Do re-open successfully");
	}
	
	@Test(testName = "Delete ToDo", priority = 54, enabled= true)
	
	public void Delete_Todo() {
		System.out.println("For Delete ToDo");
		todo.todo_action(driver, "Delete ToDo");
		todo.validate_delete_Todo(driver);
		logger.log(LogStatus.INFO, "To-Do delete successfully");
	}

}
