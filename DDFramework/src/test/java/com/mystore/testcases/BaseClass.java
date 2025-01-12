package com.mystore.testcases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	ReadConfig readconfig = new ReadConfig();

	String url = readconfig.getbaseurl();
	String browser = readconfig.getbrowser();
	
	public String emailAddress = readconfig.getemailaddress() ;
	String password = readconfig.getPassword();
	

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() {


		switch(browser.toLowerCase()){

		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "msedge":

			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;

		default:
			driver=null;
			break;

		}
		

		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

		//for logging

		logger = LogManager.getLogger("DDFramework");
		
		driver.get(url);
		logger.info("URL Opened");
	}

	
	
	public void capturescreenshot(WebDriver driver , String testname) throws IOException {
		
		// Step 1: Convert WebDriver object to TakeScreenshot interface
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		// Step2 : call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File (System.getProperty("user.dir") + "//Screenshots//" + testname +".png");
		
		//Step 3 : copy image file to destination
		FileUtils.copyFile(src, dest);
	}
	
	@AfterClass
	public void teardown() {

		driver.close();
		driver.quit();
	}

}
