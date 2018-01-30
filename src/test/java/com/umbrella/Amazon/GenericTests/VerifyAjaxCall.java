package com.umbrella.Amazon.GenericTests;

import org.apache.log4j.Logger;
import 	org.testng.annotations.Test;

import com.umbrella.Amazon.FunctionalTest.VerifyAutoSuggestions;
import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

/*So far, you’ve seen six different strategies to work with the AJAX controls using Selenium Webdriver.
In most of these methods, we’ve used various types of waits to handle the AJAX calls.
WebSite Used :: http://www.webscantest.com/bjax/
Thread.sleep()
Implicit Wait
Explicit Wait
Fluent Wait
WebdriverWait
==================================================
Test Case Description:
Open the demo AJAX application demo website.
Following AJAX controls would appear in an IFRAME.
A demo paragraph element which contains some default text.
A simple button control to make the AJAX calls.
When you click the button control, the AJAX call takes place.
The default text disappears from the screen.
Two new paragraphs get displayed on the screen.
You now need to validate the two conditions.
The new text in the first paragraph shouldn’t match the default text.
The text in the second paragraph should match the expected value.
===================================================
AJAX is an advance communication technique used by Web applications to 
exchange the data from the server without affecting the state of the currently opened web page.
Based on some input if our output changed
*/
public class VerifyAjaxCall extends TestBase {
	
	Config config;
	GenericWebSites genericWebSites;
	private final Logger log = LoggerHelper.getLogger(VerifyAutoSuggestions.class);
	
	@Test
	public void verifyAjaxCall() throws InterruptedException{
		log.info("This test is for verifyAjaxCall");
		log.info(VerifyAjaxCall.class.getName()+"Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		genericWebSites = new GenericWebSites(driver);
		genericWebSites.gettextbeforeajaxcall();
	//	String beforeajaxcall = " The data from the server will go here...";
		genericWebSites.clickonajaxbutton();
		//Thread.sleep(3000);
		genericWebSites.gettextafterajaxcall();
		
	}

}
