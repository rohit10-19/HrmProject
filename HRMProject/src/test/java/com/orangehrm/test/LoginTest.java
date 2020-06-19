package com.orangehrm.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.orangehrm.base.Base;
import com.orangehrm.pages.Login;

public class LoginTest extends Base
{
	
	@Test
	public void loginTest()
	{
		Login l=new Login();
		l.loginCredentials("Admin", "admin123");
		
		
	}

}
