package utils;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider
	public static Object[][] Logininputs(Method m) throws IOException
	
	{
		Object[][] LoginObj=null;
		DataReader ds = new DataReader("./Resources/powexcel.xlsx");
		
		if(m.getName().equals("VerifyAllLogin"))
		{
			int sheetnum = 0;
			
			int rowsize = ds.getTotalRows(sheetnum);
			int colsize = ds.getTotalColumns(sheetnum);
			LoginObj = new Object[rowsize][colsize];
			for(int i=0;i<rowsize; i++)
			{
				for(int j=0;j<colsize;j++)
				{
					LoginObj[i][j] = ds.getvalue(sheetnum, i+1, j);
					
					
				}
			}
			
			return LoginObj;
			
		}
		
		if(m.getName().equals("Login"))
		{
			System.out.println("Reading Dataprovider");
			int sheetnum = 0;
			int rowsize = ds.getTotalRows(sheetnum);
			int colsize = ds.getTotalColumns(sheetnum);
			LoginObj = new Object[rowsize][colsize];
			
			for(int i=0;i<rowsize; i++)
			{
				for(int j=0;j<colsize;j++)
				{
					LoginObj[i][j] = ds.getvalue(sheetnum, i+1, j);
					//System.out.println("Details "+LoginObj[i][j]);
					
				}
			}
		}
		
	

	return LoginObj;
	}

}
