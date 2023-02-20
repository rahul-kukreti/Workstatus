package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class BugReport_Objectpage extends BaseClass {
	
	//xpath for bug report
	
	By bug_link = By.xpath("//a[@href='https://www.workstatus.io/report-bugs']");
	By bug_title = By.xpath("//input[@name='subject']");
	By bug_desc = By.xpath("//textarea[@name='desc']");
	By bug_email = By.xpath("//input[@name='email']");
	By severity = 	By.xpath("//select[@name='Severity']");
	
	public void click_BugReportlink(WebDriver driver) {
		commFunc.Explicitywait(driver, bug_link);
		commFunc.Click(driver, bug_link);
	}
	
	public void validate_reportlink(WebDriver driver) {
		commFunc.Explicitywait(driver,By.xpath("//div[text()='Submit Issue']"));
		if(driver.findElements(By.xpath("//div[text()='Submit Issue']")).size()!=0) {
			System.out.println("Bug Report link opened successfully!");
		}
		else {
			System.err.println("Bug Report link not opened successfully!");
		}
	}
	
	public void click_file(WebDriver driver, String fileName) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileDir = System.getProperty("user.dir") + "\\UploadData\\" + fileName + "";
		System.out.println(fileDir);
		commFunc.fileUpload(driver, fileDir);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void blank_title(WebDriver driver) {
		//commFunc.sendKeys(driver, bug_title, (conf.getbug_title()));
		commFunc.sendKeys(driver, bug_desc, (conf.getbug_desc()));
		commFunc.sendKeys(driver, bug_email, (conf.getfemail()));
	}
	
	public void severity(WebDriver driver) {
		commFunc.Explicitywait(driver, severity);
		commFunc.Click(driver, severity);
		commFunc.Click(driver, By.xpath("//select[@name='Severity']//child::option[2]"));
	}

}
