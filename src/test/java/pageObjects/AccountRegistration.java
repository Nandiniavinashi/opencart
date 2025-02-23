package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

	public AccountRegistration(WebDriver driver) {
		super(driver);
		
	}
	
@FindBy(xpath = "//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath = "//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath = "//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath = "//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath = "//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath = "//input[@id='input-confirm']")
WebElement txtConfirmPassword;

@FindBy(xpath = "//input[@name='agree']")
WebElement chkPolicy;

@FindBy(xpath = "//input[@type='submit']")
WebElement btnContinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}

public void setLastname(String lname) {
	txtLastname.sendKeys(lname);
}
public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setTelephone(String telephone) {
	txtTelephone.sendKeys(telephone);
}

public void setPassword(String pass) {
	txtPassword.sendKeys(pass);
}

public void setConfirmPassowrd(String pass) {
	txtConfirmPassword.sendKeys(pass);
}

public void checkPolicy() {
	chkPolicy.click();
}

public void clickContinue() {
	btnContinue.click();
}

public String getConfirmation() {
	try {
		return msgConfirmation.getText();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return (e.getMessage());
	}
}

}
