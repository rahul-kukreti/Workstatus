package com.End2End.Test_Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Schedules extends BaseClass {
	
	@Test(testName = "Add WorkOrder", priority = 61, enabled = true)
	public void add_schedules() throws InterruptedException {
		logger = rep.startTest("Schedules scenarios");
		System.out.println("//For adding workorder");
		member.login_old(driver); // remove when full fledge runnig
		// member.interrupt(driver);// remove when full fledge runnig
		//Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement project = driver.findElement(By.xpath("//a[@href='/dashboard/schedules']"));
		//js.executeScript("arguments[0].scrollIntoView(true);",project);
		//project.click();
		By add_schedule = By.xpath("//a[@href='/dashboard/schedules']");
		commFunc.scrollIntoElement(driver, add_schedule);
	}

}
