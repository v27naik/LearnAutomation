package learnAuto;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport1 
{
    @Test
    public void verifySeleniumBlog()
    {
    	ExtentReports extent = ExtentReports.get(ExtentReport1.class);
    	extent.init("C:\\SeleniumPractice\\restLearn\\Test_Report\\ExtentReport1.html", true);
    	extent.startTest("Verify Page Title");
    	 System.setProperty("webdriver.chrome.driver","C:\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	extent.log(LogStatus.INFO, "Browser started");
    	driver.get("http://learn-automation.com");
    	extent.log(LogStatus.INFO, "Navigated to www.learn-automation.com");
    	String title=driver.getTitle();
    	extent.log(LogStatus.INFO, "Get the current title");
    	Assert.assertTrue(title.contains("Selenium"));
    	extent.log(LogStatus.PASS, "Title verified");
    	extent.attachScreenshot("C:\\Mukesh\\image1.jpg");
    	driver.quit();
    	extent.log(LogStatus.INFO, "Browser closed");
    	extent.endTest();

    }
    
}
