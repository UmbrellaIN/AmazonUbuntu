
package com.umbrella.Amazon.GenericTests;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.umbrella.Amazon.DataProviders.Ecxel_API;
import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

import org.testng.Assert;


public class VerifyVariousListBox extends TestBase{
	
	Config config;
	GenericWebSites generic;
	String xlFilePath = "D:\\loginsheet.xlsx";
	String sheetName = "names";
	Ecxel_API eat ;
	private static final Logger log = LoggerHelper.getLogger(VerifyDragAndDrop.class);

	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		eat = new Ecxel_API(xlFilePath);
		Object[][] data = eat.testDataexcel(xlFilePath, sheetName);
	    return data;
	}
	
	@Test
	public void verifyBootStrapListBox() {
		// http://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html
		log.info(VerifyVariousListBox.class.getName() + " Method verifyDragAndDrop " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		generic.elementsInFirstListBox();
	}
	
	@Test
	public void verifyJQueryListBox() {
		// http://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html
		log.info(VerifyVariousListBox.class.getName() + " Method verifyJQueryListBox " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		generic.jQueryListOne();
	
	}
	
	@Test(dataProvider = "userData" )
	public void verifyDataListFilter(String dataFromExcel) throws InterruptedException {
		// http://www.seleniumeasy.com/test/data-list-filter-demo.htmls
		log.info(VerifyVariousListBox.class.getName() + " Method verifyDataListFilter " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		String actualresult = generic.verifyDataListFilter(dataFromExcel);
		log.info("Actual Result returned By the Method is  and I am Verifying Test" +actualresult);
		Assert.assertEquals("Pass", actualresult);
		
	}
}
