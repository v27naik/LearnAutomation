package learnAuto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Library.Utility;

public class LearnObjectRep 
{
	@BeforeTest
	public void PreCondition()
	{
		Utility.BasicSteps();
	}
	
  @Test
  public void objectRep() throws IOException 
  {
	  //Utility.options.setHeadless(true);
	  
	  //File src=new File(".Object_Repo.properties");
	  
	  FileInputStream src = new FileInputStream(System.getProperty("user.dir")+"\\Object_Repo.properties");
	  
	 // FileInputStream fis=new FileInputStream(src);
	  
	  Properties pro=new Properties();
	  pro.load(src);
	  
	  System.out.println("Property class loaded");
	  System.out.println("Property class loaded");
	  Utility.driver.get("http://www.newtours.demoaut.com/");
		  Utility.driver.findElement(By.xpath(pro.getProperty("txtusername"))).sendKeys("tutorial1");
	  
	  Utility.driver.findElement(By.xpath(pro.getProperty("txtpassword"))).sendKeys("tutorial1");
	  Utility.driver.findElement(By.xpath(pro.getProperty("btnlogin"))).click();;
  }
}
