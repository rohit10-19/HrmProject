package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.orangehrm.base.Base;

public class ScreenShotHandle extends Base
{
	public static void  screenShotHandle(String imagename)
	{
		Date d = new Date();
		SimpleDateFormat s= new SimpleDateFormat("dd_MM_YYYY");
		String date=s.format(d);
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\Rohit\\git\\HRMProject\\FailedTestCapture\\"+imagename+date+".png");
		try 
		{
			FileUtils.copyFile(src, des);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
