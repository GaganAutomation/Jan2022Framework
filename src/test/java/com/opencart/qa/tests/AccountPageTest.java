package com.opencart.qa.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencart.qa.Base.BaseTest;
import com.opencart.qa.utils.Constants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test
	public void accountPageTitleTest() {
		String title = accountPage.getAccountPageTitle();
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void isPageHeaderExistTest() {
		Assert.assertTrue(accountPage.isPageHeaderExist());

	}
	
	@Test
	public void accountPageUrlTest() {
		String url = accountPage.getAccountPageUrl();
		Assert.assertTrue(url.contains(Constants.ACCOUNT_PAGE_FRACTION_URL));
	}
	
	@Test
	public void searchExistTest() {
		Assert.assertTrue(accountPage.isSearchExist());
	}
	
	@Test
	public void accountsPageSectionListTest() {
		List<String> actSecList = accountPage.getAccountsPageSectionList();
		System.out.println("Accounts Sections list = " + actSecList);
		Assert.assertEquals(actSecList, Constants.ACCOUNTS_SECTIONS_LIST);
	}
	
	@Test
	public void searchTest() {
		searchResultPage = accountPage.doSearch("macbook");
		String acctHeaderValue = searchResultPage.getSearchResultHeaderValue();
		Assert.assertTrue(acctHeaderValue.contains("macbook"));
	}
	
	@Test
	public void searchProductCountTest() {
		searchResultPage = accountPage.doSearch("macbook");
		int actProductCount = searchResultPage.getProductSearchCount();
		Assert.assertEquals(actProductCount, Constants.MACBOOK_PRODUCT_COUNT);
	}
	
	@Test
	public void searchProductListTest() {
		searchResultPage = accountPage.doSearch("macbook");
		List<String> acctProductList = searchResultPage.getProductResultList();
		System.out.println(acctProductList);
		
	}
	

}
