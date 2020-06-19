package com.orangehrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base 
{
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void browserselection(String browser)
	{
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
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
