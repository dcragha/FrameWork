package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\framework\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
		
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public static void initializer() {
			
			String browserName=prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver","I:\\\\Ragu_IT\\\\Java&Selenium\\\\Browsers\\\\chromedriver.exe");
			    driver=new ChromeDriver();
			}else if(browserName.equals("firefox")){
				System.out.println("firefox");
				
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			
			
		}
		
		
	
	
	

}
