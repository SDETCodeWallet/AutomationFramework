package applicaionPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric.WebDriverUtils;
import genric.baseTest;

public class homePage extends WebDriverUtils {

	public homePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	public void searchProduct() {
		sendkeys(searchBox, "Motorola Phone");
	}

	@FindBy(xpath = "//a[@id='nav-link-yourAccount']")
	private WebElement signInBtn;

	public SignInPage clickOnSignInBtn() {
		clickOnWebElement(signInBtn);
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		return signInPage;
	}

}
