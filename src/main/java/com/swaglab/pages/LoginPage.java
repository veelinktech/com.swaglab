package com.swaglab.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.base.TestBase;

public class LoginPage extends TestBase
{
	
	@FindBy(id = "user-name")
	public WebElement input_id_userName;
	
	@FindBy(name = "password")
	public WebElement input_name_passWord;
	
	@FindBy(xpath = "//input[@value='LOGIN']")
	public WebElement button_xpath_Login;
	
	@FindBy(id = "login_credentials")
	WebElement div_id_login_credentials;
	
	@FindBy(className = "login_password")
	WebElement div_classname_login_password;
	
	@FindBy(xpath = "//button[text()='Open Menu']")
	public WebElement button_xpath_open_menu;
	
	@FindBy(linkText = "Logout")
	public WebElement a_linktext_logout;
	
	public LoginPage()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String verify_usrname_fontSize()
	{
		String fontsize  = input_id_userName.getCssValue("font-size");
		
		return fontsize;
	}
	
	public String verify_username_textbox_width()
	{
		String un_textbox_width = input_id_userName.getCssValue("width");
		
		return un_textbox_width;
	}
	
	
	public String verify_username_textbox_color()
	{
		String un_textbox_color = input_id_userName.getCssValue("color");
		
		return un_textbox_color;
	}
	
	
	public String verify_password_fontsize()
	{
		String password_fontsize = input_name_passWord.getCssValue("font-size");
		
		return password_fontsize;
	}
	
	
	public String verify_Login()
	{
		input_id_userName.sendKeys(pro.getProperty("userName"));
		input_name_passWord.sendKeys(pro.getProperty("password"));
		button_xpath_Login.click();
		return driver.getCurrentUrl();
		
	}
	
	

}
