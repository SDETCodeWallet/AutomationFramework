package genric;

import org.testng.Assert;

public class VerificationUtils {

	public void verifyTextIsDisplayed(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);
	}

	public void assertTrue(boolean bln, String message) {
		assertTrue(bln, message);
	}

	public void assertFalse(boolean condition, String message) {
		assertFalse(condition, message);
	}

	public void verifyBooleanEqual(boolean actual, boolean expected) {
		Assert.assertEquals(actual, expected);
	}

}
