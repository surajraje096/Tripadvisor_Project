package com.amazon.qa.util;
import java.io.BufferedInputStream;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.amazon.qa.base.TestBase;




public class testUtil extends TestBase{
	public static String mailscreenshotpath;
	
	
	public static ExcelReader excel =new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\amazon\\qa\\testdata\\testdata.xlsx");
	public static boolean isExecutable(String tcid){
		String sheetName="test_suite";
		for(int rownum=2;rownum<=excel.getRowCount(sheetName);rownum++){
			if(excel.getCellData(sheetName, "tcid", rownum).equals(tcid)){
				if(excel.getCellData(sheetName, "runmod", rownum).equals("Y")){
					
					return true;
				}
				else{
					return false;
				}
			}
			
		}
		return false;
	}


public static Object[][] getData(String sheetName){
	//String sheetName="LoginTest";
	int rows=excel.getRowCount(sheetName);
	int cols=excel.getColumnCount(sheetName);
	
	System.out.println("row=    "+rows+"    cols=   "+cols);//row=2 ; column=2
	
	Object[][] data=new Object[rows-1][cols];//[1][2]
	
	//row start from Excel sheel 2
	for(int rowNum=2;rowNum<=rows;rowNum++){ //2
		
		
		for(int colNum=0;colNum<cols;colNum++){ //0,1-2 times  (eg.colNum=1;colNum<=cols;colNum++)
			
			data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);//1,2
			
		}
	}
	return data; 
	
	
}


	
	
	
	
	//public static WebDriver driver;
public static void captureScreenshot(String methodName) throws IOException{
		
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.HOUR_OF_DAY);
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+methodName+"_"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
		FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
}


	
	

	
	/*
    try {
    	
    	mailscreenshotpath = methodName+"_"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
    	
    	FileUtils.copyFile(scrFile, new File("C:\\11_Jan_2020Batch\\TestNG_ListenersOnFailure\\Screenshot "+mailscreenshotpath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	*/
	
public static void zip(String filepath){
 	try
 	{
 		File inFolder=new File(filepath);
 		File outFolder=new File("Reports.zip");
 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
 		BufferedInputStream in = null;
 		byte[] data  = new byte[1000];
 		String files[] = inFolder.list();
 		for (int i=0; i<files.length; i++)
 		{
 			in = new BufferedInputStream(new FileInputStream
 			(inFolder.getPath() + "/" + files[i]), 1000);  
 			out.putNextEntry(new ZipEntry(files[i])); 
 			int count;
 			while((count = in.read(data,0,1000)) != -1)
 			{
 				out.write(data, 0, count);
 			}
 			out.closeEntry();
}
 		  out.flush();
 		  out.close();
 			 	
 		}
 		  catch(Exception e)
 		  {
 			  e.printStackTrace();
 		  } 
 		 }

}
	
