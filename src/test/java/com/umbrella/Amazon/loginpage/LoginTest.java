package com.umbrella.Amazon.loginpage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.umbrella.Amazon.DataProviders.Ecxel_API;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.pageLibrary.LoginPage;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

/**
 * 
 * @author Bhanu Pratap https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class LoginTest extends TestBase {

	String xlFilePath = "D:\\loginsheet.xlsx";
	String sheetName = "login";
	Ecxel_API eat = null;
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);

	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		eat = new Ecxel_API(xlFilePath);
		Object[][] data = eat.testDataexcel(xlFilePath, sheetName);
	    return data;
	}

	@Test(dataProvider="userData")
	public void testLoginToApplication(String UserName, String PassWord) throws Exception {
		// System.out.println(" *******************I am executing Login Test and
		// Thread is "+ driver.getClass().getSimpleName()+ "and Thread
		// count***********************************"+
		// Thread.currentThread().getId());
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		// System.out.println(" *******************I am executing Login Test and
		// Thread is "+ driver.getClass().getSimpleName()+ "and Thread
		// count***********************************"+
		// Thread.currentThread().getId());

		LoginPage loginPage = new LoginPage(driver);
		// System.out.println(" *******************I am executing Login Test and
		// Thread is "+ driver.getClass().getSimpleName()+ "and Thread
		// count***********************************"+
		// Thread.currentThread().getId());
		//Code to covert exponential String into well formatted string
		
//		BigDecimal myNumber = new BigDecimal(PassWord);
//		double myDouble = myNumber.doubleValue();
//		NumberFormat formatter = new DecimalFormat("#.##########");
//		String pawd = formatter.format(myDouble);

		loginPage.loginToApplication(UserName, PassWord);
		boolean status = loginPage.verifySuccessLoginMsg();
		if (status) {
			log.info("login is sucessful");
		} else {
			// System.out.println(" *******************I am executing Login Test
			// and Thread is "+ driver.getClass().getSimpleName()+ "and Thread
			// count***********************************"+
			// Thread.currentThread().getId());

			Assert.assertTrue(false, "login is not sucessful");
		}
		loginPage.signout();
	}

}
