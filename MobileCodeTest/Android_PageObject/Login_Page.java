package Android_PageObjects.Login_Android;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.disney.appium.common.AppiumConstants;
import com.disney.appium.common.AutomationTools;
import com.disney.appium.common.UserLoginDetails;
import com.disney.appium.common.AutomationTools.Page;
import com.disney.selenium.common.Log;
import com.disney.selenium.common.enums.Environment;

import Android_PageObjects.Common_Android.BannerHandler_Page;
import Android_PageObjects.ParkHoursAndInfo_Android.ParkInfoAndEntry_Page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_Page {
	private AppiumDriver driver;
	static Assertion hardAssert = new Assertion();

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Login_Page(final AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(
				new AppiumFieldDecorator(driver, AppiumConstants.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS), this);
	}

	/**
	 * This is the email text box
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/edittext_email")
	private MobileElement email;

	/**
	 * This is the email In Reset Password Screen
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/usernameEditTextId")
	private MobileElement emailInResetPasswordScreen;
	
	/**
	 * This is the password text box
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/edittext_password")
	private MobileElement password;

	/**
	 * This is the SignIn_IOS button
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/btn_login")
	private MobileElement sign_In;

	/**
	 * This is the Welcome_IOS Screen text
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/snowball_header_screen_name")
	private MobileElement welcome_Back_Text;

	/**
	 * This is the Sign In to your Account Enabled Button
	 */
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Sign In to Your Account']")
	private MobileElement signInToYourAccountEnabledButton;

	/**
	 * This is the dismiss button
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/btn_not_now")
	private MobileElement not_Now;

	/**
	 * This is the Create Account button
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/txt_create_an_account")
	private MobileElement createAccountButton;

	/**
	 * This is the forget password link
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/txt_forgot_pass")
	private MobileElement forgotPasswordLink;

	/**
	 * 
	 * This is the SignIn Button on the Welcome/Login screen
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/txt_signin")
	private MobileElement signInButton;

	/**
	 * show password checkbox
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/chk_box_show_password")
	private MobileElement showPassword;

	/**
	 * This is the banner box at the bottom of the screen, in which different
	 * messages can be displayed
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/banner_message")
	private MobileElement bannerFooter;

	/**
	 * This is the User is notified that maximum allowed sign-in attempt have been
	 * exceeded
	 */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Something Fishy Is Going On']")
	private MobileElement errorMsg;

	/**
	 * This is the close button displayed on the error banner displayed when the user is not able
	 * to login.
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/dismiss_banner_button")
	private MobileElement errorMsgDismissButton;

	/**
	 * This is clear text button appears if any text entered in email or fields
	 */
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='clear text']")
	private MobileElement clearTextButton;
	
	/**
     * Login Layout on Home screen.
     */ 
	@AndroidFindBy( id = "com.disney.wdw.android.debug:id/login_layout") 
	private MobileElement LoginScreen_Home_Screen;
	
	/**
	 * This is the SignIn Delay Screen
	 */
	@AndroidFindBy(xpath="//android.widget.TextSwitcher[@content-desc='Need Help Signing In?']")
	//@AndroidFindBy(id="com.disney.wdw.android.debug:id/snowball_header_screen_name")
	private MobileElement SignInDelayScreen;
	
	/**
	 * This is Top Arrow
	 */
	@AndroidFindBy(id = "com.disney.wdw.android.debug:id/pulldown_image")
	private MobileElement TopArrow;
	
	/**
	 * Login_Android(String username, String passwordString)
	 * To enter the email address and password to login into the account.
	 * The parameters are set in the LoginDetails.json file.
	 * Login_Android(String username, String passwordString) To enter the email
	 * address and password to login into the account. The parameters are set in the
	 * Logindetails.json file.
	 * 
	 * @param username
	 * @param passwordString
	 * @return
	 */
	public boolean Login(String username, String passwordString) {
		ParkInfoAndEntry_Page parkInfo = new ParkInfoAndEntry_Page(driver);
		AutomationTools.waitForElementToLoad(driver, email, 40);
		this.email.click();
		AutomationTools.SendKeys(driver, (MobileElement) this.email, username);
		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(3000);
		
		this.password.click();
		AutomationTools.swipeScreenUp(driver);
		AutomationTools.SendKeys(driver, (MobileElement) this.password, passwordString);
		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(3000);
		
		AutomationTools.swipeScreenUp(driver);
		AutomationTools.SetDelay(2000);
		AutomationTools.waitForElementToLoad(driver, this.sign_In, AppiumConstants.timeThirtySecondsinSEC);
		this.sign_In.click();
		Log.log(driver).info("Clicked on Sign In button");
		AutomationTools.SetDelay(2000);
		
		Log.log(driver).info("Checking if Welcome Back Screen Displayed.");
		this.verifyCloseWelcomeBackScreen();
		parkInfo.Park_Info_Entry();
		return true;
	}

	/**
	 * Login_Android(String username, String passwordString) To enter the email
	 * address and password to login into the account. The parameters are set in the
	 * Logindetails.json file.
	 * 
	 * @param username
	 * @param passwordString
	 * @return
	 */
	public boolean signInIncrementalProfile(String username, String passwordString) {

		AutomationTools.waitForElementToLoad(driver, email, 40);
		this.email.click();
		AutomationTools.SendKeys(driver, (MobileElement) this.email, username);
		AutomationTools.closeKeyboard(driver);
		this.password.click();
		AutomationTools.SendKeys(driver, (MobileElement) this.password, passwordString);
		AutomationTools.SetDelay(2000);
		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(2000);
		AutomationTools.swipeScreenUp(driver);
		AutomationTools.SetDelay(2000);
		this.signInToYourAccountEnabledButton.click();
		Log.log(driver).info("Checking if Welcome Back Screen Displayed.");
		return true;
	}

	/**
	 * verifyCloseWelcomeBackScreen() To check if the Welcome_IOS Back Screen is
	 * loaded after Login_Android. Clicks on Not Now button to skip setting security
	 * questions.
	 * 
	 * @return true
	 */
	public boolean verifyCloseWelcomeBackScreen() {
		try {

			AutomationTools.waitForElementToLoad(driver, this.welcome_Back_Text,AppiumConstants.timeThirtySecondsinSEC);
			Log.log(driver).info("Welcome Back Screen Displayed.");
			AutomationTools.waitForElementToLoad(driver, this.not_Now, AppiumConstants.timeThirtySecondsinSEC);
			AutomationTools.SetDelay(AppiumConstants.timeThreeSecondsinMS);
			this.not_Now.click();
			Log.log(driver).info("Clicked on Not Now.");
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	/**
	 * This method is used to verify Email Address text field
	 * 
	 * @author Sundar
	 */
	public void verifyEMailAddressTextField() {

		Log.log(driver).info("Verifying whether Email Address Text Field is present or not....");
		AutomationTools.waitForElementToLoad(driver, email, 40);
		hardAssert.assertEquals(this.email.isDisplayed(), true);
		Log.log(driver).info("Email Address Text Field is present.");
	}

	
	public void verifyPasswordField() {

		Log.log(driver).info("Verifying whether Password Field is present or not....");
		hardAssert.assertEquals(this.password.isDisplayed(), true);
		Log.log(driver).info("Password Field is present.");
	}
	
	
	public void verifyPasswordFieldIsBlank() {
		AutomationTools.waitForElementToLoad(driver, password, 40);
		String length = this.password.getText();
		hardAssert.assertEquals(length.length(), 0);
		System.out.println("password field is blank");
	}

	
	public void enterPassword(com.disney.appium.common.UserLoginDetails loginInfo) {

		// Get password from the loginInfo object
		System.out.println("Getting the password from the loginInfo objects...");
		String pw = loginInfo.getPassword();

		// Set the password on the first password entry field
		System.out.println("Setting the password as: " + pw);
		this.password.click();
		AutomationTools.SendKeys(driver, (MobileElement) password, pw);
		AutomationTools.closeKeyboard(driver);
		System.out.println("We think we set the password as: " + pw);

		AutomationTools.SetDelay(5000);

		// Click on the Sign In activated Button
		this.signInToYourAccountEnabledButton.click();
		Log.log(driver).info("Password Field is present and clicked on signin button too");
	}

	/**
	 * This method enters email id field to verify forget password
	 * 
	 * @author Ragini
	 */
	public void enterEmailId(String eMail) {

		// Enter the email address
		AutomationTools.waitForElementToLoad(driver, email, 40);
		this.email.click();
		AutomationTools.SendKeys(driver, (MobileElement) email, eMail);
		AutomationTools.closeKeyboard(driver);
		System.out.println("We think we set the email address as: " + eMail);
	}
	
	public void enterEmailIdInResetPasswordScreen(String eMail) {

		// Enter the email address
		AutomationTools.waitForElementToLoad(driver, emailInResetPasswordScreen, 40);
		this.emailInResetPasswordScreen.click();
		AutomationTools.SendKeys(driver, (MobileElement) emailInResetPasswordScreen, eMail);
		AutomationTools.closeKeyboard(driver);
		System.out.println("We think we set the email address as: " + eMail);
	}

	/**
	 * This method is used to click Forgot Password? link
	 * 
	 * @author Ragini
	 */
	public void clickForgotPasswordLink() {
		Log.log(driver).info("Forgot Password? link is present or not....");
		AutomationTools.SetDelay(AppiumConstants.timeFiveSecondsinMS);
		AutomationTools.waitAndClick(driver, forgotPasswordLink, 15);
		Log.log(driver).info("Forgot Password? link is clicked.");
	}

	/**
	 * This method verifies if the email field is blank
	 * 
	 * @author Chittranjan
	 */
	public void verifyEmailFieldIsBlank() {
		Log.log(driver).info("Verifying if the email field is blank....");
		AutomationTools.waitForElementToLoad(driver, email, 15);
		String eMail = this.email.getText();
		hardAssert.assertEquals(eMail.length(), 0);
		Log.log(driver).info("The email field on Login Page is defaulted to blank....");
	}

	/**
	 * This method is to enter password
	 * 
	 * @param string
	 * 
	 * @author Monisha
	 */
	public void enterPassword(String pwd) {
		AutomationTools.waitForElementToLoad(driver, password, 40);
		this.password.click();
		AutomationTools.SendKeys(driver, (MobileElement) this.password, pwd);
		AutomationTools.closeKeyboard(driver);
		Log.log(driver).info("Entered Password in the password text field " + pwd);
	}
	
	/**
	 * This method is to clear email emtered
	 * 
	 * @author manasa.suryanarayana
	 */
	public void clearEmailField() {
		AutomationTools.waitForElementToLoad(driver, email, 40);
		this.email.click();
		this.email.clear();
		AutomationTools.closeKeyboard(driver);
		Log.log(driver).info("email field is cleared");
	}

	/**
	 * This method is used to verify whether the password field is encrypted or not
	 * 
	 * @param boolean
	 * 
	 * @author Monisha
	 */
	public void verifyPasswordFieldIsEncrypted(boolean encrypted) {
		if (encrypted) {
			hardAssert.assertTrue(
					driver.findElement(By.xpath("//DisneyEditText[@password='" + encrypted + "']")).isDisplayed(),
					"Password field is de-encrypted");
			Log.log(driver).info("Password field is encrypted");
		} else {
			hardAssert.assertTrue(
					driver.findElement(By.xpath("//DisneyEditText[@password='" + encrypted + "']")).isDisplayed(),
					"Password field is encrypted");
			Log.log(driver).info("Password field is de-encrypted");
		}

	}

	/**
	 * method to click on show password checkbox
	 * 
	 * @author Monisha
	 */

	public void clickOnShowPassword() {
		AutomationTools.waitForElementToLoad(driver, showPassword, 10);
		this.showPassword.click();
		Log.log(driver).info("Show password is clicked");

	}

	/**
	 * Method to click on sigInLink in welcome page
	 * 
	 * @author Gissela
	 */
	public void ClickOnsigInlink() {
		AutomationTools.waitForElementToLoad(driver, signInButton, 60);
		Assert.assertTrue(signInButton.isDisplayed(), "Renewal Landing Header not found");
		Log.log(driver).info("Verified RenewalLanding");
		signInButton.click();
	}

	/**
	 * This method clicks on the blue enabled "Sign In to Your Account" button.
	 * 
	 * @author Larry Conley 11/21/17 -- MDX 4.10
	 */
	public void clickOnBlueEnabledSignInToYourAccountButton() {
		System.out.println("Trying to click on the blue enabled \"Sign In to Your Account\" button...");
		this.signInToYourAccountEnabledButton.click();
		System.out.println("We think we clicked on the blue enabled \"Sign In to Your Account\" button.");
	}

	/**
	 * This method verifies that an error dialog appears when an invalid user name
	 * and or password are used during login. And then checks to verify that the
	 * expected error dialog is displayed as well.
	 * 
	 * @Author Larry Conley 11/22/17 -- MDX 4.10
	 * @param String
	 *            -- the expected error message for invalid credentials
	 */
	public void verifyInvalidCredentialsBanner(String expectedErrorMessage) {
		String actualErrorMessage = "";
		AutomationTools.waitForElementToLoad(driver, bannerFooter, 60);
		System.out.println("Verifying that the banner footer error message is displayed...");
		Assert.assertTrue(this.bannerFooter.isDisplayed());
		System.out.println("The banner footer error message is verified as being displayed!");

		System.out.println(
				"Verifying that the excpected invalid credentials dialog has been displayed and is correct...");
		actualErrorMessage = this.bannerFooter.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		System.out.println("The expected invalid credentials error dialog has been verified as displayed and correct!");
	}

	/**
	 * This method is used to verify Create Account Button
	 * 
	 * @author Sundar
	 */
	public void verifyCreateAccountButton() {

		Log.log(driver).info("Verifying whether Create Account Button is present or not....");
		hardAssert.assertEquals(this.createAccountButton.isDisplayed(), true);
		Log.log(driver).info("Create Account Button is present.");
	}

	/**
	 * This method is used to verify Forgot Password? link
	 * 
	 * @author Sundar
	 */
	public void verifyForgotPasswordLink() {

		Log.log(driver).info("Verifying whether Forgot Password? link is present or not....");
		hardAssert.assertEquals(this.forgotPasswordLink.isDisplayed(), true);
		Log.log(driver).info("Forgot Password? link is present.");
	}

	/**
	 * clickCreateAccount()
	 * 
	 * @author Sundar
	 * @return true clicked on Create Account button is clicked.
	 */
	public boolean clickCreateAccount() {
		AutomationTools.waitForElementToLoad(driver, this.createAccountButton, AppiumConstants.timeThirtySecondsinSEC);
		this.createAccountButton.click();
		Log.log(driver).info("Create Account Clicked.");
		return true;
	}

	/*
	 * This method clicks on the SignIn_IOS button
	 * 
	 * @author Vinil Nandella
	 * 
	 * @version 1.0(09/14/2017) -- MDX 4.8
	 */
	public void clickOnsignInButton() throws InterruptedException {
		AutomationTools.swipeScreenUp(driver);
		AutomationTools.waitForElementToLoad(driver, this.sign_In, AppiumConstants.timeThirtySecondsinSEC);
		Log.log(driver).info("Clicking on the \"Sign In\" button...");
		Thread.sleep(1000);
		this.sign_In.click();
		AutomationTools.SetDelay(3000);
		Log.log(driver).info("Clicked on the \"Sign In\" button");
	}

	/**
	 * This method logs in after a log off
	 * 
	 * @param String
	 *            newPassword //This is the new password to enter in the password
	 *            text field after changing the password
	 */
	public void signinAfterSignOut(String newPassword) {
		ParkInfoAndEntry_Page parkInfo = new ParkInfoAndEntry_Page(driver);
		Log.log(driver).info("Trying to enter the new changed password in the password text field....");
		this.password.click();
		this.password.sendKeys(newPassword);
		Log.log(driver).info("Entered new Password in the password text field");
		AutomationTools.closeKeyboard(driver);
		Log.log(driver).info("Trying to click on Sign In button...");
		this.sign_In.click();
		Log.log(driver).info("Clicked on Sign In button");
		Log.log(driver).info("Checking if Welcome Back Screen Displayed.");
		this.verifyCloseWelcomeBackScreen();
		parkInfo.Park_Info_Entry();
	}

	/**
	 * validateLoginUser() This method is used to validate a "User" object for login
	 * that's being logged in with the AutomationTools.createAccount() method. It
	 * checks to see if the user object is correctly setup with an email address and
	 * password and then fails the test if either is missing.
	 * 
	 * @author Ragini
	 */
	public void validateLoginUser(UserLoginDetails User) throws Exception {
		System.out.println("Environment set to: " + Environment.getEnvironmentName());
		if (User.getUserEmail().equals("") || User.getPassword().equals("")) {
			throw new IllegalArgumentException("User creation process failed");
		}

	}

	/**
	 * This method takes the data from the JSON file(Logindetails.json), enters
	 * email id and password in the sign page fields.
	 * 
	 * @author Akash Akula Version 1.0(09/1/2017) -- MDX 4.8
	 */
	public void signIn(com.disney.appium.common.UserLoginDetails loginInfo) {

		// Get the email address from the loginInfo object
		String eMail = loginInfo.getUserEmail();
		System.out.println("Setting email as: " + eMail);

		// Enter the email address
		AutomationTools.waitForElementToLoad(driver, email, 20);
		AutomationTools.SendKeys(driver, (MobileElement) email, eMail);
		AutomationTools.closeKeyboard(driver);
		System.out.println("We think we set the email address as: " + eMail);

		// Get password from the loginInfo object
		System.out.println("Getting the password from the loginInfo objects...");
		String pw = loginInfo.getPassword();

		// Set the password on the first password entry field
		System.out.println("Setting the password as: " + pw);
		AutomationTools.waitForElementToLoad(driver, password, 20);
		AutomationTools.SendKeys(driver, (MobileElement) password, pw);
		AutomationTools.closeKeyboard(driver);
		System.out.println("We think we set the password as: " + pw);
		AutomationTools.SetDelay(AppiumConstants.timeThreeSecondsinMS);
		AutomationTools.swipeScreenUp(driver);
		AutomationTools.SetDelay(3000);

		// Click on the Sign In activated Button
        AutomationTools.waitAndClick(driver, signInToYourAccountEnabledButton, 15);
		ParkInfoAndEntry_Page parkInfo = new ParkInfoAndEntry_Page(driver);
		parkInfo.Park_Info_Entry();

	}

	/**
	 * This method verifies that an error dialog appears when an invalid user name
	 * and or password are used during login. And then checks to verify that the
	 * expected error dialog is displayed as well.
	 * 
	 * @Author Larry Conley 11/22/17 -- MDX 4.10
	 * @param String -- the expected error message for invalid credentials
	 */
	public void verifyErrorMsgAndNotSignedIn()
	{
	    AutomationTools.waitForElementToLoad(driver, errorMsg, 60);
	    System.out.println("Verifying that the error message is displayed...");
	    Assert.assertTrue(this.errorMsg.isDisplayed());
	    System.out.println("The error msg is "+errorMsg.getText());
	    AutomationTools.tapBack(driver);
	   	   	}
	
	/**
	 * This method is to enter password for given number of  times
	 * 
	 * @param string
	 */
	public void EnterPasswordforitimes(String pwd, int loopcount) {
		for (int i = 1; i <= loopcount; i++) {
			AutomationTools.waitForElementToLoad(driver, password, 40);
			this.password.click();
			AutomationTools.SendKeys(driver, (MobileElement) this.password, pwd);
			AutomationTools.closeKeyboard(driver);
			Log.log(driver).info("Entered Password in the password text field " + pwd);
			AutomationTools.swipeScreenUp(driver, Page.FirstThrid);
			AutomationTools.SetDelay(AppiumConstants.timeThreeSecondsinMS);
			clickOnBlueEnabledSignInToYourAccountButton();
			 int screen = driver.findElements(By.id("snowball_header_screen_name")).size();
			if (screen > 0) {
				verifySignInDelayScreen();
				Log.log(driver).info("SignIn Delay Screen is displayed");
				AutomationTools.tapBack(driver);
				break;
			}else{
				BannerHandler_Page banner = new BannerHandler_Page(driver);
				banner.clickOnDismissBanner();
			}
			}
	}

	/**
	 * This method is used to verify SignIn Delay Screen
	 */
	public boolean verifySignInDelayScreen() throws TimeoutException {

		Log.log(driver).info("Verifying whether SignIn Delay Screen is Displayed or not....");
		Assert.assertEquals(this.SignInDelayScreen.isDisplayed(), true);
		Log.log(driver).info("SignIn Delay Screen is displayed.");
		return true;
	}

	/**
	 * This method is used to click on top arrow
	 */
	public void ClickonTopArrow() {
		Log.log(driver).info("Trying to click on Top Arrow...");
		this.TopArrow.click();
		Log.log(driver).info("Clicked on Top Arrow");
	}
	
	/**
     * This method is to enter password
     * @param string 
     * 
     * @author Monisha
     */
	public void enterPasswordandclickonSignIn(String pwd) {
		this.password.click();
		AutomationTools.SendKeys(driver, (MobileElement) this.password, pwd);
		AutomationTools.closeKeyboard(driver);
		//AutomationTools.SetDelay(AppiumConstants.timeThreeSecondsinMS);
		//Log.log(driver).info("Entered Password in the password text field "+pwd);
	    this.signInToYourAccountEnabledButton.click();
	}
  
	/**
	 * This method takes the data from the JSON file(Logindetails.json), enters
	 * email id and password in the sign page fields.
	 * 
	 * @author manasa.suryanarayana Version 1.0(09/1/2017) -- MDX 4.8
	 */
	public void signInWithoutVerification(com.disney.appium.common.UserLoginDetails loginInfo) {

		// Get the email address from the loginInfo object
		String eMail = loginInfo.getUserEmail();
		System.out.println("Setting email as: " + eMail);

		// Enter the email address
		this.email.click();
		AutomationTools.SendKeys(driver, (MobileElement) email, eMail);
		AutomationTools.closeKeyboard(driver);
		System.out.println("We think we set the email address as: " + eMail);

		// Get password from the loginInfo object
		System.out.println("Getting the password from the loginInfo objects...");
		String pw = loginInfo.getPassword();

		// Set the password on the first password entry field
		System.out.println("Setting the password as: " + pw);
		this.password.click();
		AutomationTools.SendKeys(driver, (MobileElement) password, pw);
		AutomationTools.closeKeyboard(driver);
		System.out.println("We think we set the password as: " + pw);

		AutomationTools.SetDelay(3000);

		AutomationTools.swipeScreenUp(driver);
		AutomationTools.SetDelay(5000);
		// Click on the Sign In activated Button
		this.signInToYourAccountEnabledButton.click();
		AutomationTools.SetDelay(5000);
	}

	/**
	 * This method is used to verify and click on the close button displayed on the error banner when user
	 * is not able to login.
	 * @author prashanth.jayaraman
	 */
	public boolean clickCloseButtonOnErrorBanner(){
		AutomationTools.SetDelay(AppiumConstants.timeThreeSecondsinMS);
		if(errorMsgDismissButton.isDisplayed() & errorMsgDismissButton.isEnabled()){
			errorMsgDismissButton.click();
			AutomationTools.SetDelay(AppiumConstants.timeThreeSecondsinMS);
			Log.log(driver).info("Clicked on the close button on the error banner.");
			return true;
		}else{
			Log.log(driver).info("Error occured while clicking on the close button on the error banner.");
			return false;
		}
	}
	
	/**
	 * This method validates if Sign In Button is disabled
	 * @author prashanth.jayaraman
	 */
	public boolean verifySignInButtonDisabled(){	
		AutomationTools.swipeUpDeviceScreen(driver);
		if(sign_In.isDisplayed()){
			hardAssert.assertFalse(sign_In.isEnabled(), "Error occured while Verified that the Sign In button is displayed and is Disabled.");
			Log.log(driver).info("Verified that the Sign In button is displayed and is Disabled.");
			return true;
		}
		else
		{
			Log.log(driver).info("Error occured while verifying that the Sign In button is displayed and is Disabled.");
			return false;
		}
	}

	/**
	 * This method clicks on clear text button that appears in the email or password fields after entering some text.
	 */
	public void clickOnClearTextButton()
	{
		Log.log(driver).info("Trying to click on clear text button.....");
		this.email.click();
		Assert.assertTrue(this.clearTextButton.isDisplayed());
		this.clearTextButton.click();
		Log.log(driver).info("Clicked on clear text button");

	}

	/**
 	 * This method clicks on ForgotPassword Link
 	 * 
 	 * @author Chittranjan
 	 */
 	public void clickOnForgotPasswordLink() {
 
 		Log.log(driver).info("Clicking on Forgot Password Link....");
 		// Click on the Sign In activated Button
 		this.forgotPasswordLink.click();
 	}
 	
 	
 	/**
 	 * This method will enter the incorrect password continuously for 3 consecutive times
 	 * 
 	 * @author Thiagarajan
 	 */
 	public void enterIncorrectPasswordMultipleTimes() {
 		Log.log(driver).info("Entering the Incorrect password for 3 times....");
 		this.password.clear();
 		this.enterPassword("zfasfa");
 		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(3000);
 		this.sign_In.click();
 		clickCloseButtonOnErrorBanner();
 		this.password.clear();
 		this.enterPassword("zfasfa");
 		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(3000);
 		this.sign_In.click();
 		clickCloseButtonOnErrorBanner();
 		this.password.clear();
 		this.enterPassword("zfasfa");
 		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(3000);
 		this.sign_In.click();
 		Log.log(driver).info("Entered the Incorrect password for 3 times....");
 	}
 	
 	/**
	 * Login_Android(String username, String passwordString) To enter the email
	 * address and password to login into the account. The parameters are set in the
	 * Logindetails.json file.
	 * 
	 * @param username
	 * @param passwordString
	 * @return
	 */
	public boolean LoginWithoutVerifyWelcomeScreen(String username, String passwordString) {
		ParkInfoAndEntry_Page parkInfo = new ParkInfoAndEntry_Page(driver);
		AutomationTools.waitForElementToLoad(driver, email, 40);
		this.email.click();
		AutomationTools.SendKeys(driver, (MobileElement) this.email, username);
		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(3000);
		this.password.click();
		AutomationTools.SendKeys(driver, (MobileElement) this.password, passwordString);
		AutomationTools.closeKeyboard(driver);
		AutomationTools.SetDelay(3000);
		AutomationTools.swipeScreenUp(driver);
		AutomationTools.SetDelay(2000);
		AutomationTools.waitForElementToLoad(driver, this.sign_In, AppiumConstants.timeThirtySecondsinSEC);
		this.sign_In.click();
		Log.log(driver).info("Clicked on Sign In button");
		Log.log(driver).info("Checking if Welcome Back Screen Displayed.");
		return true;
	}
	
	/**
 	 * This method is used to enter invalid password continuously for 2 times
 	 * @author Karthikha
 	 * @param pwd - Password
 	 * @param errorMsg - Expected Error Message
 	 * @param size - Number of times to enter invalid password
 	 */
 	public void enterInvalidPasswordMultipleTimes(String pwd,String errorMsg,int size) {
 		Log.log(driver).info("Entering the Incorrect password for 2 times....");
 		for(int i=1;i<=size;i++){
 	 		this.enterPassword(pwd);
 			AutomationTools.SetDelay(3000);
 	 		this.sign_In.click();
 	 		this.verifyInvalidCredentialsBanner(errorMsg);
 	 		clickCloseButtonOnErrorBanner();
 		}
 		Log.log(driver).info("Entered the Incorrect password for "+size+"times....");
 	}
 	
 	/**
 	 * This Method is used to verify that Email is showed
 	 * @author Karthikha
 	 * @param email - Guest UserId
 	 */
 	public void verifyEmailShowed(String email){
 		Log.log(driver).info("Trying to verify the Email is Showed");
 		boolean found = driver.findElement(By.xpath("//android.widget.EditText[@text='" + email + "']")).isDisplayed();
 		hardAssert.assertTrue(found,"Given Email is not showed");
 		Log.log(driver).info("Verified Email");
 	}
 	
 	/**
 	 * This Method is to verify that error banner disappeared
 	 * @author Karthikha
 	 * @param value - True or False
 	 */
 	public void verifyErrorBannerDisappear(boolean value){
 		Log.log(driver).info("Trying to verify that Error Banner has been disappeared");
 		boolean bannerFound = true;
 		try{
 		bannerFound = this.errorMsgDismissButton.isDisplayed();
 		Log.log(driver).info("Verified that Error Banner is displayed");
 		}catch(NoSuchElementException ex){
 		bannerFound = false;
 		Log.log(driver).info("Verified that Error Banner has been disappeared");
 		}
 		hardAssert.assertEquals(bannerFound, value);
 	}
 	
 	/**
 	 * This Method is used to click Not Now button
 	 * @author Karthikha
 	 */
 	public void clickNotNow() {
		AutomationTools.waitForElementToLoad(driver, this.not_Now, AppiumConstants.timeThirtySecondsinSEC);
		this.not_Now.click();
		Log.log(driver).info("Clicked on Not Now.");
	}
 	
	/**
     * This Verify Login screen is displayed
     */
	public void verifyLoginScreen_Displayed() {
		Log.log(driver).info("Checking if the Login Layout is present");
		AutomationTools.waitForElementToLoad(driver, this.LoginScreen_Home_Screen, 10);
		Assert.assertEquals(true, this.LoginScreen_Home_Screen.isDisplayed(), "Login Layout is not displayed");
		Log.log(driver).info( "LoginScreen on Home Tab is displayed as expected")	;	
	}
	
}
	
