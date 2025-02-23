package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity","Master"})
	 public void verify_Login() {
		
		logger.info("******* Starting TC002_LoginTest ********");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Cliked MyAcoount");
			hp.clickLogin();
			logger.info("Login Page is opened");
			
			LoginPage lp= new LoginPage(driver);
			lp.SetEmail(p.getProperty("email"));
			logger.info("Email is given");
			lp.SetPassword(p.getProperty("password"));
			logger.info("Password is given");
			lp.Login();
			logger.info("*****Logged in *****");
			
			MyAccountPage mcp= new MyAccountPage(driver);
			boolean result = mcp.isMyAccountExists();
			
			Assert.assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}
		
		logger.info("****** Finished ******");
		
		
	}
	
	

}
