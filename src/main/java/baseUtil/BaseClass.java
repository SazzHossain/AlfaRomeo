package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;

public class BaseClass {
	
	// Why default type is not ok for below 2 line? 
	// because different package accessibility is not possible for default type
	public WebDriver driver; // = new ChromeDriver(); we will keep the drive ouside of the method so we can use it anywhere.
	public HomePage homePage;
	
	@BeforeMethod
	public void starting() {
		// First job is to recognize the location of driver from your Framework
		// right click on chromedriver.exe(windows)/chromedriver(mac) ---> properties ---> copy the location and paste below
		// System is a Java class and setProperty is a method of System Class		
		// 1st way, to show the location of chrome driver
		// This is an absolute path
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\msazz\\eclipse-workspace\\com.alfaromeousa\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize(); //to maximize the window
		 driver.manage().deleteAllCookies(); // to delete all cookies
		 driver.get("https://www.alfaromeousa.com");
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); //if the page load withing few sec, it will not wait till 20 sec.
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait is used to wait for each web element	 
		 homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void ending(){
		driver.quit();
	}
	
	

}
