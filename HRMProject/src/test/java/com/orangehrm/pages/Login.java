package com.orangehrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.Base;



public class Login extends Base
{
	
	@FindBy(id="txtUsername")
	private WebElement userid;
	
	@FindBy(id="txtPassword")
	private WebElement pwd;
	
	@FindBy(id="btnLogin")
	private WebElement loginbutton;
	
	
	public Login()
	{
		
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle()
	{
		 return driver.getTitle();
	}
	
	
	public void loginCredentials(String un, String pd)
	{
		userid.sendKeys(un);
		pwd.sendKeys(pd);
		loginbutton.click();
		
	}
	

}
