package com.opencart.qa.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.Constants;
import com.opencart.qa.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String,String> productInfoMap;
	
	private By productHeader = By.cssSelector("div#content h1");
	private By productImage = By.cssSelector("div#content img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By qty = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By successMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");
	
	public ProductInfoPage(WebDriver driver) {
		
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getProductHeaderText() {
		return eleUtil.waitForElementToBeVisible(productHeader, Constants.DEFAULT_TIME_OUT).getText().trim();
	}
	
	public int getProductImageCount() {
		return eleUtil.waitForElementsToBeVisible(productImage, Constants.DEFAULT_TIME_OUT).size();
	}
	
	public Map<String,String> getProductInfo() {
		productInfoMap = new LinkedHashMap<String,String>();
		productInfoMap.put("productname", getProductHeaderText());
		productInfoMap.put("productImagecount", String.valueOf(getProductImageCount()));
		productMetaData();
		productPriceData();
		return productInfoMap;
	}
	
	
	private void productMetaData() {
		List<WebElement> metaDataList = eleUtil.getElements(productMetaData);
//		Brand: Apple
//		Product Code: Product 18
//		Reward Points: 800
//		Availability: Out Of Stock
		for(WebElement e: metaDataList) {
			String text = e.getText().trim();
			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metaVal = meta[1].trim();
			productInfoMap.put(metaKey, metaVal);
		}
	}
	
	private void productPriceData() {
		List<WebElement> metaPriceList = eleUtil.getElements(productPriceData);
//		1,721.47€
//		Ex Tax: 1,721.47€
		
		String price = metaPriceList.get(0).getText().trim();
		String exPrice = metaPriceList.get(1).getText().trim();
		productInfoMap.put("price", price);
		productInfoMap.put("exTaxPrice", exPrice);
	}
	
	public Boolean isQtyExist() {
		return eleUtil.getElement(qty).isEnabled();
	}
	
	public void getQtyText() {
		
	}
	

}
