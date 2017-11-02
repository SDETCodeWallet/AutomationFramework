package genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicaionPages.homePage;

public class baseTest extends homePage implements Constants {

	public baseTest(WebDriver driver) {
		super(driver);
	}

	public homePage launchApp() {
		if (BROWSERNAME.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", CHROMEEXE);
			driver = new ChromeDriver();
		} else if (BROWSERNAME.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FIREFOXEXE);
			driver = new FirefoxDriver();
		} else if (BROWSERNAME.equalsIgnoreCase("Internet")) {
			System.out.println("in");
			System.setProperty("webdriver.ie.driver", IEEXE);
			driver = new InternetExplorerDriver();
		} else if (BROWSERNAME.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", EDGEEXE);
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get(APPLICATIONURL);
		homePage basePage = PageFactory.initElements(driver, homePage.class);
		return basePage;
	}

	public void ehgjh() {
		System.out.println("after mehthod");
	}

}
