package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class FileReader {

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
			int cellValue = (int) sht.getRow(1).getCell(0).getNumericCellValue();
			

		} else if (extension.equalsIgnoreCase("xls")) {
			HSSFWorkbook book = new HSSFWorkbook(fileIPS);
			System.out.println("test");
			HSSFSheet sht = book.getSheet("Summary");
			int cellValue = (int) sht.getRow(1).getCell(1).getNumericCellValue();
			
		}

	}

}
