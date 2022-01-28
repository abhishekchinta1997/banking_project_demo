package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver localDriver;
	
	//CONSTRUCTOR
	public LoginPage(WebDriver remoteDriver) {
		
		this.localDriver = remoteDriver;
		
		//PageFactory is used to initialize the PageObjects
		PageFactory.initElements(remoteDriver, this);
	}
	
	//Identify the elements which are in the Login Page
	
	//input username field
	@FindBy(name="uid")
	WebElement txtUserName;
	
	//input password field
	@FindBy(name="password")
	WebElement txtPassWord;
	
	//click login button
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	//click logot button
	@FindBy(xpath="//div/ul/li[15]/a")
	WebElement linkLogout;
	
	public void setUserName(String uname) {
		
		txtUserName.sendKeys(uname);
	}
	
	public void setPassWord(String pwd) {
		
		txtPassWord.sendKeys(pwd);
	}

	public void clickLogin() {
	
		btnLogin.click();
	}
	
	public void clickLogout() {
		
		linkLogout.click();
	}

}
