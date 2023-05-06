package userDefinedLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoad {
	
	public  static Properties readPropertiesFile() 
	{
		
        FileInputStream fis = null;
        
        try {
        	
        	String filePath="./src/main/java/data/Config.properties";
            fis = new FileInputStream(filePath);
            
        } catch (FileNotFoundException e) {
    
        	e.printStackTrace();
        	
        }
        
        Properties prop = new Properties();
        
        try {
        	
            prop.load(fis);
            
        } catch (IOException e) {
        	
        	e.printStackTrace();
        	
        }
        
        return prop;
        
	}
	
}