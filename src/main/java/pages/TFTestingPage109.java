package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TFTestingPage109 {

	WebDriver driver;

	public TFTestingPage109(WebDriver driver) {

		this.driver = driver;

	}

	// DashBoard Elements

	@FindBy(how = How.CSS, using = "button[onclick='myFunctionSky()']")
	public WebElement SkyBlueBackgroundButton;

	@FindBy(how = How.CSS, using = "button[onclick='myFunctionWhite()']")
	public WebElement WhiteBackgroundButton;

	@FindBy(how = How.CSS, using = "body[style='background-color: skyblue;")
	public WebElement SkyBlueBackgroundColor;

	@FindBy(how = How.CSS, using = "button[onclick='myFunctionWhite()']")
	public WebElement WhiteBackgroundColor;

	// Element Action

	public String validateBackgroundColor() {
// getting background color attribute with getCssValue()
		String bckgclr = driver.findElement(By.xpath("/html/body")).getCssValue("background-color");
		return bckgclr;

	}

	public String validateIfButtonExits(WebElement webElement) {

		String buttonColorText = webElement.getText();
		return buttonColorText;
	}

}
