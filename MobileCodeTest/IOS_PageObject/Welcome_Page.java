package IOS_PageObjects.Welcome_IOS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import IOS_PageObjects.SecretDebugMenu_IOS.SecretDebugMenu_Page;
import IOS_PageObjects.SecretSettings_IOS.SecretSettings_Page;

import com.disney.selenium.common.Log;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.disney.appium.common.AppiumConstants;
import com.disney.appium.common.AutomationTools;
import com.disney.appium.common.DirectionEnum;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * This is the MDX Welcome_IOS Page page object for iOS
 
 */

public class Welcome_Page 
{

  public AppiumDriver  driver;
    
  static Assertion hardAssert = new Assertion();
  
  //CONSTANTS
  /*
   * This variable stores the login password
   */
  String loginPassword = "1secret$";

  /**
   * Blue Mickey button - also known as Show Dashboard_IOS button on other screens
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Open Dashboard']|//XCUIElementTypeButton[@name='Close Dashboard']" )
  private MobileElement welcome_avatar;

  /**
   * Close - slider button at top of screen 
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@label='Close']" )
  private MobileElement tutorial_close;
  
  /**
   * Carousel for CTAs at the Park Info & Entry welcome screen
   */
  @iOSFindBy( xpath = "//XCUIElementTypeCollectionView" )
  private MobileElement welcomePageCTACarousel;
  
