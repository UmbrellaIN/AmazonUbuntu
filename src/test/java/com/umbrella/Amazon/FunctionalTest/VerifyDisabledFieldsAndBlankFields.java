package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.MagnetoBackend;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyDisabledFieldsAndBlankFields extends TestBase {
	
	Config config;
	MagnetoBackend magneto;
	private final Logger log = LoggerHelper.getLogger(VerifyDisabledFieldsAndBlankFields.class);

	
	@Test
	public void verifyDisabledFieldsAndBlankFields() throws Exception
	{
		log.info("This test is for Backend Login:");
		log.info(VerifyDisabledFieldsAndBlankFields.class.getName()+"Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		magneto = new MagnetoBackend(driver);
		magneto.enterUserName("user01");
		magneto.enterPassword("guru99com");
		magneto.clickonsubmit();
		Thread.sleep(5000);
		log.info("Handling PopUp");
		magneto.handlingPopUp();
		Thread.sleep(1000);
		magneto.customerAccountInformation();
		Thread.sleep(3000);
		String elementreadonly = magneto.cheekelementReadOnly();
		Assert.assertNotNull(elementreadonly);
		String elementreadonly1 = magneto.cheekelementPrefixReadOnly();
		Assert.assertNull(elementreadonly1);
		

	}
}
