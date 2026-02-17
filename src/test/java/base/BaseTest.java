package base;
import org.testng.Reporter;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import utils.ExtentManager;
public class BaseTest {
	ConfigReader config=new ConfigReader();
	public static WebDriver driver;
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
			}	
			else
				driver = new ChromeDriver();
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
			}
			else
				driver = new FirefoxDriver();
			Reporter.log("Driver initialised", true );	
			

		}
		driver.manage().window().maximize();
		driver.get(url);
		ExtentManager.createTest("Test Started");
}
	
	
@AfterSuite
public void TearDown() {
	if (driver != null) {
        driver.quit();
        ExtentManager.flushReport();
        Reporter.log("Driver quiting", true );	
        Reporter.log("After suit executed", true );	
		
    }
}

@BeforeMethod
public void BeforeTestcases() {
	Reporter.log("Before Method TestCase Executing", true );
	
}
@AfterMethod
public void AfterTestcases() {
	Reporter.log("After Method TestCase Executing", true );
	
}
		

	
}
