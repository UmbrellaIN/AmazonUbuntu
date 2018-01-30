package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GoIbiboWeb;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

/*
This class verifies that BootStrap Modal does not need any
special opertaion to work on, However if any frame is present
then we have to swith our focus to that frame
Thus Test id fir https://www.goibibo.com/
*/


public class VerifyModalsAreWorking extends TestBase {
	
	private static final Logger log = LoggerHelper.getLogger(VerifyModalsAreWorking.class);
	GoIbiboWeb ibibo;
	Config config;
	
	@Test
	public void verifyModalsAreWorking() throws Exception
	{
		log.info(VerifyModalsAreWorking.class.getName() +" Get Started ");
		ibibo = new GoIbiboWeb(driver);
		config = new Config(OR);
		driver.get(config.getWebsite());
		ibibo.getclickonsignInButton();
		Thread.sleep(3000);
		//ibibo.switchtoframe();
		ibibo.clickonLogin();
		Thread.sleep(3000);

	}

}
