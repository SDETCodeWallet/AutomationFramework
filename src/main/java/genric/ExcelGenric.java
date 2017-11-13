package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenric {

	FileInputStream fInStream;
	FileOutputStream fOutStream;
	Workbook book;
	Sheet sht;
	Row rw;
	Cell cell;
	String cellValue;

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
		List<String> listValues = null;
		if (new ExcelGenric().checkExcelFormat(excelPath).equalsIgnoreCase("xlsx")) {
			book = new XSSFWorkbook(fInStream);
		} else if (new ExcelGenric().checkExcelFormat(excelPath).equalsIgnoreCase("xls")) {
			book = new HSSFWorkbook(fInStream);
		}
		int values = book.getSheetAt(sheetAt).getLastRowNum();
		for (int i = 0; i < values - 1; i++) {
			String value = book.getSheetAt(sheetAt).getRow(i).getCell(columnNum).getStringCellValue();
			System.out.println(value);
			listValues = new ArrayList<String>();
			listValues.add(value);
			

		}
		return listValues;

	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<String> value = new ExcelGenric().getColumnsValue(Constants.excelTestFilePath, 0, 0, 0);
		for (String test : value) {
			System.out.println(test);
		}

	}

}
