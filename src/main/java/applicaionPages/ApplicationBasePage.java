package applicaionPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genric.baseTest;

public class ApplicationBasePage {

	@FindBy(xpath = "//img[@title='Flipkart']")
	private WebElement appTitle;
	
	@FindBy(xpath = "//a[text()='Signup']")
	private WebElement loginLink;

	public void fn_ClickOnSignUpLink() {
		
	}

}
