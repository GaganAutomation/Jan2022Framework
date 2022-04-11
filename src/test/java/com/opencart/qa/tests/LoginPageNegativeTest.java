package com.opencart.qa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.Base.BaseTest;
import com.opencart.qa.utils.Errors;

public class LoginPageNegativeTest extends BaseTest  {
	
	
	@DataProvider
	public Object[][] getLoginInvalidData() {
		return new Object[][] {
			
			{"Test1@gmail.com","Test123"},
			{"gagantyagi2012@gmail.com","Test@123!!@!"},
			{" ","Test@123"},
			{"test@gmail@.com","Test@#!$!$"},
			{" ", " "}
			
		};
	}

	@Test(dataProvider = "getLoginInvalidData")
	public void LoginInvalidTest(String uname, String pwd) {
		//loginPage.doInvalidLogin(uname, pwd);
		Assert.assertTrue(loginPage.doInvalidLogin(uname, pwd), Errors.LOGIN_PAGE_ERROR_MESG);
	}
	
}
