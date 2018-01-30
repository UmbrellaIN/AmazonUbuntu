package com.umbrella.Amazon.PageFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.umbrella.Amazon.generics.JavaScriptHelper;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.generics.WaitHelper;
import com.umbrella.Amazon.testCore.TestBase;
import com.umbrella.Amazon.utilities.UtilitiesMethods;

public class Myntra extends TestBase {

	WebDriver driver;
	WaitHelper waitHelper;
	JavaScriptHelper javaScriptHelper;
	UtilitiesMethods utm = new UtilitiesMethods();
	private final Logger log = LoggerHelper.getLogger(Myntra.class);

	public Myntra(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, carasoul, new
		// Config(TestBase.OR).getExplicitWait());
	}

	public void scrolltillsportshoes() throws InterruptedException {
		log.info("Scrolling Page till Sport shoes ");
		javaScriptHelper = new JavaScriptHelper(driver);
		WebElement sportshoes = null;
		try {
			// sportshoes =
			// driver.findElement(By.xpath("html/body/div[3]/div/div/footer/div/div[2]/div/div[2]/a[11]"));
			sportshoes = getWebElement1("myntra.homepage.scrollpage", driver);
		} catch (Exception e) {
			log.info("+++++++++++++++++++++++Creting an Exception++++++++++++++++++++++++++++++++++");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Scrolling Till Sport Shoes");
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("arguments[0].scrollIntoView(true);", sportshoes);
		// jse.ExecuteScript("arguments[0].scrollIntoView(true);", sportshoes);

		// jse.executeScript("window.scrollBy(0,950)", "");
		// javaScriptHelper.scrollIntoView(sportshoes);
		// Thread.sleep(3000);
		log.info("+++++++++++++++++++++++Clicking on Sport shordsss++++++++++++++++++++++" + sportshoes.isDisplayed());
		sportshoes.click();

	}

	public void clickonnikeshoes() {
		// WebElement imagenike=
		// driver.findElement(By.xpath("//ul[@class='results-base']//child::li[1]//child::img"));
		log.info("Clicking on Nike Shoes");
		WebElement imagenike = null;
		try {
			imagenike = getWebElement1("myntra.sportsshoes.nikeshoes", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagenike.click();
	}

	public void clickonnikeshoesnumber9() {
		WebElement imagenikesize9 = null;
		try {
			imagenikesize9 = getWebElement1("myntra.sportsshoes.nikeshoes9", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicking on Nike Shoes Number 9");
		imagenikesize9.click();
	}

	public void clickonaddtobag() {
		WebElement imagenikesize9 = null;
		try {
			imagenikesize9 = getWebElement1("myntra.sportsshoes.addtobag", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("clicking on add to Bag Button");
		imagenikesize9.click();
	}

	public void clickonGOtobag() {
		WebElement imagenikesize9 = null;
		try {
			imagenikesize9 = getWebElement1("myntra.sportsshoes.gotobag", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicking on Goto Bag");
		imagenikesize9.click();
	}

	public int gettotayalbeforediscount() {

		WebElement ordertotal = driver
				.findElement(By.xpath("html/body/div[1]/div[3]/div/div[1]/div[2]/div[2]/div[2]/span"));
		String ordertotal1 = ordertotal.getAttribute("textContent");

		//log.info("************************TOTAL BEFORE DISCOUNT IS   *******************************" + ordertotal1);
		int total1 = utm.convertStringtoInt(ordertotal1);
		log.info("************************TOTAL BEFORE DISCOUNT IS   *******************************" + total1);
		return total1;

	}

	public void applycoupon() {
		WebElement imagenikesize9 = null;
		try {
			imagenikesize9 = getWebElement1("myntra.sportsshoes.applycoupon", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Applying Coupon First Time");
		imagenikesize9.click();
	}

	public void applycoupon2() {
		WebElement imagenikesize9 = null;
		try {
			imagenikesize9 = getWebElement1("myntra.sportsshoes.applycoupon2", driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicking on Apply Couopn in second pop up");
		imagenikesize9.click();
	}

	public void coupondiscounttext() {
		WebElement imagenikesize9 = null;
		try {
			imagenikesize9 = getWebElement1("myntra.sportsshoes.coupondiscounttext", driver);
			String text = imagenikesize9.getText();
			log.info("************************Text us *******************************" + text);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getdiscountvalue() {
		WebElement discountvalue = driver
				.findElement(By.xpath("html/body/div[1]/div[3]/div/div[1]/div[2]/div[1]/div[5]/div[5]/span"));

		String text1 = discountvalue.getAttribute("textContent");
		//log.info("************************Value of discount coupon is  *******************************" + text1);
       int discount =  utm.convertStringtoInt(text1);
		log.info("************************Value of discount coupon is  *******************************" + discount);
        return discount;
		//String text2 = discountvalue.getText();
		//log.info("************************Value of discount coupon is  *******************************" + text2);
	}

	public int gettotalafterdiscount() {
		WebElement ordertotal = driver
				.findElement(By.xpath("html/body/div[1]/div[3]/div/div[1]/div[2]/div[2]/div[2]/span"));
		String ordertotal1 = ordertotal.getAttribute("textContent");
		int ordertotal2 = utm.convertStringtoInt(ordertotal1);
		log.info("************************TOTAL AFTER DISCOUNT IS   *******************************" + ordertotal2);
		return ordertotal2;

	}
}
