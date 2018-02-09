package com.umbrella.Amazon.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.testCore.TestBase;

import static org.awaitility.Awaitility.*;
import static org.hamcrest.Matchers.*;

public class YouTube extends TestBase {
	
	private WebDriver driver;
	private static final Logger log = LoggerHelper.getLogger(YouTube.class);
	
	public YouTube(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void youTubeSearchButton() {
		WebElement youTubeSearch = driver.findElement(By.xpath("//input[@id='search']"));
		youTubeSearch.sendKeys("raspberry pi 3");
		youTubeSearch.sendKeys(Keys.ENTER);

	}

	public void getFirstVideo() throws InterruptedException {

		List<WebElement> youtubeVideos = driver
				.findElements(By.xpath("//div[@id='primary']//div[@id='contents']//a[@id='thumbnail']"));
		log.info(" Number of YouTub Videso on the Page " + youtubeVideos.size());
		Thread.sleep(3000);
		youtubeVideos.get(0).click();
		Thread.sleep(10000);
	}

	// The getElementById() method returns the element that has the ID attribute
	// with the specified value.
	//
	// This method is one of the most common methods in the HTML DOM, and is
	// used almost every time you want to manipulate, or get info from, an
	// element on your document.
	//
	// Returns null if no elements with the specified ID exists.
	//
	// An ID should be unique within a page. However, if more than one element
	// with the specified ID exists, the getElementById() method returns the
	// first element in the source code.
	public void variousvideoOperation() throws InterruptedException {

		WebElement videoplayer = driver.findElement(By.xpath("//video"));
		try {
			Thread.sleep(5000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById(\"movie_player\").click()");
			Thread.sleep(6000);
			// check video is paused
			log.info("I m Priniting State of the Video");
			System.out.println(jse.executeScript("document.getElementById(\"movie_player\").paused"));

			log.info("Playing Video");
			log.info("To check Video Raedy State ");
			Object elem = jse.executeScript("document.getElementsByClassName(video-stream)).readyState");

			System.out.println(jse.executeScript("document.getElementsByClassName(video-stream)).readyState"));

			jse.executeScript("document.getElementById(\"movie_player\").click()");
			Thread.sleep(2000);
			// check video is paused
			log.info("I m Priniting State of the Video");
			System.out.println(jse.executeScript("document.getElementById(\"movie_player\").paused"));
			log.info("Increasing volume ");
			jse.executeScript("document.getElementById(\"movie_player\").volume=0.5");
			Thread.sleep(2000);
			log.info("To check video is muted ");
			System.out.println(jse.executeScript("document.getElementById(\"movie_player\").muted"));
			Thread.sleep(5000);

			;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getReadYStateofVideo() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		log.info("To check Video Raedy State ");
		try {
			Thread.sleep(5000);
			Object elem = jse.executeScript("document.getElementById(\"movie_player\").readyState");
			log.info("To  Video Raedy State Objehct is  " + elem.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void skipAdd() throws InterruptedException {
		//https://www.youtube.com/watch?v=2SzdhH8xAX4
		Thread.sleep(5000);
		
		//This is giving text as Skip ADD 
		WebElement skipAddButton  =driver.findElement(By.xpath("//button[@class='videoAdUiSkipButton videoAdUiAction videoAdUiFixedPaddingSkipButton']//div[1]"));
        log.info("***************Getting Messgae form The skipAddButton in the begining  **************** " + skipAddButton.getText());
		
        WebElement skipadd = driver.findElement(By.xpath("//div[@class='videoAdUiPreSkipButton']//div[2]"));
        
        String SkipaddInSeconds = driver.findElement(By.xpath("//div[@class='videoAdUiPreSkipButton']"))
				.getText();
	//	WebElement SkipaddInSeconds1 = driver.findElement(By.xpath("//div[@class='videoAdUiPreSkipButton']//div[2]"));
        log.info("Getting Messgae form The Addskipper " + SkipaddInSeconds);
        Thread.sleep(5000);
        log.info("**************Getting Messgae form The Addskipper after waiting 5 seconds************ " + SkipaddInSeconds);
        
        WebElement skipAddButton1  =driver.findElement(By.xpath("//button[@class='videoAdUiSkipButton videoAdUiAction videoAdUiFixedPaddingSkipButton']//div[1]"));
        log.info("***************Getting Messgae form The skipAddButton **************** " + skipAddButton1);


        await("Avertisent can not be skipiied before 5 seconds").atMost(20, TimeUnit.SECONDS).until(skipadd::getText,
				is("Skip Ad"));
        
     //s   WebElement skipAddButton  =driver.findElement(By.xpath("//button[@class='videoAdUiSkipButton videoAdUiAction videoAdUiFixedPaddingSkipButton']//div[1]"));
       // skipAddButton.click();
        
        WebElement SkipAddAfter5Seconds = driver.findElement(By.xpath("//div[@class='videoAdUiSkipContainer html5-stop-propagation']//button"));
       //ss SkipAddAfter5Seconds.click();
        
	}

}
