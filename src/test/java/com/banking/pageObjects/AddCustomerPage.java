package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver localDriver;
	
	//CONSTRUCTOR
	public AddCustomerPage(WebDriver remoteDriver) {
		
		this.localDriver = remoteDriver;
		
		//PageFactory is used to initialize the PageObjects
		PageFactory.initElements(remoteDriver, this);
	}
	
	//click New Customer Link
	@FindBy(how=How.XPATH, using="//div/ul/li[2]/a")
	WebElement linkAddNewCustomer;
	
	//input Customer Name
	@FindBy(how=How.NAME, using="name")
	WebElement txtCustomerName;
	
	//Gender Radio Button
	@FindBy(how=How.NAME, using="rad1")
	WebElement rdGender;
	
	//Date of Birth
	@FindBy(how=How.ID_OR_NAME, using="dob")
	WebElement txtDOB;
	
	//input Address
	@FindBy(how=How.NAME, using="addr")
	WebElement txtAddress;
	
	//input City
	@FindBy(how=How.NAME, using="city")
	WebElement txtCity;
	
	//input State
	@FindBy(how=How.NAME, using="state")
	WebElement txtState;
	
	//input PIN Code
	@FindBy(how=How.NAME, using="pinno")
	WebElement txtPinCode;
	
	//input Phone Number
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txtPhoneNo;
	
	//input Email ID
	@FindBy(how=How.NAME, using="emailid")
	WebElement txtEmailID;
	
	//input Password
	@FindBy(how=How.NAME, using="password")
	WebElement txtPassword;
	
	//click Submit Button
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
		
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void customerName(String cname) {
		txtCustomerName.sendKeys(cname);;
	}
	
	public void customerGender(String cgender) {
		rdGender.click();
	}
	
	public void customerDOB(String mm, String dd, String yy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}
	
	public void customerAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void customerCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void customerState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void customerPINcode(String cpinCode) {
		txtPinCode.sendKeys(cpinCode);
	}
	
	public void customerPhoneNo(String cPhoneNo) {
		txtPhoneNo.sendKeys(cPhoneNo);
	}
	
	public void customerEmailID(String cemail) {
		txtEmailID.sendKeys(cemail);
	}
	
	public void customerPassword(String cpwd) {
		txtPassword.sendKeys(cpwd);
	}
	
	public void clickSubmitButton() {
		btnSubmit.click();
	}
	

}
