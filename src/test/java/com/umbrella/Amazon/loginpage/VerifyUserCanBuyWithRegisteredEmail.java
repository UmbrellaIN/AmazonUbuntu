//package com.umbrella.Amazon.loginpage;
//
//import org.apache.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.umbrella.Amazon.generics.AlertHelper;
//import com.umbrella.Amazon.generics.LoggerHelper;
//import com.umbrella.Amazon.pageLibrary.BillingCheckOutPage;
//import com.umbrella.Amazon.pageLibrary.SignInPage;
//import com.umbrella.Amazon.testCore.TestBase;
//
//public class VerifyUserCanBuyWithRegisteredEmail extends TestBase {
//
//	private final Logger log = LoggerHelper.getLogger(VerifyUserCanBuyWithRegisteredEmail.class);
//	SignInPage sign ;
//	BillingCheckOutPage shippinginfo = new BillingCheckOutPage();
//	AlertHelper alerhelper;
//
//	@Test(priority = 1)
//	public void testusercanloginwithvalidcredentials() throws Exception {
//		System.out.println(" **********I am starting Test of Demo site**********");
//		log.info(VerifyUserCanBuyWithRegisteredEmail.class + " started");
//		System.out.println("I am Just instantiating signinpage driver");
//		sign = new SignInPage(driver);
//		// sign = new SignInPage();
//		sign.clickonaccountbutton();
//		sign.clickonmyaccountbutton();
//		//String value = OR.getProperty("Username");
//		sign.enterusername("ankit@xyz.com");
//		sign.enterpassword("ankit123");
//	//	sign.enterpassword(OR.getProperty("Password"));
//		sign.submitbutton();
//		// Assert.assertEquals(sign.getpagetitle(), "My Account");
//		if (sign.getpagetitle().equalsIgnoreCase("My Account")) {
//			System.out.println("=========Test Case Pass============");
//		} else {
//			Assert.assertTrue(false, "My Account");
//		}
//
//	}
//
//	@Test(priority = 2)
//	public void testusercanbuproduct() throws Exception {
//		sign.clickonwishlist();
//		if (sign.getpagetitle().equalsIgnoreCase("My Wishlist")) {
//			System.out.println("=========Test Case Pass============");
//		} else {
//			Assert.assertTrue(false, "My Wishlist");
//		}
//		sign.clickoncart();
//		alerhelper = new AlertHelper();
//		alerhelper.isAlertPresent();
//		sign.proceedtocheckout();
//
//	}
//
//	@Test(priority = 3)
//	public void testusercanfillinfo() throws Exception {
//		// shippinginfo = new BillingCheckOutPage();
//		shippinginfo.enteraddress1("Rampur");
//		//shippinginfo.enteraddress1(OR.getProperty("Address"));
//		System.out.println(" **********I am Closing Test of Demo site**********");
//	}
//
//}
