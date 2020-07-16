package IOS_PageObjects.CreateAccount_IOS;

import Android_PageObjects.Common_Android.PopUpMessage01_Page;
import IOS_PageObjects.Alerts_IOS.IOSAlerts_Page;

import com.disney.appium.common.AutomationTools;
import com.disney.appium.common.DirectionEnum;
import com.disney.appium.common.UserAccountInfo;
import com.disney.selenium.common.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.helpers.LogLog;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.disney.appium.common.AppiumConstants;
import com.disney.appium.common.AutomationTools;
import com.disney.selenium.common.Log;

public class CreateAccount_Page {

    /*
     *  This page object was last updated on 07/31/17 for MDX 4.7 debug build  
     *  @author Swathi Jajula
     */
    
    public AppiumDriver  driver;

    static Assertion hardAssert = new Assertion();
    
    /**
     * Close button at the top of the page
     */
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Close']")
    public MobileElement closeButton;
    
    /**
     * Create Account Navigation Bar at the top of the page
     */
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Create Account']")
    public MobileElement createAccountNavigationBar;
    
    /**
     * Let's Set Up Your Disney Account! header and text
     */                                              
   // @iOSFindBy(xpath = "//XCUIElementTypeOther[@name='Let's Set Up Your Disney Account!If you've registered with a site like Disneyland.com, ABC.com or ESPN.com, you can go back and sign in using the same email and password.']")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    public MobileElement letsSetupYourDisneyAccountHeader;
    
    /**
     * Birthday field for entering user's birthday -- contains static text elements for Birthday* and then static text holding user's birthday entry
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell[@name='Birthday, Required, Dropdown, October 1, 1971']")
    public MobileElement birthdayField;
    
    /**
     * Birthday* static text field header - birthday title above entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Birthday*']")
    public MobileElement birthdayStaticTextFieldHeader;
    
    /**
     * Birthday static text field - This holds what the user actually enters for their birthday and the values will change here
     * to match whatever the user enters!
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]" +
            "/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]")
    public MobileElement birthdayFieldUserBirthdayEntry;

    /**
     * Toolbar above picker wheel
     */
    @FindBy ( className = "XCUIElementTypeToolbar")
    public MobileElement toolBar; 
    
    /**
     * "Back" arrow button in toolbar
     */
    @FindBy ( xpath = "//XCUIElementTypeToolbar/XCUIElementTypeButton[@name='Back']")
    public MobileElement backButton; 
    
    /**
     * "Next" arrow button in toolbar
     */
    @FindBy ( xpath = "//XCUIElementTypeToolbar/XCUIElementTypeButton[@name='Next']")
    public MobileElement nextButton; 
    
    /**
     * "Done" button in toolbar
     */
    @FindBy ( xpath = "//XCUIElementTypeToolbar/XCUIElementTypeButton[@name='Done']")
    public MobileElement doneButton; 
    
    /**
     * Date picker wheel for entering Birthday
     */
    @FindBy (xpath = "//XCUIElementTypeOther/XCUIElementTypePickerWheel")
    public List<MobileElement> datePickerWheel; 
    
    /**
     * Country picker wheel for selecting country
     */
    @iOSFindBy (className = "XCUIElementTypePickerWheel")
    public List<MobileElement> countryPickerWheel; 
    
    /**
     * Date picker wheel for selecting the State   
     */
    @FindBy (xpath = "//XCUIElementTypePickerWheel[@value='Alabama, 1 of 51']")
    public List<MobileElement> statePickerWheel; 
    
