package genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import applicaionPages.ApplicationBasePage;

public class baseTest extends basePage {

	@BeforeMethod
	public ApplicationBasePage launchApp() {
		if (FileReader.getPropertyValue("BrowserName").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", FileReader.getPropertyValue("ChromeExePath"));
			driver = new ChromeDriver();
		} else if (FileReader.getPropertyValue("BrowserName").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FileReader.getPropertyValue("FireFoxExePath"));
			driver = new FirefoxDriver();
		} else if (FileReader.getPropertyValue("BrowserName").equalsIgnoreCase("Internet")) {
			System.setProperty("webdriver.ie.driver", FileReader.getPropertyValue("IEExePath"));
			driver = new InternetExplorerDriver();
		} else if (FileReader.getPropertyValue("BrowserName").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", FileReader.getPropertyValue("EdgeExePath"));
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get(FileReader.getPropertyValue("ApplicationUrl"));
		ApplicationBasePage basePage = PageFactory.initElements(driver, ApplicationBasePage.class);
		return basePage;
	}

	@AfterMethod
	public void ehgjh() {
		System.out.println("after mehthod");
	}

}
