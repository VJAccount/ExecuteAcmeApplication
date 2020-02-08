package com.acme.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.leafBot.pages.HomePage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

import cucumber.api.java.en.Given;

public class LoginPage extends ProjectSpecificMethods {
	
	public LoginPage(RemoteWebDriver driver, ExtentTest node, ExtentTest test){
		this.driver = driver;
		this.node = node;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="email")
	private WebElement eleUserName;	
	
	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;	
	
	@FindBy(how=How.ID,using="buttonLogin")
	private WebElement eleLogin;
	
	@Given("Enter the username as (.*)")
	public LoginPage enterUserName(String data) {	
		clearAndType(eleUserName, data);
		return this;
	}	
	
	@Given("Enter the Password as (.*)")
	public LoginPage enterPassword(String data) {
		clearAndType(elePassword, data);
		return this;
	}
	
	@Given("Click on the Login")
	public HomePage clickLogin() {
		click(eleLogin);
		return new HomePage(driver, node, test);		
	}

}
