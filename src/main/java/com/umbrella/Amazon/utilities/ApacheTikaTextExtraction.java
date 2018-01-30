package com.umbrella.Amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class ApacheTikaTextExtraction {

	//This Method takes the filepath and extreact the content of pdf file
	//Apache Tika is a framework used to extract the content of various files like Doc, PDF etc
	public String dataINPDFAfterParsing(String FilePath) throws IOException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		FileInputStream inputstream = new FileInputStream(new File(FilePath));
		ParseContext pcontext = new ParseContext();
		// parsing the document using PDF parser
		PDFParser pdfparser = new PDFParser();
		try {
			pdfparser.parse(inputstream, handler, metadata, pcontext);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getting the content of the document
		System.out.println("Contents of the PDF :" + handler.toString());
           String datainPDFFile = handler.toString();
		// getting metadata of the document
		System.out.println("Metadata of the PDF:");
		String[] metadataNames = metadata.names();
		for (String name : metadataNames) {
			System.out.println(name + " : " + metadata.get(name));
		}
       return datainPDFFile;
	}

	public static void main(final String[] args) throws IOException, TikaException {
		String filepath = "C:\\Users\\Acer\\Downloads\\Selenium Easy - Download Table Data to CSV, Excel, PDF and Print (2).pdf";
		ApacheTikaTextExtraction apche = new ApacheTikaTextExtraction();
		apche.dataINPDFAfterParsing(filepath);

	}

}
