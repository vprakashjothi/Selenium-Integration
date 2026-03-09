package tests;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import base.BaseTest;
import utils.ExcelUtil;
import utils.FailureNotification;
import utils.ScreenshotUtil;
import pages.LoginPage;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.*;
public class LoginTest extends BaseTest{
	LoginPage loginPage;
	@BeforeSuite
	public void Initialise() throws Exception{
		loginPage = new LoginPage(driver);
		Reporter.log("Before class executed", true );	
		
	}
	
	@Test
    public void loginTest1() throws Exception {
		Reporter.log("Test Case 1 Executing", true );	
		//LoginPage loginPage = new LoginPage(driver);  // use when not implementing thread safe 
        loginPage.assertMainpage(driver.getTitle().toString());
		//LoginPage loginPage = new LoginPage(getDriver());  
		//loginPage.assertMainpage(getDriver().getTitle().toString());
        Reporter.log("Test Case 1 Executed", true );	
	}
	
	@Test
    public void loginTest2() throws Exception {
        Reporter.log("Test Case 2 Executing", true );			
		String path=ExcelUtil.getCellData("Sheet1", 1, 2);
        String username = ExcelUtil.getCellData("Sheet1", 1, 3);
        String password = ExcelUtil.getCellData("Sheet1", 1, 4);
        //LoginPage loginPage = new LoginPage(driver);
        loginPage.login(path,username, password);
        loginPage.loginAssertionTrue(driver.getTitle().toString());
        Reporter.log("Test Case 2 Executed", true );		
	}
	@Test
    public void loginTest3() throws Exception {
		   Reporter.log("Test Case 3 Executing", true );	
		String path=ExcelUtil.getCellData("Sheet1", 2, 2);
        String username = ExcelUtil.getCellData("Sheet1", 2, 3);
        String password = ExcelUtil.getCellData("Sheet1", 2, 4);
        //LoginPage loginPage = new LoginPage(driver);
        loginPage.login(path,username, password);
        loginPage.loginAssertionFalse();
        Reporter.log("Test Case 3 Executed", true );	

	}
	@Test
    public void loginTest4() throws Exception {
		   Reporter.log("Test Case 4 Executing", true );	
		String path=ExcelUtil.getCellData("Sheet1", 3, 2);
     String username = ExcelUtil.getCellData("Sheet1", 3, 3);
     String password = ExcelUtil.getCellData("Sheet1", 3, 4);
     //LoginPage loginPage = new LoginPage(driver);
     loginPage.login(path,username, password);
     loginPage.loginAssertionFalse();
     Reporter.log("Test Case 4 Executed", true );	
//     driver.manage().timeouts().implicitlyWait(null);

	}
	@Test
    public void loginTest5() throws Exception {
		   Reporter.log("Test Case 5 Executing", true );	
		String path=ExcelUtil.getCellData("Sheet1", 4, 2);
     String username = ExcelUtil.getCellData("Sheet1", 4, 3);
     String password = ExcelUtil.getCellData("Sheet1", 4, 4);
     //LoginPage loginPage = new LoginPage(driver);
     loginPage.login(path,username, password);
     loginPage.loginAssertionFalse();
     Reporter.log("Test Case 5 Executed", true );	

	}	
	
	
	
	
	 @AfterMethod
	    public void captureFailure(ITestResult result) throws Exception {

	        if (ITestResult.FAILURE == result.getStatus()) {
	            //Screenshot attach on failure
	        	ScreenshotUtil.attachScreenshot(driver);
	            //Notification Push 
	            Reporter.log("TestName: "+result.getTestName()+"\nName: "+result.getName()+"\nMethod: "+result.getMethod()+"\n"+result.getAttributeNames(), true);
	            FailureNotification.NotificationPush(result.getName(),result.getTestName());
	            //FailureNotification.removeNotification();
	        }


	    }
	 
	 
	
	
}
