package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath= "//input[@id='input-email']")
WebElement enterEmail;

@FindBy(xpath = "//input[@id='input-password']")
WebElement enterPassword;

@FindBy(xpath = "//input[@value='Login']")
WebElement btnLogin;

public void SetEmail(String Email) {
	enterEmail.sendKeys(Email);
}

public void SetPassword(String password) {
	enterPassword.sendKeys(password);
}

public void Login() {
	btnLogin.click();
}

}
