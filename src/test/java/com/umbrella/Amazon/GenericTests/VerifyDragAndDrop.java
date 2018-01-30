package com.umbrella.Amazon.GenericTests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.umbrella.Amazon.PageFactory.GenericWebSites;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class VerifyDragAndDrop extends TestBase {

	Config config;
	GenericWebSites generic;
	private static final Logger log = LoggerHelper.getLogger(VerifyDragAndDrop.class);

	/*
	 * 'Verify that the drag and drop action is performed successfully by
	 * checking the innerHTML of the destination element for the draggable
	 * image.' we illustrate the drag and drop functionality of the web
	 * application through Action methods in Webdriver:
	 * dragAndDrop(Sourcelocator, Destinationlocator)
	 * dragAndDropBy(Sourcelocator, x-axis pixel of Destinationlocator, y-axis
	 * pixel of Destinationlocator) 
	 * //Using Action class for drag and drop.
	 * Actions act=new Actions(driver);
	 * //Dragged and dropped. 
	 * act.dragAndDrop(From, To).build().perform();
	 */ @Test
	public void verifyDragAndDrop() {
		// http://www.seleniumeasy.com/test/drag-and-drop-demo.html
		log.info(VerifyDragAndDrop.class.getName() + " Method verifyDragAndDrop " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);
		//generic.dragAndDrop();
		generic.dragAndDropTrail2();

	}

	@Test
	public void verifyDragAndDropSliders() {
		// http://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html
		log.info(VerifyDragAndDrop.class.getName() + " Method verifyDragAndDropSliders " + " Get Started");
		config = new Config(OR);
		driver.get(config.getWebsite());
		generic = new GenericWebSites(driver);

	}

}
