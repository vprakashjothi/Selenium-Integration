package base;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import utils.ExtentManager;
public class BaseTest {
	ConfigReader config=new ConfigReader();
	protected WebDriver driver;                  // Not thread safe
//	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();  // Thread safe for implementing screenshot listener 
	ChromeOptions chromeOption=new ChromeOptions();
	FirefoxOptions firefoxOption=new FirefoxOptions();
	
	@BeforeSuite
public void Setup() {
		
		Reporter.log("Before suit started", true );
		String browser=config.Property("browser");
		String url=config.Property("url");
		String mode=config.Property("mode");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			if(mode.equalsIgnoreCase("headless")) {
				chromeOption.addArguments("--headless=new");  // Chrome 109+
				chromeOption.addArguments("--disable-gpu");
				chromeOption.addArguments("--window-size=1920,1080");	
				driver = new ChromeDriver(chromeOption);
				//driver.set(new ChromeDriver(chromeOption));
			}	
			else {
				driver = new ChromeDriver();
				//driver.set(new ChromeDriver());
	
			}
			Reporter.log("Driver initialised", true );	
				
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			if(mode.equalsIgnoreCase("headless")) {
				firefoxOption.addArguments("--headless=new");  // Chrome 109+
				firefoxOption.addArguments("--disable-gpu");
				firefoxOption.addArguments("--window-size=1920,1080");	
				driver = new FirefoxDriver(firefoxOption);
				//driver.set(new FirefoxDriver(firefoxOption));
			}
			else {
				driver = new FirefoxDriver();
				//driver.set(new FirefoxDriver());

			}
			Reporter.log("Driver initialised", true );	
		}
		driver.manage().window().maximize();
		driver.get(url);
		//getDriver().manage().window().maximize();
        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //getDriver().get(url);
		ExtentManager.createTest("Test Started");
}
/*
	 public static WebDriver getDriver() {
	        return driver.get();
	    }	
*/
	
@AfterSuite
public void TearDown() {
	if (driver != null) {
        driver.quit();
        ExtentManager.flushReport();
        Reporter.log("Driver quiting", true );	
        Reporter.log("After suit executed", true );			
    }
}

		

	
}
