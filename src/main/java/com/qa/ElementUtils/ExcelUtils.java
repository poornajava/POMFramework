package com.qa.ElementUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.omg.CORBA.DATA_CONVERSION;

public class ExcelUtils {

	public static String sheetPath="C:\\Users\\Poorna\\eclipse-workspace\\Framework\\src\\main\\java\\com\\qa\\testData\\DataSheet.xlsx";
	static 	Workbook wb	;

	public static Object[][] excelUtils(String sheetName)
	{
		
		System.out.println("here");
	try {
		FileInputStream fp= new FileInputStream(sheetPath);
		try {
		 wb	=	WorkbookFactory.create(fp);
				
		
				
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
	
		e.printStackTrace();
	}
	org.apache.poi.ss.usermodel.Sheet sh	=  wb.getSheet(sheetName);

	Object data[][]= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0;i<sh.getLastRowNum();i++)
	{
		for(int k=0;k<sh.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sh.getRow(i+1).getCell(k).toString();
			System.out.println(data[i][k]);
			
		}
		
		System.out.println(data);
		
		
		
	}
	return data;
	
	

		
	}

}
