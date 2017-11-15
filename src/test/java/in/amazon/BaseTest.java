package in.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicaionPages.homePage;
import genric.Constants;
import genric.WebDriverUtils;

public class BaseTest implements Constants {
	WebDriverUtils webUtils;
	
	@BeforeMethod
	public homePage launchApp() {

	if (BROWSERNAME.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", CHROMEEXE);
		webUtils.driver = new ChromeDriver();
	} else if (BROWSERNAME.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", FIREFOXEXE);
		webUtils.driver = new FirefoxDriver();
	} else if (BROWSERNAME.equalsIgnoreCase("Internet")) {
		System.out.println("in");
		System.setProperty("webdriver.ie.driver", IEEXE);
		webUtils.driver = new InternetExplorerDriver();
	} else if (BROWSERNAME.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", EDGEEXE);
		webUtils.driver = new EdgeDriver();
	}
	webUtils.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	webUtils.driver.get(APPLICATIONURL);
	homePage basePage = PageFactory.initElements(webUtils.driver, homePage.class);

	return basePage;

}

@Test
public void test1() {
	System.out.println("pass");
}

@AfterMethod
public void tearDown() {
	WebDriverUtils.driver.close();
}
}
