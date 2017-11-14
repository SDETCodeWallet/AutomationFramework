package genric;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverUtils {

	protected static WebDriver driver;
	private WebElement we;
	private boolean blnFlag;
	private String textValue;
	private int i;

	public WebDriverUtils(WebDriver driver) {
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

	public void sendkeys(WebElement we, String input) {
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
		driver.get(url);
	}

	public String getAttributeValue(WebElement we, String attributeName) {
		String attributeValue = we.getAttribute(attributeName);
		return attributeValue;
	}

	public void getTextofAllLinks(List<WebElement> listWebElement) {
		for (WebElement we : listWebElement) {
			System.out.println(getText(we));
		}

	}

	public void clickOnAllLinks(List<WebElement> listWebElement) {
		int totalLinks = listWebElement.size();
		for (WebElement we : listWebElement) {
			clickOnWebElement(we);
			navigateBack();
		}
	}

	public void navigateToUrl(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateRefresh() {
		driver.navigate().refresh();
	}

	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	public void switchToFrame(WebElement we) {
		driver.switchTo().frame(we);
	}
	
	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId); 
	}
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();  
	}
	
	public void acceptPopUp() {
		driver.switchTo().alert().accept();
	}
	
	public void dismissPopUp() {
		driver.switchTo().alert().dismiss();
	}
	
	public String getPopUpText() {
		return driver.switchTo().alert().getText(); 
	}
	
	public void sendKeysInPopUp(String inputValue) {
		driver.switchTo().alert().sendKeys(inputValue);
	}


	public static void takeScreenShot(String srcDestinationPath) {
		EventFiringWebDriver eFiringDriver = new EventFiringWebDriver(driver);
		File srcImage = eFiringDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcImage, new File(srcDestinationPath+"\\.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeBrowser() {
		driver.close();
	}

}
