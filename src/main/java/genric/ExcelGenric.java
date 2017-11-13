package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenric {

	FileInputStream fInStream;
	FileOutputStream fOutStream;
	XSSFWorkbook xssfbook;
	HSSFWorkbook hssfBook;
	Sheet sht;
	String cellValue;

	public String readExcel(int sheetAt, int rowNum, int columnNum) {
		String[] excelPath = Constants.excelTestFilePath.split("\\.");
		String extension = excelPath[1];
		System.out.println(extension);
		try {
			fInStream = new FileInputStream(new File((Constants.excelTestFilePath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if (extension.equalsIgnoreCase("xlsx")) {
			try {
				xssfbook = new XSSFWorkbook(fInStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sht = xssfbook.getSheetAt(sheetAt);
			cellValue = sht.getRow(rowNum).getCell(columnNum).getStringCellValue();
		} else if (extension.equalsIgnoreCase("xls")) {
			try {
				hssfBook = new HSSFWorkbook(fInStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sht = hssfBook.getSheetAt(sheetAt);
			cellValue = sht.getRow(rowNum).getCell(columnNum).getStringCellValue();

		}
		return cellValue;

	}

	
	public void writeExcelValue(String string, String sheetName, int rowNum, int cellNum, String cellvalue) throws EncryptedDocumentException, InvalidFormatException, IOException  {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\shubhamg\\git\\AutomationFramework\\src\\main\\resources\\test.xls"));
		workbook.write(out);
		out.close();
		
	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		new ExcelGenric().writeExcelValue("src\\main\\resources\\shubhmTestingPurpose.xlsx", "Yesthjkj", 0, 0,
				"my name is khan");

	}

}
