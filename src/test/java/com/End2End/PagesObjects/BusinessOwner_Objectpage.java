package com.End2End.PagesObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;

public class BusinessOwner_Objectpage extends BaseClass {

	// Xpath for business owner form

	By business_option = By.xpath("//h4[text()=' Create a new organisation ']");
	By continue_btn = By.xpath("//button//span[text()=' Continue ']");
	By office_option = By.xpath("//h4[text()=' In an office ']");
	By org_name = By.xpath("//input[@formcontrolname='name']");
	By select_size = By.xpath("(//mat-select[@role='combobox'])[1]");
	By select_industry = By.xpath("(//mat-select[@role='combobox'])[2]");
	By select_option = By.xpath("//div[@role='listbox']//child::mat-option[2]");
	By btn_ok = By.xpath("//button[text()='OK']");

	public void click_businessOption(WebDriver driver) {
		commFunc.Explicitywait(driver, business_option);
		commFunc.Click(driver, business_option);
	}

	public void click_continue_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, continue_btn);
		commFunc.Click(driver, continue_btn);
	}

	public void validate_businessCheckbox(WebDriver driver) {
		if (driver.findElements(By.xpath("//h1[text()=' Where does your team work? ']")).size() != 0) {
			System.out.println("Business checkbox selected.!");
		} else {
			System.err.println("Business checkbox is not selected.!");
		}
	}

	public void click_OfcOption(WebDriver driver) {
		commFunc.Explicitywait(driver, office_option);
		commFunc.Click(driver, office_option);
	}

	public void validate_ofcCheckbox(WebDriver driver) {
		if (driver.findElements(By.xpath("//h1[text()=' Create your Organization ']")).size() != 0) {
			System.out.println("Office checkbox selected.!");
		}

		else {
			System.err.println("Office checkbox is not selected.!");
		}
	}

	public void Organisation(WebDriver driver) throws InterruptedException {
		commFunc.sendKeyswithEnter(driver, org_name, (conf.org_name_old()));

	}

	public void dropdownValues(WebDriver driver) throws InterruptedException {
		commFunc.Click(driver, select_size);
		commFunc.Click(driver, select_option);
		Thread.sleep(2000);
		commFunc.Click(driver, select_industry);
		commFunc.Click(driver, select_option);
		commFunc.Click(driver, continue_btn);
	}

	public void newName(WebDriver driver) {
		driver.findElement(org_name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		commFunc.sendKeyswithEnter(driver, org_name, (conf.org_name_new()));
	}

	public void validate_organizationDetails(WebDriver driver) {
		if (driver.findElements(By.xpath("//h2[text()='Organisation created successfully.']")).size() != 0) {

			System.out.println("Organization created successfully!");
			commFunc.Click(driver, btn_ok);
		}

		else {
			System.err.println("Organization name duplicated!");
		}

	}

	public void validate_Duplicateorganization(WebDriver driver) {
		commFunc.Explicitywait(driver, By.xpath("//h2[text()='Organization already exists with this name.']"));
		if (driver.findElements(By.xpath("//h2[text()='Organization already exists with this name.']")).size() != 0) {

			System.out.println("Organization name duplicated!");
			commFunc.Click(driver, btn_ok);
		}

		else {
			System.err.println("Organization created successfully!");
		}

	}

	public void click_checkboxes(WebDriver driver) {

		List<WebElement> allLinks = driver
				.findElements(By.xpath("//div[contains(@class,'all-reports-single-block-features')]//child::input"));
		Iterator<WebElement> itr = allLinks.iterator();
		while (itr.hasNext()) {
			commFunc.Click(driver,
					By.xpath("(//div[contains(@class,'all-reports-single-block-features')]//child::input)[1]"));
			commFunc.Click(driver,
					By.xpath("(//div[contains(@class,'all-reports-single-block-features')]//child::input)[2]"));
			commFunc.Click(driver,
					By.xpath("(//div[contains(@class,'all-reports-single-block-features')]//child::input)[3]"));
			commFunc.Click(driver,
					By.xpath("(//div[contains(@class,'all-reports-single-block-features')]//child::input)[4]"));
			commFunc.Click(driver,
					By.xpath("(//div[contains(@class,'all-reports-single-block-features')]//child::input)[5]"));
			commFunc.Click(driver,
					By.xpath("(//div[contains(@class,'all-reports-single-block-features')]//child::input)[6]"));
			break;
		}

		commFunc.Click(driver, continue_btn);

	}
	
	public void validate_checkboxes(WebDriver driver) {
		if(driver.findElements(By.xpath("//h1[text()=' Create your first project ']")).size()!=0) {
			System.out.println("All chckboxes clicked successfully!");
		}
		else {
			System.err.println("Continue button is not clicked!");
		}
	}
}
