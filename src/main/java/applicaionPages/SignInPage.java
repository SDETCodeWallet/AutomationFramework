package applicaionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import genric.WebDriverUtils;

public class SignInPage extends WebDriverUtils {

	public SignInPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement userName;

	public void fn_EnterUserName() {
		sendkeys(userName, "");

	}

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement passWord;

	public void fn_EnterPassword() {
		sendkeys(passWord, "");

	}

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement loginBtn;

	public void fn_ClickOnLoginButton() {
		clickOnWebElement(loginBtn);
	}

	public void userLogin() {
		fn_EnterUserName();
		fn_EnterPassword();
		fn_ClickOnLoginButton();
	}
}
