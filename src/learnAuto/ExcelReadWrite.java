package learnAuto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReadWrite 
{
  @Test
  public void ExcelRead() 
  {
	  try
	  {
		  File src=new File("C:\\SeleniumPractice\\restLearn\\Test_Data\\ReadWrite.xlsx");
		  FileInputStream fis=new FileInputStream(src);
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet sh1= wb.getSheetAt(0);
		  
		  System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
		  System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
		  System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
		  
	  }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage());
	  }
	  
  }
  
  @Test
  public void ExcelWrite() 
  {
	  try
	  {
		  File src=new File("C:\\SeleniumPractice\\restLearn\\Test_Data\\ReadWrite.xlsx");
		  FileInputStream fis=new FileInputStream(src);
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet sh1= wb.getSheet("Sheet2");
		  
		        /*Row row = sh1.createRow(0);
		        Cell cell = row.createCell(0);
		        cell.setCellValue("Manual");*/
		        sh1.createRow(0).createCell(0).setCellValue("Age");
		  FileOutputStream fout=new FileOutputStream(new File("C:\\SeleniumPractice\\restLearn\\Test_Data\\ReadWrite.xlsx"));
		  wb.write(fout);
		  fout.close();
		  
	  }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage());
	  }
	  
  }
}
