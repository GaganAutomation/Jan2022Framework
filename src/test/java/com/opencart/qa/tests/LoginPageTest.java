package com.opencart.qa.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.qa.Base.BaseTest;
import com.opencart.qa.utils.Constants;

import io.qameta.allure.Description;

public class LoginPageTest extends BaseTest {

	@Test
	@Description("login Page Title Test")
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("page title : " + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageUrlTest() {
		String actUrl = loginPage.getLoginPageUrl();
		System.out.println("login page url : " + actUrl);
		Assert.assertTrue(actUrl.contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}

	@Test
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test
	public void isRegisterLinkExistTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

	@Test
	public void loginTest() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accountPage.getAccountPageTitle(), "My Account");
	}

	@Test
	public void footerLinksTest() {
		List<String> footerLinks = loginPage.getFooterLinks();
		System.out.println("Footer List: "+footerLinks);
		Assert.assertEquals(footerLinks, Constants.FOOTER_LIST);
	}
	
	@Test
	public void getNewCustText() { 
		String newCustText = loginPage.getNewCustomerText();
		Assert.assertEquals(newCustText, Constants.LOGIN_PAGE_NEW_CUSTOMER_TEXT);
	}
	
	@Test
	public void isHeaderLinkTest() {
		List<String> headerList = loginPage.isHeaderLinksExist();
		System.out.println(headerList);
		Assert.assertEquals(headerList, Constants.HEADER_LINKS);
	}
	
	
	
}
