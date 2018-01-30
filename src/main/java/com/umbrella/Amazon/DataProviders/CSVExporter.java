package com.umbrella.Amazon.DataProviders;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;

import com.umbrella.Amazon.FunctionalTest.VerifyentriesinExportedCSVfile;
import com.umbrella.Amazon.generics.LoggerHelper;

public class CSVExporter {
	
	private final Logger log = LoggerHelper.getLogger(VerifyentriesinExportedCSVfile.class);


	public File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		System.out.println("Before Format : " + dir.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		System.out.println("After Format : " + sdf.format(dir.lastModified()));
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	/*
	 * method is used to get the latest file from the directory. It takes the
	 * folder path as the parameter and returns the file which is recently added
	 * to the folder.
	 * FileFilter is an abstract class used by JFileChooser for filtering the set of files shown to the user	
	 */
	public File getTheNewestFile(String filePath, String ext) {
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		File[] files = dir.listFiles(fileFilter);

		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}

		return theNewestFile;
	}

	/**
	 * method to read the CSV file and get the number of entries present in the
	 * exported csv file. It takes the file name as the parameter
	 **/
	public int getRecordsCountInCSV(String downloadPath, String csvFileName) {
		int lineNumberCount = 0;
		try {
			if (!csvFileName.isEmpty() || csvFileName != null) {
				String filePath = downloadPath + System.getProperty("file.separator") + csvFileName;
				log.info("File Path is " +filePath);
				File file = new File(filePath);
				if (file.exists()) {
					log.info("File found with Name:" + csvFileName);
					FileReader fr = new FileReader(file);
					LineNumberReader linenumberreader = new LineNumberReader(fr);
					while (linenumberreader.readLine() != null) {
						lineNumberCount++;
					}
					// To remove the header
					lineNumberCount = lineNumberCount - 1;
					//System.out.println("********************Total number of lines found in csv******************* : "
						//	+ (lineNumberCount));
					linenumberreader.close();
				} else {
					log.info("************File does not exists*****************");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lineNumberCount;
	}

}
