package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	
	WebDriver driver;

	// parameterized constructor initialized when class is instantiated [object created]
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory class help to instantiate WebElements
		// Important interview question
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//*[@src='/content/dam/alfa/cross/integrations/header/logo-alfa-white.png']")
	WebElement logo;
	
	
	public void clickLogo() {
		logo.click();
	}
	
	

}
