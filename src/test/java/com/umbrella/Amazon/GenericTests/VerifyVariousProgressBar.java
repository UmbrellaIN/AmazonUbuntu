package com.umbrella.Amazon.GenericTests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;
/*Go to the test page
Start the progress bar
While the progress bar is not cpmpleted, wait for it to compete
When the progress bar is completes, check it and take screenshot*/

public class VerifyVariousProgressBar  extends TestBase{
	
	Config config;
	GenericWebSites generic;
	private static final Logger log = LoggerHelper.getLogger(VefifyVariousModalsAndAlert.class);
	
	@Test
	public void vefifyJqueryProgressBar()
	{
		log.info(VerifyVariousProgressBar.class.getName() + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		generic.clickonStartDownload();
		generic.getTextFromDialogBoxAfterAwaitility();
	}
	
	@Test
	public void verfiyBootStarpProgressBar()
	{
		//http://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html
		log.info(VerifyVariousProgressBar.class.getName() + "Method verfiyBootStarpProgressBar " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		generic.getTextPercentagebeforeClick();
	}
	
	@Test
	public void verfiyBootStarpProgressBar1()
	{
		log.info(VerifyVariousProgressBar.class.getName() + "Method verfiyBootStarpProgressBar1 " + " Get Started");
	}

}
