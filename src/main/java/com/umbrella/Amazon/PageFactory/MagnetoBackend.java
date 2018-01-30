package com.umbrella.Amazon.PageFactory;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.umbrella.Amazon.DataProviders.CSVExporter;
import com.umbrella.Amazon.FunctionalTest.VerifyentriesinExportedCSVfile;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.TestBase;

public class MagnetoBackend extends TestBase {

	WebDriver driver;
	String dirpathdownloads = "C:\\Users\\Acer\\Downloads";
	String extension = "csv";
	CSVExporter csv;
	private final Logger log = LoggerHelper.getLogger(VerifyentriesinExportedCSVfile.class);

	public MagnetoBackend(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String UserName) {
		log.info("Entering User Name");
		try {
			WebElement username = getWebElement1("magneto.homepage.usernametextbox", driver);
			username.sendKeys(UserName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enterPassword(String Password) {
		log.info("Entering Password ");
		try {
			WebElement username = getWebElement1("magneto.homepage.passwordtextbox", driver);
			username.sendKeys(Password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickonsubmit() {
		log.info("Clecking on submit button");
		try {
			WebElement submit = getWebElement1("magneto.homepage.submitbutton", driver);
			submit.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void handlingPopUp() {
		Set<String> allwindowsopend = driver.getWindowHandles();
		Iterator<String> iterator = allwindowsopend.iterator();
		String subWindowHandler = null;
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		try {
			WebElement popupcloser = getWebElement1("magneto.userpage.popupcloser", driver);
			popupcloser.click();
			// driver.findElement(By.xpath("//a[@title='close']")).click();
		} catch (Exception e) {
			System.out.println("IM RAISING AN EXCEPTION");
			e.printStackTrace();
		}
	}

	public int NumberOfRecordsonPage() throws Exception {
		log.info("Getting number of Records ");
		WebElement numberof = getWebElement1("magneto.userpage.findrecords", driver);
		String count = numberof.getAttribute("textContent");
		log.info("*****************Number of reords on page***************** " + count);
		int expected = Integer.parseInt(count);
		return expected;
	}

	public void clickonExportCSV() {
		log.info("Clicking on Export CSV button");
		try {
			WebElement export = getWebElement1("magneto.userpage.export", driver);
			export.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getCountFromFile() {
		csv = new CSVExporter();
		File latestfile = csv.getTheNewestFile(dirpathdownloads, extension);
		String csvfilename = latestfile.getName().toString();
		System.out.println("CSV File Downloaded is :- " + csvfilename);
		int actualcount = csv.getRecordsCountInCSV(dirpathdownloads, csvfilename);
		log.info("*****************Number of reords on File***************** " + actualcount);

		return actualcount;
	}

	public void clickoninvoices() {
		log.info("Clicking On Invoices");
		try {
			WebElement mousehoveronsales = getWebElement1("magneto.userpage.salesmousehover", driver);
			Actions action = new Actions(driver);
			action.moveToElement(mousehoveronsales).build().perform();
			WebElement salesinvoice = getWebElement1("magneto.userpage.invoice", driver);
			salesinvoice.click();
		} catch (Exception e) {
			System.out.println("**************I m in clicvk on invoice Exception Part********************");
			e.printStackTrace();
		}
	}

	public void clickonDate() throws Exception {
		try {
			log.info("Clicking on Date in Asending order");
			WebElement invoicedate = getWebElement1("magneto.userpage.invoicedate", driver);
			invoicedate.click();
		} catch (Exception e) {
			System.out.println("*****************I m in clickONDATE on invoice Exception Part****************");
			e.printStackTrace();
		}
	}

	public void noofcolrows() {
		log.info("table/thead/tr/th is for cloumn");
		List<WebElement> Noofcols = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("No of cols:" + Noofcols.size());
	}

	public boolean verifydatesareinascendingorder() throws ParseException {
		Date dateone = null;
		ArrayList<Date> dates = new ArrayList<Date>();

		log.info("/table/tbody/tr is for cloumn");
		List<WebElement> NoofRows = driver
				.findElements(By.xpath("//*[@class='hor-scroll']//child::tbody//child::tr//child::td[3]"));
		System.out.println("No of Rows are :" + NoofRows.size());
		for (WebElement elements : NoofRows) {
			// System.out.println("***********Dates Are*****************"
			// +elements.getText());
			String date = elements.getText();

			DateFormat df = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa");
			// DateFormat outputformat = new SimpleDateFormat("MM-dd-yyyy
			// HH:mm:ss");
			dateone = df.parse(date);
			dates.add(dateone);

		}
		// System.out.println("***********I m getting FIRST
		// DATE*****************" + dates.get(1));
		/*
		 * The code below shows a true and false case. If date2 is after date1,
		 * after returns true. If it is not, after returns false.
		 */
		for (int i = 0; i < dates.size() - 1; i++) {
			if (dates.get(i + 1).after(dates.get(i))) {
				return true;
			}
		}
		return false;
	}

	public void customerAccountInformation() {
		try {
			getWebElement1("magneto.userpage.clickonfirstcustomer", driver).click();
			Thread.sleep(3000);
			getWebElement1("magneto.userpage.accountinformation", driver).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String cheekelementReadOnly() {

		WebElement some_element1 = driver.findElement(By.xpath(
				"html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[3]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/select"));
		String readonly = some_element1.getAttribute("disabled");
		System.out.println(
				"I am Getting Value check DISABLED Elemenet 66666666666666666666666666666666666666++++++++++++++++++"
						+ readonly);
		return readonly;

		// WebElement some_element =
		// driver.findElement(By.xpath("html/body/div[1]/div[4]/div/div/div[2]/div/div[3]/form/div[3]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/select"));
		// String readonly = some_element.getAttribute("readonly");
		// System.out.println("I am Getting Value check READONLY Elemenet
		// 66666666666666666666666666666666666666++++++++++++++++++"+ readonly);
		//
	}

	public String cheekelementPrefixReadOnly() {

		WebElement some_element1 = null;
		try {
			some_element1 = getWebElement1("magneto.userpage.Prefix", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String readonly = some_element1.getAttribute("disabled");
		System.out.println(
				"I am Getting Value check DISABLED Elemenet 66666666666666666666666666666666666666++++++++++++++++++"
						+ readonly);
		return readonly;
	}

	public void gettable() {
		WebElement table = driver.findElement(By.xpath("//table[@class='data']"));
		log.info("Table Name is "+ table);
	}

	public void getDataInTable() {
		log.info("I m starting getnumberofrows mthod");
		// int count = 0;
		try {
			log.info("Calling Method entersearchbutton from getNumberOfRowsMethod");
			entersearchbutton("test");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='data']//child::tbody//tr"));
		log.info("The number of Rows are " + rows.size());
		for (int row = 0; row < rows.size(); row++) {
			// For each row find number of columns to ietrate through loop
			log.info("/////////////////************************The Value for Row number" + row
					+ "******************////////////////////////// ");

			List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));
			for (int j = 0; j < columns.size(); j++)// loop to iterate through
													// each cell of each row and
													// get text of cell.
			{

				String text = columns.get(j).getText();
				log.info("***********The Value for Column number" + j + "****************** ");
				log.info("The Text for  Data Cell Value is " + text);

			}

		}
	}

	public int getNumberOfRowsinTable() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='data']//child::tbody//tr"));
		// log.info("The number of Rows are " + rows.size());
		return rows.size();
	}

	public List<String> getDataInCellTwo() {
		List<String> names = new ArrayList<String>();
		log.info("I am Starting getDatainCellTwo Method");
		if(getNumberOfRowsinTable()>1)
		{
		for (int i = 0; i < getNumberOfRowsinTable(); i++) {
			WebElement rows = driver
					.findElement(By.xpath("//table[@class='data']//child::tbody//tr[" + (i + 1) + "]//td[3]"));
			log.info("The Data in Second Column is " + rows.getText());
			names.add(rows.getText());
		}
		}
		else
		{
			log.info(" ======================= NO MATCHING RECORD IS PRESENT==============================");
		}
		for (String nams : names) {
			if (nams.toLowerCase().contains("test")) {
				// log.info("Test Cases Pass");
			} else {
				// log.info("Test Cases Fail");
			}
		}
		return names;
	}

	public void entersearchbutton(String txttosearch) throws InterruptedException {
		WebElement name = driver.findElement(By.id("customerGrid_filter_name"));
		name.sendKeys(txttosearch);
		name.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}
	
	public void checkAlphabeticalOrder()
	{
		List<String> dataitems = getDataInCellTwo();
		for(int i=0 ; i<dataitems.size();i++)
		{
			if(dataitems.get(i+1).compareTo(dataitems.get(i))>0)
			{
				System.out.println("S1 is Greater Than S2");
			}
			else if(dataitems.get(i+1).compareTo(dataitems.get(i))<0)
			{
				System.out.println("S1 is Less Than S2");
			}
			else
			{
				System.out.println("S1 and S2 are equal");
			}
		}
	}


}
