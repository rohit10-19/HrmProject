package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.Base;
import com.orangehrm.pages.AddEmployee;
import com.orangehrm.pages.Login;
import com.orangehrm.pages.OpenPIM;
import com.orangehrm.utilities.ExcelReader;
import com.orangehrm.utilities.PropertyFileHandle;

public class AddEmployeeTest extends Base
{
	Login login;
	OpenPIM openpim;
	AddEmployee addemployee;
	
	
@BeforeMethod
	
	public void setUp()
	{
		browserselection();
		login=new Login();
		openpim=login.loginCredentials(PropertyFileHandle.proprtyfilehandle("username"),PropertyFileHandle.proprtyfilehandle("password") );
		addemployee=openpim.clicklink();
	}

@Test(priority=1)

public void validateAddEmployeeTest()
{
	String title = driver.getTitle();
	Assert.assertEquals(title, "OrangeHRM");
}

/*@Test(priority=2)
public void enterData()
{
	int rows = ExcelReader.getTotalNumberRows("Sheet1");
	System.out.println("Total No of Rows:"+rows);
	String fname = ExcelReader.readExcelData("Sheet1", 1, 0);
	String lname = ExcelReader.readExcelData("Sheet1", 1, 1);
	String userid = ExcelReader.readExcelData("Sheet1", 1, 2);
	String passwd = ExcelReader.readExcelData("Sheet1", 1, 3);
	String cnfmpasswd = ExcelReader.readExcelData("Sheet1", 1, 4);
	addemployee.setCredentials(fname, lname, userid, passwd, cnfmpasswd);
}*/
@AfterMethod
public void tearDown()
{
	driver.close();
}

@DataProvider

public Object[][] data()
{
	int rows = ExcelReader.getTotalNumberRows("Sheet1");
	System.out.println("Total No of Rows:"+rows);
	Object[][] ref = new String[rows][5];
	for(int i=0;i<rows;i++)
	{
		ref[i][0]=ExcelReader.readExcelData("Sheet1",i+1, 0);
		ref[i][1]=ExcelReader.readExcelData("Sheet1",i+1, 1);
		ref[i][2]=ExcelReader.readExcelData("Sheet1",i+1, 2);
		ref[i][3]=ExcelReader.readExcelData("Sheet1",i+1, 3);
		ref[i][4]=ExcelReader.readExcelData("Sheet1",i+1, 4);
	}
	
	return ref;
	
}
@Test(priority=2,dataProvider="data")
public void fillData(String fname, String lname, String userid, String passwd, String cnfmpasswd)
{
	addemployee.setCredentials(fname, lname, userid, passwd, cnfmpasswd);
}

}
