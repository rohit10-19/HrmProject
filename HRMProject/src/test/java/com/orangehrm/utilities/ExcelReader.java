package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader 
{
	private static Workbook wb;
	
	public static int getTotalNumberRows(String Sheetname)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream("../HRMProject/Excel/Hrm.xlsx"));
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wb.getSheet(Sheetname).getLastRowNum();
	}
	
	public static String readExcelData(String Sheetname, int rownum, int cellnum)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream("../HRMProject/Excel/Hrm.xlsx"));
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).toString();
		
	}
	public static void setExcelFile(String Sheetname, int rownum, int cellnum,String result)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream("../HRMProject/Excel/Hrm.xlsx"));
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).setCellValue(result);
		try 
		{
			wb.write(new FileOutputStream("../HRMProject/Excel/Hrm.xlsx"));
		} 
		 catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
