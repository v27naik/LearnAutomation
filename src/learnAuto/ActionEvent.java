package learnAuto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Utility;

public class ActionEvent 
{
	@BeforeTest
	public void PreCondition()
	{
		Utility.BasicSteps();
	}
	
	@Test
	public void MouseHover() throws InterruptedException 
	{
		Utility.driver.get("http://www.google.com/");
		Utility.isElementPresnt(Utility.driver,"//input[contains(@class,'gLFyf gsfi')]", 20).sendKeys("test");
		Actions builder=new Actions(Utility.driver);
		WebElement ele= Utility.isElementPresnt(Utility.driver,"//ul[contains(@class,'erkvQe')]/li[4]", 20);
		builder.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		builder.click(ele).build().perform();
	}
	
	@Test
	public void RightClickElement() 
	{
		Utility.driver.get("http://www.google.com/");
		Actions act=new Actions(Utility.driver);
		act.contextClick(Utility.driver.findElement(By.linkText("YouTube Music"))).perform();
	}
	
	@Test
	public void KeyboardEvent() 
	{
		Utility.driver.get("http://www.google.com/");
		Actions act=new Actions(Utility.driver);
		act.contextClick(Utility.driver.findElement(By.linkText("YouTube Music"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	
	}
	
	@Test
	public void CalendarHandling()
	{
		Utility.driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		Utility.driver.findElement(By.id("datepicker")).click();
		List<WebElement> allDates = Utility.driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele:allDates)
		{
			String date=ele.getText();
			if(date.equalsIgnoreCase("28"))
			{
				ele.click();
				break;
				
			}
		}
	}
	
}
