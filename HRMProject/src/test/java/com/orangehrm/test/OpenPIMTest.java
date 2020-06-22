package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.Base;
import com.orangehrm.pages.Login;
import com.orangehrm.pages.OpenPIM;
import com.orangehrm.utilities.PropertyFileHandle;

public class OpenPIMTest extends Base
{
	Login login;
	OpenPIM openpim;
	
@BeforeMethod
	
	public void setUp()
	{
		browserselection();
		login=new Login();
		openpim=login.loginCredentials(PropertyFileHandle.proprtyfilehandle("username"),PropertyFileHandle.proprtyfilehandle("password") );
		
	}

@Test(priority=1)

public void validateOpenPIMPageTitleTest()
{
	String title = openpim.validateOpenPIM();
	Assert.assertEquals(title, "OrangeHRM");
}
@Test(priority=2)

public void clickTest()
{
	openpim.clicklink();
}
@AfterMethod
public void tearDown()
{
	driver.close();
}

}
