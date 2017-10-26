package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FileReader {

	private static WorkbookFactory book;
	private static FileInputStream fileInputStream;

	public static String getPropertyValue(String name) {
		FileInputStream inputFile = null;
		String configFilePath = "src//main//resources//Config.properties";
		File filePath = new File(configFilePath);
		try {
			inputFile = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(name);
		return value;
	}

	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\shubhamg\\Desktop\\Sales Center\\AutoBase_Timesheet.xls";
		String[] excelFile = filePath.split("\\.");
		String extension = excelFile[1];
		File excelFilePath = new File(filePath);

		FileInputStream fileIPS = new FileInputStream(excelFilePath);
		if (extension.equalsIgnoreCase("xlxs")) {
			XSSFWorkbook book = new XSSFWorkbook(fileIPS);
			XSSFSheet sht = book.getSheet("Summary");
			int  cellValue =  (int) sht.getRow(1).getCell(0).getNumericCellValue();
			System.out.println(cellValue);

		} else if (extension.equalsIgnoreCase("xls")) {
			System.out.println("inside");
			HSSFWorkbook book = new HSSFWorkbook(fileIPS);
			HSSFSheet sht = book.getSheet("Summary");
			int cellValue = (int) sht.getRow(1).getCell(1).getNumericCellValue();
			System.out.println(cellValue);
		}

	}

}
