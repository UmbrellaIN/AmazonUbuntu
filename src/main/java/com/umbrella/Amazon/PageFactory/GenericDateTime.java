package com.umbrella.Amazon.PageFactory;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.generics.WaitHelper;
import com.umbrella.Amazon.testCore.TestBase;

/*
 * **This class is for handling various types of Date and Time Picker
Website Used :: https://demos.telerik.com/kendo-ui/datetimepicker/index
****
*/
public class GenericDateTime extends TestBase {

	WaitHelper waitHelper;
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(GenericDateTime.class);

	// DAte and Time to be set in textbox
	String dateTime = "12/07/2018 2:00 PM";

	// button to open calendar
	@FindBy(xpath = "//span[@class='k-icon k-i-calendar']")
	WebElement datebutton;

	// button to move next in calendar
	@FindBy(xpath = "//a[@aria-label='Next']")
	WebElement movenxt;

	// button to click in center of calendar header
	@FindBy(xpath = "//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]")
	WebElement centerbutton;

	// button to move previous month in calendar
	@FindBy(xpath = "//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]")
	WebElement previousbutton;

	public GenericDateTime(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void clickoncalendarbutton() throws InterruptedException {
		log.info("Clicking on Calendar Button");
		datebutton.click();
		Thread.sleep(2000);
		movenxt.click();
		Thread.sleep(2000);
		previousbutton.click();
		Thread.sleep(2000);
		centerbutton.click();

		// Split the date time to get only the date part
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
		// get the year difference between current year and year to set in
		// calander
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		{
			if (yearDiff != 0) {
				// if you have to move next year
				if (yearDiff > 0) {
					for (int i = 0; i < yearDiff; i++) {
						System.out.println("Year Diff->" + i);
						movenxt.click();
					}
				}
				// if you have to move previous year
				else if (yearDiff < 0) {
					for (int i = 0; i < (yearDiff * (-1)); i++) {
						System.out.println("Year Diff->" + i);
						previousbutton.click();
					}
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Get all months from calendar to select correct one
			List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath(
					"//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
			list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// get all dates from calendar to select correct one
			List<WebElement> list_AllDateToBook = driver.findElements(By.xpath(
					"//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
			list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();
			/// FOR TIME
			WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));
			// click time picker button
			selectTime.click();
			// get list of times
			List<WebElement> allTime = driver.findElements(
					By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
			dateTime = dateTime.split(" ")[1] + " " + dateTime.split(" ")[2];
			// select correct time
			for (WebElement webElement : allTime) {
				if (webElement.getText().equalsIgnoreCase(dateTime)) {
					webElement.click();
				}
			}
		}
	}
}