  /**
   * Today's Showtimes static text -- button is not defined!
   */
  @iOSFindBy( xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[contains( @name , 'Today’s\nShowtimes' ) ]" )
  private MobileElement todaysShowTimesStaticText;
  
  /**
   * Park Hours static text -- button is not defined!
   */
  @iOSFindBy( xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[contains( @name , 'Park\nHours' ) ]" )
  private MobileElement parkHoursStaticText;
   
  /**
   * My Tickets static text -- button is not defined!
   */
  @iOSFindBy( xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[contains( @name , 'My Tickets'  ) ]" )
  private MobileElement myTicketsStaticText;
  
  /**
   * Buy Tickets static text -- button is not defined!
   */

  @iOSFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[contains(@name, 'Buy\nTickets')]")
  private MobileElement buyTicketsStaticText;
  
  /**
   * AnnualPass Blockouts static text -- button is not defined!
   */
  @iOSFindBy( xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[contains(@name,'AnnualPass')]" )
  private MobileElement annualPassBlockoutsStaticText;
  
  /**
   * Secret Menu static text -- button is not defined!
   */
  @iOSFindBy( xpath = "//XCUIElementTypeCell[contains(@name,'Secret')]" )
  private MobileElement secretMenuBlockoutsStaticText;
  
  /**
   * This is the "Sign In" button needed for logging in before entering any account information
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Sign In']" )
  private MobileElement signInButton;
  
  /**
   * The Sign In button inside the sign in form -- List<MobileElement>
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[contains(@name,'Sign In')]" )
  private List<MobileElement> signInButtonInSignInForm;
  
  /**
   * The 'Signing in to your account...' text
   */
  @iOSFindBy( xpath = "//*[@name='Signing in to your account...']" )
  private MobileElement signingInToYourAccountText;
  
  /**
   * Create Account button
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Create Account']" )
  private MobileElement createAccountButton;
  
  /**
   * Disney Account image below Sign In and Create Account buttons
   */
  @iOSFindBy( xpath = "//XCUIElementTypeImage[@name='logo-DisneyAccount.png']" )
  private MobileElement disneyAccountImage;
  
  /**
   * Buy tickets, view your passes and more -- beneath Create Account button -- on screen shows: "to get FastPass+, view photos and see plans."
   */
  @iOSFindBy( xpath = "//XCUIElementTypeStaticText[@name='Buy tickets, view your passes and more.']" )
  private MobileElement buyTicketsViewPassesAndMoreStaticText;
    
  /**
   * Nameless table that holds the Email, Password, Show Password, and Sign In buttons 
   */
  @iOSFindBy( xpath = "//XCUIElementTypeTable" )
  private MobileElement welcomePageAccountSignInTable;
  
  /**
   * Privacy & Legal at bottom of screen
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Privacy & Legal']" )
  private MobileElement privacyButton;
  
  /**
   * Email field for text editing
   */
  @iOSFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'Email')]")
  private MobileElement emailFieldTextEditing;
  
  /*
   * This field is for Clear text which clears existing EMailid
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Clear text']" )
  private List<MobileElement> clearEMailAddressButton;
  
  /**
   * Password field for text editing
   */
  @iOSFindBy( xpath = "//XCUIElementTypeCell[@name='Password, Text field']" )
  private MobileElement passwordFieldTextEditing;
  
  /**
   * Show Password check-box -- unchecked
   */
  @iOSFindBy( xpath = "//XCUIElementTypeOther[@name='Show Password, Checkbox, unchecked']" )
  private MobileElement showPasswordCheckbox_Unchecked;
  
  /**
   * Show Password check-box -- checked
   */
  @iOSFindBy( xpath = "//XCUIElementTypeOther[@name='Show Password, Checkbox, checked']" )
  private MobileElement showPasswordCheckbox_Checked;
 
  /**
   * Sign In button -- NOT enabled
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Sign In, Alert Please enter a valid password., Alert Please use a valid email address.']" )
  private MobileElement signInButton_DISABLED;
  
  /**
   * Sign In button - Enabled
   */
  @iOSFindBy(xpath = "(//XCUIElementTypeButton[@name='Sign In'])[2]")
  private MobileElement signInButton_ENABLED;
  

  /**
   * Forgot Password static text
   */
  @iOSFindBy( xpath = "//XCUIElementTypeStaticText[@name='Forgot Password?']" )
  private MobileElement forgotPasswordStaticText; 
    
  /**
   * Help Button at bottom of screen
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Help']" )
  private MobileElement helpButton;
  
  /**
   * Privacy & Legal Button at bottom of screen
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Privacy & Legal']" )
  private MobileElement privacyAndLegalButton;
  
  /**
   * My Account button which appears when a user is logged in
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='My Account']" )
  private MobileElement myAccountButton;

  /**
   * "Done" button in toolbar
   */
  @FindBy ( xpath = "//XCUIElementTypeToolbar/XCUIElementTypeButton[@name='Done']")
  private MobileElement doneButton; 
  
  /**
   * "Tap To Explore" Text on welcome screen
   */
  @FindBy ( xpath = "//XCUIElementTypeStaticText[@name=\"Tap to Explore\"]")
  private MobileElement tapToExploreText; 

  /**
   * "Park Logo" Image on welcome screen
   */
  @FindBy ( xpath = "//XCUIElementTypeImage[@name='ParkLogo']")
  private MobileElement parkLogoImage; 
  
  
  /**
   * "Park info & Entry" Text 
   */
  // @iOSFindBy ( xpath = "//XCUIElementTypeOther[@name='Park Info &amp; Entry']")
  @iOSFindBy ( xpath = "//XCUIElementTypeOther[@name='Park Info & Entry']")
  private MobileElement parkInfoAndEntryText; 
   
  /**
   * "Welcome Back" text in the Navigation bar
   */
   @FindBy ( xpath = "//XCUIElementTypeNavigationBar[@name = 'Welcome Back']")
   private MobileElement welcomeBackText;
   
   /**
    * Close button for Welcome Back screen
    */
   @FindBy ( xpath = "//XCUIElementTypeButton[@name='Close']")
   private MobileElement closeButton;

    @iOSFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'Attractions')]")
    private MobileElement attractionsSection;
    /**
     * This is email Address Field after logging out
     */
    @iOSFindBy( xpath = ".//*[contains(@name,'Email')]" )
    private MobileElement emailFieldTextAfterLoggingOut;
  
  /**
   * Constructor 
   */
  public Welcome_Page( final AppiumDriver driver ) 
  {
    this.driver = driver;    
    PageFactory.initElements( new AppiumFieldDecorator( driver , AppiumConstants.IMPLICITLY_WAIT_TIMEOUT , TimeUnit.SECONDS ) , this );
  }
  
  
  /**
   * This method is trying to click on sign in button
   * @param driver2
   */
  public void clickOnSignInButton()
  {
	  Log.log( driver ).info("Trying to click on the enabled Sign In button...");
	  AutomationTools.waitForElementToLoad(driver, this.signInButton, AppiumConstants.timeTwentySecondsinSEC);
	  this.signInButton.click();
	  Log.log( driver ).info("We think we clicked on the enabled Sign In button.");
  }
  
 
 /*
  * TODO -- enter explanation 
  */
  public Welcome_Page(ThreadLocal<Object> driver2)
{
    
}
  
