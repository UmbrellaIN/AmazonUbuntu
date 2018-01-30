package com.umbrella.Amazon.FunctionalTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.umbrella.Amazon.DataProviders.Ecxel_API;
import com.umbrella.Amazon.PageFactory.Myntra;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;
import com.umbrella.Amazon.utilities.UtilitiesMethods;

public class VerifyCouponCodeWorksDirectly extends TestBase {

	Config config;
	Myntra myntra;
	String xlFilePath = System.getProperty("user.dir")
			+ "/src/main/java/com/umbrella/Amazon/DataProviders/PriceInfo.xlsx";
	String sheetName = "price";
	Ecxel_API eat;
	UtilitiesMethods utm;
	private final Logger log = LoggerHelper.getLogger(VerifyCouponCodeWorksDirectly.class);

	@DataProvider(name = "priceData")
	public Object[][] userFormData() throws Exception {
		eat = new Ecxel_API(xlFilePath);
		// eat.loadexcel();
		Object[][] data = eat.testDataexcel(xlFilePath, sheetName);
		return data;
	}

	@Test(dataProvider = "priceData")
	public void erifyCouponCodeWorksDirectly(String pricebefoerdiscount, String discount, String priceafterdiscount)
			throws Exception {
		int expectedpriceafterdiscount = 0;
		int expectedprice = 0;
		int expecteddiscount = 0;

		log.info(VerifyCouponCodeWorksDirectly.class.getName() + " Started ");
		log.info("**********************PATH IS *******************" + xlFilePath);

		try {
			String one = pricebefoerdiscount.replaceAll("\\.0*$", "");
			expectedprice = Integer.parseInt(one);
			log.info(
					"////////////////**********///////////////////////I AM GETTING PRICE before Dicount from Excel ++++++++++++++++++"
							+ expectedprice);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String one = discount.replaceAll("\\.0*$", "");
			expecteddiscount = Integer.parseInt(one);
			log.info(
					"////////////////**********///////////////////////I AM GETTING DISCOUNT FROM DATA PROVIDER++++++++++++++++++"
							+ expecteddiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String one = priceafterdiscount.replaceAll("\\.0*$", "");
			expectedpriceafterdiscount = Integer.parseInt(one);
			log.info(
					"////////////////**********///////////////////////I AM GETTING PRICE AFTER DISCOUNT FROM DATA PROVIDER++++++++++++++++++"
							+ expectedpriceafterdiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		config = new Config(OR);
		driver.get(config.getWebsite());
		myntra = new Myntra(driver);
		myntra.scrolltillsportshoes();
		Thread.sleep(5000);
		myntra.clickonnikeshoes();
		myntra.clickonnikeshoesnumber9();
		myntra.clickonaddtobag();
		myntra.clickonGOtobag();
		int actualpricebeforediscount = myntra.gettotayalbeforediscount();
		myntra.applycoupon();
		myntra.applycoupon2();
		myntra.coupondiscounttext();
		Thread.sleep(3000);
		int actualdiscountvalue = myntra.getdiscountvalue();
		Thread.sleep(2000);
		int actualpriceafterdiscount = myntra.gettotalafterdiscount();
		Assert.assertEquals(expectedprice, actualpricebeforediscount);

		Assert.assertEquals(expecteddiscount, actualdiscountvalue);
//

		Assert.assertEquals(expectedpriceafterdiscount, actualpriceafterdiscount);

	}

}
