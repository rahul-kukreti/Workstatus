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
	
	public String getbug_title() {
		return prop.getProperty("bug_title");
	}
	
	public String getbug_desc() {
		return prop.getProperty("bug_desc");
	}
	
	public String getWrong_email() {
		return prop.getProperty("Wrong_email");
	}
	
	public String org_name_old() {
		return prop.getProperty("org_name_old");
	}

	public String org_name_new() {
		return prop.getProperty("org_name_new");
	}
	
	public String get_project() {
		return prop.getProperty("project_name");
	}
	
	public String get_projectnew() {
		return prop.getProperty("project_name1");
	}
	
	public String get_newMember() {
		return prop.getProperty("member_id");
	}
	
	public String get_nmemberName() {
		return prop.getProperty("member_name");
	}
	
	public String get_week() {
		return prop.getProperty("weekly");
	}
	
	public String get_hour() {
		return prop.getProperty("hour");
	}
	
	public String getemail_member_old() {
		return prop.getProperty("old_member");
	}
	
	public String getpass_member_old() {
		return prop.getProperty("old_password");
	}
	
	public String get_Teamname() {
		return prop.getProperty("Team_Name");
	}
	
	public String get_Project_desc() {
		return prop.getProperty("project_desc");
	}
}

