package com.umbrella.Amazon.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderHelper {

	/**
	 * A convenience method that performs click-and-hold at the location of the
	 * source element, moves by a given offset, then releases the mouse.
	 * 
	 * @param slider
	 *            webElement
	 * @param xOffset
	 *            - horizontal move offset. Positive value means moving to the
	 *            right, negative - to the left
	 * @param yOffset
	 *            - vertical move offset. Positive value means moving up,
	 *            negative - down
	 * @throws Exception
	 */
	public void dragSlider(WebElement slider, int xOffset, int yOffset, WebDriver driver) throws Exception {
		Actions moveSlider = new Actions(driver);
		Action action = moveSlider.clickAndHold(slider).moveByOffset(xOffset, yOffset).release().build();
		action.perform();
		Thread.sleep(500);
	}

	/**
	 * @param element
	 *            webElement
	 * @param xOffset
	 *            - horizontal move offset. Positive value means moving to the
	 *            right, negative - to the left
	 * @param yOffset
	 *            - vertical move offset. Positive value means moving up,
	 *            negative - down
	 * @throws Exception
	 */
	public void dragAndDrop2(WebElement element, int xOffset, int yOffset, WebDriver driver) throws Exception {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.dragAndDropBy(element, xOffset, yOffset).build();
		dragAndDrop.perform();
	}

}
