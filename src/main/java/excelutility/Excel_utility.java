package excelutility;
  

import java.io.FileInputStream;
import java.io.IOException;
  
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
  

 public class Excel_utility {
    
    public void readexcelfile() throws IOException{
              
          FileInputStream file = new FileInputStream("/Users/kiwitech/Documents/Selenium_framwork/Project/excelfile/Automation_Sheet.xlsx");
            HSSFWorkbook wb=new HSSFWorkbook(file);
            HSSFSheet sheet=wb.getSheet("Sheet1");
       
            // Iterate each row one by one
            Iterator<Row> rIterator = sheet.iterator();
            while (rIterator.hasNext()) 
            {
                Row row = rIterator.next();
                  
                  // For each row, iterate through all the columns
                Iterator<Cell> Cell = row.cellIterator();
                   
                while (Cell.hasNext()) 
                {
                    Cell cell = Cell.next();
                      
                      // Check the cell type
                    switch(cell.getCellType())
                    {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                          
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue()); 
                        break;
                          
                    case FORMULA:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    }
                    System.out.print("|");
                }
                System.out.println();              
            }
            wb.close();
            file.close();
    }
}
