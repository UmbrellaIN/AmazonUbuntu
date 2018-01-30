package com.umbrella.Amazon.FunctionalTest;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.PageFactory.MagnetoBackend;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;
/*This class verofies various Table Related functionalities
Pagination
Data Search
Table Filter
Table Sort and Search
Table Data Download
Website for this Test is :: 
Page Library Class is :: GenericWebSites*/
public class VerifyTableSearchFunctionality extends TestBase {

	
	private static final Logger log  = LoggerHelper.getLogger(VerifyTableSearchFunctionality.class);
	Config config;
	GenericWebSites genericweb;
	MagnetoBackend magneto;
	
	@Test
	public void verifyTableFilter() throws Exception
	{
		log.info(" Test verifyTableFilter Get Started " );
		config = new Config(OR);
	    driver.get(config.getWebsite());
	   // genericweb = new GenericWebSites(driver);
	    magneto = new MagnetoBackend(driver);
		magneto.enterUserName("user01");
		magneto.enterPassword("guru99com");
		magneto.clickonsubmit();
		Thread.sleep(5000);
		magneto.handlingPopUp();
		magneto.entersearchbutton("great");
		List<String> actualdataincells = magneto.getDataInCellTwo();
	    for(String data: actualdataincells)
	    {
	    	Assert.assertTrue(data.toLowerCase().contains("great"));
	    }
		
	//	magneto.getnumberofrows();
		
		log.info(" Test verifyTableFilter Get Down " );

	}	
}
