package com.umbrella.Amazon.FunctionalTest;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.AmazonHomePage;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyAutoSuggestions extends TestBase{

	Config config;
	AmazonHomePage homepage;
	private final Logger log = LoggerHelper.getLogger(VerifyAutoSuggestions.class);
	
	@Test
	public void verifyAutoSuggestions() throws Exception
	{
		log.info("This test is for VerifyAutoSuggestions Login:");
		log.info(VerifyAutoSuggestions.class.getName()+"Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		homepage = new AmazonHomePage(driver);
		homepage.enterintosearchbox("Selenium");
		Thread.sleep(2000);
		ArrayList<String> count = homepage.autosuggestions();
		int count1 =  count.size();
		Assert.assertTrue(count1>1);
	}
}

