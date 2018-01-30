package com.umbrella.Amazon.generics;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
@SuppressWarnings("rawtypes")
public class LoggerHelper {

	private static boolean root = false;
	


	public static Logger getLogger(Class clas){
		if (root) {
			return Logger.getLogger(clas);
		}
		try{
		String log4jLOcation = System.getProperty("user.dir")+"/Resources/log4j.properties";
		//PropertyConfigurator.configure(ResourceHelper.getResourcePath(System.getProperty("/Resources/log4j.properties")));
		PropertyConfigurator.configure(log4jLOcation);
		root = true;}
		catch(Exception e)
		{
			System.out.println("I am Rising an exception "+ e.getMessage());
		}
		return Logger.getLogger(clas);
	}
}
