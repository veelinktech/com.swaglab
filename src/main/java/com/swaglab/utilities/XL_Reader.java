package com.swaglab.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL_Reader 
{
	
	File f;
	
	FileInputStream fis;
	
	XSSFWorkbook wb;
	
	XSSFSheet sh;
	
	
	
	
	public XL_Reader(String excelPath)
	{
		try
		{
			f = new File(excelPath);
		
			fis = new FileInputStream(f);
			
			wb = new XSSFWorkbook(fis);
			
		}
		

		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public int rowCount(String sheetName)
	{
		sh = wb.getSheet(sheetName);
		
		int rowsize = sh.getLastRowNum()+1;
		
		return rowsize;
		
	}
	
	
	public int colCount(String sheetName)
	{
	  
		sh = wb.getSheet(sheetName);
				
		int colCount = sh.getRow(0).getLastCellNum();
		
		return colCount;
	}
	
	
	public String getData(String sheetName, int row, int col)
	{
		sh = wb.getSheet(sheetName);
		
		String data = sh.getRow(row).getCell(col).getStringCellValue();
		
		return data;
	}

}
