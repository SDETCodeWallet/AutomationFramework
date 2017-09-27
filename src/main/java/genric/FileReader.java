package genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

	public static void main(String... args) {
		System.out.println(getPropertyValue("ApplicationUrl"));
	}
}
