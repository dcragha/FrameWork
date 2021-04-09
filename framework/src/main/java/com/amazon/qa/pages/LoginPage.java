package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory or Object repository
	
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//a[text()='Sign Up']")
		WebElement signUpBtn;
		
		@FindBy(xpath="//div[2]//div[1]//a//img")
		WebElement crmLogo;
		

		
		//Initializing the page objects so that web elements can be accessed through driver
		
		public LoginPage() {
			
			PageFactory.initElements(driver, this);
		}
		
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		
		public boolean verifyCRMLogo() {
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un,String pw) {
			username.sendKeys(un);
			password.sendKeys(pw);
			loginBtn.click();
			
			//after this it should go to home page
			
			return new HomePage();
		}
}
