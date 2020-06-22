package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.Base;

public class OpenPIM extends Base
{
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	private WebElement pim;
	
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	private WebElement addEmployee;
	
	public OpenPIM()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateOpenPIM()
	{
		return driver.getTitle();
		
		
	}
	
	public AddEmployee clicklink()
	{
		pim.click();
		addEmployee.click();
		return new AddEmployee();
	}

	
	
	

}
