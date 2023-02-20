package com.End2End.Test_Regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.End2End.PagesObjects.BugReport_Objectpage;
import com.End2End.PagesObjects.Forgotpassword_Objectpage;
import com.End2End.PagesObjects.Login_Objectpage;
import com.End2End.PagesObjects.Signup_Objectpage;
import com.End2End.PagesObjects.Supportfeature_Objectpage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.utility.BrowserFactory;
import com.utility.CommonFunctions;
import com.utility.ConfigReader;
import com.utility.ExtentManager;
import com.utility.Utility;

public class BaseClass {

	public static WebDriver driver;

	//ExtentReport;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest logger;
	
	
	public static CommonFunctions commFunc = new CommonFunctions();
	public static BrowserFactory browserSelect = new BrowserFactory();
	public static Signup_Objectpage sign = new Signup_Objectpage();
	public static Login_Objectpage login = new Login_Objectpage();
	public static Supportfeature_Objectpage sf = new Supportfeature_Objectpage();
	public static ConfigReader conf = new ConfigReader();
	public static Utility uti = new Utility();
	public static BugReport_Objectpage bg = new BugReport_Objectpage();
	public static Forgotpassword_Objectpage fp = new Forgotpassword_Objectpage();
	
	
	@Parameters({"enviroment"})
	@BeforeSuite(description = "initializing Driver", alwaysRun= true)
	public void initializeDriver(String enviroment) throws InterruptedException {
			driver = browserSelect.openChromeIncongnito();
		//driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://app.newstaging.workstatus.io/");
			
	}
}
