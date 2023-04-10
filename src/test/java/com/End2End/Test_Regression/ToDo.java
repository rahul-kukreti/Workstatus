package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;

public class ToDo extends BaseClass {

	@Test(testName = "Add To-DO", priority = 47, enabled = true)
	public void add_todo() throws FilloException {
		logger = rep.startTest("To-Do's scenarios");
		System.out.println("//For Add To-dos");
		//member.logout(driver); //open when full fledge running
		member.login_old(driver);
		business.click_module(driver, "To-dos");
		todo.click_addTodo_btn(driver);
		
		//To get To-do name from sheet
		String Name = record.getField("Name");
		
		//To get To-do project name from sheet
		String p_name = record.getField("P_Name");
		
		//To get To-do member name from sheet
		String m_name = record.getField("M_Name");
		todo.todo_details(driver, Name,p_name,m_name);
		business.click_continue_btn(driver);
		todo.get_current_date(driver);
		
		//To get To-do priority from sheet
		String priority = record.getField("Priority");
		
		//To get To-do description from sheet
		String description = record.getField("Desciption");
		todo.todo_detail(driver, priority,description);
		member.click_limit(driver);
		todo.validate_todo(driver);
		logger.log(LogStatus.INFO, "ToDo created successfully!");
		
	}

}
