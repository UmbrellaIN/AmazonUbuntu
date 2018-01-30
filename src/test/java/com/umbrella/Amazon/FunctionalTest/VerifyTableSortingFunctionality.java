package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.PageFactory.MagnetoBackend;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

/*This class verofies various Table Related functionalities
Note:: First Time This Will Sort Data in Ascending order and second Time will in Desecending Order
Table Sort and Search
Table Data Download
Website for this Test is :: http://www.seleniumeasy.com/test/table-sort-search-demo.html
Page Library Class is :: GenericWebSites*/
public class VerifyTableSortingFunctionality extends TestBase {

	private static final Logger log = LoggerHelper.getLogger(VerifyTableSortingFunctionality.class);
	Config config;
	GenericWebSites genericweb;

	@Test
	public void verifyTableSortandSearch() throws Exception {
		log.info(" Test VerifyTableSortandSearch Get Started ");
		config = new Config(OR);
		driver.get(config.getWebsite());
		genericweb = new GenericWebSites(driver);
		//genericweb.getTableDatainCoulmnPosition();
		String actualorder = genericweb.secondHeading();
		log.info("*********************Actual Oreder IS *********************" + actualorder );
		Assert.assertEquals(actualorder, "SortedOrder");
		log.info(" Test VerifyTableSortandSearch Get Down ");

	}

}
