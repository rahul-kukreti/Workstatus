package com.End2End.Test_Regression;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;

public class Schedules extends BaseClass {

	@Test(testName = "Add scheduled", priority = 61, enabled = true)
	public void add_schedules() throws InterruptedException, FilloException {
		logger = rep.startTest("Schedules scenarios");
		System.out.println("//For adding schedule");
		commFunc.add_schedule(driver);
		schedule.verify_schedule(driver);
		logger.log(LogStatus.INFO, "Schedule added successfully!");
	}

	@Test(testName = "duplicate scheduled", priority = 62, enabled = true)
	public void duplciate_schedule() throws InterruptedException, FilloException {
		System.out.println("//For duplicat schedule");
		commFunc.add_schedule(driver);
		schedule.verifyDuplicate_schedule(driver);
		logger.log(LogStatus.INFO, "Duplicate schedule added successfully!");

	}

	@Test(testName = "Edit schedule", priority = 63, enabled = true)
	public void edit_schedule() throws InterruptedException {
		System.out.println("//For editing schedule");
		schedule.edit_scheduled(driver);
		commFunc.put_field_data(driver, "description", conf.get_description());
		schedule.click_saveBtn(driver);
		schedule.validate_edit_schedule(driver);
		logger.log(LogStatus.INFO, "Schedule edited successfully!");

	}

	@Test(testName = "Delete schedule one", priority = 64, enabled = true)
	public void delete_schedule() {
		System.out.println("//For deleting schedule");
		schedule.validate_delete_schedule_one(driver);
		logger.log(LogStatus.INFO, "Schedule deleted successfully!");
	}

	@Test(testName = "Delete schedule all", priority = 65, enabled = true)
	public void delete_schedule_all() throws InterruptedException, FilloException {
		commFunc.add_schedule(driver);
		schedule.validatae_schedule_all(driver);
		logger.log(LogStatus.INFO, "All Schedule deleted successfully!");
	}

}
