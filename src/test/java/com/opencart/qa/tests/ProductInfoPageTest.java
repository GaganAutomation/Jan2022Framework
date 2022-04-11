package com.opencart.qa.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.Base.BaseTest;
import com.opencart.qa.utils.Constants;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoPageSetup() {
	accountPage	= loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			
			{"MacBook","MacBook Pro"},
			{"MacBook", "MacBook Air"},
			{"Apple", "Apple Cinema 30\""},
			{"Samsung","Samsung SyncMaster 941BW"}
			
		};
	}
	
	@Test(dataProvider = "getProductData")
	public void productInfoHeaderTest(String productName, String mainProductName) {
		searchResultPage = accountPage.doSearch(productName);	
		productInfoPage = searchResultPage.selectProduct(mainProductName);
		Assert.assertEquals(productInfoPage.getProductHeaderText(), mainProductName);
	}

	@Test
	public void productInfoImageTest() {
		searchResultPage = accountPage.doSearch("Macbook");	
		productInfoPage = searchResultPage.selectProduct("MacBook Air");	
		Assert.assertTrue(productInfoPage.getProductImageCount() == Constants.MACBOOK_IMAGES_COUNT);
	}
	
	
	@Test
	public void productInfoTest() {
		searchResultPage = accountPage.doSearch("MacBook");	
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();
		actProductInfoMap.forEach((k,v) -> System.out.println(k + ":" + v));
		sofAssert.assertEquals(actProductInfoMap.get("productname"), "MacBook Pro");
		sofAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		sofAssert.assertEquals(actProductInfoMap.get("Reward Points"), "800");
		sofAssert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");
		sofAssert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		sofAssert.assertAll();
	}
}
