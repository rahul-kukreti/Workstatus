package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	
	public ConfigReader() {
		try {

			File src = new File("./src/test/java/com/utility/resources/Config.property");
			FileInputStream fs = new FileInputStream(src);

			prop = new Properties();
			prop.load(fs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String getname() {
		return prop.getProperty("name");
	}
	
	public String getemail() {
		return prop.getProperty("email");
	}
	
	public String getemail_new() {
		return prop.getProperty("email_new");
	}
	
	
	public String getphone() {
		return prop.getProperty("phone_no");
	}
	
	public String getpassword() {
		return prop.getProperty("password");
	}
	
	public String getConfirm_passowrd() {
		return prop.getProperty("cpassword");
	}
	
	public String getdescription() {
		return prop.getProperty("description");
	}
	
	public String getfname() {
		return prop.getProperty("fname");
	}
	
	public String getfemail() {
		return prop.getProperty("femail");
	}
	
	public String getfphone() {
		return prop.getProperty("fphone");
	}

}

