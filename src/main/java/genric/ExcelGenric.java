package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenric {

	private FileInputStream fInStream;
	private FileOutputStream fOutStream;
	private Workbook book;
	private Sheet sht;
	private Row rw;
	private Cell cell;
	private String cellValue;

	public String checkExcelFormat(String excelPath) throws FileNotFoundException {
		String[] exelSplitFile = excelPath.split("\\.");
		String extension = exelSplitFile[1];
		if (extension.equalsIgnoreCase("xlsx")) {
			return extension;
		} else if (extension.equalsIgnoreCase("xls")) {
			return extension;
		}
		return extension;
	}

	public String readExcelValue(String excelPath, int sheetAt, int rowNum, int columnNum) throws IOException {
		fInStream = new FileInputStream(new File(excelPath));
		if (new ExcelGenric().checkExcelFormat(excelPath).equalsIgnoreCase("xlsx")) {
			book = new XSSFWorkbook(fInStream);
		} else if (new ExcelGenric().checkExcelFormat(excelPath).equalsIgnoreCase("xls")) {
			book = new HSSFWorkbook(fInStream);
		}
		return book.getSheetAt(sheetAt).getRow(rowNum).getCell(columnNum).getStringCellValue();
	}

	public List<String> getColumnsValue(String excelPath, int sheetAt, int rowNum, int columnNum) throws IOException {
		fInStream = new FileInputStream(new File(excelPath));
		List<String> value1 = new ArrayList<String>();
		String value = null;
		if (new ExcelGenric().checkExcelFormat(excelPath).equalsIgnoreCase("xlsx")) {
			book = new XSSFWorkbook(fInStream);
		} else if (new ExcelGenric().checkExcelFormat(excelPath).equalsIgnoreCase("xls")) {
			book = new HSSFWorkbook(fInStream);
		}
		int values = book.getSheetAt(sheetAt).getPhysicalNumberOfRows();
		for (int i = 0; i < values; i++) {
			value = book.getSheetAt(sheetAt).getRow(i).getCell(columnNum).getStringCellValue();
			value1.add(value);
		}
		return value1;

	}

	public void createExcel(String filePathToBeGenrated,String sheetName,int rowNum,int colNum,String valueToBeInserted) throws IOException {
		fOutStream = new FileOutputStream(filePathToBeGenrated);
		if (checkExcelFormat(filePathToBeGenrated).equalsIgnoreCase("xlsx")) {
			book = new HSSFWorkbook();	
		} else if (checkExcelFormat(filePathToBeGenrated).equalsIgnoreCase("xls")) {
			book = new XSSFWorkbook();
		}
		book.createSheet(sheetName).createRow(rowNum).createCell(colNum).setCellValue(valueToBeInserted); 
		book.write(fOutStream);
		book.close();
	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		new ExcelGenric().createExcel("src\\main\\resources\\TestpurposeTestdata.xlsx","Testing data Purpose",1,0,"Success");

	}

}
