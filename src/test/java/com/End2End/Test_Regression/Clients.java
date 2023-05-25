package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;

public class Clients extends BaseClass {

	@Test(testName = "Add client", priority = 55, enabled = true)
	public void add_client() throws FilloException, InterruptedException {
		logger = rep.startTest("Cleints scenarios");
		System.out.println("//For Add Client");
		member.login_old(driver); // remove when full fledge runnig
		member.interrupt(driver);// remove when full fledge runnig
		business.click_module(driver, "Clients");
		client.add_client_btn(driver);

		String client_Name = record.getField("Client_Name");
		commFunc.put_field_data(driver, "clientName", client_Name);

		String client_address = record.getField("Client_Address");
		commFunc.put_field_data(driver, "clientAddress", client_address);
		business.click_continue_btn(driver);

		String client_email = record.getField("Client_Email");
		commFunc.put_field_data(driver, "clientEmail", client_email);
		client.get_country_code(driver);

		String client_phone = record.getField("Client_Phone");
		commFunc.put_field_data(driver, "clientPhone", client_phone);
		Thread.sleep(2000);
		client.continue_btn(driver);

		String p_name = record.getField("P_Name");
		client.select_project(driver, p_name);
		client.continue_btn1(driver);

		String type = record.getField("Type");
		commFunc.selectDropdown(driver, "type", type);

		String baseon = record.getField("Based On");
		commFunc.selectDropdown(driver, "basedOn", baseon);

		String cost = record.getField("Cost");
		commFunc.put_field_data(driver, "cost", cost);

		String percentage = record.getField("Percentage");
		commFunc.put_field_data(driver, "percentage", percentage);

		String reset = record.getField("Reset");
		commFunc.selectDropdown(driver, "reset", reset);
		client.get_currentDate(driver);

		client.save_client_btn(driver);
		logger.log(LogStatus.INFO, "Client added successfully!");

	}
	
	@Test(testName = "Edit client", priority = 56, enabled = true)
	
	public void edit_client() throws FilloException {
		System.out.println("For edit client");
		client.edit_client(driver);
		client.save_client_btn(driver);
		client.validate_edit_client(driver);
		logger.log(LogStatus.INFO, "Client edited successfully!");
	}
	
	@Test(testName = "Archive client", priority = 57, enabled = true)
	public void archive_client() {
		System.out.println("//For archive client");
		client.archive_client(driver);
		logger.log(LogStatus.INFO, "Client archived successfully!");
	}
	
	@Test(testName = "Un-archive client", priority = 58, enabled = true)
	
	public void unarchive_client() {
		System.out.println("//For un-archive client");
		client.unarchived_Client(driver);
		logger.log(LogStatus.INFO, "Client un-archived successfully!");
	}

}
