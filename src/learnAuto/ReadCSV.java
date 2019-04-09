package learnAuto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCSV 
{
  @Test
  public void ReadCsvFiles() throws IOException 
  {
	  CSVReader reader = new CSVReader(new FileReader("C:\\SeleniumPractice\\restLearn\\Test_Data\\ReadCSV.csv"));
	  List<String[]> li=reader.readAll();
	  System.out.println("Total rows which we have is "+li.size());
	  Iterator<String[]>i1= li.iterator();
	  while(i1.hasNext())
	  {
		  String[] str=i1.next();
		  System.out.print(" Values are ");
		  for(int i=0;i<str.length;i++)
		  	{
			  System.out.print(" "+str[i]);
		  	}
		  System.out.println("   ");
	 }
  }
}