    /**
     * First Name field -- contains static text elements for First Name* and then static text holding user's first name entry
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]")
    public MobileElement firstNameField;
    
    /**
     * First Name static text -- contains the First Name* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='First Name*']")
    public MobileElement firstNameStaticText;
    
    /**
     * Last Name field -- contains static text elements for Last Name* and then static text holding user's last name entry
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]")
    public MobileElement lastNameField;
    
    /**
     * Last Name static text -- contains the Last Name* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Last Name*']")
    public MobileElement lastNameStaticText;
    
    /**
     * Email field -- contains static text elements for Email* and then static text holding user's email entry
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[4]")
    public MobileElement emailField;
    
    /**
     * Email static text -- contains the Email* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Email*']")
    public MobileElement emailStaticText;
    
    /**
     * Country field -- contains static text elements for Country* header and then static text holding user's actual entry for country
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]")
    public MobileElement countryField;
    
    /**
     * Country static text -- contains the Country* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Country*']")
    public MobileElement countryStaticText;
    
    /**
     * Country static text selected value -- contains the user's actual selected country value
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='United States']")
    public MobileElement countrySelectedValue;
    
    /**
     * Address Line 1 field -- contains static text elements for Address Line 1* header
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[6]")
    public MobileElement addressLine1Field;
    
    /**
     * Address Line 1 static text -- contains the Address Line 1* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Address Line 1*']")
    public MobileElement addressLine1StaticText;
    
    /**
     * Address Line 2 field -- contains static text elements for Address Line 2 header
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[7]")
    public MobileElement addressLine2Field;
    
    /**
     * Address Line 2 static text -- contains the Address Line 2 header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Address Line 2']")
    public MobileElement addressLine2StaticText;
    
    /**
     * Address Line 3 field -- contains static text elements for Address Line 3* header
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell[@name='Address Line 3, Required, Text field']")
    public MobileElement addressLine3Field;
    
    /**
     * Address Line 3 static text -- contains the Address Line 3* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Address Line 3*']")
    public MobileElement addressLine3StaticText;

    /**
     * City field -- contains static text elements for City* header
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[9]")
    public MobileElement cityField;
    
    /**
     * City static text -- contains the City* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name=' City*']")
    public MobileElement cityStaticText;
    
    /**
     * State dropdown field -- contains static text elements for State* header
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[10]")
    public MobileElement stateDropdownField;
    
    /**
     * State static text -- contains the State* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='State*']")
    public MobileElement stateStaticText;
    
    /**
     * Zip code field -- contains static text elements for Zip or Postal Code* header
     */
    @iOSFindBy(xpath = "////XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[11]")
    public MobileElement zipCodeField;
    
