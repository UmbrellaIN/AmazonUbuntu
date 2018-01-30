package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.AmazonHomePage;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifySearchFunctionality extends TestBase {

	Config config;
	AmazonHomePage homepage;
	private final Logger log = LoggerHelper.getLogger(VerifySearchFunctionality.class);

	@Test
	public void verifySearchFunctionality() throws Exception {
		log.info("This test is for VerifySearchFunctionality:");
		log.info(VerifySearchFunctionality.class.getName() + "Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		homepage = new AmazonHomePage(driver);
		homepage.enterintosearchbox("abcsefghijklmnopqrstuvwxyz");
		homepage.clickOnSearchButton();
		String errormessage = homepage.geterrormsg();
		Assert.assertTrue(errormessage.contains("did not match any products"));
	}
}
