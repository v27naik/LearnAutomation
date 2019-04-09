package learnAuto;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.Utility;

public class BrokenLink 
{
	@BeforeTest
	public void PreCondition()
	{
		Utility.BasicSteps();
	}
	
  @Test
  public void verifyLink() 
  {
	  //Utility.options.setHeadless(true);
	  Utility.driver.get("http://www.newtours.demoaut.com/");
		List<WebElement> links=Utility.driver.findElements(By.tagName("a"));
		System.out.println("Total links are "+links.size());
		for(int i=0;i<links.size();i++)
		{
			WebElement ele= links.get(i);
			String url=ele.getAttribute("href");
			BrokenLink.verifyLinkActive(url);
		}
  }
  
  @Test
  public static void verifyLinkActive(String linkUrl) 
  {
	  try 
      {
         URL url = new URL(linkUrl);
         HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
         httpURLConnect.setConnectTimeout(3000);
         httpURLConnect.connect();
        if(httpURLConnect.getResponseCode()==200)
         {
             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
          }
        if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
         {
             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
          }
      } catch (Exception e) 
	  {
    	  e.printStackTrace(); 
      }
  }
}
