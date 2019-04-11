package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
	this.driver=driver;
	}
	
	@FindBy(xpath="//input[contains(@name,'userName')]") @CacheLookup WebElement username; 
	
	@FindBy(xpath="//input[contains(@name,'password')]") @CacheLookup WebElement password;
	
	@FindBy(xpath="//input[contains(@name,'login')]") @CacheLookup WebElement btnlogin;

	public void login_newT(String uid,String pass)
	{
	username.sendKeys(uid);
	password.sendKeys(pass);
	btnlogin.click();
	}
}
