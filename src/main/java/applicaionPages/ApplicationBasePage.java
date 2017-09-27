package applicaionPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genric.DriverUtils;


public class ApplicationBasePage extends DriverUtils{
	
	@FindBy(xpath="//img[@title='Flipkart']")
	private WebElement appTitle;
	
	public void appTitleIsDisplayed() {
	  
	}

}
