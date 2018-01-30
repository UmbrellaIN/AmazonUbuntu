package com.umbrella.Amazon.GuiTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.AmazonHomePage;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyImageAreBrokenInvalid extends TestBase {
	
	Config config ;
	AmazonHomePage homepage;
	private final Logger log = LoggerHelper.getLogger(VerifyImageAreBrokenInvalid.class);

	@Test
	public void validateInvalidImages() {
	    log.info(VerifyImageAreBrokenInvalid.class.getName() + " started");
	    config = new Config(OR);
		driver.get(config.getWebsite());
		log.info("Calling brokenImage Method:");
		homepage = new AmazonHomePage(driver);
		int numberofbrokenimages = homepage.brokenImagetest();
		Assert.assertTrue(numberofbrokenimages<=0);
	}


}
