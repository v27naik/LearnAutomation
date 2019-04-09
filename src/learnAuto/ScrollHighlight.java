package learnAuto;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Utility;

public class ScrollHighlight 
{
	@BeforeTest
	public void PreCondition()
	{
		Utility.BasicSteps();
	}
	
	@Test
	public void HighlightElement()
	{
		Utility.driver.get("http://www.newtours.demoaut.com/");
		JavascriptExecutor js=(JavascriptExecutor)Utility.driver;
		WebElement username = Utility.isElementPresnt(Utility.driver,"//input[contains(@name,'userName')]", 20);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px red');", username);
		//js.executeScript("arguments[0].setAttribute('disable','');",username);
	}
	
	@Test
	public void ScrollView() throws InterruptedException 
	{
		Utility.driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		JavascriptExecutor js=(JavascriptExecutor)Utility.driver;
		WebElement element = Utility.driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		System.out.println(element.getText());
	}
	
	@AfterMethod
	  public static void captureScreenShot()
	  {        
		 	try 
		 		{
		 			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		 			ImageIO.write(image, "png", new File("C:\\SeleniumPractice\\restLearn\\Test_Screenshots\\"+System.currentTimeMillis()+".png")); 
		 		} 
		 	catch (Exception e)
		 	 	{
		 			System.out.println(e.getMessage());
		 	 	} 
		 }
	  
}
