package com.End2End.Test_Regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.End2End.PagesObjects.BugReport_Objectpage;
import com.End2End.PagesObjects.BusinessOwner_Objectpage;
import com.End2End.PagesObjects.Clients_Objectpage;
import com.End2End.PagesObjects.Forgotpassword_Objectpage;
import com.End2End.PagesObjects.Login_Objectpage;
import com.End2End.PagesObjects.Member_ObjectPage;
import com.End2End.PagesObjects.Project_ObjectPage;
import com.End2End.PagesObjects.Schedules_Objectpage;
import com.End2End.PagesObjects.Signup_Objectpage;
import com.End2End.PagesObjects.Supportfeature_Objectpage;
import com.End2End.PagesObjects.Teams_ObjectPage;
import com.End2End.PagesObjects.TimeOff_Objectpage;
import com.End2End.PagesObjects.Todo_Objectpage;
import com.End2End.PagesObjects.Workorder_Objectpage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.utility.BrowserFactory;
import com.utility.CommonFunctions;
import com.utility.ConfigReader;
import com.utility.DataInput;
import com.utility.ExtentManager;
import com.utility.Utility;

public class BaseClass {

	public static WebDriver driver;

	// ExtentReport;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest logger;
	public static Recordset record;
	String sheetName = "Workstatus";

	public static CommonFunctions commFunc = new CommonFunctions();
	public static BrowserFactory browserSelect = new BrowserFactory();
	public static Signup_Objectpage sign = new Signup_Objectpage();
	public static Login_Objectpage login = new Login_Objectpage();
	public static Supportfeature_Objectpage sf = new Supportfeature_Objectpage();
	public static ConfigReader conf = new ConfigReader();
	public static Utility uti = new Utility();
	public static BugReport_Objectpage bg = new BugReport_Objectpage();
	public static Forgotpassword_Objectpage fp = new Forgotpassword_Objectpage();
	public static BusinessOwner_Objectpage business = new BusinessOwner_Objectpage();
	public static Member_ObjectPage member = new Member_ObjectPage();
	public static Member members = new Member();
	public static Teams_ObjectPage teams = new Teams_ObjectPage();
	public static Project_ObjectPage project = new Project_ObjectPage();
	public static Todo_Objectpage todo = new Todo_Objectpage();
	public static DataInput input = new DataInput();
	public static Clients_Objectpage client =  new Clients_Objectpage();
	public static Workorder_Objectpage work =  new Workorder_Objectpage();
	public static Schedules_Objectpage schedule = new Schedules_Objectpage();
	public static TimeOff_Objectpage time = new TimeOff_Objectpage();


	@Parameters({ "enviroment" })
	@BeforeSuite(description = "initializing Driver", alwaysRun = true)
	public void initializeDriver(String enviroment) throws InterruptedException {
		driver = browserSelect.openChromeIncongnito();
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.newstaging.workstatus.io/");

	}

	@Parameters({ "testCaseID" })
	@BeforeSuite(description = "initializing DataInput", alwaysRun = true)
	public void initializeInpuData(String testCaseID) throws FilloException {

		// Get data from sheet
		record = input.getValuefromsheet(sheetName, testCaseID);
	}
}
