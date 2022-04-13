package com.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.Constants;
import com.opencart.qa.utils.ElementUtil;
import com.opencart.qa.utils.Errors;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators

	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwd = By.linkText("Forgotten Password11");
	private By registerLink = By.linkText("Register");
	private By footerLinks = By.xpath("(//div[@class='row'])[last()]//li");
	private By newCustText = By.xpath("(//div/h2)[1]");
	private By headerLinks = By.cssSelector("ul.list-inline span");
	private By myRepo = By.cssSelector("my repo");
	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	// 2. public page const....
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// 3. public page actions..
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
	}

	public String getLoginPageUrl() {
		return eleUtil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);
	}

	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwd);
	}

	public AccountPage doLogin(String un, String pwd) {
		WebElement email_id = eleUtil.waitForElementToBeVisible(email, Constants.DEFAULT_TIME_OUT);
		email_id.sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountPage(driver);
	}
	
	public boolean doInvalidLogin(String un, String pwd) {
		WebElement email_id = eleUtil.waitForElementToBeVisible(email, Constants.DEFAULT_TIME_OUT);
		email_id.clear();
		email_id.sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		String actualErrorMesg = eleUtil.doElementGetText(loginErrorMessg);
		System.out.println(actualErrorMesg);
		if(actualErrorMesg.contains(Errors.LOGIN_PAGE_ERROR_MESG)) {
		return true;
		}
		else {
			return false;
		}
	}

	public boolean isRegisterLinkExist() {
		return eleUtil.doIsDisplayed(registerLink);
	}

	public RegisterAccountPage navigateToRegisterPage() {
		if (isRegisterLinkExist()) {
			eleUtil.doClick(registerLink);
			return new RegisterAccountPage(driver);
		}

		return null;
	}

	public List<String> getFooterLinks() {
		List<WebElement> footerLinksList = eleUtil.getElements(footerLinks);
		List<String> linksList = new ArrayList<String>();
		for (WebElement e : footerLinksList) {
			String text = e.getText();
			linksList.add(text);
		}
		return linksList;
	}

	public String getNewCustomerText() {
		return eleUtil.getElement(newCustText).getText();
	}

	public List<String> isHeaderLinksExist() {
		List<WebElement> headerList = eleUtil.getElements(headerLinks);
		List<String> listOfHeader = new ArrayList<String>();
		for (WebElement e : headerList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				listOfHeader.add(text);
			}
		}
		return listOfHeader;
	}
	
}
