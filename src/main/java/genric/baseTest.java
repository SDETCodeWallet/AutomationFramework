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

public class baseTest implements Constants {
	WebDriverUtils test; 

	@BeforeMethod
	public homePage main() {
		if (BROWSERNAME.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", CHROMEEXE);
			test.driver = new ChromeDriver();
		} else if (BROWSERNAME.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", FIREFOXEXE);
			test.driver = new FirefoxDriver();
		} else if (BROWSERNAME.equalsIgnoreCase("Internet")) {
			System.out.println("in");
			System.setProperty("webdriver.ie.driver", IEEXE);
			test.driver = new InternetExplorerDriver();
		} else if (BROWSERNAME.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", EDGEEXE);
			test.driver = new EdgeDriver();
		}
		test.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		test.driver.get(APPLICATIONURL);
		test.driver.manage().window().maximize();
		WebDriverUtils.takeScreenShot("C:\\Users\\shubhamg\\git\\AutomationFramework");
		homePage basePage = PageFactory.initElements(test.driver, homePage.class);
		
		return basePage;

	}

	

	@Test
	public void test1() {
		System.out.println("pass");
	}

	@AfterMethod
	public void tearDown() {
		test.driver.close();
	}

}
