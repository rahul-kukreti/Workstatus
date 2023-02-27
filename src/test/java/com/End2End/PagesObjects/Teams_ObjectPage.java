package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class Teams_ObjectPage extends BaseClass {
	
	
	//xpath for teams
	
	By add_team_icon = By.xpath("//button//span[contains(text(),'Add Team')]");
	
	
	public void click_addTeam(WebDriver driver) {
		commFunc.Explicitywait(driver, add_team_icon);
		commFunc.Click(driver, add_team_icon);
	}

}
