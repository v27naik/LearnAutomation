package learnAuto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Utility;

public class UploadDownload 
{
	@BeforeTest
	public void PreCondition()
	{
		Utility.BasicSteps();
	}
	
	/*@Test
	public void UploadFile() throws InterruptedException, AWTException 
	{
		// Specify the file location with extension
		 StringSelection sel = new StringSelection("C:\\SeleniumPractice\\restLearn\\UploadFile1.docx");
		 
		 // Copy to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		 System.out.println("selection : " +sel);
		 
		 Utility.driver.get(""); 
		 Utility.driver.findElement(By.linkText("File Upload")).click();
		 //Scroll down the page
		 JavascriptExecutor js = (JavascriptExecutor)Utility.driver;
		 js.executeScript("scroll(0,150)");
		// Wait for 5 seconds
		 Thread.sleep(3000);
		 Utility.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// This will click on Browse button
		 Utility.driver.findElement(By.id("file-upload")).click();
		 System.out.println("Choose file button clicked");
		 
		// Create object of Robot class
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
		 
		// Release Enter
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 
		// Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
	}*/
	
	@Test
	public void DownloadFile() 
	{
		Utility.driver.get("http://the-internet.herokuapp.com/"); 
		 Utility.driver.findElement(By.linkText("File Download")).click();
		 Utility.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Utility.driver.findElement(By.linkText("some-file.txt")).click();
		  
		// Click on download 
		//Utility.driver.findElement(By.xpath(".//*[@id='program-header']/div[4]/a[1]")).click();
	
	}
}
