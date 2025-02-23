package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registeration() {
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link.. ");
			hp.clickRegister();
			logger.info("Clicked on Register Link.. ");
			
			// account registration
			
			AccountRegistration repage =new AccountRegistration(driver);
			logger.info("Providing customer details...");
			repage.setFirstName(randomString().toUpperCase());
			repage.setLastname(randomString().toUpperCase());
			repage.setEmail(randomString()+"@gmail.com");
			
			String password= AlphaNumeric();
			repage.setTelephone(randomNumber());
			repage.setPassword(password);
			repage.setConfirmPassowrd(password);
			repage.checkPolicy();
			repage.clickContinue();
			
			logger.info("Validating expected message..");
			String confmsg=repage.getConfirmation();
			if (confmsg.equals("Your Account Has Been Created!")) {
				
				Assert.assertTrue(true);
				
			} else {
				
			
				logger.error("Test Filed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);

			}
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		} catch (Exception e) {
			
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
}


