package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.Reporter;
public class LoginPage {
	WebDriver driver;
	private  @FindBy(id="username")
	WebElement username;
	
	private @FindBy(id="password")
	WebElement password;
	
	private @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submit;
	

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);  
		
	}
	
	public void login(String path,String user, String pass) {
		driver.get(path);
		username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();
    }
	
	public void assertMainpage(String title) {
		Assert.assertEquals(title,driver.getTitle().toString());
		
	}
	public void loginAssertionTrue(String value) {
		Assert.assertEquals(value,"Logged In Successfully | Practice Test Automatio" ,"Assertion is good for right credentials");
		Reporter.log("Logged in Successfully", true );
		
	}
	public void loginAssertionFalse() {
		
		WebElement fail=driver.findElement(By.xpath("//*[contains(text(),'Your username is invalid!')]"));		
		Reporter.log("Your username is invalid!", true );
		Assert.assertEquals(fail.getText(), "Your username is invalid!","Assertion for wrong credentials");
	}
	
	
	
}
