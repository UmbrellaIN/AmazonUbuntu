package com.umbrella.Amazon.loginpage;

import org.apache.log4j.Logger;
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
public class VerifyProductCounts extends TestBase{
	private final Logger log = LoggerHelper.getLogger(VerifyProductCounts.class);
	//LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void testVerifyProductCounts(){
		log.info(VerifyProductCounts.class.getName()+" started");	
	//	System.out.println(" *******************I am executing VerifyProductCounts Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());

		Config config = new Config(OR);
		driver.getClass().getName();
		driver.get(config.getWebsite());
	//	System.out.println(" *******************I am executing VerifyProductCounts Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());

		homePage = new HomePage(driver);
		ProductCategoryPage pCate = homePage.clickOnMenu(homePage.womenMenu);
		pCate.selectColor(pCate.Orange);
		int count = pCate.getTotalProducts();
	//	System.out.println(" *******************I am executing VerifyProductCounts Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());

		if(count==3){
			log.info("product count is matching");
		}
		else{
			//System.out.println(" *******************I am executing VerifyProductCounts Test and Thread is "+ driver.getClass().getSimpleName()+ "and Thread count***********************************"+ Thread.currentThread().getId());

			Assert.assertTrue(false,"product count is not matching");	
		}
		
	}

}
