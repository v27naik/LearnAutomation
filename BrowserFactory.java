package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory 
{
	public static WebDriver driver;
	public static WebDriver startBrowser(String browser, String siteURL)
	 {
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");
	 options.setHeadless(false);
	 
	if (browser=="chrome")
		{
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(options);
		}
	
	 driver.get(siteURL);
     
     return driver;
	 	 
	}
 }
