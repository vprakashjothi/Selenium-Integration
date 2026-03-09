package utils;
import java.util.Properties;
import java.io.*;

public class ConfigReader {
Properties properties;

public ConfigReader() {
	try {
		FileInputStream file=new FileInputStream("src/test/resources/config.propertie");
		properties = new Properties();
		properties.load(file);
		
	}
	catch (Exception e){
		e.printStackTrace();
	}
}

public String Property(String key) {
	return properties.getProperty(key);
	
}


}
