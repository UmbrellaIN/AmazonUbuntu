package com.umbrella.Amazon.pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.generics.WaitHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;

public class SignInPage  {
	
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(SignInPage.class);
	WaitHelper waitHelper;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		WebElement durga = driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]"));
		waitHelper.waitForElement(driver, new Config(TestBase.OR).getExplicitWait(), durga);
	}
	
	

	public void clickonaccountbutton() throws Exception {
		log.info("Clicking on Account");
		driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
//		WebElement account = getWebElement("gurudemo.homepage.account");
//		account.click();
	}

	public void clickonmyaccountbutton() throws Exception {
		log.info("Clicking on MyAccount");
//		WebElement myaccount = getWebElement("gurudemo.homepage.myaccount");
//		myaccount.click();
	}

	public void enterusername(String UserName) {
		log.info("Entering UserNamet");
//		try {
//			WebElement usernametextbox = getWebElement("gurudemo.homepage.accountusername");
//			// usernametextbox.sendKeys(OR.getProperty("Username"));
//			usernametextbox.sendKeys(UserName);
//		} catch (Exception e) {
//			log.info("Excetion name is " + e.getMessage());
//		}
	}

	public void enterpassword(String PassWord) throws Exception {
		log.info("Entering Password");
//		WebElement passwordtextbox = getWebElement("gurudemo.homepage.accountpassword");
//		// passwordtextbox.sendKeys(OR.getProperty("Password"));
//		passwordtextbox.sendKeys(PassWord);
	}

	public void submitbutton() throws Exception {
		log.info("Clicking on subit Button");
		//getWebElement("gurudemo.homepage.accountsubmitbutton").click();
	}

	public String getpagetitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickonwishlist() throws Exception {
		log.info("Clicking on My WishList");
	//	getWebElement("gurudemo.homepage.mywishlist").click();

	}

	public void clickoncart() throws Exception {
		log.info("Clicking on My Cart");
//		try {
//			getWebElement("gurudemo.homepage.cart").click();
//
//		} catch (Exception e) {
//			log.info("Excetion name is " + e.getMessage());
//		}
	}

	public void proceedtocheckout() throws Exception {
		log.info("Clicking on My proceedtocheckout");
		try {
			//getWebElement("gurudemo.homepage.proceedtocheckout").click();

		} catch (Exception e) {
			log.info("Excetion name is " + e.getMessage());
		}
	}

}
