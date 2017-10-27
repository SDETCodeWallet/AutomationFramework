package genric;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public  class basePage {

	protected WebDriver driver;
	private WebElement we;
	private boolean blnFlag;
	private String textValue;
	private int i;
	FileReader filereader;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
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

	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	public void takeScreenShot(File srcDestinationPath) {
		EventFiringWebDriver eFiringDriver = new EventFiringWebDriver(driver);
		File srcImage = eFiringDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcImage, srcDestinationPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
