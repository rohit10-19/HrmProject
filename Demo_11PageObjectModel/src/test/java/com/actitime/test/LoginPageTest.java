package com.actitime.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.pages.LoginPage;
import com.acttime.base.Base;

public class LoginPageTest extends Base
{
	@Test
	public void verifyLogin()
	{
		LoginPage login=new LoginPage(driver);
		login.loginCredentials("admin", "manager");
		logger.info("Entering credentials");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logoutLink")));
		String ref = text.getText();
		
		System.out.println(ref);
		logger.info("Print Text");
		 Assert.assertEquals(ref, "Logout");
		 System.out.println("Login Sucessful");
		 logger.info("Login sucessful");
		
	}

}
