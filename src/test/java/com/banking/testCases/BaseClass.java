package com.banking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;

public class BaseClass {
	
	//All prerequisites available in ReadConfig.java file and importing values to BaseClass
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getSiteURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser") //pass parameters from xml file to open desired browser
	@BeforeClass
	public void setUp(String br) {
		
		logger = Logger.getLogger("BANKING");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			logger.info("Chrome Browser Opened");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			logger.info("Firefox Browser Opened");
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
			logger.info("Microsoft Edge Browser Opened");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		logger.info("URL Opened");
	}
	
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	public void takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot Captured");
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public static String randomNumber()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(6);
		return generatedString2;
	}

}
