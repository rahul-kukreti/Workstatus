package com.End2End.PagesObjects;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;

public class BugReport_Objectpage extends BaseClass {
	
	//xpath for bug report
	
	By bug_link = By.xpath("//a[@href='https://www.workstatus.io/report-bugs']");
	By bug_title = By.xpath("//input[@name='subject']");
	By bug_desc = By.xpath("//textarea[@name='desc']");
	By bug_email = By.xpath("//input[@name='email']");
	By severity = 	By.xpath("//select[@name='Severity']");
	By reproduce = By.xpath("//select[@name='Is it Reproducible']");
	By platform = By.xpath("//select[@name='UDF_NCHAR3']");
	By button = By.xpath("//button[@type='submit']");
	By form_messgae = By.xpath("//h1[text()='THANK YOU!']");
	
	public void click_BugReportlink(WebDriver driver) {
		commFunc.Explicitywait(driver, bug_link);
		commFunc.Click(driver, bug_link);
	}
	
	public void btn_click(WebDriver driver) {
		commFunc.Explicitywait(driver, button);
		commFunc.Click(driver, button);
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
			  } 
		  
		   catch(InterruptedException e) {
		  e.printStackTrace(); 
		  } 
		  String fileDir = System.getProperty("user.dir") + "\\UploadData\\" + fileName + "";
		  System.out.println(fileDir);
		  commFunc.fileUpload(driver, fileDir);
		  
		  try { Thread.sleep(5000);
		  } 
		  catch (InterruptedException e) {
			  
		  e.printStackTrace();
		  }
		 
		
		/*
		 * commFunc.Explicitywait(driver,By.id("//input[@id='uploadfile']")); WebElement
		 * file = driver.findElement(By.id("//input[@id='uploadfile']")); file.
		 * sendKeys("C:\\Users\\Rahul Kukreti\\git\\Workstatus\\Workstatus_Automation\\UploadData\\joins.png"
		 * );
		 */
		 
	}

	
	public void blank_title(WebDriver driver) {
		commFunc.sendKeys(driver, bug_desc, (conf.getbug_desc()));
	   commFunc.sendKeys(driver, bug_email, (conf.getfemail()));
	}
	
	public void blank_email(WebDriver driver) {
		commFunc.sendKeys(driver, bug_title, (conf.getbug_title()));
		commFunc.sendKeys(driver, bug_desc, (conf.getbug_desc()));
	}
	
	public void bug_details(WebDriver driver) {
		commFunc.sendKeys(driver, bug_title, (conf.getbug_title()));
		commFunc.sendKeys(driver, bug_desc, (conf.getbug_desc()));
		 commFunc.sendKeys(driver, bug_email, (conf.getfemail()));
	}
	
	public void severity(WebDriver driver) {
		commFunc.Explicitywait(driver, severity);
		commFunc.Click(driver, severity);
		commFunc.Click(driver, By.xpath("//select[@name='Severity']//child::option[2]"));
	}
	
	public void reproducible(WebDriver driver) {
		commFunc.Explicitywait(driver, reproduce);
		commFunc.Click(driver, reproduce);
		commFunc.Click(driver, By.xpath("//select[@name='Is it Reproducible']//child::option[2]"));
	}
	
	public void platform(WebDriver driver) {
		commFunc.Explicitywait(driver, platform);
		commFunc.Click(driver, platform);
		commFunc.Click(driver, By.xpath("//select[@name='UDF_NCHAR3']//child::option[2]"));
	}
	
	public void captcha_bug(WebDriver driver) {
		
		String str = JOptionPane.showInputDialog("Enter your captcha");
		WebElement element = driver.findElement(By.xpath("//input[@id='input_captcha']"));
		element.sendKeys(str);
		
	}

	public void validate_bugpage(WebDriver driver) {
		commFunc.Explicitywait(driver, form_messgae);
		if(driver.findElements(By.xpath("//h1[text()='THANK YOU!']")).size()!=0) {
			System.out.println("Bug report form submitted successfully!");
		}
		else {
			System.err.println("Bug report form not submitted successfully!");
		}
	}
}
