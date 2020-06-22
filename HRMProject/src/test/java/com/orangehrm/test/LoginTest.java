package com.orangehrm.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.orangehrm.base.Base;
import com.orangehrm.pages.Login;
import com.orangehrm.utilities.PropertyFileHandle;

public class LoginTest extends Base
{
	Login login;
	@BeforeMethod
	
	public void setUp()
	{
		browserselection();
		login=new Login();
	}

	@Test(priority=1)

	public void ValidateLoginPageTest()
	{
		String title = login.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test(priority=2)
	public void loginTest()
	{
		login.loginCredentials(PropertyFileHandle.proprtyfilehandle("username"),PropertyFileHandle.proprtyfilehandle("password") );
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
