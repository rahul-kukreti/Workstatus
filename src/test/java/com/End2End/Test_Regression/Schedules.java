package com.End2End.Test_Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;

public class Schedules extends BaseClass {

	@Test(testName = "Add scheduled", priority = 61, enabled = true)
	public void add_schedules() throws InterruptedException, FilloException {
		logger = rep.startTest("Schedules scenarios");
		System.out.println("//For adding schedule");
		member.login_old(driver); // remove when full fledge runnig
		// member.interrupt(driver);// remove when full fledge runnig
		schedule.add_schedule(driver);
        Thread.sleep(3000);
		String title = record.getField("Title");
		commFunc.put_field_data(driver, "title", title);
		String description = record.getField("Description");
		commFunc.put_field_data(driver, "description", description);

		String reset = record.getField("Reset");
		commFunc.selectDropdown(driver, "repeat", reset);
		schedule.click_saveBtn(driver);
		schedule.verify_schedule(driver);
		logger.log(LogStatus.INFO, "Schedule added successfully!");
	}

	@Test(testName = "duplicate scheduled", priority = 62, enabled = true)
	public void duplciate_schedule() throws InterruptedException, FilloException {
		System.out.println("//For duplicat schedule");
		schedule.add_schedule(driver);

		String title = record.getField("Title");
		commFunc.put_field_data(driver, "title", title);
		String description = record.getField("Description");
		commFunc.put_field_data(driver, "description", description);

		String reset = record.getField("Reset");
		commFunc.selectDropdown(driver, "repeat", reset);
		schedule.click_saveBtn(driver);
		schedule.verifyDuplicate_schedule(driver);
		logger.log(LogStatus.INFO, "Duplicate schedule added successfully!");
		
	}

}
