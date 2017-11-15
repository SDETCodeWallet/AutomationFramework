package in.amazon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicaionPages.homePage;
import genric.baseTest;

class HomePageScript extends baseTest {

	@Test
	public  void searchProduct() {
	  homePage homePage= new baseTest().launchApp(); 
	  homePage.searchProduct("Samsung");
	  homePage.clickOnSerachBtn();
		

	}

}
