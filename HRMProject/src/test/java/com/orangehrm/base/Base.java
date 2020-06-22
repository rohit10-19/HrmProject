package com.orangehrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.orangehrm.utilities.PropertyFileHandle;

public class Base 
{
	public static WebDriver driver;
	
	public static void browserselection()
	{
		String browser=PropertyFileHandle.proprtyfilehandle("browser");
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "../HRMProject/exe/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "../HRMProject/exe/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Incorrect browser selection");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get(PropertyFileHandle.proprtyfilehandle("url"));
	}
	

}
