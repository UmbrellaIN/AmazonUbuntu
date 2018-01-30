package com.umbrella.Amazon.loginpage;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.umbrella.Amazon.DataProviders.Ecxel_API;


public class LoginWithDataProvider  {
	
//	 String xlFilePath = "D:\\CredentilSheet.xlsx";
//	    String sheetName = "login";
//	    Ecxel_API eat = null;
//	     
//	    @Test(dataProvider = "userData")
//	    public void fillUserForm(String userName, String passWord, String dateCreated,  String result)
//	    {
//	       System.out.println("UserName: "+ userName);
//	       System.out.println("PassWord: "+ passWord);
//	       System.out.println("DateCreated: "+ dateCreated);
//	     //  System.out.println("NoOfAttempts: "+ noOfAttempts);
//	       System.out.println("Result: "+ result);
//	       System.out.println("*********************");
//	    }
//	    
//	    @DataProvider(name = "userData")
//	    public Object[][] userFormData() throws Exception
//	    {
//	    	eat = new Ecxel_API(xlFilePath);
//	        Object[][] data = eat.testDataexcel(xlFilePath, sheetName);
//	        return data;
//	    }
//	     
//	SECOND ITERATION OF THIS CLASSS
	
	String xlFilePath = "D:\\loginsheet.xlsx";
	String sheetName = "login";
	Ecxel_API eat ;
	//eat = new Ecxel_API(xlFilePath);
	//private final Logger log = LoggerHelper.getLogger(LoginTest.class);
//	
//	@BeforeTest
//	public void init() throws Exception
//	{
//		eat=  new Ecxel_API(xlFilePath);
//	}


	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception {
		eat = new Ecxel_API(xlFilePath);
	//	eat.loadexcel();
		Object[][] data = eat.testDataexcel(xlFilePath, sheetName);
		return data;
	}

	@Test(dataProvider = "userData")
    public void filldata(String UserName , String PassWord, String City) throws Exception
    {
		BigDecimal myNumber = new BigDecimal(PassWord);
		double myDouble = myNumber.doubleValue();
		NumberFormat formatter = new DecimalFormat("#.##########");
		String pawd = formatter.format(myDouble);
		System.out.println("UserName is "+ UserName);
		System.out.println("Password is "+ pawd);
		System.out.println("City is "+ City);
		//System.out.println("Password is "+ PassWord);
		
    }
	

	
	
	
}
