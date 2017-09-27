package genric;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VerificationUtils {
	WebDriver driver;

	public void VerificationUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifytitle(String expectedtitle) {
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedtitle);
	}
	
	

}
