package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.Base;

public class AddEmployee extends Base
{
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	private WebElement addEmployee;
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='chkLogin']")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@id='user_name']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='re_password']")
	private WebElement confirmpassword;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement savebutton;
	
	public AddEmployee()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddEmployee()
	{
		 return  driver.getTitle();
	}
	
	public void setCredentials(String fname, String lname, String userid, String passwd, String cnfmpasswd)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		checkbox.click();
		username.sendKeys(userid);
		password.sendKeys(passwd);
		confirmpassword.sendKeys(cnfmpasswd);
		savebutton.click();
	}
	
	
	
	
	
	
	

}
