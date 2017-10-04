package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FileReader {

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

	
}
