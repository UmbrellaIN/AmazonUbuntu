package com.umbrella.Amazon.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.generics.WaitHelper;
import com.umbrella.Amazon.testCore.TestBase;
import com.umbrella.Amazon.utilities.BrokenLinksAndImages;

public class AmazonHomePage extends TestBase {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(AmazonHomePage.class);
	WaitHelper waitHelper;
	BrokenLinksAndImages bli;

	ArrayList<String> list2 = new ArrayList<String>();

	@FindBy(className = "cropped-image-map-center-alignment")
	WebElement carasoul;

	@FindBy(xpath = "//div[@id='desktop-1']//child::div//child::div[2]//child::div//child::li")
	WebElement carasouldesktop1;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, carasoul, new
		// Config(TestBase.OR).getExplicitWait());
	}

	public int brokenImagetest() {
		int invalidImageCount = 0;
		bli = new BrokenLinksAndImages();
		try {
			log.info("Storing All the Images ");
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			log.info("Total no. of images are " + imagesList.size());
			// System.out.println("Total no. of images are " +
			// imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					bli.verifyimageActive(imgElement);

				}
			}
			log.info("Total no. of invalid images are " + invalidImageCount);
			// System.out.println("Total no. of invalid images are " +
			// invalidImageCount);
			// return invalidImageCount;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return invalidImageCount;

	}

	public int linksActive() throws IOException {
		int countInvalid = 0;

		bli = new BrokenLinksAndImages();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(
				"************************No of links without images +++++++++++++++++++++++++++++++++" + links.size());
		Iterator<WebElement> itr = links.iterator();
		while (itr.hasNext()) {
			String url = itr.next().getAttribute("href");
			int Invalid = bli.verifyLinkActive(url);
			// System.out.println("******************+++++++++++++++i m getting
			// vaid value as and adding ++++++++++++++++++++++++++++++++++++
			// **************************:" + Invalid );

			countInvalid = countInvalid + Invalid;

		}
		// System.out.println("******************+++++++++++++++TOTAL NUMBER OF
		// InVALID LINKS ++++++++++++++++++++++++++++++++++++
		// **************************:" + countInvalid );
		return countInvalid;
	}

	public int numberofimageincarsoul() throws Exception {
		log.info("Finding Number of Images in Carasoul");
		List<WebElement> noofimages = getWebElements("amazon.homepage.carasoul", driver);
		int noofimagesincarasoul = noofimages.size();
		log.info("Returning No of Images" + noofimagesincarasoul);
		return noofimagesincarasoul;
	}

	public ArrayList<String> getitemsincarasoulbeforeclick() throws InterruptedException {
		ArrayList<String> list1 = new ArrayList<String>();
		log.info("method getitemsincarasoulbeforeclick Started");
		try {
			List<WebElement> elements = getWebElements1("amazon.homepage.desktopid1", driver);
			for (WebElement element : elements) {
				if (element.isDisplayed() == true) {
					list1.add(element.getText());
					System.out.println(
							"+++++++++++++I m Priniting Names is List 1 ++++++++++++++++++++" + element.getText());

				} else {
					// System.out.println("I m getting Mull Value");
				}
			}

		} catch (Exception e) {
			// System.out.println("********************I m Raising exception
			// getitemsincarasoulbeforeclick*******************");
			e.printStackTrace();
		}
		log.info("Returning First List of Items");
		return list1;
	}

	public void clickonnextincarasoul() {
		try {
			log.info("Clicking on rightcarasoul");
			WebElement element = getWebElement1("amazon.homepage.rightclickonfirstcarasoul", driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			// System.out.println("********************I m Raising exception
			// clickonnextincarasoul*******************");

			e.printStackTrace();
		}
	}

	public ArrayList<String> getitemsincarasoulafterclick() throws Exception {
		log.info("method getitemsincarasoulafterclick Started");
		try {
			List<WebElement> elements = getWebElements1("amazon.homepage.desktopid1", driver);

			for (WebElement elemens : elements) {
				if (elemens.isDisplayed() == false) {

				} else {
					list2.add(elemens.getText());
					System.out.println(
							"+++++++++++++I m Priniting Names is List 2 ++++++++++++++++++++" + elemens.getText());
				}
			}
		} catch (Exception e) {
			// System.out.println("********************I m Raising exception
			// getitemsincarasoulafterclick*******************");

			e.printStackTrace();
		}
		log.info("Returning Second List of Items");
		return list2;
	}

	public void enterintosearchbox(String stringtofind) {
		WebElement searchboxtextarea = null;
		try {
			searchboxtextarea = getWebElement1("amazon.homepage.searchbox", driver);
			log.info("Entering in to Search BOX");
			searchboxtextarea.sendKeys(stringtofind);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Raising an Exception ==== enterintosearchbox");
			e.printStackTrace();
		}

	}

	public ArrayList<String> autosuggestions() throws Exception {
		ArrayList<String> suggestionlist = new ArrayList<String>();
		List<WebElement> elements = getWebElements1("amazon.homepage.searchboxsuggestions", driver);
		for (WebElement elems : elements) {
			log.info("Suggestion are" + elems.getAttribute("data-keyword"));
			suggestionlist.add(elems.getAttribute("data-keyword"));
		}
		log.info("Number of AutoSuugestion Are " + elements.size());
		return suggestionlist;
	}

	public void clickOnSearchButton() {
		try {
			getWebElement1("amazon.homepage.clickonsearch", driver).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Raising an Exception ==== clickOnSearchButton");
			e.printStackTrace();
		}
	}

	public String geterrormsg() {
		WebElement errmsg;
		try {
			errmsg = getWebElement1("amazon.homepage.errormessage", driver);
			String errormessage = errmsg.getText();
			log.info("ERROR MSG IS  " + errormessage);
			return errormessage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Raising an Exception ==== clickOnSearchButton");
			e.printStackTrace();
		}
		return null;

	}

	public void getnumberofitemsonapage() {
		log.info(
				"This method tells the number of items present in tha page and also retrieve the prices and title ofeach item");
		log.info(
				"URL IS https://www.amazon.in/s/ref=sr_il_ti_shoes?fst=as%3Aoff&rh=n%3A1571283031%2Cn%3A%211571284031%2Cn%3A1983396031%2Cn%3A1983518031%2Cn%3A1983519031%2Cp_89%3ANike&bbn=1983519031&sort=price-asc-rank&ie=UTF8&qid=1516553693&lo=shoes");

		List<WebElement> element1 = driver.findElements(By.xpath("//*[@id='atfResults']//child::li"));
		System.out.println("     THE TOTAL NUMER OF SIZE IS    " + element1.size());

		List<WebElement> element2 = driver
				.findElements(By.xpath("//*[@id='atfResults']//child::li//child::div//child::div[3]//child::a"));
		System.out.println("     THE TOTAL NUMER OF SIZE IS    " + element2.size());
		for (WebElement eles : element2) {
			System.out.println("     Title of the item is   " + eles.getAttribute("title"));

		}

		List<WebElement> element3 = driver.findElements(
				By.xpath("//*[@id='atfResults']//child::li//child::div//child::div[3]//child::div[2]//child::a"));
		System.out.println("     THE TOTAL NUMER OF PRICS IS    " + element3.size());
		for (WebElement eles : element2) {
			System.out.println("     Price of the item is   " + eles.getText());

		}
	}

	public int getnumberofitemsonAirconditionfirstpage() {
		List<String> items = new ArrayList<String>();
		List<WebElement> item = driver.findElements(By.xpath("//div[@id='mainResults']//child::li"));
		for (int i = 0; i < item.size(); i++) {
			log.info("********Name of Item***********" + item.get(i).getAttribute("id"));
			if (item.get(i).getAttribute("id").contains("result")) {
				items.add(item.get(i).getAttribute("id"));
			} else {
				log.info(" I am getting null Value");
			}
		}
		log.info("++++++++++++++++++++++Size of New Items us ++++++++++++" + items.size());
		return items.size();
	}

	public void checkpaginationexist() {
		// log.info("Find the pagination elements by using findElemnts() and
		// store as list of elements.");
		List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='pagn']//child::span"));
		log.info("*******************NUMNBER OF PAGES ON THE PAGE IS " + pagination.size());

		if (pagination.size() > 0) {
			int count = 0;
			log.info("Pagination Exist");
			for (WebElement link : pagination) {

				log.info("// click on pagination link " + count++);

				try {
					link.click();
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}
		} else {
			log.info("Paginatio doesnot exixt");
		}

	}

	// By fooID = By.id("foo");
	// WebElement foo = driver.findElement(fooID);
	//
	// public boolean retryingFindClick(By by) {
	// boolean result = false;
	// int attempts = 0;
	// while (attempts < 2) {
	// try {
	// driver.findElement(by).click();
	// result = true;
	// break;
	// } catch (StaleElementReferenceException e) {
	// }
	// attempts++;
	// }
	// return result;
	// }

	public int firstpagennumber() {
		WebElement one = null;
		try {
			one = driver.findElement(By.xpath("//*[@class='pagnMore']//following-sibling::span[1]"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String number = one.getText();
		int firstindex = Integer.parseInt(number);
		log.info(" Last Index is " + firstindex);
		return firstindex;
	}

	public int lastpagennumber() {
		WebElement one = null;
		try {
			one = driver.findElement(By.xpath("//*[@class='pagnMore']//following-sibling::span[1]"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String number = one.getText();
		int lastindex = Integer.parseInt(number);
		log.info(" Last Index is " + lastindex);
		return lastindex;
	}

	public void clickonpreviouspagelinkonfirstpage() {
		WebElement prevoius = driver.findElement(By.xpath("//div[@id='pagn']//child::span[1]//child::span[2]"));
		log.info(" The text of percious page " + prevoius.getText());
		log.info(" Is Previous Buton is DiabledOrNot " + prevoius.isDisplayed());
	}

	public void clickonnextpagelink() {
		// WebElement next =
		// driver.findElement(By.xpath("//a[@id='pagnNextLink']//child::span[1]"));
		// log.info(" The text of next page " + next.getText());
		try {
			WebDriverWait wait = new WebDriverWait(driver,50);
			WebElement element = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pagnNextLink']//child::span[1]")));
			log.info(" The text of next page " + element.getText());
			element.click();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public void clickonpreviousbutton() {
		WebElement previousbutton = driver.findElement(By.xpath("//a[@id='pagnPrevLink']//child::span[2]"));
		log.info(" Text from second page " + previousbutton.getText());

	}

	public int getnumberofitemsonAirconditionEachPageExceptFirstPage() {
		// log.info(" I am Starting
		// getnumberofitemsonAirconditionEachPageExceptFirstPage method");

		List<String> items = new ArrayList<String>();
		List<WebElement> item = driver.findElements(By.xpath("//div[@id='centerMinus']//child::li"));
		for (int i = 0; i < item.size(); i++) {
			// log.info("********Name of Item***********" +
			// item.get(i).getAttribute("id"));
			if (item.get(i).getAttribute("id").contains("result")) {
				items.add(item.get(i).getAttribute("id"));
			} else {
				// log.info(" I am getting null Value");
			}
		}
		log.info("++++++++++++++++++++++Size of New Items us ++++++++++++" + items.size());
		return items.size();
	}

	public boolean waitForJSandJQueryToLoad() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// no jQuery present
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

}
