
package IOS_PageObjects.Alerts_IOS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.disney.appium.common.AppiumConstants;
import com.disney.appium.common.AutomationTools;
import com.disney.selenium.common.Log;

import IOS_PageObjects.Tutorial_IOS.iosTutorial_page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class IOSAlerts_Page 
{

  static public AppiumDriver  driver;
  
  static Assertion hardAssert = new Assertion();
      
  /**
   * Alert window asking to send notifications 
   */
  @iOSFindBy( xpath = "//XCUIElementTypeAlert" )
  private MobileElement popupmsg_messageAlert;
  
  /**
   * WDW Would Like to Send You Notifications title
   */
  @iOSFindBy( xpath = "//XCUIElementTypeStaticText" )
  private MobileElement popupmsg_messageTitle;
  
  /**
   * Notifications may include alerts, sounds, and icon badges. These can be configured
   * in settings.
   */
  @iOSFindBy( xpath = "//XCUIElementTypeStaticText[2]" )
  private MobileElement popupmsg_messageText;

  /**
   * Alert - Don't Allow button
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Don’t Allow']" )
  private MobileElement popupmsg_buttonDoNotAllow;

  /**
   * Alert - Allow button
   */
  @iOSFindBy( xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeButton" )
  private MobileElement popupmsg_buttonAllow;
  
  
  /**
   * Alert - Allow button
   */
  @iOSFindBy( xpath = "//XCUIElementTypeOther[3]//XCUIElementTypeButton" )
  private MobileElement popupmsg_buttonAllow1;
  
  /**
   * This is the Allow button
   */
  @iOSFindBy( id = "Allow" )
  private MobileElement allowButton;
  
  /**
   * This is the Always Allow button
   */
  @iOSFindBy( id = "Always Allow" )
  private MobileElement alwaysAllowButton;
  

  /**
   * Alert - Allow button 
   * This is an popup message for 'Allow â€œDisney Worldâ€� to access your location while you use the app? 
   */
  @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@label='Allow “Disney World” to access your location?']")
  private MobileElement popupmsg_allowLocationEvenWhenUsingAlert;
  
  /**
   * Alert - In-App Purchases
   * This is a popup referencing the In-App Purchases information.
   */
  @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='In-App Purchases']")
  private MobileElement inAppPurchasesPopupMessage;
  
  /**
   * Alert - Ok button
   * Note - This has the 'k' in 'Ok' in the lower case.
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='Ok']" )
  private MobileElement alertOkButton;
  
  /**
   * Alert - OK button
   */
  @iOSFindBy( xpath = "//XCUIElementTypeButton[@name='OK']" )
  private MobileElement alertOKButton;
  
  /**
   * Alert - Close button
   */
  @iOSFindBy( xpath = "//XCUIElementTypeAlert[@name='Reservation Confirmed!']/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
  private MobileElement alertCloseButton;

  /**
   * Alert - In-App Purchases
   */
  @iOSFindBy( xpath = "//XCUIElementTypeStaticText[@name='In-App Purchases']" )
  private List<MobileElement> inAppPurchasesAlert;
  
  /**
   * Alert - “Disney World” Would Like to Send You Notifications
   */
  @iOSFindBy( xpath = "//XCUIElementTypeAlert" )
  private MobileElement likeToSendNotificationsAlert;
  
  /**
   * Alert - Allow “Disney World” to access your location?
   */
  @iOSFindBy( xpath = "//XCUIElementTypeAlert" )
  private MobileElement allowToAccessLocationAlert;
  
  /**
   * Enumerated list of button values
   */
  public static enum buttonValues 
  {
    Allow,
    NotAllow,
    OK
  }
  
  /**
   * Constructor
   */
  public IOSAlerts_Page( final AppiumDriver driver ) 
  {
      //Create a wait object
      //WebDriverWait wait = new WebDriverWait(driver, 30);
      
    this.driver = driver;    
    PageFactory.initElements( new AppiumFieldDecorator( driver , AppiumConstants.IMPLICITLY_WAIT_TIMEOUT , TimeUnit.SECONDS ) , this );  
  }

  /**
   * This method clicks on the OK button in an alert
   */
  public void clickOnOKButton()
  {
      Log.log( driver ).info("Trying to click on the OK alert button...");
      this.alertOKButton.click();
      Log.log( driver ).info("We think we clicked the OK alert button!");
  }
  
  /**
   * This method clicks on the Close button in an alert
   */
  public void clickOnCloseButton()
  {
      Log.log( driver ).info("Trying to click on the Close alert button...");
      AutomationTools.SetDelay(5000);
      this.alertCloseButton.click();
      Log.log( driver ).info("We think we clicked the Close alert button!");
  }
  
  /**
   * This method is used to accept the Send Notification Alert
   */
  public void acceptSendNotificationsAlert(){
	  
	  Log.log(driver).info("Checking if send notifications alert is present or not....");
	  AutomationTools.waitForElementToLoad(driver, likeToSendNotificationsAlert, 30);
	  hardAssert.assertEquals(true, this.likeToSendNotificationsAlert.isDisplayed());
	  Log.log(driver).info("Send notifications Alert is present.");
	  Log.log(driver).info("Trying to click on Allow Button.....");
	  AutomationTools.waitAndClick(driver, allowButton, 15);
	  Log.log(driver).info("Clicked on Allow Button.");
  }
  
  /**
   * This method is used to accept the allow to access location Alert
   */
  public void acceptAllowToAcceptLocationAlert(){
	  
	  Log.log(driver).info("Checking if access location Alert is present or not....");
	  AutomationTools.waitForElementToLoad(driver, this.allowToAccessLocationAlert, 30);
	  hardAssert.assertEquals(true, this.allowToAccessLocationAlert.isDisplayed());
	  Log.log(driver).info("Access location Alert is present.");
	  Log.log(driver).info("Trying to click on Always Allow Button.....");
	  AutomationTools.waitAndClick(driver, alwaysAllowButton, 15);
	  Log.log(driver).info("Clicked on Always Allow Button.");
  }
  
  /**
   * This method accepts the allow location services alert and closes the tutorial.
   */
  public void acceptAlertsCloseTutorial()
  {
      
      IOSAlerts_Page alert = new IOSAlerts_Page (driver);
      iosTutorial_page tutorial = new iosTutorial_page(driver);
      
      //Check for the Allow Disney World to access location while using app alert, then click ALLOW
      this.acceptSendNotificationsAlert();
      
      //Allow Location Services if the alert is displayed
      this.acceptAllowToAcceptLocationAlert();
      
      //Checks for the In-App purchases present in the app information alert, then click Ok
      
      if (inAppPurchasesAlert.size() > 0)
      {
    	  	  alert.alertOkButton.click();
          
          //Sleep for 1 second after clicking on Ok of In-App purchases
          try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    
      }
      hardAssert.assertEquals( tutorial.clickOnDismissButton() , true );
  }
  
  
  public void acceptAlerts()
  {
      
      IOSAlerts_Page alert = new IOSAlerts_Page (driver);
      
    //Allow Location Services if the alert is displayed
      if (alert.VerifyMessageIsThrown())
      {
          alert.popupmsg_buttonAllow.click();
          
          //Sleep for 1 second after dismissing Location Services alert
          try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    
      }
              

      //Check for the Allow Disney World to access location when not using app alert, then click ALLOW
      if (alert.popupmsg_allowLocationEvenWhenUsingAlert.isDisplayed())
      {
          alert.popupmsg_buttonAllow.click();
          
          //Sleep for 1 second after dismissing Location Services alert
          try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    
      }
  }
  
  /**
   * VerifyMessageIsThrown - Verify if Alert is displayed (waits for 5 seconds)
   * @return true if Alert Message has been detected
   */
  public boolean VerifyMessageIsThrown()
  {
    AutomationTools.waitForElementToLoad( driver , popupmsg_messageAlert , 20 );
    Assert.assertTrue( popupmsg_messageAlert.isDisplayed() , "Message Alert not displayed" );
    Log.log( driver ).info( "Verified Message Window thrown" );
    return true;
  }
  
  /**
   * VerifyMessateTitle
   * @param aTitle
   * @return true if title as expected
   */
  public boolean VerifyMessageTitle( String aTitle )
  {
    AutomationTools.waitForElementToLoad( driver , popupmsg_messageTitle , 10 );
    String aDisplayedText = popupmsg_messageTitle.getAttribute( "label" );
    
    Assert.assertEquals( aTitle , aDisplayedText , "Title not as expected: " + aTitle );
    Log.log( driver ).info( "Verified title: " + aTitle );
    
    return true;
  }
  
  /**
   * VerifyMessageText
   * @param aText
   * @return true if text as expected
   */
  public boolean VerifyMessageText( String aText )
  {
    AutomationTools.waitForElementToLoad( driver , popupmsg_messageText , 10 );
    String aDisplayedText = popupmsg_messageText.getAttribute( "label" );
    
    Assert.assertEquals( aText , aDisplayedText , "Text not as expected: " + aText );
    Log.log( driver ).info( "Verified text: " + aText );
    
    return true;
  }
  
  /**
   * ClickOnButton
   * @param aButtonValue
   * @return true if button is clicked upon or message has not been shown
   */
  public boolean ClickOnButton( buttonValues aButtonValue )
  {
    boolean aResult = false;
    
    do
    {
        if ( VerifyMessageIsThrown() == false )
        {
           Log.log( driver ).info( "No Alert message thrown" );
           break;
        }
        
        if ( aButtonValue == buttonValues.Allow )
        {
            Assert.assertEquals( true , popupmsg_buttonAllow.isDisplayed() , "Button not displayed: " + aButtonValue.toString() );
            popupmsg_buttonAllow.click();
            Log.log( driver ).info( "Clicked on button: " + aButtonValue.toString() );
            aResult = true;
            break;
        }
        
        if ( aButtonValue == buttonValues.NotAllow )
        {
          Assert.assertEquals( true , popupmsg_buttonDoNotAllow.isDisplayed() , "Button not displayed: " + aButtonValue.toString() );
          popupmsg_buttonDoNotAllow.click();
          Log.log( driver ).info( "Clicked on button: " + aButtonValue.toString() );
          aResult = true;
          break;
        }
        
        Log.log( driver ).info( "Button Value not found: " + aButtonValue.toString() );
      
    } while ( 1 == 0 );
    
    return aResult;
  }
}
