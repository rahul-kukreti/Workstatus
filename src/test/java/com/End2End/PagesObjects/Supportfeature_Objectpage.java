package com.End2End.PagesObjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;

public class Supportfeature_Objectpage extends BaseClass {

	// xpath for support feature page

	By support_link = By.xpath("//a[@href='https://www.workstatus.io/suggest-feature']");
	By des_name = By.xpath("//textarea[@name='user-req']");
	By description = By.xpath("//textarea[@placeholder='Project Brief']");
	By filesupload = By.xpath("//button[@id='footer-browse-btn']");
	By fname = By.xpath("//input[@name='fname']");
	By femail = By.xpath("//input[@name='email']");
	By fphone = By.xpath("//input[@name='phone']");
	By radiobutton = By.xpath("//input[@value='Must have']");
	By feature_form = By.xpath("//h1[text()='THANK YOU!']");
	By submitbtn = By.xpath("//button[@type='submit']");

	public void click_supportFeaturelink(WebDriver driver) {
		commFunc.Explicitywait(driver, support_link);
		commFunc.Click(driver, support_link);
	}

	public void click_radiobutton(WebDriver driver) {
		commFunc.Explicitywait(driver, radiobutton);
		commFunc.jclick(driver, radiobutton);
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

	public void validate_supportFeature_link(WebDriver driver) {
		if (driver.findElement(By.id("contact-form-section")).isDisplayed()) {
			System.out.println("Support feature link opened successfully!");
		}

		else {
			System.err.println("Support feature link not opening!");
		}
	}

	public void details(WebDriver driver) {
		commFunc.sendKeys(driver, description, (conf.getdescription()));
		commFunc.sendKeys(driver, fname, (conf.getfname()));
		commFunc.sendKeys(driver, femail, (conf.getfemail()));
		commFunc.sendKeys(driver, fphone, (conf.getfphone()));
	}

	public  void captcha(WebDriver driver) {
		
	WebElement element = driver.findElement(By.xpath("//span[@id='f-quizz']"));
	String str = element.getText();
	
	
	//4   +   5
   // 0 1 2 3 4 5
	  
	String s1 = str.substring(0, 1);
	String s2 = str.substring(4, 5);
	
	Integer I1 = Integer.valueOf(s1);
	Integer I2 = Integer.valueOf(s2);
	Integer I = I1+I2;	
	String number = String.valueOf(I);
	element = driver.findElement(By.xpath("//input[@placeholder='??']"));
	element.sendKeys(number);
			
	}
	
	public void click_featureBtn(WebDriver driver) {
		commFunc.Explicitywait(driver, submitbtn);
		commFunc.Click(driver, submitbtn);
	}
	
	public void validate_featurepage(WebDriver driver) {
		commFunc.Explicitywait(driver, feature_form);
		if(driver.findElements(By.xpath("//h1[text()='THANK YOU!']")).size()!=0) {
			System.out.println("Feature form submitted successfully!");
		}
		else {
			System.err.println("Feature form not submitted successfully!");
		}
	}
}
