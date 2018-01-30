package com.umbrella.Amazon.pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.generics.WaitHelper;
import com.umbrella.Amazon.testCore.Config;
import com.umbrella.Amazon.testCore.TestBase;



/**
 * 
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
/**
 * This class is an example of Page Factory Methods
 *
 */
public class HomePage extends TestBase {
	

	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	
	String Tshirts = "T-shirts";
	String Blouses = "Blouses";
	String CasualDresses = "Casual Dresses";

	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	public WebElement dressesMenu;
	
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[3]/a")
	public WebElement tshirtsMenu;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//TestBase testBase = new TestBase();
		waitHelper.waitForElement(driver, womenMenu,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void mouseOver(String data){
		log.info("doing mouse over on :"+data);
		//System.out.println("****************************** I am Starting VerifyProductCounts Test and current Thread***********************************"+Thread.currentThread().getId());

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}
	
	public ProductCategoryPage clickOnIntem(String data){
		log.info("clickin on :"+data);
	//	System.out.println("****************************** I am Starting VerifyProductCounts Test and current Thread***********************************"+Thread.currentThread().getId());

		driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();
		return new ProductCategoryPage(driver);
	}
	
	public ProductCategoryPage clickOnMenu(WebElement element){
		log.info("clickin on : "+element.getText());
	//	System.out.println("****************************** I am Starting VerifyProductCounts Test and current Thread***********************************"+Thread.currentThread().getId());

		element.click();
		return new ProductCategoryPage(driver);
	}

}
