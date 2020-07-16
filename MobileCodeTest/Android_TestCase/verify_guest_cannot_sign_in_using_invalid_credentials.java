package Android_TestCases.Login;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.disney.appium.common.BaseTest;
import com.disney.selenium.common.Log;
import com.google.common.base.Stopwatch;
import Android_PageObjects.Login_Android.Login_Page;
import Android_PageObjects.Tutorial_Android.Tutorial_Page;

/**
 * VerifyGuestCannotSignInUsingInvalidCredentials 
 * The purpose of this test case is to ensure that no one can login to an account without 
 * the correct account and password information, and that when invalid data is entered, 
 * an expected error message appears.
 * 
 * @author Swathi Jajula                                                                                                                                                              |                                   
 */

public class RETIRED_TEST_44371_verify_guest_cannot_sign_in_using_invalid_credentials extends BaseTest
{

    //Create an assertion object for failing test run on error
    static Assertion hardAssert = new Assertion();

    @Test
    public void VerifyGuestCannotSignInUsingInvalidCredentials_TEST() {
        try {
            
            // Create a stop-watch so that we can capture test run duration
            Stopwatch                 timer       =      Stopwatch.createUnstarted();           
            // Instantiate the needed Page Objects
            Tutorial_Page             tutorial    =  new Tutorial_Page(getAppiumDriver());
            Login_Page                login       =  new Login_Page(getAppiumDriver());
            //Expected error message
            String expectedErrorMessage = "The email and/or password do not match. Please try again.";
            
            // Grab the start time
            timer.start();
            Log.log(getAppiumDriver()).info("Starting test: VerifyGuestCannotSignInUsingInvalidCredentials_TEST() " + timer);
            
            //Dismiss the tutorial if it's found
            tutorial.dismissTutorial();
            
            // STEP 1 of 1
            
            //Click on SignIn link
            login.ClickOnsigInlink();
            
            //Enter invalid account info
            login.enterEmailId("mavis.fubar@disney.com");
            
            //Enter invalid password
            login.enterPassword("invalidPassword");
           
            //Tap on the blue enabled Sign In to Your Account button
            login.clickOnBlueEnabledSignInToYourAccountButton();
            
            //Give time for the error banner to appear in the footer 
            Thread.sleep(2000);
            
            //Verify that the expected error message is displayed
            login.verifyInvalidCredentialsBanner(expectedErrorMessage);
            
            //FINISH and CLEAN UP
            Log.log(getAppiumDriver()).info("Finished with running VerifyGuestCannotSignInUsingInvalidCredentials_TEST()");
               
            //Grab the End time
            timer.stop();
            Log.log(getAppiumDriver()).info("Test duration: " + timer);
            Log.log(getAppiumDriver()).info("Shutting down and cleaning up.");
            
        } catch (Exception ee) {
            Log.log(getAppiumDriver()).info("There was a problem: ");
            ee.printStackTrace();
            // Intentionally fail the test if any step triggers an exception
            hardAssert.assertEquals("A test step has failed: " + ee, "Expected all test steps to pass."); 
        }
}
}
