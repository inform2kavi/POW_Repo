package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	Properties propobj = new Properties();
	
	public ReadProperties() throws IOException
	{
		System.out.println("Loading constructor of ReadProperties");
		FileInputStream FIS = new FileInputStream("./Resources/config.properties");
		propobj.load(FIS);
		
	}
	
	
	public String ReturnPropertyValue(String Key)
	{
		
		return propobj.getProperty(Key);	
			
		
	}
	
	public String ReturnPropertyValue(String Key, int fieldno)
	{
		return propobj.getProperty(Key).split(":")[fieldno];
	}

}
