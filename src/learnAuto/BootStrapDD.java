package learnAuto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Utility;

public class BootStrapDD 
{
	@BeforeTest
	public void PreCondition()
	{
		Utility.BasicSteps();
	}
	
	@Test
	public void BootStrap() throws InterruptedException 
	{
		Utility.driver.get("https://www.spicejet.com/");
		WebElement waitL =Utility.driver.findElement(By.linkText("Flights"));
		Utility.wait.until(ExpectedConditions.visibilityOf(waitL));
		Utility.driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		System.out.println("Run.....");
		//Utility.isElementPresnt(driver,".//*[@id='txtSource']", 20);
		List<WebElement> list = Utility.driver.findElements(By.xpath("//div[contains(@class,'dropdownDiv')]/ul/li/a"));
			for (WebElement ele : list)
			    {
			 		System.out.println("Values " + ele.getAttribute("innerHTML"));
			 		if (ele.getAttribute("innerHTML").contains(" Pune (PNQ)")) 
			 		{
			 			Thread.sleep(3000);
		 				ele.click();
		 				System.out.println("City selected");
		 				break;
			 		}
			    }
	}
	@Test
	public void GetToolTip() throws InterruptedException 
	{
		Utility.driver.get("https://www.redbus.in/");
		Utility.wait.until(ExpectedConditions.elementToBeClickable(By.id("i-icon-profile")));
		System.out.println("wait---------------");
		WebElement getT = Utility.driver.findElement(By.linkText("BUS HIRE"));
		Actions builder=new Actions(Utility.driver);
		builder.moveToElement(getT).perform();
		String tooltip_msg=getT.getAttribute("title");
		System.out.println("Tooltip/ Help message is : "+tooltip_msg);
		Utility.driver.close();
	}
  
}
