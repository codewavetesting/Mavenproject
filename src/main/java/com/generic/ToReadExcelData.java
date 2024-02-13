package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToReadExcelData  {
	public static String sTestDataFile = "";

	 public static String[] toReadExcelData(String sSheet , String sTestCaseID) throws EncryptedDocumentException, InvalidFormatException, IOException, IOException, InvalidFormatException {
	        String[] sData = null;
	        FileInputStream fis = new FileInputStream(sTestDataFile);
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sht = wb.getSheet(sSheet);
	        int rowNum = sht.getLastRowNum();
	        for (int i = 1; i<=rowNum ; i++)
	        {
	            if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
	            {
	                int cellNum = sht.getRow(i).getLastCellNum();
	                sData = new String[cellNum-1];
	                for(int j = 1; j<cellNum ; j++)
	                {
	                    sData[j-1] = sht.getRow(i).getCell(j).getStringCellValue();
	                }
	                break;
	            }
	        }
	        return sData;
	    }
}
