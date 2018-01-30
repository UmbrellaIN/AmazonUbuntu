package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GenericWebSites;
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
public class VerifyTableGridSearchBox extends TestBase{
	
	private static final Logger log  = LoggerHelper.getLogger(VerifyTableGridSearchBox.class);
	Config config;
	GenericWebSites genericweb;
	
	@Test
	public void verifyTableDataSearch() throws Exception
	{
		log.info(" Test VerifyTableDataSearch Get Started " );
		config = new Config(OR);
	    driver.get(config.getWebsite());
	    genericweb = new GenericWebSites(driver);
	    genericweb.searchbox("in progress");
	    Thread.sleep(3000);
	    int expected = genericweb.NumberOForRowsSearch();
	    log.info("The Number of Expected Rows are " + expected);
	    int actual = genericweb.getDatainStatusColumn();
	    log.info("The Number of Actual Rows are " + actual);
	    Assert.assertEquals(expected, actual);
		log.info(" Test VerifyTableDataSearch Get Down " );
	}	

}
