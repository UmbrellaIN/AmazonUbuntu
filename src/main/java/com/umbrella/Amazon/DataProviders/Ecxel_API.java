package com.umbrella.Amazon.DataProviders;

import java.io.FileInputStream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Ecxel_API {

	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String xlFilePath;

	
	
	

	public Ecxel_API(String xlFilePath) throws Exception {
		System.out.println("++++++++++++++++++++I am Excel API constructor and get called ++++++++++++++++++++++"+ xlFilePath.getClass().getName());
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
	///	fis.close();
	}
	public void initial()
	{
		
	}
	

	public int getRowCount(String sheetName) {

		sheet = workbook.getSheet(sheetName);
		// Removed +1 from the end in int RowCount
		int rowCount = sheet.getLastRowNum()+1;
		System.out.println("++++++++++++++++++++RowCount is ++++++++++++++++++++++" + rowCount);
		return rowCount;
	}

	public int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		System.out.println("++++++++++++++++++++Column is ++++++++++++++++++++++" + colCount);
		return colCount;
	}

	public Object getCellData(String sheetName, int colNum, int rowNum) {
		try {
			
		//	System.out.println("++++++++++++++++++++Shet Name and MAethod is  get Cell Data ++++++++++++++++++++++" + sheetName);
			//System.out.println("++++++++++++++++++++COL NUM COUNT and MAethod is  get Cell Data ++++++++++++++++++++++" + colNum);
			//System.out.println("++++++++++++++++++++ROW  COUNT and MAethod is  get Cell Data ++++++++++++++++++++++" + rowNum);

			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);

			cell = row.getCell(colNum);

			if (cell.getCellTypeEnum() == CellType.STRING)

				return cell.getStringCellValue();

			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else if (cell.getCellTypeEnum() == CellType.NUMERIC)
				return cell.getNumericCellValue();
			
			else if(cell.getCellTypeEnum()==null)
				return "I AM NULLL";
			else if(cell.getCellTypeEnum()==CellType._NONE)
				return "I AM NULLL";
			
			else
				return String.valueOf(cell.getBooleanCellValue());
		}

		catch (Exception e) {
			e.printStackTrace();
		
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}

	}

	public Object[][] testDataexcel(String xlFilePath, String sheetName) throws Exception {
		Object[][] excelData = null;
		//eat = new Ecxel_API(xlFilePath);
		int rows = getRowCount(sheetName);
		int columns = getColumnCount(sheetName);

		excelData = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				excelData[i - 1][j] = getCellData(sheetName, j, i);
			}

		}
		return excelData;
	}
}
