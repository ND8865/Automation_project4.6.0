package excelutility;

import java.io.FileInputStream;



import java.io.IOException;
  
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtility_Code 
{
	static String path = "/Users/kiwitech/Documents/Selenium_framwork/Project/excelfile/Automation_Sheet.xlsx";
	
	public static String getdata(int rownum,int colnum)
	{   
		String data="";
		try 
		{

			FileInputStream fis = new 	FileInputStream(path);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheetAt(0);
			data = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
       

		} 
		catch (Exception e) 
		{
			System.out.println("Issue in the getdata"+e);
		}

		return data;
	}

	public static int getrowcount()
	  {
		  int rownum=0;
		  try 
		  {
			  FileInputStream fis = new FileInputStream(path);
			  HSSFWorkbook wb = new HSSFWorkbook(fis);
			  HSSFSheet sheet = wb.getSheetAt(0);
		       rownum= sheet.getLastRowNum();
			
		} 
		  catch (Exception e)
	      {
			System.out.println("issue in getrowcount "+e);
			//e.printStackTrace();
		  }
		return rownum;
	  }
	
	
}
	


	


