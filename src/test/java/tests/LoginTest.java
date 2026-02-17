package tests;
import org.testng.Reporter;
import org.testng.annotations.*;

import base.BaseTest;
import utils.ExcelUtil;
import pages.LoginPage;
import org.openqa.selenium.*;
public class LoginTest extends BaseTest{
	@Test
    public void loginTest1() throws Exception {
		Reporter.log("Test Case 1 Executing", true );	
        LoginPage loginPage = new LoginPage(driver);
        loginPage.assertMainpage(driver.getTitle().toString());
        Reporter.log("Test Case 1 Executed", true );	
	}
	
	@Test
    public void loginTest2() throws Exception {
        Reporter.log("Test Case 2 Executing", true );			
		String path=ExcelUtil.getCellData("Sheet1", 1, 2);
        String username = ExcelUtil.getCellData("Sheet1", 1, 3);
        String password = ExcelUtil.getCellData("Sheet1", 1, 4);
        LoginPage loginPage = new LoginPage(driver);
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(path,username, password);
        loginPage.loginAssertionFalse();
        Reporter.log("Test Case 3 Executed", true );	

	}
	
	
	
	
}
