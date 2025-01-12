package com.mystore.utilities;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "C:\\Users\\User\\eclipse-workspace\\DDFramework\\Configuration\\config.properties";


	public ReadConfig() {

		try {

			properties = new Properties();

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	public String getbaseurl() {

		String value = properties.getProperty("baseurl");

		if (value!= null) 

			return value;

		else 
			throw new RuntimeException("url not sepecified in config file");
	}	

	public String getbrowser() {

		String value = properties.getProperty("browser");

		if(value!=null)

			return value;

		else
			throw new RuntimeException("browser not found");
	}

	public String getemailaddress() {

		String email = properties.getProperty("email");

		if(email!=null)

			return email;
		else
			throw new RuntimeException("email not specified in config file.");
	}

	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");

	}
}

