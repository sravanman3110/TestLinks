package CaptureObjects.ObjectList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetObjectsTest {
	@Test
	void Objtest() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "/Users/e5110612/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		FindElementsBypage elementobj = new FindElementsBypage();
		
	/*	File Bfile = new File("");
		String filePath  = Bfile.getAbsolutePath()+"/TestData";
        String fileName = "TestData.xlsx";
        String sheetName = "URLSheet";
        File file =    new File(filePath+"/"+fileName);
      

        FileInputStream inputStream = new FileInputStream(file);
        Workbook URLWorkbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if(fileExtensionName.equals(".xlsx")) {                    
                         URLWorkbook = new XSSFWorkbook(inputStream); 
                                    }
        else if(fileExtensionName.equals(".xls")){
            URLWorkbook = new HSSFWorkbook(inputStream);
        }
       
        Sheet URLSheet = URLWorkbook.getSheet(sheetName);
        int rowCount = URLSheet.getLastRowNum()-URLSheet.getFirstRowNum();
   //rowCount+1     
    /*    for (int i = 1 ; i < 100; i++) 
        {
	        	Row row = URLSheet.getRow(i);
		    	DataFormatter formatter = new DataFormatter();
		    	String TestURL = "https://"+formatter.formatCellValue(row.getCell(3));
		    	String BaseURL = "https://"+formatter.formatCellValue(row.getCell(2));
	    	try { */
	    		 driver.get("https://www.vu.edu.au");  // BaselineURL = 2 & TestURL = 3
	    		 elementobj.findelements(driver);
	    		 
	  /*  	}
	    	catch(Exception e) {
	    		
		    		driver.navigate().refresh();
		    		
		    		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
	    	}
	    	finally {
	    		// String ScrName =  driver.getTitle();
	    	} 
}*/
	    		 driver.quit();
	}

}
