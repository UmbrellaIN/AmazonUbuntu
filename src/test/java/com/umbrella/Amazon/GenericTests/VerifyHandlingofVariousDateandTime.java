package com.umbrella.Amazon.GenericTests;

import com.umbrella.Amazon.FunctionalTest.VerifyAutoSuggestions;
import com.umbrella.Amazon.PageFactory.GenericDateTime;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
public class VerifyHandlingofVariousDateandTime extends TestBase{
	
	Config config;
	GenericDateTime gtd ; 
	private final Logger log = LoggerHelper.getLogger(VerifyAutoSuggestions.class);
	
	@Test
	public void verifyHandlingofVariousDateandTime() throws InterruptedException
	{
		log.info(VerifyHandlingofVariousDateandTime.class.getName() + "Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		gtd = new GenericDateTime(driver);
		gtd.clickoncalendarbutton();
		Thread.sleep(4000);
		
	}
	
	

}
