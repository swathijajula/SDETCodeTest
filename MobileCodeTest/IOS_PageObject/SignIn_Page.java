package IOS_PageObjects.SignIn_IOS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.disney.appium.common.AppiumConstants;
import com.disney.appium.common.AutomationTools;
import com.disney.appium.common.DirectionEnum;
import com.disney.appium.common.UserLoginDetails;
import com.disney.selenium.common.Log;
import com.disney.selenium.common.exception.AutomationException;

import IOS_PageObjects.Alerts_IOS.IOSAlerts_Page;
import IOS_PageObjects.Dashboard_IOS.DashboardLoggedIn_Page;
import IOS_PageObjects.NavigationBar_IOS.NavigationBar_Page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SignIn_Page {

	public AppiumDriver  driver;

	static Assertion hardAssert = new Assertion();

	/**
	 * This is the Close button at the top of the screen
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Close']")
	private MobileElement closeButton;

	/**
	 * This is the Close button at the top of the screen after task
	 */
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='Close'])[2]")
	private MobileElement closeAfterTaskButton;

	/**
	 * This is the Navigation Bar at the top of the screen
	 * It has the title: Sign In To Your Account
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Sign In to Your Account']")
	private MobileElement signInNavigationBar;

	/**
	 * This is the Create Account button
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name = 'Create Account']")
	private MobileElement createAccountButton;

	/**
	 * This is the Email cell
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Email')]")
	private MobileElement emailField;

	/**
	 * This is the Email field's static text which shows the word: Email
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Email']")
	private MobileElement emailStaticText;

	/**
	 * This is the password field
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeCell[@name='Password, Text field']")
	private MobileElement passwordField;

	/**
	 * This is the password static text
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Password']")
	private MobileElement passwordStaticText;

	/**
	 * This is the Show Password checkbox -- unchecked
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name='Show Password, Checkbox, unchecked']")
	private MobileElement showPasswordCheckbox_Unchecked;

	/**
	 * This is the Show Password checkbox -- checked
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name='Show Password, Checkbox, checked']")
	private MobileElement showPasswordCheckbox_Checked;

	/**
	 * This is the Sign In button -- deactivated
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Sign In, Alert Please enter a valid password., Alert Please use a valid email address.']")
	private MobileElement signInButton_Deactivated;

	/**
	 * This is the Sign In button -- activated
	 */
	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='Sign In'])[2]")
	private MobileElement signInButton_Activated;

	/**
	 * This is the Forgot Password link at the bottom of the screen
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Forgot Password?']")
	private MobileElement forgotPasswordLink;

	/**
	 * This is alert message for email and/or password with not match
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='errorNotificationText']")
	private MobileElement alertInvalidLogin;

	/**
	 * This is dismiss alert buttons in  message for email and/or password with not match
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Dismiss alert']")
	private MobileElement dismissAlertInvalidLoginButton;

	/**
	 * This is retry button
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Retry']")
	private MobileElement retryButton;


	/**
	 * This is clear button in email field
	 */
	//@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Clear text'][1]")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeButton")
	private MobileElement clearEmailButton;


	/**
	 * This is 'Need Help Signing In?' Navigation Bar Text
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Need Help Signing In?']")
	private MobileElement needHelpSigningInText;

	/**
	 * This is 'You have exceeded the limit of sign in attempts. Please wait before trying again, or tap below to reset your password.' text
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='You have exceeded the limit of sign in attempts. Please wait before trying again, or tap below to reset your password.']")
	private MobileElement exceedAttempsText;

	/**
	 * This is Reset via email Button
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Reset Via Email']")
	private MobileElement resetViaEmailButton;

	/**
	 * This is Reset by Security Questions button
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Reset Using Security Questions']")
	private MobileElement resetSecurityQuestionsButton;

	/**
	 * This is the 'If you need further assistance...' Text
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='If you need further assistance, please call']")
	private MobileElement needFurtherAssistanceText;

	/**
	 * This is the 'In-App Purchases']...' Alert
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='In-App Purchases']")
	private MobileElement inAppPurchasesAlert;

	/**
	 * This is the OK button in the 'In-App Purchases']...' Alert
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private MobileElement inAppPurchasesOKButton;

	/**
	 * This is the OK button in the 'In-App Purchases']...' Alert
	 */
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='You have exceeded the limit of sign in attempts. Please wait before trying again, or tap below to reset your password.']")
	private MobileElement attemptHaveBeenExceeded;

	/**
	 * This field is for password static text
	 */
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'••••••••')]")
	private MobileElement encryptedPassword;


	/**
	 * This field is for password text
	 */
	@iOSFindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Disney123')]")
	private MobileElement passwordRevealed;

	/**
	 * This field is for done
	 */
    @iOSFindBy(xpath="//XCUIElementTypeButton[@name='Done']")
    private MobileElement doneButton;
    
    /**
     * This is the Error Message populated when entered Wrong credentials
     */
    @iOSFindBy(xpath ="//XCUIElementTypeStaticText[@name='errorNotificationText']")
    private MobileElement emailPasswordDoNotMatchErrorMessage;
    
    /**
     * This is the Dismiss Alert Button
     */
    @iOSFindBy(id ="Dismiss alert")
    private MobileElement dismissAlertButton;

    /**
     * This is the Dismiss Alert Button
     */
    @iOSFindBy(xpath ="//XCUIElementTypeButton[@name='Sign In']")
    private MobileElement signIn;

    /**
     * Workaround: Password fields list
     * TODO: Remove this element when issue fnb-4011 has been solved
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Password')]")
    private List<MobileElement> passwordFieldsList;

    /**
     * Workaround: Sign In buttons list
     * TODO: Remove this element when issue fnb-4011 has been solved
     */
    @iOSFindBy(xpath ="//XCUIElementTypeButton[@name='Sign In']")
    private List<MobileElement> signInButtonsList;
    
    /**
     * This is the Close button at the top of the screen on fast pass creation page
     */
    // @iOSFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'Close')])[2]")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name ='Close' and @visible='true']")
    private MobileElement closeAfterFPCreation;
    
    /**
     * This is the clear element
     */
    @iOSFindBy(xpath="//XCUIElementTypeCell[contains(@name,'Email')]/XCUIElementTypeTextField")
    public MobileElement clearElement;
    
    /**
	 * This is the back button located top left of the page.
	 */
	@iOSFindBy(id = "Back")
	private MobileElement backButton;
	
	/**		
	  * This is the In-App Purchases dialogue box
	  */			
	 @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='In-App Purchases']")			
	 MobileElement inAppPurchaseDialogueBox;
	 
	 /**
	   * Alert - Ok button
	   * Note - This has the 'k' in 'Ok' in the lower case.
	   */
	  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name ='OK' and @visible='true']" )
	  private MobileElement alertOkButton;

    /**
     * Constructor 
     */
    public SignIn_Page( final AppiumDriver driver ) 
    {
      this.driver = driver;    
      PageFactory.initElements( new AppiumFieldDecorator( driver , AppiumConstants.IMPLICITLY_WAIT_TIMEOUT , TimeUnit.SECONDS ) , this );
    }
    
    /**
     * This method takes the data from the JSON file(Logindetails.json), enters email id and password in the sign page fields.
     *
     */
    public void signIn(com.disney.appium.common.UserLoginDetails loginInfo ){
    
    		//Get the email address from the loginInfo object
           String eMail = loginInfo.getUserEmail();
           Log.log( driver ).info("Setting email as: " + eMail);
        
           //Enter the email address
           AutomationTools.waitForElementToLoad(driver, this.emailField, AppiumConstants.timeTwentySecondsinSEC);
           this.emailField.sendKeys(eMail);
           Log.log( driver ).info("We think we set the email address as: " + eMail);
         
           //Get password from the loginInfo object
           Log.log( driver ).info("Getting the password from the loginInfo objects...");
           String pw = loginInfo.getPassword();
        
           //Set the password on the first password entry field
           Log.log( driver ).info("Setting the password as: " + pw);
           this.passwordField.sendKeys(pw);
           Log.log( driver ).info("We think we set the password as: " + pw);

           this.clickDoneButton();

           //Click on the Sign In activated Button
           this.clickOnTheSignInActivatedButton();
           AutomationTools.SetDelay(5000);
          if (verifyInAppPurchasesDialogueBox())
          {
           this.clickOnOkButton();
          }
           // Verify that we are on dashboard logged in page.
           DashboardLoggedIn_Page dashboard = new DashboardLoggedIn_Page(driver); 
           dashboard.verifyIfDashboardPageIsDisplayed();
    
    }
    
    /**
     * This method is used to close the purchase Dialogue box
     */
    public void closeInAppPurchasesDialogueBox() throws TimeoutException {
    	if (verifyInAppPurchasesDialogueBox()){
    		this.clickOnOkButton();
		}
	}

    /**
     * This method is used to verify an In App Purchases dialogue box 
     */
   public boolean verifyInAppPurchasesDialogueBox() throws TimeoutException {
       	
   		Log.log( driver ).info("Verifying whether In App Purchases dialogue box is present or not....");
   		AutomationTools.waitForElementToLoad(driver, inAppPurchaseDialogueBox, 15);
   		hardAssert.assertEquals(inAppPurchaseDialogueBox.isDisplayed(),true);
   		Log.log( driver ).info("Verified In App Purchases dialogue box is present....");
   		return true;
   		
   }
   
   /**
    * This method is used to click on Ok button
    */
  public void clickOnOkButton(){
	
  		Log.log( driver ).info("Trying to click OK Button ....");
  		this.alertOkButton.click();
  		Log.log( driver ).info("clicked on Ok button");
  		
  }
   
    
    /**
     * This method is used to login directly with email and password that are created manually 
     * 
     */
    public void signIn(String eMail, String pw){
    
        //Enter the email address on the email entry field
    	Log.log( driver ).info("Setting email as: " + eMail);
        this.emailField.sendKeys(eMail);
        Log.log( driver ).info("We think we set the email address as: " + eMail);
        AutomationTools.SetDelay(3000);
        //Enter the password on the password entry field
        Log.log( driver ).info("Setting the password as: " + pw);
        this.passwordField.sendKeys(pw);
        Log.log( driver ).info("We think we set the password as: " + pw);
        this.clickDoneButton();
        //Click on the Sign In activated Button
        this.clickOnTheSignInActivatedButton();
        if (verifyInAppPurchasesDialogueBox())
        {
         this.clickOnOkButton();
        }
        // Verify that we are on dashboard logged in page.
        DashboardLoggedIn_Page dashboard = new DashboardLoggedIn_Page(driver); 
        dashboard.verifyIfDashboardPageIsDisplayed();
    
    }
    
    public void setPasswordAndSignIn(String pw)
    {
    	 Log.log( driver ).info("Setting the password as: " + pw);
    	 AutomationTools.waitForElementToLoad(driver, passwordStaticText, 10);
    	 this.passwordStaticText.sendKeys(pw);
         Log.log( driver ).info("We think we set the password as: " + pw);
         this.clickDoneButton();
         //Click on the Sign In activated Button
         this.clickOnTheSignInActivatedButton();
         AutomationTools.SetDelay(2000);
    }
    
    /**
     * This method is used to click on the done button
     */
    public void clickDoneButton(){
    	Log.log(driver).info("Trying to click on Done Button.....");
    	AutomationTools.waitAndClick(driver, doneButton, 20);
    	Log.log(driver).info("Clicked on Done Button.");
    }
    
    /**
      * This method is used to verify an alert message for invalid user credentials is displayed or not 
      */
    public void verifyInvalidLoginErrorMessage(){
        	
    		Log.log( driver ).info("Verifying whether 'The email and/or password do not match' message is present or not....");
    		AutomationTools.waitForElementToLoad(driver, alertInvalidLogin, 15);
    		hardAssert.assertEquals(this.alertInvalidLogin.getText(), "The email and/or password do not match. Please try again.");
    		Log.log( driver ).info("The displayed error message is :"+ this.alertInvalidLogin.getText());
    		Log.log( driver ).info("'The email and/or password do not match' message is present.");
    	}
    
    
   
   /**
    * This method is used to verify Email Password do not match error match
    */
   public void verifyEmailPasswordDoNotMatchErrorMessage(){
	   AutomationTools.waitForElementToLoad(driver, emailPasswordDoNotMatchErrorMessage, 10);
	   Log.log( driver ).info("Verifying whether Email Password do not match error match is present or not.....");
	   hardAssert.assertEquals(this.emailPasswordDoNotMatchErrorMessage.isDisplayed(), true);
	   Log.log( driver ).info("Error Message is : "+ this.emailPasswordDoNotMatchErrorMessage.getText());
	   Log.log( driver ).info(" Email Password do not match error match is present.");
   }
   
   /**
    * This method is used to dismiss alert
    */
   public void dismissAlert(){
	   AutomationTools.waitForElementToLoad(driver, dismissAlertButton, 10);
	   Log.log( driver ).info("Trying to click on Dismiss Alert Button.....");
	   this.dismissAlertButton.click();
	   Log.log( driver ).info("Clicked on the Dismiss Alert Button.");
   }
   
   /**
    * This method is used for multiple Sign In attempts
    */
   public void signInAttempts(int i,String pw){
       NavigationBar_Page      navigationBar    = new NavigationBar_Page(driver);

	   for(int j =0; j<i;j++){
           navigationBar.clickMoreOptionsButton();
           navigationBar.clickHomeButton();
		   this.setPasswordAndSignIn(pw);
           this.dismissAlert();
	   }
   }

    

	
	public void enterSignInDetails(String eMail, String pw)
	{
		//Enter the email address on the email entry field
		Log.log( driver ).info("Setting email as: " + eMail);
		this.emailField.sendKeys(eMail);
		Log.log( driver ).info("We think we set the email address as: " + eMail);
		AutomationTools.SetDelay(3000);
		//Enter the password on the password entry field
		Log.log( driver ).info("Setting the password as: " + pw);
		this.passwordField.sendKeys(pw);
		Log.log( driver ).info("We think we set the password as: " + pw);
		this.clickDoneButton();
		//Click on the Sign In activated Button
		this.clickOnTheSignInActivatedButton();
	}


	/**
	 * This method clicks on the Sign In button
	 * 
	 */
	public void clickOnTheSignInActivatedButton()
	{
		Log.log( driver ).info("Trying to click on the Activated Sign In button...");
		this.signInButton_Activated.click();
		Log.log( driver ).info("We think we clicked on the Activated Sign In button.");
	}

	/**
	 * This method is used to click on Create Account Button from signin Page
	 */
	public void clickOnCreateAccountButton(){

		Log.log( driver ).info("Trying to click on the Create Account button...");
		this.createAccountButton.click();
		Log.log( driver ).info("We think we clicked on the Create Account button.");

	}

	/**
	 * This method is used to verify Email Address text field
	 */
	public void verifyEMailAddressTextField(){

		Log.log( driver ).info("Verifying whether Email Address Text Field is present or not....");
		hardAssert.assertEquals(this.emailField.isDisplayed(), true);
		Log.log( driver ).info("Email Address Text Field is present.");
	}

	/**
	 * This method is used to verify Password field
	 */
	public void verifyPasswordField(){

		Log.log( driver ).info("Verifying whether Password Field is present or not....");
		hardAssert.assertEquals(this.passwordField.isDisplayed(), true);
		Log.log( driver ).info("Password Field is present.");
	}

	/**
	 * This method is used to verify Create Account Button
	 */
	public void verifyCreateAccountButton(){

		Log.log( driver ).info("Verifying whether Create Account Button is present or not....");
		hardAssert.assertEquals(this.createAccountButton.isDisplayed(), true);
		Log.log( driver ).info("Create Account Button is present.");
	}

	/**
	 * This method is used to verify Forgot Password? link
	 */
	public void verifyForgotPasswordLink(){

		Log.log( driver ).info("Verifying whether Forgot Password? link is present or not....");
		hardAssert.assertEquals(this.forgotPasswordLink.isDisplayed(), true);
		Log.log( driver ).info("Forgot Password? link is present.");
	}

	/**
	 * This method verifies that we are at the Sign In To Your Account screen -- Not already logged in
	 */
	public void verifyWeAreAtTheLoginScreen_NotLoggedIn()
	{
		Log.log( driver ).info("Verifying that we are at the \"Sign In to Your Account\" screen...");
		Log.log( driver ).info("Checking for the Sign In navigation bar...");
		hardAssert.assertEquals(this.signInNavigationBar.isEnabled(), true);
		Log.log( driver ).info("The Sign In Navigation bar was found!");
		Log.log( driver ).info("Checking for the Email static text...");
		hardAssert.assertEquals(this.emailStaticText.isEnabled(), true);
		Log.log( driver ).info("The Email static text was found!");
		Log.log( driver ).info("Checking for the password field static text...");
		hardAssert.assertEquals(this.passwordStaticText.isEnabled(), true);
		Log.log( driver ).info("The Password field static text was found!");
		Log.log( driver ).info("Checking for the Show Password checkbox...");
		hardAssert.assertEquals(this.showPasswordCheckbox_Unchecked.isEnabled(), true);
		Log.log( driver ).info("The Show Password checkbox was found!");
		Log.log( driver ).info("Checking for the deactivated Sign In button...");
		hardAssert.assertEquals(this.signInButton_Deactivated.isEnabled(), false); //Yes, say it is False
		Log.log( driver ).info("The deactivated Sign In button was found!");
		Log.log( driver ).info("Checking for the Forgot Password? link...");
		hardAssert.assertEquals(this.forgotPasswordLink.isEnabled(), true);
		Log.log( driver ).info("The Forgot Password? link was found!");
		Log.log( driver ).info("We have verified that we are at the \"Sign In to Your Account\" screen! (Not logged in)");
	}

	/*
	 * This method clicks the Close button at the top of the screen
	 */
	public void clickTheCloseButton()
	{
		Log.log( driver ).info("Trying to click the Close button...");
		AutomationTools.waitAndClick(driver, closeButton, 30);
		Log.log( driver ).info("We think we clicked the Close button.");
	}

	/*
	 * This method clicks the Close button at the top of the screen On FP Creation Page
	 */
	public void clickTheCloseButtonOnFP()
	{
		System.out.println("Trying to click the Close button...");
		AutomationTools.waitAndClick(driver, closeAfterFPCreation, 60);
		System.out.println("We think we clicked the Close button.");
	}

	/*
	 * This method clicks the Close button at the top of the screen
	 */
	public void clickTheCloseButtonAfterTask()
	{
		Log.log( driver ).info("Trying to click the Close button...");
		AutomationTools.waitAndClick(driver, closeAfterTaskButton, 60);
		Log.log( driver ).info("We think we clicked the Close button.");
	}

	/*
	 * This method clicks the password field
	 */
	public void clickOnPasswordField()
	{
		Log.log( driver ).info("Trying to click on password field...");
		this.passwordField.click();
		Log.log( driver ).info("We think we clicked on the password field.");
	}

	/*
	 * This method verify Deactivated signIn button is displayed
	 */
	public void verifyDeactivatedSignInButton()
	{
		Log.log( driver ).info("Trying to verify Deactivated sign in button is displayed...");
		hardAssert.assertEquals(this.signInButton_Deactivated.isDisplayed(), true);
		Log.log( driver ).info("We think we verified Deactivated sign in button is displayed.");
	}

	/*
	 * This method verify signIn button is disabled
	 */
	public void verifySignInButtonDisabled()
	{
		Log.log( driver ).info("Trying to Verify that Sign In button is disabled...");
		hardAssert.assertEquals(this.signInButton_Deactivated.isEnabled(), false);
		Log.log( driver ).info("Sign In button is disabled.");
	}

	/**
	 * This method is used to click an alert message for invalid user credentials is displayed or not
	 */
	public void clickInvalidLoginErrorMessage(){

		Log.log( driver ).info("clicking  'The email and/or password do not match' message is present or not....");
		this.retryButton.click();
		this.dismissAlertInvalidLoginButton.click();
		Log.log( driver ).info("'The email and/or password do not match' message is present.");
	}

	/**
	 * This method is used to click on Email Field
	 */
	public void clickonEmailField () {
		Log.log( driver ).info("clicking 'The email field");
		this.emailField.click();
		Log.log( driver ).info("clicked  'The email field");

	}

	/**
	 * This method is used to clear the Email Field
	 */
	public void clearEmailText () {
		Log.log( driver ).info("clear 'The email field");
		this.emailField.click();
		AutomationTools.SetDelay(5000);
		this.clearEmailButton.click();
		Log.log( driver ).info("cleared 'The email field");


	}

	/**
	 * This method is used to validate the 'Need Help Signing In?' text
	 */
	public void verifyNeedHelpSigningInText()
	{
		Log.log( driver ).info("verify text 'Need Help Signing In?'");
		hardAssert.assertEquals(this.needHelpSigningInText.isDisplayed(), true);
		Log.log( driver ).info("verified text 'Need Help Signing In?'");
	}

	/**
	 * This method is used to validate the 'You have exceeded the limit of sign in attempt...' text
	 */
	public void verifyExceedAttempsText()
	{
		Log.log( driver ).info("verify text 'You have exceeded the limit of sign in attempt...'");
		hardAssert.assertEquals(this.exceedAttempsText.isDisplayed(), true);
		Log.log( driver ).info("verified text 'You have exceeded the limit of sign in attempt...'");
	}

	/**
	 * This method is used to validate the 'Reset Via Email' button
	 */
	public void verifyResetViaEmailButton()
	{
		Log.log( driver ).info("verify button 'Reset Via Email'");
		hardAssert.assertEquals(this.resetViaEmailButton.isDisplayed(), true);
		Log.log( driver ).info("verified button 'Reset Via Email'");
	}

	/**
	 * This method is used to validate the 'Reset Using Security Questions' button
	 */
	public void verifyResetUsingSecurityQuestionsButton()
	{
		Log.log( driver ).info("verify button ' Reset Using Security Questions'");
		hardAssert.assertEquals(this.resetSecurityQuestionsButton.isDisplayed(), true);
		Log.log( driver ).info("verified button 'Reset Using Security Questions'");
	}

	/**
	 * This method is used to validate the 'Need Further Assistance...' text
	 */
	public void verifyNeedFurtherAssistanceText()
	{
		Log.log( driver ).info("verify text ' Need Further Assistance...'");
		hardAssert.assertEquals(this.needFurtherAssistanceText.isDisplayed(), true);
		Log.log( driver ).info("verified text 'Need Further Assistance...'");
	}

	/**
	 * This method is used to click on the OK button in the 'In-App Purchases' Alert
	 */
	public void clickOnInAppPurchasesButton()
	{
		Log.log( driver ).info("trying to click on the OK button in the 'In-App Purchases' Alert");
		if(this.inAppPurchasesAlert.isDisplayed() == true)
		{
			this.inAppPurchasesOKButton.click();
		}

		Log.log( driver ).info("clicked on the OK button in the 'In-App Purchases' Alert");
	}


	public void clickOnDismissButton()
	{
		Log.log( driver ).info("trying to click Dismiss alert button");
		this.dismissAlertInvalidLoginButton.click();
		Log.log( driver ).info("clicked on dismiss alert button");
	}


	/**
	 * This method is used to validate the 'You have exceeded the limit of sign in attempts. Please wait before trying again, or tap below to reset your password.' text
	 */
	public void verifyAttemptHaveBeenExceedededText()
	{
		Log.log( driver ).info("verify text 'You have exceeded the limit of sign in attempts...'");
		hardAssert.assertEquals(this.attemptHaveBeenExceeded.isDisplayed(), true);
		Log.log( driver ).info("verified text 'You have exceeded the limit of sign in attempts...'");
		Log.log( driver ).info("Trying to swipe down");
		this.backButton.click();
	}

	/**
	 * This method is used to click on forgot password link
	 * @throws AutomationException 
	 */
	public void clickForgotPasswordLink() throws AutomationException{
		Log.log( driver ).info("Trying to click on Forgot Password Link.....");
		AutomationTools.swipeToElement(driver, forgotPasswordLink, 1);
		this.forgotPasswordLink.click();
		Log.log( driver ).info("Clicked on Forgot Password Link.");
	}

	/**
	 * This method is used to verify that the email field is empty.
	 */
	public void verifyEmptyEmailField(){
		Log.log( driver ).info("Verifying whether Email field is empty or not.....");
		hardAssert.assertEquals(this.emailField.getText().equals("Email, Text field"), true);
		Log.log( driver ).info("Email filed is empty.");

	}

	/**
	 * This method is used to enter the email address in Email text field
	 * @param userEmail - Email to set
	 */
	public void setEmail( String userEmail )
	{
		AutomationTools.waitForElementToLoad( driver , emailField , 60 );
		hardAssert.assertEquals(emailField.isDisplayed(),true);
		this.emailField.sendKeys(userEmail );
		AutomationTools.closeKeyboard( driver );
		Log.log( driver ).info( "Email: " + userEmail );
		(new TouchAction(driver)).tap(335, 431).perform();

	}

	/**
	 * This method is used to enter the password in password text field
	 * @param
	 */
	public void setPassword(String Password)
	{
		Log.log( driver ).info("Trying to enter password");
		AutomationTools.SetDelay(2000);
		hardAssert.assertEquals(passwordStaticText.isDisplayed(),true);
		this.passwordStaticText.sendKeys(Password );
		Log.log( driver ).info( "Email: " + Password );
	}

	/**
	 * This method is used to click on enabled reassign Button
	 */
	public void verifyDeencryptedPassword(){
		this.doneButton.click();
		AutomationTools.SetDelay(2000);
		Log.log( driver ).info("Tring to verify deencrypted password....");
		hardAssert.assertEquals(this.encryptedPassword.isDisplayed(), true);
		Log.log( driver ).info("successfully verified deencrypted password.... ");

	}

	/**
	 * This method is used to validate the 'Need Further Assistance...' text
	 */
	public void clickOnShowPasswordcheckBox()
	{
		Log.log( driver ).info("Trying to click showpassword checkbox");
		this.showPasswordCheckbox_Unchecked.click();
		Log.log( driver ).info("successfully clicked showpassword checkbox'");
	}

	/**
	 * This method is used to click on enabled reassign Button
	 */
	public void verifyTextPassword(String strPassword){
		MobileElement objPassword=(MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[contains(@name,'"+strPassword+"')]");
		AutomationTools.SetDelay(2000);
		Log.log( driver ).info("Tring to verify deencrypted password....");
		hardAssert.assertEquals(objPassword.isDisplayed(), true);
		Log.log( driver ).info("successfully verified deencrypted password.... ");

	}


	/**
	 *Trying to verify that user is not SignedIn
	 * This element is displayed when the user is not logged.
	 */
	public void verifyUserNotSignedIn()
	{
		List<MobileElement> createAccountButton=driver.findElementsByXPath("//XCUIElementTypeButton[@name = 'Create Account']");
		Log.log( driver ).info("Trying to verify that user is not SignedIn ");
		hardAssert.assertEquals(createAccountButton.size()>0, true);
		Log.log( driver ).info("successfully verified that user is not SignedIn");
	}

	/**
	 * This method is used for Checking for the Sign In navigation bar
	 */
	public void verifySignIntoYourAccountHeader(){
		Log.log( driver ).info("Checking for the Sign In navigation bar...");
		hardAssert.assertEquals(this.signInNavigationBar.isEnabled(), true);
		Log.log( driver ).info("The Sign In Navigation bar was found!");

	}

	/**
	 * Workaround: Enters password and clicks on Sign In button
	 * TODO: Remove this method when issue fnb-4011 has been solved
	 *
	 * @param loginInfo
	 */
	public void workaroundSignIn(com.disney.appium.common.UserLoginDetails loginInfo) {
		//Get password from the loginInfo object
		Log.log( driver ).info("Getting the password from the loginInfo objects...");
		String pw = loginInfo.getPassword();

		//Set the password on the first password entry field
		Log.log( driver ).info("Setting the password as: " + pw);
		this.passwordFieldsList.get(1).sendKeys(pw);
		Log.log( driver ).info("We think we set the password as: " + pw);

		//Click on the Sign In Button
		this.signInButtonsList.get(2).click();

		// Verify that we are on dashboard logged in page.
		DashboardLoggedIn_Page dashboard = new DashboardLoggedIn_Page(driver);
		dashboard.verifyIfDashboardPageIsDisplayed();
	}


	/**
	 * This method is used to SignIn
	 */
	public void clickOnSinInButton(){
		AutomationTools.waitForElementToLoad(driver, signIn, 10);
		Log.log(driver).info("Trying to click on signIn Button.....");
		this.signIn.click();
		Log.log(driver).info("Clicked on the signIn Button.");
	}


	/**
	 * signInNoDashVerification
	 * @param loginInfo
	 */
	public void signInNoDashVerification( UserLoginDetails loginInfo )
	{
		// Get the email address from the loginInfo object
		String eMail = loginInfo.getUserEmail();
		Log.log( driver ).info( "Setting email as: " + eMail );

		// Enter the email address
		AutomationTools.waitForElementToLoad( driver , this.emailField , AppiumConstants.timeTwentySecondsinSEC );
		this.emailField.click();
		this.clearElement.clear();
		this.emailField.sendKeys( eMail );
		Log.log( driver ).info( "We think we set the email address as: " + eMail );

		this.clickDoneButton();

		// Get password from the loginInfo object
		Log.log( driver ).info( "Getting the password from the loginInfo objects..." );
		String pw = loginInfo.getPassword();

		// Set the password on the first password entry field
		Log.log( driver ).info( "Setting the password as: " + pw );
		this.passwordField.sendKeys( pw );
		Log.log( driver ).info( "We think we set the password as: " + pw );

		this.clickDoneButton();

		// Click on the Sign In activated Button
		this.clickOnTheSignInActivatedButton();

	}

	/**
	 * This method is to signin without dashboard verification
	 * @param userName
	 * @param password
	 */
	public void signInNoDashVerification( String userName, String password )
	{
		// Get the email address from the loginInfo object
		Log.log( driver ).info( "Setting email as: " + userName );

		// Enter the email address
		AutomationTools.waitForElementToLoad( driver , this.emailField , AppiumConstants.timeTwentySecondsinSEC );
		this.emailField.click();
		this.clearElement.clear();
		this.emailField.sendKeys( userName );
		Log.log( driver ).info( "We think we set the email address as: " + userName );

		this.clickDoneButton();

		// Set the password on the first password entry field
		Log.log( driver ).info( "Setting the password as: " + password );
		this.passwordField.sendKeys( password );
		Log.log( driver ).info( "We think we set the password as: " + password );

		this.clickDoneButton();

		// Click on the Sign In activated Button
		this.clickOnTheSignInActivatedButton();
    

  }

}
