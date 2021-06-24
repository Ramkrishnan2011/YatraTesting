package com.yatra.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//BASECLASS
public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase()
	{
		
		try
		{
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\Ramu\\eclipse-workspace\\YatraTest\\src\\main\\java\\com\\yatra" +"\\qa\\config\\config.properties");
			prop.load(ip);
			
		}
		catch(FileAlreadyExistsException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static  void initialization()
	{
		String browsername =prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramu\\Documents\\chromedriver");
			driver= new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
