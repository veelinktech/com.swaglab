package com.swaglab.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.swaglab.utilities.Utility;

public class TestBase 
{
	public static File f;
	
	FileInputStream fis;
	
	public Properties pro;
	
	public static WebDriver driver;
	
	
	public TestBase()
	{
		try
		{
			f = new File(".\\src\\main\\java\\com\\swaglab\\configuration\\config.properties");
		
			fis = new FileInputStream(f);
			
			pro = new Properties();
			
			pro.load(fis);
		}
		
	
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void init_Browser()
	{
		String browser = pro.getProperty("browserName");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Given browser is wrong");
		}
		
		
		driver.get(pro.getProperty("appUrl"));
		
		
		Utility.max_Win();
		
		Utility.implicitly_Wait(45);
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
