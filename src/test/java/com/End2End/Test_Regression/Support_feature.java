package com.End2End.Test_Regression;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Support_feature extends BaseClass {

	@Test(testName = "Click support feature tab", priority = 8, enabled = true)
	public void click_support_feat() {
		logger = rep.startTest("Support feature scenarios");
		System.out.println("//For clicking on support feature link..!!");
		sf.click_supportFeaturelink(driver);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		sf.validate_supportFeature_link(driver);
		logger.log(LogStatus.INFO, "Support feature opened successfully!");

	}

	@Test(testName = "submit feature page", priority = 9, enabled = true)
	public void details_supportFeature() {
		System.out.println("//For filling details in support feature page..!!");
		sf.details(driver);
		sf.click_radiobutton(driver);
		sf.captcha(driver);
		sf.click_featureBtn(driver);
		sf.validate_featurepage(driver);
		logger.log(LogStatus.INFO, "Support feature submitted successfully!");
		driver.close();
		
	}
	
}
