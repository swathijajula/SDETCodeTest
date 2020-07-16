package IOS_TestCases.Login;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.disney.appium.common.AutomationTools;
import com.disney.appium.common.BaseTest;
import com.disney.selenium.common.Log;
import com.google.common.base.Stopwatch;

import IOS_PageObjects.Alerts_IOS.IOSAlerts_Page;
import IOS_PageObjects.CreateAccount_IOS.CreateAccount_Page;
import IOS_PageObjects.Welcome_IOS.Welcome_Page;

/**
 * Purpose: This test case verifies the ability to navigate to the register or login page
 * from the non-logged in dashboard
 * 
 * @author Swathi Jajula
 */
public class TEST_36840_register extends BaseTest {
	static Assertion hardAssert = new Assertion();
	@Test
	public void register()  {
		try
		{
			// Step 1
			Log.log(getAppiumDriver()).info( "Starting the TEST_36840_register() test case..." );
			// Create a stop-watch so that we can capture test duration
			Stopwatch timer = Stopwatch.createUnstarted();

			//-----CLASED USED-----//
			IOSAlerts_Page               alert           = new IOSAlerts_Page (getAppiumDriver());
			Welcome_Page              welcome         = new Welcome_Page(getAppiumDriver());
			CreateAccount_Page           create          = new CreateAccount_Page(getAppiumDriver());

			//-----TEST TIME-----//
			// Grab the start time
			timer.start();
			Log.log(getAppiumDriver()).info("Starting test: " + timer);

			//-----TUTORIAL AND ALERTS-----//
			// Click Allow on all initial alerts and then close the tutorial if it exists
			alert.acceptAlertsCloseTutorial();
			AutomationTools.SetDelay(3000);

			//-----DETAIL STEPS-----//
			// Step 1
			Log.log(getAppiumDriver()).info("Click on create account button");
			welcome.clickOnCreateAccountButton();
			Log.log(getAppiumDriver()).info("Verify create account page displayed");
			create.verifyCreateAccountPageIsDisplayed();

			//Step 2
			Log.log(getAppiumDriver()).info("Click on dismiss header");
			create.clickOnCloseButton();
			Log.log(getAppiumDriver()).info("Validate signin dashboard is displayed");
			welcome.verifySignInButton();
			
			//-----FINISH-----//
			Log.log(getAppiumDriver()).info("----- Verified the ability to navigate to the register or login page from the non-logged in dashboard -----");
			Log.log(getAppiumDriver()).info("*****TEST SUCCESSFULLY PASSED*****");

			//FINISH and CLEAN UP
			System.out.println("Finished with TEST_36840_register() test run!");

			// Grab the End time
			timer.stop();
			System.out.println("Test duration: " + timer);

			//Clean up
			System.out.println("Shutting down and cleaning up.");
		}
		catch (Exception ee)
		{
			Log.log(getAppiumDriver()).info("There was a problem: ");
			ee.printStackTrace();
			//Intentionally fail the test if any step triggers an exception
			hardAssert.assertEquals("A test step has failed: " + ee, "Expected all test steps to pass."); 
		}
	}
}