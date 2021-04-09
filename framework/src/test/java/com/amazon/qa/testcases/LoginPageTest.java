package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initializer();
		
		 loginpage=new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title=loginpage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	
	@Test(enabled=false)
	public void crmlLogoTest() {
	boolean logo=loginpage.verifyCRMLogo();	
	Assert.assertTrue(logo);
		
	}
	
	/*
	 * @DataProvider public void crmTesData() {
	 * 
	 * }
	 */
	//use this annotation after completing the data provider utility
	//@Test(priority=4,dataProvider ="crmTesData" )
	
	@Test(enabled=false)
	public void login1Test() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
