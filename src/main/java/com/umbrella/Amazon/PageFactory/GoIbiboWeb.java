package com.umbrella.Amazon.PageFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.TestBase;


 
public class GoIbiboWeb extends TestBase{
	
	private WebDriver driver;
	private static final Logger log = LoggerHelper.getLogger(GoIbiboWeb.class);

	
	public GoIbiboWeb( WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getclickonsignInButton() throws Exception
	{
		log.info("Cliciking on SignIn Button");
		WebElement signin = getWebElement1("GoIbibo.homepage.signin",driver);
		signin.click();
		Thread.sleep(2000);
		driver.switchTo().frame("authiframe");
	}
	
	public void switchtoframe()
	{
		//To move back to the parent frame, you can either use switchTo().parentFrame()
		//or if you want to get back to the main (or most parent) frame, you can use switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		log.info("No of frames are " + frames.size());
		for(int i = 0;i<frames.size();i++)
		{
			log.info("Name of frames are " + frames.get(i).getAttribute("id"));
			
		//	if(frames.get(i).getAttribute("id").equals(authiframe))
			if(frames.get(i).getAttribute("id").equals("authiframe"))
			{
			driver.switchTo().frame(i);
			}
		}
		}
	
	public void clickonLogin() throws Exception
	{
		log.info("Cliciking on Login Button");
		WebElement signin = getWebElement1("GoIbibo.homepage.login",driver);
		signin.click();
		
		String defaultmessgae = driver.findElement(By.xpath("html/body/section/div[3]/div[4]/span[1]/button")).getText();
		log.info("Default Message is " + defaultmessgae);
	}
	
	

}