    /**
     * Zip code static text -- contains the Zip or Postal Code* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='ZIP or Postal Code*']")
    public MobileElement zipCodeStaticText;
    
    /**
     * Password field -- contains static text elements for Password Required, text field* header
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[12]")
    public MobileElement passwordField;
    
    /**
     * Password static text -- contains the Password* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Password*']")
    public MobileElement passwordStaticText;
    
    /**
     * Confirm Password field -- contains static text elements for Confirm Password Required, text field* header
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[13]")
    public MobileElement passwordConfirmField;
    
    /**
     * Confirm Password static text -- contains the Password* header on the entry field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Confirm Password*']")
    public MobileElement passwordConfirmStaticText;
    
    /**
     * Text block containing: "Enter a combination of at least 6 letters, numbers, and/or special characters."
     * This is just below the Confirm Password field and does not have a unique ID of any kind! 
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeOther[2]")
    public MobileElement passwordRequirementsText;
    
    /**
     * Complete your Registration static text
     */
    @iOSFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@name='Complete Your Registration']")
    public MobileElement completeYourRegistrationStaticText;
    
    //TODO -- complete mapping all elements of the Create Account page!
    
    /**
     * Receive updates checkbox
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[@name='WDIGFamilySites checkbox']")
    public MobileElement wdigFamilySitesCheckbox;
    
    /**
     * Yes! I would like to receive updates text -- USA
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[@name='WDIGFamilySites']")
    public MobileElement wdigYesReceiveUpdatesText_USA;
    
    /**
     * Terms and Conditions checkbox
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[@name='termsAndConditions checkbox']")
    public MobileElement termsAndConditionsCheckbox;
    
    /**
     * I have read and agree to the terms and conditions text
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[@name='termsAndConditions']")
    public MobileElement termsAndConditionsText;
    
    /**
     * Create My Account button -- disabled
     */
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Create My Account, Alert Please enter your first name. Use a maximum of 28 letters., Alert Please enter your last name. Use a maximum of 28 letters.']")
    public MobileElement createMyAccountButtonDisabled;
    
    /**
     * Create My Account button -- enabled
     */
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='Create My Account']")
    public MobileElement createMyAccountButtonEnabled;
    
    /**
     * Password Phone less than 2 character types alert 
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Password must include at least 2 of these 3 character types:')]")
    public MobileElement passwordCharacterTypesErrorMessage;

    //Picker Wheel Web Element
    @iOSFindBy(className="XCUIElementTypePickerWheel")
    private List<MobileElement> environmentPickerwheel;

    /**
     * Supplemental Terms Check Box
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]" +
            "/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]" +
            "/XCUIElementTypeTable[1]/XCUIElementTypeCell[16]/XCUIElementTypeOther[1]")
    public MobileElement supplementalTermsCheckBox;

    /**
     * Confirmartion message after creating the account
     */
    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your account has been created.']")
    public MobileElement confirmationMessage;

    /**
     * Country static text field - This holds what the user actually enters for their Country and the values will change here
     * to match whatever the user enters!
     */
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]" +
            "/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]" +
            "/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]/XCUIElementTypeStaticText[2]")
    public MobileElement countryFieldUserCountryEntry;

    /**
     * County Text Field
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell[@name='County, Text field']")
    public MobileElement countyTextField;
    
    /**
     * Password Phone Number Message 
     */
    @iOSFindBy(xpath = "//XCUIElementTypeCell[contains(@name,'Password cannot be formatted like a phone number')]")
    public MobileElement passwordPhoneNumberMessage;

    /*
    * This is the AGE pickerWheel, initial value is set at: "Infant, 1 of 19"
    */
    @FindBy (xpath = "//XCUIElementTypePickerWheel")
    public List<MobileElement> PickerWheel;

    /**
     * This is 'Create Account' header appears on create account screen
     */
     @iOSFindBy ( xpath = "//*[contains(@name, 'Create Account')]")
     public MobileElement createAccountHeader;

    /**
     * This is the Error message displayed in password text field while user tries to create an account with the common passwords
     */
    @iOSFindBy ( xpath = "//*[contains(@name, 'Alert, invalid input Password cannot include a common word or phrase')]")
    public MobileElement alertMessageDisplayedWhileCreatingAccountWithCommonPwd;

    /**
     * Constructor 
     */
    public CreateAccount_Page( final AppiumDriver driver ) 
    {
      this.driver = driver;    
      PageFactory.initElements( new AppiumFieldDecorator( driver , AppiumConstants.IMPLICITLY_WAIT_TIMEOUT , TimeUnit.SECONDS ) , this );
    }
    
    /**
     * This method is used to verify Header text field
     */
    public void verifyLetsSetupYourDisneyAccountHeader(){
    	
    	Log.log(driver).info("Verifying whether Let's Set Up Your Disney Account! Text Field is present or not....");
    	hardAssert.assertEquals(this.letsSetupYourDisneyAccountHeader.isDisplayed(), true);
    	Log.log(driver).info("Let's Set Up Your Disney Account! Text Field is present.");
    }
    
    /**
     * This method is used to verify Birthday Static text with required(*)symbol
     */
    public void verifyBirthdayStaticTextFieldHeader(){
    	
    	Log.log(driver).info("Verifying whether Birthday Static textis present or not....");
    	hardAssert.assertEquals(this.birthdayStaticTextFieldHeader.isDisplayed(), true);
    	Log.log(driver).info("Birthday Static text is present.");
    	Log.log(driver).info(this.birthdayStaticTextFieldHeader.getText());
    }
    
    /**
     * This method is used to verify First Name field
     */
    public void verifyFirstNameField(){
    	
    	Log.log(driver).info("Verifying whether First Name field is present or not....");
    	hardAssert.assertEquals(this.firstNameField.isDisplayed(), true);
    	Log.log(driver).info("First Name field is present.");
    	String text =(this.firstNameField.getText());
    	hardAssert.assertEquals(text, "First Name, Required, Text field");
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify Last Name field
     */
    public void verifyLastNameField(){
    	
    	Log.log(driver).info("Verifying whether Last Name field is present or not....");
    	hardAssert.assertEquals(this.lastNameField.isDisplayed(), true);
    	Log.log(driver).info("Last Name field is present.");
    	String text =(this.lastNameField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text, "Last Name, Required, Text field");
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify Email field
     */
    public void verifyEmailField(){
    	
    	Log.log(driver).info("Verifying whether Email field is present or not....");
    	hardAssert.assertEquals(this.emailField.isDisplayed(), true);
    	Log.log(driver).info("Email field is present.");
    	Log.log(driver).info(this.emailField.getText());
    	String text =(this.emailField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text, "Email, Required, Text field");
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify Country field
     */
    public void verifyCountryField(){
    	
    	Log.log(driver).info("Verifying whether Country field is present or not....");
    	hardAssert.assertEquals(this.countryField.isDisplayed(), true);
    	Log.log(driver).info("Country field is present.");
    	Log.log(driver).info(this.countryField.getText());
    	String text =(this.countryField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text.contains("United States"), true);
    	Log.log(driver).info("The text field is United States by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    	
    }
    
    /**
     * This method is used to verify Address Line 1 Field
     */
    public void verifyAddressLine1Field(){
    	
    	Log.log(driver).info("Verifying whether Address Line 1 Field is present or not....");
    	hardAssert.assertEquals(this.addressLine1Field.isDisplayed(), true);
    	Log.log(driver).info("Address Line 1 Field is present.");
    	String text =(this.addressLine1Field.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text, "Address Line 1, Required, Text field");
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify Address Line 2 Field
     */
    public void verifyAddressLine2Field(){
    	
    	Log.log(driver).info("Verifying whether Address Line 2 Field is present or not....");
    	hardAssert.assertEquals(this.addressLine2Field.isDisplayed(), true);
    	Log.log(driver).info("Address Line 2 Field is present.");
    	String text =(this.addressLine2Field.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text, "Address Line 2, Text field");
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), false);
    	Log.log(driver).info("This is a not a required field");
    }
    
    /**
     * This method is used to verify City Field
     */
    public void verifyCityField(){
    	
    	Log.log(driver).info("Verifying whether City Field is present or not....");
    	hardAssert.assertEquals(this.cityField.isDisplayed(), true);
    	Log.log(driver).info("City Field is present.");
    	String text =(this.cityField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text, "City, Required, Text field");
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify State Field
     */
    public void verifyStateDropdownField(){
    	
    	Log.log(driver).info("Verifying whether State Field is present or not....");
    	hardAssert.assertEquals(this.stateDropdownField.isDisplayed(), true);
    	Log.log(driver).info("State Field is present.");
    	String text =(this.stateDropdownField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text, "State, Required, Dropdown");
    	Log.log(driver).info("The Dropdown field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify Zip Code Field
     */
    public void verifyZipCodeField(){
    	
    	Log.log(driver).info("Verifying whether Zip Code Field is present or not....");
    	hardAssert.assertEquals(this.zipCodeField.isDisplayed(), true);
    	Log.log(driver).info("Zip Code Field is present.");
    	String text =(this.zipCodeField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text, "ZIP or Postal Code, Required, Text field");
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify Password Field
     */
    public void verifyPasswordField(){
    	
    	Log.log(driver).info("Verifying whether Password Field is present or not....");
    	hardAssert.assertEquals(this.passwordField.isDisplayed(), true);
    	Log.log(driver).info("Password Field is present.");
    	String text =(this.passwordField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text.contains("Password hidden,"), false);
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    
    /**
     * This method is used to verify Confirm Password Field
     */
    public void verifyPasswordConfirmField(){
    	
    	Log.log(driver).info("Verifying whether Confirm Password Field is present or not....");
    	hardAssert.assertEquals(this.passwordConfirmField.isDisplayed(), true);
    	Log.log(driver).info("Confirm Password Field is present.");
    	String text =(this.passwordConfirmField.getText());
    	Log.log(driver).info(text);
    	hardAssert.assertEquals(text.contains("Password hidden,"), false);
    	Log.log(driver).info("The text field is blank by default");
    	hardAssert.assertEquals(text.contains("Required,"), true);
    	Log.log(driver).info("This is a required field");
    }
    
    /**
     * This method is used to verify password requirements text
     */
    public void verifyPasswordRequirementsText(){
    	
    	Log.log(driver).info("Verifying whether password requirements text is present or not....");
    	hardAssert.assertEquals(this.passwordRequirementsText.isEnabled(), true);
    	Log.log(driver).info("Password requirements text is present.");
    }
    
    /**
     * This method is used to verify WDIG Yes Receive Updates Text
     */
    public void verifyWDIGYesReceiveUpdatesText_USA(){
    	
    	Log.log(driver).info("Verifying whether WDIG Yes Receive Updates Text is present or not....");
    	hardAssert.assertEquals(this.wdigYesReceiveUpdatesText_USA.isDisplayed(), true);
    	Log.log(driver).info("WDIG Yes Receive Updates Text is present.");
    
    }
    
    /**
     * This method is used to verify Terms And Conditions Text
     */
    public void verifyTermsAndConditionsText(){
    	
    	Log.log(driver).info("Verifying whether Terms And Conditions Text is present or not....");
    	hardAssert.assertEquals(this.termsAndConditionsText.isDisplayed(), true);
    	Log.log(driver).info("Terms And Conditions Text is present.");
    
    }
    
   /**
     * This method is used to verify Create My Account Button is disabled by default.
     */
    public void verifyCreateMyAccountButtonDisabled(){
    	
    	Log.log(driver).info("Verifying whether Create My Account Button is disabled or not....");
    	hardAssert.assertEquals(this.createMyAccountButtonDisabled.isEnabled(), false);
    	Log.log(driver).info("Create My Account Button is disabled.");
    
    }
    
    /**
     * This method is used to verify all the elements oh the page.
     */
    public void verifyAllTheElements(){
    	
    	Log.log(driver).info("Trying to verify all the elements on the page....");
    	
    	this.verifyLetsSetupYourDisneyAccountHeader();
    	this.verifyBirthdayStaticTextFieldHeader();
    	this.verifyFirstNameField();
    	this.verifyLastNameField();
    	this.verifyEmailField();
    	this.verifyCountryField();
    	
    	AutomationTools tools = new AutomationTools();
    	tools.swipeScreenAnyDirection_IOS("up", 3, driver);
    	
    	this.verifyAddressLine1Field();
    	this.verifyAddressLine2Field();
    	this.verifyCityField();
    	this.verifyStateDropdownField();
    	this.verifyPasswordField();
    	this.verifyPasswordConfirmField();
    	this.verifyPasswordRequirementsText();
    	
    	tools.swipeScreenAnyDirection_IOS("up", 2, driver);
    	this.verifyWDIGYesReceiveUpdatesText_USA();
    	this.verifyTermsAndConditionsText();
    	this.verifyCreateMyAccountButtonDisabled();
    	
    	Log.log(driver).info("All the elements on the page are verified.");
    }
    
    /**
     * Create an MDX account. 
     * Sets valid values on all fields and then clicks on create account. Age>13
     * @param userDetails
     * @param country the country name for which to create user
     * @throws InterruptedException userInfo
     */
     public void createNewAccount(com.disney.appium.common.RegisterUser userInfo, String country, String state_text, MobileElement firstNameField, MobileElement lastNameField) throws InterruptedException
     {
         IOSAlerts_Page alert = new IOSAlerts_Page (driver);
         
         //TODO parameterize this method so that it takes in a country and then switches out element IDs relative to that country 
         //This is necessary for handling the various checkboxes that appear depending on the country you are creating an account for
         
         //Click on the birthday field
         birthdayField.click();
         
         //Print out the birth day, birth month, and the birth year
         System.out.println("DATE OF BIRTH IS: "+(userInfo.getBirth_day()+" "+userInfo.getBirth_month()+" "+userInfo.getBirth_year()));
         
         //Get the 3 different wheels in the datePickerWheel element
         List<MobileElement> birthdayWheels = datePickerWheel;
         
         //Testing has found that we need to tap on the element to ensure that it has focus
         MobileElement myBDWheel = (MobileElement) birthdayWheels.get(0);
         System.out.println("Clicking on the birthday element to actvate the date picker wheel...");
         myBDWheel.click();
         
         //Print out how many wheels the birthdayWheel has--which should always be 0
         System.out.println("Date picker size: " + birthdayWheels.size());
         
         //Set the month
         System.out.println("Setting the month...");
         ((MobileElement) birthdayWheels.get(0)).setValue(userInfo.getBirth_month());
         System.out.println("We think we've set the month.");
         //Set the day
         System.out.println("Setting the Day...");
         ((MobileElement) birthdayWheels.get(1)).setValue(userInfo.getBirth_day());
         System.out.println("We think we've set the day.");
         //Set the year
         System.out.println("Setting the year...");
         ((MobileElement) birthdayWheels.get(2)).setValue(userInfo.getBirth_year());
         System.out.println("We think we've set the year.");
                 
         //Click the Done button to dismiss the keyboard so that we can then click on other fields
         System.out.println("Clicking on the Done button...");
         this.doneButton.click();
         System.out.println("We think we've clicked on the Done button.");
         
         //Click on the country field to give it focus
         System.out.println("Clicking on the Country field...");
         countryField.click();
         System.out.println("We think we clicked on the Country field.");
         
         //Get the number of wheels in the countryPickerWheel -- should always be 0
         List<MobileElement> countryWheel = countryPickerWheel;
         System.out.println("Country picker size: " + countryWheel.size());
         
         //Set the country as specified in the UserRegister.json file
         System.out.println("Setting the Country as: " + country);
         ((MobileElement) countryWheel.get(0)).setValue(country);
         System.out.println("We think we set the country as: " + country);
         
         //Click the Done button
         System.out.println("Clicking on the Done button...");
         this.doneButton.click();
         System.out.println("We think we clicke don the Done button.");
         
         //Get the firstName from the userInfo object
         String fName = userInfo.getFirstName();
         System.out.println("Setting first name as: " + fName);
         //Type the first name into the firstNameField
         this.firstNameField.sendKeys(fName);
         System.out.println("We think we set the first name as: " + fName);
         
         //Get the lastName from the userInfo object
         String lName = userInfo.getLastName();
         System.out.println("Setting last name as: " + lName);
         //Enter the lastName into the lastNameField
         this.lastNameField.sendKeys(lName);
         System.out.println("We think we set the last name as: " + lName);
         
         //Get the email address from the userInfo object
         String eMail = userInfo.getEmail();
         System.out.println("Setting email as: " + eMail);
         //Enter the email address
         this.emailField.sendKeys(eMail);
         System.out.println("We think we set the email address as: " + eMail);
         
         //Get the address from addressLine1 in the userInfo object
         String addressLine1 = userInfo.getAddressLine1();
         System.out.println("Setting address line 1 as: " + addressLine1);
         //Enter the address on the address line 1 field
         this.addressLine1Field.sendKeys(addressLine1);
         System.out.println("We think we set address field 1 as: " + addressLine1);
         
         //Get the City from the userInfo object
         String city = userInfo.getCity();
         System.out.println("Setting city as: " + city);
         //Enter the City
         this.cityField.sendKeys(city);
         System.out.println("We think we set the city as: " + city);
         
         //Click on the State line to bring up the pickWheel
         System.out.println("Clicking on the State field...");
         this.stateDropdownField.click();
         System.out.println("We think we clicked on the State field.");

         //Choose the state that is specified in the call made by the test case      
         List<MobileElement> stateWheel = statePickerWheel;
         System.out.println("State picker size: " + stateWheel.size());
         System.out.println("Setting the State as: " + state_text);
         ((MobileElement) stateWheel.get(0)).setValue(state_text);
         System.out.println("We think we set the State as: " + state_text);
         
         //Click the Done button
         System.out.println("Clicking on the Done button...");
         this.doneButton.click();
         System.out.println("We think we clicked on the Done button.");
         
         //Get the zip code from the userInfo object
         System.out.println("Getting zip code from userInfo object...");
         String zip = userInfo.getZipCode();
         //Enter the zip code
         System.out.println("Setting zip code as: " + zip);
         this.zipCodeField.sendKeys(zip);
         System.out.println("We think we set the zip code as: " + zip);

         //Click the Done button
         System.out.println("Clicking on the Done button...");
         this.doneButton.click();
         System.out.println("We think we clicke don the Done button.");
         
         //Get the password from the userInfo object
         System.out.println("Getting the password from the userinfo objects...");
         String pw = userInfo.getPassword();
         //Set the password on the first password entry field
         System.out.println("Setting the password as: " + pw);
         this.passwordField.sendKeys(pw);
         System.out.println("We think we set the password as: " + pw);
         //Send the password again on the confirm password field
         System.out.println("Setting the confirmation password now...");
         this.passwordConfirmField.sendKeys(pw);
         System.out.println("We think we verified the confirmation password as: " + pw);
         
         //Click te Done button
         System.out.println("Clicking on the Done button...");
         this.doneButton.click();
         System.out.println("We think we clicked on the Done button.");
         
         //Click on the Terms and Conditions checkbox for a USA account
         System.out.println("Placing a check in the Terms and Conditions checkbox...");
         this.termsAndConditionsCheckbox.click();
         System.out.println("We placed a check in the Terms and Conditions checkbox");
         
         System.out.println("Click on the activated \"Create My Account\" button...");
         this.createMyAccountButtonEnabled.click(); 
         System.out.println("We think we clicked on Create My Account button");
         
         //wait  for account creation time
         System.out.println("Pausing for 5 seconds as we wait for the server to create the account...");
         Thread.sleep(5000);
         
         //Click the OK button
         System.out.println("Clicking on the \"OK\" button in the successful Account Creatinon alert...");
         alert.clickOnOKButton();
         System.out.println("We think we clicked the \"OK\" button in the alert.");
        
     }

    /**
     * This method sets Birthday Date to 'October 13, 1983'
     */
    public void setBirthdayDate()
    {
        this.birthdayField.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();

        //Start with 0
        int x = 0;

        //While x is less than 10, run through the loop
        while (x < 12)
        {
            //Decrement the current year by rolling backwards
            params.put("order", "next");
            //This selects where on the wheel to touch
            params.put("offset", 0.15);
            params.put("element", ((MobileElement) this.PickerWheel.get(0)));
            js.executeScript("mobile: selectPickerWheelValue", params);
            params.put("element", ((MobileElement) this.PickerWheel.get(1)));
            js.executeScript("mobile: selectPickerWheelValue", params);
            params.put("element", ((MobileElement) this.PickerWheel.get(2)));
            //This is where the executor implements the parameters
            js.executeScript("mobile: selectPickerWheelValue", params);
            //Add loop runs here
            x++;

        }
        //Click the Done button to exit the pickerWheel
        System.out.println("Trying to click on the Done button...");
        (new TouchAction(driver)).tap(335, 431).perform();
        Log.log(driver).info("Birthday: "+birthdayFieldUserBirthdayEntry.getText());
        System.out.println("We think we clicked on the Done button...");
    }


    /**
     * setFirstName
     * @param fname - First Name to be typed down
     */
    public void setFirstName(String fname)
    {
        AutomationTools.waitForElementToLoad( driver , firstNameField , 60 );
        hardAssert.assertEquals(firstNameField.isDisplayed(),true);
        this.firstNameField.sendKeys( fname );
        AutomationTools.closeKeyboard( driver );
        Log.log(driver).info( "Sent First Name: " + fname );
    }

    /**
     * setLastName
     * @param lname - Last name to be typed down
     */
    public void setLastName(String lname)
    {
        AutomationTools.waitForElementToLoad( driver , lastNameField , 60 );
        hardAssert.assertEquals(lastNameField.isDisplayed(),true);
        this.lastNameField.sendKeys( lname );
        AutomationTools.closeKeyboard( driver );
        Log.log(driver).info( "Sent Last Name: " + lname );
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
        Log.log(driver).info( "Email: " + userEmail );
        (new TouchAction(driver)).tap(335, 431).perform();
    }

    /**
     * This method sets Country to United Kingdom
     */
    public void setCountry()

    {
        this.countryField.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();

        //Start with 0
        int x = 0;

        //While x is less than 2, run through the loop
        while (x < 2)
        {
            //Decrement the current year by rolling backwards
            params.put("order", "next");
            //This selects where on the wheel to touch
            params.put("offset", 0.15);
            params.put("element", ((MobileElement) this.PickerWheel.get(0)));
            //This is where the executor implements the parameters
            js.executeScript("mobile: selectPickerWheelValue", params);
            //Add loop runs here
            x++;
        }
        //Click the Done button to exit the pickerWheel
        System.out.println("Trying to click on the Done button...");
        this.doneButton.click();
        String country = this.countryFieldUserCountryEntry.getText();
        Log.log(driver).info("Selects Country: " +country);
        System.out.println("We think we clicked on the Done button...");
    }

    /**
     * This method is used to enter the address in the address1 text field
     * @param address1
     */
    public void setAddress1( String address1 )
    {
        AutomationTools.waitForElementToLoad( driver , createAccountNavigationBar , 60 );
        hardAssert.assertEquals(addressLine1Field.isDisplayed(),true);
        this.addressLine1Field.sendKeys( address1 );
        Log.log(driver).info( "Typed Address1: " + address1 );
        (new TouchAction(driver)).tap(335, 431).perform();
    }

    /**
     * This method is used to enter the city name in City text field
     * @param city
     */
    public void setCity(String city)
    {
        hardAssert.assertEquals(cityField.isDisplayed(),true);
        cityField.sendKeys(city);
        AutomationTools.closeKeyboard( driver );
        Log.log(driver).info( "Typed City: " + city );
        (new TouchAction(driver)).tap(335, 431).perform();
    }

    /**
     * This method is used to enter the zip code in the Zip code text field
     * @param zipcode
     */
    public void setZipCode(String zipcode)
    {
        hardAssert.assertEquals(zipCodeField.isDisplayed(),true);
        zipCodeField.sendKeys( zipcode );
        //AutomationTools.closeKeyboard( driver );
        Log.log(driver).info( "Typed ZIPCode: " + zipcode );
        (new TouchAction(driver)).tap(335, 431).perform();
    }

    /**
     * This method is used to enter the password in password text field
     * @param
     */
    public void setPassword(String Password)
    {
        hardAssert.assertEquals(passwordField.isDisplayed(),true);
        passwordField.sendKeys(Password);
        Log.log(driver).info( "Typed Password: " + Password);
        (new TouchAction(driver)).tap(335, 431).perform();
    }

    /**
     * This method is used to enter the password in confirm password text field
     * @param confirmPassword
     */
    public void setConfirmPassword( String confirmPassword )
    {
        hardAssert.assertEquals(passwordConfirmField.isDisplayed(),true);
        passwordConfirmField.sendKeys(confirmPassword);
        Log.log(driver).info( "Typed on Confirm Password: " + confirmPassword );
        (new TouchAction(driver)).tap(335, 431).perform();
    }

    /**
     * This method is used to accept the parkconditons box
     */
    public void checkParkConditionsBox()
    {
        AutomationTools tools = new AutomationTools();
        tools.swipeScreenAnyDirection_IOS("up",1,driver);
        this.wdigFamilySitesCheckbox.click();
        Log.log(driver).info("Clicked on wdig Family sites checkbox");
        this.supplementalTermsCheckBox.click();
        Log.log(driver).info("Clicked on Supplemental terms checkbox");
        this.createMyAccountButtonEnabled.click();
        System.out.println("We think we clicked on Create My Account button");
    }
    /**
     * This method is used to Set County
     * @param county
     */
    public void setCounty( String county)
    {
        hardAssert.assertEquals(countyTextField.isDisplayed(),true);
        countyTextField.sendKeys(county);
        Log.log(driver).info( "Entered County: " + county );
        this.doneButton.click();
    }


    /**
     * creates International Adult Account
     * class with user data to create account
     */
    public void createInternationalAdultAccount()
    {
        setBirthdayDate();
        setFirstName("FirName");
        setLastName("LasName");
        String userEmail = "testmail" + System.currentTimeMillis() / 1000L + "@mailinator.com";
        setEmail(userEmail);
        setCountry();
        setAddress1("Big Ben,Westminster");
        setCity("London");
        setCounty("Greater London");
        setZipCode("SW1A 0AA");
        setPassword("secret$2");
        setConfirmPassword("secret$2");
        checkParkConditionsBox();

    }
    /**
     * This method is used to verify the confirmation message after creating the account.
     */
    public void verifyIfConfirmationMessageIsDisplayed(){

        Log.log(driver).info("Verifying whether or not the confirmation message is displayed");
        hardAssert.assertEquals(confirmationMessage.isDisplayed(),true);
        Log.log(driver).info("Confirmation message displayed");
    }

    /**
     * This method is used to verify if error message is displayed if guest tries to create an account with Common password
     */
     public void verifyIfAlertMessageDisplayedWhileCreatingAccountWithCommonPwd()
     {
         setFirstName("FirName");
         setLastName("LasName");
         String userEmail = "testmail" + System.currentTimeMillis() / 1000L + "@mailinator.com";
         setEmail(userEmail);
         setAddress1("Town Creek Park");
         setCity("Auburn");
         setZipCode("36832");
         setPassword("0000000000d");
         setConfirmPassword("0000000000d");
         checkParkConditionsBox();
         Log.log(driver).info("Trying to verify if Alert message is displayed.....");
         hardAssert.assertEquals(alertMessageDisplayedWhileCreatingAccountWithCommonPwd.isEnabled(),true);
         Log.log(driver).info("Alert message displayed");
     }
    /**
     * This method is used to verify if Create Account screen is displayed by validating its header
     */
    public void verifyIfCreateAccountScreenIsDisplayed(){

        Log.log(driver).info("Trying to verify whether Create Account screen is displayed or not....");
        hardAssert.assertEquals(createAccountHeader.isDisplayed(),true);
        Log.log(driver).info("Create Account screen displayed");
    }

    
    /**

     * This method is used to verify the password alert with less than 2 character types 
     */
    public void verifyPasswordCharacterTypesErrorMessage(){

        Log.log(driver).info("Verifying whether or not the password character types message is displayed");
        hardAssert.assertEquals(passwordCharacterTypesErrorMessage.isDisplayed(),true);
        Log.log(driver).info("password character types message displayed");
    }
       
    /**
     * This method is used to click on create my account button
     */
    public void clickCreateAccountButton(){
    		System.out.println("Click on the activated \"Create My Account\" button...");
        this.createMyAccountButtonEnabled.click(); 
        System.out.println("We think we clicked on Create My Account button");
    }
    
    /**
     * This method is used to verify create account page is displayed.
     */
    public void verifyCreateAccountPageIsDisplayed(){

        Log.log(driver).info("Verifying whether or not the create account page is displayed");
        hardAssert.assertEquals(createAccountNavigationBar.isDisplayed(),true);
        Log.log(driver).info("Confirmation page displayed");
    }


    /**
     * This method is used to click on close button
     */
    public void clickOnCloseButton(){
    		System.out.println("Click on Close button...");
        this.closeButton.click(); 
        System.out.println("We think we clicked on Close button");
    }
   

    
    /**
     * This method is used to select a state
     * @param state - state to be selected
     */
    public void setState(String state_text)
    {
    		AutomationTools.waitForElementToLoad( driver , stateDropdownField , 60 );
    		hardAssert.assertEquals(stateDropdownField.isDisplayed(),true);
    		System.out.println("Clicking on the State field...");
    		this.stateDropdownField.click();
    		System.out.println("We think we clicked on the State field.");

    		//Choose the state that is specified in the call made by the test case      
    		List<MobileElement> stateWheel = statePickerWheel;
    		System.out.println("State picker size: " + stateWheel.size());
    		System.out.println("Setting the State as: " + state_text);
    		((MobileElement) stateWheel.get(0)).setValue(state_text);
    		System.out.println("We think we set the State as: " + state_text);
    		this.doneButton.click();
    }

    /**
     * This method is used to verify the password phone number message after create an account
     */
    public void verifyPasswordPhoneNumberMessage(){

        Log.log(driver).info("Verifying whether or not the password phone number message is displayed");
        hardAssert.assertEquals(passwordPhoneNumberMessage.isDisplayed(),true);
        Log.log(driver).info("password phone number message displayed");
    }


}
    

