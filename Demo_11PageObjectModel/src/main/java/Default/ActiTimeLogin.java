package Default;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ActiTimeLogin 
{
	//Logger logger=Logger.getLogger(ActiTimeLogin .class);
	
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	@BeforeMethod
	public void setUp()
	{
		reports = new ExtentReports("user.dir"+"\\extentreports.html");
		test = reports.startTest("ExtentDemo");
		//PropertyConfigurator.configure("log4j.properties");
		//PropertyConfigurator.configure("log4j.xml");
		
		//BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "../Demo_11PageObjectModel/exe/chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("http://localhost/login.do");
		// logger.info("Opening actitime application");
		 test.log(LogStatus.INFO, "Home page of the application is opened");
	
	 }
	
	@Test
	public void verifyLogin()
	{
		test.log(LogStatus.INFO, "Username is admin");
		driver.findElement(By.id("username")).sendKeys("Admin");
		//logger.info("Entering user name");
		test.log(LogStatus.INFO, "Password is manager");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		//logger.info("Entering user password");
		driver.findElement(By.id("loginButton")).click();
		//logger.info("Clicking on loggin button");
		test.log(LogStatus.INFO, "User click on login button");
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logoutLink")));
		//String ref = text.getText();
		//System.out.println(ref);
		// Assert.assertEquals(ref, "Logout");
		//SoftAssert s= new SoftAssert();
		//s.assertEquals(ref, "Logout");
		//s.assertAll();
		// System.out.println("Login Sucessful");
		// logger.info("Login sucessfulmessage");
		
		 String expPageTitle="actiTIME - Login";
		 String actualPageTitle=driver.getTitle();
		 System.out.println(actualPageTitle);
		 if(expPageTitle.equals(actualPageTitle))
		 {
			 test.log(LogStatus.PASS, "Login is success"); 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Login is failed");
				try 
				{
					test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+ "test failed");
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		 }
	}
	@AfterMethod
	public void tearDown()
	{
		reports.endTest(test);
		reports.flush();
		driver.close();
	}
private String capture(WebDriver driver) throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("src/../ErrImages"+System.currentTimeMillis()+".png");
		String errflpath = destFile.getAbsolutePath();
		FileUtils.copyFile(srcFile, destFile);
		return errflpath;
		
	}
	


}
