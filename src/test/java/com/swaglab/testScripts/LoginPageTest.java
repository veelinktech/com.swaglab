package com.swaglab.testScripts;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swaglab.base.TestBase;
import com.swaglab.pages.LoginPage;
import com.swaglab.utilities.Utility;

public class LoginPageTest extends TestBase
{
	
	LoginPage login;
	
	@BeforeTest
	public void setUp()
	{
		init_Browser();
		
		login =  new LoginPage();
	}
	
	@Test
	public void validateTitle()
	{
		String actual_title = login.verifyTitle();
		
		Assert.assertEquals(actual_title,"Swag Labs");
	}
	
	@Test
	public void validateUrl()
	{
		String actual_url = login.verifyUrl();
		
		Assert.assertEquals(actual_url, "https://www.saucedemo.com/v1/");
	}
	
	@Test
	public void validate_usrname_and_password_fontSize()
	{
		SoftAssert soft = new SoftAssert();
		
		String actual_un_font_size = login.verify_usrname_fontSize();
		
		soft.assertEquals(actual_un_font_size, "20px");
		
		String actual_pass_font_size = login.verify_password_fontsize();
		
		soft.assertEquals(actual_pass_font_size, "18px");
		
		soft.assertAll();
		
	}
	
	@Test
	public void validate_Login()
	{
		String homePage_url = login.verify_Login();
		
		Assert.assertEquals(homePage_url, "https://www.saucedemo.com/v1/inventory.html");
		
		login.button_xpath_open_menu.click();
		
		login.a_linktext_logout.click();
		
	}
	
	
	@AfterMethod
	public void failed_TC(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			Utility.take_Screenshot("LoginPageTest1");
		}
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		Utility.close_Win();
	}

}
