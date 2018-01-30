package com.umbrella.Amazon.GenericTests;

import java.awt.image.BufferedImage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

/*Ussage of this Dynamic Data Loading is various Website Lke Amazon
We can see various images and products withput loading the
page. USed Java Script or AjaX
Used DataBase Connection to get the number of Iteration for this
Website for this Test is :: http://www.seleniumeasy.com/test/dynamic-data-loading-demo.html
Page Library Class is :: GenericWebSites
*/
public class VerifyDynamicData extends TestBase {

	private static final Logger log = LoggerHelper.getLogger(VerifyDynamicData.class);
	Config config;
	GenericWebSites generic;

	@Test
	public void verifyDynamicData() throws InterruptedException {
		log.info(VerifyDynamicData.class.getName() + "*******Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
        //Click + ctrl to get More Info On ImagesDiffer Class.
		ImageDiffer imgdiff = new ImageDiffer();
		generic.clickonGetNewUser();

		Thread.sleep(3000);

		// Get the data for firsy request
		String datafirstuser = generic.getUserFirstName();
		BufferedImage imageBeforeClick = generic.getUserDataImage();
		// Get the data for second request
        Thread.sleep(5000);
		// Clicking on NextUser
		generic.clickonGetNewUser();
		Thread.sleep(7000);
		String datanext = generic.getUserFirstName();
		BufferedImage imageAfterClick = generic.getUserDataImage();

		// Compare the data for both thr request
		Assert.assertTrue(datafirstuser.compareTo(datanext) != 0);
		
		Thread.sleep(5000);
		ImageDiff diff = imgdiff.makeDiff(imageBeforeClick, imageAfterClick);
      	Assert.assertTrue(diff.hasDiff(), "Images are same");

	}

}
