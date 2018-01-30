package com.umbrella.Amazon.GuiTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.AmazonHomePage;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;


public class VerifyCarouselRotation extends TestBase{
	
	Config config ;
	AmazonHomePage homepage;
	private final Logger log = LoggerHelper.getLogger(VerifyCarouselRotation.class);
	
	@Test
	public void verifyCarouselRotation() throws Exception
	{
		log.info(VerifyCarouselRotation.class.getName() + " started");
		System.out.println("Hello I am fine");
	    config = new Config(OR);
		driver.get(config.getWebsite());
		homepage = new AmazonHomePage(driver);
		int actualinoofimages = homepage.numberofimageincarsoul();
		Assert.assertEquals(10, actualinoofimages);
//		if(actualinoofimages == 10)
//		{
//			System.out.println("Test case Pass");
//		}
//		else
//		{
//			System.out.println("Test case Fail");
//		}
		
	}

}
