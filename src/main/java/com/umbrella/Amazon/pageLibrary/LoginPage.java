package com.umbrella.Amazon.pageLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.umbrella.Amazon.generics.GenericHelper;
import com.umbrella.Amazon.generics.JavaScriptHelper;
import com.umbrella.Amazon.generics.LoggerHelper;
import com.umbrella.Amazon.generics.WaitHelper;
import com.umbrella.Amazon.testCore.TestBase;








/**
 * 
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class LoginPage extends TestBase{
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	
	
//	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
//	WebElement signin;
	
//	@FindBy(xpath="//*[@id='email']")
//	WebElement emailAddress;
//	
//	@FindBy(xpath="//*[@id='passwd']")
//	WebElement password;
	
//	@FindBy(xpath="//*[@id='SubmitLogin']")
//	WebElement submitLogin;
	
	@FindBy(xpath="//*[@id='center_column']/p")
	WebElement successMsgObject;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement registration;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement createAnAccount;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement signout;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(driver, signin,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void clickOnSignInLink() throws Exception{
		log.info("clicked on sign in link...");
		WebElement signin = getWebElement1("atomation.loginpage.signin", driver);
		signin.click();
	}
	
	public void enterEmailAddress(String emailAddress) throws Exception{
		log.info("entering email address...."+emailAddress);
		WebElement emailAddress1  = getWebElement1("atomation.loginpage.emailtextbox", driver);
		emailAddress1.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) throws Exception{
		log.info("entering password...."+password);
		WebElement password1 = getWebElement1("atomation.loginpage.passwordtextbox", driver);
		
		password1.sendKeys(password);
	}
	
	public HomePage clickOnSubmitButton() throws Exception{
		log.info("clicking on submit button...");
		new JavaScriptHelper(driver).scrollDownVertically();
	    WebElement submitLogin = getWebElement1("atomation.loginpage.submitlogin",driver);
	//	System.out.println("+++++++++++++++++Submit Button is ********************"+    submitLogin.isDisplayed());
		submitLogin.click();
		return new HomePage(driver);
	}
	
	public boolean verifySuccessLoginMsg(){
		return new GenericHelper().isDisplayed(successMsgObject);
	}
	
	public void enterRegistrationEmail(){
		String email = System.currentTimeMillis()+"@gmail.com";
		log.info("entering registration email.."+email);
		registration.sendKeys(email);	
	}
	
	public RegistrationPage clickOnCreateAnAccount(){
		createAnAccount.click();
		return new RegistrationPage(driver);
	}
	
	public void loginToApplication(String emailAddress, String password) throws Exception{
		//System.out.println("****************************** I am Starting Login Test and current Thread***********************************"+Thread.currentThread().getId());

		clickOnSignInLink();
		//System.out.println("****************************** I am Starting Login Test and current Thread***********************************"+Thread.currentThread().getId());
System.out.println("+++++++++++++++ I am Getting UserName from DataProvider++++++++++++++++++++" +emailAddress);
		enterEmailAddress(emailAddress);
		//.out.println("****************************** I am Starting Login Test and current Thread***********************************"+Thread.currentThread().getId());
		System.out.println("+++++++++++++++ I am Getting Password from DataProvider++++++++++++++++++++" +password);

		enterPassword(password);
		//System.out.println("****************************** I am Starting Login Test and current Thread***********************************"+Thread.currentThread().getId());

		clickOnSubmitButton();
	}
	
	public void signout()
	{
		signout.click();
	}

}
