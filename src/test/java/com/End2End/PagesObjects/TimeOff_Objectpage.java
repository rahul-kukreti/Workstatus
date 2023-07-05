package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class TimeOff_Objectpage extends BaseClass {

	By timeOff_module = By.xpath("//a[@href='/dashboard/timeoff']");
	By timeoff_button = By.xpath("//button//span[contains(text(),'Request')]");
	By setting_timeoff = By.xpath("//button[@routerlink='/dashboard/settings/timeoff']");

	public void click_timeoff_module(WebDriver driver) {
		commFunc.scrollIntoElement(driver, timeOff_module);
	}
	
	public void timeOff_request(WebDriver driver) {
		commFunc.Explicitywait(driver, timeoff_button);
		commFunc.Click(driver, timeoff_button);
	}
	
	public void add_policy(WebDriver driver) {
		commFunc.Explicitywait(driver, setting_timeoff);
		commFunc.Click(driver, setting_timeoff);
	}
}
