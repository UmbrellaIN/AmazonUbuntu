package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.YouTube;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyYouTubeFunctionality extends TestBase {

	Config config;
	YouTube youtube;
	private static final Logger log = LoggerHelper.getLogger(VerifyYouTubeFunctionality.class);

	@Test
	public void verifyYouTube() throws InterruptedException {
		log.info(VerifyYouTubeFunctionality.class.getName() + " Method verifyYouTube " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		youtube = new YouTube(driver);
		// generic.youTubeSearchButton();
		// generic.getFirstVideo();
		// generic.variousvideoOperation();
		// generic.getReadYStateofVideo();
		// generic.skipAdd();
	}
	
	@Test
	public void SkipAddTest() throws InterruptedException
	{
		log.info(VerifyYouTubeFunctionality.class.getName() + " Method verifyYouTube " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		youtube = new YouTube(driver);
		youtube.skipAdd();
		
	}

}
