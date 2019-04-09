package Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Utility 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
		

	
	public static void BasicSteps()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.setHeadless(false);
        System.setProperty("webdriver.chrome.driver","C:\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
	  	driver = new ChromeDriver(options);
		driver.manage().window().maximize();
				wait=new WebDriverWait(driver,20);
		


	}
	
	public static WebElement isElementPresnt(WebDriver driver,String xpath,int time)
	{
		WebElement ele = null;
			for(int i=0;i<time;i++)
				{
					try	
					{
						ele=driver.findElement(By.xpath(xpath));
						break;
					}
					catch(Exception e)
					{
						try 
						{
							Thread.sleep(1000);
						} catch (InterruptedException e1) 
						{
							System.out.println("Waiting for element to appear on DOM");
						}
					}
	 }
	return ele;
	}
	
	//Handle alert
	public static void handleAlert(WebDriver ldriver)
	{
		if(isAlertPresent(ldriver))
		{
			Alert alert = ldriver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}
	
	//verify alert is present or not
	public static boolean isAlertPresent(WebDriver ldriver)
	{
		try
		{
			ldriver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException ex)
		{
			return false;
		}
	}
	
	//HighLight Element 
	public static void highLightElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	try 
		{
			Thread.sleep(500);
		} 
	catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());
		} 
	 js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	}

	public static void ProxySetting()
	{
	  Proxy p=new Proxy();
	  p.setHttpProxy("localhost:7777");
	  DesiredCapabilities cap=new DesiredCapabilities();
	  cap.setCapability(CapabilityType.PROXY, p);
	  driver=new ChromeDriver(cap);
	 }
	

	public static String captureScreenShot(WebDriver driver, String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\SeleniumPractice\\restLearn\\Test_Screenshots\\"+System.currentTimeMillis()+".png"));
		return result;
	}
	
	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
}
