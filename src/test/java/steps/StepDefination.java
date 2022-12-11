package steps;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.TFTestingPage109;
import pages.TestBase;

public class StepDefination extends TestBase {

	TFTestingPage109 tFTestingPage109;
	String skyblueButtonText = "Starting Value";
	String SkyWhiteButtonText = "Starting Value";

	@Before
	public void setUp() {
		initDriver();
		tFTestingPage109 = PageFactory.initElements(driver, TFTestingPage109.class);

	}

	@Given("^\"([^\"]*)\" button exists$")
	public void button_exists(String button) {
		driver.get("https://techfios.com/test/109/index.php");

		if (button.equalsIgnoreCase("Set SkyBlue Background")) {
			skyblueButtonText = tFTestingPage109.validateIfButtonExits(tFTestingPage109.SkyBlueBackgroundButton);
			System.out.println("STEP#1 --> Button text " + skyblueButtonText);
		} else if (button.equalsIgnoreCase("Set SkyWhite Background")) {
			SkyWhiteButtonText = tFTestingPage109.validateIfButtonExits(tFTestingPage109.WhiteBackgroundButton);
			System.out.println("STEP#1 --> Button text " + SkyWhiteButtonText);
		} else {
			System.out.println("Unable to find button:");
		}

	}

	@When("^I click on the button$")
	public void i_click_on_the_button() {
		if (skyblueButtonText.equalsIgnoreCase("Set SkyBlue Background")) {
			tFTestingPage109.SkyBlueBackgroundButton.click();
			System.out.println("STEP#2 --> Set SkyBlue Background Clicked" );
		} else if (SkyWhiteButtonText.equalsIgnoreCase("Set White Background")) {
			tFTestingPage109.WhiteBackgroundButton.click();
			System.out.println("STEP#2 --> Set White Background Clicked" );
		} else {
			System.out.println("Unable to find button:");
		}

	}

	@Then("^the background color will change to \"([^\"]*)\"$")
	public void the_background_color_will_change_to(String backgroundColor) {

		if (skyblueButtonText.equalsIgnoreCase("Set SkyBlue Background")) {
			String expectedSkyblueRGBA = tFTestingPage109.validateBackgroundColor();
			String actualedSkyblueRGBA = ("rgba(135, 206, 235, 1)");
			System.out.println("STEP#3 --> Assert Successful for Sky Blue Background");
			Assert.assertEquals("Backgound color does not match", expectedSkyblueRGBA, actualedSkyblueRGBA);

		} else if (SkyWhiteButtonText.equalsIgnoreCase("Set White Background")) {
			String expectedWhiteRGBA = tFTestingPage109.validateBackgroundColor();
			String actualdWhiteRGBA = ("rgba(255, 255, 255, 1)");
			System.out.println("STEP#3 --> Assert Successful for White Background");
			Assert.assertEquals("Backgound color does not match", expectedWhiteRGBA, actualdWhiteRGBA);

		} else {
			System.out.println("Unable to find background color RGBA:");
		}

	}

}
