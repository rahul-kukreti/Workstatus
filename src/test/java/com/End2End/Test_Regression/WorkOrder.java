package com.End2End.Test_Regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Utility;

public class WorkOrder extends BaseClass {

	@Test(testName = "Add WorkOrder", priority = 59, enabled = false)
	public void add_Workorder() throws InterruptedException, FilloException {
		logger = rep.startTest("WorkOrder scenarios");
		System.out.println("//For adding workorder");
		member.login_old(driver); // remove when full fledge runnig
		// member.interrupt(driver);// remove when full fledge runnig
		business.click_module(driver, "Work Orders");
		work.select_client(driver);
		Thread.sleep(2000);
		String instruc = record.getField("Instruction");
		work.add_work(driver, instruc);
		String client_address = record.getField("Client_Address");
		commFunc.put_field_data(driver, "address", client_address);
		work.add_work_stepTwo(driver);
		String type = record.getField("Type");
		commFunc.selectDropdown(driver, "type", type);

		String baseon = record.getField("Based On");
		commFunc.selectDropdown(driver, "basedOn", baseon);

		String cost = record.getField("Cost");
		commFunc.put_field_data(driver, "cost", cost);

		Thread.sleep(2000);
		work.add_notify(driver);

		String reset = record.getField("Reset");
		commFunc.selectDropdown(driver, "reset", reset);
		Thread.sleep(2000);
		client.save_client_btn(driver);
		work.validate_work(driver);
		logger.log(LogStatus.INFO, "Work order added successfully!");
	}

	@Test(testName = "Geolocation", priority = 60, enabled = true)
	public void get_Geolocation() throws InterruptedException {
		System.out.println("//For geolocation");  
		work.set_geo(driver);
	}

}
