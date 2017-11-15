package applicaionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric.WebDriverUtils;

public class homePage {

	WebDriverUtils webDriverUtils;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	public void searchProduct(String serachProduct) {
		webDriverUtils.sendkeys(searchBox,serachProduct);
	}
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchBtn; 
	
	public void clickOnSerachBtn() {
		webDriverUtils.clickOnWebElement(searchBtn);
	}

	@FindBy(xpath = "//a[@id='nav-link-yourAccount']")
	private WebElement signInBtn;

	public SignInPage clickOnSignInBtn() {
		webDriverUtils.clickOnWebElement(signInBtn);
		SignInPage signInPage = PageFactory.initElements(webDriverUtils.driver, SignInPage.class);
		return signInPage;
	}

}
