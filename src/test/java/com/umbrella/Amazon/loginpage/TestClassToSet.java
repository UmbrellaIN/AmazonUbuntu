//package com.umbrella.Amazon.loginpage;
//
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.testng.Reporter;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.umbrella.Amazon.generics.LoggerHelper;
//import com.umbrella.Amazon.testCore.Config;
//import com.umbrella.Amazon.testCore.TestBase;
//
//public class TestClassToSet  extends TestBase {
//	
//	
//	
//	
//	private final Logger log = LoggerHelper.getLogger(TestClassToSet.class);
//	
//
//	
//
//	@Test
//	public void openff() throws Exception {
//		log.info(TestClassToSet.class.getName()+" started");
//		
//		//Config config = new Config(OR);
//		//driver.get(config.getWebsite());
//		log.info("+++++++++++++++++++++Suite one first class Started++++++++++++++++++++++++");
//		
//		Reporter.log("mousehover on select by category button");
//		WebElement web_Element_To_Be_Hovered = getWebElement("amazon.homepage.shopbycategoryhover");
//		Actions builder = new Actions(driver);
//		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
//		
//		
//		Reporter.log("mousehover on mobiles and computers");
//		WebElement web_Element_To_Be_Hovered_mobile = getWebElement("amazon.homepage.mobilescomputershover");
//		//Actions builder1 = new Actions(driver);
//		builder.moveToElement(web_Element_To_Be_Hovered_mobile).build().perform();
//		
//		
//		Reporter.log("Click on all mobiles");
//		getWebElement("amazon.homepage.allmobilephones").click();
//		
//		//driver.findElement(By.xpath("njbabnfa"));
//		driver.quit();
////		System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM 3.8\\chromedriver.exe");
////		driver = new ChromeDriver();
////
////		driver.manage().window().maximize();
////
////		driver.navigate().to("https://www.amazon.in");
////		Thread.sleep(1000);
////
////		driver.quit();
//	}	
//}