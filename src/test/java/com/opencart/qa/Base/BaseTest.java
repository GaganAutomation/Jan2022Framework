package com.opencart.qa.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.opencart.qa.factory.DriverFactory;
import com.opencart.qa.pages.AccountPage;
import com.opencart.qa.pages.LoginPage;
import com.opencart.qa.pages.ProductInfoPage;
import com.opencart.qa.pages.RegisterAccountPage;
import com.opencart.qa.pages.SearchResultPage;


public class BaseTest {

	public WebDriver driver;
	public DriverFactory df;
	public LoginPage loginPage;
	public Properties prop;
	public AccountPage accountPage;
	public RegisterAccountPage regiPage;
	public SearchResultPage searchResultPage;
	public ProductInfoPage productInfoPage;
	public SoftAssert sofAssert;
	

	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(@Optional String browser) {
		df = new DriverFactory();
		prop = df.init_properties();
		
		if(browser!=null) {
			prop.setProperty("browser", browser);	
		}
		
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		regiPage = new RegisterAccountPage(driver);
		sofAssert = new SoftAssert();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
