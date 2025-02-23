package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/




public class TC003_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void verify_LoginDDT(String email, String password, String exp) {
		
        try {
			logger.info("******* Starting TC002_LoginTest ********");
			
			
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				logger.info("Cliked MyAcoount");
				hp.clickLogin();
				logger.info("Login Page is opened");
				
				LoginPage lp= new LoginPage(driver);
				lp.SetEmail(email);
				logger.info("Email is given");
				lp.SetPassword(password);
				logger.info("Password is given");
				lp.Login();
				logger.info("*****Logged in *****");
				
				MyAccountPage mcp= new MyAccountPage(driver);
				boolean result = mcp.isMyAccountExists();
				
				if (exp.equalsIgnoreCase("Valid"))
				{
					if (result==true) 
					{
						mcp.clickLogout();
						Assert.assertTrue(true);
						
					} 
					else 
					{
						Assert.assertTrue(false);
					}
					
				}
				
				if (exp.equalsIgnoreCase("Invalid"))
				{
					if (result==true) 
					{
						mcp.clickLogout();
						Assert.assertTrue(false);
						
					} 
					else 
					{
						Assert.assertTrue(true);
					}
					
				}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("********* Finished  ***********");	
		
	}
	

}
