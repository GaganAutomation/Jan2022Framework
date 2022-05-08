package com.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.Constants;
import com.opencart.qa.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators

	private By search = By.name("search");
	private By header = By.cssSelector("div#logo a");
	private By accSecList = By.cssSelector("div#content h2");
	private By btnSearch = By.cssSelector("div#search button");
	private By locator;

	// 2. public page const....
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// 3. public page Actions

	public String getAccountPageTitle() {
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	public boolean isPageHeaderExist() {
		return eleUtil.doIsDisplayed(header);
	}

	public String getAccountPageUrl() {
		return eleUtil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNT_PAGE_FRACTION_URL);
	}
	
	
	public boolean isSearchExist() {
		return eleUtil.doIsDisplayed(search);
	}
	
	public SearchResultPage doSearch(String ProductName) {
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, ProductName);
			eleUtil.doClick(btnSearch);
			return new SearchResultPage(driver);
		}
		
		return null;
	}
	
	public List<String> getAccountsPageSectionList() {
		List<WebElement> secList = eleUtil.getElements(accSecList);
		List<String> accSecList = new ArrayList<String>();
		for(WebElement e: secList) {
			String text = e.getText();
			accSecList.add(text);
		}
		
		return accSecList;
	}

}
