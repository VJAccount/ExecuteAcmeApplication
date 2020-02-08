package com.acme.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.acme.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;

public class TC001_LoginAndVerify extends ProjectSpecificMethods{

	@BeforeTest
	public void setValues() {
		testCaseName = "Login and LoginOut";
		testDescription = "Login testCase using DemoSalesManager UserName and LogOut";
		nodes = "Leads";
		authors = "Gopinath";
		category = "Smoke";
		dataSheetName = "TC001_Acme";
	}
	
	@Test(dataProvider = "fetchData")
	public void loginAndVerify(String uName, String pwd, String title) {
		new LoginPage(driver, node, test)
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.verifyTitle(title);
	}
	
}
