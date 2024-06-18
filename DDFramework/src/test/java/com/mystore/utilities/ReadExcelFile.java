package com.mystore.utilities;

import java.io.FileInputStream;

import java.io.InputStream;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {

	public static FileInputStream inputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;


	public static String getCellValue(String filename , String sheetname , int rowNo , int cellNo) {

		try {
			inputstream = new FileInputStream(filename);
			workbook = new XSSFWorkbook(inputstream);
			excelsheet = workbook.getSheet(sheetname);
			cell = workbook.getSheet(sheetname).getRow(rowNo).getCell(cellNo);

			workbook.close();

			return cell.getStringCellValue();

		} 

		catch (Exception e) 

		{

			return "";
		}

	}

	public static int getRowCount(String filename, String sheetname) {

		try {


			inputstream = new FileInputStream(filename);

			// create XSSFWorkbook class object for excel file manipulation , means read and write excel
			workbook = new XSSFWorkbook(inputstream);
			excelsheet = workbook.getSheet(sheetname);

			// get total no of rows 
			int totalrows = excelsheet.getLastRowNum() +1;

			workbook.close();

			return totalrows;
		} 

		catch (Exception e) {

			return 0;
		}

	}

	public static int getCellCount(String filename, String sheetname) {

		try {

			inputstream = new FileInputStream(filename);

			// create XSSFWorkbook class object for excel file manipulation , means read and write excel
			workbook = new XSSFWorkbook(inputstream);
			excelsheet = workbook.getSheet(sheetname);

			// get total no of cells 
			int totalcells = excelsheet.getRow(0).getLastCellNum();

			workbook.close();

			return totalcells;
		} 

		catch (Exception e) {

			return 0;
		}


	}

}
