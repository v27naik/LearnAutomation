package learnAuto;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Library.Utility;

public class ExtentReport2 
{
ExtentReports report;
ExtentTest logger; 
WebDriver driver;
 
	@Test
	public void verifyBlogTitle()
	{
		report = ExtentReports.get(ExtentReport2.class);
		report.init("C:\\SeleniumPractice\\restLearn\\Test_Report\\ExtentReport2.html", true);
		 System.setProperty("webdriver.chrome.driver","C:\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
 		driver=new ChromeDriver();
 		driver.manage().window().maximize();
 		//logger = report.startTest("testName"); 
 		driver.get("http://www.learn-automation.com");
 		logger.log(LogStatus.INFO, "Application is up and running");
 		String title=driver.getTitle();
 		Assert.assertTrue(title.contains("Google")); 
 		logger.log(LogStatus.PASS, "Title verified");
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshot_path=Utility.captureScreenShot(driver, result.getName());	
			String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);
		}
	
		report.endTest();
		driver.get("C:\\SeleniumPractice\\restLearn\\Test_Report\\ExtentReport2.html");
	}
}
