package com.umbrella.Amazon.GuiTests;

import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.testautomationguru.ocular.Ocular;
import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

/*Visual Validation is a process of validating the visual aspects of an application’s user interface –
Verifying each element in the application is appearing exactly in the same size, color, shape etc.
TestAutomationGuru has come up with its own library, Ocular, for your selenium WebDriver test automation 
frameworks which could solve most of these challenges. It is FREE & Open Source!
http://www.testautomationguru.com/ocular-automated-visual-validation-for-selenium-webdriver-test-automation-frameworks/s
*/
public class VerifyChartAndGraphs extends TestBase{
	
	String resultPath = System.getProperty("user.dir") + "/Path" ;
	String snapShotPath = System.getProperty("user.dir") + "/Path" ;

	Config config ;
	GenericWebSites generic;
	
	private static final Logger  log= LoggerHelper.getLogger(VerifyChartAndGraphs.class);
	
	
	@Test
	public void verifyChartOne() {
		// http://www.excel-easy.com/data-analysis/charts.html
		log.info(VerifyChartAndGraphs.class.getName() + " Method verifyChartOne " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		generic.OcularConfig();
		generic.findChartOnThePage();
	}
	
	@Test
	public void verifyChartTwo() {
		// http://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html
		log.info(VerifyChartAndGraphs.class.getName() + " Method verifyChartTwo " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		
	}
	
	@Test
	public void verifyChartThree() {
		// http://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html
		log.info(VerifyChartAndGraphs.class.getName() + " Method verifyChartThree " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
	}
	

}
