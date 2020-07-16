package Android_PageObjects.Tutorial_Android;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.disney.appium.common.AppiumConstants;
import com.disney.appium.common.AutomationTools;
import com.disney.selenium.common.Log;

import Android_PageObjects.Common_Android.Alerts_Page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


/**
 * This is the MDX Tutorial Page page object for Android
 * @author Swathi Jajula
 */
public class Tutorial_Page {
	private AppiumDriver driver;


	  /*
	   * This is the title for the Tutorial screen
	   */

	  //  @AndroidFindBy( xpath = "//android.widget.TextView[@text='Enjoy Our Streamlined Design']" ) <--Production build xpath
     // @AndroidFindBy( xpath = "//android.widget.TextView[@text='Renew Eligible Annual Passes']" )

      @AndroidFindBy( id = "com.disney.wdw.android.debug:id/tutorial_pager" )
	  private MobileElement tutorial_Title1;

 
      /*
       * This is the Close Button at the top of the tutorial page for the PRODUCTION build
       */
      @AndroidFindBy( id = "com.disney.wdw.android.debug:id/img_pulldown_button" )
      private MobileElement tutorial_closeButton_Production;
      
      /*
       * This is the tutorial close button found on the DEBUG build
       */
	  //@AndroidFindBy( id = "com.disney.wdw.android.debug:id/pulldown_image" )
	  @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
	  private MobileElement tutorial_close;
	  
	  /*
	 * This is the tutorial page itself and should be used to find the existence
	 * of tutorial page
	 */
      @AndroidFindBy( id = "com.disney.wdw.android.debug:id/tutorial_pager" )
      private MobileElement tutorial_Page;
      
      /**
       * 
       */
	  @AndroidFindBy(id="com.disney.wdw.android.debug:id/pulldown_image")
	  private MobileElement pullDownImage;
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public Tutorial_Page(final AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(
				new AppiumFieldDecorator(driver, AppiumConstants.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS), this);
	}

	/**

	 * dismiss - dismisses the tutorial screen at startup
	 * 
	 * @return true if Tutorial screen is displayed
	 */
	public void dismiss() {
		if (verifyTutorialScreen()) {
			this.clickOnDismissTutorial();
		}
	}
		/*
	 * This method dismisses the Tutorial Screen at startup
	 */
	public void dismissTutorial(){
	    System.out.println("Dismissing the Tutorial if found...");
		this.clickOnDismissTutorial();
        System.out.println("We think we dismissed the tutorial.");
	Alerts_Page              alerts                = new Alerts_Page(driver);

	// Accept Alerts
	alerts.acceptAlerts();
		}

	/**
	 * verifyTutorialScreen
	 * 

	 * This method verifies that the title for the Tutorial screen is displayed
	 * @return true if Tutorial screen is displayed
	 */
	public boolean verifyTutorialScreen() throws TimeoutException {
		System.out.println("Waiting for " + this.tutorial_Title1);
		AutomationTools.waitForElementToLoad(driver, this.tutorial_Title1, 60);
		Assert.assertEquals(true, this.tutorial_Title1.isDisplayed(), "Tutorial screen not found");
		Log.log(driver).info("Verified that the title for the Tutorial screen is displayed.");
		return true;
	}

	/**
	 * clickOnDismissScreen
	 * 
	 * This method dismisses the Tutorial screen by clicking on the Close button
	 * @return true if closed
	 */
	public boolean clickOnDismissTutorial() throws TimeoutException {
		AutomationTools.waitForElementToLoad(driver, this.tutorial_close, 80);
		Assert.assertEquals(true, this.tutorial_close.isDisplayed());
		this.tutorial_close.click();
		Log.log(driver).info("We think we clicked on the Dismiss Tutorial button.");
		Alerts_Page              alerts                = new Alerts_Page(driver);

		// Accept Alerts
		alerts.acceptAlerts();
		return true;
			}
	
	/**
	 * clickOnDismissScreen
	 * 
	 * This method dismisses the Tutorial screen by clicking on the Close button
	 * @return true if closed
	 */
	public boolean clickOnPullDownImage() throws TimeoutException {
		AutomationTools.waitForElementToLoad(driver, this.pullDownImage, 80);
		Assert.assertEquals(true, this.pullDownImage.isDisplayed());
		this.pullDownImage.click();
		Log.log(driver).info("We think we clicked on the pulldown button.");
		return true;
	}	
}

