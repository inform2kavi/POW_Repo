package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	Properties propobj = new Properties();
	
	public ReadProperties() throws IOException
	{
		
		FileInputStream FIS = new FileInputStream("./Resources/config.properties");
		propobj.load(FIS);
		
	}
	
	//returns the value of the key
	public String ReturnPropertyValue(String Key)
	{
		
		return propobj.getProperty(Key);	
			
		
	}
	
	//returns the specified index value of the key 
	public String ReturnPropertyValue(String Key, int fieldno)
	{
		return propobj.getProperty(Key).split(":")[fieldno];
	}

}