   /**
   * This method swipe towards left to identify secret questions
   */
  public void swipeToSecretQuestion()
  {
	  Log.log( driver ).info("swiping left on mytickets static text ");
	  AutomationTools.swipeElement(driver, myTicketsStaticText, DirectionEnum.LEFT, 500, 1000);
	  AutomationTools.SetDelay(4000);
	  if(!secretMenuBlockoutsStaticText.isDisplayed())
	    AutomationTools.swipeElement(driver, buyTicketsStaticText, DirectionEnum.LEFT, 500, 1000);
  }
  
  /**
   * This method swipe towards right to find my tickets
   */
  public void swipeToMyTickets()
  {
	  System.out.println("swiping left on buy tickets static text ");
	  AutomationTools.swipeElement(driver, buyTicketsStaticText, DirectionEnum.RIGHT, 500, 1000);
  }
  
  /**
   * Clicks the big blue Mickey button
   */ 
  public void clickOnMickey()
  {
      Log.log( driver ).info("Clicking on the big blue Mickey button...");
      AutomationTools.waitAndClick(driver, welcome_avatar, 15);
      Log.log( driver ).info("We think we clicked on the big blue Mickey button...");
  }
  
  /**
   * Swipe left or right in the Carousel
   * 
   */ 
  public void swipeCarousel(String someDirection, int numberOfSwipes)
  {
      //Will hold our direction
      int int_fromX = 0;
      int int_toX = 0;
      
      if(someDirection.contains("left"))
      {
          int_fromX = 190;
          int_toX = 4;
      }
      if(someDirection.contains("right"))
      {
          int_fromX = 4;
          int_toX = 190;
      }
        
      //Create a JavaScript Executor for implementing our swipes
      JavascriptExecutor jse = (JavascriptExecutor) driver;
      Log.log( driver ).info("Trying to swipe " + someDirection);
      
      //Swipe direction passed in as well as the number of swipes passed in
      for (int i = 1; i <= numberOfSwipes; i++)
      {
      Map<String, Object> params = new HashMap<>();
      params.put("duration", .250);
      params.put("fromX", int_fromX);
      params.put("fromY", 50);
      params.put("toX", int_toX);
      params.put("toY", 50);
      //params.put("element", ((RemoteWebElement) element).getId());
      jse.executeScript("mobile: dragFromToForDuration", params);  
      Log.log( driver ).info("We think we swiped " + someDirection + " " + i + " of " + numberOfSwipes + " times.");
      }
            
  }
  
  /**
   * Swipe left or right in the welcome search Carousel 
   */ 
  public void swipeWelcomeSearchCarousel(String someDirection, int numberOfSwipes)
  {
      //Will hold our direction
      int int_fromX = 0;
      int int_toX = 0;
      
      if(someDirection.contains("left"))
      {
          int_fromX = 218;
          int_toX = 4;
      }
      if(someDirection.contains("right"))
      {
          int_fromX = 4;
          int_toX = 218;
      }
        
      //Create a JavaScript Executor for implementing our swipes
      JavascriptExecutor jse = (JavascriptExecutor) driver;
      Log.log( driver ).info("Trying to swipe " + someDirection);
      
      //Swipe direction passed in as well as the number of swipes passed in
      for (int i = 1; i <= numberOfSwipes; i++)
      {
      Map<String, Object> params = new HashMap<>();
      params.put("duration", .250);
      params.put("fromX", int_fromX);
      params.put("fromY", 20);
      params.put("toX", int_toX);
      params.put("toY", 20);
      //params.put("element", ((RemoteWebElement) element).getId());
      jse.executeScript("mobile: dragFromToForDuration", params);  
      Log.log( driver ).info("We think we swiped " + someDirection + " " + i + " of " + numberOfSwipes + " times.");
      }
            
  }
  
