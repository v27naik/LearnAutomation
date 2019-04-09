package learnAuto;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Library.Utility;

public class ScreenShotWait
{
	
	String myWebPage;
	@BeforeTest
	public void PreCondition()
	{
		Utility.BasicSteps();
	}
  
  @Test
  public void learnPageLoadTimeOut() 
  {
	  Utility.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  try
	  	{
		  myWebPage ="http://www.google.com";
		  Utility.driver.get(myWebPage);
		  Utility.driver.findElement(By.linkText("Gmail"));
		    ScreenShotWait.captureScreenShot();
		    System.out.println("Page : "+myWebPage+ " loaded sucessfully.");
		   
		 } 
		 catch (TimeoutException e) 
		 {
		      System.out.println("Page: " + myWebPage + " did not load within 40 seconds!");
		  }
	  
   	}
  
  @AfterMethod
  public static void captureScreenShot()
  {
	// Take screenshot and store as a file format             
	 //File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           
	 	try 
	 		{
	 			//FileUtils.copyFile(src, new File("C:\\SeleniumPractice\\restLearn\\"+System.currentTimeMillis()+".png"));    
	 		// This code will capture screenshot of current screen		
	 			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	 				    
	 			// This will store screenshot on Specific location
	 			ImageIO.write(image, "png", new File("C:\\SeleniumPractice\\restLearn\\Test_Screenshots\\"+System.currentTimeMillis()+".png")); 
	 		} 
	 	catch (Exception e)
	 	 	{
	 			System.out.println(e.getMessage());
	 	 	} 
	 }
  
  
  
  @Test
 
  public void learnAction()
  	{
	  	Utility.driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		  WebElement drag=Utility.driver.findElement(By.xpath(".//*[@id='draggable']"));
		  WebElement drop=Utility.driver.findElement(By.xpath(".//*[@id='droppable']"));
		  WebElement element=Utility.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='draggable']")));
		  Actions act = new Actions(Utility.driver);
	 	  act.dragAndDrop(drag, drop).build().perform();
   	}

  
  
}
