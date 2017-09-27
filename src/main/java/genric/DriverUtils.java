package genric;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtils {

	private WebDriver driver;
	private WebElement we;
	private boolean blnFlag;
	private String textValue;
	private int i;

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
		driver.get(url);
	}
	
//	public string getAttributeValue() {
//		
//	}

	public void getTextofAllLinks(List<WebElement> listWebElement) {
		int totalLinks = listWebElement.size();

		for (i = 0; i <= totalLinks - 1; i++) {
			we = listWebElement.get(i);
			System.out.println(we.getText());
		}

	}
	
	public void clickOnAllLinks(List<WebElement> listWebElement) {
		int totalLinks=listWebElement.size();
		for(i=0;i<=totalLinks-1;i++) {
			we=listWebElement.get(i);
		    clickOnWebElement(we);
		    navigateBack();
		     totalLinks=listWebElement.size();
		}
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

	public void navigatetoUrl(String Url) {
		driver.navigate().to(Url);
	}

}
