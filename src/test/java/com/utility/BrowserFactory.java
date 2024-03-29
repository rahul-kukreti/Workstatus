package com.utility;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	WebDriver driver;
	
		
	
	public WebDriver openChromeIncongnito() {

		// Run automation in Incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--remote-allow-origins=*");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		// SET CHROME OPTIONS
		contentSettings.put("geolocation", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		return driver;

	}
	
	/*
	 * public WebDriver openChrome() { WebDriverManager.chromedriver().setup();
	 * ChromeOptions options = new ChromeOptions();
	 * 
	 * options.addArguments("--start-maximized");
	 * options.addArguments("disable-infobars");
	 * options.addArguments("--disable-notifications");
	 * options.addArguments("--disable-web-security");
	 * options.addArguments("--no-proxy-server"); Map<String, Object> prefs = new
	 * HashMap<String, Object>(); prefs.put("credentials_enable_service", false);
	 * prefs.put("profile.password_manager_enabled", false);
	 * prefs.put("download.default_directory", System.getProperty("user.dir")
	 * +File.separator + "downloaded Files"); options.setExperimentalOption("prefs",
	 * prefs); driver = new ChromeDriver(options); return driver; }
	 */
}


