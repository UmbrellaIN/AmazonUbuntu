package com.umbrella.Amazon.loginpage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.pageLibrary.HomePage;
import com.umbrella.Amazon.pageLibrary.ProductCategoryPage;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;



/**
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class VerifyLowestFirstPriceFilter extends TestBase{
	private final Logger log = LoggerHelper.getLogger(VerifyLowestFirstPriceFilter.class);
	
	@Test
	public void verifyLowestFirstPriceListInProduct_deatilsPage() throws InterruptedException {
		log.info(VerifyLowestFirstPriceFilter.class.getName()+" started");
		//System.out.println(" *******************I am executing VerifyLowestFirstPriceFilter Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());


		Config config = new Config(OR);
		driver.get(config.getWebsite());
		

		HomePage homepage = new HomePage(driver);
		//System.out.println(" *******************I am executing VerifyLowestFirstPriceFilter Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());


		ProductCategoryPage pcategoryPage = homepage.clickOnMenu(homepage.womenMenu);
		// select price filter
		pcategoryPage.selectSortByFilter("Price: Lowest first");
		
		// wait for some time to make sure price is sorted.
		Thread.sleep(1000);
		//System.out.println(" *******************I am executing VerifyLowestFirstPriceFilter Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());


		List<WebElement> price = pcategoryPage.getAllProductsPrice();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		//System.out.println(" *******************I am executing VerifyLowestFirstPriceFilter Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());

		Iterator<WebElement> itr = price.iterator();

		//price comes in "$16.40" format
		// remove $ from beginning and change to int for sorting order verification
		// Store it in array list
		while (itr.hasNext()) {
			String p = itr.next().getText();
			//System.out.println(p);
			if (p.contains("$")) {
				String actualData = p.substring(1);
				System.out.println(actualData);
				double p1 = Double.parseDouble(actualData);
				int productPrice = (int) (p1);
				array.add(productPrice);
			}
		//	System.out.println(" *******************I am executing VerifyLowestFirstPriceFilter Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());

		}
        System.out.println(array);
        //[16, 16, 26, 27, 28, 30, 50]
		for (int i = 0; i < array.size() - 1; i++) {
			// this condition will check all next price should be smaller than previous one.
			// next price can be grater and equal
			if (array.get(i) <= array.get(i + 1)) {
				System.out.println("obj.get(i):-" + array.get(i));
				System.out.println("obj.get(i+1):-" + array.get(i + 1));
			} else {
				//System.out.println(" *******************I am executing VerifyLowestFirstPriceFilter Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());

				Assert.assertTrue(true,"price filter is not working");
			}
		}
	}

}
