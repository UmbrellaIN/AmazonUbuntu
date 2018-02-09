package com.umbrella.Amazon.PageFactory;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.tika.exception.TikaException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Wait;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.umbrella.Amazon.DataProviders.CSVExporter;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.generics.WaitHelper;

import com.umbrella.Amazon.testCore.TestBase;
import com.umbrella.Amazon.utilities.ApacheTikaTextExtraction;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;

public class GenericWebSites extends TestBase {

	WebDriver driver;
	String dirpathdownloads = "C:\\Users\\Acer\\Downloads";
	String extension = "pdf";
	private final Logger log = LoggerHelper.getLogger(GenericWebSites.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//div[@id='demo']//child::button")
	WebElement changecontentbutton;

	@FindBy(xpath = "html/body/table/tbody/tr[3]/td/div")
	WebElement textbeforeajaxcall;

	@FindBy(xpath = "html/body/table/tbody/tr[3]/td/button")
	WebElement clickonajaxbutton;

	@FindBy(xpath = "html/body/table/tbody/tr[3]/td/div")
	WebElement gettextafterajaxcall;

	public GenericWebSites(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, carasoul, new
		// Config(TestBase.OR).getExplicitWait());
	}

	public void changecontentbutton() {
		log.info("CLicking on Change Content Button");
		changecontentbutton.click();
	}

	public void gettextbeforeajaxcall() {

		log.info(
				"+++++++++++++++++++++++++++++++++++++++++++gettextbeforeajaxcall method++++++++++++++++++++++++++++++++++");
		log.info("++++++++++++++++++++++++Text before Ajax Call+++++++++++++++++++++++++++"
				+ textbeforeajaxcall.getText());
	}

	public void clickonajaxbutton() {
		log.info("Clicking on Ajax Button");
		clickonajaxbutton.click();
	}

	public void gettextafterajaxcall() {
		log.info("Getting text after AjaxCall");
		By newAjaxcontrol = By.xpath("html/body/table/tbody/tr[3]/td/div");
		Wait<WebDriver> newwait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		//newwait.until(ExpectedConditions.presenceOfElementLocated((newAjaxcontrol)));
		String textafterajaxcall = ((WebElement) newAjaxcontrol).getText();
		log.info("+++++++++++++textafterajaxcall++++++++" + textafterajaxcall);

	}

	public void getclickonsignInButton() throws Exception {
		log.info("Cliciking on SignIn Button");
		WebElement signin = getWebElement1("GoIbibo.homepage.signin", driver);
		signin.click();
		Thread.sleep(2000);
		driver.switchTo().frame("authiframe");
	}

	public List<WebElement> getTableDatainCoulmnPosition() {
		List<WebElement> data = driver.findElements(By.xpath("//table//tbody//tr//td[3]"));

		// for(int i=0 ; i<data.size();i++)
		// {
		// String cellvalue = data.get(i).getText();
		// //log.info("data val is " + cellvalue);
		// }
		return data;
	}

	public String secondHeading() {
		// This method has various LoopHoles
		// To OvercomeindexoutofboundExceptio I compare the String in try-catch
		// Block
		// My Assert always expecting "SortedOrder" as actual return by this
		// methos, so whwnever my method retuen
		// Descnding the system wittll stop exceuption and Test case Failed.

		String order = null;
		WebElement positionHeading = driver.findElement(By.xpath("//th[3]"));
		// First Time Click will sort the data in Ascending Order"
		positionHeading.click();
		for (int i = 0; i < getTableDatainCoulmnPosition().size(); i++) {

			log.info("//////Data Value in The Cell is /////////////////////////////////////// "
					+ getTableDatainCoulmnPosition().get(i).getText());
			try {
				if (getTableDatainCoulmnPosition().get(i).getText()
						.compareTo(getTableDatainCoulmnPosition().get(i + 1).getText()) <= 0) {
					order = "Ascending";
					log.info("Data is in  Order**********************" + order);
				} else {
					order = "Descensssding";
					log.info("Data is in Order***********************" + order);
					return order;
				}
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		return "SortedOrder";
	}

	public void searchbox(String text) {
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id='task-table-filter']"));
		SearchBox.sendKeys(text);
		SearchBox.sendKeys(Keys.ENTER);
	}

	public int getDatainStatusColumn() {
		List<String> data1 = new ArrayList<String>();
		List<WebElement> data = driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr//td[4]"));
		for (WebElement eles : data) {
			if (eles.isDisplayed() == true) {
				log.info("The Value in Cell is " + eles.getText());
				data1.add(eles.getText());
			}
			// log.info("The Visibilty of Element is " + eles.isDisplayed());
		}
		return data1.size();
	}

	public int NumberOForRowsSearch() {
		int count = 0;
		List<WebElement> data = driver.findElements(By.xpath("//table[@id='task-table']//tbody//tr//td[4]"));
		for (WebElement dals : data) {
			if (dals.isDisplayed() == true) {

				count++;
			} else {

			}
		}
		return count;
	}

	public void clickonPDF() {
		WebElement pdflink = driver.findElement(By.xpath("//div[@class='dt-buttons']//a[4]"));
		try {
			Thread.sleep(1000);
			pdflink.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getLastPDFFileDownloadedInFolder() {
		CSVExporter csv = new CSVExporter();
		File pdffile = csv.getTheNewestFile(dirpathdownloads, extension);
		String latestpdfname = pdffile.getName().toString();
		log.info("The Name of Latest PDF is " + latestpdfname);
		String path = dirpathdownloads + "\\" + latestpdfname;
		log.info("************************ The File PAth is *******************" + path);
		return latestpdfname;
	}

	public String getDataInPDFFile() {
		String testinPDF = null;
		ApacheTikaTextExtraction apache = new ApacheTikaTextExtraction();
		String filename = getLastPDFFileDownloadedInFolder();
		try {
			testinPDF = apache.dataINPDFAfterParsing(dirpathdownloads + "\\" + filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TikaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testinPDF;
	}

	public void clickonGetNewUser() {
		driver.findElement(By.xpath("//button[@id='save']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getUserDataImage() throws InterruptedException {
		WebElement imagelogo1 = driver.findElement(By.xpath("//div[@id='loading']//img"));

		log.info(" ******************I am taking Screen shot and Visibilty of Image is ***************"
				+ imagelogo1.isDisplayed());
		Thread.sleep(2000);
		Screenshot imagelogoscr1 = new AShot().takeScreenshot(driver, imagelogo1);

		Thread.sleep(2000);
		BufferedImage expectedimage = imagelogoscr1.getImage();// this is the //
																// actual
																// image//

		Thread.sleep(2000);
		return expectedimage;
	}

	public String getUserFirstName() {
		WebElement firstName = driver.findElement(By.xpath("//div[@id='loading']"));
		log.info("First Name of the User is " + firstName.getText().replaceAll("\n", " "));
		return firstName.getText().replaceAll("\n", " ");
	}

	public void clickonStartDownload() {
		WebElement downloadbutton = driver.findElement(By.xpath("//button[@id='downloadButton']"));
		downloadbutton.click();
	}

	public void getTextFromDialogBoxBeforeAwaitilty() {
		WebElement textdialogue = driver.findElement(By.cssSelector("div.progress-label"));
		log.info(" The Text from the Dialog Box is " + textdialogue.getText());
	}

	public void getTextFromDialogBoxAfterAwaitility() {
		// Wait for the download to complete - max 20 seconds
		WebElement textdialogue1 = driver.findElement(By.cssSelector("div.progress-label"));
		log.info(
				" The Text from the Dialog  After Clicking on Start Download Button Box is " + textdialogue1.getText());
		// Click+CTRL TO GET MORE FOCUS ON AWAIT CLASS APT*****WONDERFUL API FOR
		// ASYNCHRONIUS LIKE ANGULAR JS APPLICATION
		await("Download did not complete within 20 seconds").atMost(20, TimeUnit.SECONDS).until(textdialogue1::getText,
				is("Complete!"));
		// Did you notice? The robust wait statement is just an one-liner! It
		// looks neat and clean!
		System.out.println("DONE!!");
		WebElement textdialogue = driver.findElement(By.cssSelector("div.progress-label"));
		log.info(" The Text from the Dialog Box after Wait and Copmletion is " + textdialogue.getText());

	}

	public void getTextPercentagebeforeClick() {
		WebElement percentage = driver.findElement(By.xpath("//div[@class='percenttext']"));
		String percentaetext = percentage.getText();
		log.info("The Percentage Before Click is " + percentaetext);
		driver.findElement(By.xpath("//button[@id='cricle-btn']")).click();
		try {
			await("Download did not complete within 20 seconds").atMost(60, TimeUnit.SECONDS).until(percentage::getText,
					is("100%"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebElement percentage1 = driver.findElement(By.xpath("//div[@class='percenttext']"));
		String percentaetext1 = percentage1.getText();
		log.info("The Percentage After Click is " + percentaetext1);
	}

	public void dragAndDrop() {
		// http://demo.guru99.com/test/drag_drop.html
		Actions action = new Actions(driver);
		WebElement sourceelement = driver.findElement(By.xpath("//div[@id='products']//li[2]"));
		WebElement destinationElement = driver.findElement(By.xpath("//ol[@id='amt7']"));
		action.dragAndDrop(sourceelement, destinationElement).build().perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dragAndDropTrail2() {
		// http://www.seleniumeasy.com/test/drag-and-drop-demo.html
		Actions builder = new Actions(driver);
		try {
			WebElement sourceelement = driver.findElement(By.xpath("//div[@id='todrag']//span[1]"));
			log.info("**************Visibilty of the Element is ****************** " + sourceelement.isDisplayed());
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			WebElement destinationElement = driver.findElement(By.xpath("//div[@id='mydropzone']"));
			log.info(
					"**************Visibilty of the Element is ****************** " + destinationElement.isDisplayed());
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			Action dragAndDrop = builder.clickAndHold(sourceelement).moveToElement(destinationElement)
					.release(destinationElement).build();
			log.info("**************PERFORMING DRAG AND DROP ****************** ");
			dragAndDrop.perform();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void elementsInFirstListBox() {
		List<WebElement> numberoflementisListOne = driver
				.findElements(By.xpath("html/body/div[2]/div/div[2]/div/div[1]/div/ul/li"));
		log.info(" Number of Element in List One " + numberoflementisListOne.size());
		log.info(" Clicking on the first Link " + numberoflementisListOne.get(0).getText());
		numberoflementisListOne.get(0).click();
		WebElement rightclick = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div[2]/button[2]"));
		// driver.manage().timeouts().implicitlyWait(200000,
		// TimeUnit.MILLISECONDS);
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(5000, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		//wait.until(ExpectedConditions.elementToBeClickable(rightclick));
		rightclick.click();

		log.info(" Number of Items in Second List after Ist click is " + elementsInSecondListBox());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int elementsInSecondListBox() {
		List<WebElement> numberoflementisSeconfListOne = driver
				.findElements(By.xpath("html/body/div[2]/div/div[2]/div/div[3]/div/ul/li"));
		log.info(" Number of Element in List One " + numberoflementisSeconfListOne.size());
		return numberoflementisSeconfListOne.size();
	}

	public void jQueryListOne() {
		List<WebElement> options = driver
				.findElements(By.xpath("//div[@id='pickList']//child::div//child::div[1]//select//option"));
		log.info("Getting Option Sixe in the List " + options.size());
		for (int i = 0; i < options.size(); i++) {
			log.info("Option Value is " + options.get(i).getText());
			options.get(i).click();
			WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(5000, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			//wait.until(ExpectedConditions.elementToBeClickable(addButton));
			addButton.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("Number of Items in The second List " + jQueryListSecond());
		}
	}

	public int jQueryListSecond() {
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='pickList']//div//div[3]//select//option"));
		// log.info("Getting Option Sixe in the List " + options.size());
		// for (int i = 0; i < options.size(); i++) {
		// log.info("Option Value In second List is " +
		// options.get(i).getText());
		// }
		return options.size();
	}

	public String verifyDataListFilter(String nameToBETest) throws InterruptedException {
		WebElement searchTextBox = driver.findElement(By.xpath("//input[@type='search']"));
		// List<WebElement> names = driver
		// .findElements(By.xpath("//div[@class='info-block block-info
		// clearfix']//div//following-sibling::h4"));
		// for (WebElement eles : names) {

		// log.info("Namems of the Persons are " + eles.getText());
		try {
			// for(int j=0 ;j <names.size();j++)
			// {
			// String[] split = eles.getText().split(":");
			// String firstText = split[0];
			// String seconText = split[1];
			//
			// log.info(" First Text is " + firstText);
			// log.info("Second Text is " + seconText);
			log.info(" ****************** I am getting name from the data provider ****************" + nameToBETest);
			searchTextBox.sendKeys(nameToBETest);
			Thread.sleep(2000);
			List<WebElement> elemetsAfterSearch = driver
					.findElements(By.xpath("//div[@class='info-block block-info clearfix']//div"));
			// log.info(" Numer of items In The Tablea after performing Search
			// is " + elemetsAfterSearch.size());

			List<WebElement> namesInSearch = null;
			if (elemetsAfterSearch.size() > 1)
				namesInSearch = driver.findElements(By.xpath(
						"//div[@class='info-block block-info clearfix']//child::div[1]//following-sibling::h4[1]"));
			String name = namesInSearch.get(0).getText();
			if (name.contains(nameToBETest)) {
				log.info(" There is No Matching Record found ");
				searchTextBox.clear();
				searchTextBox.sendKeys(Keys.ENTER);
				Thread.sleep(5000);
			} else if (name.contains("")) {
				log.info("There is No Matching Record found ");
				searchTextBox.clear();
				searchTextBox.sendKeys(Keys.ENTER);
			} else {
				return "Fail ";
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "Pass";

	}

	private boolean verifyChart1(String fileName, WebElement element) {

		log.info(" I am called fron Test Method on Generic with filename  " + fileName);
		Path path = Paths.get(fileName);
		try {
			OcularResult result = Ocular.snapshot().from(path).sample().using(driver).element(element).compare();
			return result.isEqualsImages();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public void findChartOnThePage() {

		String snapShotPath = System.getProperty("user.dir") + "/Path/BarGraphChart.png";
		try {
			WebElement image = driver.findElement(By.xpath("//img[@alt='Column Chart in Excel']"));
			log.info(" Visbility of the Image is " + image.isDisplayed());
			log.info("************** I M Startinfg Comparing **************************************");
			boolean resultofthis = verifyChart1(snapShotPath, image);
			log.info(" ***************Result of the findChartOnThePage********************* " + resultofthis);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// boolean resultofthis = verifyChart1(snapShotPath, image);
	}

	public void OcularConfig() {
		log.info(" Starting Config Ocular");
		String resultPath = System.getProperty("user.dir") + "/Path";
		String snapShotPath = System.getProperty("user.dir") + "/Path";
		Path resultPath1 = Paths.get(resultPath);
		Path snapShotPath1 = Paths.get(snapShotPath);
		Ocular.config().resultPath(resultPath1).snapshotPath(snapShotPath1).globalSimilarity(50).saveSnapshot(false);
		log.info(" Stoping Config Ocular");

	}

	public void youTubeSearchButton() {
		WebElement youTubeSearch = driver.findElement(By.xpath("//input[@id='search']"));
		youTubeSearch.sendKeys("raspberry pi 3");
		youTubeSearch.sendKeys(Keys.ENTER);

	}

	public void getFirstVideo() {
		

	}

}
