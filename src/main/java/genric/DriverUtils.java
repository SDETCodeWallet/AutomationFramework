package genric;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DriverUtils {

	private WebDriver driver;
	private WebElement we;
	private boolean blnFlag;
	private String textValue;
	private int i;
	FileReader filereader;

	public String browser = filereader.getPropertyValue("BrowserName");

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver launchApp() {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", filereader.getPropertyValue("ChromeExePath"));
			setDriver(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("Internet")) {
			System.out.println("insode");
			System.setProperty("webdriver.ie.driver", filereader.getPropertyValue("IEExePath"));
			setDriver(new InternetExplorerDriver());
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", filereader.getPropertyValue("FireFoxExePath"));
			setDriver(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", filereader.getPropertyValue("EdgeExePath"));
			setDriver(new EdgeDriver());
		}
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		getDriver().get(filereader.getPropertyValue("ApplicationUrl"));
		return getDriver();
	}

	public boolean IsEnabled(WebElement we) {
		blnFlag = we.isEnabled();
		return blnFlag;
	}

	public boolean IsSelected(WebElement we) {
		blnFlag = we.isSelected();
		return blnFlag;
	}

	public boolean IsDisplayed(WebElement we) {
		blnFlag = we.isDisplayed();
		return blnFlag;
	}

	public void clickOnWebElement(WebElement we) {
		blnFlag = IsEnabled(we);
		if (blnFlag = true) {
			we.click();
		} else {
			System.err.println("Button should be enabled");
		}

	}

	public void senkeys(WebElement we, String input) {
		blnFlag = IsDisplayed(we);
		if (blnFlag = true) {
			we.clear();
			we.sendKeys(input);
		} else {
			System.err.println("Field Should displayed on page");
		}

	}

	public String getText(WebElement we) {
		textValue = we.getText();
		return textValue;
	}

	public void getUrl(String url) {
		getDriver().get(url);
	}

	public String getAttributeValue(WebElement we, String attributeName) {
		String attributeValue = we.getAttribute(attributeName);
		return attributeValue;
	}

	public void getTextofAllLinks(List<WebElement> listWebElement) {
		int totalLinks = listWebElement.size();

		for (i = 0; i <= totalLinks - 1; i++) {
			we = listWebElement.get(i);
			System.out.println(we.getText());
		}

	}

	public void clickOnAllLinks(List<WebElement> listWebElement) {
		int totalLinks = listWebElement.size();
		for (i = 0; i <= totalLinks - 1; i++) {
			we = listWebElement.get(i);
			clickOnWebElement(we);
			navigateBack();
			totalLinks = listWebElement.size();
		}
	}

	public void navigateBack() {
		getDriver().navigate().back();
	}

	public void navigateForward() {
		getDriver().navigate().forward();
	}

	public void navigateRefresh() {
		getDriver().navigate().refresh();
	}

	public void navigatetoUrl(String Url) {
		getDriver().navigate().to(Url);
	}

	public void quitBrowser() {
		getDriver().quit();
	}

	public void closeBrowser() {
		getDriver().close();
	}

}
