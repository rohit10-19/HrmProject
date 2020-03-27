package com.acttime.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;




public class Base 
{
	 protected WebDriver driver;
	 public Logger logger;
	 @BeforeClass
	 public void logger()
	 {
		 logger=Logger.getLogger(getClass());
		 
	 }
	
	 @BeforeMethod
	 @Parameters({"browsername","url"})
	 public void initilization(String browsername, String url)
	 {
		// PropertyConfigurator.configure("log4j.properties");
		 if(browsername.equals("Chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "../Demo_11PageObjectModel/exe/chromedriver.exe");
			 driver=new ChromeDriver();
		 }
		 else if(browsername.equals("FireFox"))
		 {
			 System.setProperty("Webdriver.gecko.driver", "../Demo_11PageObjectModel/exe/geckodriver.exe");
			 driver=new FirefoxDriver();
			 
		 }
		 else
		 {
			 System.out.println("Browser not found");
		 }
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
		 driver.manage().window().maximize();
		 
		 driver.get(url);
		 logger.info("Opening actitime application");
	 }
		 
	 
	/* @BeforeMethod
	 @Parameters({"browsername","url"})
	 public void setUp(String browsername, String url)
	 {
		 initilization(browsername, url);
	 }*/
	 
	 @AfterMethod
	 public void tearDown()
	 {
		 driver.close();
	 }

}
