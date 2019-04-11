package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pom.BrowserFactory;

public class VerifyLogin 
{
  @Test
  public void validUser() 
  {
	  
	// This will launch browser and specific url 
	WebDriver driver= BrowserFactory.startBrowser("chrome","http://www.newtours.demoaut.com/");
	 
	// Created Page Object using Page Factory
	LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	login_page.login_newT("tutorial1", "tutorial1");
  }
}
