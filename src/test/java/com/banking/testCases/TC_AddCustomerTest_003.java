package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassWord(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		logger.info("User Logged In");
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.clickAddNewCustomer();
		
		logger.info("Providing Customer Details.....");
		addCust.customerName("abhishek");
		addCust.customerDOB("01", "01", "1997");
		Thread.sleep(3000);
		addCust.customerAddress("INDIA");
		addCust.customerCity("EGDT");
		addCust.customerState("AP");
		addCust.customerPINcode("533249");
		addCust.customerPhoneNo("9999900000");
		
		String emailid = randomString()+"@gmail.com";
		addCust.customerEmailID(emailid);
		
		addCust.customerPassword("asdfghjkl");
		addCust.clickSubmitButton();
		
		Thread.sleep(3000);
		
		logger.info("Validation Started...");
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result==true)
		{
			Assert.assertTrue(true);
			logger.info("Test Passed");
		}
		else
		{
			takeScreenshot("addNewCustomer", driver);
			logger.info("Screenshot Captured");
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}	
	}
}
