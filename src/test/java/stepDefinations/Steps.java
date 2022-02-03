package stepDefinations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.banking.pageObjects.LoginPage;
import com.banking.testCases.BaseClass;
import com.banking.utilities.ReadConfig;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public ReadConfig rc;
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		
		rc = new ReadConfig();
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver = new ChromeDriver();
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(baseURL);
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String uname, String pwd) {
	    
		lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassWord(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void the_page_title_should_be(String string) {
	    
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else if(driver.getTitle().equals("Guru99 Bank Home Page"))
		{
			Assert.assertTrue(true);
		}	
		else 
		{
			Assert.assertTrue(false);
		}
	}

	@When("User click Logout")
	public void user_click_logout() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(2000);
	    driver.switchTo().alert().accept(); //close logout alert
		driver.switchTo().defaultContent();

	}
	

	@Then("close Browser")
	public void close_browser() {
	    driver.close();
	}

}
