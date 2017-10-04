package genric;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import applicaionPages.ApplicationBasePage;

public class baseTest {
	
	DriverUtils DriverFunctions;
	ApplicationBasePage mainpage;
	
	@BeforeClass
	public void launchApp() {
		DriverFunctions=new DriverUtils();
		DriverFunctions.launchApp();
	}
	
	public ApplicationBasePage ApplicationPage() {
	 ApplicationBasePage basePage=PageFactory.initElements(DriverFunctions.getDriver(), ApplicationBasePage.class);
	 return basePage;
	}
	
	
	@AfterClass
	public void tearDown() {
		DriverFunctions.quitBrowser();;
	}

}
