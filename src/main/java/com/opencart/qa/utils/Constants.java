package com.opencart.qa.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	public static final int DEFAULT_TIME_OUT = 5;
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String DEMO_PAGE_TITLE = "DEMO PAGE TITLE";
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_FRACTION_URL = "route=account/account";
	public static final String REGISTER_PAGE_TITLE = "Register Account";
	public static final String Register_PAGE_FRACTION_URL = "route=account/register";
	
	public static final List<String> ACCOUNTS_SECTIONS_LIST = Arrays.asList("My Account",
																"My Orders", 
																"My Affiliate Account", 
																"Newsletter");
	
	public static final List<String> FOOTER_LIST = Arrays.asList("About Us",
			"Delivery Information",
			"Privacy Policy",
			"Terms & Conditions","Contact Us",
			"Returns",
			"Site Map","Brands",
			"Gift Certificates",
			"Affiliate",
			"Specials","My Account",
			"Order History",
			"Wish List",
			"Newsletter");
	public static final String LOGIN_PAGE_NEW_CUSTOMER_TEXT = "New Customer";
	public static final List<String> HEADER_LINKS = Arrays.asList("123456789",
			"My Account",
			"Wish List (0)",
			"Shopping Cart",
			"Checkout");
	public static final int MACBOOK_PRODUCT_COUNT = 3;
	public static final int MACBOOK_IMAGES_COUNT = 4;
	public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created";
	
}
