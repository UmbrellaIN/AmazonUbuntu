package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;
/*This class verofies various Table Related functionalities
Table Data Download
Website for this Test is :: http://www.seleniumeasy.com/test/table-data-download-demo.htmlssss
Page Library Class is :: GenericWebSites*/
public class VerifyTableDownloadPrintSearch extends TestBase{
	
	private static final Logger log  = LoggerHelper.getLogger(VerifyTableDownloadPrintSearch.class);
	Config config;
	GenericWebSites genericweb;
	
	@Test
	public void verifyTableDataDownload() throws Exception
	{
		log.info(" Test VerifyTableDataDownload Get Started " );
		config = new Config(OR);
	    driver.get(config.getWebsite());
	    genericweb = new GenericWebSites(driver);
	    genericweb.clickonPDF();
	    Thread.sleep(4000);
	    genericweb.getLastPDFFileDownloadedInFolder();
	    String expectedtext = "Brielle Williamson Integration Specialist New York 61 2012/12/02 $372,000";
	    String actaultext = genericweb.getDataInPDFFile();
	    Assert.assertTrue(actaultext.contains(expectedtext));
		log.info(" Test VerifyTableDataDownload Get Down " );

	}	

}
