package com.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class CommonFunctions {
	// testing
	WebDriver driver;

	JavascriptExecutor js;
	SoftAssert softAssert = new SoftAssert();
	

	static SoftAssert objSoftAssert = new SoftAssert();

	public void assertElementsExistence(WebDriver driver, By xpath) {
		List<WebElement> elements = driver.findElements(xpath);

		if (elements.size() == 0) {
			softAssert.assertTrue(true);

		} else {
			softAssert.assertTrue(false, xpath + " is/are NOT hidden");
		}

		softAssert.assertAll();
	}

	/**
	 * Switches to the next tab
	 *
	 */
	// ---------------------------switchTabs----------------
	public void switchTabs() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				// Switch to the opened tab
				driver.switchTo().window(actual);
			}
		}
	}

	public void scrollUntilAllElementIsVisible(WebDriver driver, By elementsXpath, By vScrollXpath) {
		int elementCount = driver.findElements(elementsXpath).size();

		while (true) {
			driver.findElement(vScrollXpath).sendKeys(Keys.PAGE_DOWN);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int newElementCount = driver.findElements(elementsXpath).size();
			if (newElementCount == elementCount) {
				break;
			}
			elementCount = driver.findElements(elementsXpath).size();
		}

	}

	// <------------------------------Select DropDown Values----------------------->

	public void selectDropdown(WebDriver driver, By Locator, String value) {
		clicabilityWait(driver, Locator);
		List<WebElement> list = driver.findElements(Locator);

		for (WebElement ele : list) {

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			if (ele.getAttribute("innerHTML").contains(value)) {

				ele.click();
				break;
			}
		}
	}

	public void SelectValueFromDropdown(WebDriver driver, By Xpath, String VisabuleText) {
		Select Locater = new Select(driver.findElement(Xpath));
		Locater.selectByVisibleText(VisabuleText);

	}

	// <-------------------------Move To Element location------------------------>

	public void MoveToElement(WebDriver Driver, By locater) {
		Actions actions = new Actions(driver);
		WebElement Element = driver.findElement(locater);
		actions.moveToElement(Element);
		actions.clickAndHold();
		actions.moveToElement(Element);
		actions.release().perform();
	}
	// <-------------------------Move To Element location------------------------>

	public void actionsClick(WebDriver driver, By locater) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locater)).click().perform();
	}

	// <--------------Normal Click Method-------------------->

	public void Click(WebDriver driver, By Locator) {
		try {
			this.clicabilityWait(driver, Locator);
			driver.findElement(Locator).click();

		} catch (Exception e) {
			try {
				jclick(driver, Locator);
			} catch (Exception f) {
				Actions action = new Actions(driver);

				action.moveToElement(driver.findElement(Locator)).click().perform();

			}
		}
	}
	
	// <---------------------Click Element By using JavaScript
	// Executer-------------------->
	public void jclick(WebDriver driver, By Locator) {
		this.Explicitywait(driver, Locator);
		WebElement element = driver.findElement(Locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	// <---------------------------Send Data into Locater With Enter
	// Key-------------------------------->

	public void sendKeyswithEnter(WebDriver driver, By Locator, String value) {

		WebElement element = driver.findElement(Locator);
		element.sendKeys(value);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.sendKeys(Keys.ENTER);

	}

	// <---------------------------Send Data into
	// Locater-------------------------------->
	public void sendKeys(WebDriver driver, By Locator, String value) {
		this.Explicitywait(driver, Locator);
		WebElement element = driver.findElement(Locator);
		element.sendKeys(value);
	}
	
	//For in-case data send into field for formcontrolname
	
	 public void put_field_data(WebDriver driver,String field_data, String value) {
		  
		  WebElement ele = driver.findElement(By.xpath("//input[@formcontrolname='"+field_data+"']"));
		  ele.sendKeys(value);
	  }
	 
	 //For in case mat-select with formcontrolname
	 
	 public void selectDropdown(WebDriver driver, String name, String drop_value) {
		 this.Click(driver, By.xpath("//mat-select[@formcontrolname='"+name+"']"));
		 this.Click(driver, By.xpath("//div[@role='listbox']//mat-option//span[contains(text(),'"+drop_value+"')]"));
	 }
	

	// <----------------------Send Data into Locater by using JavaScript
	// Executer---------------->

	public void jsendkeyes(WebDriver driver, By Locator, String EnterValue) {
		WebElement element = driver.findElement(Locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String val = "Arguments[0].value='" + EnterValue + "';";
		js.executeScript(val, element);
	}

	// <---------------Get Attribute Value Method------------------->

	public String ElementAttributeGetText(WebDriver driver, By Locator, String AttributeName) {
		String Val = driver.findElement(Locator).getAttribute(AttributeName);
		return Val;

	}

	public void CloseBrowserTab() {
		driver.close();
	}

	// <----------------Explicity Wait-------------------------->
	public void Explicitywait(WebDriver driver, By WebElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(WebElement));
	}

	public void explicitywaitInvisibility(WebDriver driver, By WebElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(WebElement));
	}

	public void listWaitGreaterThan(WebDriver driver, By WebElement, int count) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(WebElement, count));
	}

	public void listWaitEqual(WebDriver driver, By WebElement, int count) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.numberOfElementsToBe(WebElement, count));
	}

	// <----------------clicability Wait-------------------------->
	public void clicabilityWait(WebDriver driver, By WebElement) {
		this.Explicitywait(driver, WebElement);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(WebElement));
	}

	// <---------------TextVisibilitycheck-------------------------->
	public void textvisibilityCheck(WebDriver driver, By WebElement, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(WebElement, text));
	}

	public String GetCurrentDate(String ReqDateFormate) {

		DateFormat dateFormat = new SimpleDateFormat(ReqDateFormate);
		Date date = new Date();
		String date1 = dateFormat.format(date);

		return date1;

	}

	public boolean isElementInteractable(WebDriver driver, By element) {
		try {
			WebDriverWait waitDriver = new WebDriverWait(driver, Duration.ofSeconds(5));

			waitDriver.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
//			if(driver.findElement(element).isDisplayed())
//			{
			System.out.println("Multiple tabs are present,....");
//			}
		} catch (Exception e) {
			System.out.println("Continue.....");
			return false;

		}
		return true;
	}

	public void ScrollDown(int scrollpixel) {
		try {
			JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
			myExecutor.executeScript("window.scrollBy(0," + scrollpixel + ")", "");
			Thread.sleep(2000);
			return;
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

	public void scrollIntoElement(WebDriver driver, By element) {
		try {
			Thread.sleep(5000);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					driver.findElement(element));
			this.Click(driver, element);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// <--------------------File Uploading------------------->
	public void fileUpload(WebDriver driver, String fileDir) {
		By inputFileDirField = By.xpath("//div[contains(@class,'customFileUpload')]//input[@type='file']");
		this.explicitywaitInvisibility(driver, inputFileDirField);
		this.sendKeys(driver, inputFileDirField, fileDir);
	}
	//input[contains(@type,'file')]
	//button[@id='footer-browse-btn']
	// <---------------Convert Date Formate--------------------------->

	public String DateFormateConvert(String PrasentDateFormate, String ExpectedDateFormate, String Valu)
			throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(PrasentDateFormate);
		Date myDate = dateFormat.parse(Valu);

		SimpleDateFormat dateFormat2 = new SimpleDateFormat(ExpectedDateFormate);
		String Result = dateFormat2.format(myDate);
		System.out.println("*********Date Formate Changed Successfully*******" + "  " + Result);
		return Result;

	}

	// ------------Get System Time and Date-----------
	public String getSystemDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);

		// Print the Date
		return date1;

	}

	public String DateTimeWeekly() {
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String date = dateFormat2.format(cal.getTime());
		return date;

	}
	
	public  String DateTimemonthly_Start() {
		DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,
				  cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		String date = dateFormat3.format(cal.getTime());
		return date;

	}
	
	public  String DateTimemonthly_End() {
		DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,
				  cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String date = dateFormat3.format(cal.getTime());
		return date;

	}
	
	public String last_14_days() {
		DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-14);
		String date = dateFormat3.format(cal.getTime());
		return date;
	}
	
}