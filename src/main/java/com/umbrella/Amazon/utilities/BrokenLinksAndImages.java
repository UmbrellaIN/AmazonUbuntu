package com.umbrella.Amazon.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.umbrella.Amazon.generics.LoggerHelper;

public class BrokenLinksAndImages {
	public int invalidImageCount;
	public int validlinks1 = 10;
	private final Logger log = LoggerHelper.getLogger(BrokenLinksAndImages.class);

	public int verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// log.info("verifyimageActive Returning Invalid Images Count");
		return invalidImageCount;
	}

	public int verifyLinkActive(String url) throws IOException {
             int link = 0;
		try {

			URL urlnew = new URL(url);
			HttpURLConnection httpinstance = (HttpURLConnection) urlnew.openConnection();
			httpinstance.connect();
			if (httpinstance.getResponseCode() == 200) {
				System.out.println(url + "  " + httpinstance.getResponseMessage());
				// System.out.println("******************I m Incraesing Valid
				// Count Value **************************:" + validlinks );
				link = 0;

			} else if (httpinstance.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {
				// System.out.println("///////////*********************************I
				// M IN BAD REQUEST
				// ****************************************//////////////");

				System.out.println(url + "  " + httpinstance.getResponseMessage());

				link =  1;

			}
		} catch (Exception e) {
              log.info("I m raising an Exception");
			e.printStackTrace();
		}
		// System.out.println("******************RETURNING VALID LINKS
		// AS**************************:" + validlinks );
		return link;

	}
}
