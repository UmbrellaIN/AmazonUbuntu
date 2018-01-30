package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.MagnetoBackend;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyDataIsSortedAccordingtoDateASCDESC extends TestBase {
	
	Config config;
	MagnetoBackend magneto;
	private final Logger log = LoggerHelper.getLogger(VerifyDataIsSortedAccordingtoDateASCDESC.class);

	
	@Test
	public void verifyDataIsSortedAccordingtoDateASC() throws Exception
	{
		log.info("This test is for Backend Login:");
		log.info(VerifyDataIsSortedAccordingtoDateASCDESC.class.getName()+"Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		magneto = new MagnetoBackend(driver);
		magneto.enterUserName("user01");
		magneto.enterPassword("guru99com");
		magneto.clickonsubmit();
		Thread.sleep(5000);
		log.info("Handling PopUp");
		magneto.handlingPopUp();
		Thread.sleep(5000);
		magneto.clickoninvoices();
		Thread.sleep(5000);
		magneto.clickonDate();
		Thread.sleep(2000);
		boolean actual = magneto.verifydatesareinascendingorder();
		Assert.assertTrue(actual);
		
}
}