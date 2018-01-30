package com.umbrella.Amazon.GuiTests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.AmazonHomePage;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyAllLinksAreActive extends TestBase {
	
	Config config ;
	AmazonHomePage homepage;
	private final Logger log = LoggerHelper.getLogger(VerifyImageAreBrokenInvalid.class);
		
	@Test
	public void cerifyAllLinksAreActive() throws IOException
	{
		log.info(VerifyAllLinksAreActive.class.getName()+"Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		homepage = new AmazonHomePage(driver);
	    int invalidlinks =  homepage.linksActive();
	    Assert.assertTrue(invalidlinks<1);
		 
		
	}

}
