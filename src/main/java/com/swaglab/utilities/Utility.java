package com.swaglab.utilities;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.swaglab.base.TestBase;

public class Utility extends TestBase
{
	
	public static void max_Win()
	{
		driver.manage().window().maximize();
	}

	
	public static void implicitly_Wait(int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void close_Win()
	{
		driver.close();
	}
	
	public static void min_Win()
	{
		driver.manage().window().minimize();
	}
	
	public static void alert_popup_OK()
	{
		driver.switchTo().alert().accept();
		
	}
	
	public static void alert_popup_Cancel()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static String alert_popup_getText()
	{
		return driver.switchTo().alert().getText();
	}
	
	public static void alert_popup_sendKeys(String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	public static void take_Screenshot(String filename)
	{
		try
		{
		 f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 FileHandler.copy(f, new File(".\\Screenshot\\"+ filename + ".png"));
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void frameIndex(int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	public static void frameIdorName(String idorname)
	{
		driver.switchTo().frame(idorname);
	}
	
	public static void frameWebElement(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
}
