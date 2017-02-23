package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	XSSFWorkbook workbook;
	
	public String getvalue(int sheetnum, int rownum, int columnnum)
	{
		String value = null;
		value = workbook.getSheetAt(sheetnum).getRow(rownum).getCell(columnnum).toString();
		
		return value;
	}
	
	public DataReader(String xslname) throws IOException
	{
		
		File Excelfile = new File(xslname);	
		FileInputStream FIS = new FileInputStream(Excelfile);
		workbook = new XSSFWorkbook(FIS);
	}
	
	public int getTotalRows(int sheetnum, int headerRowCount)
	{
		int totalRows;
		totalRows = (workbook.getSheetAt(sheetnum).getLastRowNum() - headerRowCount);
		return totalRows;
	}
	
	public int getTotalRows(int sheetnum)
	{
		int totalRows;
		totalRows = workbook.getSheetAt(sheetnum).getLastRowNum();
		return totalRows;
	}
	
	public int getTotalColumns(int sheetnum)
	{
		int totalColumns;
		totalColumns = workbook.getSheetAt(sheetnum).getRow(0).getLastCellNum();
		return totalColumns;
	}
	
	public void closeBook() throws IOException
	{
		workbook.close();
	}

}