  /**
   * Swipe left or right in the Park Info carousel
   * @param string direction "left" or "right" -- lower case
   * @param int number of swipes
   */ 
  public void swipeParkInfoEntryCarousel(String someDirection, int numberOfSwipes)
  {
      
      int int_fromX = 0;
      int int_toX = 0;
      
      if(someDirection.contains("left"))
      {
          int_fromX = 492;
          int_toX = 276;
      }
      if(someDirection.contains("right"))
      {
          int_fromX = 276;
          int_toX = 492;
      }
        
      //Create a JavaScript Executor for implementing our swipes
      JavascriptExecutor jse = (JavascriptExecutor) driver;
      Log.log( driver ).info("Trying to swipe " + someDirection);
      
      //Swipe direction passed in as well as the number of swipes passed in
      for (int i = 0; i < numberOfSwipes; i++)
      {
      Map<String, Object> params = new HashMap<>();
      params.put("duration", .250);
      params.put("fromX", int_fromX);
      params.put("fromY", 548);
      params.put("toX", int_toX);
      params.put("toY", 548);
      
      jse.executeScript("mobile: dragFromToForDuration", params);  
      Log.log( driver ).info("We think we swiped " + someDirection + " " + i + " of " + numberOfSwipes + " times.");
      }
            
  }

    /**
     * Swipe left or right in the Park Info carousel
     *
     * @param direction "left" or "right" -- lower case
     */
    public void swipeParkInfoEntryCarousel(String direction) {
        switch (direction) {
            case "left":
            	AutomationTools.waitForElementToLoad(driver, myTicketsStaticText, 15);
            	Log.log(driver).info("Trying to Swipe left in \"Park Info Entry Carousel\".");
            	JavascriptExecutor js =(JavascriptExecutor) driver;
                 HashMap<String, String> swipeObject = new HashMap<String, String>();
                 swipeObject.put("direction", "left");
                 swipeObject.put("element", this.myTicketsStaticText.getId());
                 js.executeScript("mobile:swipe", swipeObject);                
                 break;
            case "right":
            	AutomationTools.waitForElementToLoad(driver, buyTicketsStaticText, 15);
            	Log.log(driver).info("Trying to Swipe right in \"Park Info Entry Carousel\".");
            	JavascriptExecutor js1 =(JavascriptExecutor) driver;
            	HashMap<String, String> swipeObject1 = new HashMap<String, String>();
                swipeObject1.put("direction", "right");
                swipeObject1.put("element", this.buyTicketsStaticText.getId());
                js1.executeScript("mobile:swipe", swipeObject1);
            	break;
        }
    }

  /**
   * This method asserts that the Annual Pass Blockouts button is visible
   * It will fail the test if the assertion fails.
   */
  public void verifyAnnualPassBlockoutsButton()
  {
      Log.log( driver ).info("Verifying that the Annual Pass Blockouts button is displayed...");
      hardAssert.assertEquals(this.annualPassBlockoutsStaticText.isDisplayed(), true);
      Log.log( driver ).info("The Annual Pass Blockouts button is displayed!");
  }
  
  /**
   * This method asserts that the "Today's Showtimes" button is visible
   * It will fail the test if the assertion fails.
   */
  public void verifyTodaysShowtimesButton()
  {
      Log.log( driver ).info("Verifying that the \"Today's Showtimes\" button is displayed...");
      hardAssert.assertEquals(this.todaysShowTimesStaticText.isDisplayed(), true);
      Log.log( driver ).info("The \"Today's Showtimes\" button is displayed!");
  }
  
  /**
   * This method verifies that the first three buttons in the Park Info & Entry carrousel are visible
 * @throws InterruptedException 
   */
  public void verifyFirstThreeButtonsInWelcomePageCarousel() throws InterruptedException {
      AutomationTools.SetDelay(3000);
      Log.log( driver ).info("Verifying that the \"Today's Showtimes\" button is displayed...");
      hardAssert.assertEquals(this.todaysShowTimesStaticText.isDisplayed(), true);
      Log.log( driver ).info("The \"Today's Showtimes\" button is displayed!");

      Log.log( driver ).info("Verifying that the \"Park Hours\" button is displayed...");
      hardAssert.assertEquals(this.parkHoursStaticText.isDisplayed(), true);
      Log.log( driver ).info("The \"Park Hours\" button is displayed!");

      Log.log( driver ).info("Verifying that the \"My Tickets\" button is displayed...");
      hardAssert.assertEquals(this.myTicketsStaticText.isDisplayed(), true);
      Log.log( driver ).info("The \"My Tickets\" button is displayed!");
  }
  
  /**
   * This method verifies that the buy tickets button is displayed
   */
  public void validateBuyTicketsButton()
  {
      Log.log( driver ).info("validate the 'Buy Tickets' button is displayed...");
      hardAssert.assertEquals(this.buyTicketsStaticText.isDisplayed(), true);
      Log.log( driver ).info("We think we validate the 'Buy Tickets' button displayed.");
  }
  
