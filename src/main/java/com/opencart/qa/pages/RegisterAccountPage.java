package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.Constants;
import com.opencart.qa.utils.ElementUtil;

public class RegisterAccountPage {

	// private WebDriver driver;
	private ElementUtil eleUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephn = By.id("input-telephone");
	private By pwd = By.id("input-password");
	private By pwdC = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '0']");
	private By agreeCheckBox = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegisterAccountPage(WebDriver driver) {
		// this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getRegisterPageTitle() {
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.REGISTER_PAGE_TITLE);
	}

	public boolean doRegister(String firstName, String lastName, String email, String telephn, String pwd,
			String subscribe) {
		eleUtil.waitForElementToBeVisible(this.firstName, Constants.DEFAULT_TIME_OUT).sendKeys(firstName);

		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephn, telephn);
		eleUtil.doSendKeys(this.pwd, pwd);
		eleUtil.doSendKeys(this.pwdC, pwd);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		} else {
			eleUtil.doClick(subscribeNo);
		}

		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueBtn);

		if (getAccountRegisterSuccessMessg().contains(Constants.REGISTER_SUCCESS_MESSG)) {
			goToRegisterPage();
			return true;
		}

		return false;
	}

	public String getAccountRegisterSuccessMessg() {
		return eleUtil.waitForElementToBeVisible(sucessMessg, Constants.DEFAULT_TIME_OUT).getText();
	}

	private void goToRegisterPage() {
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);

	}
}
