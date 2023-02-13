package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class Supportfeature_Objectpage extends BaseClass{
	
	//xpath for support feature page
	
	By support_link = By.xpath("//a[@href='https://www.workstatus.io/suggest-feature']");
	
	
	public void click_supportFeaturelink(WebDriver driver) {
		commFunc.Explicitywait(driver, support_link);
		commFunc.Click(driver, support_link);
	}

}