  /**
   * This method clicks on the Today's Showtimes button
   */
  public void clickOnTodaysShowtimesButton()
  {
      Log.log( driver ).info("Clicking on the \"Today's Showtimes\" button...");
      
      this.todaysShowTimesStaticText.click();
      Log.log( driver ).info("We think we clicked on the \"Today's Showtimes\" button.");
  }
  
  /**
   * This method clicks on the Secret Menu
   */
  public void clickOnSecretMenuButton()
  {
      Log.log( driver ).info("Clicking on the Secret Menu button...");
      this.secretMenuBlockoutsStaticText.click();
      Log.log( driver ).info("We think we clicked on the Secret Menu button.");
  }
  
  /**
   * This method clicks on the Park Hours button
   */
  public void clickOnParkHoursButton()
  {
      Log.log( driver ).info("Clicking on the \"Park Hours\" button...");
      this.parkHoursStaticText.click();
      Log.log( driver ).info("We think we clicked on the \"Park Hours\" button.");
  }
  
  /**
   * This method clicks on the My Tickets button
   */
  public void clickOnMyTicketsButton()
  {
      Log.log( driver ).info("Clicking on the \"My Tickets\" button...");
      this.myTicketsStaticText.click();
      Log.log( driver ).info("We think we clicked on the \"My Tickets\" button.");
  }
  
  /**
   * This method clicks on the Buy Tickets button
   */
  public void clickOnBuyTicketsButton()
  {
      Log.log( driver ).info("Clicking on the \"Buy Tickets\" button...");
      AutomationTools.waitForElementToLoad(driver, this.buyTicketsStaticText, AppiumConstants.timeTwentySecondsinSEC);
      this.buyTicketsStaticText.click();
      Log.log( driver ).info("We think we clicked on the \"Buy Tickets\" button.");
  }
  
  /**
   * This method clicks on the Buy Tickets button
   */
  public void clickOnBuyTicketsButtonBeforeSignin()
  {
      Log.log( driver ).info("Clicking on the \"Buy Tickets\" button...");
      Log.log( driver ).info("swiping left on mytickets static text");
      AutomationTools.swipeElement(driver, myTicketsStaticText, DirectionEnum.LEFT, 500, 1000);
      AutomationTools.waitForElementToLoad(driver, this.buyTicketsStaticText, AppiumConstants.timeTwentySecondsinSEC);
      this.buyTicketsStaticText.click();
      Log.log( driver ).info("We think we clicked on the \"Buy Tickets\" button.");
  }
  
  /**
   * This method clicks on the AnnualPass Blockouts button
   */
  public void clickOnAnnualPassBlockoutsButton()
  {
      Log.log( driver ).info("Clicking on the \"AnnualPass Blockouts\" button...");
      this.annualPassBlockoutsStaticText.click();
      Log.log( driver ).info("We think we clicked on the \"AnnualPass Blockouts\" button.");
  }
  
  /**
   * This method clicks on the SignIn_IOS button 
  */
  public void clickOnsignInButton()
  {	  
	  AutomationTools.waitForElementToLoad(driver, signInButton, 40);
      Log.log( driver ).info("Clicking on the \"Sign In\" button...");
      this.signInButton.click();
      Log.log( driver ).info("We think we clicked on the \"Sign In\" button...");
  }
  
  /**
   * This method clicks on the Create Account button
   */
  public void clickOnCreateAccountButton()
  {
      Log.log( driver ).info("Clicking on the \"Create Account\" button...");
      this.createAccountButton.click();
      Log.log( driver ).info("We think we clicked on the \"Create Account\" button...");
  }
  
  /**
   * This method clicks on the Sign In button
   */
  public void clickOnTheSignInEnabledButton()
  {
     Log.log( driver ).info("Trying to click on the enabled Sign In button...");
     AutomationTools.waitForElementToLoad(driver, this.signInButton_ENABLED, AppiumConstants.timeTwentySecondsinSEC);
     this.signInButton_ENABLED.click();
     Log.log( driver ).info("We think we clicked on the enabled Sign In button.");
  }
  
  /**
   * This method is used to click on Help Button
   */
  public void clickOnHelpButton(){
	  
	  Log.log( driver ).info("Trying to click on the Help button...");
	  this.helpButton.click();
	  Log.log( driver ).info("We think we clicked on the Help button.");
	     
  }
  
