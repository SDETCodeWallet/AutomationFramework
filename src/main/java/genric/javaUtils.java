package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gargoylesoftware.htmlunit.javascript.host.dom.RadioNodeList;

class javaUtils {

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

	public static String genrateRandomString(int charCount) {
		String st1 = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
		StringBuilder stringBuilder = new StringBuilder(charCount);
		Random random = new Random();
		for (int i = 0; i <= charCount - 1; i++) {
			stringBuilder.append(st1.charAt(random.nextInt(charCount)));
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(new javaUtils().genrateRandomString(15));
	}
}
