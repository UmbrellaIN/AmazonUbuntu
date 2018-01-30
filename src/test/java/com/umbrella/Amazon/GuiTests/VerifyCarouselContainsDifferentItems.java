package com.umbrella.Amazon.GuiTests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.AmazonHomePage;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyCarouselContainsDifferentItems extends TestBase{
	
	Config config;
	AmazonHomePage homepage;
	
	private final Logger log = LoggerHelper.getLogger(VerifyCarouselContainsDifferentItems.class);
	
	@Test
	public void verifyCarouselContainsDifferentItems() throws Exception
	{
		log.info(VerifyCarouselContainsDifferentItems.class.getName() + " started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		homepage = new AmazonHomePage(driver);
		log.info("Getting First List");
		ArrayList<String> list1 = homepage.getitemsincarasoulbeforeclick();
		homepage.clickonnextincarasoul();
		log.info("Getting Secong List");
		ArrayList<String> list2 = homepage.getitemsincarasoulafterclick();
		log.info("Comparing both the List");
		Assert.assertFalse(list1.equals(list2));
		
	}

}
