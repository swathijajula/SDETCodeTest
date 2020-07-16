package Android_TestCases.Login;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.disney.appium.common.AutomationTools;
import com.disney.appium.common.BaseTest;
import com.disney.selenium.common.Log;
import com.google.common.base.Stopwatch;

import Android_PageObjects.Login_Android.Login_Page;
import Android_PageObjects.Tutorial_Android.Tutorial_Page;

/**
 * Purpose: This test case verifies if the error banner is displayed as expected
 * when we enter invalid email or password and symbols. 
 * incorrectemail_and_password_input
 *
 * @author Swathi Jajula
 */
public class TEST_49077_incorrectemail_and_password_input extends BaseTest {

	static Assertion hardAssert = new Assertion();

	@Test
	public void TEST_incorrectemail_and_password_input() {

		try {
			Log.log(getAppiumDriver()).info("Starting the TEST_45124_MDXAndroidInitialLogintotheApp() test case...");

			// Page Objects
			Stopwatch timer = Stopwatch.createUnstarted();
			Tutorial_Page tuto = new Tutorial_Page(getAppiumDriver());
			Login_Page login = new Login_Page(getAppiumDriver());
			String invalidEmail = "abc@gmail.com";
			String invalidPassword = "password";
			String expectedErrorMessage = "The email and/or password do not match. Please try again.";

			// Create a stop-watch so that we can capture test duration
			timer.start();
			Log.log(getAppiumDriver()).info("Starting test: " + timer);

			// Launch the WDW application Verify and dismissing Tutorial
			// Step 1
			// Dismiss the tutorial if it's found
			tuto.dismissTutorial();

			// Step 2 & 3
			Log.log(getAppiumDriver()).info(
					"From dashboard user taps the email, passwords fields and sends invalid inputs and then clicks on sign in CTA");
			login.LoginWithoutVerifyWelcomeScreen(invalidEmail, invalidPassword);

			Log.log(getAppiumDriver()).info("User verifies if arised error message is as expected");
			login.verifyInvalidCredentialsBanner(expectedErrorMessage);

			// Step 4
			Log.log(getAppiumDriver()).info("User dismisses error banner");
			login.clickCloseButtonOnErrorBanner();
			AutomationTools.swipeToBottomOfPage(getAppiumDriver());

			Log.log(getAppiumDriver())
					.info("User verifies if error banner is dismissed and sign In button is in disabled state");
			login.verifyErrorBannerDisappear(false);
			login.verifySignInButtonDisabled();

			// Grab the End time
			timer.stop();
			Log.log(getAppiumDriver()).info("Test duration: " + timer);
			Log.log(getAppiumDriver()).info("Shutting down and cleaning up.");

			// FINISH and CLEAN UP
			Log.log(getAppiumDriver()).info("Finished with TEST_49077_incorrectemail_and_password_input test run!");

		} catch (Exception ee) {

			Log.log(getAppiumDriver()).info("There was a problem: ");
			ee.printStackTrace();

			// Intentionally fail the test if any step triggers an exception
			hardAssert.assertEquals("A test step has failed: " + ee, "Expected all test steps to pass.");

		}
	}
}
