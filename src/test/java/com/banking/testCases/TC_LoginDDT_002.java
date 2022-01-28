package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username Provided");
		lp.setPassWord(pwd);
		logger.info("Password Provided");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close invalid alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed - Invalid Credentials");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("User Logged In");
			lp.clickLogout();
			Thread.sleep(3000);
			logger.info("User Logged out");
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	
	//user defined method created to check alert is present or not
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	//takes data from xl sheet and stores values in 2D array
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException {
		
		String xlPath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\banking\\testData\\LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(xlPath, "Sheet1");
		int colCount = XLUtils.getCellCount(xlPath, "Sheet1", 1);
		
		String logindata[][] = new String[rowCount][colCount];
		for(int i=1; i<=rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				//in array it should be array[0]0] and from xl sheet sheet[0][1]
				//then the array should be array[0-1][0]
				logindata[i-1][j] = XLUtils.getCellData(xlPath, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
