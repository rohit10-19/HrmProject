package com.orangehrm.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class PropertyFileHandle 
{
	public static String proprtyfilehandle(String key)
	{
		Properties pro=new Properties();
		try 
		{
			pro.load(new FileInputStream("../HRMProject/Utility/hrm.properties"));
		} 
		catch(Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pro.getProperty(key);
	}

}
