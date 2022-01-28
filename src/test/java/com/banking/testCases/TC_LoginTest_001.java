package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
		
	@Test
	public void LoginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassWord(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("User Logged In");
			logger.info("Login Test Passed");
		}
		else
		{
			takeScreenshot("TC_LoginTest_001", driver);
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
	}

}
