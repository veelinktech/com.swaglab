package com.swaglab.testScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.swaglab.base.TestBase;
import com.swaglab.pages.LoginPage;
import com.swaglab.utilities.Utility;
import com.swaglab.utilities.XL_Reader;

public class LoginPageTest_DDF extends TestBase
{
	
LoginPage login;
	
	@BeforeTest
	public void setUp()
	{
		init_Browser();
		
		login =  new LoginPage();
	}
	
	
	@Test(dataProvider = "d1")
	public void validateLogin_DDF(String username, String password)
	{
		login.input_id_userName.sendKeys(username);
		
		login.input_name_passWord.sendKeys(password);
		
		login.button_xpath_Login.click();
		
		login.button_xpath_open_menu.click();
		
		login.a_linktext_logout.click();
	}
	
	@AfterTest
	public void tearDown()
	{
		Utility.close_Win();
	}
	
	
	@DataProvider(name = "d1")
	public Object[][] getData()
	{
		XL_Reader r = new XL_Reader(".\\excelDatas\\DDF_V1.xlsx");
		
		int rows = r.rowCount("Sheet1");
		
		int cols = r.colCount("Sheet1");
		
		Object[][] obj =  new Object[rows][cols];
		
		for(int i=1; i<rows; i++ )
		{
			for(int j=0; j<cols; j++)
			{
				obj[i][j]= r.getData("Sheet1", i, j);
			}
		}
		
		return obj;
	}

}
