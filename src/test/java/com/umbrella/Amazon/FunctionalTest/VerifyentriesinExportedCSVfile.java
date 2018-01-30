package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.MagnetoBackend;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyentriesinExportedCSVfile extends TestBase {
	
	Config config;
	MagnetoBackend magneto;
	private final Logger log = LoggerHelper.getLogger(VerifyentriesinExportedCSVfile.class);

	
	@Test
	public void verifyentriesinExportedCSVfile() throws Exception
	{
		log.info("This test is for Backend Login:");
		log.info(VerifyentriesinExportedCSVfile.class.getName()+"Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		magneto = new MagnetoBackend(driver);
		magneto.enterUserName("user01");
		magneto.enterPassword("guru99com");
		magneto.clickonsubmit();
		Thread.sleep(5000);
		magneto.handlingPopUp();
		int expectedcount = magneto.NumberOfRecordsonPage();
		magneto.clickonExportCSV();
		Thread.sleep(15000);
		int actualcount = magneto.getCountFromFile();
		Assert.assertEquals(expectedcount, actualcount);
	}

}
