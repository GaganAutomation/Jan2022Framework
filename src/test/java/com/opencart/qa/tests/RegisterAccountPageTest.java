package com.opencart.qa.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.Base.BaseTest;
import com.opencart.qa.utils.Constants;


public class RegisterAccountPageTest extends BaseTest {
	
	@BeforeClass
	public void regPageSetup() {
		regiPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmail() {
		Random random = new Random();
		String email = "Janautomation"+random.nextInt(1000)+"@gmail.com";
		return email;
	}

	@Test
	public void registerPageTitleTest() {
		String actTitle = regiPage.getRegisterPageTitle();
		Assert.assertEquals(actTitle, Constants.REGISTER_PAGE_TITLE);
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
	return new Object[][] {
		{"Nitest","Agarwal","7676543456","nitest@123","yes"},
		{"Anu","Kamath","7676543488","anu@123","no"},
		{"Gagan","Tyagi","7676543499","gagan@123","yes"},
	};
  }
	
	
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		
		Assert.assertTrue(regiPage
				.doRegister(firstName, lastName, getRandomEmail(), telephone, password, subscribe));
	}
	
	
	

}
