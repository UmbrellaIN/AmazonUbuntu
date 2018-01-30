package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.AmazonHomePage;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

/*This class verofies various Table Related functionalities
Pagination=https://www.amazon.in/b/ref=gbph_ftr_m-3_1cb7_page_6?node=3474656031&ajr=0&gb_f_first=enforcedCategories:3474656031,dealStates:AVAILABLE%252CWAITLIST%252CWAITLISTFULL%252CUPCOMING,page:6,sortOrder:BY_SCORE,dealsPerPage:5&pf_rd_p=c53b9893-31ba-424d-ad05-6a3eaccc1cb7&pf_rd_s=merchandised-search-3&pf_rd_t=101&pf_rd_i=3474656031&pf_rd_m=A1VBAL9TL5WCBF&pf_rd_r=V1KPJNE0RAB705WDS80Y&ie=UTF8
What is pagination?
If you have a form which allows the user to browse through the rows in a database table, what do you do if that table has hundreds or even thousands of rows? 
It would not be a good idea to show all those 
rows in a single form, instead you should split the database output into more manageable chunks or 'pages'. There are two things you must do:
Decide on the maximum number of database rows that can be included in each page. You may hard code this value, or (my preferred method) you can define it in a 
variable so that the value may be changed at runtime.
You then need to inform the user that other 'pages' are available and provide a mechanism whereby the user is able to select a different 'page' of details. 
I currently use a set of hyperlinks in a separate pagination area which looks like this:
Pagination Area
dialog-types-pagination (1K)
*/


public class VerifyTablePagination extends TestBase {
	
	private static final Logger log  = LoggerHelper.getLogger(VerifyTablePagination.class);
	Config config;
	AmazonHomePage amazon;
		
	@Test
	public void verifyTablePagination() throws Exception
	{
		log.info(" Test verifyTablePagination Get Started " );
		config = new Config(OR);
	    driver.get(config.getWebsite());
	    amazon = new AmazonHomePage(driver);
	  //  amazon.getnumberofitemsonAirconditionpages();
	    //amazon.checkpaginationexist();
	    int actaualpages = amazon.lastpagennumber();
	    Assert.assertTrue(actaualpages >1);
	    if(actaualpages>1)
	    {
	    	log.info("Pagination Exist");
	    }
	    amazon.clickonpreviouspagelinkonfirstpage();
	    for (int i =0 ;i< actaualpages;i++)
	    {
	    amazon.clickonnextpagelink();
	    Thread.sleep(3000);
	  //  amazon.waitForJSandJQueryToLoad();
	    amazon.getnumberofitemsonAirconditionEachPageExceptFirstPage();
	    }
	    Thread.sleep(2000);
		log.info(" Test verifyTablePagination Get Down " );
		
        
	}	

}