  /*
   * This methods signs into the application.
   * Required parameters are EMail Address and Password
   */
  public void signIntoApplication(String strEMailAddress,String strPassword)
  {
	  Log.log( driver ).info("Entering EMail address as "+strEMailAddress);
	  if (!this.emailFieldTextEditing.isDisplayed()) {
		  AutomationTools.swipeScreenAnyDirection_IOS("up", 1, driver);
	  }
	  this.emailFieldTextEditing.click();
	  try {
		Thread.sleep(2000);
		//Unable to clear existing EMail address with clear method, so trying to clear with clicking on Delete icon
		//this.emailFieldTextEditing.clear();
		
		if(clearEMailAddressButton.size()>0)
		{
			Log.log( driver ).info("Clearing existing EMail address by clicking on Clear text button");
			clearEMailAddressButton.get(0).click();
		}
		  Thread.sleep(2000);
		  this.emailFieldTextEditing.sendKeys(strEMailAddress);
		  AutomationTools.closeKeyboard(driver);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	  Log.log( driver ).info("Entering Password as "+strPassword);
	  this.passwordFieldTextEditing.click();
	  this.passwordFieldTextEditing.sendKeys(strPassword);
	  Log.log( driver ).info("Clicking on Sign In button");
	  AutomationTools.closeKeyboard(driver);
		try {
			AutomationTools.waitForElementDisapper(driver, signingInToYourAccountText, 20);
		} catch (Exception e) {
			hardAssert.fail("Signing in to your account pop up is not disappearing after waiting for a while...");
		}
		try {
			hardAssert.assertTrue(signInButtonInSignInForm.size()==0);
		} catch (Exception e) {
			hardAssert.fail("Sign In screen not disappearing...");
		}
		try {
			Thread.sleep(4000);
			if (this.welcomeBackText.isDisplayed()) {
				Log.log( driver ).info("Welcome back screen is displayed");
				this.closeButton.click();
				Log.log( driver ).info("We think we clicked on the button to close Welcome Back screen");
				Thread.sleep(4000);
			}
		} catch (Exception e) {
			Log.log(driver).info("Welcome Back screen is not displayed.");;
		}
  }

    /**
     * This method logs in after a log off
     */
    public void loginAfterALogoff(String password)
    {
        Log.log( driver ).info("Trying to login after a logoff...");
        Log.log( driver ).info("Trying to set previous password...");
        this.passwordFieldTextEditing.sendKeys(password);
        Log.log( driver ).info("We think we set the previous password.");
        Log.log( driver ).info("Trying to click on the enabled Sign In button...");
        this.signInButton_ENABLED.click();
        Log.log( driver ).info("We think we clicked on the enabled Sign In button.");
    }

  /**
   * This method logs in after a log off
   */
  public void loginAfterALogoff()
  {
      Log.log( driver ).info("Trying to login after a logoff...");
      Log.log( driver ).info("Trying to set previous password...");
      this.passwordFieldTextEditing.sendKeys(loginPassword);
      Log.log( driver ).info("We think we set the previous password.");
      Log.log( driver ).info("Trying to click on the enabled Sign In button...");
      this.signInButton_ENABLED.click();
      Log.log( driver ).info("We think we clicked on the enabled Sign In button.");
  }
  
  /**
   * This method clicks on the My Account button
   */
  public void clickOnMyAccountLink()
  {
      Log.log( driver ).info("Trying to click on the My Account link...");
      this.myAccountButton.click();
      Log.log( driver ).info("We think we clicked on the My Account link.");
  }
  
  /**
   * This method logs a user in with email and password
   * @throws InterruptedException 
   */
  public void loginUser(String someEmail, String somePassword) throws InterruptedException
  {
      Log.log( driver ).info("Trying to login user...");
      this.emailFieldTextEditing.sendKeys(someEmail);
      Log.log( driver ).info("We think we entered the email address.");
      this.passwordFieldTextEditing.sendKeys(somePassword);
      Log.log( driver ).info("We think we entered the password.");
      Log.log( driver ).info("Trying to click on the DONE button...");
      this.doneButton.click();
      Log.log( driver ).info("We think we clicked on the DONE button.");
      Log.log( driver ).info("Trying to click on the ENABLED Sign In button...");
      //Slow things down before we try clicking on the button
      Thread.sleep(2000);     
      this.signInButton_ENABLED.click();
      Log.log( driver ).info("We think we clicked on the ENABLED Sign In button!");
  }


  /*
   * Click on Close tutorial button
   */
  public void closeTutorialPulldown()
  {
	  Log.log( driver ).info("Trying to click on pull down close tutorial");
	  this.tutorial_close.click();
      Log.log( driver ).info("We think we clicked on the pull down close tutorial.");
  }
  
  
  
  /**
   * This method is used to validate Help Button displayed
   */
  public void validateHelpButton(){
	  
	  Log.log( driver ).info("Trying to validate the Help button displayed...");
	  hardAssert.assertEquals(this.helpButton.isDisplayed(), true);
	  Log.log( driver ).info("We think we the Help button is displayed.");
	     
  }
  
  /**
   * This method is used to validate Privacy & Legal Button displayed
   */
  public void validatePrivacyButton(){
	  
	  Log.log( driver ).info("Trying to validate the Privacy & Legal button displayed...");
	  hardAssert.assertEquals(this.privacyButton.isDisplayed(), true);
	  Log.log( driver ).info("We think we the Privacy & Legal button is displayed.");
	     
  }

    /**
     * This method logs in after a log off
     */
    public void signinAfterSignOut(String newPassword)
    {
        this.passwordFieldTextEditing.sendKeys(newPassword);
        Log.log( driver ).info("Enters new Password in textfield");
        this.signInButton_ENABLED.click();
        Log.log( driver ).info("Clicked on Sign in Button");
    }
    
    /**
     * This method validates objects present in welcome screen
     */
    
    public MobileElement getWelcome_avatar(){
        return this.welcome_avatar;

    }
    
    
    /**
     * This method validate the signIn button is displayed 
     */
    public void verifySignInButton()
    {
        Log.log( driver ).info("Verifying the \"Sign In\" button...");
  	  	hardAssert.assertEquals(this.signInButton.isDisplayed(), true);
        Log.log( driver ).info("We think we verified the \"Sign In\" button...");
    }
    
    /**
     * This method validate the welcome avatar  is displayed 
     */
    public void verifyWelcomeAvatar()
    {
        Log.log( driver ).info("Verifying the \"Welcome Avatar\"...");
  	  	hardAssert.assertEquals(this.welcome_avatar.isDisplayed(), true);
        Log.log( driver ).info("We think we verified the \"Welcome Avatar\"...");
    }
    
    /**
    * This method validate the ParkInfo & EntryText is displayed 
    */
    public void verifyParkInfoAndEntryText()
    {
        Log.log( driver ).info("Verifying the \"Park Info & Entry \" Text");
  	  	hardAssert.assertEquals(this.parkInfoAndEntryText.isDisplayed(), true);
        Log.log( driver ).info("We think we verified the \"Park Info & Entry \" Text");
    }
    
    /**
    * This method validate the Create Account Button is displayed 
    */
    public void verifyCreateAccountButton()
    {
        Log.log( driver ).info("Verifying the \"Create Account \" button");
  	  	hardAssert.assertEquals(this.createAccountButton.isDisplayed(), true);
        Log.log( driver ).info("We think we verified the \"Create Account\" button");
    }
    
    //
    /**
    * This method validate the tap to explore Text is displayed 
    */
    public void verifyTapToExploreText()
    {
        Log.log( driver ).info( "Source: " + driver.getPageSource() );
        Log.log( driver ).info("Verifying the \"Tap To Explore\" text");
  	  	hardAssert.assertEquals(this.tapToExploreText.isEnabled(), true);
        Log.log( driver ).info("We think we verified the \"Tap To Explore\" tap");
    }  
    
    /**
    * This method validate the tap to explore Text is displayed 
    */
    public void verifyTapToExploreTextNotDisplayed()
    {
        Log.log( driver ).info("Verifying the \"Tap To Explore\" text not displayed");
        try 
        {
  	  	hardAssert.assertEquals(this.tapToExploreText.isDisplayed(), true);
  	  	hardAssert.fail("Tap explore should not be displayed");
        } catch (Exception ee) 
        	{
         Log.log( driver ).info("the tap to explore text is not be displayed as expected ");
        }
        Log.log( driver ).info("We think we verified the \"Tap To Explore\" tap not displayed");
    }  
    
    /**
     * This method clicks on the Secret Menu button then sets the environment and returns to the Welcome page
     * We always start at the "default" setting, which is Production. Use previous and next to move the wheel up (previous)
     * and down (next) the clicks needed to select the desired environment.
     * "previous" 
     * 1 click  = Prod/OAuthTest
     * 2 clicks = Latest/Env5/VPN
     * 3 clicks = Stage/Env5
     * 4 clicks = Load/Env5
     * "next"
     * 1 clicks = Stage/Env2
     * 2 clicks = QA
     * 3 clicks = Latest/Env2
     * 4 clicks = Stage/Env5/Static
     * 5 clicks = Latest/SSO
     * 6 clicks = Latest/Env5
     * 7 clicks = Stage/SSO
     */
    public void clickSecretSettingsAndSetEnvironmentAndReturnToWelcomePage(String direction, int clicks)
    {
      
        SecretSettings_Page     secretSettings      = new SecretSettings_Page(driver);
        SecretDebugMenu_Page    secretDebug         = new SecretDebugMenu_Page(driver);
        
        //Swipe left in carousel to reveal Secret Menu button
        this.swipeCarousel("left", 1);
        
        //Click on the Secret Menu button
        this.clickOnSecretMenuButton();
        
        //Click on the Secret Settings link/button
        secretDebug.clickOnSecretSettingsStaticText();
        
        //Click on Service Environment button
        secretSettings.clickOnServiceEnvironment();
        
        //Set environment as desired then return to welcome screen
        secretSettings.selectEnvironmentViaPickerWheel(direction, clicks);
                
    }
    
    /**
     * This method verifies that the My Tickets button is displayed
     */
    public void verifyMyTicketsButton()
    {
    	     Log.log( driver ).info("Verifying that the \"My Tickets\" button is displayed...");
         hardAssert.assertEquals(this.myTicketsStaticText.isDisplayed(), true);
         Log.log( driver ).info("The \"My Tickets\" button is displayed!");
    }
    
    /**
     * This method verifies that the My Tickets button is displayed
     * @author swathijajula
     */
    public void verifyBuyTicketsButton()
    {
    	 Log.log( driver ).info("Verifying that the \"Buy Tickets\" button is displayed...");
         hardAssert.assertEquals(this.buyTicketsStaticText.isDisplayed(), true);
         Log.log( driver ).info("The \"Buy Tickets\" button is displayed!");
    }
    
    /**
     * This method clicks on the Email field for editing
     */
    public void clickOnEmailEditField()
    {
    	Log.log( driver ).info("Trying to click on the Email editing Field...");
    	this.emailFieldTextEditing.click();
    	Log.log( driver ).info("We think we clicked on the Email editing Field!");
    }
    
    /**
     * This method verifies that welcome back screen is displayed
     * @author swathijajula
     * @version MDX 4.11
     */
    public void verifywelcomeBackHeader()
    {
    	Log.log( driver ).info("Welcome back screen is displayed");
        hardAssert.assertEquals(this.welcomeBackText.isDisplayed(), true);
		Log.log( driver ).info("Successfully verified Welcome Back screen is displayed");
    }

    /**
     * This method clicks on the title of the Attractions section
     */
    public void clickOnAttractionsSection() {
        Log.log(driver).info("Trying to click on the Attractions section...");
        this.attractionsSection.click();
        Log.log(driver).info("We think we clicked on the Attractions section.");
    }
    
    /**
     * This method logs in after a log off with a different User
     */
    public void signinWithDifferentUser(String emailId,String newPassword)
    {
    		Log.log( driver ).info("Trying to sign in with a different User");
    		emailFieldTextAfterLoggingOut.click();
    		AutomationTools.SetDelay(2000);
    		if(clearEMailAddressButton.size()>0)
    		{
    			Log.log( driver ).info("Clearing existing EMail address by clicking on Clear text button");
    			clearEMailAddressButton.get(0).click();
    		}else
    			emailFieldTextEditing.clear();
    		
    		AutomationTools.SetDelay(3000);
    		this.emailFieldTextAfterLoggingOut.sendKeys(emailId);
        this.passwordFieldTextEditing.sendKeys(newPassword);
        Log.log( driver ).info("Enters new Password in textfield");
        AutomationTools.closeKeyboard(driver);
        this.signInButton_ENABLED.click();
        AutomationTools.SetDelay(6000);
        Log.log( driver ).info("Clicked on Sign in Button");
    }
}